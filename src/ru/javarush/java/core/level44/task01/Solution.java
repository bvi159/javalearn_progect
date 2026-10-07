package ru.javarush.java.core.level44.task01;
/*
Цифровая картотека личных данных 🏢
Представьте, что вы разрабатываете цифровую базу данных для крупной организации, где хранятся личные дела сотрудников. Каждое личное дело должно содержать базовую информацию о человеке и его актуальный адрес. Чтобы обеспечить надежное сохранение и последующее восстановление этих данных, вам необходимо использовать механизм сериализации.

Для начала создайте два класса: Address для хранения сведений об адресе и Person для сбора информации о человеке. В классе Address предусмотрите поля для названия города (city) и улицы (street), оба строкового типа. Затем в классе Person вам понадобятся поля для имени (name) типа String, возраста (age) типа int, и, самое главное, ссылку на объект Address (address), который будет хранить место жительства человека. Крайне важно, чтобы оба класса, и Address, и Person, реализовали интерфейс Serializable, ведь только так Java сможет их "упаковать" и "распаковать".

Далее, в вашем основном методе main, создайте экземпляр класса Person, заполните все его поля, включая вложенный объект Address, например, данными о вымышленном сотруднике. После этого используйте механизм сериализации, чтобы "упаковать" этот объект Person и сохранить его в файл с именем "person.ser". Завершив сохранение, представьте, что программу перезапустили, и вам нужно восстановить данные: десериализуйте объект обратно из файла "person.ser". В конце, чтобы убедиться, что все данные сохранились корректно, включая информацию об адресе, выведите значения всех полей восстановленного объекта Person и его вложенного объекта Address на экран.

Требования:
•	Класс Address должен быть объявлен и содержать два поля: city и street, оба типа String.
•	Класс Person должен быть объявлен и содержать три поля: name (String), age (int), address (Address).
•	Оба класса, Address и Person, должны реализовывать интерфейс Serializable.
•	В классе Person поле address должно быть ссылкой на объект Address.
•	В методе main должен быть создан экземпляр класса Person, у которого заполнены все поля, включая вложенный объект Address.
•	Экземпляр класса Person должен быть сериализован и сохранён в файл "person.ser" с помощью ObjectOutputStream.
•	Объект Person должен быть десериализован из файла "person.ser" с помощью ObjectInputStream.
•	После десериализации значения всех полей объекта Person и его вложенного объекта Address должны быть выведены на экран.

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        // 1) Создаем и заполняем вложенный объект Address
        Address address = new Address();
        address.city = "Нортвуд";
        address.street = "Центральная, 10";

        // 2) Создаем и заполняем объект Person, включая адрес
        Person person = new Person();
        person.name = "Алекс Мортон";
        person.age = 30;
        person.address = address;

        // 3) Сериализация объекта Person в файл "person.ser"
        // try-with-resources автоматически закроет поток
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("person.ser"))) {
            oos.writeObject(person); // "Упаковываем" объект в бинарный файл
        }

        // 4) Десериализация объекта Person из файла "person.ser"
        Person restored;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("person.ser"))) {
            restored = (Person) ois.readObject(); // "Распаковываем" объект из файла
        }

        // 5) Проверка корректности восстановления: выводим все поля на экран
        System.out.println("Имя: " + restored.name);
        System.out.println("Возраст: " + restored.age);
        // Если всё прошло успешно, вложенный объект Address тоже восстановится
        System.out.println("Город: " + restored.address.city);
        System.out.println("Улица: " + restored.address.street);
    }
}

 */

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        // 1) Создаем и заполняем вложенный объект Address
        Address address = new Address();
        address.city = "Нортвуд";
        address.street = "Центральная, 10";

        // 2) Создаем и заполняем объект Person, включая адрес
        Person person = new Person();
        person.name = "Алекс Мортон";
        person.age = 30;
        person.address = address;

        // 3) Сериализация объекта Person в файл "person.ser"
        // try-with-resources автоматически закроет поток
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("person.ser"))) {
            oos.writeObject(person); // "Упаковываем" объект в бинарный файл
        }

        // 4) Десериализация объекта Person из файла "person.ser"
        Person restored;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("person.ser"))) {
            restored = (Person) ois.readObject(); // "Распаковываем" объект из файла
        }

        // 5) Проверка корректности восстановления: выводим все поля на экран
        System.out.println("Имя: " + restored.name);
        System.out.println("Возраст: " + restored.age);
        // Если всё прошло успешно, вложенный объект Address тоже восстановится
        System.out.println("Город: " + restored.address.city);
        System.out.println("Улица: " + restored.address.street);
    }
}

class Address implements Serializable {
    String city;
    String street;

}

class Person implements Serializable {
    String name;
    int age;
    Address address;

}

/*
import java.io.*;

// Класс Address хранит адрес и реализует Serializable, чтобы его можно было сериализовать
class Address implements Serializable {
    public String city;
    public String street;
}

// Класс Person хранит информацию о человеке и ссылку на Address.
class Person implements Serializable {
    public String name;
    public int age;
    public Address address; // Вложенный объект Address
}

public class Solution {
    public static void main(String[] args) throws Exception {
        // 1) Создаем и заполняем вложенный объект Address
        Address address = new Address();
        address.city = "Нортвуд";
        address.street = "Центральная, 10";

        // 2) Создаем и заполняем объект Person, включая адрес
        Person person = new Person();
        person.name = "Алекс Мортон";
        person.age = 30;
        person.address = address;

        // 3) Сериализация объекта Person в файл "person.ser"
        // try-with-resources автоматически закроет поток
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("person.ser"))) {
            oos.writeObject(person); // "Упаковываем" объект в бинарный файл
        }

        // 4) Десериализация объекта Person из файла "person.ser"
        Person restored;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("person.ser"))) {
            restored = (Person) ois.readObject(); // "Распаковываем" объект из файла
        }

        // 5) Проверка корректности восстановления: выводим все поля на экран
        System.out.println("Имя: " + restored.name);
        System.out.println("Возраст: " + restored.age);
        // Если всё прошло успешно, вложенный объект Address тоже восстановится
        System.out.println("Город: " + restored.address.city);
        System.out.println("Улица: " + restored.address.street);
    }
}


 */