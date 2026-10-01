package ru.javarush.java.core.level42.task08;
/*
transient-поле и сериализация
Ваш цифровой зоопарк обзавёлся особыми животными, у которых есть свои "секреты", например, их любимое укромное место, которое не должно быть записано в общедоступный "транспортный контейнер" при их перемещении.

Продолжая использовать класс Animal, добавьте в него новое поле secretHidingSpot (String). Это поле должно быть "невидимым" для процесса "упаковки", то есть не сохраняться при сериализации.

В главном методе создайте объект вашего особого питомца, например, mysticalCreature, заполните все его данные, включая секретное место.

Затем упакуйте эти данные для пересылки в файл "animal2.bin" и тут же распакуйте их обратно, получив recoveredCreature.

После распаковки выведите на экран значение поля secretHidingSpot из recoveredCreature. Вы должны увидеть, что оно равно null, и добавьте пояснение: "Secret after deserialization: null", чтобы наглядно продемонстрировать, что этот секрет остался незаписанным и недоступным после транспортировки.

Требования:
•	В классе Animal должно быть объявлено поле secretHidingSpot типа String с модификатором transient.
•	В главном методе должен быть создан объект Animal (например, mysticalCreature), у которого заполнены все поля, включая secretHidingSpot.
•	Объект mysticalCreature должен быть сериализован и записан в файл "animal2.bin" с использованием ObjectOutputStream.
•	Объект должен быть считан обратно из файла "animal2.bin" с помощью ObjectInputStream и присвоен переменной recoveredCreature.
•	После десериализации значение поля secretHidingSpot у recoveredCreature должно быть выведено на экран.
•	В выводе на экран должно присутствовать пояснение: "Secret after deserialization: null".

import java.io.*;

// Демонстрация transient-поля при сериализации/десериализации
public class Solution {
    // Класс Animal поддерживает сериализацию
    public static class Animal {


        String name;
        int age;
        String species;

        // Это поле помечено transient — оно не будет записано в поток при сериализации
        transient String secretHidingSpot;
    }

    public static void main(String[] args) throws Exception {
        // Создаём и заполняем "особое животное"
        Animal mysticalCreature = new Animal();
        mysticalCreature.name = "Shadow Lynx";
        mysticalCreature.age = 7;
        mysticalCreature.species = "Felis mystica";
        mysticalCreature.secretHidingSpot = "Under the old oak"; // секрет, не должен попасть в файл

        // Сериализация объекта в файл "animal2.bin"


        // Десериализация объекта из файла "animal2.bin"


        // transient-поле не сериализуется, поэтому после десериализации оно равно null

    }
}

 */

import java.io.*;

// Демонстрация transient-поля при сериализации/десериализации
public class Solution {
    // Класс Animal поддерживает сериализацию
    public static class Animal implements Serializable {
        String name;
        int age;
        String species;
        // Это поле помечено transient — оно не будет записано в поток при сериализации
        transient String secretHidingSpot;
    }

    public static void main(String[] args) throws Exception {
        // Создаём и заполняем "особое животное"
        Animal mysticalCreature = new Animal();
        mysticalCreature.name = "Shadow Lynx";
        mysticalCreature.age = 7;
        mysticalCreature.species = "Felis mystica";
        mysticalCreature.secretHidingSpot = "Under the old oak"; // секрет, не должен попасть в файл

        // Сериализация объекта в файл "animal2.bin"
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("animal2.bin"))) {
            oos.writeObject(mysticalCreature);
        }


        // Десериализация объекта из файла "animal2.bin"
        Animal recoveredCreature;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("animal2.bin"))) {
            recoveredCreature = (Animal) ois.readObject();
        }

        // transient-поле не сериализуется, поэтому после десериализации оно равно null
        System.out.println("Secret after deserialization: " + recoveredCreature.secretHidingSpot);

    }
}

/*
import java.io.*;

// Демонстрация transient-поля при сериализации/десериализации
public class Solution {
    // Класс Animal поддерживает сериализацию
    public static class Animal implements Serializable {
        private static final long serialVersionUID = 1L;

        String name;
        int age;
        String species;

        // Это поле помечено transient — оно не будет записано в поток при сериализации
        transient String secretHidingSpot;
    }

    public static void main(String[] args) throws Exception {
        // Создаём и заполняем "особое животное"
        Animal mysticalCreature = new Animal();
        mysticalCreature.name = "Shadow Lynx";
        mysticalCreature.age = 7;
        mysticalCreature.species = "Felis mystica";
        mysticalCreature.secretHidingSpot = "Under the old oak"; // секрет, не должен попасть в файл

        // Сериализация объекта в файл "animal2.bin"
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("animal2.bin"))) {
            oos.writeObject(mysticalCreature); // записываем объект в бинарный поток
        }

        // Десериализация объекта из файла "animal2.bin"
        Animal recoveredCreature;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("animal2.bin"))) {
            recoveredCreature = (Animal) ois.readObject(); // читаем объект обратно
        }

        // transient-поле не сериализуется, поэтому после десериализации оно равно null
        System.out.println("Secret after deserialization: " + recoveredCreature.secretHidingSpot);
    }
}
 */