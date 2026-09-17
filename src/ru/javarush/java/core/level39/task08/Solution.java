package ru.javarush.java.core.level39.task08;
/*
Цифровой уборщик: безвозвратное удаление проекта
Вы — оператор мощного цифрового уборщика, и вам поручено полностью очистить систему от устаревшего проекта, который занимает слишком много места. Этот проект находится в одной конкретной директории, но внутри неё могут быть бесчисленные файлы и вложенные папки, которые тоже нужно безвозвратно удалить.

Ваша задача — реализовать программу, которая сможет аккуратно и полностью избавиться от всего содержимого указанной директории, включая все её вложенные файлы и папки, а затем удалить и саму эту директорию. Используйте для этого специальные системные средства, которые позволяют совершать обход файлового дерева. Каждый раз, когда ваш цифровой уборщик успешно удаляет файл или папку, он должен сообщать об этом, выводя на экран строку: "Удалён: " и полный путь к только что уничтоженному элементу.

Требования:
•	Программа должна использовать интерфейс FileVisitor (или SimpleFileVisitor) для рекурсивного обхода всех файлов и папок внутри указанной директории.
•	Все вложенные файлы и папки должны быть удалены до удаления самой исходной директории (папки проекта).
•	Каждый файл в целевой директории и её поддиректориях должен быть удалён с помощью соответствующего метода (например, Files.delete).
•	Каждая папка (включая вложенные) должна быть удалена после удаления всех её содержимого.
•	После успешного удаления каждого файла или папки программа должна выводить на экран строку "Удалён: " и полный путь к удалённому элементу.
•	После удаления всех вложенных файлов и папок программа должна удалить и саму исходную директорию.
•	В случае возникновения ошибки при удалении файла или папки программа должна корректно обработать исключение и не завершаться аварийно.

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        // Считываем путь до директории, которую нужно удалить целиком
        Scanner console = new Scanner(System.in);
        System.out.println("Введите путь к директории, которую нужно удалить полностью:");
        String input = console.nextLine().trim();

        Path root = Paths.get(input);

        // Небольшая проверка входных данных — чтобы программа вежливо завершалась
        if (!Files.exists(root)) {
            System.out.println("Указанный путь не существует: " + root.toAbsolutePath());
            return;
        }
        if (!Files.isDirectory(root)) {
            System.out.println("Это не директория: " + root.toAbsolutePath());
            return;
        }

        // Обход дерева с помощью SimpleFileVisitor:
        // - visitFile: удаляем каждый файл
        // - postVisitDirectory: после удаления всех вложенных элементов удаляем саму папку


    }
}

 */

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        // Считываем путь до директории, которую нужно удалить целиком
        Scanner console = new Scanner(System.in);
        System.out.println("Введите путь к директории, которую нужно удалить полностью:");
        String input = console.nextLine().trim();

        Path root = Paths.get(input);
