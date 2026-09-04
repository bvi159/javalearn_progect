package ru.javarush.java.core.level17.task16;
/*
Зоологическая энциклопедия: Особенности кошек 🐈

Вы создаёте интерактивную зоологическую энциклопедию, которая должна подробно описывать различные виды животных, их общие черты и уникальные особенности. Вам предстоит построить сложную иерархию классов.
Начните с базового класса Animal. У каждого животного есть String animalName и метод void eat(), который выводит "<имя животного> ест.".
Далее создайте класс Mammal, который будет наследовать от Animal. Добавьте в него уникальный метод void feedMilk(), который выводит "<имя животного> кормит детёнышей молоком.", подчеркивая особенность млекопитающих.
Теперь создайте класс Cat, который будет наследовать от Mammal. Кошки имеют свои пищевые привычки, поэтому переопределите метод eat() так, чтобы он выводил "<имя животного> ест рыбу.". Кроме того, добавьте в класс Cat новый уникальный метод void purr(), который выводит "<имя животного> мурлычет.".
В вашем основном методе main создайте объект Cat. Дайте ему имя "Мурка", присвоив это значение полю animalName. Затем продемонстрируйте все её способности и особенности, вызвав методы eat(), feedMilk() и purr(). Ваша энциклопедия должна детально представить:
Мурка ест рыбу.
Мурка кормит детёнышей молоком.
Мурка мурлычет.
Требования:
•	Необходимо создать класс Animal с полем String animalName и методом void eat(), который выводит "<имя животного> ест.".
•	Класс Mammal должен наследовать Animal и содержать уникальный метод void feedMilk(), который выводит "<имя животного> кормит детёнышей молоком.".
•	Класс Cat должен наследовать Mammal.
•	В классе Cat необходимо переопределить метод eat() так, чтобы он выводил "<имя животного> ест рыбу.".
•	В классе Cat необходимо реализовать метод void purr(), который выводит "<имя животного> мурлычет.".
•	В методе main необходимо создать объект Cat, присвоить его полю animalName значение "Мурка".
•	В методе main необходимо вызвать для объекта Cat методы eat(), feedMilk() и purr() - вывод должен соответствовать требованиям задачи.

public class Solution {
    public static void main(String[] args) {
        // Создаем кошку и задаем ей имя
        Cat cat = new Cat();
        cat.animalName = "Мурка";

        // Демонстрируем все способности: переопределенный eat, уникальный feedMilk и purr
        cat.eat();
        cat.feedMilk();
        cat.purr();
    }
}

 */
public class Solution {
    public static void main(String[] args) {
        // Создаем кошку и задаем ей имя
        Cat cat = new Cat();
        cat.animalName = "Мурка";

        // Демонстрируем все способности: переопределенный eat, уникальный feedMilk и purr
        cat.eat();
        cat.feedMilk();
        cat.purr();
    }
}

class Animal {
    String animalName;

    void eat() {
        System.out.println(animalName + " ест.");
    }
}

class Mammal extends Animal {
    void feedMilk() {
        System.out.println(animalName + " кормит детёнышей молоком.");
    }
}

class Cat extends Mammal {
    @Override
    void eat() {
        System.out.println(animalName + " ест рыбу.");
    }

    void purr() {
        System.out.println(animalName + " мурлычет.");
    }
}

/*
// Базовый класс Animal: у каждого животного есть имя и умение есть
class Animal {
    String animalName;

    void eat() {
        System.out.println(animalName + " ест.");
    }
}

// Класс Mammal наследует Animal и добавляет уникальный метод кормления молоком
class Mammal extends Animal {
    void feedMilk() {
        System.out.println(animalName + " кормит детёнышей молоком.");
    }
}

// Класс Cat наследует Mammal, переопределяет прием пищи и добавляет мурлыканье
class Cat extends Mammal {
    @Override
    void eat() {
        // Пищевые привычки кошек: они едят рыбу
        System.out.println(animalName + " ест рыбу.");
    }

    void purr() {
        System.out.println(animalName + " мурлычет.");
    }
}

public class Solution {
    public static void main(String[] args) {
        // Создаем кошку и задаем ей имя
        Cat cat = new Cat();
        cat.animalName = "Мурка";

        // Демонстрируем все способности: переопределенный eat, уникальный feedMilk и purr
        cat.eat();
        cat.feedMilk();
        cat.purr();
    }
}
 */