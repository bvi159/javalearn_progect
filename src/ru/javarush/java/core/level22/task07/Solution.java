package ru.javarush.java.core.level22.task07;

/*
Перемещение объекта на игровой карте 🎮

Вы разрабатываете простую игру, где объекты перемещаются по координатной сетке. Вам нужно удобно отслеживать их положение.
Создайте класс-запись, который будет представлять собой точку на карте с координатами по горизонтали и вертикали.
В основной программе создайте начальную точку для вашего объекта, например, с координатами (3, 7).
Теперь вам нужно имитировать его перемещение: создайте новую точку, которая будет представлять то же самое место, но с увеличенной горизонтальной координатой на 2 единицы.
Выведите на экран обе точки — начальную и новую, чтобы наглядно показать их положение.

Требования:
•	В программе должен быть определён record-класс с именем Point с двумя полями: horizontal и vertical.
•	Экземпляры класса Point должны быть неизменяемыми: после создания их поля нельзя изменить.
•	В основной программе необходимо создать объект Point с координатами (3, 7).
•	В программе должна быть создана новая точка Point, у которой горизонтальная координата увеличена на 2 по сравнению с исходной, а вертикальная остаётся прежней.
•	Программа должна вывести на экран обе точки: начальную и новую, чтобы показать разницу в их положении.

public class Solution {
    public static void main(String[] args) {
        // Инициализируем начальную точку (3, 7)
        Point start = new Point(3, 7);

        // Создаём новую точку со смещением по горизонтали на 2, вертикаль оставляем прежней
        Point moved = new Point(start.horizontal() + 2, start.vertical());

        // Выводим обе точки: сначала начальную, затем новую
        System.out.println(start);
        System.out.println(moved);
    }
}

 */


public class Solution {
    public static void main(String[] args) {
        // Инициализируем начальную точку (3, 7)
        Point start = new Point(3, 7);

        // Создаём новую точку со смещением по горизонтали на 2, вертикаль оставляем прежней
        Point moved = new Point(start.horizontal() + 2, start.vertical());

        // Выводим обе точки: сначала начальную, затем новую
        System.out.println(start);
        System.out.println(moved);

        boolean areEqual = start.equals(moved);
        int hashStart = start.hashCode();
        int hashMoved = moved.hashCode();

        System.out.println("Are these objects equal? -> " + areEqual);
        System.out.println("Hash start: " + hashStart);
        System.out.println("Hash moved: " + hashMoved);

    }
}

record Point(int horizontal, int vertical) {
}

/*
// Record-класс для представления точки на карте.
record Point(int horizontal, int vertical) {}

public class Solution {
    public static void main(String[] args) {
        // Инициализируем начальную точку (3, 7)
        Point start = new Point(3, 7);

        // Создаём новую точку со смещением по горизонтали на 2, вертикаль оставляем прежней
        Point moved = new Point(start.horizontal() + 2, start.vertical());

        // Выводим обе точки: сначала начальную, затем новую
        System.out.println(start);
        System.out.println(moved);
    }
}

 */