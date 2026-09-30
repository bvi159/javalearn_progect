package ru.javarush.java.core.level41.task08;
/*
Археологический поиск рун в цифровом монолите 📜
Вы — цифровой археолог, исследующий древний, необъятный бинарный монолит под названием "hugefile.bin". Легенда гласит, что где-то внутри него спрятана загадочная рунная последовательность "JAVA". Ваша миссия — найти первое вхождение этой последовательности. Но есть загвоздка: монолит настолько огромен, что его невозможно целиком загрузить в память вашего компьютера.

К счастью, у вас есть мощный артефакт — memory mapping (MappedByteBuffer), который позволит вам исследовать монолит, как будто он уже находится в памяти, без фактической загрузки. Ваша программа должна вывести точную позицию первого найденного вхождения рун в формате: "Найдено в позиции X" или же грустно сообщить "Не найдено", если древние руны так и не открыли вам своих секретов.

Требования:
•	Программа должна использовать класс MappedByteBuffer для чтения содержимого файла "hugefile.bin" без полной загрузки его в оперативную память.
•	Программа должна искать первое вхождение последовательности байт, соответствующей строке "JAVA" (в кодировке ASCII), в содержимом файла.
•	Программа должна корректно обрабатывать файлы, размер которых превышает доступную оперативную память, используя возможности memory mapping.
•	Если последовательность найдена, программа должна вывести сообщение в формате "Найдено в позиции X", где X — позиция первого байта вхождения "JAVA" в файле; если не найдена — вывести "Не найдено".
•	Программа должна корректно закрывать все используемые ресурсы (файловые каналы, потоки и т.д.) после завершения работы.

import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class Solution {
    // Имя файла по условию


    // Ищем ASCII-последовательность "JAVA"


    // Размер окна для memory mapping (128 МБ — хороший баланс)


    public static void main(String[] args) {


        // Открываем файловый канал в режиме чтения и гарантируем закрытие ресурса




        if (fileSize < L) {


        }

        // Шаг сдвига окна: перекрываем соседние окна на (L - 1) байт,
        // чтобы не пропустить шаблон, начинающийся на границе двух окон





        // Отображаем текущий кусок файла в память (memory mapping)


        // Ищем первое вхождение "JAVA" внутри текущего окна

        // Быстрая проверка посимвольно (ASCII-байты)





        // Глобальная позиция в файле




        // MappedByteBuffer не требует явного закрытия: освобождается GC/OS.
        // Мы храним только одну ссылку за раз, поэтому удержания ресурса нет.


        // Если дошли сюда — вхождение не найдено


        // В учебной задаче упрощаем обработку: печатаем "Не найдено" при ошибке


    }
}

 */

import java.io.*;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

public class Solution {
    // Имя файла по условию
    static String fileName = "hugefile.bin";

    // Ищем ASCII-последовательность "JAVA"
    static byte[] target = "JAVA".getBytes(StandardCharsets.US_ASCII);

    // Размер окна для memory mapping (128 МБ — хороший баланс)
    int chunkSize = 128 * 1024 * 1024; // 128 МБ

    public static void main(String[] args) {


        // Открываем файловый канал в режиме чтения и гарантируем закрытие ресурса
        try (FileInputStream file = new FileInputStream(fileName);
             FileChannel channel = file.getChannel()) {

            long fileSize = channel.size();
            int chunkSize = 128 * 1024 * 1024; // 128 МБ

            long position = 0;
            int overlap = target.length - 1; // перекрытие
            while (position < fileSize) {
                long size = Math.min(chunkSize, fileSize - position);
                MappedByteBuffer buffer = channel.map(FileChannel.MapMode.READ_ONLY, position, size);

                for (int i = 0; i <= size - target.length; i++) {
                    boolean found = true;
                    for (int j = 0; j < target.length; j++) {
                        if (buffer.get(i + j) != target[j]) {
                            found = false;
                            break;
                        }
                    }
                    if (found) {
                        System.out.println("Найдено в позиции " + (position + i));
                        // Можно остановить поиск или продолжить
                        return;
                    }
                }
                // если дошли до конца файла — выходим
                if (position + size >= fileSize) break;

                // сдвигаемся с учётом перекрытия
                position += size - overlap;
            }
            System.out.println("Не найдено");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        // пример из следующей лекции

        try (ZipFile zf = new ZipFile("D:\\imgw-928085339.zip")) {
            Enumeration<? extends ZipEntry> en = zf.entries();
            while (en.hasMoreElements()) {
                ZipEntry e = en.nextElement();
                e.setComment("Заморкинский файл");
                e.setTime(System.currentTimeMillis());
                System.out.println("Имя: " + e.getName());
                System.out.println("Комментарий: " + e.getComment());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
/*
public class Solution {
    // Имя файла по условию
    private static final String FILE_NAME = "hugefile.bin";

    // Ищем ASCII-последовательность "JAVA"
    private static final byte[] PATTERN = new byte[] {'J', 'A', 'V', 'A'};

    // Размер окна для memory mapping (128 МБ — хороший баланс)
    private static final int CHUNK_SIZE = 128 * 1024 * 1024;

    public static void main(String[] args) {
        Path path = Path.of(FILE_NAME);

        // Открываем файловый канал в режиме чтения и гарантируем закрытие ресурса
        try (FileChannel channel = FileChannel.open(path, StandardOpenOption.READ)) {
            long fileSize = channel.size();
            int L = PATTERN.length;

            if (fileSize < L) {
                System.out.println("Не найдено");
                return;
            }

            // Шаг сдвига окна: перекрываем соседние окна на (L - 1) байт,
            // чтобы не пропустить шаблон, начинающийся на границе двух окон
            long step = CHUNK_SIZE - (L - 1);

            for (long position = 0; position < fileSize; position += step) {
                long remaining = fileSize - position;
                int mapSize = (int) Math.min(CHUNK_SIZE, remaining);

                // Отображаем текущий кусок файла в память (memory mapping)
                MappedByteBuffer buffer = channel.map(FileChannel.MapMode.READ_ONLY, position, mapSize);

                // Ищем первое вхождение "JAVA" внутри текущего окна
                int lastStart = mapSize - L;
                for (int i = 0; i <= lastStart; i++) {
                    // Быстрая проверка посимвольно (ASCII-байты)
                    if (buffer.get(i) == PATTERN[0]
                            && buffer.get(i + 1) == PATTERN[1]
                            && buffer.get(i + 2) == PATTERN[2]
                            && buffer.get(i + 3) == PATTERN[3]) {
                        long foundAt = position + i; // Глобальная позиция в файле
                        System.out.println("Найдено в позиции " + foundAt);
                        return;
                    }
                }
                // MappedByteBuffer не требует явного закрытия: освобождается GC/OS.
                // Мы храним только одну ссылку за раз, поэтому удержания ресурса нет.
            }

            // Если дошли сюда — вхождение не найдено
            System.out.println("Не найдено");
        } catch (IOException e) {
            // В учебной задаче упрощаем обработку: печатаем "Не найдено" при ошибке
            System.out.println("Не найдено");
        }
    }
}
 */