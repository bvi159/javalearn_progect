package com.javarush.task.task26.task2612;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* 
Весь мир играет комедию
Почитать про java.util.concurrent.locks.Lock на http://docs.oracle.com/ (там все есть в джавадоках!)
Написать реализацию метода someMethod():
1. попытаться захватить лок
1.1. если лок занят, то вызвать метод actionIfLockIsBusy()
1.2. если лок свободен, то:
1.2.1 вызвать метод actionIfLockIsFree()
1.2.2 отпустить лок при любых условиях, даже если actionIfLockIsFree() будет кидать исключение

Требования:
•	Класс Solution должен содержать приватное поле Lock lock.
•	Класс Solution должен содержать публичный метод actionIfLockIsFree().
•	Класс Solution должен содержать публичный метод actionIfLockIsBusy().
•	Метод someMethod() должен пытаться захватить лок.

public class Solution {
    private Lock lock = new ReentrantLock();

    public void someMethod() {
        if (lock.tryLock()) {
            try {
                actionIfLockIsFree();
            } finally {
                lock.unlock();
            }
        } else {
            actionIfLockIsBusy();
        }
    }

    public void actionIfLockIsFree() {
    }
S
    public void actionIfLockIsBusy() {
    }
}
Ну у них чуть покрасивее, согласен

*/

public class Solution {
    private Lock lock = new ReentrantLock();

    public void someMethod() {
        // Implement the logic here. Use the lock field
        try {
            if (!lock.tryLock()) {
                actionIfLockIsBusy();
            } else {
                actionIfLockIsFree();
                lock.unlock();
            }

        } catch (Exception e) {
            lock.unlock();
            throw new RuntimeException(e);
        }
//        finally {
//            lock.unlock();
//        }
    }

    public void actionIfLockIsFree() {
        System.out.println("I'm Free!");
    }

    public void actionIfLockIsBusy() {
        System.out.println("I'm Busy!");
    }

    public static void main(String[] args) {
        Solution mySolution = new Solution();
        mySolution.someMethod();
    }

}

/*
public class Solution {
    protected Lock lock = new ReentrantLock();

    public void someMethod() {
        // Implement the logic here. Use the lock field
    }

    public void actionIfLockIsFree() {
    }

    public void actionIfLockIsBusy() {
    }
}
 */