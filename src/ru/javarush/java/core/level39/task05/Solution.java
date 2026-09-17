package ru.javarush.java.core.level39.task05;
/*
Аналитик данных: отбор критически важных отчётов
Представьте, что вы — аналитик данных в крупной корпорации, и к вам в папку "data" ежедневно стекаются сотни отчётов. Среди них есть как ценные файлы, так и просто системные папки или ненужные черновики.

Ваша задача — срочно отобрать только те отчёты, которые представляют собой обычные файлы, а не папки, и при этом их имена начинаются строго с буквы "A" и оканчиваются на ".csv".

Используя специальные инструменты для потоковой обработки директорий, настройте фильтр таким образом, чтобы он пропустил только эти специфические документы. Затем выведите на экран имена каждого найденного файла, чтобы получить только те данные, которые действительно важны для вашего анализа.

Требования:
•	Необходимо использовать DirectoryStream для перебора содержимого папки "data".
•	При создании DirectoryStream нужно применить фильтр (DirectoryStream.Filter), который будет пропускать только необходимые файлы.
•	Фильтр должен пропускать только объекты, которые являются обычными файлами, а не директориями.
•	Фильтр должен проверять, что имя файла начинается с буквы "A" и заканчивается на ".csv". Для этого можно использовать PathMatcher с соответствующим шаблоном или ручную проверку имени файла.
•	Программа должна выводить на экран имена всех файлов, прошедших фильтр.Аналитик данных: отбор критически важных отчётов
Представьте, что вы — аналитик данных в крупной корпорации, и к вам в папку "data" ежедневно стекаются сотни отчётов. Среди них есть как ценные файлы, так и просто системные папки или ненужные черновики.

Ваша задача — срочно отобрать только те отчёты, которые представляют собой обычные файлы, а не папки, и при этом их имена начинаются строго с буквы "A" и оканчиваются на ".csv".

Используя специальные инструменты для потоковой обработки директорий, настройте фильтр таким образом, чтобы он пропустил только эти специфические документы. Затем выведите на экран имена каждого найденного файла, чтобы получить только те данные, которые действительно важны для вашего анализа.

Требования:
•	Необходимо использовать DirectoryStream для перебора содержимого папки "data".
•	При создании DirectoryStream нужно применить фильтр (DirectoryStream.Filter), который будет пропускать только необходимые файлы.
•	Фильтр должен пропускать только объекты, которые являются обычными файлами, а не директориями.
•	Фильтр должен проверять, что имя файла начинается с буквы "A" и заканчивается на ".csv". Для этого можно использовать PathMatcher с соответствующим шаблоном или ручную проверку имени файла.
•	Программа должна выводить на экран имена всех файлов, прошедших фильтр.

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Solution {
    public static void main(String[] args) throws IOException {
        // Папка с отчётами
        Path dataDir = Paths.get("data");

        // Фильтр для DirectoryStream:
        // 1) пропускаем только обычные файлы (не директории);
        // 2) имя файла должно начинаться с 'A' и заканчиваться на ".csv".


        // Перебираем содержимое папки "data" через DirectoryStream с нашим фильтром

    }
}

 */

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Solution {
    public static void main(String[] args) throws IOException {
        Path dataDir = Paths.get("data");

        DirectoryStream.Filter<Path> filter = path ->
                Files.isRegularFile(path)
                        && path.getFileName().toString().startsWith("A")
                        && path.getFileName().toString().endsWith(".csv");

        try (DirectoryStream<Path> stream = Files.newDirectoryStream(dataDir, filter)) {
            stream.forEach(path -> System.out.println(path.getFileName()));
        }
    }
}
/*
public class Solution {
    public static void main(String[] args) throws IOException {
        // Папка с отчётами
        Path dataDir = Paths.get("data");

        // Фильтр для DirectoryStream:
        // 1) пропускаем только обычные файлы (не директории);
        // 2) имя файла должно начинаться с 'A' и заканчиваться на ".csv".
        DirectoryStream.Filter<Path> filter = entry -> {
            if (!Files.isRegularFile(entry)) {
                return false;
            }
            String name = entry.getFileName().toString();
            return name.startsWith("A") && name.endsWith(".csv");
        };

        // Перебираем содержимое папки "data" через DirectoryStream с нашим фильтром
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(dataDir, filter)) {
            for (Path p : stream) {
                // Выводим только имя файла (без пути)
                System.out.println(p.getFileName());
            }
        }
    }
}
 */