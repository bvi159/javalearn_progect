package ru.javarush.java.core.level16.task02;
/*
Персональный ассистент: вежливое приветствие 🗣️

Вы разрабатываете персонального ассистента на основе искусственного интеллекта. Для каждого пользователя ассистент должен знать его имя, но это имя — личная и приватная информация. Однако, когда ассистент приветствует пользователя, он должен использовать это имя.

Начните с создания класса Person, который будет представлять пользователя. У этого класса должно быть приватное строковое поле userName для хранения имени, и конструктор, принимающий это имя. Внутри класса Person объявите внутренний класс с именем Greeting. Этот класс Greeting должен содержать метод sayHello(), который выводит на экран дружелюбное "Hello, " и имя пользователя.

В методе main вашей программы создайте объект Person, например, с именем "Anna". Затем, используя этот объект Person, создайте объект внутреннего класса Greeting и вызовите его метод sayHello(). Ваша программа должна вывести на экран личное приветствие для Анны.

Требования:
•	Должен быть создан класс с именем Person.
•	В классе Person должно быть приватное строковое поле userName для хранения имени пользователя.
•	Класс Person должен содержать конструктор, принимающий имя пользователя в качестве параметра и сохраняющий его в поле userName.
•	Внутри класса Person должен быть объявлен внутренний (non-static inner) класс с именем Greeting.
•	Класс Greeting должен содержать метод sayHello(), который выводит на экран строку "Hello, " и имя пользователя, используя значение поля userName внешнего класса Person.
•	В методе main программы должен быть создан объект класса Person с именем пользователя, например, "Anna".
•	С помощью объекта Person должен быть создан объект внутреннего класса Greeting.
•	У объекта Greeting должен быть вызван метод sayHello(), который выводит приветствие с именем пользователя.

public class Solution {
    public static void main(String[] args) {
        // Создаем объект Person с именем "Anna"
        Person person = new Person("Anna");

        // Создаем объект внутреннего класса Greeting через объект внешнего класса
        // Синтаксис person.new Greeting() обязателен для non-static inner классов
        Person.Greeting greeting = person.new Greeting();

        // Вызываем метод, который выводит приветствие
        greeting.sayHello();
    }
}

 */
public class Solution {
    public static void main(String[] args) {
        // Создаем объект Person с именем "Anna"
        Person person = new Person("Anna");

        // Создаем объект внутреннего класса Greeting через объект внешнего класса
        // Синтаксис person.new Greeting() обязателен для non-static inner классов
        Person.Greeting greeting = person.new Greeting();

        // Вызываем метод, который выводит приветствие
        greeting.sayHello();
    }
}

class Person {
    private String userName;

    Person(String name) {
        this.userName = name;
    }

    class Greeting {
        void sayHello() {
            System.out.println("Hello, " + userName);
        }
    }

}

/*
// Класс Person представляет пользователя с приватным именем
class Person {
    // Приватное поле для хранения имени пользователя (инкапсуляция)
    private String userName;

    // Конструктор принимает имя и сохраняет его в поле userName
    public Person(String userName) {
        this.userName = userName;
    }

    // Внутренний (non-static inner) класс имеет доступ к приватным полям внешнего класса
    class Greeting {
        // Метод выводит персональное приветствие, используя поле userName внешнего класса
        public void sayHello() {
            System.out.println("Hello, " + userName);
        }
    }
}

 */