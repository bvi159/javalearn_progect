package ru.javarush.java.core.level13.task20;
/*
Агентство недвижимости: расчет возраста здания 🏡
Вы работаете в агентстве недвижимости и вам нужно точно определить возраст здания, зная только его constructionDate (20 марта 2000 года) и today (текущую дату).

Используя мощный класс Period, вычислите buildingAgePeriod, то есть, сколько полных years, months и days прошло с момента постройки до сегодняшнего дня.

Выведите buildingAgePeriod на экран в понятном формате: "Возраст: X лет, Y месяцев, Z дней".

Требования:
•	Необходимо использовать класс Period для вычисления разницы между датами.
•	Дата постройки здания (constructionDate) и текущая дата (today) должны быть представлены объектами LocalDate.
•	Возраст здания должен определяться как полное количество лет, месяцев и дней между датой постройки и текущей датой.
•	Результат должен быть выведен на экран в формате: "Возраст: X лет, Y месяцев, Z дней", где X, Y, Z — соответствующие значения из объекта Period.
public class Solution {
    public static void main(String[] args) {
        // Создаем объект LocalDate для даты постройки здания: 20 марта 2000 года


        // Получаем текущую дату


        // Вычисляем полный период между датой постройки и сегодняшним днем


        // Форматируем и выводим результат в формате "Возраст: X лет, Y месяцев, Z дней"

    }
}

*/

import java.time.LocalDate;
import java.time.Period;

public class Solution {
    public static void main(String[] args) {
        // Создаем объект LocalDate для даты постройки здания: 20 марта 2000 года
        LocalDate constructionDate = LocalDate.of(2000, 03, 20);
        LocalDate today = LocalDate.now();

        // Получаем текущую дату

        // Вычисляем полный период между датой постройки и сегодняшним днем
        Period buildingAgePeriod = Period.between(constructionDate, today);

        // Форматируем и выводим результат в формате "Возраст: X лет, Y месяцев, Z дней"
        System.out.println("Возраст: "
                + buildingAgePeriod.getYears() + " лет, "
                + buildingAgePeriod.getMonths() + " месяцев, "
                + buildingAgePeriod.getDays() + " дней"
        );


    }
}