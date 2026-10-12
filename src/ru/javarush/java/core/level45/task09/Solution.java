package ru.javarush.java.core.level45.task09;
/*
Архивариус данных: максимальное сжатие повторяющейся информации
Представьте, что вы — системный администратор, отвечающий за хранение огромных объёмов информации, которая к тому же содержит много повторяющихся паттернов. Ваша задача — максимально эффективно использовать место на диске.

Создайте класс DataBlock, который будет представлять собой такой объём данных. Он должен быть Serializable. Внутри этого класса у вас будет всего одно поле: массив строк largeStringArray типа String[]. Инициализируйте этот массив таким образом, чтобы он содержал, скажем, 1000 элементов, и каждый из них был заполнен абсолютно одинаковой строкой, например, "очень_много_повторяющегося_текста". Это создаст идеальные условия для демонстрации преимуществ сжатия.

Теперь ваша задача — сериализовать этот объект DataBlock в файл, но не простым способом. Чтобы сэкономить место, вы должны использовать GZIPOutputStream в цепочке потоков перед ObjectOutputStream. Это позволит сжать данные "на лету" во время их записи. Сохраните результат в файл с именем "data.gz".

После того как объект будет успешно записан, очень важно измерить реальную экономию места. Выведите на экран размер созданного файла "data.gz" в байтах. Сравнение этого размера с тем, каким был бы несжатый файл, наглядно продемонстрирует огромную эффективность GZIP-сжатия для повторяющихся данных.

Требования:
•	Необходимо создать класс с именем DataBlock.
•	Класс DataBlock должен реализовывать интерфейс Serializable.
•	В классе DataBlock должно быть объявлено единственное поле — массив строк String[] с именем largeStringArray.
•	largeStringArray должен быть инициализирован массивом из 1000 элементов, каждый из которых содержит одну и ту же строку, например, "очень_много_повторяющегося_текста".
•	Объект DataBlock должен быть сериализован в файл с помощью ObjectOutputStream, обёрнутого в GZIPOutputStream для сжатия данных.
•	Сериализованный и сжатый объект должен быть сохранён в файл с именем "data.gz".
•	После завершения записи необходимо определить и вывести размер созданного файла "data.gz" в байтах.

import java.io.*;
import java.util.Arrays;
import java.util.zip.GZIPOutputStream;

public class Solution {
    public static void main(String[] args) throws IOException {
        DataBlock data = new DataBlock();

        // Цепочка потоков: FileOutputStream -> GZIPOutputStream -> ObjectOutputStream
        // Сериализация через ObjectOutputStream, сжатие на лету через GZIPOutputStream
        try (FileOutputStream fos = new FileOutputStream("data.gz");
             GZIPOutputStream gzos = new GZIPOutputStream(fos);
             ObjectOutputStream oos = new ObjectOutputStream(gzos)) {
            oos.writeObject(data);
        }

        // Определяем размер сжатого файла в байтах и выводим на экран
        long size = new File("data.gz").length();
        System.out.println(size);
    }
}

 */

import java.io.*;
import java.util.zip.GZIPOutputStream;

public class Solution {
    public static void main(String[] args) throws IOException {
        DataBlock data = new DataBlock();
        for (int i = 0; i < 1000; i++) {
            data.largeStringArray[i] = "очень_много_повторяющегося_текста";
        }


        // Цепочка потоков: FileOutputStream -> GZIPOutputStream -> ObjectOutputStream
        // Сериализация через ObjectOutputStream, сжатие на лету через GZIPOutputStream
        try (FileOutputStream fos = new FileOutputStream("data.gz");
             GZIPOutputStream gzos = new GZIPOutputStream(fos);
             ObjectOutputStream oos = new ObjectOutputStream(gzos)) {
            oos.writeObject(data);
        }

        // Определяем размер сжатого файла в байтах и выводим на экран
        long size = new File("data.gz").length();
        System.out.println(size);
    }
}

class DataBlock implements Serializable {
    String[] largeStringArray = new String[1000];
}

/*

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.zip.GZIPOutputStream;

// Класс-обёртка для большого массива строк.
// Делает данные "идеальными" для сжатия: 1000 одинаковых элементов.
class DataBlock implements Serializable {
    String[] largeStringArray;

    public DataBlock() {
        largeStringArray = new String[1000];
        // Заполняем массив абсолютно одинаковой строкой
        Arrays.fill(largeStringArray, "очень_много_повторяющегося_текста");
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        DataBlock data = new DataBlock();

        // Цепочка потоков: FileOutputStream -> GZIPOutputStream -> ObjectOutputStream
        // Сериализация через ObjectOutputStream, сжатие на лету через GZIPOutputStream
        try (FileOutputStream fos = new FileOutputStream("data.gz");
             GZIPOutputStream gzos = new GZIPOutputStream(fos);
             ObjectOutputStream oos = new ObjectOutputStream(gzos)) {
            oos.writeObject(data);
        }

        // Определяем размер сжатого файла в байтах и выводим на экран
        long size = new File("data.gz").length();
        System.out.println(size);
    }
}
 */