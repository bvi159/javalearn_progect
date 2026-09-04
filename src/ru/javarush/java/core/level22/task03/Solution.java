package ru.javarush.java.core.level22.task03;
/*
Проверка идентичности городов на карте 🗺️

Представьте, что вы разрабатываете приложение для каталогизации городов мира, и вам важно удостовериться, что два объекта, представляющие один и тот же город, считаются идентичными, даже если они были созданы независимо.
Создайте класс-запись, который будет описывать город, включая его название и численность населения.
Затем, в основной программе, создайте два экземпляра города с абсолютно одинаковыми названиями и численностью населения.
Ваша цель — используя встроенные механизмы сравнения, проверить, являются ли эти два объекта города равными, и вывести результат этой проверки на экран.

Требования:
•	Необходимо создать record-класс с названием City, который содержит как минимум два компонента: название города (String) и численность населения (int).
•	Класс City должен быть объявлен с использованием ключевого слова record, а не как обычный класс.
•	В основной программе требуется создать два объекта City с одинаковыми значениями полей (название и численность населения).
•	Для проверки идентичности необходимо использовать метод equals, который автоматически реализован в record-классах.
•	Результат сравнения (true или false) должен быть выведен на экран с помощью System.out.println.

public class Solution {
    public static void main(String[] args) {
        // Создаем два объекта City с абсолютно одинаковыми значениями
        City city1 = new City("Paris", 2148327);
        City city2 = new City("Paris", 2148327);

        // В record equals автоматически сгенерирован и сравнивает компоненты по значению
        boolean areEqual = city1.equals(city2);

        // Выводим результат сравнения: true или false
        System.out.println(areEqual);
    }
}

 */
public class Solution {
    public static void main(String[] args) {
        // Создаем два объекта City с абсолютно одинаковыми значениями
        City city1 = new City("Paris", 2148327);
        City city2 = new City("Paris", 2148327);

        // В record equals автоматически сгенерирован и сравнивает компоненты по значению
        boolean areEqual = city1.equals(city2);

        boolean hashEqual = city1.hashCode() == city2.hashCode();

        // Выводим результат сравнения: true или false
        System.out.println(areEqual);
        System.out.println(hashEqual);
        System.out.println(city1.hashCode());
    }
}

record City(String name, int population) {

}

/*

public class Solution {
    public static void main(String[] args) {
        // Создаем два объекта City с абсолютно одинаковыми значениями
        City city1 = new City("Paris", 2148327);
        City city2 = new City("Paris", 2148327);

        // В record equals автоматически сгенерирован и сравнивает компоненты по значению
        boolean areEqual = city1.equals(city2);

        // Выводим результат сравнения: true или false
        System.out.println(areEqual);
    }
}

// Record-класс, описывающий город: название и численность населения
record City(String name, int population) { }

 */