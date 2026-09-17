package ru.javarush.java.core.level38.task10;
/*
Секретное послание с самоликвидацией: безопасно записать и стереть 💥

Представьте, что вы — шпион, которому нужно передать важное, но очень чувствительное послание. Оно должно быть записано на временном носителе и немедленно уничтожено после прочтения, не оставив следов.
Ваша программа должна создать такой временный файл, используя Files.createTempFile. Затем, с помощью BufferedWriter, она должна записать в него секретную фразу "Hello, temp!".
Самое важное: процесс записи должен быть заключен в конструкцию try-with-resources, чтобы даже в случае сбоя ресурс был корректно закрыт.
Сразу после того, как послание будет записано и "прочитано", этот временный файл должен быть полностью удалён. Как только он исчезнет без следа, программа должна подтвердить успех операции сообщением: "Временный файл удалён", гарантируя полную безопасность вашей миссии.

Требования:
•	Программа должна создавать временный файл с помощью метода Files.createTempFile.
•	Секретная фраза "Hello, temp!" должна быть записана во временный файл с использованием BufferedWriter.
•	Процесс записи во временный файл должен быть реализован внутри блока try-with-resources для гарантированного закрытия BufferedWriter даже при возникновении исключений.
•	Сразу после записи и "прочтения" содержимого, временный файл должен быть полностью удалён с файловой системы.
•	После удаления временного файла программа должна вывести сообщение "Временный файл удалён".

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class Solution {
    public static void main(String[] args) throws IOException {
        // Создаем временный файл в системной temp-директории


        // Пишем секретное сообщение в файл.
        // try-with-resources гарантирует закрытие BufferedWriter даже при ошибках.


        // "Читаем" содержимое файла (симулируем прочтение) — выводить на экран не будем
        // чтобы не оставлять следов.


        // Немедленно удаляем временный файл после прочтения


        // Подтверждаем успешное удаление

    }
}

 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class Solution {
    public static void main(String[] args) throws IOException {
        // Создаем временный файл в системной temp-директории
        Path pathToSecret = Files.createTempFile("temp_", ".tmp");

        // Пишем секретное сообщение в файл.
        // try-with-resources гарантирует закрытие BufferedWriter даже при ошибках.
        try (BufferedWriter out = Files.newBufferedWriter(pathToSecret, StandardCharsets.UTF_8);
             BufferedReader in = Files.newBufferedReader(pathToSecret, StandardCharsets.UTF_8)) {
            out.write("Hello, temp!");
            out.close();
            String inRead = in.readLine();
//            System.out.println("Это прочитано из файла temp: " + inRead);
            Files.deleteIfExists(pathToSecret);
            System.out.println("Временный файл удалён");
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден: " + e.getMessage());
        }


        // "Читаем" содержимое файла (симулируем прочтение) — выводить на экран не будем
        // чтобы не оставлять следов.


        // Немедленно удаляем временный файл после прочтения


        // Подтверждаем успешное удаление

    }
}
/*
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class Solution {
    public static void main(String[] args) throws IOException {
        // Создаем временный файл в системной temp-директории
        Path tempFile = Files.createTempFile("secret-", ".txt");

        // Пишем секретное сообщение в файл.
        // try-with-resources гарантирует закрытие BufferedWriter даже при ошибках.
        try (BufferedWriter writer = Files.newBufferedWriter(tempFile, StandardCharsets.UTF_8)) {
            writer.write("Hello, temp!");
        }

        // "Читаем" содержимое файла (симулируем прочтение) — выводить на экран не будем
        // чтобы не оставлять следов.
        String message = Files.readString(tempFile, StandardCharsets.UTF_8);

        // Немедленно удаляем временный файл после прочтения
        Files.delete(tempFile);

        // Подтверждаем успешное удаление
        System.out.println("Временный файл удалён");
    }
}

 */