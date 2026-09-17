package ru.javarush.java.core.level39.task06;
/*
Куратор галереи: инвентаризация изображений
Вы — куратор огромной цифровой галереи, и ваши изображения хранятся в папке "images", а также во множестве её подпапок, вложенных на любую глубину.

Вам нужно провести инвентаризацию и найти абсолютно все изображения формата PNG и JPG, чтобы составить полный каталог. При этом неважно, как написано расширение — ".PNG", ".jpg" или ".JpG" — все они должны быть найдены.

Используя мощные поисковые инструменты вашей системы, которые способны погружаться на неограниченную глубину каталогов, найдите каждый такой файл.

Как только вы обнаружите изображение, немедленно выведите его полный путь на экран, чтобы точно знать, где находится каждое произведение искусства в вашей обширной коллекции.

Требования:
•	Программа должна искать файлы не только в папке "images", но и во всех её подпапках на любую глубину.
•	Для поиска файлов программа должна использовать механизм глоббинга или PathMatcher для фильтрации по расширениям файлов.
•	Программа должна находить файлы с расширениями ".png" и ".jpg" вне зависимости от регистра букв в расширении.
•	Для каждого найденного изображения программа должна выводить на экран его абсолютный путь.
•	Расширения файлов должны сравниваться без учёта регистра (например, ".PNG", ".JpG" и т.д. считаются совпадающими).
•	В результатах должны присутствовать только файлы-изображения, папки и другие типы файлов не должны выводиться.

import java.io.IOException;
import java.nio.file.*;

public class Solution {
    // PathMatcher с регулярным выражением и флагом (?i) — игнорируем регистр расширения
    // Сопоставляем имена, оканчивающиеся на .png или .jpg (любой регистр)
    private static final PathMatcher matcher =
            FileSystems.getDefault().getPathMatcher("regex:(?i).*\\.(png|jpg)");

    public static void main(String[] args) throws IOException {
        // Точка старта — папка "images" рядом с программой
        Path start = Paths.get("images");

        // Если папки нет или это не директория — нечего обходить
        if (!Files.isDirectory(start)) {
            return; // по условию выводим только найденные пути
        }

        // Рекурсивно обходим всю структуру папок
        scan(start);
    }

    // Рекурсивный обход каталога:
    // - используем DirectoryStream с фильтром, чтобы проходить только по директориям
    //   и тем файлам, что подходят по расширению;
    // - для директорий — уходим глубже (рекурсия),
    // - для подходящих файлов — печатаем абсолютный путь.
    private static void scan(Path dir) throws IOException {
        // Фильтр: пропускаем директории и файлы .png/.jpg (без учёта регистра)


    }
}

 */

import java.io.IOException;
import java.nio.file.*;

public class Solution {
    // PathMatcher с регулярным выражением и флагом (?i) — игнорируем регистр расширения
    // Сопоставляем имена, оканчивающиеся на .png или .jpg (любой регистр)
    private static final PathMatcher matcher =
            FileSystems.getDefault().getPathMatcher("regex:(?i).*\\.(png|jpg)");

    public static void main(String[] args) throws IOException {
        // Точка старта — папка "images" рядом с программой
        Path start = Paths.get("images");

        // Если папки нет или это не директория — нечего обходить
        if (!Files.isDirectory(start)) {
            return; // по условию выводим только найденные пути
        }

        // Рекурсивно обходим всю структуру папок
        scan(start);
    }

    // Рекурсивный обход каталога:
    // - используем DirectoryStream с фильтром, чтобы проходить только по директориям
    //   и тем файлам, что подходят по расширению;
    // - для директорий — уходим глубже (рекурсия),
    // - для подходящих файлов — печатаем абсолютный путь.
    private static void scan(Path dir) throws IOException {
        // Фильтр: пропускаем директории и файлы .png/.jpg (без учёта регистра)


        Files.find(dir, Integer.MAX_VALUE, (path, attributes) ->
                        matcher.matches(path.getFileName()) && attributes.isRegularFile())

                .forEach(path -> System.out.println(path.toAbsolutePath()));


    }
}
/*
public class Solution {
    // PathMatcher с регулярным выражением и флагом (?i) — игнорируем регистр расширения
    // Сопоставляем имена, оканчивающиеся на .png или .jpg (любой регистр)
    private static final PathMatcher matcher =
            FileSystems.getDefault().getPathMatcher("regex:(?i).*\\.(png|jpg)");

    public static void main(String[] args) throws IOException {
        // Точка старта — папка "images" рядом с программой
        Path start = Paths.get("images");

        // Если папки нет или это не директория — нечего обходить
        if (!Files.isDirectory(start)) {
            return; // по условию выводим только найденные пути
        }

        // Рекурсивно обходим всю структуру папок
        scan(start);
    }

    // Рекурсивный обход каталога:
    // - используем DirectoryStream с фильтром, чтобы проходить только по директориям
    //   и тем файлам, что подходят по расширению;
    // - для директорий — уходим глубже (рекурсия),
    // - для подходящих файлов — печатаем абсолютный путь.
    private static void scan(Path dir) throws IOException {
        // Фильтр: пропускаем директории и файлы .png/.jpg (без учёта регистра)
        DirectoryStream.Filter<Path> filter = entry ->
                Files.isDirectory(entry)
                        || (Files.isRegularFile(entry) && matcher.matches(entry.getFileName()));

        try (DirectoryStream<Path> entries = Files.newDirectoryStream(dir, filter)) {
            for (Path entry : entries) {
                if (Files.isDirectory(entry)) {
                    scan(entry); // рекурсивный спуск в подпапку
                } else {
                    // Это файл-изображение: выводим его абсолютный путь
                    System.out.println(entry.toAbsolutePath().normalize());
                }
            }
        }
    }
}
 */