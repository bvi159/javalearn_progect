package ru.javarush.java.core.level13.task04;
/*
Фиксация важного исторического момента 📜
Представьте, что вы записываете точное время и дату важного исторического события, которое произошло 20 марта 2022 года. Вам нужно не просто день, а конкретный момент.

Создайте переменную типа LocalDateTime (поскольку задача подразумевает и дату, и время) и присвойте ей значение, представляющее 20 марта 2022 года, скажем, в 10:00 утра. Назовите эту переменную historicMoment.

Затем выведите historicMoment на экран, чтобы зафиксировать этот ключевой момент.

Требования:
•	В программе должна быть объявлена переменная с именем historicMoment типа LocalDateTime.
•	Переменная historicMoment должна быть инициализирована значением, соответствующим 20 марта 2022 года, 10:00 утра.
•	Для создания значения даты и времени должен быть использован класс LocalDateTime (например, метод LocalDateTime.of).
•	Значение переменной historicMoment должно быть выведено на экран с помощью System.out.println.
public class Solution {
    public static void main(String[] args) {
        // LocalDateTime хранит одновременно дату и время
        // Фиксируем точный момент: 20 марта 2022 года, 10:00


        // Выводим зафиксированный момент на экран

    }
}
public class Solution {
    public static void main(String[] args) {
        // LocalDateTime хранит одновременно дату и время
        // Фиксируем точный момент: 20 марта 2022 года, 10:00


        // Выводим зафиксированный момент на экран

    }
}
 */
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Solution {
    public static void main(String[] args) {
        // LocalDateTime хранит одновременно дату и время
        // Фиксируем точный момент: 20 марта 2022 года, 10:00
        LocalDateTime historicMoment = LocalDateTime.of(2022, 3, 20, 10, 0);

        // Выводим зафиксированный момент на экран
        System.out.println(historicMoment);
// пример из следующей лекции
        LocalDate birthday = LocalDate.of(1986, 7, 21);
        System.out.println("Дата рождения: " + birthday);
        System.out.println("День недели рождения: " + birthday.getDayOfWeek());

        LocalTime parsedTime = LocalTime.parse("14:30:21.123456789");
        System.out.println(parsedTime);

        LocalTime precise = LocalTime.of(8, 15, 30, 123_456_789); // 08:15:30.123
        System.out.println(precise);

    }
}