package ru.javarush.java.core.level05.task16;

/*
Учёт двух календарных систем: Время из разных измерений ⏳

Вы работаете над проектом, который должен учитывать время из разных источников, как будто вы отслеживаете события по двум разным календарным системам. В Java есть две Даты (классы Date) с одинаковым именем, но из разных "измерений" (пакетов): одна для общих утилит, другая для работы с базами данных. Они называются одинаково — Date, но каждая хранит свои нюансы.

В методе main вашего класса Main вам нужно создать два объекта с именем Date:

Один объект должен быть из пакета java.util, представляющий общую дату и время.
Другой объект должен быть из пакета java.sql, предназначенный для работы с SQL-датами.
Присвойте каждому объекту текущую дату и время, а затем выведите их на консоль. Это покажет, что вы умеете различать эти "клонированные" сущности и корректно использовать их в своём коде, обращаясь к ним по полному "адресу" их измерения.

Требования:
•	В программе должен быть явно импортирован класс java.util.Date.
•	В методе main класса Main должны быть созданы два объекта с именем Date — один типа java.util.Date, другой типа java.sql.Date.
•	Оба объекта должны быть инициализированы текущей датой и временем.
•	При создании объекта java.sql.Date должно быть использовано полное имя класса (java.sql.Date), чтобы избежать конфликта имён.
•	Оба объекта (java.util.Date и java.sql.Date) должны быть выведены на консоль для сравнения их представления.

// Импортируем класс java.util.Date
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        // Создаем объект java.util.Date и присваиваем ему текущую дату и время


        // Создаем объект java.sql.Date, используя полное имя класса, и присваиваем ему текущую дату


        // Выводим оба объекта на консоль

    }
}

 */

// Импортируем класс java.util.Date
// import java.util.Date;

public class Main {
    public static void main(String[] args) {
        // Создаем объект java.util.Date и присваиваем ему текущую дату и время
        java.util.Date currentDay = new java.util.Date();

        // Создаем объект java.sql.Date, используя полное имя класса, и присваиваем ему текущую дату
        //Date sqlDate = new Date(System.currentTimeMillis());
        java.sql.Date sqlDate = new java.sql.Date(currentDay.getTime());

        // Выводим оба объекта на консоль
        System.out.println(currentDay);
        System.out.println(sqlDate);
    }
}
/*
Ихнее решение
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        // Создаем объект java.util.Date и присваиваем ему текущую дату и время
        Date utilDate = new Date();

        // Создаем объект java.sql.Date, используя полное имя класса, и присваиваем ему текущую дату
        java.sql.Date sqlDate = new java.sql.Date(System.currentTimeMillis());

        // Выводим оба объекта на консоль
        System.out.println("java.util.Date: " + utilDate);
        System.out.println("java.sql.Date: " + sqlDate);
    }
}



 */