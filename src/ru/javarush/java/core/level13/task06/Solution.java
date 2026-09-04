package ru.javarush.java.core.level13.task06;
/*
Астрологический прогноз: день рождения и день недели 🌟
Для вашего нового астрологического приложения вам нужно определить день недели для конкретной даты рождения.

Возьмем для примера userBirthDate: 15 декабря 1990 года.

Создайте объект LocalDate для этой даты. Затем ваша задача — выяснить, какой день недели был в этот особенный день, и вывести его на экран.

Требования:
•	В программе должен быть создан объект LocalDate, представляющий 15 декабря 1990 года.
•	Для работы с датой рождения необходимо использовать класс LocalDate из пакета java.time.
•	Программа должна определить, какой день недели соответствует заданной дате.
•	Полученное значение дня недели должно быть выведено на экран.

public class Solution {
    public static void main(String[] args) {
        // Создаем объект LocalDate для 15 декабря 1990 года


        // Получаем день недели для указанной даты


        // Выводим день недели на экран

    }
}

 */
import java.sql.SQLOutput;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

public class Solution {
    public static void main(String[] args) {
        // Создаем объект LocalDate для 15 декабря 1990 года
        LocalDate userBirthDay = LocalDate.of(1990,12,15);

        // Получаем день недели для указанной даты
        DayOfWeek dayOfBirthday = userBirthDay.getDayOfWeek();


        // Выводим день недели на экран
        System.out.println(dayOfBirthday);
        // Получаем название дня недели на русском языке
        String russianDayOfWeek = dayOfBirthday.getDisplayName(TextStyle.FULL, new Locale("ru"));
        System.out.println(russianDayOfWeek);


    }
}