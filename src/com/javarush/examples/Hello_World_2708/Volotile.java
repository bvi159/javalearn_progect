package com.javarush.examples.Hello_World_2708;

// Если убрать volatile у flag - повиснет
public class Volotile {
    public static volatile boolean flag = false;

    public static void main(String[] args) throws InterruptedException {
        Runnable whileFlagFalse = () -> {
            while(!flag) {
            }
            System.out.println("Flag is now TRUE");
        };

        new Thread(whileFlagFalse).start();
        Thread.sleep(1000);
        flag = true;
    }
}
