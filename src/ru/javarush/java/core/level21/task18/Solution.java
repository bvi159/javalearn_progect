package ru.javarush.java.core.level21.task18;
/*
Упорядочивание городов по численности населения 🏙️

Как градостроитель, вы собираете данные о городах и вам необходимо автоматически упорядочивать их по численности населения для отчётов и аналитики.
Создайте класс City с полями name (строка) и population (целое число). Реализуйте интерфейс Comparable<City> для этого класса таким образом, чтобы города сортировались по населению от меньшего к большему. Создайте список из трёх разных городов с их населением (например, "Нью-Йорк" 8.4М, "Лондон" 8.9М, "Париж" 2.1М). Затем используйте стандартный метод Collections.sort для сортировки этого списка и выведите отсортированный список на экран, чтобы подтвердить правильность порядка.

Требования:
•	Необходимо создать публичный класс с именем City.
•	Класс City должен содержать два приватных поля: name (типа String) и population (типа int).
•	Класс City должен реализовывать интерфейс Comparable<City>.
•	В классе City должен быть реализован метод compareTo, который сравнивает города по полю population, обеспечивая сортировку от меньшего к большему.
•	В программе должен быть создан список (например, ArrayList) из трёх объектов City с разными значениями name и population.
•	Список городов должен быть отсортирован методом Collections.sort.
•	После сортировки программа должна вывести на экран список городов в порядке возрастания населения.

public class Solution {
    public static void main(String[] args) {
        // Создаём список городов с разным населением
        List<City> cities = new ArrayList<>();
        cities.add(new City("Нью-Йорк", 8400000)); // 8.4 млн
        cities.add(new City("Лондон", 8900000));   // 8.9 млн
        cities.add(new City("Париж", 2100000));    // 2.1 млн

        // Сортируем список стандартным методом Collections.sort
        // Порядок будет по возрастанию населения благодаря compareTo в City
        Collections.sort(cities);

        // Выводим отсортированный список
        for (City city : cities) {
            System.out.println(city);
        }
    }
}

 */

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        // Создаём список городов с разным населением
        List<City> cities = new ArrayList<>();
        cities.add(new City("Нью-Йорк", 8400000)); // 8.4 млн
        cities.add(new City("Лондон", 8900000));   // 8.9 млн
        cities.add(new City("Париж", 2100000));    // 2.1 млн

        // Сортируем список стандартным методом Collections.sort
        // Порядок будет по возрастанию населения благодаря compareTo в City
        Collections.sort(cities);

        // Выводим отсортированный список
        for (City city : cities) {
            System.out.println(city.toString());
        }
    }
}

