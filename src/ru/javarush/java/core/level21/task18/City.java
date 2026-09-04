package ru.javarush.java.core.level21.task18;

import org.jetbrains.annotations.NotNull;

public class City implements Comparable<City> {
    private String name;
    private int population;

    City(String cityName, int howMuch) {
        this.name = cityName;
        this.population = howMuch;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    @Override
    public int compareTo(@NotNull City cityObj) {
        return Integer.compare(this.population, cityObj.population);
    }

    @Override
    public String toString() {
        return ("\"" + this.getName()+"\" "+ this.getPopulation()+"M");


    }
}
/*
// Публичный класс City, реализующий Comparable<City> для сортировки по населению
public class City implements Comparable<City> {
    // Приватные поля согласно требованиям
    private final String name;
    private final int population;

    // Простой конструктор для инициализации города
    public City(String name, int population) {
        this.name = name;
        this.population = population;
    }

    // Геттеры — пригодятся, если потребуется доступ к полям
    public String getName() {
        return name;
    }

    public int getPopulation() {
        return population;
    }

    @Override
    public int compareTo(City other) {
        // Сравниваем по численности населения: от меньшего к большему
        return Integer.compare(this.population, other.population);
    }

    @Override
    public String toString() {
        // Упрощённый вывод: имя и численность населения
        return name + ": " + population;
    }
}
 */

