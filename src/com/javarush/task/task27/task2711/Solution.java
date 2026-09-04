package com.javarush.task.task27.task2711;

import java.util.concurrent.CountDownLatch;

/* 
CountDownLatch
Дана стандартная реализация методологии wait-notify.
Почитай про CountDownLatch и перепиши тело метода someMethod используя поле latch.
Весь лишний код удали из класса.

Требования:
•	Из класса Solution должно быть удалено поле lock.
•	Из метода someMethod должен быть удален synchronized блок.
•	В методе someMethod должен быть вызван метод await без параметров у объекта сохраненного в поле latch.
•	В методе someMethod должен быть вызван метод retrieveValue.
•	В методе someMethod должен быть вызван метод countDown у объекта сохраненного в поле latch.

*/

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class Solution {
    private final CountDownLatch latch = new CountDownLatch(1);

    public void someMethod() throws InterruptedException {
        // Ожидаем, если нужно (например, для синхронизации с другим потоком)
        // latch.await(); // Если нужно ждать перед выполнением

        retrieveValue();

        // Уменьшаем счётчик после выполнения
        latch.countDown();
    }

    void retrieveValue() {
        System.out.println("Value retrieved.");
    }

    // Метод для ожидания завершения someMethod()
    public void waitForCompletion() throws InterruptedException {
        latch.await();
    }

    public static void main(String[] args) throws InterruptedException {
        Solution solution = new Solution();

        // Пример: один поток выполняет someMethod(), другой ждёт завершения
        Thread workerThread = new Thread(() -> {
            try {
                solution.someMethod(); // Выполняет и вызывает countDown()
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread waitingThread = new Thread(() -> {
            try {
                solution.waitForCompletion(); // Ждёт завершения someMethod()
                System.out.println("someMethod() завершился!");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        waitingThread.start();
        workerThread.start();

        waitingThread.join();
        workerThread.join();

        /// ///////////////////////////////

        Object lock = new Object();

        Runnable task = () -> {
            synchronized (lock) {
                System.out.println("thread");
            }
        };

        Thread th1 = new Thread(task);
        th1.start();
        synchronized (lock) {
            for (int i = 0; i < 8; i++) {
                Thread.currentThread().sleep(1000);
                System.out.print("  " + i);
            }
            System.out.println(" ...");
        }
    }


}


/*
public class Solution {
    private final Object lock = new Object();
    private volatile boolean isWaitingForValue = true;

    CountDownLatch latch = new CountDownLatch(1);

    public void someMethod() throws InterruptedException {
        synchronized (lock) {
            while (isWaitingForValue) {
                lock.wait();
            }

            retrieveValue();

            isWaitingForValue = false;
            lock.notify();
        }
    }

    void retrieveValue() {
        System.out.println("Value retrieved.");
    }

    public static void main(String[] args) {

    }
}

 */