package ru.javarush.java.core.level41.task05;
/*
Поиск потерянных фрагментов в архивах 🔍

Представьте, что вы — археолог данных, работающий в огромном цифровом архиве. Вам нужно найти конкретный,
давно утерянный фрагмент информации в гигантском файле. Вам не нужно загружать весь файл, ведь это займет слишком много времени.
Вместо этого, используя инструмент RandomAccessFile, вы должны "перепрыгнуть" ровно на 1000-й байт от начала файла.
Затем, с этой позиции, вам предстоит прочитать следующие 256 байт, словно вы вырезаете драгоценный фрагмент из древнего свитка.
После этого ваша программа должна сообщить, сколько байтов удалось реально прочитать — это важно, ведь иногда фрагмент может быть короче ожидаемого.
Требования:
•	Программа должна использовать класс RandomAccessFile для работы с файлом.
•	Программа должна перейти на позицию 1000 байт от начала файла с помощью метода seek(long pos).
•	Программа должна попытаться прочитать ровно 256 байт, начиная с позиции 1000.
•	Если в файле после 1000-го байта осталось меньше 256 байт, программа должна корректно обработать ситуацию и прочитать только доступное количество байт.
•	Программа должна вывести на экран количество байт, которое было фактически прочитано из файла.

import java.io.IOException;
import java.io.RandomAccessFile;

public class Solution {
    public static void main(String[] args) throws IOException {
        // используем тестовый large.txt в текущей папке
        String path = "large.txt";


        // Открываем файл в режиме чтения
        // "Перепрыгиваем" ровно на 1000-й байт от начала файла




        // Пытаемся прочитать ровно 256 байт, но корректно обрабатываем конец файла:
        // читаем только доступные байты (read может вернуть меньше запрошенного)






        // Выводим количество реально прочитанных байт


    }
}

 */

import java.io.IOException;
import java.io.RandomAccessFile;

public class Solution {
    public static void main(String[] args) throws IOException {
        // используем тестовый large.txt в текущей папке
        String path = "large.txt";
        String dstPath = "small.txt";

        // Открываем файл в режиме чтения
        // "Перепрыгиваем" ровно на 1000-й байт от начала файла
        try (RandomAccessFile raf = new RandomAccessFile(path, "r");
             RandomAccessFile dst = new RandomAccessFile(dstPath, "rws")) {
            raf.seek(1000); // Перемещаемся к началу куска
            byte[] buffer = new byte[256];
            int bytesRead = raf.read(buffer);
            // Обрабатываем buffer
            dst.setLength(0);                   // ← очищаем файл
            if (bytesRead > 0) {
                dst.write(buffer, 0, bytesRead);  // ← ключевое: длина bytesRead
            }
            System.out.println(bytesRead);
        }
        // Пытаемся прочитать ровно 256 байт, но корректно обрабатываем конец файла:
        // читаем только доступные байты (read может вернуть меньше запрошенного)


        // Выводим количество реально прочитанных байт


    }
}
/*
public class Solution {
    public static void main(String[] args) throws IOException {
        // используем тестовый large.txt в текущей папке
        String path = "large.txt";

        // Открываем файл в режиме чтения
        try (RandomAccessFile raf = new RandomAccessFile(path, "r")) {
            // "Перепрыгиваем" ровно на 1000-й байт от начала файла
            raf.seek(1000L);

            byte[] buffer = new byte[256];
            int totalRead = 0;

            // Пытаемся прочитать ровно 256 байт, но корректно обрабатываем конец файла:
            // читаем только доступные байты (read может вернуть меньше запрошенного)
            while (totalRead < buffer.length) {
                int read = raf.read(buffer, totalRead, buffer.length - totalRead);
                if (read == -1) { // достигнут конец файла — больше байтов нет
                    break;
                }
                totalRead += read;
            }

            // Выводим количество реально прочитанных байт
            System.out.println(totalRead);
        }
    }
}
 */