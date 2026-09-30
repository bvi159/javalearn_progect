package ru.javarush.java.core.level40.task05;
/*
Создание резервной копии критически важных данных 💾

Вы — системный администратор, и сегодня ваша задача — обеспечить надёжное резервное копирование жизненно важных проектных данных. Вам нужно создать программу, которая возьмёт все файлы и папки, находящиеся прямо в корневой директории 'data', и скопирует их в отдельную, безопасную папку 'backup'.
Для каждого элемента, который успешно переместится в хранилище, программа должна с гордостью вывести на экран сообщение: 'Скопирован: [имя файла или папки]'. Но если вдруг что-то пойдёт не так и какой-то файл или папка откажется копироваться, ваша система должна немедленно предупредить вас, выведя: 'Ошибка копирования [имя файла или папки]: [сообщение об ошибке]', чтобы вы могли оперативно принять меры. Ваша цель — полный и прозрачный процесс бэкапа.
Требования:
•	Программа должна проверить существование директории 'data' и создать директорию 'backup', если она отсутствует.
•	Программа должна копировать только те файлы и папки, которые находятся непосредственно в корневой директории 'data', без рекурсивного обхода вложенных папок.
•	Программа должна корректно копировать как отдельные файлы, так и целые папки (со всем их содержимым) из 'data' в 'backup'.
•	После успешного копирования каждого файла или папки программа должна вывести сообщение в формате: 'Скопирован: [имя файла или папки]'.
•	Если при копировании любого файла или папки возникает ошибка, программа должна вывести сообщение в формате: 'Ошибка копирования [имя файла или папки]: [сообщение об ошибке]'.
•	Программа должна сохранять оригинальные имена файлов и папок при копировании в папку 'backup'.
•	Для копирования файлов и папок должны использоваться стандартные классы Java (например, Files, Path, File), а не сторонние библиотеки.

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.stream.Stream;

public class Solution {
    public static void main(String[] args) {
        Path data = Paths.get("data");
        Path backup = Paths.get("backup");

        // Проверяем, что директория 'data' существует
        if (Files.notExists(data) || !Files.isDirectory(data)) {
            System.out.println("Директория 'data' не найдена.");
            return;
        }

        try {
            // Создаем 'backup', если ее нет
            Files.createDirectories(backup);
        } catch (IOException e) {
            // Если не смогли создать папку назначения — дальше нет смысла продолжать
            System.out.println("Ошибка копирования backup: " + e.getMessage());
            return;
        }

        // Берем только непосредственные элементы внутри 'data' (без рекурсивного обхода для выбора)



    }

    // Рекурсивная копия каталога с помощью обхода дерева файлов
    private static void copyDirectory(Path sourceDir, Path targetDir) throws IOException {
        Files.walkFileTree(sourceDir, new SimpleFileVisitor<>() {
            @Override
            public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                // Создаем соответствующую директорию в целевом месте (сохраняем относительный путь)
                Path relative = sourceDir.relativize(dir);
                Path dest = targetDir.resolve(relative);
                Files.createDirectories(dest);
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                // Копируем файл, сохраняя структуру и атрибуты
                Path relative = sourceDir.relativize(file);
                Path dest = targetDir.resolve(relative);
                Files.copy(file, dest,
                        StandardCopyOption.REPLACE_EXISTING,
                        StandardCopyOption.COPY_ATTRIBUTES);
                return FileVisitResult.CONTINUE;
            }
        });
    }
}

 */

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.stream.Stream;

