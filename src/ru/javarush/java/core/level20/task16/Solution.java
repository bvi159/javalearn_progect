package ru.javarush.java.core.level20.task16;
/*
Текстовый Конвертер с Удобным Выводом

Вы работаете над утилитой для обработки текста. Ваша основная задача — изменять строки (например, переводить в другой регистр), но вы также хотите, чтобы пользователи могли легко увидеть результат этих изменений без дополнительного кода.
Создайте интерфейс StringTransformer (Преобразователь Строк) с одним абстрактным методом String transform(String s), который принимает строку и возвращает изменённую строку. Обязательно пометьте его аннотацией @FunctionalInterface. Теперь добавьте в этот интерфейс default-метод под названием printTransformed(String s). Этот default-метод должен самостоятельно вызывать transform для переданной строки s и сразу же выводить полученный результат на экран.
В основной части вашей программы создайте лямбда-выражение, которое будет реализовывать StringTransformer и преобразовывать любую строку к нижнему регистру. Затем используйте printTransformed для строки "JAVA ROCKS" и убедитесь, что она корректно выведена в нижнем регистре.

Требования:
•	Интерфейс StringTransformer должен содержать только один абстрактный метод с сигнатурой String transform(String s).
•	Интерфейс StringTransformer должен быть помечен аннотацией @FunctionalInterface.
•	В интерфейсе StringTransformer должен быть определён default-метод с именем printTransformed(String s).
•	Метод printTransformed(String s) должен вызывать метод transform для переданной строки и выводить результат на экран.
•	В основной части программы необходимо создать лямбда-выражение, реализующее интерфейс StringTransformer, которое преобразует строку к нижнему регистру.
•	Лямбда-реализация должна быть использована для вызова метода printTransformed со строкой "JAVA ROCKS".
•	В результате выполнения программы на экран должна быть выведена строка "java rocks".

public class Solution {
    public static void main(String[] args) {
        // Лямбда-реализация: преобразует строку к нижнему регистру


        // Вызываем default-метод для строки "JAVA ROCKS"

    }
}

 */

public class Solution {
    public static void main(String[] args) {
        // Лямбда-реализация: преобразует строку к нижнему регистру
        StringTransformer myString = str -> str.toLowerCase();
        // Вызываем default-метод для строки "JAVA ROCKS"
        myString.printTransformed("JAVA ROCKS");
    }
}

@FunctionalInterface
interface StringTransformer {
    String transform(String s);
    default void printTransformed(String s) {
        System.out.println(transform(s));
    }
}


/*

// Функциональный интерфейс с одним абстрактным методом
@FunctionalInterface
interface StringTransformer {
    String transform(String s);

    // default-метод, который сам вызывает transform и печатает результат
    default void printTransformed(String s) {
        System.out.println(transform(s));
    }
}

public class Solution {
    public static void main(String[] args) {
        // Лямбда-реализация: преобразует строку к нижнему регистру
        StringTransformer toLower = s -> s.toLowerCase();

        // Вызываем default-метод для строки "JAVA ROCKS"
        toLower.printTransformed("JAVA ROCKS"); // ожидаемый вывод: "java rocks"
    }
}

 */