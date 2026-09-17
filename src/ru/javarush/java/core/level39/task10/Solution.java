package ru.javarush.java.core.level39.task10;
/*
Смотритель архива: актуализация временной метки
Представьте, что вы — смотритель цифрового архива, и вам необходимо актуализировать метаданные одного из старых, но важных документов. По каким-то причинам время его последней модификации устарело, и вам нужно «обновить» эту временную метку до текущего момента.

Реализуйте программу, которая по заданному вами пути к файлу сможет магическим образом изменить время его последней модификации на текущее системное время.

После того как эта операция будет выполнена, ваша программа должна немедленно отобразить новое, актуальное значение времени последней модификации на экране, чтобы вы могли удостовериться, что изменения применены успешно. Используйте для этого специальные функции для работы с файлами и их атрибутами.

Требования:
•	Программа должна принимать путь к файлу, для которого требуется обновить метаданные.
•	Программа должна изменить время последней модификации указанного файла на текущее системное время.
•	В задаче должны быть использованы стандартные классы и методы Java для работы с атрибутами файлов (например, java.nio.file.Files, java.nio.file.attribute).
•	После изменения времени последней модификации программа должна вывести на экран новое значение этого атрибута для указанного файла.
•	Программа должна убедиться, что время последней модификации действительно обновилось, и отобразить именно актуальное значение.

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileTime;
import java.time.Instant;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        // Считываем путь к файлу с клавиатуры
        Scanner console = new Scanner(System.in);
        System.out.println("Введите путь к файлу:");
        String input = console.nextLine().trim();

        Path path = Paths.get(input);

        try {
            // Читаем текущее значение времени модификации для наглядности и проверки


            // Устанавливаем текущее системное время как время последней модификации
            // (FileTime относится к пакету java.nio.file.attribute)


            // Считываем значение после обновления напрямую из файловой системы


            // Простая проверка успешности: значение после операции отличается от исходного
            // (на некоторых ФС точность метки времени может быть грубее миллисекунд)


            // Выводим новое (актуальное) значение. FileTime печатает ISO-8601 в UTC.

        } catch (IOException e) {
            // Для учебной задачи ограничимся коротким сообщением
            System.out.println("Ошибка при обновлении метаданных: " + e.getMessage());
        }
    }
}

 */

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileTime;
import java.time.Instant;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        // Считываем путь к файлу с клавиатуры
        // D:\__Ра-бо-та_115_h\_ПОЧТА\17.09.2026\Выписка СРО 11_09_2026.pdf
        Scanner console = new Scanner(System.in);
        System.out.println("Введите путь к файлу:");
        String input = console.nextLine().trim();

        Path path = Paths.get(input);

        try {
            FileTime before = Files.getLastModifiedTime(path);

            FileTime now = FileTime.from(Instant.now());
            Files.setLastModifiedTime(path, now);

            FileTime after = Files.getLastModifiedTime(path);
            boolean updated = !after.equals(before);

            System.out.println("Новое время последней модификации (UTC): " + after);
            System.out.println(updated ? "Статус: обновлено успешно." :
                    "Статус: время не изменилось (возможны ограничения точности/прав доступа).");

        } catch (IOException e) {
            System.out.println("Ошибка при чтении атрибутов: " + e.getMessage());
        }


        // Устанавливаем текущее системное время как время последней модификации
        // (FileTime относится к пакету java.nio.file.attribute)


        // Считываем значение после обновления напрямую из файловой системы


        // Простая проверка успешности: значение после операции отличается от исходного
        // (на некоторых ФС точность метки времени может быть грубее миллисекунд)


        // Выводим новое (актуальное) значение. FileTime печатает ISO-8601 в UTC.


    }
}
/*
public class Solution {
    public static void main(String[] args) {
        // Считываем путь к файлу с клавиатуры
        Scanner console = new Scanner(System.in);
        System.out.println("Введите путь к файлу:");
        String input = console.nextLine().trim();

        Path path = Paths.get(input);

        try {
            // Читаем текущее значение времени модификации для наглядности и проверки
            FileTime before = Files.getLastModifiedTime(path);

            // Устанавливаем текущее системное время как время последней модификации
            // (FileTime относится к пакету java.nio.file.attribute)
            FileTime now = FileTime.from(Instant.now());
            Files.setLastModifiedTime(path, now);

            // Считываем значение после обновления напрямую из файловой системы
            FileTime after = Files.getLastModifiedTime(path);

            // Простая проверка успешности: значение после операции отличается от исходного
            // (на некоторых ФС точность метки времени может быть грубее миллисекунд)
            boolean updated = !after.equals(before);

            // Выводим новое (актуальное) значение. FileTime печатает ISO-8601 в UTC.
            System.out.println("Новое время последней модификации (UTC): " + after);
            System.out.println(updated ? "Статус: обновлено успешно." :
                    "Статус: время не изменилось (возможны ограничения точности/прав доступа).");
        } catch (IOException e) {
            // Для учебной задачи ограничимся коротким сообщением
            System.out.println("Ошибка при обновлении метаданных: " + e.getMessage());
        }
    }
}
 */