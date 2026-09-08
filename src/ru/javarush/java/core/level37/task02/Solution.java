package ru.javarush.java.core.level37.task02;
/*
Сохранение и восстановление магического свитка 📜

Вы — хранитель древних цифровых знаний, и ваша задача — сохранить важную magicInscription "Привет, Java!" на магическом свитке, а затем прочитать её обратно, убедившись, что ни одна буква не исказилась.
Этот свиток будет называться fileName "output.txt", и для его создания вы должны использовать OutputStreamWriter, тщательно обернув его в кодировку UTF-8, чтобы сохранить всю мудрость.
После того как ваша magicInscription будет записана, пришло время прочесть её. Используйте InputStreamReader, также настроенный на кодировку UTF-8, чтобы восстановить savedScrollContent из файла.
В конце покажите восстановленное послание на экране, подтверждая, что магия кодирования сработала безупречно.

Требования:
•	В программе должны быть объявлены переменные: magicInscription со значением "Привет, Java!", fileName со значением "output.txt" и savedScrollContent для хранения прочитанного текста.
•	Для записи magicInscription в файл output.txt должен использоваться OutputStreamWriter, обёрнутый вокруг FileOutputStream, с указанием кодировки UTF-8.
•	Для чтения содержимого файла output.txt должна использоваться комбинация InputStreamReader и FileInputStream, также с указанием кодировки UTF-8.
•	Содержимое, прочитанное из файла, должно быть полностью идентично исходной строке magicInscription ("Привет, Java!").
•	Программа должна вывести на экран значение переменной savedScrollContent, чтобы подтвердить успешность записи и чтения с учётом кодировки.

 import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

public class Solution {
    public static void main(String[] args) throws Exception {
        // Объявляем требуемые переменные
        String magicInscription = "Привет, Java!";
        String fileName = "output.txt";


        // Запись строки в файл:
        // OutputStreamWriter оборачивает FileOutputStream, кодировка — UTF-8


        // Чтение строки из файла:
        // InputStreamReader оборачивает FileInputStream, кодировка — UTF-8


        // Вывод восстановленного текста на экран

    }
}

 */

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

public class Solution {
    public static void main(String[] args) throws Exception {
        String magicInscription = "Привет, Java!";
        String fileName = "output.txt";

        // ✅ Запись: кодировка в OutputStreamWriter
        try (OutputStreamWriter writer = new OutputStreamWriter(
                new FileOutputStream(fileName),    // FileOutputStream без кодировки
                StandardCharsets.UTF_8             // Кодировка здесь
        )) {
            writer.write(magicInscription);
        }

        // ✅ Чтение: кодировка в InputStreamReader
        try (InputStreamReader reader = new InputStreamReader(
                new FileInputStream(fileName),
                StandardCharsets.UTF_8
        )) {

            StringBuilder savedScrollContent = new StringBuilder();
            int c;
            while ((c = reader.read()) != -1) {
                savedScrollContent.append((char) c);
            }
            System.out.println(savedScrollContent);
        }
    }
}
/*

public class Solution {
    public static void main(String[] args) throws Exception {
        // Объявляем требуемые переменные
        String magicInscription = "Привет, Java!";
        String fileName = "output.txt";
        String savedScrollContent;

        // Запись строки в файл:
        // OutputStreamWriter оборачивает FileOutputStream, кодировка — UTF-8
        try (OutputStreamWriter writer = new OutputStreamWriter(
                new FileOutputStream(fileName), StandardCharsets.UTF_8)) {
            writer.write(magicInscription);
        }

        // Чтение строки из файла:
        // InputStreamReader оборачивает FileInputStream, кодировка — UTF-8
        StringBuilder builder = new StringBuilder();
        try (InputStreamReader reader = new InputStreamReader(
                new FileInputStream(fileName), StandardCharsets.UTF_8)) {
            char[] buffer = new char[256]; // буфер для последовательного чтения
            int read;
            while ((read = reader.read(buffer)) != -1) {
                builder.append(buffer, 0, read);
            }
        }
        savedScrollContent = builder.toString();

        // Вывод восстановленного текста на экран
        System.out.println(savedScrollContent);
    }
}

 */