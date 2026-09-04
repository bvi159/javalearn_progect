package ru.javarush.java.core.level20.task06;
/*
Университетский Реестр: Личности и Идентификаторы

Представьте, что вы создаёте сложную систему для управления персоналом и студентами в университете. Каждый человек в этой системе обладает общими характеристиками, но студенты, помимо этого, имеют уникальный идентификатор, который является универсальным для всех учащихся.

Во-первых, определите универсальный "идентификационный контракт" под названием Identifiable (Идентифицируемый), который гарантирует, что у каждого объекта, соответствующего этому контракту, будет фиксированный ID с типом int и значением 42. Важно понимать, почему такое поле в интерфейсе должно быть константой.

Во-вторых, создайте общий "шаблон личности" в виде абстрактного класса Person (Человек). У Person будет изменяемое поле name (имя) типа String, которое вы сможете задать через конструктор. Здесь также важно понять, почему поле в абстрактном классе может быть обычным, а не константой, в отличие от интерфейса.

Наконец, создайте конкретный класс Student (Студент). Student должен быть одновременно и Person (наследуя общие черты человека), и Identifiable (обладая уникальным идентификатором). В конструкторе Student вы должны задать его имя. Добавьте в Student метод printInfo(), который будет выводить на экран имя студента и его универсальный ID.

Требования:
•	Необходимо создать интерфейс Identifiable, который содержит константу int ID со значением 42.
•	Поле ID в интерфейсе Identifiable должно быть объявлено как public static final, чтобы оно было константой, доступной всем реализующим классам.
•	Необходимо создать абстрактный класс Person с изменяемым полем name типа String, которое инициализируется через конструктор.
•	Класс Student должен наследовать абстрактный класс Person и реализовывать интерфейс Identifiable.
•	В классе Student должен быть конструктор, который принимает имя студента и передает его в конструктор класса Person.
•	Класс Student должен содержать метод printInfo(), который выводит на экран имя студента и его универсальный ID.

public class Solution {
    public static void main(String[] args) {
        // Пример использования:
        Student student = new Student("Иван Петров");
        student.printInfo(); // выведет имя и ID
    }
}
 */
public class Solution {
    public static void main(String[] args) {
        // Пример использования:
        Student student = new Student("Иван Петров");
        student.printInfo(); // выведет имя и ID
    }
}

interface Identifiable {
    public final static int ID = 42;
}

abstract class Person {
    String name;
    Person(String name) {
        this.name = name;
    }
}

class Student extends Person implements Identifiable {
    Student(String studentName) {
       super(studentName);
    }

    void printInfo() {
        System.out.println(name + ID);
    }
}

/*

// "Идентификационный контракт": у каждого, кто реализует этот интерфейс, есть универсальный ID.
interface Identifiable {
    public static final int ID = 42; // явно указываем модификаторы по требованию задачи
}

// Абстрактный шаблон "Личность": у каждого человека есть имя.
abstract class Person {
    private String name;

    public Person(String name) {
        this.name = name;
    }

    // Геттер и сеттер подчеркивают, что поле можно менять
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

// Конкретный класс Student наследует общие свойства Person и реализует контракт Identifiable.
class Student extends Person implements Identifiable {
    public Student(String name) {
        super(name); // передаем имя в конструктор базового класса Person
    }

    // Выводит имя студента и универсальный ID (общий для всех студентов)
    public void printInfo() {
        // ID — константа интерфейса Identifiable, getName — из абстрактного класса Person
        System.out.println("Студент: " + getName() + ", ID: " + ID);
    }
}

 */