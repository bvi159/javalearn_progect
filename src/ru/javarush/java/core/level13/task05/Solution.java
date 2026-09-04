package ru.javarush.java.core.level13.task05;
/*
Волшебные часы: показ точного времени 🕰️
Вы — мастер-часовщик, создающий необычные часы. Они должны не просто показывать время, но и подробно рассказывать о каждом его компоненте.

Захватите currentTime в виде объекта LocalTime. Теперь извлеките из него displayHours, displayMinutes и displaySeconds.

Выведите эти компоненты на экран в следующем формате, чтобы каждый мог увидеть точное волшебство: "Часы: [значение часов], минуты: [значение минут], секунды: [значение секунд]".

Требования:
•	Программа должна импортировать класс java.time.LocalTime.
•	Программа должна получить текущее время с помощью LocalTime.now() и сохранить его в переменную currentTime.
•	Из объекта currentTime необходимо получить значения часов, минут и секунд с помощью соответствующих методов LocalTime.
•	Значения часов, минут и секунд должны быть сохранены в переменные displayHours, displayMinutes и displaySeconds.
•	Программа должна вывести значения часов, минут и секунд в формате: "Часы: [значение часов], минуты: [значение минут], секунды: [значение секунд]".
public class Solution {
    public static void main(String[] args) {
        // Получаем текущее время с помощью LocalTime.now()


        // Извлекаем часы, минуты и секунды из текущего времени


        // Выводим часы, минуты и секунды в заданном формате

    }
}

public class Solution {
    public static void main(String[] args) {
        // Получаем текущее время с помощью LocalTime.now()


        // Извлекаем часы, минуты и секунды из текущего времени


        // Выводим часы, минуты и секунды в заданном формате

    }
}
 */

import java.time.LocalTime;

public class Solution {
    public static void main(String[] args) {
        // Получаем текущее время с помощью LocalTime.now()
        LocalTime currentTime = LocalTime.now();

        // Извлекаем часы, минуты и секунды из текущего времени
        int displayHours = currentTime.getHour();
        int displayMinutes = currentTime.getMinute();
        int displaySeconds = currentTime.getSecond();

        // Выводим часы, минуты и секунды в заданном формате
        System.out.println( "Часы: " + displayHours + ", минуты: "+ displayMinutes +", секунды: "+ displaySeconds);

    }
}