package ru.javarush.java.core.level22.task10;
/*
Идентификация местоположения на карте 📍

Вы разрабатываете приложение для карт, где важна точность координат. Вам нужно убедиться, что две точки с идентичными координатами считаются одинаковыми.
Создайте класс-запись, который будет представлять собой точку на двумерной плоскости, содержащую её координаты по осям X и Y.
В основной программе создайте два объекта точки с абсолютно одинаковыми значениями координат.
Ваша цель — проверить их равенство с помощью стандартного метода сравнения, а затем сравнить их хеш-коды. Выведите оба результата на экран, чтобы убедиться, что и сравнение, и хеширование дают положительный результат, подтверждая идентичность точек.

Требования:
•	Необходимо создать класс-запись (record), представляющий точку на двумерной плоскости с двумя полями: координатами X и Y.
•	Класс-запись должен использовать автогенерированные методы equals и hashCode для сравнения и хеширования объектов.
•	В основной программе требуется создать два объекта точки с одинаковыми значениями координат.
•	Программа должна сравнить созданные объекты с помощью метода equals и вывести результат сравнения на экран.
•	Программа должна сравнить хеш-коды двух объектов с помощью метода hashCode и вывести результат сравнения на экран.
•	Результаты сравнения (equals) и сравнения хеш-кодов (hashCode) должны быть положительными, что подтверждает идентичность точек.

public class Solution {
    public static void main(String[] args) {
        // Создаем две точки с абсолютно одинаковыми координатами
        Point point1 = new Point(40.7128, -74.0060);
        Point point2 = new Point(40.7128, -74.0060);

        // Сравнение объектов через equals (метод автоматически сгенерирован у record)
        boolean equalsResult = point1.equals(point2);

        // Сравнение их хеш-кодов (hashCode тоже автогенерируется у record)
        boolean sameHash = point1.hashCode() == point2.hashCode();

        // Выводим оба результата: ожидается true и true
        System.out.println(equalsResult);
        System.out.println(sameHash);
    }
}

 */
public class Solution {
    public static void main(String[] args) {
        // Создаем две точки с абсолютно одинаковыми координатами
        Point point1 = new Point(40.7128, -74.0060);
        Point point2 = new Point(40.7128, -74.0060);

        // Сравнение объектов через equals (метод автоматически сгенерирован у record)
        boolean equalsResult = point1.equals(point2);

        // Сравнение их хеш-кодов (hashCode тоже автогенерируется у record)
        boolean sameHash = point1.hashCode() == point2.hashCode();

        // Выводим оба результата: ожидается true и true
        System.out.println(equalsResult);
        System.out.println(sameHash);
    }
}

record Point(double x, double y) {
}

/*
public class Solution {
    public static void main(String[] args) {
        // Создаем две точки с абсолютно одинаковыми координатами
        Point point1 = new Point(40.7128, -74.0060);
        Point point2 = new Point(40.7128, -74.0060);

        // Сравнение объектов через equals (метод автоматически сгенерирован у record)
        boolean equalsResult = point1.equals(point2);

        // Сравнение их хеш-кодов (hashCode тоже автогенерируется у record)
        boolean sameHash = point1.hashCode() == point2.hashCode();

        // Выводим оба результата: ожидается true и true
        System.out.println(equalsResult);
        System.out.println(sameHash);
    }
}

// Класс-запись (record) для точки на двумерной плоскости.
record Point(double x, double y) { }
 */