//-----------------------фрагмент из следующей лекции - после использования удалить
        //  D:\__Ра-бо-та_115_h\_ПОЧТА\17.09.2026\Выписка СРО 11_09_2026.pdf
        try {
            FileTime newTime = FileTime.fromMillis(System.currentTimeMillis() - 24 * 60 * 60 * 1000); // минус 1 день
            Files.setLastModifiedTime(root, newTime);
            System.out.println("Время последней модификации изменено!");
        } catch (IOException e) {
            System.out.println("Ошибка при изменении времени: " + e.getMessage());
        }
        try {
            // Получаем view для базовых атрибутов
            BasicFileAttributeView view = Files.getFileAttributeView(
                    root, BasicFileAttributeView.class
            );

            // Читаем текущие времена
            BasicFileAttributes attrs = view.readAttributes();
            FileTime lastModified = attrs.lastModifiedTime();
            FileTime lastAccess = attrs.lastAccessTime();
            FileTime creation = attrs.creationTime();

            // Сдвигаем каждое на -1 год (365 дней в миллисекундах)
            long YEAR = 365L * 24 * 60 * 60 * 1000;

            FileTime newModified = FileTime.fromMillis(lastModified.toMillis() - YEAR);
            FileTime newAccess = FileTime.fromMillis(lastAccess.toMillis() - YEAR);
            FileTime newCreation = FileTime.fromMillis(creation.toMillis() - YEAR);

            // setTimes(lastModified, lastAccess, creation)
            view.setTimes(newModified, newAccess, newCreation);

            System.out.println("Все три времени уменьшены на 1 год!");
            System.out.println("  lastModified: " + newModified);
            System.out.println("  lastAccess:   " + newAccess);
            System.out.println("  creation:     " + newCreation);

        } catch (IOException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
        try {
            Files.setAttribute(root, "dos:hidden", true);
            System.out.println("Файл стал скрытым (если поддерживается ОС).");
        } catch (UnsupportedOperationException e) {
            System.out.println("Скрытые файлы не поддерживаются на этой ОС.");
        }
        //    -----------------------------------

        // Небольшая проверка входных данных — чтобы программа вежливо завершалась
        if (!Files.exists(root)) {
            System.out.println("Указанный путь не существует: " + root.toAbsolutePath());
            return;
        }
        if (!Files.isDirectory(root)) {
            System.out.println("Это не директория: " + root.toAbsolutePath());
            return;
        }

        // Обход дерева с помощью SimpleFileVisitor:
        // - visitFile: удаляем каждый файл
        // - postVisitDirectory: после удаления всех вложенных элементов удаляем саму папку
        try {
            Files.walkFileTree(root, new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    Files.delete(file); // удаляем файл
                    System.out.println("Удалён: " + file.toAbsolutePath());
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                    Files.delete(dir); // удаляем папку после того, как удалили всё внутри
                    System.out.println("Удалён: " + dir.toAbsolutePath());
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
                    System.err.println("Ошибка доступа к файлу: " + file + " (" + exc + ")");
                    return FileVisitResult.CONTINUE;
                }
            });
        } catch (IOException e) {
            System.out.println("Не могу " + e.getClass().getName());
        }

    }
}
/*
public class Solution {
    public static void main(String[] args) {
        // Считываем путь до директории, которую нужно удалить целиком
        Scanner console = new Scanner(System.in);
        System.out.println("Введите путь к директории, которую нужно удалить полностью:");
        String input = console.nextLine().trim();

        Path root = Paths.get(input);

        // Небольшая проверка входных данных — чтобы программа вежливо завершалась
        if (!Files.exists(root)) {
            System.out.println("Указанный путь не существует: " + root.toAbsolutePath());
            return;
        }
        if (!Files.isDirectory(root)) {
            System.out.println("Это не директория: " + root.toAbsolutePath());
            return;
        }

        // Обход дерева с помощью SimpleFileVisitor:
        // - visitFile: удаляем каждый файл
        // - postVisitDirectory: после удаления всех вложенных элементов удаляем саму папку
        try {
            Files.walkFileTree(root, new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
                    // Удаляем файл по мере посещения
                    try {
                        Files.delete(file);
                        System.out.println("Удалён: " + file.toAbsolutePath());
                    } catch (IOException e) {
                        // Сообщаем об ошибке и продолжаем обход
                        System.out.println("Не удалось удалить файл: " + file.toAbsolutePath() + " (" + e.getMessage() + ")");
                    }
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult postVisitDirectory(Path dir, IOException exc) {
                    // Если при обходе директории была ошибка — сообщим, но попытаемся удалить папку
                    if (exc != null) {
                        System.out.println("Проблема при обходе директории: " + dir.toAbsolutePath() + " (" + exc.getMessage() + ")");
                    }
                    // Удаляем директорию после удаления её содержимого
                    try {
                        Files.delete(dir);
                        System.out.println("Удалён: " + dir.toAbsolutePath());
                    } catch (IOException e) {
                        System.out.println("Не удалось удалить папку: " + dir.toAbsolutePath() + " (" + e.getMessage() + ")");
                    }
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult visitFileFailed(Path file, IOException exc) {
                    // Если атрибуты файла прочесть не удалось (например, нет доступа),
                    // попробуем всё равно удалить его. Если не получится — сообщим и продолжим.
                    try {
                        Files.delete(file);
                        System.out.println("Удалён: " + file.toAbsolutePath());
                    } catch (IOException e) {
                        String msg = exc != null ? exc.getMessage() : e.getMessage();
                        System.out.println("Не удалось получить доступ/удалить: " + file.toAbsolutePath() + " (" + msg + ")");
                    }
                    return FileVisitResult.CONTINUE;
                }
            });
        } catch (IOException e) {
            // Общая непредвиденная ошибка обхода — сообщаем и завершаем аккуратно
            System.out.println("Ошибка при обходе файловой системы: " + e.getMessage());
        }
    }
}
 */