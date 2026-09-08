package ru.javarush.java.core.level37.task08;
/*
Сравнительный анализ "переводчиков": Как меняется смысл текста 🌍

Вы — эксперт по цифровым языкам, и вам предстоит провести наглядную демонстрацию того, как один и тот же multilingualTestMessage может быть воспринят совершенно по-разному в зависимости от того, какой "переводчик" его читает.
Создайте текстовый файл (например, "test_encoding.txt" ) и запишите в него фразу "Тест: Привет, мир! €", убедившись, что файл сохранен в самой распространенной и универсальной кодировке UTF-8.
Затем, используя Files.newBufferedReader, последовательно прочитайте testFilePath три раза, каждый раз указывая разную readingCharset. Сначала используйте правильный UTF-8, затем попробуйте Windows-1251 (популярную для кириллицы, но не для евро) и, наконец, старую ISO-8859-1 (которая совсем не понимает кириллицу и евро).
Для каждого акта чтения выведите на экран название readingCharset и полученный readContent, чтобы наглядно показать, как неправильный "переводчик" может исказить или даже потерять часть исходного сообщения.

Требования:
•	Необходимо создать текстовый файл с именем "test_encoding.txt" и записать в него строку "Тест: Привет, мир! €" в кодировке UTF-8.
•	Файл "test_encoding.txt" должен быть прочитан трижды с помощью Files.newBufferedReader, каждый раз с разной кодировкой.
•	Первое чтение файла должно быть выполнено с использованием Charset UTF-8, чтобы получить корректное отображение текста.
•	Второе чтение файла должно быть выполнено с использованием Charset Windows-1251, чтобы продемонстрировать частичную потерю или искажение символов (например, для символа евро).
•	Третье чтение файла должно быть выполнено с использованием Charset ISO-8859-1, чтобы показать сильные искажения или потерю кириллических символов и символа евро.
•	Для каждого чтения на экран должно быть выведено название используемой кодировки (readingCharset) и фактическое содержимое, прочитанное из файла (readContent).

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Solution {
    public static void main(String[] args) throws IOException {
        // Путь к тестовому файлу
        Path testFilePath = Paths.get("test_encoding.txt");

        // Текст, который сохраняем в UTF-8
        String multilingualTestMessage = "Тест: Привет, мир! €";

        // 1) Создаем/перезаписываем файл и записываем строку в кодировке UTF-8


        // 2) Читаем файл трижды через Files.newBufferedReader с разными "переводчиками" (кодировками)

    }

    // Построчное чтение через Files.newBufferedReader с заданной кодировкой
    private static String readAll(Path path, Charset charset) throws IOException {
        try (BufferedReader reader = Files.newBufferedReader(path, charset)) {
            StringBuilder sb = new StringBuilder();
            String line;
            boolean first = true;
            while ((line = reader.readLine()) != null) {
                // Сохраняем переводы строк, если бы их было несколько
                if (!first) sb.append(System.lineSeparator());
                sb.append(line);
                first = false;
            }
            return sb.toString();
        }
    }
}

 */

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Solution {
    public static void main(String[] args) throws IOException {
        // Путь к тестовому файлу
        Path testFilePath = Paths.get("test_encoding.txt");

        // Текст, который сохраняем в UTF-8
        String multilingualTestMessage = "Тест: Привет, мир! €";

        // 1) Создаем/перезаписываем файл и записываем строку в кодировке UTF-8
        try {
            Files.write(testFilePath, multilingualTestMessage.getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            System.out.println("Ошибка: " + e.getClass().getName());
            ;
        }


        // 2) Читаем файл трижды через Files.newBufferedReader с разными "переводчиками" (кодировками)
        String str1 = readAll(testFilePath, StandardCharsets.UTF_8);
        String str2 = readAll(testFilePath, Charset.forName("Windows-1251"));
        String str3 = readAll(testFilePath, StandardCharsets.ISO_8859_1);
        System.out.println("UTF_8 - " + str1);
        System.out.println("Windows-1251 - " + str2);
        System.out.println("ISO_8859_1 - " + str3);

    }

    // Построчное чтение через Files.newBufferedReader с заданной кодировкой
    private static String readAll(Path path, Charset charset) throws IOException {
        try (BufferedReader reader = Files.newBufferedReader(path, charset)) {
            StringBuilder sb = new StringBuilder();
            String line;
            boolean first = true;
            while ((line = reader.readLine()) != null) {
                // Сохраняем переводы строк, если бы их было несколько
                if (!first) sb.append(System.lineSeparator());
                sb.append(line);
                first = false;
            }
            return sb.toString();
        }
    }
}
/*

public class Solution {
    public static void main(String[] args) throws IOException {
        // Путь к тестовому файлу
        Path testFilePath = Paths.get("test_encoding.txt");

        // Текст, который сохраняем в UTF-8
        String multilingualTestMessage = "Тест: Привет, мир! €";

        // 1) Создаем/перезаписываем файл и записываем строку в кодировке UTF-8
        try (BufferedWriter writer = Files.newBufferedWriter(testFilePath, StandardCharsets.UTF_8)) {
            writer.write(multilingualTestMessage);
        }

        // 2) Читаем файл трижды через Files.newBufferedReader с разными "переводчиками" (кодировками)
        Charset[] variants = new Charset[] {
                StandardCharsets.UTF_8,                   // корректная кодировка
                Charset.forName("Windows-1251"),          // популярная для кириллицы, но без символа €
                StandardCharsets.ISO_8859_1               // не поддерживает кириллицу и €
        };

        for (Charset readingCharset : variants) {
            String readContent = readAll(testFilePath, readingCharset); // читаем файл в заданной кодировке
            System.out.println("readingCharset = " + readingCharset.name());
            System.out.println("readContent    = " + readContent);
            System.out.println(); // пустая строка для отделения результатов
        }
    }

    // Построчное чтение через Files.newBufferedReader с заданной кодировкой
    private static String readAll(Path path, Charset charset) throws IOException {
        try (BufferedReader reader = Files.newBufferedReader(path, charset)) {
            StringBuilder sb = new StringBuilder();
            String line;
            boolean first = true;
            while ((line = reader.readLine()) != null) {
                // Сохраняем переводы строк, если бы их было несколько
                if (!first) sb.append(System.lineSeparator());
                sb.append(line);
                first = false;
            }
            return sb.toString();
        }
    }
}

 */