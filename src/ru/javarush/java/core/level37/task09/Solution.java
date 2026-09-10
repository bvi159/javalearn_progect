package ru.javarush.java.core.level37.task09;
/*
Цифровой архивариус: Миграция старых документов в новый формат 🏛️

Представьте, что вы — цифровой архивариус, и ваша миссия — спасти древние рукописи из устаревшего формата и перевести их на современный, универсальный язык.
У вас есть sourceFilePath с именем "input-1251.txt", который хранится в старой sourceEncoding Windows-1251. Вам нужно перевести все его содержимое в новый targetFilePath "output-utf8.txt", используя универсальную targetEncoding UTF-8, при этом тщательно сохраняя каждую lineOfText и всю структуру исходного документа.
Для чтения используйте Files.newBufferedReader, указав sourceEncoding, а для записи — Files.newBufferedWriter, настроенный на targetEncoding. Ваша программа должна гарантировать, что ни один символ не будет потерян или искажен в процессе этой цифровой миграции.

Требования:
•	Программа должна использовать Files.newBufferedReader и явно указывать кодировку Windows-1251 для чтения файла "input-1251.txt".
•	Программа должна использовать Files.newBufferedWriter и явно указывать кодировку UTF-8 для записи в файл "output-utf8.txt".
•	Программа должна читать исходный файл построчно и записывать каждую строку в выходной файл, сохраняя структуру документа.
•	Программа должна корректно перекодировать все символы из Windows-1251 в UTF-8, не теряя и не искажая ни одного символа.
•	Для корректного закрытия файловых потоков программа должна использовать конструкцию try-with-resources.

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class Solution {
    public static void main(String[] args) throws IOException {
        // Пути к файлам: исходный (Windows-1251) и целевой (UTF-8)
        Path sourceFilePath = Path.of("input-1251.txt");
        Path targetFilePath = Path.of("output-utf8.txt");

        // Явно указываем кодировки для чтения и записи


        // try-with-resources гарантирует корректное закрытие ресурсов

    }
}

 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class Solution {
    public static void main(String[] args) throws IOException {
        // Пути к файлам: исходный (Windows-1251) и целевой (UTF-8)
        Path sourceFilePath = Path.of("input-1251.txt");
        Path targetFilePath = Path.of("output-utf8.txt");

        // Явно указываем кодировки для чтения и записи
//        Files.createFile(targetFilePath);

        try
                (BufferedReader reader = Files.newBufferedReader(sourceFilePath, Charset.forName("Windows-1251"));
                 BufferedWriter writer = Files.newBufferedWriter(targetFilePath, StandardCharsets.UTF_8)
                ) {
            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line);
                writer.newLine(); // не забываем перенос строки!
            }
        }

        System.out.println("Файл успешно перекодирован из Windows-1251 в UTF-8!");


        // try-with-resources гарантирует корректное закрытие ресурсов

    }
}
/*
public class Solution {
    public static void main(String[] args) throws IOException {
        // Пути к файлам: исходный (Windows-1251) и целевой (UTF-8)
        Path sourceFilePath = Path.of("input-1251.txt");
        Path targetFilePath = Path.of("output-utf8.txt");

        // Явно указываем кодировки для чтения и записи
        Charset sourceEncoding = Charset.forName("Windows-1251");
        Charset targetEncoding = StandardCharsets.UTF_8;

        // try-with-resources гарантирует корректное закрытие ресурсов
        try (BufferedReader reader = Files.newBufferedReader(sourceFilePath, sourceEncoding);
             BufferedWriter writer = Files.newBufferedWriter(targetFilePath, targetEncoding)) {

            String lineOfText;
            // Читаем файл построчно и записываем каждую строку в выходной файл
            while ((lineOfText = reader.readLine()) != null) {
                writer.write(lineOfText);   // Записываем строку без изменений (символы корректно перекодируются)
                writer.newLine();           // Восстанавливаем перевод строки (readLine() его убирает)
            }
        }
    }
}
 */