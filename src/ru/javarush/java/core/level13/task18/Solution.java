package ru.javarush.java.core.level13.task18;
/*
Машина времени: проверка наступления даты 🕰️
Представьте, что вы программируете машину времени, которая должна проверять, наступила ли уже определенная дата.

Вам нужно сравнить futureMilestone (1 января 2025 года) с today (текущей датой).

Создайте две переменные типа LocalDate для этих дат.

Используя метод isBefore, определите, наступила ли уже futureMilestone.

Если futureMilestone уже прошла, выведите "2025 уже наступил". В противном случае сообщите: "2025 еще не наступил".

Требования:
•	В программе должны быть созданы две переменные типа LocalDate: одна для текущей даты (today), другая для даты 1 января 2025 года (futureMilestone).
•	Переменная today должна быть инициализирована с использованием LocalDate.now().
•	Переменная futureMilestone должна быть инициализирована значением 1 января 2025 года.
•	Для определения, наступила ли уже дата futureMilestone, необходимо использовать метод isBefore у объекта LocalDate.
•	Если futureMilestone уже прошла (то есть today позже futureMilestone), программа должна вывести "2025 уже наступил". В противном случае — "2025 еще не наступил".

public class Solution {
    public static void main(String[] args) {
        // Текущая дата


        // Контрольная дата: 1 января 2025 года


        // Используем isBefore: если futureMilestone раньше today, значит 2025 уже наступил

    }
}


 */

import java.time.LocalDate;

public class Solution {
    public static void main(String[] args) {
        // Текущая дата
        LocalDate today = LocalDate.now();

        // Контрольная дата: 1 января 2025 года
        LocalDate futureMilestone = LocalDate.of(2025, 1, 1);

        // Используем isBefore: если futureMilestone раньше today, значит 2025 уже наступил
        if (futureMilestone.isBefore(today)) {
            System.out.println("2025 уже наступил");
        } else {
            System.out.println("2025 еще не наступил");
        }

    }
}