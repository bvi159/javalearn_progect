package ru.javarush.java.core.level13.task19;
/*
Вы — незаменимый проектный менеджер, и вам нужно точно знать, сколько дней осталось до projectDeadline, который назначен на 15 мая 2025 года.

Начните с определения today (текущей даты) и projectDeadline как объектов LocalDate. Затем, используя ChronoUnit.DAYS.between, вычислите daysRemaining — точное количество дней между этими двумя датами.

Выведите daysRemaining на экран, чтобы вся команда была в курсе!

Требования:
•	В программе должна быть создана переменная today, представляющая текущую дату, с использованием класса LocalDate.
•	В программе должна быть создана переменная projectDeadline типа LocalDate, представляющая дату 15 мая 2025 года.
•	Для вычисления количества дней между today и projectDeadline должен быть использован метод ChronoUnit.DAYS.between.
•	Результат вычисления разницы в днях должен быть сохранён в переменную daysRemaining.
•	Программа должна вывести значение переменной daysRemaining на экран.

public class Solution {
    public static void main(String[] args) {
        // Текущая дата (берется из системных настроек)


        // Дата дедлайна проекта: 15 мая 2025 года


        // Количество дней между today и projectDeadline


        // Выводим результат на экран

    }
}

 */
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Solution {
    public static void main(String[] args) {
        // Текущая дата (берется из системных настроек)
        LocalDate today = LocalDate.now();
        

        // Дата дедлайна проекта: 15 мая 2025 года
        LocalDate projectDeadline = LocalDate.of(2025, 05, 15);


        // Количество дней между today и projectDeadline
        long daysRemaining = ChronoUnit.DAYS.between(today, projectDeadline);


        // Выводим результат на экран
        System.out.println(daysRemaining);

    }
}