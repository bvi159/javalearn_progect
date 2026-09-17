package ru.javarush.java.core.level39.task01;

/*
Цифровой инвентаризатор: обзор содержимого папки
Представьте, что вы — цифровой инвентаризатор в огромном виртуальном складе. Ваша задача – быстро получить полный список всего, что находится прямо внутри одной из папок, чтобы убедиться, что ничего не потерялось и всё на своих местах.

Для этого создайте специальный путь, указывающий на вашу виртуальную "myfolder" библиотеку.

Затем, используя мощные инструменты вашей системы, получите перечень всех файлов и подпапок, которые лежат непосредственно в этой директории.

После этого, аккуратно выведите имя каждого элемента на экран, каждое с новой строки, чтобы получить чёткий и полный обзор содержимого.

Требования:
•	Необходимо создать объект Path, указывающий на папку "myfolder".
•	Для получения списка файлов и папок в директории нужно использовать методы класса Files.
•	Программа должна получить только те файлы и папки, которые находятся непосредственно в "myfolder", не заходя во вложенные папки.
•	Имена всех найденных файлов и подпапок должны быть выведены на экран, каждое с новой строки.
•	Для вывода имени элемента следует использовать только его имя (а не полный путь).

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class Solution {
    public static void main(String[] args) {
        // Создаем путь к директории "myfolder" (относительно текущей рабочей директории)


        // Получаем только непосредственные элементы директории через Files.newDirectoryStream(...)
        // try-with-resources гарантирует закрытие потока даже при ошибке

    }
}

 */

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Solution {
    public static void main(String[] args) throws IOException {
        // Создаем путь к директории "myfolder" (относительно текущей рабочей директории)
        Path myDirectory = Files.createDirectories(Path.of("myfolder"));
        // Получаем только непосредственные элементы директории через Files.newDirectoryStream(...)
        // try-with-resources гарантирует закрытие потока даже при ошибке
        try (var myStream = Files.newDirectoryStream(myDirectory)) {
            myStream
                    .forEach(path -> path.getFileName()
                            .forEach(System.out::println));
        }

    }

}

/*
public class Solution {
    public static void main(String[] args) {
        // Создаем путь к директории "myfolder" (относительно текущей рабочей директории)
        Path dir = Path.of("myfolder");

        // Получаем только непосредственные элементы директории через Files.newDirectoryStream(...)
        // try-with-resources гарантирует закрытие потока даже при ошибке
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir)) {
            for (Path entry : stream) {
                // Выводим только имя элемента (последний сегмент пути), без полного пути
                System.out.println(entry.getFileName());
            }
        } catch (IOException e) {
            // Короткое сообщение об ошибке для учебной задачи
            System.out.println("Не удалось прочитать содержимое папки: " + e.getMessage());
        }
    }
}
 */