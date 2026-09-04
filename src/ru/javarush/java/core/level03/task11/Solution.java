package ru.javarush.java.core.level03.task11;
/*
Планирование пикника 🧺

Вы с друзьями планируете пикник на выходных. Задайте две переменные типа boolean: isSunny и isWeekend.
Создайте переменную canGoToPark, которая будет true только если и isSunny, и isWeekend равны true (используйте оператор &&).

Создайте вторую переменную canStayHome, которая будет true, если хотя бы один из дней не соответствует
условиям для пикника (используйте оператор || и !). Выведите значения обеих новых переменных на экран.

Требования:
•	В программе должны быть объявлены две переменные типа boolean: isSunny и isWeekend.
•	Переменная canGoToPark должна быть объявлена и вычисляться с помощью логического оператора &&,
    чтобы принимать значение true только если isSunny и isWeekend оба равны true.
•	Переменная canStayHome должна быть объявлена и вычисляться с помощью логических операторов || и !,
    чтобы принимать значение true, если хотя бы одно из условий (не солнечно или не выходные) выполняется.
•	Значения переменных canGoToPark и canStayHome должны быть выведены на экран.

public class Solution {
    public static void main(String[] args) {
        // Исходные условия (можно менять для проверки разных вариантов)

        // В парк идём только если одновременно солнечно И выходные

        // Остаёмся дома, если НЕ солнечно ИЛИ НЕ выходные

        // Вывод значений на экран

    }
}

 */

public class Solution {
    public static void main(String[] args) {
        // Исходные условия (можно менять для проверки разных вариантов)
        boolean isSunny = true;
        boolean isWeekend  = true;
        boolean canGoToPark = isSunny && isWeekend;
        boolean canStayHome = !isSunny || !isWeekend;

//        // В парк идём только если одновременно солнечно И выходные
//        if(canGoToPark) {
//            canStayHome = false;
//        }
//
//        // Остаёмся дома, если НЕ солнечно ИЛИ НЕ выходные
//        if(canStayHome) {
//            canGoToPark = false;
//        }
//        // Вывод значений на экран
        System.out.println(canGoToPark);
        System.out.println(canStayHome);


    }
}