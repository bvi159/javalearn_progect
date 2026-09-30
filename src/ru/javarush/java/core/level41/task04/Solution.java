package ru.javarush.java.core.level41.task04;
/*
Цифровой курьер: Мгновенная доставка копий 📦
Вы — оператор высокоскоростной цифровой почтовой службы. Вам привезли важный документ под названием "source.txt", который содержит ценную текстовую информацию.

Ваша задача — мгновенно создать его точную копию, отправив ее в новый пункт назначения под именем "target.txt".

Использовать вы будете не обычную медленную "почту", а специальный, супербыстрый метод transferTo из FileChannel, который позволяет перебрасывать данные без лишних хлопот.

После того, как ваш "цифровой курьер" завершит свою работу, в пункте "target.txt" должна лежать абсолютно идентичная копия исходного документа.

Требования:
•	Программа должна использовать класс FileChannel для работы с файлами.
•	Для копирования содержимого из "source.txt" в "target.txt" необходимо применить метод transferTo класса FileChannel.
•	"source.txt" должен открываться для чтения, а "target.txt" — для записи (с возможным созданием файла, если он не существует).
•	В результате выполнения программы файл "target.txt" должен содержать точную копию данных из "source.txt".
•	Все открытые каналы и потоки должны быть корректно закрыты после завершения операции копирования.

import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class Solution {
    public static void main(String[] args) throws IOException {
        // Пути к исходному и целевому файлам (в текущей папке проекта)
        Path source = Path.of("source.txt");
        Path target = Path.of("target.txt");

        // Открываем каналы:
        // - исходный файл только для чтения
        // - целевой файл для записи, создаём при отсутствии и очищаем при наличии


            // Копируем данные супербыстрым способом: FileChannel.transferTo
            // Используем цикл на случай, если передастся не весь объём за один вызов



    }
}

 */

import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class Solution {
    public static void main(String[] args) throws IOException {
        // Пути к исходному и целевому файлам (в текущей папке проекта)
        Path source = Path.of("source.txt");
        Path target = Path.of("target.txt");

        // Открываем каналы:
        // - исходный файл только для чтения
        // - целевой файл для записи, создаём при отсутствии и очищаем при наличии
        try (FileChannel src = FileChannel.open(source, StandardOpenOption.READ);
             FileChannel dst = FileChannel.open(target,
                     StandardOpenOption.CREATE,
                     StandardOpenOption.TRUNCATE_EXISTING,
                     StandardOpenOption.WRITE)) {
            long size = src.size();
            src.transferTo(0, size, dst);
//            long transferred = src.transferTo(0, size, dst);
//            System.out.println("Скопировано байт: " + transferred);
        }


        // Копируем данные супербыстрым способом: FileChannel.transferTo
        // Используем цикл на случай, если передастся не весь объём за один вызов


    }
}
/*
public class Solution {
    public static void main(String[] args) throws IOException {
        // Пути к исходному и целевому файлам (в текущей папке проекта)
        Path source = Path.of("source.txt");
        Path target = Path.of("target.txt");

        // Открываем каналы:
        // - исходный файл только для чтения
        // - целевой файл для записи, создаём при отсутствии и очищаем при наличии
        try (FileChannel in = FileChannel.open(source, StandardOpenOption.READ);
             FileChannel out = FileChannel.open(target,
                     StandardOpenOption.WRITE,
                     StandardOpenOption.CREATE,
                     StandardOpenOption.TRUNCATE_EXISTING)) {

            // Копируем данные супербыстрым способом: FileChannel.transferTo
            // Используем цикл на случай, если передастся не весь объём за один вызов
            long size = in.size();
            long position = 0;
            while (position < size) {
                long transferred = in.transferTo(position, size - position, out);
                position += transferred; // продвигаем позицию на фактически скопированные байты
            }
            // Каналы закроются автоматически благодаря try-with-resources
        }
    }
}
 */