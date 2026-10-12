package ru.javarush.java.core.level45.task08.v1;

import java.io.Serializable;

public class User implements Serializable {
    private final static long serialVersionUID = 200L;
    private final String userName;
    private final int userAgeInt;

    public User(String name, int age) {
        this.userName = name;
        this.userAgeInt = age;
    }

}
