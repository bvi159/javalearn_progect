package ru.javarush.java.core.level41.task06;
/*
Разделение галактических чертежей на модули 🏗️

Вы — архитектор данных, отвечающий за управление огромными чертежами галактических станций. Каждый чертеж — это колоссальный файл, который невозможно обрабатывать целиком.
Для удобства транспортировки и сборки вам нужно разделить каждый такой гигантский файл на стандартизированные, управляемые "модули" фиксированного размера, скажем, по 4096 байт каждый.
Ваша программа должна выполнить эту операцию и по окончании работы сообщить, на сколько именно таких "модулей" был успешно разделен чертеж.

Требования:
•	Программа должна читать исходный файл порциями (чанками) фиксированного размера — по 4096 байт за раз.
•	Каждый считанный чанк должен быть записан в отдельный выходной файл (модуль).
•	Выходные файлы должны именоваться так, чтобы было понятно, к какому оригинальному файлу и к какому номеру чанка они относятся.
•	Если размер исходного файла не кратен 4096, последний модуль должен содержать только оставшиеся байты.
•	Программа должна корректно подсчитать и вывести общее количество созданных модулей (чанков) после завершения операции.

mport java.io.*;
import java.util.Scanner;

public class Solution {
    // Фиксированный размер чанка (модуля) — 4 КБ
    private static final int CHUNK_SIZE = 4096;

    public static void main(String[] args) throws Exception {

        // Считываем путь к исходному файлу без лишних подсказок (удобно для автотестов)


        // имя исходного файла без пути
        // каталог исходного файла

        // счётчик созданных модулей

        // Читаем исходный файл блоками по 4096 байт



        // Имя выходного файла: <имя_оригинала>.moduleNNNN (сохраняем привязку к исходному файлу и номеру модуля)


        // Пишем модуль рядом с исходным файлом; если родительской папки нет — в текущую


        // ВАЖНО: записываем ровно bytesRead, чтобы последний модуль был нужного размера (меньше 4096)



        // Выводим общее количество созданных модулей

    }
}

 */

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

public class Solution {
    // Фиксированный размер чанка (модуля) — 4 КБ
    private static final int CHUNK_SIZE = 4096;

    public static void main(String[] args) throws Exception {
        Scanner console = new Scanner(System.in);
        // Считываем путь к исходному файлу без лишних подсказок (удобно для автотестов)
        String inputPath = console.nextLine().trim();

        File inputFile = new File(inputPath);
        String originalName = inputFile.getName(); // имя исходного файла без пути
        File parentDir = inputFile.getAbsoluteFile().getParentFile(); // каталог исходного файла

        int modules = 0; // счётчик созданных модулей

        // Читаем исходный файл блоками по 4096 байт
        try (BufferedInputStream in = new BufferedInputStream(new FileInputStream(inputFile))) {
            byte[] buffer = new byte[CHUNK_SIZE];
            int bytesRead;

            while ((bytesRead = in.read(buffer)) != -1) {
                modules++;

                // Имя выходного файла: <имя_оригинала>.moduleNNNN (сохраняем привязку к исходному файлу и номеру модуля)
                String chunkFileName = originalName + ".module" + String.format("%04d", modules);

                // Пишем модуль рядом с исходным файлом; если родительской папки нет — в текущую
                File outFile = (parentDir != null) ? new File(parentDir, chunkFileName) : new File(chunkFileName);

                // ВАЖНО: записываем ровно bytesRead, чтобы последний модуль был нужного размера (меньше 4096)
                try (BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(outFile))) {
                    out.write(buffer, 0, bytesRead);
                }
            }
        }

        // Выводим общее количество созданных модулей
        System.out.println(modules);
    }
}
/*
 // Фиксированный размер чанка (модуля) — 4 КБ
    private static final int CHUNK_SIZE = 4096;

    public static void main(String[] args) throws Exception {
        Scanner console = new Scanner(System.in);
        // Считываем путь к исходному файлу без лишних подсказок (удобно для автотестов)
        String inputPath = console.nextLine().trim();

        File inputFile = new File(inputPath);
        String originalName = inputFile.getName(); // имя исходного файла без пути
        File parentDir = inputFile.getAbsoluteFile().getParentFile(); // каталог исходного файла

        int modules = 0; // счётчик созданных модулей

        // Читаем исходный файл блоками по 4096 байт
        try (BufferedInputStream in = new BufferedInputStream(new FileInputStream(inputFile))) {
            byte[] buffer = new byte[CHUNK_SIZE];
            int bytesRead;

            while ((bytesRead = in.read(buffer)) != -1) {
                modules++;

                // Имя выходного файла: <имя_оригинала>.moduleNNNN (сохраняем привязку к исходному файлу и номеру модуля)
                String chunkFileName = originalName + ".module" + String.format("%04d", modules);

                // Пишем модуль рядом с исходным файлом; если родительской папки нет — в текущую
                File outFile = (parentDir != null) ? new File(parentDir, chunkFileName) : new File(chunkFileName);

                // ВАЖНО: записываем ровно bytesRead, чтобы последний модуль был нужного размера (меньше 4096)
                try (BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(outFile))) {
                    out.write(buffer, 0, bytesRead);
                }
            }
        }

        // Выводим общее количество созданных модулей
        System.out.println(modules);
    }
 */