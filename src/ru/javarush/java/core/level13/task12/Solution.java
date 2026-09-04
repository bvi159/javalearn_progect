package ru.javarush.java.core.level13.task12;
/*
Хроники времени: путешествие через Instant 🌌
Вы создаете универсальную систему хроник, которая должна работать с абсолютным временем. Начните с создания originalEventTime — ZonedDateTime объекта для 1 июня 2025 года, 12:00 в зоне "Europe/Minsk".

Затем преобразуйте этот originalEventTime в universalInstant — абсолютное, независимое от часового пояса мгновение.

Наконец, возьмите universalInstant и переведите его обратно в ZonedDateTime, но уже для зоны "Asia/Tokyo", получив eventTimeTokyoZoned.

Выведите на экран все три значения: originalEventTime, universalInstant и eventTimeTokyoZoned, чтобы продемонстрировать, как момент существует во всех своих проявлениях.

Требования:
•	Программа должна создать объект originalEventTime типа ZonedDateTime, представляющий 1 июня 2025 года, 12:00 в зоне "Europe/Minsk".
•	Программа должна преобразовать originalEventTime в объект universalInstant типа Instant.
•	Программа должна создать объект eventTimeTokyoZoned типа ZonedDateTime, представляющий тот же момент времени universalInstant, но в зоне "Asia/Tokyo".
•	Программа должна вывести на экран значения originalEventTime, universalInstant и eventTimeTokyoZoned.

public class Solution {
    public static void main(String[] args) {
        // 1) Создаем ZonedDateTime для 1 июня 2025 года, 12:00 в зоне Europe/Minsk


        // 2) Преобразуем ZonedDateTime в абсолютное мгновение Instant (UTC, часовой пояс не влияет)


        // 3) Тот же самый Instant отображаем как локальное время для зоны Asia/Tokyo


        // 4) Выводим все три значения

    }
}


 */
import java.time.*;

public class Solution {
    public static void main(String[] args) {
        // 1) Создаем ZonedDateTime для 1 июня 2025 года, 12:00 в зоне Europe/Minsk
        ZonedDateTime originalEventTime = LocalDateTime.of(2025, 06, 01, 12, 00)
                                         .atZone(ZoneId.of("Europe/Minsk"));


        // 2) Преобразуем ZonedDateTime в абсолютное мгновение Instant (UTC, часовой пояс не влияет)
        Instant universalInstant = originalEventTime.toInstant();


        // 3) Тот же самый Instant отображаем как локальное время для зоны Asia/Tokyo
        ZonedDateTime eventTimeTokyoZoned = universalInstant.atZone(ZoneId.of("Asia/Tokyo"));

        // 4) Выводим все три значения
        System.out.println(originalEventTime);
        System.out.println(universalInstant);
        System.out.println(eventTimeTokyoZoned);

    }
}