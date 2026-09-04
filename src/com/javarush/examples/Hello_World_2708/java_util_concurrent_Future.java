package com.javarush.examples.Hello_World_2708;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class java_util_concurrent_Future {
    public static void main(String []args) throws Exception {
        Callable task = () -> {
            return "Hello, World!";
        };
        FutureTask<String> future = new FutureTask<>(task);
        new Thread(future).start();
        System.out.println(future.get());
    }
}
