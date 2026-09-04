package ru.javarush.java.core.level19.task02;
/*
Добавляем собаку в зоопарк 🐶

Продолжая работу над вашим симулятором зоопарка, пришло время добавить в него первого полноценного жителя — преданного пса.

Вам нужно создать класс Dog, который станет конкретным наследником вашего абстрактного класса Animal.

Самое важное — реализовать внутри Dog тот самый метод makeSound() таким образом, чтобы при его вызове на экране гордо появлялось веселое "Гав!".

Требования:
•	Необходимо создать новый класс с именем Dog.
•	Класс Dog должен быть наследником абстрактного класса Animal.
•	В классе Dog должен быть реализован метод makeSound(), унаследованный от Animal.
•	Метод makeSound() в классе Dog должен выводить на экран строку "Гав!".

public class Solution {
    public static void main(String[] args) {
        // Демонстрация работы: полиморфный вызов makeSound()
        Animal dog = new Dog();
        dog.makeSound(); // Ожидаемый вывод: Гав!
    }
}


 */

public class Solution {
    public static void main(String[] args) {
        // Демонстрация работы: полиморфный вызов makeSound()
        Animal dog = new Dog();
        dog.makeSound(); // Ожидаемый вывод: Гав!
    }
}

abstract class Animal {
    abstract void makeSound();
}

class Dog extends Animal {
    @Override
    void makeSound() {
        System.out.println("Гав!");
    }
}




/*
// Абстрактный класс, описывающий общее поведение животных
public abstract class Animal {
    // Абстрактный метод: каждый конкретный вид животного реализует свой звук
    public abstract void makeSound();
}

// Конкретный класс Dog — наследник абстрактного Animal
public class Dog extends Animal {

    @Override
    public void makeSound() {
        // Корректный вывод "Гав!" при вызове makeSound()
        System.out.println("Гав!");
    }
}

 */