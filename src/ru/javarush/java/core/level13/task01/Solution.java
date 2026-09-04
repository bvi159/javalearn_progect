package ru.javarush.java.core.level13.task01;
/*
Отметка текущего дня в календаре 🗓️
Представьте, что вы создаете умный цифровой календарь. Ваша первая задача — автоматически отметить сегодняшний день.

Для этого вам нужно захватить текущую дату и сохранить ее. Создайте переменную типа LocalDate под названием currentCalendarDate, в которую поместите сегодняшний день.

После этого покажите эту важную дату на экране, чтобы пользователь мог ее увидеть.

Требования:
•	В программе должен быть импортирован класс java.time.LocalDate.
•	В программе должна быть объявлена переменная с именем currentCalendarDate типа LocalDate.
•	В переменную currentCalendarDate должно быть записано текущее значение даты с помощью метода LocalDate.now().
•	Программа должна вывести на экран значение переменной currentCalendarDate.

public class Solution {
    public static void main(String[] args) {
        // Создаем переменную типа LocalDate и записываем в нее сегодняшнюю дату


        // Выводим дату на экран

    }
}

 */

import java.time.LocalDate;

public class Solution {
    public static void main(String[] args) {
        // Создаем переменную типа LocalDate и записываем в нее сегодняшнюю дату
        LocalDate currentCalendarDate = LocalDate.now();

        // Выводим дату на экран
        System.out.println(currentCalendarDate);
    }
}