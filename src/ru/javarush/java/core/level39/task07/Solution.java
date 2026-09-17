package ru.javarush.java.core.level39.task07;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        // Считываем путь к корневой директории с консоли
        Scanner console = new Scanner(System.in);
        String root = console.nextLine();

        Path start = Paths.get(root);

        // Обходим файловую систему с помощью FileVisitor (через SimpleFileVisitor)
        // Files.walkFileTree рекурсивно пройдёт по всем вложенным каталогам
        Files.walkFileTree(start, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
                if (file.getFileName().toString().toLowerCase().endsWith(".txt")) {
                    System.out.println("Найден .txt файл: " + file.toAbsolutePath());
                }
                return FileVisitResult.CONTINUE;
            }
        });

    }
}
/*
Про IO exception я и забыл(@Override public FileVisitResult visitFileFailed(Path file, IOException exc))

Правильный ответ:
public class Solution {
    public static void main(String[] args) throws IOException {
        // Считываем путь к корневой директории с консоли
        Scanner console = new Scanner(System.in);
        String root = console.nextLine();

        Path start = Paths.get(root);

        // Обходим файловую систему с помощью FileVisitor (через SimpleFileVisitor)
        // Files.walkFileTree рекурсивно пройдёт по всем вложенным каталогам
        Files.walkFileTree(start, new SimpleFileVisitor<>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
                // Берём имя файла и проверяем расширение .txt (без учёта регистра)
                String name = file.getFileName().toString().toLowerCase(Locale.ROOT);
                if (name.endsWith(".txt")) {
                    // Выводим сообщение с абсолютным путём к файлу
                    System.out.println("Найден .txt файл: " + file.toAbsolutePath());
                }
                return FileVisitResult.CONTINUE; // продолжаем обход
            }

            @Override
            public FileVisitResult visitFileFailed(Path file, IOException exc) {
                // Если файл недоступен (нет прав и т.п.), просто продолжаем обход
                return FileVisitResult.CONTINUE;
            }
        });
    }
}
 */