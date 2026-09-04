package ru.javarush.java.core.level21.task08;
/*
Фабрика виртуальных питомцев 🐾

Вы создаёте игру-симулятор виртуального питомца, и вам нужен удобный способ создавать новых животных различных видов, просто указывая их имя.
Для начала, определите класс Animal с полем для имени и конструктором, который принимает это имя. Затем создайте "фабричный" интерфейс AnimalFactory с методом, который будет создавать экземпляр Animal по заданному имени. Ваша задача — реализовать переменную этого фабричного интерфейса, используя ссылку на конструктор Animal. С помощью этой фабрики создайте нового питомца по имени "Барсик" и затем выведите его имя на экран, чтобы подтвердить успешное "рождение".

Требования:
•	Необходимо создать класс Animal с приватным полем для имени и конструктором, который принимает имя в качестве параметра.
•	Необходимо объявить интерфейс AnimalFactory с методом, который принимает строку (имя) и возвращает объект типа Animal.
•	Переменная типа AnimalFactory должна быть инициализирована с использованием ссылки на конструктор класса Animal (Animal::new).
•	С помощью переменной AnimalFactory необходимо создать объект Animal с именем "Барсик".
•	После создания объекта Animal с помощью фабрики необходимо вывести имя питомца на экран.

public class Solution {
    public static void main(String[] args) {
        // Инициализируем переменную фабрики ссылкой на конструктор Animal
        // Это короче и нагляднее, чем писать лямбда-выражение (name) -> new Animal(name)


        // Создаем питомца по имени "Барсик" через фабрику


        // Выводим имя питомца, чтобы подтвердить успешное создание

    }
}

 */

public class Solution {
    public static void main(String[] args) {
        // Инициализируем переменную фабрики ссылкой на конструктор Animal
        // Это короче и нагляднее, чем писать лямбда-выражение (name) -> new Animal(name)
        //AnimalFactory newPet0 = petName -> new Animal(petName);
        AnimalFactory factory = Animal::new;

        // Создаем питомца по имени "Барсик" через фабрику
        Animal newPet = factory.createAnimal("Барсик");

        // Выводим имя питомца, чтобы подтвердить успешное создание
        System.out.println(newPet.getName());

//        Animal barsik = new Animal("Барсик");
//        System.out.println(barsik.getName());

    }

}

class Animal {
    private final String name; // Имя питомца
    Animal(String petName) {
        this.name = petName;
    }

    public String getName(){
        return name;
    }
}

@FunctionalInterface
interface AnimalFactory {
    Animal createAnimal(String name);
//    static void createAnimal(String petName) {
//        Animal newAnimal = new Animal(petName);
//    }
}

/*
@FunctionalInterface
interface AnimalFactory {
    // Метод фабрики принимает имя и возвращает новый объект Animal
    Animal create(String name);
}

class Animal {
    private final String name; // Имя питомца

    // Конструктор, принимающий имя питомца
    Animal(String name) {
        this.name = name;
    }

    // Геттер для имени — чтобы можно было вывести его на экран
    public String getName() {
        return name;
    }
}

public class Solution {
    public static void main(String[] args) {
        // Инициализируем переменную фабрики ссылкой на конструктор Animal
        // Это короче и нагляднее, чем писать лямбда-выражение (name) -> new Animal(name)
        AnimalFactory factory = Animal::new;

        // Создаем питомца по имени "Барсик" через фабрику
        Animal pet = factory.create("Барсик");

        // Выводим имя питомца, чтобы подтвердить успешное создание
        System.out.println(pet.getName());
    }
}
 */