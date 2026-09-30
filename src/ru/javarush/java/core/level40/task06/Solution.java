package ru.javarush.java.core.level40.task06;
/*
Цифровой библиотекарь: сбор текстовых сокровищ 📚

Представьте, что вы — цифровой библиотекарь, которому поручено собрать все ценные текстовые документы из разросшегося 'цифрового леса' под названием 'data'. В этой директории могут быть сотни папок, вложенных друг в друга, но вас интересуют только файлы с расширением '.txt'.
Ваша программа должна рекурсивно пройтись по всей структуре 'data', отыскать каждый такой текстовый файл и аккуратно скопировать его в специальное хранилище — директорию 'archive'.
Самое главное: вы должны сохранить их первоначальное 'родство', то есть относительную структуру папок, чтобы их было легко найти и после копирования.
Для каждого успешно перемещённого 'томика' ваша система должна отчитаться, выведя на экран: 'Скопирован: [исходный путь] -> [путь назначения]'.
Если же вдруг какой-то файл окажется недоступен для копирования, вы должны быть немедленно уведомлены сообщением: 'Ошибка копирования [исходный путь]: [сообщение об ошибке]'.
Ваша задача — создать безупречный текстовый архив!

Требования:
•	Программа должна рекурсивно просматривать все вложенные папки и файлы, начиная с директории 'data'.
•	Программа должна находить только файлы с расширением '.txt' (регистр не имеет значения).
•	При копировании файлов в директорию 'archive' программа должна сохранять их относительный путь относительно 'data'.
•	Каждый найденный .txt-файл должен быть скопирован в соответствующее место в директории 'archive'.
•	Перед копированием файла программа должна создавать все необходимые папки в 'archive', если их ещё нет.
•	После успешного копирования каждого файла программа должна выводить сообщение: 'Скопирован: [исходный путь] -> [путь назначения]'.
•	Если файл не удалось скопировать, программа должна вывести сообщение: 'Ошибка копирования [исходный путь]: [сообщение об ошибке]'.

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.stream.Stream;

public class Solution {
    public static void main(String[] args) {
        // Корневая директория с исходными файлами
        Path dataDir = Paths.get("data");
        // Корневая директория назначения
        Path archiveDir = Paths.get("archive");

        try {
            // Создаем директорию archive, если ее нет
            Files.createDirectories(archiveDir);
        } catch (IOException e) {
            // Если даже archive не удалось создать — дальше нет смысла продолжать
            System.out.println("Ошибка копирования " + archiveDir + ": " + e.getMessage());
            return;
        }

        // Рекурсивно обходим каталог data


    }
}

 */

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.stream.Stream;

public class Solution {
    public static void main(String[] args) {
        // Корневая директория с исходными файлами
        Path dataDir = Paths.get("data");
        // Корневая директория назначения
        Path archiveDir = Paths.get("archive");

        try {
            // Создаем директорию archive, если ее нет
            Files.createDirectories(archiveDir);
        } catch (IOException e) {
            // Если даже archive не удалось создать — дальше нет смысла продолжать
            System.out.println("Ошибка копирования " + archiveDir + ": " + e.getMessage());
            return;
        }

        // Рекурсивно обходим каталог data
        try {
            var data = Files.walk(dataDir);
            data
                    .filter(Files::isRegularFile)
                    .filter(path -> path.toString().toLowerCase().endsWith(".txt"))
                    .forEach(path -> {
                        Path relative = dataDir.relativize(path);
                        Path targetPath = archiveDir.resolve(relative);
                        try {
                            Files.createDirectories(targetPath.getParent());
                            Files.copy(path, targetPath, StandardCopyOption.REPLACE_EXISTING);
                            System.out.println("Скопирован: " + path + " -> " + targetPath);
                        } catch (IOException e) {
                            System.out.println("Ошибка копирования " + path + ": " + e.getMessage());
                        }

                    });

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}

/*
public class Solution {
    public static void main(String[] args) {
        // Корневая директория с исходными файлами
        Path dataDir = Paths.get("data");
        // Корневая директория назначения
        Path archiveDir = Paths.get("archive");

        try {
            // Создаем директорию archive, если ее нет
            Files.createDirectories(archiveDir);
        } catch (IOException e) {
            // Если даже archive не удалось создать — дальше нет смысла продолжать
            System.out.println("Ошибка копирования " + archiveDir + ": " + e.getMessage());
            return;
        }

        // Рекурсивно обходим каталог data
        try (Stream<Path> paths = Files.walk(dataDir)) {
            paths
                // Берем только обычные файлы
                .filter(Files::isRegularFile)
                // Фильтруем по расширению .txt (регистр не важен)
                .filter(path -> path.getFileName().toString().toLowerCase().endsWith(".txt"))
                .forEach(src -> {
                    // Относительный путь файла относительно data
                    Path relative = dataDir.relativize(src);
                    // Путь назначения в archive с сохранением структуры
                    Path dest = archiveDir.resolve(relative);
                    try {
                        // Создаем недостающие папки в archive
                        Files.createDirectories(dest.getParent());
                        // Копируем файл (перезаписываем, если уже есть)
                        Files.copy(src, dest, StandardCopyOption.REPLACE_EXISTING);

                        System.out.println("Скопирован: " + src + " -> " + dest);
                    } catch (IOException e) {
                        // Отчет об ошибке копирования конкретного файла
                        System.out.println("Ошибка копирования " + src + ": " + e.getMessage());
                    }
                });
        } catch (IOException e) {
            // Обработка общей ошибки обхода директории data
            System.out.println("Ошибка копирования " + dataDir + ": " + e.getMessage());
        }
    }
}
 */