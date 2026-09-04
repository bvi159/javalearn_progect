package ru.javarush.java.core.level19.task10;
/*
Библиотека геометрических фигур 🔵⬛

Вообразите себя архитектором, проектирующим библиотеку для работы с геометрическими фигурами. Каждая фигура, будь то квадрат или круг, обладает площадью, но формула для её вычисления уникальна.
Для начала, создайте абстрактный класс Figure с абстрактным методом double area(), который будет символизировать возможность вычисления площади.
Затем приступайте к созданию конкретных фигур: класса Square, который будет хранить длину своей стороны (side), и класса Circle, который будет хранить свой радиус (radius).
Оба этих класса должны наследовать Figure и каждый реализовать свой собственный метод area(): для Square это будет side * side, а для Circle — Math.PI * radius * radius.

Чтобы протестировать вашу библиотеку, в методе main создайте объекты Square со стороной, равной 4, и Circle с радиусом, равным 3. После этого для каждой из созданных фигур вызовите метод area() и выведите полученный результат на экран, чтобы убедиться в корректности расчетов.

Требования:
•	Необходимо создать абстрактный класс с именем Figure.
•	В классе Figure должен быть абстрактный метод double area(), который не имеет реализации.
•	Должен быть создан класс Square, который наследует класс Figure и содержит поле side для хранения длины стороны квадрата.
•	Класс Square должен реализовывать метод area(), возвращающий площадь квадрата по формуле side * side.
•	Должен быть создан класс Circle, который наследует класс Figure и содержит поле radius для хранения радиуса круга.
•	Класс Circle должен реализовывать метод area(), возвращающий площадь круга по формуле Math.PI * radius * radius.
•	В методе main необходимо создать объект Square со стороной 4 и объект Circle с радиусом 3.
•	В методе main для каждого созданного объекта Square и Circle необходимо вызвать метод area() и вывести результат на экран.

// Библиотека геометрических фигур: абстракция + конкретные реализации
public class Solution {
    public static void main(String[] args) {
        // Создаем объекты конкретных фигур
        Figure square = new Square(4); // квадрат со стороной 4
        Figure circle = new Circle(3); // круг с радиусом 3

        // Вызываем area() у каждой фигуры и выводим результат
        System.out.println(square.area());
        System.out.println(circle.area());
    }
}
 */


// Библиотека геометрических фигур: абстракция + конкретные реализации
public class Solution {
    public static void main(String[] args) {
        // Создаем объекты конкретных фигур
        Figure square = new Square(4); // квадрат со стороной 4
        Figure circle = new Circle(3); // круг с радиусом 3

        // Вызываем area() у каждой фигуры и выводим результат
        System.out.println(square.area());
        System.out.println(circle.area());
    }
}

abstract class Figure {
    abstract double area();

}

class Square extends Figure {
    double side;

    Square(double side) {
        this.side = side;
    }
    @Override
    double area() {
        return side * side;
    }
}

class Circle extends Figure {
    double radius;

    Circle(double radius) {
        this.radius = radius;
    }

    @Override
    double area() {
        return Math.PI * radius * radius;
    }


}

/*
// Абстрактная фигура: любая фигура умеет считать свою площадь
abstract class Figure {
    // Абстрактный метод: конкретные фигуры реализуют свою формулу площади
    abstract double area();
}

// Квадрат: хранит длину стороны и считает площадь по формуле side * side
class Square extends Figure {
    double side; // длина стороны квадрата

    Square(double side) {
        this.side = side;
    }

    @Override
    double area() {
        return side * side;
    }
}

// Круг: хранит радиус и считает площадь по формуле PI * r^2
class Circle extends Figure {
    double radius; // радиус круга

    Circle(double radius) {
        this.radius = radius;
    }

    @Override
    double area() {
        return Math.PI * radius * radius;
    }
}
 */