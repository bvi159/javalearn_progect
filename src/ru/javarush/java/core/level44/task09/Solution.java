package ru.javarush.java.core.level44.task09;
/*
Неверное толкование данных: `ClassCastException` после десериализации 🚨
Представьте, что вы — специалист по данным, и вам передали файл с набором текстовых меток или идентификаторов, которые на самом деле являются названиями фруктов. Однако по ошибке или недоразумению вы, как программист, пытаетесь обработать эти названия как последовательность числовых данных. Ваша задача — наглядно продемонстрировать, что произойдет, когда программа попытается "прочитать" "яблоко" как число.

В вашем основном методе main создайте ArrayList строкового типа (ArrayList<String>). Заполните его несколькими названиями фруктов, например, "apple" и "banana". После этого сериализуйте этот список строк в файл с именем "fruits.ser".

Теперь наступает момент ошибки: десериализуйте содержимое файла "fruits.ser" обратно в объект. Но вместо того, чтобы привести его к исходному типу ArrayList<String>, попытайтесь принудительно привести его к типу ArrayList<Integer>. После этого, как будто ничего не произошло, попытайтесь получить первый элемент из этого "списка чисел" и присвоить его переменной типа Integer.

Ожидается, что на этом шаге ваша программа не сможет продолжить выполнение и завершится с ошибкой java.lang.ClassCastException. Цель этой задачи — наглядно продемонстрировать, как Java строго следит за соответствием типов во время выполнения и почему так важно правильно управлять типами данных при работе с сериализацией, чтобы избежать неожиданных исключений.

Требования:
•	В программе должен быть создан объект ArrayList<String> и заполнен строковыми значениями (например, "apple", "banana").
•	Список строк должен быть сериализован в файл с именем "fruits.ser" с помощью ObjectOutputStream.
•	Объект должен быть десериализован из файла "fruits.ser" с помощью ObjectInputStream.
•	Десериализованный объект должен быть приведён к типу ArrayList<Integer> вместо ArrayList<String>.
•	После приведения типа необходимо попытаться получить первый элемент списка и присвоить его переменной типа Integer.
•	Программа должна завершиться с ошибкой java.lang.ClassCastException при попытке присвоения значения переменной типа Integer.

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws Exception {
        // 1) Создаем список строк с названиями фруктов
        ArrayList<String> fruits = new ArrayList<>();
        fruits.add("apple");
        fruits.add("banana");

        // 2) Сериализуем список в файл "fruits.ser"
        // try-with-resources автоматически закроет поток после записи


        // 3) Десериализуем объект из файла "fruits.ser"


        // 4) Неправильное приведение типа:
        // Из-за стирания типов (type erasure) компилятор не видит реальный параметр типа,
        // поэтому приведение к ArrayList<Integer> компилируется, но это логическая ошибка.


        // 5) Попытка получить первый элемент как Integer.
        // Фактически внутри лежит строка "apple", поэтому на этой строке возникнет
        // java.lang.ClassCastException во время выполнения.


        // Этот вывод не будет достигнут из-за исключения выше.

    }
}


 */

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws Exception {
        // 1) Создаем список строк с названиями фруктов
        ArrayList<String> fruits = new ArrayList<>();
        fruits.add("apple");
        fruits.add("banana");

        // 2) Сериализуем список в файл "fruits.ser"
        // try-with-resources автоматически закроет поток после записи
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("fruits.ser"))) {
            oos.writeObject(fruits);
        }

        // 3) Десериализуем объект из файла "fruits.ser"
        ArrayList<Integer> numericFruits;
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("fruits.ser"));
        numericFruits = (ArrayList<Integer>) ois.readObject();
        ois.close();

        int firstFruit = numericFruits.get(0);

        // Этот вывод не будет достигнут из-за исключения выше.
        System.out.println(firstFruit);

    }
}
/*

public class Solution {
    public static void main(String[] args) throws Exception {
        // 1) Создаем список строк с названиями фруктов
        ArrayList<String> fruits = new ArrayList<>();
        fruits.add("apple");
        fruits.add("banana");

        // 2) Сериализуем список в файл "fruits.ser"
        // try-with-resources автоматически закроет поток после записи
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("fruits.ser"))) {
            oos.writeObject(fruits);
        }

        // 3) Десериализуем объект из файла "fruits.ser"
        Object deserialized;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("fruits.ser"))) {
            deserialized = ois.readObject();
        }

        // 4) Неправильное приведение типа:
        // Из-за стирания типов (type erasure) компилятор не видит реальный параметр типа,
        // поэтому приведение к ArrayList<Integer> компилируется, но это логическая ошибка.
        @SuppressWarnings("unchecked")
        ArrayList<Integer> wrongList = (ArrayList<Integer>) deserialized;

        // 5) Попытка получить первый элемент как Integer.
        // Фактически внутри лежит строка "apple", поэтому на этой строке возникнет
        // java.lang.ClassCastException во время выполнения.
        Integer firstNumber = wrongList.get(0);

        // Этот вывод не будет достигнут из-за исключения выше.
        System.out.println("Первый элемент как число: " + firstNumber);
    }
}

 */