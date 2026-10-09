package ru.javarush.java.core.level45.task07.v1;

import java.io.Serializable;

public class Animal implements Serializable {
    private final static long serialVersionUID = 100l;
    private final String animalType;
    private final int animalWeight;

    public Animal(String name, int weight) {
        this.animalType = name;
        this.animalWeight = weight;
    }


}
