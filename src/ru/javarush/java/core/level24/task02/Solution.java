package ru.javarush.java.core.level24.task02;
/*
Кто главный? Различие между исключениями и ошибками

Вы — главный архитектор безопасности важной системы, и перед вами стоит задача классифицировать различные "инциденты", которые могут произойти. Некоторые из них — это просто "непредвиденные ситуации", которые можно исправить, а другие — это настоящие "катастрофы", которые указывают на серьёзные проблемы с самой системой.
Создайте две переменные. Одну назовите generalSystemIssue, и пусть она будет представлять собой общее исключение (Exception), которое можно обработать. Вторую переменную назовите catastrophicFailure, и пусть она будет представлять собой ошибку (Error), указывающую на нечто более фатальное, например, когда виртуальная машина "сдаётся".
Ваша цель — выяснить, являются ли они обе частью общего семейства "проблем", которые могут быть "выброшены" (Throwable). Для каждой переменной выведите на экран результат проверки: является ли она наследником класса Throwable. Это поможет вам понять, насколько серьёзны эти "инциденты" и как к ним относиться.

Требования:
•	В программе должна быть объявлена переменная generalSystemIssue, которая является экземпляром класса Exception.
•	В программе должна быть объявлена переменная catastrophicFailure, которая является экземпляром класса Error.
•	Для обеих переменных (generalSystemIssue и catastrophicFailure) должна быть выполнена проверка, является ли их класс наследником класса Throwable.
•	Результат проверки для каждой переменной (generalSystemIssue и catastrophicFailure) должен быть выведен на экран.

public class Solution {
    public static void main(String[] args) {
        // Общее исключение, которое можно обработать


        // Фатальная ошибка, указывающая на проблему уровня JVM


        // Проверяем на уровне классов: является ли класс переменной наследником Throwable


        // Выводим результат проверки для каждой переменной

    }
}

 */
public class Solution {
    public static void main(String[] args) {
        // Общее исключение, которое можно обработать
        Exception generalSystemIssue = new Exception("Общее исключение");

        // Фатальная ошибка, указывающая на проблему уровня JVM
        Error catastrophicFailure = new Error("Катастрофическое исключение");


        // Проверяем на уровне классов: является ли класс переменной наследником Throwable
        //boolean isExtentionOfExeption = generalSystemIssue.getClass().isAssignableFrom(Throwable.class);
        boolean isExtentionOfExeption = Throwable.class.isInstance(generalSystemIssue);
        boolean isExtentionofError = Throwable.class.isInstance(catastrophicFailure);

        // Выводим результат проверки для каждой переменной
        System.out.println(isExtentionOfExeption);
        System.out.println(isExtentionofError);

    }
}
/*

public class Solution {
    public static void main(String[] args) {
        // Общее исключение, которое можно обработать
        Exception generalSystemIssue = new Exception("Общее исключение");

        // Фатальная ошибка, указывающая на проблему уровня JVM
        Error catastrophicFailure = new Error("Катастрофическая ошибка");

        // Проверяем на уровне классов: является ли класс переменной наследником Throwable
        boolean generalIsThrowable = Throwable.class.isAssignableFrom(generalSystemIssue.getClass());
        boolean catastrophicIsThrowable = Throwable.class.isAssignableFrom(catastrophicFailure.getClass());

        // Выводим результат проверки для каждой переменной
        System.out.println(generalIsThrowable);
        System.out.println(catastrophicIsThrowable);
    }
}


 */