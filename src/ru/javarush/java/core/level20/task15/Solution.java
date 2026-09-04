package ru.javarush.java.core.level20.task15;
/*
Валидатор Текста: Проверка Длины Строки

Вы создаёте модуль для валидации пользовательского ввода, и одна из стандартных проверок — это длина введённого текста. Java предоставляет для таких задач готовые, удобные инструменты.
В основной части вашей программы объявите переменную типа Predicate<String> (это стандартный функциональный интерфейс из пакета java.util.function). Присвойте этой переменной лямбда-выражение, которое будет проверять, является ли строка "длинной": оно должно возвращать true, если длина строки больше 5 символов.
Продемонстрируйте работу вашего Predicate для двух примеров: строки "Java" (которая должна быть "недостаточно длинной") и строки "FunctionalInterface" (которая должна быть "длинной"), выведите результаты этих проверок на экран.

Требования:
•	В программе должен быть импортирован интерфейс Predicate из пакета java.util.function.
•	В основной части программы должна быть объявлена переменная типа Predicate<String>.
•	В переменную Predicate<String> должно быть присвоено лямбда-выражение, которое возвращает true, если длина строки больше 5 символов.
•	Predicate должен быть применён к строке "Java", и результат проверки (false) должен быть выведен на экран.
•	Predicate должен быть применён к строке "FunctionalInterface", и результат проверки (true) должен быть выведен на экран.

public class Solution {
    public static void main(String[] args) {
        // Предикат проверяет, что длина строки больше 5 символов


        // Демонстрация работы на двух примерах

    }
}


 */


import java.util.function.Predicate;

public class Solution {
    public static void main(String[] args) {
        // Предикат проверяет, что длина строки больше 5 символов
        Predicate<String> myStringIsLong = str -> str.length() > 5;

        // Демонстрация работы на двух примерах
        System.out.println(myStringIsLong.test("Java"));
        System.out.println(myStringIsLong.test("FunctionalInterface"));

    }
}

/*

public class Solution {
    public static void main(String[] args) {
        // Предикат проверяет, что длина строки больше 5 символов
        Predicate<String> isLongText = s -> s.length() > 5;

        // Демонстрация работы на двух примерах
        System.out.println(isLongText.test("Java"));                 // false
        System.out.println(isLongText.test("FunctionalInterface"));  // true
    }
}

 */