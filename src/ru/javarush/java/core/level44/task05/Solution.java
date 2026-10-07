package ru.javarush.java.core.level44.task05;
/*
Парадоксальный список: коллекция, содержащая саму себя 🤯
Вы решили создать необычную, даже немного парадоксальную структуру данных, которая сама себя содержит. Это похоже на головоломку или рекурсивную ссылку в метаданных. Ваша задача — продемонстрировать, что Java-сериализация способна справиться даже с такими хитрыми конструкциями, сохраняя идентичность ссылок.

В вашем методе main создайте объект ArrayList<Object>. Это будет ваш "парадоксальный" список. Сначала добавьте в него обычную строку, например, "cycle" или "hello". Но затем, и это самое интересное, добавьте в этот же список саму эту коллекцию в качестве второго элемента. Теперь у вас есть список, который напрямую ссылается на себя.

Далее, чтобы сохранить эту уникальную структуру, сериализуйте этот ArrayList в файл с помощью ObjectOutputStream. После успешного сохранения представьте, что программу перезапустили, и вам нужно восстановить данные: десериализуйте список обратно из файла. В заключение, чтобы убедиться, что идентичность ссылки на себя была сохранена, выведите на экран результат сравнения: второй элемент десериализованного списка должен быть равен (==) самому этому списку. Ожидаемый результат этого сравнения — true, что подтвердит способность сериализации сохранять циклические ссылки.

Требования:
•	В методе main должен быть создан объект ArrayList<Object>, который добавляет сам себя в качестве одного из элементов.
•	Перед добавлением самой коллекции в качестве элемента, в список должна быть добавлена строка (например, "cycle" или "hello").
•	Коллекция с циклической ссылкой должна быть сериализована в файл с помощью ObjectOutputStream.
•	Коллекция должна быть десериализована обратно из файла с помощью ObjectInputStream.
•	После десериализации необходимо сравнить второй элемент списка с самим списком с помощью оператора ==, и вывести результат этого сравнения на экран.
•	Результат сравнения (==) между вторым элементом и самим списком должен быть true.

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws Exception {
        // Создаем список, который будет ссылаться сам на себя
        ArrayList<Object> paradox = new ArrayList<>();
        paradox.add("cycle");          // Сначала добавляем обычную строку
        paradox.add(paradox);          // Затем добавляем сам список в качестве второго элемента

        // Сериализуем список в файл. try-with-resources автоматически закроет поток


        // Десериализуем список из файла — имитируем перезапуск программы


        // Проверяем, что воссоздана та же структура ссылок:
        // второй элемент списка является тем же самым объектом (==), что и сам список

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
        // Создаем список, который будет ссылаться сам на себя
        ArrayList<Object> paradox = new ArrayList<>();
        paradox.add("cycle");          // Сначала добавляем обычную строку
        paradox.add(paradox);          // Затем добавляем сам список в качестве второго элемента

        // Сериализуем список в файл. try-with-resources автоматически закроет поток
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("paradox.ser"));
        oos.writeObject(paradox);
        oos.close();

        // Десериализуем список из файла — имитируем перезапуск программы
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("paradox.ser"));
        ArrayList<Object> recoveredParadox = (ArrayList<Object>) ois.readObject();
        ois.close();

        // Проверяем, что воссоздана та же структура ссылок:
        // второй элемент списка является тем же самым объектом (==), что и сам список
        ArrayList<Object> recoveredSecondObject = (ArrayList<Object>) recoveredParadox.get(1);
        System.out.println(recoveredParadox == recoveredSecondObject);

    }
}
/*
public class Solution {
    public static void main(String[] args) throws Exception {
        // Создаем список, который будет ссылаться сам на себя
        ArrayList<Object> paradox = new ArrayList<>();
        paradox.add("cycle");          // Сначала добавляем обычную строку
        paradox.add(paradox);          // Затем добавляем сам список в качестве второго элемента

        // Сериализуем список в файл. try-with-resources автоматически закроет поток
        String fileName = "paradox_list.bin";
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(paradox);
        }

        // Десериализуем список из файла — имитируем перезапуск программы
        ArrayList<Object> restored;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            restored = (ArrayList<Object>) ois.readObject();
        }

        // Проверяем, что воссоздана та же структура ссылок:
        // второй элемент списка является тем же самым объектом (==), что и сам список
        boolean result = restored.get(1) == restored;
        System.out.println(result); // Ожидается: true
    }
}

 */