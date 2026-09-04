package ru.javarush.java.core.level17.task20;
/*
Звериные повадки: Спящая кошка 🐱💤

Вы разрабатываете модуль для симуляции поведения животных, где каждое животное может издавать звуки и спать. Начните с класса Animal. В нём реализуйте метод void makeSound(), который выводит "Some sound". Также создайте метод void sleep(), который сначала выводит "Animal is going to sleep..." и затем вызывает makeSound() (то есть, this.makeSound()). Это означает, что животное может издавать какой-то звук перед сном.
Теперь создайте класс Cat, который наследует от Animal. Кошки имеют свой уникальный звук! Переопределите метод makeSound() в классе Cat, чтобы он выводил "Meow!".
В вашем основном методе main объявите переменную типа Animal, но присвойте ей экземпляр класса Cat (то есть, Animal mysteriousCreature = new Cat();). Затем вызовите метод sleep() у объекта mysteriousCreature.
Не запуская код, попробуйте предсказать, какой именно звук будет издан, когда sleep() вызовет makeSound(): общий "Some sound" или специфичное "Meow!"? Этот пример прекрасно иллюстрирует принцип полиморфизма и динамического связывания, когда поведение определяется фактическим типом объекта во время выполнения.

Требования:
•	Должен быть создан класс Animal.
•	Класс Animal должен содержать метод void makeSound(), который выводит на экран "Some sound".
•	Класс Animal должен содержать метод void sleep(), который сначала выводит на экран "Animal is going to sleep...", а затем вызывает метод makeSound() (через this.makeSound()).
•	Должен быть создан класс Cat, который наследуется от Animal.
•	Класс Cat должен переопределять метод makeSound() и выводить на экран "Meow!".
•	В методе main должна быть объявлена переменная типа Animal, которой присваивается экземпляр класса Cat (Animal mysteriousCreature = new Cat();).
•	В методе main у объекта mysteriousCreature должен быть вызван метод sleep().
•	При вызове sleep() у mysteriousCreature метод makeSound() должен вызываться из класса Cat, а не из Animal, то есть на экран должно выводиться "Meow!".

public class Solution {
    public static void main(String[] args) {
        // Полиморфизм: ссылка типа Animal указывает на объект фактического типа Cat
        Animal mysteriousCreature = new Cat();

        // Вызов sleep() приведёт к вызову Cat.makeSound() благодаря динамическому связыванию
        mysteriousCreature.sleep();
    }
}

 */
public class Solution {
    public static void main(String[] args) {
        // Полиморфизм: ссылка типа Animal указывает на объект фактического типа Cat
        Animal mysteriousCreature = new Cat();

        // Вызов sleep() приведёт к вызову Cat.makeSound() благодаря динамическому связыванию
        mysteriousCreature.sleep();
    }
}

class Animal {
    void makeSound() {
        System.out.println("Some sound");
    }

    void sleep() {
        System.out.println("Animal is going to sleep...");
        this.makeSound();
    }
}

class Cat extends Animal {
    @Override
    void makeSound() {
        System.out.println("Meow!");
    }
}

/*
// Базовый класс Animal: умеет издавать звук и "засыпать"
class Animal {
    void makeSound() {
        System.out.println("Some sound");
    }

    void sleep() {
        System.out.println("Animal is going to sleep...");
        // Вызов через this гарантирует динамическое связывание:
        // будет вызван makeSound() фактического типа объекта (Cat), а не базового (Animal)
        this.makeSound();
    }
}

// Класс-наследник Cat: переопределяет звук на "Meow!"
class Cat extends Animal {
    @Override
    void makeSound() {
        System.out.println("Meow!");
    }
}
 */