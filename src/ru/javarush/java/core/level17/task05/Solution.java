package ru.javarush.java.core.level17.task05;
/*

Виртуальный художник: Как рисовать круг 🎨

Представьте, что вы создаёте простую программу для рисования, где каждая фигура знает, как себя изобразить. Начните с общего шаблона для всех рисуемых объектов: класса Shape. Этот класс Shape должен содержать метод void draw(), который по умолчанию выводит на экран "Drawing a shape", показывая, что происходит общее рисование.
Теперь перейдём к более конкретной фигуре — кругу. Создайте класс Circle, который будет наследовать от Shape. Но круг рисуется по-особому! Поэтому вам нужно переопределить метод draw() в классе Circle так, чтобы он выводил специфичную для круга строку "Drawing a circle".
В вашем основном методе main создайте объект Circle и затем попросите его нарисовать себя, вызвав метод draw(). Ваша программа-художник должна чётко показать: "Drawing a circle".

Требования:
•	Необходимо создать класс с именем Shape.
•	Класс Shape должен содержать публичный метод void draw(), который выводит на экран строку "Drawing a shape".
•	Необходимо создать класс Circle, который наследует класс Shape.
•	В классе Circle должен быть переопределён метод draw(), который выводит на экран строку "Drawing a circle".
•	В переопределённом методе draw() класса Circle должна быть использована аннотация @Override.
•	В методе main необходимо создать объект класса Circle и вызвать у него метод draw(), чтобы на экран вывелась строка "Drawing a circle".

public class Solution {
    public static void main(String[] args) {
        // Создаем объект круга и просим его нарисовать себя
        Circle circle = new Circle();
        circle.draw(); // Ожидаемый вывод: "Drawing a circle"
    }
}

 */

public class Solution {
    public static void main(String[] args) {
        // Создаем объект круга и просим его нарисовать себя
        Circle circle = new Circle();
        circle.draw(); // Ожидаемый вывод: "Drawing a circle"
    }
}

class Shape {
    public void draw() {
        System.out.println("Drawing a shape");
    }
}

class Circle extends Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a circle");
    }
}

/*
// Базовый класс для всех фигур
class Shape {
    // Публичный метод рисования по умолчанию для любой фигуры
    public void draw() {
        System.out.println("Drawing a shape");
    }
}

// Конкретная фигура — круг, наследуется от Shape
class Circle extends Shape {
    @Override // Аннотация подсказывает компилятору, что метод переопределяется
    public void draw() {
        // Специфичная для круга реализация рисования
        System.out.println("Drawing a circle");
    }
}
 */