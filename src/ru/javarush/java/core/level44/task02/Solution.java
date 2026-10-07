package ru.javarush.java.core.level44.task02;
/*
Управление сложной логистикой доставки: глубоко вложенные данные 🌍
Ваша система учета данных становится всё сложнее и подробнее. Теперь вы не просто храните адрес, а хотите детализировать информацию о городе, чтобы, например, автоматически определять налоговые зоны или особенности доставки. Это требует глубокой вложенности данных.

В этом сценарии вам нужно создать три класса. Первый — CityInfo, который будет содержать лишь название города (cityName) типа String. Второй — Address, который теперь будет хранить не просто строку с названием города, а объект CityInfo (cityInfo), а также название улицы (street) типа String. И, наконец, класс Person, который, как и прежде, будет содержать имя (name), возраст (age) и объект Address (address). Все три класса — CityInfo, Address и Person — должны обязательно реализовать интерфейс Serializable.

В вашем методе main создайте объект Person, очень тщательно заполняя все поля. Это значит, что внутри объекта Person будет объект Address, а внутри него — объект CityInfo. Представьте, что вы готовите эти данные для отправки в архив: сериализуйте полностью заполненный объект Person в файл с именем "deep.ser". После этого, чтобы убедиться в безупречности вашей системы, десериализуйте объект из этого файла. В завершение, выведите на экран значения всех полей восстановленного объекта Person, включая улицу из Address и, самое главное, имя города из объекта CityInfo, чтобы наглядно убедиться, что даже такая глубокая вложенность данных была полностью и корректно сериализована и восстановлена.

Требования:
•	Необходимо создать три класса: CityInfo, Address и Person, причем каждый следующий класс содержит в себе объект предыдущего (CityInfo содержится в Address, Address содержится в Person).
•	Все три класса — CityInfo, Address и Person — должны явно реализовывать интерфейс Serializable.
•	Класс CityInfo должен содержать приватное поле cityName типа String. Класс Address должен содержать приватные поля cityInfo типа CityInfo и street типа String. Класс Person должен содержать приватные поля name типа String, age типа int и address типа Address.
•	В методе main необходимо создать объект Person, заполнив все поля, включая вложенные объекты Address и CityInfo.
•	В методе main объект Person должен быть сериализован в файл с именем "deep.ser" с помощью стандартных средств сериализации Java.
•	После сериализации объект Person должен быть десериализован обратно из файла "deep.ser".
•	После десериализации необходимо вывести на экран значения всех полей объекта Person, включая поле street из Address и поле cityName из объекта CityInfo, чтобы убедиться в корректности сериализации и восстановления вложенных объектов.

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        // Создаем глубоко вложенную структуру: Person -> Address -> CityInfo
        CityInfo cityInfo = new CityInfo("Нортвуд");
        Address address = new Address(cityInfo, "Центральная улица");
        Person person = new Person("Алекс Мортон", 30, address);

        // Сериализуем объект Person в файл deep.ser
        // try-with-resources автоматически закрывает поток
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("deep.ser"))) {
            out.writeObject(person);
        }

        // Десериализуем объект Person из файла deep.ser
        Person restored;
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("deep.ser"))) {
            restored = (Person) in.readObject();
        }

        // Выводим все поля восстановленного объекта, включая вложенные
        System.out.println("Имя: " + restored.getName());
        System.out.println("Возраст: " + restored.getAge());
        System.out.println("Улица: " + restored.getAddress().getStreet());
        System.out.println("Город: " + restored.getAddress().getCityInfo().getCityName());
    }
}


 */

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        // Создаем глубоко вложенную структуру: Person -> Address -> CityInfo
        CityInfo cityInfo = new CityInfo("Нортвуд");
        Address address = new Address(cityInfo, "Центральная улица");
        Person person = new Person("Алекс Мортон", 30, address);

        // Сериализуем объект Person в файл deep.ser
        // try-with-resources автоматически закрывает поток
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("deep.ser"))) {
            out.writeObject(person);
        }

        // Десериализуем объект Person из файла deep.ser
        Person restored;
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("deep.ser"))) {
            restored = (Person) in.readObject();
        }

        // Выводим все поля восстановленного объекта, включая вложенные
        System.out.println("Имя: " + restored.getName());
        System.out.println("Возраст: " + restored.getAge());
        System.out.println("Улица: " + restored.getAddress().getStreet());
        System.out.println("Город: " + restored.getAddress().getCityInfo().getCityName());
    }
}

class CityInfo implements Serializable {
    private final String cityName;

    public CityInfo(String cityName) {
        this.cityName = cityName;
    }

    public String getCityName() {
        return cityName;
    }
}

class Address implements Serializable {
    private final String street;
    private final CityInfo cityInfo;

    public Address(CityInfo cityInfo, String street) {
        this.street = street;
        this.cityInfo = cityInfo;
    }

    public String getStreet() {
        return street;
    }

    public CityInfo getCityInfo() {
        return cityInfo;
    }
}

class Person implements Serializable {
    private final String name;
    private final int age;
    private final Address address;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Address getAddress() {
        return address;
    }

    public Person(String name, int age, Address address) {
        this.name = name;
        this.age = age;
        this.address = address;


    }

}

/*
// Класс с информацией о городе
class CityInfo implements Serializable {
    private String cityName; // Название города

    public CityInfo(String cityName) {
        this.cityName = cityName;
    }

    public String getCityName() {
        return cityName;
    }
}

// Класс адреса: содержит объект CityInfo и название улицы
class Address implements Serializable {
    private CityInfo cityInfo; // Вложенный объект с информацией о городе
    private String street;     // Улица

    public Address(CityInfo cityInfo, String street) {
        this.cityInfo = cityInfo;
        this.street = street;
    }

    public CityInfo getCityInfo() {
        return cityInfo;
    }

    public String getStreet() {
        return street;
    }
}

// Класс человека: содержит имя, возраст и адрес
class Person implements Serializable {
    private String name;    // Имя
    private int age;        // Возраст
    private Address address; // Вложенный объект адреса

    public Person(String name, int age, Address address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Address getAddress() {
        return address;
    }
}

public class Solution {
    public static void main(String[] args) throws Exception {
        // Создаем глубоко вложенную структуру: Person -> Address -> CityInfo
        CityInfo cityInfo = new CityInfo("Нортвуд");
        Address address = new Address(cityInfo, "Центральная улица");
        Person person = new Person("Алекс Мортон", 30, address);

        // Сериализуем объект Person в файл deep.ser
        // try-with-resources автоматически закрывает поток
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("deep.ser"))) {
            out.writeObject(person);
        }

        // Десериализуем объект Person из файла deep.ser
        Person restored;
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("deep.ser"))) {
            restored = (Person) in.readObject();
        }

        // Выводим все поля восстановленного объекта, включая вложенные
        System.out.println("Имя: " + restored.getName());
        System.out.println("Возраст: " + restored.getAge());
        System.out.println("Улица: " + restored.getAddress().getStreet());
        System.out.println("Город: " + restored.getAddress().getCityInfo().getCityName());
    }
}

 */