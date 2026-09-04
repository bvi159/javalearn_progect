package ru.javarush.java.core.level21.task10;
/*
Поведение разных животных в зоопарке 🐕

Вы расширяете симулятор виртуального зоопарка. У всех животных есть общие характеристики, такие как способность издавать звуки voice() и спать sleep(). Однако, хотя сон для всех животных общий ("Animal is sleeping"), каждое животное спит по-своему, и уж точно издаёт уникальный звук.

Создайте интерфейс Animal с абстрактным методом voice() и default-методом sleep(), который выводит "Animal is sleeping". Затем определите класс Dog, который реализует интерфейс Animal. В классе Dog реализуйте метод voice() так, чтобы он выводил "Woof". Самое интересное: переопределите default-метод sleep() в классе Dog, чтобы он выводил "Dog is sleeping", показывая, что собака спит по-своему. В главной части программы создайте объект Dog и вызовите у него оба метода, чтобы увидеть уникальные проявления его поведения.

Требования:
•	Необходимо создать интерфейс с именем Animal.
•	Интерфейс Animal должен содержать абстрактный метод voice() без реализации.
•	В интерфейсе Animal должен быть реализован default-метод sleep(), который выводит строку "Animal is sleeping".
•	Необходимо создать класс Dog, который реализует интерфейс Animal.
•	В классе Dog должен быть реализован метод voice(), который выводит строку "Woof".
•	В классе Dog должен быть переопределен метод sleep(), который выводит строку "Dog is sleeping".
•	В главном методе программы необходимо создать объект класса Dog и вызвать у него методы voice() и sleep().

public class Solution {
    public static void main(String[] args) {
        // Создаем объект Dog и вызываем его методы
        Dog dog = new Dog();
        dog.voice();
        dog.sleep();
    }
}

 */
public class Solution {
    public static void main(String[] args) {
        // Создаем объект Dog и вызываем его методы
        Dog dog = new Dog();
        dog.voice();
        dog.sleep();
    }
}

interface Animal {
    void voice();

    default void sleep() {
        System.out.println("Animal is sleeping");
    }
}

class Dog implements Animal {
    @Override
    public void voice() {
        System.out.println("Woof");
    }

    @Override
    public void sleep() {
        System.out.println("Dog is sleeping");
    }
}

/*
// Интерфейс Animal описывает общее поведение всех животных
interface Animal {
    void voice(); // абстрактный метод без реализации

    // default-метод с реализацией по умолчанию
    default void sleep() {
        System.out.println("Animal is sleeping");
    }
}

// Класс Dog реализует интерфейс Animal и задает собственное поведение
class Dog implements Animal {

    @Override
    public void voice() {
        System.out.println("Woof");
    }

    // Переопределяем default-метод из интерфейса,
    // чтобы показать уникальное поведение собаки
    @Override
    public void sleep() {
        System.out.println("Dog is sleeping");
    }
}

 */