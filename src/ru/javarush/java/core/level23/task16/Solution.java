package ru.javarush.java.core.level23.task16;
/*
IT-Компания: Программист, который работает и отчитывается

Вы разрабатываете HR-систему для крупной IT-компании, где есть разные типы сотрудников, но у всех есть общие черты и обязанности.
Определите базовую концепцию "работника" через abstract class Worker, который будет иметь строковое поле employeeName и абстрактный метод work(), потому что каждый работник что-то делает.
Теперь определите общее "поведение" для тех, кто должен сдавать отчеты, с помощью interface Reportable с единственным методом report().
Создайте конкретного сотрудника – класс Programmer. Этот Programmer должен не только быть Worker (наследоваться от Worker), но и уметь Reportable (реализовать Reportable).
В методе work() для Programmer пусть выводится "Программист пишет код", а в методе report() — "Программист сдаёт отчёт".
В основном методе main "наймите" нового программиста, то есть создайте объект Programmer, и затем "дайте ему поручение" поработать и сдать отчёт, вызвав у него методы work() и report().
Программа выведет обе строки, демонстрируя, что ваш Programmer успешно выполняет как свои основные рабочие обязанности, так и обязанности по отчетности.

Требования:
•	Должен быть создан абстрактный класс Worker с защищённым или приватным строковым полем employeeName и абстрактным методом work() без реализации.
•	Должен быть создан интерфейс Reportable с единственным методом report() без реализации.
•	Должен быть создан класс Programmer, который наследуется от Worker и реализует интерфейс Reportable.
•	В классе Programmer необходимо реализовать метод work(), который выводит на экран строку "Программист пишет код".
•	В классе Programmer необходимо реализовать метод report(), который выводит на экран строку "Программист сдаёт отчёт".
•	В методе main должен быть создан объект класса Programmer.
•	В методе main у созданного объекта Programmer должны быть вызваны методы work() и report(), чтобы на экран вывелись обе строки.

public class Solution {
    public static void main(String[] args) {
        Programmer programmer = new Programmer("Алиса");

        // Поручаем работу и сдачу отчёта
        programmer.work();
        programmer.report();
    }
}

 */

// Точка входа: "нанимаем" программиста и даём ему задания
public class Solution {
    public static void main(String[] args) {
        Programmer programmer = new Programmer("Алиса");

        // Поручаем работу и сдачу отчёта
        programmer.work();
        programmer.report();
    }
}

abstract class Worker {
    private String employeeName;
    Worker(String hisName) {
        this.employeeName = hisName;
    }
    abstract void work();
}

interface Reportable {
    void report();
}

class Programmer extends Worker implements Reportable {

    Programmer(String name) {
        super(name);
    }

    @Override
    void work() {
        System.out.println("Программист пишет код");
    }

    @Override
    public void report() {
        System.out.println("Программист сдаёт отчёт");
    }
}

/*

// Абстрактный работник: общее для всех сотрудников
abstract class Worker {
    // Имя сотрудника — общее поле для всех наследников
    protected String employeeName;

    // Конструктор для инициализации имени
    protected Worker(String employeeName) {
        this.employeeName = employeeName;
    }

    // Каждый работник должен уметь работать — реализация в наследниках
    public abstract void work();
}

// Поведение для тех, кто должен сдавать отчеты
interface Reportable {
    // Метод без реализации — конкретные классы сами решают, как отчитываться
    void report();
}

// Конкретный сотрудник: Программист
// Он является Worker и умеет Reportable
class Programmer extends Worker implements Reportable {
    public Programmer(String employeeName) {
        super(employeeName);
    }

    @Override
    public void work() {
        // Реализация рабочей обязанности программиста
        System.out.println("Программист пишет код");
    }

    @Override
    public void report() {
        // Реализация обязанности по отчетности
        System.out.println("Программист сдаёт отчёт");
    }
}

// Точка входа: "нанимаем" программиста и даём ему задания
public class Solution {
    public static void main(String[] args) {
        Programmer programmer = new Programmer("Алиса");

        // Поручаем работу и сдачу отчёта
        programmer.work();
        programmer.report();
    }
}

 */