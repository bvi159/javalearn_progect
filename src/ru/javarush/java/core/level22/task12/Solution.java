package ru.javarush.java.core.level22.task12;

/*
Идентификация товаров по названию в магазине 🏷️

Вы работаете над каталогом товаров для интернет-магазина. Иногда один и тот же товар может иметь небольшие различия в цене (например, из-за разных партий или акций), но для системы важно считать товары одинаковыми, если у них совпадают названия. Создайте класс-запись, который будет представлять товар, содержащий его название и цену.

Ваша задача — переопределить стандартные методы сравнения и вычисления хеша таким образом, чтобы они учитывали только название товара, игнорируя цену. В основной программе создайте два объекта товара с одинаковым названием, но с разными ценами. Затем выведите на экран результат их сравнения и сравнения их хеш-кодов, чтобы убедиться, что система правильно идентифицирует их как эквивалентные, несмотря на разницу в стоимости.

Требования:
•	Необходимо создать record-класс, представляющий товар с двумя полями: название (String) и цена (double).
•	Метод equals должен быть переопределён так, чтобы сравнивались только названия товаров, а цена игнорировалась.
•	Метод hashCode должен учитывать только название товара, а цена не должна влиять на результат вычисления хеша.
•	В основной программе должны быть созданы два объекта товара с одинаковым названием и разными ценами.
•	В основной программе необходимо сравнить созданные объекты методом equals и вывести результат на экран.
•	В основной программе необходимо сравнить хеш-коды созданных объектов и вывести результат на экран.

public class Solution {
    public static void main(String[] args) {
        // Создаем два товара с одинаковым названием и разной ценой
        Product p1 = new Product("Кружка", 199.99);
        Product p2 = new Product("Кружка", 149.49);

        // Проверяем эквивалентность по equals (ожидаем true)
        System.out.println(p1.equals(p2));

        // Проверяем совпадение хеш-кодов (ожидаем true)
        System.out.println(p1.hashCode() == p2.hashCode());
    }
}

 */

import java.util.Objects;

public class Solution {
    public static void main(String[] args) {
        // Создаем два товара с одинаковым названием и разной ценой
        Product p1 = new Product("Кружка", 199.99);
        Product p2 = new Product("Кружка", 149.49);

        // Проверяем эквивалентность по equals (ожидаем true)
        System.out.println(p1.equals(p2));

        // Проверяем совпадение хеш-кодов (ожидаем true)
        System.out.println(p1.hashCode() == p2.hashCode());
    }
}

record Product(String name, double price) {
    @Override
    public boolean equals(Object obj) {
        Product product = (Product) obj;
        return name.equals(product.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
        //return Objects.hash(name);
    }
}

/*

// record-класс товара с названием и ценой
record Product(String name, double price) {
    @Override
    public boolean equals(Object o) {
        // Сначала проверяем ссылочное равенство
        if (this == o) return true;
        // Сравниваем только объекты типа Product
        if (!(o instanceof Product other)) return false;
        // ВАЖНО: сравниваем только название, цену игнорируем
        return Objects.equals(this.name, other.name);
    }

    @Override
    public int hashCode() {
        // Хеш считаем только по названию, чтобы быть согласованным с equals
        return Objects.hash(name);
    }
}

public class Solution {
    public static void main(String[] args) {
        // Создаем два товара с одинаковым названием и разной ценой
        Product p1 = new Product("Кружка", 199.99);
        Product p2 = new Product("Кружка", 149.49);

        // Проверяем эквивалентность по equals (ожидаем true)
        System.out.println(p1.equals(p2));

        // Проверяем совпадение хеш-кодов (ожидаем true)
        System.out.println(p1.hashCode() == p2.hashCode());
    }
}
 */