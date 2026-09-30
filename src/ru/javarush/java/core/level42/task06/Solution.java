package ru.javarush.java.core.level42.task06;
/*
Десериализация объекта из бинарного файла
Представьте, что вы — хранитель древних свитков в огромной исторической библиотеке, и ваша задача — восстанавливать забытые записи о великих личностях прошлого.

Для начала, чтобы подготовить тестовую запись, создайте класс Person с полями historianName (String) для имени и historianAge (int) для возраста. Убедитесь, что этот класс можно "заархивировать".

Сначала "зафиксируйте" данные о какой-либо исторической личности, создав объект historicalFigure, и "архивируйте" эту запись в файл "person.bin".

Затем, как будто спустя годы, в отдельном разделе вашего кода, "извлеките" эту же запись из файла "person.bin" с помощью ObjectInputStream в объект recoveredFigure.

В конце вам нужно будет громко объявить всем присутствующим, что вам удалось восстановить информацию, выведя на экран строку в формате: "Прочитано: [имя], [возраст]", где вместо [имя] и [возраст] подставьте значения полей из вашего восстановленного объекта.

Требования:
•	Класс Person должен реализовывать интерфейс Serializable для поддержки сериализации и десериализации.
•	Класс Person должен содержать два поля: historianName типа String и historianAge типа int.
•	Объект класса Person (historicalFigure) должен быть сохранён в файл "person.bin" с помощью ObjectOutputStream.
•	Объект класса Person должен быть прочитан из файла "person.bin" с помощью ObjectInputStream и сохранён в переменную recoveredFigure.
•	После десериализации на экран должна быть выведена строка в формате "Прочитано: [имя], [возраст]", где [имя] и [возраст] — значения полей recoveredFigure.


import java.io.*;

// Решение задачи: сериализация и десериализация объекта Person в бинарный файл
public class Solution {

    // Класс Person "сериализуемый" — реализует Serializable
    public static class Person  {
        // Поля по требованию задачи
        String historianName;
        int historianAge;

        public Person(String historianName, int historianAge) {
            this.historianName = historianName;
            this.historianAge = historianAge;
        }
    }

    public static void main(String[] args) throws Exception {
        // 1) Создаем объект исторической личности
        Person historicalFigure = new Person("Геродот", 35);

        // 2) Сериализуем (архивируем) объект в файл person.bin


        // 3) Десериализуем (извлекаем) объект из файла person.bin


        // 4) Выводим результат в требуемом формате

    }
}

 */

import java.io.*;

// Решение задачи: сериализация и десериализация объекта Person в бинарный файл
public class Solution {

    // Класс Person "сериализуемый" — реализует Serializable
    public static class Person implements Serializable {
        // Поля по требованию задачи
        String historianName;
        int historianAge;

        public Person(String historianName, int historianAge) {
            this.historianName = historianName;
            this.historianAge = historianAge;
        }
    }

    public static void main(String[] args) throws Exception {
        // 1) Создаем объект исторической личности
        Person historicalFigure = new Person("Геродот", 35);

        // 2) Сериализуем (архивируем) объект в файл person.bin
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("person.bin"))) {
            oos.writeObject(historicalFigure);
        }

        // 3) Десериализуем (извлекаем) объект из файла person.bin
        Person recoveredFigure;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("person.bin"))) {
            recoveredFigure = (Person) ois.readObject();
        }

        // 4) Выводим результат в требуемом формате
        System.out.println("Прочитано: " + recoveredFigure.historianName + ", " + recoveredFigure.historianAge);

    }
}
/*
// Решение задачи: сериализация и десериализация объекта Person в бинарный файл
public class Solution {

    // Класс Person "сериализуемый" — реализует Serializable
    public static class Person implements Serializable {
        // Поля по требованию задачи
        String historianName;
        int historianAge;

        public Person(String historianName, int historianAge) {
            this.historianName = historianName;
            this.historianAge = historianAge;
        }
    }

    public static void main(String[] args) throws Exception {
        // 1) Создаем объект исторической личности
        Person historicalFigure = new Person("Геродот", 35);

        // 2) Сериализуем (архивируем) объект в файл person.bin
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("person.bin"))) {
            out.writeObject(historicalFigure);
        }

        // 3) Десериализуем (извлекаем) объект из файла person.bin
        Person recoveredFigure;
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("person.bin"))) {
            recoveredFigure = (Person) in.readObject(); // Читаем и приводим к типу Person
        }

        // 4) Выводим результат в требуемом формате
        System.out.println("Прочитано: " + recoveredFigure.historianName + ", " + recoveredFigure.historianAge);
    }
}
 */