public class Solution {
    public static void main(String[] args) {
        Path data = Paths.get("data");
        Path backup = Paths.get("backup");

        // Проверяем, что директория 'data' существует
        if (Files.notExists(data) || !Files.isDirectory(data)) {
            System.out.println("Директория 'data' не найдена.");
            return;
        }

        try {
            // Создаем 'backup', если ее нет
            Files.createDirectories(backup);
        } catch (IOException e) {
            // Если не смогли создать папку назначения — дальше нет смысла продолжать
            System.out.println("Ошибка копирования backup: " + e.getMessage());
            return;
        }

        // Берем только непосредственные элементы внутри 'data' (без рекурсивного обхода для выбора)
        try {
            var stream = Files.list(data);
            stream.forEach(path -> {
                try {
                    copyDirectory(path, backup.resolve(path.getFileName()));
                    System.out.println("Скопирован: " + path.getFileName());
                } catch (IOException e) {
                    System.out.println("Ошибка копирования " + path.getFileName() + ": " + e.getMessage());
                }
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        // Пример из следующей лекции
        String tempDir = System.getProperty("java.io.tmpdir");
        System.out.println("Системная temp-папка: " + tempDir);


    }

    // Рекурсивная копия каталога с помощью обхода дерева файлов
    private static void copyDirectory(Path sourceDir, Path targetDir) throws IOException {
        Files.walkFileTree(sourceDir, new SimpleFileVisitor<>() {
            @Override
            public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                // Создаем соответствующую директорию в целевом месте (сохраняем относительный путь)
                Path relative = sourceDir.relativize(dir);
                Path dest = targetDir.resolve(relative);
                Files.createDirectories(dest);
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                // Копируем файл, сохраняя структуру и атрибуты
                Path relative = sourceDir.relativize(file);
                Path dest = targetDir.resolve(relative);
                Files.copy(file, dest,
                        StandardCopyOption.REPLACE_EXISTING,
                        StandardCopyOption.COPY_ATTRIBUTES);
                return FileVisitResult.CONTINUE;
            }
        });
    }
}
/*
  public class Solution {
    public static void main(String[] args) {
        Path data = Paths.get("data");
        Path backup = Paths.get("backup");

        // Проверяем, что директория 'data' существует
        if (Files.notExists(data) || !Files.isDirectory(data)) {
            System.out.println("Директория 'data' не найдена.");
            return;
        }

        try {
            // Создаем 'backup', если ее нет
            Files.createDirectories(backup);
        } catch (IOException e) {
            // Если не смогли создать папку назначения — дальше нет смысла продолжать
            System.out.println("Ошибка копирования backup: " + e.getMessage());
            return;
        }

        // Берем только непосредственные элементы внутри 'data' (без рекурсивного обхода для выбора)
        try (Stream<Path> items = Files.list(data)) {
            items.forEach(item -> {
                String name = item.getFileName().toString();
                Path target = backup.resolve(name);

                try {
                    if (Files.isDirectory(item)) {
                        // Для каталогов копируем весь их контент рекурсивно
                        copyDirectory(item, target);
                    } else {
                        // Для файлов — простое копирование с заменой и копированием атрибутов
                        Files.copy(item, target,
                                StandardCopyOption.REPLACE_EXISTING,
                                StandardCopyOption.COPY_ATTRIBUTES);
                    }
                    System.out.println("Скопирован: " + name);
                } catch (IOException e) {
                    // Любая ошибка при копировании файла или папки
                    System.out.println("Ошибка копирования " + name + ": " + e.getMessage());
                }
            });
        } catch (IOException e) {
            // Ошибка чтения содержимого 'data'
            System.out.println("Ошибка копирования data: " + e.getMessage());
        }
    }

    // Рекурсивная копия каталога с помощью обхода дерева файлов
    private static void copyDirectory(Path sourceDir, Path targetDir) throws IOException {
        Files.walkFileTree(sourceDir, new SimpleFileVisitor<>() {
            @Override
            public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                // Создаем соответствующую директорию в целевом месте (сохраняем относительный путь)
                Path relative = sourceDir.relativize(dir);
                Path dest = targetDir.resolve(relative);
                Files.createDirectories(dest);
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                // Копируем файл, сохраняя структуру и атрибуты
                Path relative = sourceDir.relativize(file);
                Path dest = targetDir.resolve(relative);
                Files.copy(file, dest,
                        StandardCopyOption.REPLACE_EXISTING,
                        StandardCopyOption.COPY_ATTRIBUTES);
                return FileVisitResult.CONTINUE;
            }
        });
    }
}
 */