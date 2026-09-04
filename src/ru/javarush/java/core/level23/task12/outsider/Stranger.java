package ru.javarush.java.core.level23.task12.outsider;

import ru.javarush.java.core.level23.task12.zoo.Animal;

public class Stranger {
    public static void main(String[] args) {
        Animal animal = new Animal();

        // Ниже — преднамеренная ошибка компиляции:
        //21.07.2026 Закоментировано требуемое решение, приводящее к ошибке компиляции
        //animal.makeSound();
        
    }
}

/*
public class Stranger {
    public static void main(String[] args) {
        Animal animal = new Animal();

        // Ниже — преднамеренная ошибка компиляции:
        animal.makeSound(); // error: makeSound() has protected access in zoo.Animal
    }
}
 */