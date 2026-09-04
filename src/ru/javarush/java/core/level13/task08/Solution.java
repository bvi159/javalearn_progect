package ru.javarush.java.core.level13.task08;
/*
Корректировка времени секретной миссии 🚀
Вы планируете тайную операцию. Изначально missionBriefing назначена на 1 июня 2025 года, 14:00. Однако, в последний момент пришло изменение: нужно прибавить 2 часа к этому времени, а затем отнять 30 минут.

Создайте объект LocalDateTime для первоначального missionBriefing. Примените необходимые изменения, чтобы получить finalMissionTime. Выведите finalMissionTime на экран, чтобы все агенты знали точное время старта.

Требования:
•	Необходимо создать объект LocalDateTime с датой 1 июня 2025 года и временем 14:00.
•	К объекту missionBriefing нужно прибавить 2 часа.
•	К результату предыдущей операции необходимо вычесть 30 минут.
•	Полученное после всех изменений значение времени должно быть сохранено в переменную finalMissionTime.
•	Значение переменной finalMissionTime должно быть выведено на экран.
public class Solution {
    public static void main(String[] args) {
        // Исходная дата и время брифинга: 1 июня 2025 года, 14:00


        // Прибавляем 2 часа, затем вычитаем 30 минут и сохраняем результат.


        // Выводим итоговое время старта миссии

    }
}

 */
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class Solution {
    public static void main(String[] args) {
        // Исходная дата и время брифинга: 1 июня 2025 года, 14:00
        LocalDateTime missionBriefing = LocalDateTime.of(2025, 6, 1, 14, 0);

        // Прибавляем 2 часа, затем вычитаем 30 минут и сохраняем результат.
        LocalDateTime finalMissionTime = missionBriefing.plusHours(2).minusMinutes(30);

        // Выводим итоговое время старта миссии
        System.out.println(finalMissionTime);
        //Пример из следующей лекции
        ZonedDateTime now = ZonedDateTime.now();
        System.out.println(now);

        ZonedDateTime MinskTime = ZonedDateTime.now(ZoneId.of("Europe/Minsk"));
        ZonedDateTime newYorkTime = ZonedDateTime.now(ZoneId.of("America/New_York"));
        ZonedDateTime ShanhaiTime = ZonedDateTime.now(ZoneId.of("Asia/Shanghai"));

        System.out.println("Минск: " + MinskTime);
        System.out.println("Нью-Йорк: " + newYorkTime);
        System.out.println("Шанхай: " + ShanhaiTime);


    }
}