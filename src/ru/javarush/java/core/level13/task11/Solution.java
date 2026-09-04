package ru.javarush.java.core.level13.task11;
/*
Перемещение телепортации: одно событие в разных часовых поясах 🚀
Вы управляете системой глобальных телепортаций. Одна из них назначена на teleportScheduledLocal — 1 июня 2025 года, 18:00.

Сначала точно определите это событие в часовом поясе "Europe/Minsk", создав teleportTimeMinskZoned.

Теперь самое интересное: вам нужно узнать, когда именно это же самое событие произойдет для тех, кто находится в "America/New_York", то есть получить teleportTimeNewYorkZoned. Используйте метод withZoneSameInstant для точного преобразования.

Выведите на экран оба значения: teleportTimeMinskZoned и teleportTimeNewYorkZoned, чтобы показать, как одно и то же мгновение выглядит в разных уголках мира.

Требования:
•	Необходимо создать объект LocalDateTime с датой и временем 1 июня 2025 года, 18:00.
•	Необходимо получить объект ZoneId, соответствующий часовому поясу "Europe/Minsk".
•	На основе локального времени и часового пояса "Europe/Minsk" необходимо создать объект ZonedDateTime и сохранить его в переменную teleportTimeMinskZoned.
•	Используя метод withZoneSameInstant, необходимо получить объект ZonedDateTime, соответствующий тому же моменту времени, но в часовом поясе "America/New_York", и сохранить его в переменную teleportTimeNewYorkZoned.
•	Необходимо вывести на экран значения переменных teleportTimeMinskZoned и teleportTimeNewYorkZoned.
public class Solution {
    public static void main(String[] args) {
        // Локальная дата-время телепорта (без привязки к часовому поясу)


        // Часовой пояс Минска


        // Привязываем локальное время к Минску — получаем конкретное мгновение


        // Переводим то же самое мгновение в часовой пояс Нью-Йорка


        // Выводим оба значения, чтобы увидеть разницу представлений одного мгновения

    }
}

 */
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class Solution {
    public static void main(String[] args) {
        // Локальная дата-время телепорта (без привязки к часовому поясу)
        LocalDateTime teleportScheduledLocal = LocalDateTime.of(2025,06,01,18,00);

        // Часовой пояс Минска
        // Привязываем локальное время к Минску — получаем конкретное мгновение
        ZonedDateTime teleportTimeMinskZoned = teleportScheduledLocal.atZone(ZoneId.of("Europe/Minsk"));

        // Переводим то же самое мгновение в часовой пояс Нью-Йорка
        ZonedDateTime teleportTimeNewYorkZoned = teleportTimeMinskZoned
                                                .withZoneSameInstant(ZoneId.of("America/New_York"));

        // Выводим оба значения, чтобы увидеть разницу представлений одного мгновения
        System.out.println(teleportTimeMinskZoned);
        System.out.println(teleportTimeNewYorkZoned);

    }
}