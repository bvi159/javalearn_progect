package ru.javarush.java.core.level41.task09;
/*
Отправка секретного доклада в космос: Операция "Сжатие" 🚀
Вы — инженер по космическим коммуникациям. Вам нужно отправить критически важный, но очень объемный секретный доклад, находящийся в файле "input.txt", на далекую космическую станцию.

Проблема в том, что каждый байт в космосе на счету, и передавать несжатые данные — это непозволительная роскошь. Ваша задача — использовать передовые технологии GZIPOutputStream, чтобы "ужать" этот доклад, превратив его в компактный "input.txt.gz".

После выполнения этой важной миссии, готовый, сжатый файл должен появиться в вашей текущей директории, готовый к мгновенной "телепортации" сквозь просторы космоса.

Требования:
•	Программа должна использовать класс GZIPOutputStream для сжатия данных.
•	Исходный файл с названием "input.txt" должен быть прочитан из текущей директории.
•	Результатом работы программы должен быть файл "input.txt.gz", созданный в текущей директории.
•	Содержимое файла "input.txt" должно быть записано в файл "input.txt.gz" в сжатом виде с помощью GZIPOutputStream.
•	Все используемые потоки ввода-вывода должны быть корректно закрыты после завершения работы программы (например, с помощью try-with-resources).

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.zip.GZIPOutputStream;

public class Solution {
    public static void main(String[] args) throws IOException {
        // Пути к исходному и целевому файлам в текущей директории
        Path source = Path.of("input.txt");
        Path target = Path.of("input.txt.gz");

        // try-with-resources гарантирует корректное закрытие потоков
        // Закрытие GZIPOutputStream автоматически допишет служебные данные (finish)

            // Копируем данные поблочно из исходного файла в GZIP-поток


    }
}

 */

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.zip.GZIPOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Solution {
    public static void main(String[] args) throws IOException {
        // Пути к исходному и целевому файлам в текущей директории
        Path source = Path.of("input.txt");
        Path target = Path.of("input.txt.gz");

        // try-with-resources гарантирует корректное закрытие потоков
        // Закрытие GZIPOutputStream автоматически допишет служебные данные (finish)
        try (GZIPOutputStream gos = new GZIPOutputStream(Files.newOutputStream(target));
             InputStream fis = Files.newInputStream(source)) {
            fis.transferTo(gos);
        }

        // Копируем данные поблочно из исходного файла в GZIP-поток


    }
}
/*
public class Solution {
    public static void main(String[] args) throws IOException {
        // Пути к исходному и целевому файлам в текущей директории
        Path source = Path.of("input.txt");
        Path target = Path.of("input.txt.gz");

        // try-with-resources гарантирует корректное закрытие потоков
        // Закрытие GZIPOutputStream автоматически допишет служебные данные (finish)
        try (InputStream in = Files.newInputStream(source);
             GZIPOutputStream gzipOut = new GZIPOutputStream(Files.newOutputStream(target))) {

            // Копируем данные поблочно из исходного файла в GZIP-поток
            byte[] buffer = new byte[8192];
            int read;
            while ((read = in.read(buffer)) != -1) {
                gzipOut.write(buffer, 0, read);
            }
        }
    }
}

 */