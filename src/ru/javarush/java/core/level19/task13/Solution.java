package ru.javarush.java.core.level19.task13;
/*
Расчеты площади в графическом приложении 🎨

Вы работаете над графическим приложением, где важно уметь вычислять площади различных фигур. Вам нужна общая концепция для всех фигур, но способ вычисления площади для каждой — свой.
Для начала, вам нужен общий шаблон для всех фигур. Поэтому объявите абстрактный класс Shape с абстрактным методом area(), который должен возвращать значение типа double, представляющее площадь.
Затем приступайте к созданию вашей первой конкретной фигуры — Circle. Этот класс должен наследовать Shape и иметь собственное поле double radius.
Внутри Circle реализуйте метод area() таким образом, чтобы он возвращал площадь круга по формуле 3.14 * radius * radius.

Чтобы проверить, как работает ваша логика, в методе main создайте объект Circle с радиусом 2.0. После этого вызовите у этого объекта метод area() и выведите полученный результат на экран. Вы должны увидеть число 12.56, что подтвердит правильность вычислений.

Требования:
•	В программе должен быть объявлен абстрактный класс с именем Shape.
•	В абстрактном классе Shape должен быть определён абстрактный метод area, возвращающий значение типа double.
•	В программе должен быть создан класс Circle, который наследует абстрактный класс Shape.
•	Класс Circle должен содержать поле типа double с именем radius.
•	Класс Circle должен реализовывать метод area, который возвращает результат вычисления площади круга по формуле 3.14 * radius * radius.
•	В методе main должен быть создан объект класса Circle с радиусом 2.0.
•	В методе main необходимо вызвать метод area у созданного объекта Circle и вывести полученное значение на экран.
•	В результате работы программы на экран должно быть выведено число 12.56.

public class Solution {
    public static void main(String[] args) {
        // Создаём круг радиуса 2.0
        Circle circle = new Circle(2.0);

        // Выводим площадь. Ожидаем увидеть 12.56
        System.out.println(circle.area());
    }
}

 */

public class Solution {
    public static void main(String[] args) {
        // Создаём круг радиуса 2.0
        Circle circle = new Circle(2.0);

        // Выводим площадь. Ожидаем увидеть 12.56
        System.out.println(circle.area());
    }
}

abstract class Shape {
    abstract double area();
}

class Circle extends Shape{
    double radius;
    Circle(double radius) {
        this.radius = radius;
    }
    @Override
    double area() {
        return 3.14 * radius * radius;
    }
}



/*
// Абстрактный класс — общий шаблон для всех фигур
abstract class Shape {
    // Абстрактный метод должен вернуть площадь фигуры
    public abstract double area();
}

// Конкретная фигура — круг
class Circle extends Shape {
    double radius; // радиус круга

    // Простой конструктор для инициализации радиуса
    Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double area() {
        // По условию используем 3.14 вместо Math.PI
        return 3.14 * radius * radius;
    }
}

public class Solution {
    public static void main(String[] args) {
        // Создаём круг радиуса 2.0
        Circle circle = new Circle(2.0);

        // Выводим площадь. Ожидаем увидеть 12.56
        System.out.println(circle.area());
    }
}

 */