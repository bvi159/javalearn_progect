package ru.javarush.java.core.level42.task09;
/*
Сериализация списка строк
Вы — ученик алхимика, и вам поручили вести учёт ингредиентов в вашей лаборатории. У вас есть список свежих фруктов, которые вы собираетесь использовать для новых зелий.

Создайте "список" магических ингредиентов, например, potionIngredients, и добавьте в него названия: "яблоко", "банан", "киви".

Ваша задача — записать этот список в вашу волшебную книгу рецептов, которая является файлом "fruits.ser", используя ObjectOutputStream.

После того как список будет записан, представьте, что наступил новый день, и вам нужно извлечь список ингредиентов из книги. "Распакуйте" его обратно в память, получив recoveredIngredients, и выведите все элементы этого списка на экран, по одному в каждой строке, чтобы убедиться, что всё на месте и готово к работе.

Требования:
•	В программе должен быть создан объект типа List<String> с именем potionIngredients, содержащий строки "яблоко", "банан", "киви".
•	Список potionIngredients должен быть сериализован и записан в файл с именем "fruits.ser" с помощью ObjectOutputStream.
•	Для записи списка в файл необходимо использовать ObjectOutputStream, обернув его над FileOutputStream.
•	Список должен быть считан обратно из файла "fruits.ser" с помощью ObjectInputStream и сохранён в переменную recoveredIngredients.
•	Для чтения объекта из файла требуется использовать ObjectInputStream, обернув его над FileInputStream.
•	После десериализации элементы recoveredIngredients должны быть выведены на экран по одному в каждой строке.
•	Десериализованный объект recoveredIngredients должен быть приведён к типу List<String> (или эквиваленту, если используется var).
•	Все потоки ввода-вывода должны быть корректно закрыты после завершения операций.

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        // Создаем список ингредиентов и заполняем его
        List<String> potionIngredients = new ArrayList<>();
        potionIngredients.add("яблоко");
        potionIngredients.add("банан");
        potionIngredients.add("киви");

        // Сериализация списка в файл fruits.ser
        // try-with-resources автоматически закроет потоки после использования


        // Десериализация списка из файла fruits.ser


        // Вывод элементов десериализованного списка по одному в каждой строке

    }
}

 */

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        // Создаем список ингредиентов и заполняем его
        List<String> potionIngredients = new ArrayList<>();
        potionIngredients.add("яблоко");
        potionIngredients.add("банан");
        potionIngredients.add("киви");

        // Сериализация списка в файл fruits.ser
        // try-with-resources автоматически закроет потоки после использования
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("fruits.ser"))) {
            oos.writeObject(potionIngredients);
        }


        // Десериализация списка из файла fruits.ser
        List<String> recoveredIngredients;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("fruits.ser"))) {
            recoveredIngredients = (List<String>) ois.readObject();
        }

        // Вывод элементов десериализованного списка по одному в каждой строке
        for (String element : recoveredIngredients) {
            System.out.println("- " + element);
        }

    }
}

/*
public class Solution {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        // Создаем список ингредиентов и заполняем его
        List<String> potionIngredients = new ArrayList<>();
        potionIngredients.add("яблоко");
        potionIngredients.add("банан");
        potionIngredients.add("киви");

        // Сериализация списка в файл fruits.ser
        // try-with-resources автоматически закроет потоки после использования
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("fruits.ser"))) {
            oos.writeObject(potionIngredients);
        }

        // Десериализация списка из файла fruits.ser
        List<String> recoveredIngredients;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("fruits.ser"))) {
            Object obj = ois.readObject();
            recoveredIngredients = (List<String>) obj; // Приведение типа к List<String> после чтения объекта
        }

        // Вывод элементов десериализованного списка по одному в каждой строке
        for (String ingredient : recoveredIngredients) {
            System.out.println(ingredient);
        }
    }
}
 */