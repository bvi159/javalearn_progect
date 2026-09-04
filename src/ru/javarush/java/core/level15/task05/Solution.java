package ru.javarush.java.core.level15.task05;
/*
Читаем имя на цифровой визитке 🃏

Представьте, что вы создаёте основу для цифровых визитных карточек. На каждой визитке есть имя владельца, но это имя должно быть приватным внутри объекта, чтобы никто не мог случайно его изменить. Зато должна быть возможность его прочитать.
Создайте класс UserCard. Внутри него объявите одно приватное поле userName типа String. Затем реализуйте публичный метод getUserName(), который просто возвращает значение этого приватного поля.
В классе Solution создайте объект UserCard. Инициализируйте поле userName при создании объекта, например, с именем "Элис" (для этого можете добавить соответствующий публичный конструктор в UserCard). После этого используйте метод getUserName(), чтобы получить это имя и вывести его на экран. Ваша программа должна успешно вывести "Элис".

Требования:
•	В классе UserCard должно быть объявлено приватное поле userName типа String.
•	В классе UserCard должен быть реализован публичный метод getUserName(), возвращающий значение приватного поля userName.
•	В классе UserCard должен быть реализован публичный конструктор, принимающий параметр userName и инициализирующий соответствующее поле.
•	В классе Solution должен быть создан объект UserCard с именем "Элис".
•	В классе Solution необходимо получить имя пользователя с помощью метода getUserName() и вывести его на экран.

public class Solution {
    public static void main(String[] args) {
        // Создаем визитку и задаем имя владельца
        UserCard card = new UserCard("Элис");

        // Получаем имя через геттер и выводим на экран
        System.out.println(card.getUserName());
    }
}

 */
public class Solution {
    public static void main(String[] args) {
        // Создаем визитку и задаем имя владельца
        UserCard card = new UserCard("Элис");

        // Получаем имя через геттер и выводим на экран
        System.out.println(card.getUserName());
    }
}

class UserCard {
    private String userName;

    public String getUserName() {
        return this.userName;
    }

    public UserCard(String name) {
        this.userName = name;
    }
}