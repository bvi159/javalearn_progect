package com.javarush.task.task32.task3209;

public class ExceptionHandler {
    // 5.2. Статический метод для логирования исключений
    public static void log(Exception e) {
        // Выводим краткое описание проблемы
//        System.out.println("Exception: " + e.toString());
        System.out.println(e.toString());
    }
}
