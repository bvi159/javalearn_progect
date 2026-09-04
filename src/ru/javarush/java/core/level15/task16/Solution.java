package ru.javarush.java.core.level15.task16;
/*
Фундаментальные константы для расчётов ⚛️

Вы создаёте вспомогательную библиотеку, которая будет содержать общеизвестные, фундаментальные константы, используемые в математике и календаре. Эти значения должны быть легко доступны из любой части вашей программы и, конечно же, не должны изменяться.
Создайте класс GlobalConstants. Внутри него объявите два публичных статических final поля:
MATH_PI типа double, которому присвойте значение 3.14159.
CALENDAR_DAYS_IN_YEAR типа int, которому присвойте значение 365.
Эти поля являются константами, поэтому их имена должны быть написаны в верхнем регистре с использованием подчёркиваний.
В классе Solution выведите на экран значения обеих констант, обратившись к ним напрямую через имя класса GlobalConstants. Это продемонстрирует, как можно удобно и безопасно использовать фиксированные, глобальные значения в вашем приложении.

Требования:
•	Необходимо создать отдельный класс с именем GlobalConstants.
•	В классе GlobalConstants должно быть объявлено два поля с модификаторами public static final.
•	Поле MATH_PI должно быть типа double и иметь значение 3.14159, а поле CALENDAR_DAYS_IN_YEAR должно быть типа int и иметь значение 365.
•	Названия обоих полей должны быть написаны заглавными буквами с использованием подчёркиваний (например, MATH_PI).
•	В классе Solution необходимо вывести значения обеих констант, обратившись к ним через имя класса GlobalConstants (например, GlobalConstants.MATH_PI).

public class Solution {
    public static void main(String[] args) {
        // Обращаемся к константам напрямую через имя класса GlobalConstants
        System.out.println(GlobalConstants.MATH_PI);
        System.out.println(GlobalConstants.CALENDAR_DAYS_IN_YEAR);
    }
}

 */

public class Solution {
    public static void main(String[] args) {
        // Обращаемся к константам напрямую через имя класса GlobalConstants
        System.out.println(GlobalConstants.MATH_PI);
        System.out.println(GlobalConstants.CALENDAR_DAYS_IN_YEAR);
    }
}

class GlobalConstants {
    public static final double MATH_PI = 3.14159;
    public static final int CALENDAR_DAYS_IN_YEAR = 365;
}