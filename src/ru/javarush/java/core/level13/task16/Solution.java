package ru.javarush.java.core.level13.task16;
/*
Отслеживание заказов: парсинг времени с точностью 📦
Вам пришел новый orderTimestampString — "01.06.2025 14:30". Ваша система должна немедленно преобразовать эту строку в точный объект LocalDateTime, чтобы корректно отслеживать время поступления заказа.

Используйте шаблон "dd.MM.yyyy HH:mm" для парсинга orderTimestampString в parsedOrderDateTime. Затем выведите parsedOrderDateTime на экран, убедившись, что он корректно представлен в формате 2025-06-01T14:30, готовый для внутренней обработки.

Требования:
•	В программе должны быть импортированы классы java.time.LocalDateTime и java.time.format.DateTimeFormatter.
•	Для парсинга строки "01.06.2025 14:30" должен использоваться шаблон "dd.MM.yyyy HH:mm".
•	Строка orderTimestampString должна быть преобразована в объект LocalDateTime с помощью DateTimeFormatter.
•	Результат парсинга должен быть сохранён в переменную с именем parsedOrderDateTime.
•	На экран должен быть выведен parsedOrderDateTime в формате 2025-06-01T14:30 (стандартный вывод LocalDateTime.toString()).

public class Solution {
    public static void main(String[] args) {
        // Исходная строка с меткой времени заказа


        // Создаем форматтер с шаблоном "dd.MM.yyyy HH:mm"


        // Парсим строку в объект LocalDateTime


        // Выводим результат в стандартном ISO-формате (например, 2025-06-01T14:30)

    }
}


 */

import java.time.*;
import java.time.format.DateTimeFormatter;

public class Solution {
    public static void main(String[] args) {
        // Исходная строка с меткой времени заказа
        String orderTimestampString = "01.06.2025 14:30";

        // Создаем форматтер с шаблоном "dd.MM.yyyy HH:mm"
        DateTimeFormatter myParseTemplate = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");

        // Парсим строку в объект LocalDateTime
        LocalDateTime parsedOrderDateTime = LocalDateTime.parse(orderTimestampString, myParseTemplate);

        // Выводим результат в стандартном ISO-формате (например, 2025-06-01T14:30)
        System.out.println(parsedOrderDateTime);

        // из следующего урока
        LocalDate date1 = LocalDate.of(2025, 2, 28);
        LocalDate date2 = LocalDate.of(2026, 3, 1);

        Period period = Period.between(date1, date2); // 2 дня (високосный год)
        long days = java.time.temporal.ChronoUnit.DAYS.between(date1, date2); // 2 дня

        System.out.println("Period: " + period.getDays() + " дней");
        System.out.println("ChronoUnit: " + days + " дней");

        ZonedDateTime MinskTime = ZonedDateTime.of(2025, 6, 1, 12, 0, 0, 0, ZoneId.of("Europe/Minsk"));
        ZonedDateTime nyTime = ZonedDateTime.of(2025, 6, 1, 12, 0, 0, 0, ZoneId.of("America/New_York"));

        Duration diff = Duration.between(nyTime, MinskTime);
        System.out.println("Разница: " + diff.toHours() + " часов");

    }
}