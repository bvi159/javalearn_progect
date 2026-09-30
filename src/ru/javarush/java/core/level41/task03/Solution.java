package ru.javarush.java.core.level41.task03;
/*
Хирургия данных: Скульптурирование бинарного свитка ✂️

Представьте, что вы — цифровой хирург, работающий с древним бинарным свитком, который называется "numbers.bin". Изначально этот свиток содержит последовательность магических чисел от 1 до 10. Ваша задача — используя острый скальпель FileChannel, выполнить две точные операции.
Сначала вам нужно установить курсор канала ровно на пятый байт свитка, чтобы подготовиться к дальнейшим манипуляциям. Затем, с хирургической точностью, вы должны обрезать свиток так, чтобы в нем остались только первые семь байтов. После завершения операции ваш "numbers.bin" должен содержать укороченную последовательность, состоящую только из начальных семи байтов, а курсор канала должен остаться в той же позиции, куда вы его изначально переместили — на пятом байте.

Требования:
•	Программа должна открывать файл "numbers.bin" для работы с помощью FileChannel.
•	Перед выполнением любых операций программа должна установить позицию курсора FileChannel на пятый байт файла.
•	Программа должна обрезать файл "numbers.bin" так, чтобы его размер стал ровно 7 байтов.
•	После обрезки файла позиция курсора FileChannel должна остаться на пятом байте.
•	Программа должна корректно закрывать все используемые ресурсы (например, через try-with-resources).

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class Solution {
    public static void main(String[] args) throws Exception {


        // Готовим исходные данные (1..10), чтобы задача была воспроизводима.
        // Это не часть "двух точных операций" из условия, а только подготовка файла.


        // Открываем файл через FileChannel для чтения и записи


        // Устанавливаем позицию курсора на пятый байт.
        // В FileChannel позиция считается с нуля, поэтому индекс 4 — это 5-й байт.


        // Обрезаем файл до 7 байтов.
        // Так как текущая позиция (4) меньше нового размера (7),
        // позиция останется неизменной (на пятом байте).


        // Ресурсы закроются автоматически благодаря try-with-resources


    }

    // Подготавливаем файл: записываем байты 1..10 через FileChannel + ByteBuffer (в духе лекции 202)
    private static void prepareInitialFile(Path path) throws IOException {








        // переключаем буфер в режим чтения (для записи в канал)

    }

}

 */

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        Path myBin = Paths.get("numbers.bin");

        if (Files.notExists(myBin)) {
            var file = Files.createFile(myBin);
            Files.write(myBin, "12345678910".getBytes());
        }
        try (FileChannel channel = FileChannel.open(myBin, StandardOpenOption.READ,
                StandardOpenOption.WRITE)) {
            channel.position(4);
            channel.truncate(7);
        }

    }

}
/*
public class Solution {
    public static void main(String[] args) throws Exception {
        Path path = Path.of("numbers.bin");

        // Готовим исходные данные (1..10), чтобы задача была воспроизводима.
        // Это не часть "двух точных операций" из условия, а только подготовка файла.
        prepareInitialFile(path);

        // Открываем файл через FileChannel для чтения и записи
        try (FileChannel channel = FileChannel.open(path,
                StandardOpenOption.READ, StandardOpenOption.WRITE)) {

            // Устанавливаем позицию курсора на пятый байт.
            // В FileChannel позиция считается с нуля, поэтому индекс 4 — это 5-й байт.
            channel.position(4);

            // Обрезаем файл до 7 байтов.
            // Так как текущая позиция (4) меньше нового размера (7),
            // позиция останется неизменной (на пятом байте).
            channel.truncate(7);

            // Ресурсы закроются автоматически благодаря try-with-resources
        }
    }

    // Подготавливаем файл: записываем байты 1..10 через FileChannel + ByteBuffer (в духе лекции 202)
    private static void prepareInitialFile(Path path) throws IOException {
        try (FileChannel ch = FileChannel.open(path,
                StandardOpenOption.CREATE,
                StandardOpenOption.TRUNCATE_EXISTING,
                StandardOpenOption.WRITE)) {

            ByteBuffer buffer = ByteBuffer.allocate(10);
            for (int i = 1; i <= 10; i++) {
                buffer.put((byte) i);
            }
            buffer.flip();           // переключаем буфер в режим чтения (для записи в канал)
            ch.write(buffer);        // записываем 10 байтов: 1..10
        }
    }
}

 */