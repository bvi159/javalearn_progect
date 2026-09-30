package ru.javarush.java.core.level42.task01;
/*
Сжатие строки в ZIP-архив
Представьте, что вы — тайный агент, которому нужно передать сверхсекретное сообщение. Чтобы оно заняло как можно меньше места и было готово к передаче, вам нужно его заархивировать.

Ваша программа должна создать специальный "контейнер" под названием "hello.zip" и поместить внутрь него файл "hello.txt", который будет содержать ваше секретное послание: "Hello, ZIP!".

Для этого ответственного задания воспользуйтесь инструментом ZipOutputStream.

Требования:
•	Программа должна создать архивный файл с именем "hello.zip" в текущей директории.
•	Внутри архива "hello.zip" должен быть создан файл "hello.txt".
•	Файл "hello.txt" внутри архива должен содержать текст "Hello, ZIP!".
•	Для создания ZIP-архива и помещения файла в него необходимо использовать класс ZipOutputStream.
•	Все используемые потоки ввода-вывода должны быть корректно закрыты после завершения работы программы.
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Solution {
    public static void main(String[] args) {
        // Имена архива и файла внутри него


        // Текст секретного послания


        // try-with-resources автоматически закроет ZipOutputStream и вложенный FileOutputStream

        // Создаем новую запись (файл) внутри архива с именем hello.txt


        // Записываем содержимое файла в архив (в байтовом виде, кодировка UTF-8)


        // Закрываем текущую запись (обязательный шаг перед закрытием архива)


        // Для учебной задачи достаточно распечатать стек исключения


    }
}

 */

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Solution {
    public static void main(String[] args) {
        // Имена архива и файла внутри него
        String zipArchive = "hello.zip";
        String zipFile = "hello.txt";

        // Текст секретного послания
        String zipMessage = "Hello, ZIP!";

        // try-with-resources автоматически закроет ZipOutputStream и вложенный FileOutputStream
        try (ZipOutputStream zos = new ZipOutputStream(Files.newOutputStream(Paths.get(zipArchive)))) {
            // Создаем новую запись (файл) внутри архива с именем hello.txt
            ZipEntry entry = new ZipEntry(zipFile);
            zos.putNextEntry(entry);
            // Записываем содержимое файла в архив (в байтовом виде, кодировка UTF-8)
            zos.write(zipMessage.getBytes(StandardCharsets.UTF_8));
            // Закрываем текущую запись (обязательный шаг перед закрытием архива)
            zos.closeEntry();
        } catch (IOException e) {
            // Для учебной задачи достаточно распечатать стек исключения
            //throw new RuntimeException(e);
            e.printStackTrace();
        }


    }
}
/*
public class Solution {
    public static void main(String[] args) {
        // Имена архива и файла внутри него
        String zipFileName = "hello.zip";
        String entryName = "hello.txt";

        // Текст секретного послания
        String message = "Hello, ZIP!";

        // try-with-resources автоматически закроет ZipOutputStream и вложенный FileOutputStream
        try (ZipOutputStream zipOut = new ZipOutputStream(new FileOutputStream(zipFileName))) {
            // Создаем новую запись (файл) внутри архива с именем hello.txt
            ZipEntry entry = new ZipEntry(entryName);
            zipOut.putNextEntry(entry);

            // Записываем содержимое файла в архив (в байтовом виде, кодировка UTF-8)
            byte[] data = message.getBytes(StandardCharsets.UTF_8);
            zipOut.write(data);

            // Закрываем текущую запись (обязательный шаг перед закрытием архива)
            zipOut.closeEntry();
        } catch (IOException e) {
            // Для учебной задачи достаточно распечатать стек исключения
            e.printStackTrace();
        }
    }
}
 */