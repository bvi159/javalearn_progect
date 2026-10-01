package ru.javarush.java.core.level42.task10;
/*
Сериализация карты с баллами
Представьте, что вы — внимательный преподаватель, который бережно хранит успехи своих студентов. В конце семестра вы собрали все баллы, и теперь вам нужно надёжно записать их в цифровой классный журнал, чтобы ни одна оценка не потерялась.

Создайте "карту" под названием studentGrades, где ключом будет имя студента (String), а значением — его балл (Integer). Добавьте туда записи для "Анны" (90 баллов), "Бориса" (85 баллов) и "Вики" (92 балла). Затем "заархивируйте" эту карту оценок в файл "scores.ser".

После того как данные будут сохранены, представьте, что вам нужно посмотреть оценки снова, например, для составления отчёта. "Восстановите" карту из файла в память, получив recoveredGrades, и выведите на экран имена студентов и их баллы в формате "Имя: Балл" (например, "Анна: 90"), каждую пару на новой строке, чтобы убедиться, что ни одна оценка не потерялась.

Требования:
•	Необходимо создать объект Map<String, Integer> с именем studentGrades.
•	В карту studentGrades должны быть добавлены записи: "Анна" — 90, "Борис" — 85, "Вика" — 92.
•	Карта studentGrades должна быть сериализована в файл с именем "scores.ser" с помощью стандартных средств сериализации Java.
•	После сериализации необходимо десериализовать объект Map<String, Integer> из файла "scores.ser" в переменную recoveredGrades.
•	После восстановления карты необходимо вывести все пары ключ-значение из recoveredGrades в формате "Имя: Балл", каждая пара — на новой строке.

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedHashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) throws Exception {
        // Создаём карту оценок. Используем LinkedHashMap, чтобы сохранить порядок добавления элементов.
        Map<String, Integer> studentGrades = new LinkedHashMap<>();
        studentGrades.put("Анна", 90);
        studentGrades.put("Борис", 85);
        studentGrades.put("Вика", 92);

        // Сериализуем карту в файл "scores.ser" стандартными средствами Java


        // Десериализуем карту из файла в recoveredGrades


        // Выводим пары "Имя: Балл", каждая на новой строке


    }
}

 */

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedHashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) throws Exception {
        // Создаём карту оценок. Используем LinkedHashMap, чтобы сохранить порядок добавления элементов.
        Map<String, Integer> studentGrades = new LinkedHashMap<>();
        studentGrades.put("Анна", 90);
        studentGrades.put("Борис", 85);
        studentGrades.put("Вика", 92);

        // Сериализуем карту в файл "scores.ser" стандартными средствами Java
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("scores.ser"))) {
            oos.writeObject(studentGrades);
        }


        // Десериализуем карту из файла в recoveredGrades
        Map<String, Integer> recoveredGrades;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("scores.ser"))) {
            recoveredGrades = (Map<String, Integer>) ois.readObject();
        }

        // Выводим пары "Имя: Балл", каждая на новой строке
        for (var entity : recoveredGrades.entrySet()) {
            System.out.println(entity.getKey() + ": " + entity.getValue());
        }


    }
}
/*
public class Solution {
    public static void main(String[] args) throws Exception {
        // Создаём карту оценок. Используем LinkedHashMap, чтобы сохранить порядок добавления элементов.
        Map<String, Integer> studentGrades = new LinkedHashMap<>();
        studentGrades.put("Анна", 90);
        studentGrades.put("Борис", 85);
        studentGrades.put("Вика", 92);

        // Сериализуем карту в файл "scores.ser" стандартными средствами Java
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("scores.ser"))) {
            oos.writeObject(studentGrades);
        }

        // Десериализуем карту из файла в recoveredGrades
        Map<String, Integer> recoveredGrades;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("scores.ser"))) {
            // Приведение типа безопасно, так как мы знаем, что записывали Map<String, Integer>
            recoveredGrades = (Map<String, Integer>) ois.readObject();
        }

        // Выводим пары "Имя: Балл", каждая на новой строке
        for (Map.Entry<String, Integer> entry : recoveredGrades.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
 */