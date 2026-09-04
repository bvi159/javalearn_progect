package ru.javarush.java.core.level23.task04;

public class Solution {
    public static void main(String[] args) {
        // Создаём товар, обязательно указывая имя в конструкторе
        Product kolbasa = new Product("Колбаса");

        // Выводим имя товара на экран, подтверждая успешное создание
        System.out.println("Создан новый продукт: " + kolbasa);

        // Пример неправильного использования:
    //    Product moloko = new Product();

    }
}

/*
public class Solution {
    public static void main(String[] args) {
        // Создаём товар, обязательно указывая имя в конструкторе
        Product milk = new Product("Молоко");

        // Выводим имя товара на экран, подтверждая успешное создание
        System.out.println(milk.getProductName());

        // Пример неправильного использования:
        Product invalid = new Product(); // Ошибка: нет конструктора без параметров
    }
}
 */