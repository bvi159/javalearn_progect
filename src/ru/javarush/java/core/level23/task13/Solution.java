package ru.javarush.java.core.level23.task13;
/*
Звуки животных: Когда собака гавкает

Вы создаете цифровую звуковую доску для различных животных, но пока не знаете, какой именно звук будет издавать каждое из них. Для этого определите базовую идею животного как abstract class Animal и добавьте в него abstract method makeSound(). Это обяжет каждого "наследника" Animal определить свой собственный уникальный звук.

Теперь, чтобы добавить звук конкретной собаки, создайте класс Dog, который наследуется от Animal. Внутри Dog вы обязаны реализовать метод makeSound(): пусть он выводит на экран "Гав!". В основном блоке программы, в main, "выберите" собаку для своей доски, то есть создайте объект Dog, и затем "нажмите" на кнопку её звука, вызвав makeSound(). Когда вы запустите программу, вы услышите четкое "Гав!", подтверждающее, что собака знает, как именно ей нужно подавать голос.

Требования:
•	В программе должен быть объявлен абстрактный класс с именем Animal.
•	В абстрактном классе Animal должен быть определён абстрактный метод makeSound() без реализации.
•	Должен быть создан класс Dog, который наследуется от класса Animal.
•	Класс Dog обязан реализовать метод makeSound(), который выводит на экран строку "Гав!".
•	В методе main должен быть создан объект класса Dog.
•	В методе main должен быть вызван метод makeSound() для созданного объекта Dog, чтобы на экран вывелось "Га

public class Solution {
    public static void main(String[] args) {
        // Создаём собаку и "нажимаем" на её кнопку звука
        Dog dog = new Dog();
        dog.makeSound();
    }
}


 */

public class Solution {
    public static void main(String[] args) {
        // Создаём собаку и "нажимаем" на её кнопку звука
        Dog dog = new Dog();
        dog.makeSound();
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
// Абстрактный класс задаёт общую идею "животного" и обязательный метод makeSound()
abstract class Animal {
    // Абстрактный метод — каждый наследник обязан определить свой звук
    public abstract void makeSound();
}

// Конкретный класс-собака: знает, как "подавать голос"
class Dog extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Гав!");
    }
}

public class Solution {
    public static void main(String[] args) {
        // Создаём собаку и "нажимаем" на её кнопку звука
        Dog dog = new Dog();
        dog.makeSound();
    }
}
 */