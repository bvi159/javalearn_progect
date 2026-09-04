package com.javarush.task.task25.task2506;

class Clock implements Runnable
{
    public void run()
    {
        Thread current = Thread.currentThread();

        while (!current.isInterrupted())
        {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Tik");
        }
    }
}
