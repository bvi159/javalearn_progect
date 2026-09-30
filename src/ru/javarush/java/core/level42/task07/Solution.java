package ru.javarush.java.core.level42.task07;
/*
Сериализуем простой объект
Вы — главный зоотехник в цифровом зоопарке, и вам нужно сделать «цифровые слепки» ваших питомцев, чтобы можно было безопасно перенести их данные на новый сервер или создать резервную копию.

Создайте класс Animal, который будет описывать любое животное, с полями animalName (String) для имени и animalAge (int) для возраста. «Пометьте» этот класс так, чтобы его объекты можно было «замораживать».

В главном методе вашей программы «создайте» своего первого цифрового питомца, например, myPet, присвоив ему имя и возраст по вашему выбору.

Затем «упакуйте» данные о нём в специальный «транспортный контейнер» — файл "animal.bin", используя ObjectOutputStream вместе с FileOutputStream.

Как только процесс «упаковки» завершится, выведите на экран сообщение "Animal object serialized", чтобы убедиться, что информация о вашем питомце готова к безопасному перемещению.

Требования:
•	Класс Animal должен реализовывать интерфейс Serializable для возможности сериализации его объектов.
•	Класс Animal должен содержать два поля: animalName типа String и animalAge типа int.
•	В главном методе программы должен быть создан объект Animal с заданными именем и возрастом.
•	Объект Animal должен быть сериализован (записан) в файл с именем "animal.bin" с помощью ObjectOutputStream и FileOutputStream.
•	После успешной сериализации объекта Animal на экран должно быть выведено сообщение "Animal object serialized".

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Solution {
    public static void main(String[] args) {
        // Создаем первого "цифрового питомца"
        Animal myPet = new Animal("Барсик", 4);

        // Сериализуем объект myPet в файл "animal.bin"
        // Используем ObjectOutputStream вместе с FileOutputStream

    }
}

// Класс Animal "помечаем" как сериализуемый, чтобы его объекты можно было записывать в файл
class Animal{
    String animalName; // имя животного
    int animalAge;     // возраст животного

    // Простой конструктор для инициализации полей
    Animal(String animalName, int animalAge) {
        this.animalName = animalName;
        this.animalAge = animalAge;
    }
}

 */

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        // Создаем первого "цифрового питомца"
        Animal myPet = new Animal("Барсик", 4);

        // Сериализуем объект myPet в файл "animal.bin"
        // Используем ObjectOutputStream вместе с FileOutputStream
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("animal.bin"))) {
            oos.writeObject(myPet);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Animal object serialized");

    }
}

// Класс Animal "помечаем" как сериализуемый, чтобы его объекты можно было записывать в файл
class Animal implements Serializable {
    String animalName; // имя животного
    int animalAge;     // возраст животного

    // Простой конструктор для инициализации полей
    Animal(String animalName, int animalAge) {
        this.animalName = animalName;
        this.animalAge = animalAge;
    }
}
/*
public class Solution {
    public static void main(String[] args) {
        // Создаем первого "цифрового питомца"
        Animal myPet = new Animal("Барсик", 4);

        // Сериализуем объект myPet в файл "animal.bin"
        // Используем ObjectOutputStream вместе с FileOutputStream
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("animal.bin"))) {
            oos.writeObject(myPet); // Записываем объект в бинарный файл
            // Сообщение выводим после успешной записи
            System.out.println("Animal object serialized");
        } catch (IOException e) {
            // Для учебной задачи достаточно вывести стек исключения
            e.printStackTrace();
        }
    }
}

// Класс Animal "помечаем" как сериализуемый, чтобы его объекты можно было записывать в файл
class Animal implements Serializable {
    String animalName; // имя животного
    int animalAge;     // возраст животного

    // Простой конструктор для инициализации полей
    Animal(String animalName, int animalAge) {
        this.animalName = animalName;
        this.animalAge = animalAge;
    }
}
 */