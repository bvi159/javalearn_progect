package ru.javarush.java.core.level21.task13;

/*
Проверка обязательных полей формы 📄

Представьте, что вы разрабатываете веб-форму регистрации, и вам нужно быстро проверять, не оставил ли пользователь какое-либо поле пустым. Эта проверка должна быть доступна из любого места вашего кода, не требуя создания экземпляров чего-либо.

Создайте интерфейс StringChecker. Внутри этого интерфейса определите static-метод isEmpty, который будет принимать строку в качестве аргумента. Этот метод должен возвращать true, если строка пуста (или null), и false в противном случае.

В основной части программы, без создания каких-либо объектов, вызовите StringChecker.isEmpty("") и StringChecker.isEmpty("Java") и выведите результаты на экран, чтобы увидеть, как работает ваша проверка.

Требования:
•	В программе должен быть объявлен интерфейс с именем StringChecker.
•	Внутри интерфейса StringChecker должен быть определён static-метод с именем isEmpty.
•	Метод isEmpty должен принимать один параметр типа String и возвращать значение типа boolean.
•	Метод isEmpty должен возвращать true, если переданная строка равна null или пуста (имеет длину 0), и false в противном случае.
•	В основной части программы метод StringChecker.isEmpty должен вызываться напрямую, без создания экземпляров каких-либо классов или интерфейсов.
•	Необходимо вызвать StringChecker.isEmpty("") и StringChecker.isEmpty("Java") и вывести результаты этих вызовов на экран.

public class Solution {
    public static void main(String[] args) {
        // Вызываем static-метод напрямую через имя интерфейса — без создания объектов
        System.out.println(StringChecker.isEmpty(""));     // true
        System.out.println(StringChecker.isEmpty("Java")); // false
    }
}

 */

public class Solution {
    public static void main(String[] args) {
        // Вызываем static-метод напрямую через имя интерфейса — без создания объектов
        System.out.println(StringChecker.isEmpty(""));     // true
        System.out.println(StringChecker.isEmpty("Java")); // false
        System.out.println(StringChecker.isEmpty(null));     // true
    }
}

interface StringChecker {
    static boolean isEmpty(String str) {
        return str == null || str.length() == 0;
//        return str.length() == 0 || str == null;
    }
}

/*

// Интерфейс с static-методом проверки строки на пустоту или null
interface StringChecker {
    static boolean isEmpty(String text) {
        // Короткое замыкание: если text == null, text.isEmpty() не будет вызван
        return text == null || text.isEmpty();
    }
}

public class Solution {
    public static void main(String[] args) {
        // Вызываем static-метод напрямую через имя интерфейса — без создания объектов
        System.out.println(StringChecker.isEmpty(""));     // true
        System.out.println(StringChecker.isEmpty("Java")); // false
    }
}

 */