package ru.javarush.java.core.level20.task04;
/*
Звероферма Виртуальных Питомцев

Представьте, что вы создаёте весёлую игру-симулятор виртуальных питомцев. В этой игре у каждого животного должен быть свой уникальный способ издавать звуки, но при этом вы хотите иметь возможность попросить любое животное "издать звук" общим способом.
Начните с определения универсальной "звуковой способности" под названием Soundable, которая требует от любого объекта реализации метода makeSound(), не возвращающего ничего. Затем оживите двух животных: Dog (Собаку) и Cat (Кошку). Оба этих животных должны освоить Soundable способность. Когда Dog выполняет makeSound(), он должен громко произносить "Woof". Когда Cat выполняет makeSound(), она должна нежно говорить "Meow".
В вашей основной программе создайте "зоопарк" — массив, который может содержать любые объекты, обладающие Soundable способностью. Поместите в этот "зоопарк" одного Dog и одного Cat. Затем пройдитесь по всему вашему "зоопарку" в цикле, по очереди прося каждое животное makeSound(). На экране вы должны увидеть характерные звуки:
Woof

Meow
Требования:
•	Должен быть объявлен интерфейс с именем Soundable.
•	Интерфейс Soundable должен содержать абстрактный метод void makeSound() без параметров.
•	Класс Dog должен реализовывать интерфейс Soundable и переопределять метод makeSound().
•	Класс Cat должен реализовывать интерфейс Soundable и переопределять метод makeSound().
•	В классе Dog метод makeSound() должен выводить на экран строку "Woof".
•	В классе Cat метод makeSound() должен выводить на экран строку "Meow".
•	В основной программе должен быть создан массив, способный хранить объекты типа Soundable.
•	В массив Soundable должны быть добавлены один объект Dog и один объект Cat.
•	В основной программе должен быть цикл, который вызывает метод makeSound() для каждого объекта массива.

public class Solution {
    public static void main(String[] args) {
        // "Зоопарк" — массив, который хранит объекты, умеющие издавать звук
        Soundable[] zoo = new Soundable[2];

        // Добавляем одного Dog и одного Cat
        zoo[0] = new Dog();
        zoo[1] = new Cat();

        // Просим каждое животное по очереди издать звук
        for (Soundable animal : zoo) {
            animal.makeSound();
        }
    }
}

 */

public class Solution {
    public static void main(String[] args) {
        // "Зоопарк" — массив, который хранит объекты, умеющие издавать звук
        Soundable[] zoo = new Soundable[2];

        // Добавляем одного Dog и одного Cat
        zoo[0] = new Dog();
        zoo[1] = new Cat();

        // Просим каждое животное по очереди издать звук
        for (Soundable animal : zoo) {
            animal.makeSound();
        }
    }
}

interface Soundable {
    void makeSound();
}

class Dog implements Soundable {
    @Override
    public void makeSound() {
        System.out.println("Woof");
    }
}

class Cat implements Soundable {
    @Override
    public void makeSound() {
        System.out.println("Meow");
    }
}

/*
// Универсальная "звуковая способность" для любых объектов, умеющих издавать звук
interface Soundable {
    // Абстрактный метод: каждый "звучащий" объект обязан его реализовать
    void makeSound();
}

// Собака реализует способность Soundable
class Dog implements Soundable {
    @Override
    public void makeSound() {
        // Правильный звук собаки
        System.out.println("Woof");
    }
}

// Кошка реализует способность Soundable
class Cat implements Soundable {
    @Override
    public void makeSound() {
        // Правильный звук кошки
        System.out.println("Meow");
    }
}

 */