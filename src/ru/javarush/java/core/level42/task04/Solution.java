package ru.javarush.java.core.level42.task04;
/*
Простая сериализация и десериализация
Вы работаете над проектом "Цифровой Гражданин" для футуристического города, где данные каждого жителя должны быть надёжно сохранены и легко доступны.

Создайте класс Person, который будет представлять запись о гражданине, содержащую его имя в переменной citizenName (типа String) и возраст в переменной citizenAge (типа int). Обязательно "пометьте" этот класс так, чтобы его объекты могли быть "заморожены" и "разморожены".

Затем напишите код, который сначала "создаст" нового гражданина с произвольными данными, например, newCitizen. После этого вам нужно будет "заархивировать" его цифровую запись в специальное хранилище, файл под названием "person.ser", используя ObjectOutputStream. На следующем этапе вы должны будете "восстановить" данные этого гражданина из файла "person.ser" обратно в память, получив restoredCitizen с помощью ObjectInputStream.

В завершение, убедитесь, что информация осталась нетронутой, выведя все данные о восстановленном гражданине на экран.

Требования:
•	Класс Person должен быть объявлен с реализацией интерфейса Serializable для поддержки сериализации.
•	Класс Person должен содержать два поля: citizenName типа String и citizenAge типа int.
•	В программе должен быть создан объект Person с произвольными значениями для citizenName и citizenAge.
•	Объект Person должен быть сериализован (записан) в файл с именем "person.ser" с помощью ObjectOutputStream.
•	Объект Person должен быть десериализован (прочитан) из файла "person.ser" с помощью ObjectInputStream и сохранён в переменную restoredCitizen.
•	После десериализации необходимо вывести на экран значения полей citizenName и citizenAge объекта restoredCitizen для проверки сохранности данных.

mport java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        // 1) Создаем нового "гражданина" с произвольными данными
        Person newCitizen = new Person("Alice Johnson", 30);

        // 2) "Замораживаем" (сериализуем) объект в файл person.ser
        // try-with-resources автоматически закроет потоки после использования


        // 3) "Размораживаем" (десериализуем) объект из файла person.ser


        // 4) Проверяем, что данные восстановились корректно — выводим поля

    }
}

// Класс Person помечаем как сериализуемый с помощью интерфейса Serializable
// Так объекты можно "замораживать" (писать в поток) и "размораживать" (читать из потока)
class Person  {
    // Поля согласно требованию
    public String citizenName;
    public int citizenAge;

    public Person(String citizenName, int citizenAge) {
        this.citizenName = citizenName;
        this.citizenAge = citizenAge;
    }
}

 */

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        // 1) Создаем нового "гражданина" с произвольными данными
        Person newCitizen = new Person("Alice Johnson", 30);

        // 2) "Замораживаем" (сериализуем) объект в файл person.ser
        // try-with-resources автоматически закроет потоки после использования
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("person.ser"))) {
            oos.writeObject(newCitizen);
        }


        // 3) "Размораживаем" (десериализуем) объект из файла person.ser
        Person restoredCitizen;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("person.ser"))) {
            restoredCitizen = (Person) ois.readObject();

        }


        // 4) Проверяем, что данные восстановились корректно — выводим поля
        System.out.println(restoredCitizen.citizenName + " " + restoredCitizen.citizenAge);

    }
}

// Класс Person помечаем как сериализуемый с помощью интерфейса Serializable
// Так объекты можно "замораживать" (писать в поток) и "размораживать" (читать из потока)
class Person implements Serializable {
    // Поля согласно требованию
    public String citizenName;
    public int citizenAge;

    public Person(String citizenName, int citizenAge) {
        this.citizenName = citizenName;
        this.citizenAge = citizenAge;
    }
}

/*

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Solution {
    public static void main(String[] args) throws Exception {
        // 1) Создаем нового "гражданина" с произвольными данными
        Person newCitizen = new Person("Alice Johnson", 30);

        // 2) "Замораживаем" (сериализуем) объект в файл person.ser
        // try-with-resources автоматически закроет потоки после использования
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("person.ser"))) {
            oos.writeObject(newCitizen); // Запись объекта в бинарном виде
        }

        // 3) "Размораживаем" (десериализуем) объект из файла person.ser
        Person restoredCitizen;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("person.ser"))) {
            restoredCitizen = (Person) ois.readObject(); // Чтение объекта из файла
        }

        // 4) Проверяем, что данные восстановились корректно — выводим поля
        System.out.println("citizenName: " + restoredCitizen.citizenName);
        System.out.println("citizenAge: " + restoredCitizen.citizenAge);
    }
}

// Класс Person помечаем как сериализуемый с помощью интерфейса Serializable
// Так объекты можно "замораживать" (писать в поток) и "размораживать" (читать из потока)
class Person implements Serializable {
    // Поля согласно требованию
    public String citizenName;
    public int citizenAge;

    public Person(String citizenName, int citizenAge) {
        this.citizenName = citizenName;
        this.citizenAge = citizenAge;
    }
}
 */