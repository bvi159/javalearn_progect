package ru.javarush.java.core.level16.task19;
/*
Система учета связей: универсальные пары данных 🖇️

Вы разрабатываете систему для работы с парными элементами, где каждый элемент тесно связан со своим напарником. Иногда это могут быть два слова, описывающие что-то, иногда два числа, но принцип их хранения одинаков. Вам нужен гибкий способ создавать такие пары для любых типов данных.
Создайте универсальный класс DataPair<T>. Этот класс должен хранить два поля обобщённого типа T: firstElement и secondElement. Реализуйте конструктор, который принимает два значения типа T для инициализации этих полей. Также создайте методы T getFirst() и T getSecond() для получения доступа к элементам пары.
В главном методе вашей программы (main) создайте объект DataPair, предназначенный для хранения строк, например, DataPair<String>. Передайте в его конструктор строки "Hello" и "World". Затем выведите на экран значения обоих полей, разделённые пробелом, чтобы убедиться в их корректном хранении и извлечении.

Требования:
•	Необходимо создать класс с именем DataPair, использующий дженерик-тип T.
•	Класс DataPair должен содержать два приватных поля типа T: firstElement и secondElement.
•	В классе DataPair должен быть конструктор, принимающий два параметра типа T и инициализирующий соответствующие поля.
•	Класс DataPair должен содержать публичные методы T getFirst() и T getSecond() для получения значений firstElement и secondElement соответственно.
•	В методе main необходимо создать объект DataPair, параметризованный типом String, и передать в конструктор строки "Hello" и "World".
•	В методе main необходимо получить значения обоих элементов через методы getFirst() и getSecond() и вывести их на экран через пробел.

// Универсальная пара данных: класс для хранения двух связанных элементов одного типа
class DataPair {
    // Два приватных поля обобщённого типа T


    // Конструктор принимает два значения и инициализирует поля


    // Возвращаем первый элемент пары


    // Возвращаем второй элемент пары

}

public class Solution {
    public static void main(String[] args) {
        // Создаем объект DataPair для строк и передаем "Hello" и "World"
        DataPair<String> pair = new DataPair<>("Hello", "World");

        // Выводим оба значения через пробел
        System.out.println(pair.getFirst() + " " + pair.getSecond());
    }
}

 */

// Универсальная пара данных: класс для хранения двух связанных элементов одного типа
class DataPair<T> {
    // Два приватных поля обобщённого типа T
    private T firstElement;
    private T secondElement;

    // Конструктор принимает два значения и инициализирует поля
    DataPair(T first, T second){
        firstElement = first;
        secondElement = second;
    }

    // Возвращаем первый элемент пары
    public T getFirst() {
        return firstElement;
    }

    // Возвращаем второй элемент пары
    public T getSecond() {
        return secondElement;
    }

}

public class Solution {
    public static void main(String[] args) {
        // Создаем объект DataPair для строк и передаем "Hello" и "World"
        DataPair<String> pair = new DataPair<>("Hello", "World");

        // Выводим оба значения через пробел
        System.out.println(pair.getFirst() + " " + pair.getSecond());
    }
}

/*
// Универсальная пара данных: класс для хранения двух связанных элементов одного типа
class DataPair<T> {
    // Два приватных поля обобщённого типа T
    private T firstElement;
    private T secondElement;

    // Конструктор принимает два значения и инициализирует поля
    public DataPair(T firstElement, T secondElement) {
        this.firstElement = firstElement;
        this.secondElement = secondElement;
    }

    // Возвращаем первый элемент пары
    public T getFirst() {
        return firstElement;
    }

    // Возвращаем второй элемент пары
    public T getSecond() {
        return secondElement;
    }
}

public class Solution {
    public static void main(String[] args) {
        // Создаем объект DataPair для строк и передаем "Hello" и "World"
        DataPair<String> pair = new DataPair<>("Hello", "World");

        // Выводим оба значения через пробел
        System.out.println(pair.getFirst() + " " + pair.getSecond());
    }
}

 */