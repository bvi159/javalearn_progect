package com.javarush.examples.Hello_World_2708;

import java.util.concurrent.TimeUnit;

public class HelloWorldApp {
    public static void main(String []args) throws InterruptedException {
        Runnable task = () -> {
            try {
                TimeUnit.SECONDS.sleep(500);
            } catch (InterruptedException e) {
                System.out.println("Interrupted");
            }
        };
        Thread thread = new Thread(task);
        thread.start();
        thread.join();
        System.out.println("Finished");
    }
}
