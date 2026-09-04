package ru.javarush.java.core.level10.task13;

// Содержит ровно три значения: RED, YELLOW и GREEN.



public class Solution {
    public static void main(String[] args) {
        // Создаём переменную типа TrafficSignalState и задаём начальное значение RED
        TrafficSignalState mySignal = TrafficSignalState.YELLOW;
        String russianColor = mySignal.getColor();

        // Выводим текущее состояние светофора на экран
        System.out.println(mySignal);
        System.out.println(russianColor);

    }
}