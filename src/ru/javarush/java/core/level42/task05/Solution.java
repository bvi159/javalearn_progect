package ru.javarush.java.core.level42.task05;
/*
Сериализация объекта в бинарный файл
Вы — мастер-ремесленник в волшебной лавке, и только что закончили создание уникального артефакта. Чтобы его характеристики были надёжно записаны и не потерялись, вам нужно внести его в Главный Магический Фолиант.

Создайте класс Product, который будет описывать ваш артефакт, с полями artifactName (String) для его имени и artifactValue (int) для его ценности. Убедитесь, что этот класс может быть "архивирован".

Затем "сотворите" объект вашего артефакта, например, mysticOrb, с любыми выбранными вами именем и ценностью. После этого "запишите" этот объект в бинарный файл под названием "product.bin", используя ObjectOutputStream.

Как только процесс завершится, дайте подтверждение, выведя на экран сообщение "Объект Product сериализован в файл product.bin", чтобы все знали, что артефакт успешно учтён.

Требования:
•	Класс Product должен реализовывать интерфейс Serializable для поддержки сериализации.
•	Класс Product должен содержать два поля: artifactName типа String и artifactValue типа int.
•	В программе должен быть создан объект класса Product с произвольными значениями для artifactName и artifactValue.
•	Объект Product должен быть сериализован и записан в файл с именем "product.bin" с использованием ObjectOutputStream.
•	После успешной сериализации программа должна вывести сообщение "Объект Product сериализован в файл product.bin" на экран.

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

// Класс, описывающий артефакт. Реализует Serializable, чтобы его можно было сериализовать.
class Product {
    // Имя артефакта
    String artifactName;

    // Ценность артефакта
    int artifactValue;

    // Простой конструктор для инициализации полей
    Product(String artifactName, int artifactValue) {
        this.artifactName = artifactName;
        this.artifactValue = artifactValue;
    }
}

public class Solution {
    public static void main(String[] args) {
        // Создаем артефакт с произвольными значениями
        Product mysticOrb = new Product("Mystic Orb", 777);

        // Сериализуем объект в бинарный файл "product.bin"
        // try-with-resources автоматически закроет поток даже при ошибках


        // Сообщение выводим только если сериализация прошла успешно

    }
}

 */

import java.io.*;

// Класс, описывающий артефакт. Реализует Serializable, чтобы его можно было сериализовать.
class Product implements Serializable {
    // Имя артефакта
    String artifactName;

    // Ценность артефакта
    int artifactValue;

    // Простой конструктор для инициализации полей
    Product(String artifactName, int artifactValue) {
        this.artifactName = artifactName;
        this.artifactValue = artifactValue;
    }
}

public class Solution {
    public static void main(String[] args) {
        // Создаем артефакт с произвольными значениями
        Product mysticOrb = new Product("Mystic Orb", 777);

        // Сериализуем объект в бинарный файл "product.bin"
        // try-with-resources автоматически закроет поток даже при ошибках
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("product.bin"))) {
            oos.writeObject(mysticOrb);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        // Сообщение выводим только если сериализация прошла успешно
        System.out.println("Объект Product сериализован в файл product.bin");

    }
}
/*
public class Solution {
    public static void main(String[] args) {
        // Создаем артефакт с произвольными значениями
        Product mysticOrb = new Product("Mystic Orb", 777);

        // Сериализуем объект в бинарный файл "product.bin"
        // try-with-resources автоматически закроет поток даже при ошибках
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("product.bin"))) {
            out.writeObject(mysticOrb); // Записываем объект в поток
        } catch (IOException e) {
            // В учебной задаче не усложняем обработку ошибок
            throw new RuntimeException("Не удалось сериализовать объект Product", e);
        }

        // Сообщение выводим только если сериализация прошла успешно
        System.out.println("Объект Product сериализован в файл product.bin");
    }
}
 */