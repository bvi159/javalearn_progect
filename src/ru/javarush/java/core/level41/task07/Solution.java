package ru.javarush.java.core.level41.task07;
/*
Переброска массивных данных: Операция "Гигантский Грузовик" 🚚
Представьте, что вы управляете логистической компанией по переброске цифровых данных. Вам нужно переместить колоссальный бинарный файл "input.bin" в новый склад, "output.bin".

Обычные "легковые автомобили" для такой задачи не подходят. Вам нужен настоящий гигантский грузовик — буфер размером в целых 8 мегабайт (8 * 1024 * 1024 байт)!

Важно, чтобы размер этого "грузовика" был задан одной-единственной переменной, которую можно легко изменить для будущих операций.

После успешной "переброски" всех данных, ваша система должна гордо отчитаться: "Файл успешно скопирован буфером 8 МБ".

Требования:
•	Данные должны копироваться с помощью буфера размером ровно 8 мегабайт (8 * 1024 * 1024 байт).
•	Размер буфера должен быть определён в виде отдельной переменной, чтобы его можно было легко изменить.
•	Файл "input.bin" должен читаться и записываться в "output.bin" блоками, используя заданный буфер.
•	Все файловые потоки должны быть корректно закрыты после завершения копирования.
•	После успешного завершения копирования программа должна вывести сообщение: "Файл успешно скопирован буфером 8 МБ".

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        // Размер буфера задаём одной переменной (8 МБ) — "гигантский грузовик"


        // try-with-resources гарантирует корректное закрытие потоков


        // буфер фиксированного размера


        // Читаем и пишем блоками, ровно столько байт, сколько было прочитано




        // Сообщение выводим только при успешном завершении копирования


    }
}

 */

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Solution {
    public static void main(String[] args) throws IOException {
        // Размер буфера задаём одной переменной (8 МБ) — "гигантский грузовик"
        int bufferSize = 8 * 1024 * 1024;
        byte[] buffer = new byte[bufferSize];


        // try-with-resources гарантирует корректное закрытие потоков
        try (FileInputStream in = (FileInputStream) Files.newInputStream(Path.of("input.bin"));
             FileOutputStream out = (FileOutputStream) Files.newOutputStream(Path.of("output.bin"))) {

            int byteread = 0;
            while ((byteread = in.read(buffer)) != -1) {
                out.write(buffer, 0, byteread);
            }
        }
        System.out.println("Файл успешно скопирован буфером 8 МБ");


        // буфер фиксированного размера


        // Читаем и пишем блоками, ровно столько байт, сколько было прочитано


        // Сообщение выводим только при успешном завершении копирования


    }
}
/*
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        // Размер буфера задаём одной переменной (8 МБ) — "гигантский грузовик"
        final int BUFFER_SIZE = 8 * 1024 * 1024;

        // try-with-resources гарантирует корректное закрытие потоков
        try (FileInputStream in = new FileInputStream("input.bin");
             FileOutputStream out = new FileOutputStream("output.bin")) {

            byte[] buffer = new byte[BUFFER_SIZE]; // буфер фиксированного размера
            int bytesRead;

            // Читаем и пишем блоками, ровно столько байт, сколько было прочитано
            while ((bytesRead = in.read(buffer)) != -1) {
                out.write(buffer, 0, bytesRead);
            }

            // Сообщение выводим только при успешном завершении копирования
            System.out.println("Файл успешно скопирован буфером 8 МБ");
        }
    }
}
 */