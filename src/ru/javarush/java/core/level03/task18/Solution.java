package ru.javarush.java.core.level03.task18;

public class Solution {
    public static void main(String[] args) {
        // Объявляем переменную orderNumber и присваиваем ей значение
        int orderNumber = 273;

        // Используем тернарный оператор для определения чётности orderNumber
        String orderStatus = (orderNumber % 2 == 0)? "Чётный" : "Нечётный";

        // Выводим результат на экран
        System.out.println(orderStatus);
    }
}