package com.javarush.task.task25.task2512;

import java.util.LinkedList;
import java.util.List;

/* 
Живем своим умом

В классе Solution реализуй интерфейс UncaughtExceptionHandler, который должен:
1. прервать нить, которая бросила исключение.
2. вывести в консоль стек исключений, начиная с самого вложенного.

Пример исключения:
new Exception("ABC", new RuntimeException("DEF", new IllegalAccessException("GHI")))

Пример вывода:
java.lang.IllegalAccessException: GHI
java.lang.RuntimeException: DEF
java.lang.Exception: ABC

Требования:
•	Класс Solution должен реализовывать интерфейс Thread.UncaughtExceptionHandler.
•	После вызова uncaughtException нужно прервать нить, которая бросила исключение.
•	Затем, вывести в консоль стек исключений, начиная с самого вложенного исключения.
•	Сообщения должны выводиться в формате "exception class: exception message".

Ихнее решение

public class Solution implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        t.interrupt();

        List<String> res = new LinkedList<>();
        while (e != null) {
            res.add(0, e.toString());
            e = e.getCause();
        }

        for (String s : res) {
            System.out.println(s);
        }
    }

    public static void main(String[] args) {
    }
}


*/

public class Solution implements Thread.UncaughtExceptionHandler {
// Ихнее решение
//    @Override
//    public void uncaughtException(Thread t, Throwable e) {
//        t.interrupt();
//
//        List<String> res = new LinkedList<>();
//        while (e != null) {
//            res.add(0, e.toString());
//            e = e.getCause();
//        }
//
//        for (String s : res) {
//            System.out.println(s);
//        }
//    }
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        // 1. Прерываем нить, которая бросила исключение
        t.interrupt();
        // 2. Выводим стек исключений, начиная с самого вложенного
        printExceptionStack(e);
    }

    private void printExceptionStack(Throwable e) {
        // Если есть причина исключения (вложенное исключение), обрабатываем его сначала
        if (e.getCause() != null) {
            printExceptionStack(e.getCause());
        }
        // Выводим текущее исключение в требуемом формате
        System.out.println(e.getClass().getName() + ": " + e.getMessage());
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Создаем исключение по примеру
        Exception testException = new Exception("ABC",
                new RuntimeException("DEF",
                        new IllegalAccessException("GHI")));

        // Тестируем обработчик
        Thread testThread = new Thread(() -> {
            throw new RuntimeException(testException);
        });

        testThread.setUncaughtExceptionHandler(solution);
        testThread.start();

        try {
            testThread.join();
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }


}
/*
public class Solution implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {
    }

    public static void main(String[] args) {
    }
}
 */