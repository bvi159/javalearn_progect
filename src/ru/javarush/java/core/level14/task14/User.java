package ru.javarush.java.core.level14.task14;

public class User {
    String userName;
    int userAge;

    User(String name) {
        this.userName = name;
        this.userAge = 0;
    }

    User() {
        this("Unknown");
    }
}
