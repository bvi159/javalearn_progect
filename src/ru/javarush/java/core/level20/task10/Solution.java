package ru.javarush.java.core.level20.task10;
/*
Профиль Пользователя: Имя и Возможность Сохранения

Вы создаёте систему управления пользователями для онлайн-сервиса. Каждый пользователь должен иметь имя, и его профиль должен быть готов к сохранению в файл или передаче по сети, что является стандартным требованием для объектов данных в Java.

Объявите свой собственный "контракт именования" — интерфейс Nameable (Именуемый) с методом String getName(), который должен возвращать имя. Затем создайте класс User (Пользователь). Этот User должен реализовать как ваш собственный интерфейс Nameable, так и стандартный интерфейс Java java.io.Serializable (который позволяет объекту быть сериализованным).

В классе User должно быть поле String name для хранения имени пользователя, а также конструктор, позволяющий установить это имя при создании объекта. Метод getName() должен просто возвращать значение этого поля name. В основной части вашей программы создайте объект User с любым именем и продемонстрируйте получение и вывод его имени на экран, используя метод getName().

Требования:
•	Должен быть создан пользовательский интерфейс Nameable с методом String getName().
•	Класс User должен реализовывать интерфейсы Nameable и java.io.Serializable.
•	В классе User должно быть приватное поле String name для хранения имени пользователя.
•	Класс User должен содержать конструктор, принимающий имя пользователя и инициализирующий поле name.
•	В классе User должен быть реализован метод getName(), который возвращает значение поля name.
•	В основной части программы должен быть создан объект класса User с произвольным именем.
•	Имя пользователя должно быть получено с помощью метода getName() и выведено на экран.

public class Solution {
    public static void main(String[] args) {
        // Создаем пользователя с произвольным именем
        User user = new User("Алиса");

        // Получаем имя через метод getName() и выводим на экран
        System.out.println(user.getName());
    }
}


 */
import java.io.Serializable;

public class Solution {
    public static void main(String[] args) {
        // Создаем пользователя с произвольным именем
        User user = new User("Алиса");

        // Получаем имя через метод getName() и выводим на экран
        System.out.println(user.getName());
    }
}

interface Nameable {
    String getName();
}

class User implements Nameable, Serializable {
    private String name;

    public User(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

/*

// Интерфейс "контракт именования": любой "именуемый" объект обязан уметь возвращать имя
interface Nameable {
    String getName();
}

// Класс User реализует два интерфейса: наш Nameable и стандартный Serializable
class User implements Nameable, Serializable {
    // Приватное поле для хранения имени пользователя
    private String name;

    // Конструктор для инициализации имени при создании объекта
    public User(String name) {
        this.name = name;
    }

    // Реализация метода интерфейса Nameable — просто возвращаем имя
    @Override
    public String getName() {
        return name;
    }
}

public class Solution {
    public static void main(String[] args) {
        // Создаем пользователя с произвольным именем
        User user = new User("Алиса");

        // Получаем имя через метод getName() и выводим на экран
        System.out.println(user.getName());
    }
}
 */