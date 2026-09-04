package ru.javarush.java.core.level20.task09;
/*
Цифровой Холст: Рисовать и Стирать

Вы разрабатываете продвинутый графический редактор, и вам нужно создать объекты, которые не только могут быть нарисованы, но и легко стёрты с виртуального холста.
Сначала определите два отдельных художественных контракта: Drawable (Рисуемый) с методом void draw() (рисовать) и Erasable (Стираемый) с методом void erase() (стирать). Затем создайте класс Sketch (Набросок). Этот Sketch должен быть универсальным объектом, который может выполнять действия обоих контрактов.
Реализуйте методы: когда Sketch получает команду draw(), он должен выводить на экран "Рисунок создан". А когда ему приказывают erase(), он должен сообщать "Рисунок стёрт".

Требования:
•	Необходимо создать интерфейс Drawable с методом void draw() без реализации.
•	Необходимо создать интерфейс Erasable с методом void erase() без реализации.
•	Класс Sketch должен реализовывать оба интерфейса: Drawable и Erasable.
•	Метод draw класса Sketch должен выводить на экран строку "Рисунок создан".
•	Метод erase класса Sketch должен выводить на экран строку "Рисунок стёрт".

public class Solution {
    public static void main(String[] args) {
        // Создаём универсальный объект, который умеет выполнять оба контракта
        Sketch sketch = new Sketch();

        // Демонстрация работы: сначала рисуем, затем стираем
        sketch.draw();
        sketch.erase();
    }
}

 */

public class Solution {
    public static void main(String[] args) {
        // Создаём универсальный объект, который умеет выполнять оба контракта
        Sketch sketch = new Sketch();

        // Демонстрация работы: сначала рисуем, затем стираем
        sketch.draw();
        sketch.erase();
    }
}

interface Drawable {
    void draw();
}

interface Erasable {
    void erase();
}

class Sketch implements Drawable, Erasable {
    @Override
    public void draw() {
        System.out.println("Рисунок создан");
    }

    @Override
    public void erase() {
        System.out.println("Рисунок стёрт");
    }
}

/*

// Класс Sketch реализует оба интерфейса и тем самым умеет и рисовать, и стирать
public class Sketch implements Drawable, Erasable {

    @Override
    public void draw() {
        // Сообщение при выполнении команды "рисовать"
        System.out.println("Рисунок создан");
    }

    @Override
    public void erase() {
        // Сообщение при выполнении команды "стереть"
        System.out.println("Рисунок стёрт");
    }
}

// "Художественный контракт": любой, кто реализует этот интерфейс, умеет рисовать
public interface Drawable {
    void draw(); // Метод без реализации
}

// Второй "художественный контракт": любой, кто реализует этот интерфейс, умеет стирать
public interface Erasable {
    void erase(); // Метод без реализации
}




 */