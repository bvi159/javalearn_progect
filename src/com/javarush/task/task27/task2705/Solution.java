package com.javarush.task.task27.task2705;

/* 
Второй вариант deadlock
Расставь модификаторы так, чтобы при работе с этим кодом появился deadlock.
Метод main порождает deadlock, поэтому не участвует в тестировании.

Требования:
•	Поле field должно быть приватным.
•	Метод getField НЕ должен быть приватным.
•	Метод sout должен быть объявлен с модификатором synchronized.
•	Метод sout2 должен быть объявлен с модификатором synchronized.

public class Solution {
    private final Object lock = new Object();

    public synchronized void firstMethod() {
        synchronized (lock) {
            doSomething();
        }
    }

    public void secondMethod() {
        synchronized (lock) {
            synchronized (this) {
                doSomething();
            }
        }
    }

    private void doSomething() {
    }

    public static void main(String[] args) {

    }
}

*/

public class Solution {
    private final Object lock = new Object();

    public synchronized void firstMethod() {
        synchronized (lock) {
            doSomething();
        }
    }

    public void secondMethod() {
        synchronized (lock) {
            synchronized (this) {
                doSomething();
            }
            doSomething();
        }
//        synchronized (this) {
//            doSomething();
//        }
    }

    private void doSomething() {
        System.out.println("I'm doing something!");
    }

    public static void main(String[] args) {
        Solution mySolution = new Solution();
        new Thread(new Runnable() {
            public void run() {
                mySolution.firstMethod();
            }
        }).start();

        new Thread(new Runnable() {
            public void run() {
                mySolution.secondMethod();
            }
        }).start();

    }
}

/*
public class Solution {
    private final Object lock = new Object();

    public synchronized void firstMethod() {
        synchronized (lock) {
            doSomething();
        }
    }

    public void secondMethod() {
        doSomething();
    }

    private void doSomething() {
    }

    public static void main(String[] args) {

    }
}

 */