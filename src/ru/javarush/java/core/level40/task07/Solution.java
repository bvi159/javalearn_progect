package ru.javarush.java.core.level40.task07;
/*
Уборка временных заметок приложения 🗑️

Вы разрабатываете приложение, которому иногда требуется создавать временные 'заметки' – небольшие файлы для хранения промежуточных данных. Ваша задача — продемонстрировать, как эффективно управлять такими временными ресурсами.
Сначала создайте временный файл, дайте ему любой уникальный префикс и суффикс, чтобы он не затерялся среди других файлов. Запишите в него простую строку: 'temp data'.
После того, как данные будут обработаны (или просто записаны для демонстрации), этот файл становится ненужным. Используя безопасный метод Files.deleteIfExists, убедитесь, что файл удалён. Как только он исчезнет, программа должна с уверенностью сообщить: 'Файл удалён', подтверждая, что порядок восстановлен и никаких следов не осталось.

Требования:
•	Необходимо создать временный файл с уникальным префиксом и суффиксом с помощью стандартных средств Java.
•	В созданный временный файл должна быть записана строка "temp data".
•	Для удаления временного файла должен использоваться метод Files.deleteIfExists.
•	После удаления файла программа должна проверить, что файл действительно удалён, и вывести сообщение "Файл удалён".
•	Весь процесс создания, записи и удаления временного файла должен быть реализован с учётом обработки возможных исключений и корректного закрытия ресурсов.

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class Solution {
    public static void main(String[] args) {
        try {
            // Создаем временный файл: Files самостоятельно добавит уникальную часть между префиксом и суффиксом


            // Записываем строку "temp data" с безопасным закрытием ресурса (try-with-resources)


            // Удаляем временный файл безопасным методом: не бросит исключение, если файл уже отсутствует


            // Дополнительно проверяем, что файла действительно больше нет, и подтверждаем удаление

        } catch (IOException e) {
            // В учебной задаче достаточно кратко сообщить об ошибке
            System.err.println("Ошибка при работе с временным файлом: " + e.getMessage());
        }
    }
}



 */

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class Solution {
    public static void main(String[] args) {
        try {
            // Создаем временный файл: Files самостоятельно добавит уникальную часть между префиксом и суффиксом
            Path myTemp = Files.createTempFile("myTmp_", ".victmp");

            // Записываем строку "temp data" с безопасным закрытием ресурса (try-with-resources)
            try {
                Files.writeString(myTemp, "temp data");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }


            // Удаляем временный файл безопасным методом: не бросит исключение, если файл уже отсутствует
            try {
                Files.deleteIfExists(myTemp);
                if (Files.notExists(myTemp)) {
                    System.out.println("Файл удалён");
                }
            } catch (IOException e) {
                System.out.println("Ошибка: " + e.getMessage());
                ;
            }


            // Дополнительно проверяем, что файла действительно больше нет, и подтверждаем удаление

        } catch (IOException e) {
            // В учебной задаче достаточно кратко сообщить об ошибке
            System.err.println("Ошибка при работе с временным файлом: " + e.getMessage());
        }
    }
}

/*
public class Solution {
    public static void main(String[] args) {
        try {
            // Создаем временный файл: Files самостоятельно добавит уникальную часть между префиксом и суффиксом
            Path tempFile = Files.createTempFile("app-notes-", ".tmp");

            // Записываем строку "temp data" с безопасным закрытием ресурса (try-with-resources)
            try (BufferedWriter writer = Files.newBufferedWriter(tempFile, StandardCharsets.UTF_8)) {
                writer.write("temp data");
            }

            // Удаляем временный файл безопасным методом: не бросит исключение, если файл уже отсутствует
            boolean deleted = Files.deleteIfExists(tempFile);

            // Дополнительно проверяем, что файла действительно больше нет, и подтверждаем удаление
            if (deleted && Files.notExists(tempFile)) {
                System.out.println("Файл удалён");
            }
        } catch (IOException e) {
            // В учебной задаче достаточно кратко сообщить об ошибке
            System.err.println("Ошибка при работе с временным файлом: " + e.getMessage());
        }
    }
}
 */