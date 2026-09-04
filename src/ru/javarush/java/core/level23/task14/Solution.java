package ru.javarush.java.core.level23.task14;

/*
Виртуальный холст: Разнообразие фигур 🎨

Вы разрабатываете приложение для рисования, и вам нужно иметь возможность управлять различными геометрическими фигурами.
Создайте базовый абстрактный класс Shape с абстрактным методом printType(), который будет отвечать за вывод названия фигуры. Это обяжет каждую конкретную фигуру "знать" свое имя.
Теперь "нарисуйте" две конкретные фигуры: класс Circle и класс Square, оба они должны наследовать от Shape. В каждом из них реализуйте метод printType(): для Circle он должен выводить "Круг", а для Square – "Квадрат".
Самое интересное: в основном методе main создайте "холст" для ваших фигур — массив, который может хранить объекты типа Shape. Добавьте в этот массив по одному объекту Circle и Square. Затем, используя цикл, "пройдитесь" по каждой фигуре на вашем холсте и "спросите" её, какой она тип, вызывая метод printType(). Программа последовательно выведет "Круг", а затем "Квадрат", демонстрируя, что каждая фигура правильно идентифицирует себя, несмотря на то, что они хранятся в массиве одного общего типа.

Требования:
•	Должен быть создан абстрактный класс с именем Shape.
•	В классе Shape должен быть объявлен абстрактный метод printType без реализации.
•	Должен быть создан класс Circle, который наследует от Shape и реализует метод printType, выводящий "Круг".
•	Должен быть создан класс Square, который наследует от Shape и реализует метод printType, выводящий "Квадрат".
•	В методе main должен быть создан массив, способный хранить объекты типа Shape.
•	В массив должны быть добавлены по одному объекту Circle и Square.
•	В цикле по массиву должен вызываться метод printType для каждого элемента, результатом чего будет вывод "Круг" и "Квадрат" в правильном порядке.

public class Solution {
    public static void main(String[] args) {
        // "Холст" для фигур: массив общего типа Shape (демонстрация полиморфизма)
        Shape[] canvas = new Shape[2];

        // Добавляем по одному объекту каждой конкретной фигуры
        canvas[0] = new Circle();
        canvas[1] = new Square();

        // Проходим по массиву и полиморфно вызываем метод printType()
        for (Shape shape : canvas) {
            shape.printType(); // каждая фигура печатает своё имя
        }
    }
}

 */

public class Solution {
    public static void main(String[] args) {
        // "Холст" для фигур: массив общего типа Shape (демонстрация полиморфизма)
        Shape[] canvas = new Shape[2];

        // Добавляем по одному объекту каждой конкретной фигуры
        canvas[0] = new Circle();
        canvas[1] = new Square();

        // Проходим по массиву и полиморфно вызываем метод printType()
        for (Shape shape : canvas) {
            shape.printType(); // каждая фигура печатает своё имя
        }
    }
}

abstract class Shape {
    abstract void printType();
}

class Circle extends Shape {
    @Override
    public void printType() {
        System.out.println("Круг");
    }
}

class Square extends Shape {
    @Override
    public void printType() {
        System.out.println("Квадрат");
    }
}

/*
// Абстрактный класс, задающий общий контракт для фигур
abstract class Shape {
    // Каждая конкретная фигура обязана уметь напечатать свой тип
    abstract void printType();
}

// Конкретная фигура: Круг
class Circle extends Shape {
    @Override
    public void printType() {
        System.out.println("Круг");
    }
}

// Конкретная фигура: Квадрат
class Square extends Shape {
    @Override
    public void printType() {
        System.out.println("Квадрат");
    }
}

public class Solution {
    public static void main(String[] args) {
        // "Холст" для фигур: массив общего типа Shape (демонстрация полиморфизма)
        Shape[] canvas = new Shape[2];

        // Добавляем по одному объекту каждой конкретной фигуры
        canvas[0] = new Circle();
        canvas[1] = new Square();

        // Проходим по массиву и полиморфно вызываем метод printType()
        for (Shape shape : canvas) {
            shape.printType(); // каждая фигура печатает своё имя
        }
    }
}
 */