package ru.javarush.java.core.level13.task13;
/*
Стандартизация отчетов: текущая дата в ISO формате 📊
Вы разрабатываете систему генерации ежедневных отчетов, и для единообразия все даты должны быть представлены в стандартном формате ISO (например, 2025-06-01).

Ваша задача — получить currentReportDate (сегодняшнюю дату) и, используя класс DateTimeFormatter, отформатировать ее так, чтобы она соответствовала ISO_LOCAL_DATE.

Выведите formattedReportDate на экран, чтобы убедиться, что она выглядит идеально для всех отчетов.

Требования:
•	В программе должна использоваться стандартная библиотека java.time.LocalDate для получения сегодняшней даты.
•	Для форматирования даты должен быть использован класс java.time.format.DateTimeFormatter.
•	Дата должна быть отформатирована с помощью предопределенного форматтера DateTimeFormatter.ISO_LOCAL_DATE.
•	Результат форматирования должен быть сохранён в переменную с именем formattedReportDate.
•	Значение переменной formattedReportDate должно быть выведено на экран.

public class Solution {
    public static void main(String[] args) {
        // Получаем сегодняшнюю дату как LocalDate


        // Форматируем дату в стандарт ISO_LOCAL_DATE (например, 2025-06-01)


        // Выводим отформатированную дату

    }
}


 */
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Solution {
    public static void main(String[] args) {
        // Получаем сегодняшнюю дату как LocalDate
        LocalDate currentReportDate = LocalDate.now();

        // Форматируем дату в стандарт ISO_LOCAL_DATE (например, 2025-06-01)
        String formattedReportDate = currentReportDate.format(DateTimeFormatter.ISO_LOCAL_DATE);


        // Выводим отформатированную дату
        System.out.println(formattedReportDate);
    }
}