package ru.javarush.java.core.level21.task19;
/*
Альтернативная сортировка товаров в магазине 🏷️

Вы управляете онлайн-магазином и у вас есть список товаров. Обычно вы сортируете их по цене, но сейчас вам потребовалось временно отсортировать их по названию в алфавитном порядке для специальной акции. Вы не хотите менять основной способ сравнения товаров.
Создайте класс Product с полями name (строка) и price (целое число). Создайте список из трёх объектов Product с разными названиями и ценами (например, "Телевизор", "Телефон", "Ноутбук"). Вам нужно отсортировать этот список по названию, используя Comparator, но не создавая отдельный класс для него, а прямо "на месте" с помощью анонимного класса. После сортировки выведите список товаров на экран, чтобы убедиться, что они расположены по алфавиту названий.

Требования:
•	Необходимо создать класс Product с двумя полями: name (тип String) и price (тип int).
•	В программе должен быть создан список (например, ArrayList) из трёх объектов Product с разными значениями полей name и price.
•	Список товаров должен быть отсортирован по полю name с помощью Comparator.
•	Comparator для сортировки должен быть реализован с помощью анонимного класса непосредственно в месте вызова sort, а не отдельным классом.
•	Основной способ сравнения товаров (например, по цене) не должен быть изменён или переопределён в классе Product.
•	После сортировки программа должна вывести список товаров на экран в алфавитном порядке их названий

public class Solution {
    public static void main(String[] args) {
        // Создаем список товаров с разными названиями и ценами
        List<Product> products = new ArrayList<>();
        products.add(new Product("Телевизор", 55000));
        products.add(new Product("Телефон", 35000));
        products.add(new Product("Ноутбук", 80000));

        // Временная сортировка по названию.


        // Вывод отсортированного списка (по алфавиту названий)
        for (Product p : products) {
            System.out.println(p);
        }
    }
}

 */

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        // Создаем список товаров с разными названиями и ценами
        List<Product> products = new ArrayList<>();
        products.add(new Product("Телевизор", 55000));
        products.add(new Product("Телефон", 35000));
        products.add(new Product("Ноутбук", 80000));

        // Временная сортировка по названию.
//        products.sort((a,b) -> a.getName().compareTo(b.getName()));
       products.sort(new Comparator<Product>() {
           @Override
           public int compare(Product o1, Product o2) {
               return (o1.getName()).compareTo(o2.getName());
           }
       });

        // Вывод отсортированного списка (по алфавиту названий)
        for (Product p : products) {
            System.out.println(p.getName());
        }
    }
}

class Product {
    private String name;
    private int price;

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    Product(String someName, int somePrice) {
        this.name = someName;
        this.price = somePrice;
    }
}

/*
public class Solution {
    public static void main(String[] args) {
        // Создаем список товаров с разными названиями и ценами
        List<Product> products = new ArrayList<>();
        products.add(new Product("Телевизор", 55000));
        products.add(new Product("Телефон", 35000));
        products.add(new Product("Ноутбук", 80000));

        // Временная сортировка по названию.
        products.sort(new Comparator<Product>() {
            @Override
            public int compare(Product a, Product b) {
                // Сравнение названий без учета регистра
                return a.getName().compareToIgnoreCase(b.getName());
            }
        });

        // Вывод отсортированного списка (по алфавиту названий)
        for (Product p : products) {
            System.out.println(p);
        }
    }
}

// Простой класс товара с двумя полями: name и price.
class Product {
    private final String name;
    private final int price;

    public Product(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        // Удобный человекочитаемый вывод для проверки порядка
        return name + " - " + price + " руб.";
    }
}
 */

