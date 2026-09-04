package com.javarush.task.task25.task2509;

public class DownloadThread extends Thread {
    @Override
    public void run() {
        int i = 120/0;
        System.out.println("Я Здесь!!!" + i);

    }
}
