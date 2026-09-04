package ru.javarush.java.core.level20.task01;
/*
Добро пожаловать, Протокол Приветствия!

Представьте, что вы создаёте умного домашнего помощника, который должен уметь вежливо приветствовать любого, кто с ним взаимодействует. Для этого вам нужно определить единый стандарт для всех объектов, которые способны произносить приветствия.
Пожалуйста, объявите специальную "способность" под названием Greetable. Эта способность должна включать в себя одно простое действие: greet(), которое не возвращает ничего.
Затем создайте модуль, который будет представлять обычного Person (Человека). Этот модуль Person должен освоить способность Greetable. Когда ваш Person выполняет действие greet(), он должен выводить на экран тёплое сообщение "Hello!".

Требования:
•	В программе должен быть объявлен интерфейс с именем Greetable.
•	Интерфейс Greetable должен содержать один абстрактный метод greet(), который не принимает параметров и не возвращает значение (void).
•	В программе должен быть создан класс с именем Person.
•	Класс Person должен реализовывать интерфейс Greetable.
•	В классе Person должен быть реализован метод greet(), который выводит на экран строку "Hello!".

public class Solution {
    public static void main(String[] args) {
        // Демонстрация работы: создаем человека и просим его поздороваться
        Greetable someone = new Person();
        someone.greet();
    }
}

 */
public class Solution {
    public static void main(String[] args) {
        // Демонстрация работы: создаем человека и просим его поздороваться
        Greetable someone = new Person();
        someone.greet();
    }
}

interface Greetable {
    void greet();
}

class Person implements Greetable {
    @Override
    public void greet() {
        System.out.println("Hello!");
    }
}

/*
// Интерфейс "способности" для тех, кто умеет приветствовать
public interface Greetable {
    // Одно действие: поприветствовать. Ничего не возвращает.
    void greet();
}

// Обычный человек, который умеет приветствовать
public class Person implements Greetable {

    @Override
    public void greet() {
        // Печатаем тёплое приветствие на экран
        System.out.println("Hello!");
    }
}
 */