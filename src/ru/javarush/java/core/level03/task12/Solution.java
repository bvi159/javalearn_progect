package ru.javarush.java.core.level03.task12;
/*
Комфортная температура в помещении 🌡️

Вы создаёте умный термостат. Объявите переменную int с именем roomTemperature. Создайте переменную типа boolean с именем isComfortable, которая станет true, если roomTemperature находится в комфортном диапазоне от 20 до 25 градусов включительно. Выведите значение isComfortable на экран.

Требования:
•	В программе должна быть объявлена переменная типа int с именем roomTemperature.
•	В программе должна быть объявлена переменная типа boolean с именем isComfortable.
•	Переменная isComfortable должна быть равна true, если значение roomTemperature находится в диапазоне от 20 до 25 включительно.
•	Программа должна выводить значение переменной isComfortable на экран.
public class Solution {
    public static void main(String[] args) {
        // Объявляем переменную roomTemperature типа int


        // Проверяем, находится ли roomTemperature в диапазоне от 20 до 25 включительно


        // Выводим значение переменной isComfortable на экран

    }
}

 */

public class Solution {
    public static void main(String[] args) {
        // Объявляем переменную roomTemperature типа int
        int roomTemperature = 0;

        // Проверяем, находится ли roomTemperature в диапазоне от 20 до 25 включительно
        boolean isComfortable = (roomTemperature >= 20) && (roomTemperature <= 25);

        // Выводим значение переменной isComfortable на экран
        System.out.println(isComfortable);

    }
}