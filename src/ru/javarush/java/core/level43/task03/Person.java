package ru.javarush.java.core.level43.task03;

import java.io.Serializable;

public class Person implements Serializable {
    private static final long serialVersionUID = 100L;
    private String personName;
    private int personAge;

    public Person(String name, int age) {
        this.personName = name;
        this.personAge = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "personName='" + personName + '\'' +
                ", personAge=" + personAge +
                '}';
    }
}
