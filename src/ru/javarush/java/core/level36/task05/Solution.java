package ru.javarush.java.core.level36.task05;
/*
Извлечение ценного фрагмента из бинарного потока 🧪

Представьте, что вы учёный, работающий с потоками данных, и вам нужно выделить очень специфический, небольшой фрагмент из более крупного бинарного образца.
У вас есть полный образец данных, представленный массивом байтов: {1, 2, 3, 4, 5, 6, 7, 8}. Однако для вашего эксперимента требуется всего четыре элемента, начиная с третьего по счёту (то есть, байты 3, 4, 5, 6).
Ваша Java-программа должна быть как точный инструмент, способный выполнить эту операцию. Она должна записать в новый бинарный файл, который вы назовёте "ценный_фрагмент.bin", только эти четыре байта: 3, 4, 5, 6.
Используйте для этого специализированный метод write(byte[], int offset, int length) класса FileOutputStream. После успешного выполнения программы, файл "ценный_фрагмент.bin" должен содержать строго и только байты 3, 4, 5, 6.

Требования:
•	В программе должен быть создан массив байтов с элементами {1, 2, 3, 4, 5, 6, 7, 8}.
•	Из массива необходимо выбрать четыре байта, начиная с третьего по счёту (индекс 2): 3, 4, 5, 6.
•	Для записи данных в файл должен использоваться класс FileOutputStream.
•	Запись в файл должна осуществляться с помощью метода write(byte[], int offset, int length), чтобы записать только нужный фрагмент массива.
•	Файл, в который производится запись, должен называться "ценный_фрагмент.bin".
•	После выполнения программы файл "ценный_фрагмент.bin" должен содержать ровно четыре байта: 3, 4, 5, 6, и никаких других данных.

import java.io.FileOutputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        // Исходный массив байтов образца данных
        byte[] data = {1, 2, 3, 4, 5, 6, 7, 8};

        // Имя выходного бинарного файла
        String fileName = "ценный_фрагмент.bin";

        // Записываем ровно 4 байта, начиная с индекса 2 (элементы 3, 4, 5, 6)
        // Используем специализированный метод write(byte[], int offset, int length)

        // Это пример из лекции 36_2
        String source = "image01.png";
        String dest = "image01_copy.png";

        try (FileInputStream in = new FileInputStream(source);
             FileOutputStream out = new FileOutputStream(dest)) {

            byte[] buffer = new byte[8192]; // 8 КБ — оптимальный размер для большинства задач
            int bytesRead;
            while ((bytesRead = in.read(buffer)) != -1) {
                out.write(buffer, 0, bytesRead);
            }
            System.out.println("Копирование завершено!");
        } catch (IOException e) {
            System.out.println("Ошибка при копировании: " + e.getMessage());
        }

    }
}

 */
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        // Исходный массив байтов образца данных
        byte[] data = {1, 2, 3, 4, 5, 6, 7, 8};

        // Имя выходного бинарного файла
        String fileName = "ценный_фрагмент.bin";

        // Записываем ровно 4 байта, начиная с индекса 2 (элементы 3, 4, 5, 6)
        // Используем специализированный метод write(byte[], int offset, int length)
        try(FileOutputStream out = new FileOutputStream(fileName)) {
                out.write(data, 2, 4);

        }



        // Это пример из лекции 36_2
        String source = "image01.png";
        String dest = "image01_copy.png";

        try (FileInputStream in = new FileInputStream(source);
             FileOutputStream out = new FileOutputStream(dest)) {

            byte[] buffer = new byte[8192]; // 8 КБ — оптимальный размер для большинства задач
            int bytesRead;
            while ((bytesRead = in.read(buffer)) != -1) {
                out.write(buffer, 0, bytesRead);
            }
            System.out.println("Копирование завершено!");
        } catch (IOException e) {
            System.out.println("Ошибка при копировании: " + e.getMessage());
        }

    }
}
/*

public class Solution {
    public static void main(String[] args) throws IOException {
        // Исходный массив байтов образца данных
        byte[] data = {1, 2, 3, 4, 5, 6, 7, 8};

        // Имя выходного бинарного файла
        String fileName = "ценный_фрагмент.bin";

        // Записываем ровно 4 байта, начиная с индекса 2 (элементы 3, 4, 5, 6)
        // Используем специализированный метод write(byte[], int offset, int length)
        FileOutputStream out = new FileOutputStream(fileName);
        out.write(data, 2, 4);
        out.close();
    }
}
 */