package ru.javarush.java.core.level13.task09;
/*
Глобальный командный центр: время по всему миру 🌍
Вы разрабатываете главный дисплей для глобального командного центра. Ваша задача — показать текущее время в трех стратегически важных часовых поясах: "Europe/Minsk", "America/New_York" и "Asia/Tokyo".

Для каждой из этих зон создайте ZonedDateTime объект, который будет содержать currentTimeInMinsk, currentTimeInNewYork и currentTimeInTokyo соответственно.

Убедитесь, что вы выводите каждую зону на отдельной строке, четко указывая название города и соответствующее местное время.

Требования:
•	В программе должны быть использованы объекты ZonedDateTime для представления времени в указанных часовых поясах.
•	Для каждой временной зоны должно быть получено текущее время с помощью ZonedDateTime.now(ZoneId.of(...)).
•	Для создания объектов ZonedDateTime должны быть использованы идентификаторы "Europe/Minsk", "America/New_York" и "Asia/Tokyo".
•	В программе должны быть объявлены переменные currentTimeInMinsk, currentTimeInNewYork и currentTimeInTokyo, каждая из которых содержит ZonedDateTime для соответствующей зоны.
•	Результат работы программы должен выводить для каждой зоны название города и соответствующее локальное время на отдельной строке.
•	В выводе должно быть явно указано название города и его локальное время.
public class Solution {
    public static void main(String[] args) {
        // Получаем текущее время в каждой указанной зоне через ZonedDateTime.now(ZoneId.of(...))


        // Простой и наглядный формат даты и времени (локальное время конкретной зоны)


        // Выводим каждую зону на отдельной строке: название города + локальное время

    }
}
public class Solution {
    public static void main(String[] args) {
        // Получаем текущее время в каждой указанной зоне через ZonedDateTime.now(ZoneId.of(...))


        // Простой и наглядный формат даты и времени (локальное время конкретной зоны)


        // Выводим каждую зону на отдельной строке: название города + локальное время

    }
}

*/

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class Solution {
    public static void main(String[] args) {
        // Получаем текущее время в каждой указанной зоне через ZonedDateTime.now(ZoneId.of(...))
        ZonedDateTime currentTimeInMinsk = ZonedDateTime.now(ZoneId.of("Europe/Minsk"));
        ZonedDateTime currentTimeInNewYork = ZonedDateTime.now(ZoneId.of("America/New_York"));
        ZonedDateTime currentTimeInTokyo = ZonedDateTime.now(ZoneId.of("Asia/Tokyo"));
        // Простой и наглядный формат даты и времени (локальное время конкретной зоны)

//        System.out.println("Сейчас в Минске " + currentTimeInMinsk);
//        System.out.println("Сейчас в Нью-Йорке " + currentTimeInNewYork);
//        System.out.println("Сейчас в Токио " + currentTimeInTokyo);

        LocalDateTime inMinsk = LocalDateTime.now(ZoneId.of("Europe/Minsk"));
        LocalDateTime inNewYork = LocalDateTime.now(ZoneId.of("America/New_York"));
        LocalDateTime inTokyo = LocalDateTime.now(ZoneId.of("Asia/Tokyo"));


        // Выводим каждую зону на отдельной строке: название города + локальное время
        System.out.println("Сейчас в Минске " + inMinsk);
        System.out.println("Сейчас в Нью-Йорке " + inNewYork);
        System.out.println("Сейчас в Токио " + inTokyo);


        // пример из следующей лекции
        LocalDateTime localTime = LocalDateTime.of(2025, 6, 1, 14, 0);
        ZonedDateTime zonedTime = localTime.atZone(ZoneId.of("Europe/Moscow"));
        System.out.println(zonedTime);


        LocalDateTime extracted = zonedTime.toLocalDateTime();
        System.out.println(extracted);


    }
}
/*
Ихнее решение
public class Solution {
    public static void main(String[] args) {
        // Получаем текущее время в каждой указанной зоне через ZonedDateTime.now(ZoneId.of(...))
        ZonedDateTime currentTimeInMinsk = ZonedDateTime.now(ZoneId.of("Europe/Minsk"));
        ZonedDateTime currentTimeInNewYork = ZonedDateTime.now(ZoneId.of("America/New_York"));
        ZonedDateTime currentTimeInTokyo = ZonedDateTime.now(ZoneId.of("Asia/Tokyo"));

        // Простой и наглядный формат даты и времени (локальное время конкретной зоны)
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        // Выводим каждую зону на отдельной строке: название города + локальное время
        System.out.println("Минск: " + currentTimeInMinsk.format(formatter));
        System.out.println("Нью-Йорк: " + currentTimeInNewYork.format(formatter));
        System.out.println("Токио: " + currentTimeInTokyo.format(formatter));
    }
}
 */