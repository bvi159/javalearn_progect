package com.javarush.task.task25.task2508;

public class TaskManipulator implements Runnable, CustomThreadManipulator {
    private Thread thread;
    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            System.out.println(Thread.currentThread().getName());
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                // Восстанавливаем статус прерывания и выходим из цикла
                Thread.currentThread().interrupt();
                break;
            }
        }
//            System.out.println(thread.getName());
//            try {
//                thread.sleep(100);
//
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }

    }

    @Override
    public void start(String threadName) {
        thread = new Thread(this, threadName);
//        thread.setName(threadName);
        thread.start();
    }

    @Override

    public void stop() {
//        if (thread != null) {
            thread.interrupt();
//        }
    }
}
