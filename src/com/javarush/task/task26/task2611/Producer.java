package com.javarush.task.task26.task2611;

import java.util.concurrent.ConcurrentHashMap;

import static java.lang.String.valueOf;

public class Producer implements Runnable{
    private ConcurrentHashMap<String, String> map;


    public Producer(ConcurrentHashMap<String, String> map) {
        this.map = map;
    }

    @Override
    public void run() {
        try {
            int i = 1;
            String value; // = "Some text for " + i++;
            String counter; // = valueOf(i);
            while (true) {
                i++;
                value = "Some text for " + i;
                counter = valueOf(i);
                map.put(counter, value);
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            System.out.println(String.format("[%s] thread was terminated", Thread.currentThread().getName()));
        }

        System.out.println("Добавляю ключ и значение каждые полсекунды!");
    }
}
