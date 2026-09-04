package ru.javarush.java.core.level13.task10;
/*
Международная конференция: фиксация события в часовом поясе 🌐
Вы планируете важную международную конференцию. Основное событие, conferenceStartLocal, запланировано на 1 июня 2025 года, 14:00. Это просто "локальное" время, но для координации вам нужно привязать его к конкретному часовому поясу — "Europe/Minsk".

Ваша задача — преобразовать conferenceStartLocal в conferenceStartMinskZoned типа ZonedDateTime с учетом этой зоны. Выведите conferenceStartMinskZoned на экран, чтобы подтвердить, что время события теперь четко определено в пространстве и времени.

Требования:
•	Необходимо создать объект LocalDateTime, соответствующий дате и времени 1 июня 2025 года, 14:00.
•	Нужно преобразовать локальное время conferenceStartLocal в ZonedDateTime, используя зону "Europe/Minsk".
•	conferenceStartMinskZoned должен иметь тип ZonedDateTime.
•	Полученное значение conferenceStartMinskZoned должно быть выведено на экран для проверки результата.

public class Solution {
    public static void main(String[] args) {
        // 1. Создаем "локальное" время без привязки к часовой зоне:
        // 1 июня 2025 года, 14:00


        // 2. Выбираем часовую зону Europe/Minsk


        // 3. Привязываем локальное время к выбранной зоне, получаем ZonedDateTime


        // 4. Выводим результат для проверки (например: 2025-06-01T14:00+03:00[Europe/Minsk])

    }
}

 */
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class Solution {
    public static void main(String[] args) {
        // 1. Создаем "локальное" время без привязки к часовой зоне:
        // 1 июня 2025 года, 14:00
        LocalDateTime conferenceStartLocal = LocalDateTime.of(2025, 06, 01,14,00);

        // 2. Выбираем часовую зону Europe/Minsk
        ZoneId myMinsk = ZoneId.of("Europe/Minsk");

        // 3. Привязываем локальное время к выбранной зоне, получаем ZonedDateTime
        ZonedDateTime conferenceStartMinskZoned = conferenceStartLocal.atZone(myMinsk);


        // 4. Выводим результат для проверки (например: 2025-06-01T14:00+03:00[Europe/Minsk])
        System.out.println(conferenceStartMinskZoned);

    }
}