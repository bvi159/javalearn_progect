package ru.javarush.java.core.level25.task05;
/*
Архитектурное Бюро: Расчёт Площадей Фигур 🧱

Представьте, что вы разрабатываете программное обеспечение для архитектурного бюро, где нужно рассчитывать площади различных геометрических форм. Вы знаете, что у каждой фигуры есть площадь, но способ её вычисления уникален.
Начните с создания абстрактного класса Shape. В нём объявите абстрактный метод calculateSurface(), который будет отвечать за вычисление площади, но не будет иметь конкретной реализации, ведь "площадь" для всех фигур разная.
Теперь оживите две конкретные фигуры: Square (квадрат) и Circle (круг). Каждый из этих классов должен наследовать Shape и, конечно же, предоставить свою собственную, уникальную реализацию метода calculateSurface(). Для квадрата вам понадобится знать длину sideLength, а для круга – radius.
В главном методе main воплотите в жизнь по одному экземпляру каждой из этих фигур, задав им необходимые параметры, и затем гордо выведите на экран рассчитанные площади, демонстрируя магию полиморфизма.

Требования:
•	В программе должен быть создан абстрактный класс с именем Shape.
•	В классе Shape должен быть объявлен абстрактный метод calculateSurface без реализации.
•	Должен быть реализован класс Square, который наследует Shape и содержит поле sideLength для хранения длины стороны квадрата.
•	Класс Square должен переопределять метод calculateSurface и возвращать корректную площадь квадрата, используя значение sideLength.
•	Должен быть реализован класс Circle, который наследует Shape и содержит поле radius для хранения радиуса круга.
•	Класс Circle должен переопределять метод calculateSurface и возвращать корректную площадь круга, используя значение radius.
•	В методе main должны быть созданы экземпляры Square и Circle, параметры которых задаются при создании, и для каждого объекта должен быть вызван метод calculateSurface через переменную типа Shape.
•	В методе main рассчитанные площади обеих фигур должны быть выведены на экран.

public class Solution {
    public static void main(String[] args) {
        Shape shape; // Переменная базового типа (полиморфизм)

        // Один и тот же тип ссылки указывает на разные объекты и вызывает "свою" реализацию
        shape = new Square(5); // квадрат со стороной 5
        System.out.println("Площадь квадрата: " + shape.calculateSurface());

        shape = new Circle(3); // круг с радиусом 3
        System.out.println("Площадь круга: " + shape.calculateSurface());
    }
}

 */


public class Solution {
    public static void main(String[] args) {
        Shape shape; // Переменная базового типа (полиморфизм)

        // Один и тот же тип ссылки указывает на разные объекты и вызывает "свою" реализацию
        shape = new Square(5); // квадрат со стороной 5
        System.out.println("Площадь квадрата: " + shape.calculateSurface());

        shape = new Circle(3); // круг с радиусом 3
        System.out.println("Площадь круга: " + shape.calculateSurface());
    }
}

abstract class Shape {
    abstract double calculateSurface();
}

class Square extends Shape{
    int sideLength;
    Square(int side) {
        sideLength = side;
    }
    @Override
    public double calculateSurface() {
        return Math.pow(sideLength, 2);
    }
}

class Circle extends Shape{
    int radius;
    Circle (int radius) {
        this.radius = radius;
    }
    @Override
    public double calculateSurface() {
        return Math.PI * Math.pow(radius, 2);
    }
}

/*

// Квадрат: площадь = сторона^2
class Square extends Shape {
    private final double sideLength;

    public Square(double sideLength) {
        this.sideLength = sideLength;
    }

    @Override
    public double calculateSurface() {
        return sideLength * sideLength;
    }
}

// Круг: площадь = PI * r^2
class Circle extends Shape {
    private final double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double calculateSurface() {
        return Math.PI * radius * radius;
    }
}

 */