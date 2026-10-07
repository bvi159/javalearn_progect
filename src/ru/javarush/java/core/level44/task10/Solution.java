package ru.javarush.java.core.level44.task10;

/*
Цифровой архивариус: эффективное хранение больших объемов данных с сжатием 🗄️
Вы — цифровой архивариус, которому поручено хранить огромные объемы ценных научных или статистических данных. Каждая запись представляет собой простой DataItem со своим уникальным значением. Стандартное сохранение этих данных может быстро заполнить дисковое пространство, поэтому вам нужно найти наиболее эффективный способ их хранения, используя сжатие.

Для начала создайте простой класс DataItem, который будет содержать единственное поле int value. Конечно, этот класс должен быть Serializable.

В вашем методе main создайте ArrayList<DataItem>. Заполните эту коллекцию огромным количеством элементов — например, 10 000 объектами DataItem, присваивая полю value значения от 0 до 9 999 (или любые другие последовательные числа). Это будет ваш большой набор данных.

Теперь пришло время для эксперимента по хранению. Сериализуйте этот ArrayList<DataItem> двумя разными способами:

Сначала используйте обычный ObjectOutputStream для записи списка в файл с именем "data.ser". Это будет ваш несжатый вариант.
Затем, чтобы применить сжатие, оберните ваш ObjectOutputStream в GZIPOutputStream и сериализуйте тот же список в файл с именем "data.gz".
После выполнения программы, ваша задача — сравнить размер файлов "data.ser" и "data.gz". Вы должны увидеть, что файл "data.gz" заметно меньше. Эта задача наглядно демонстрирует практическую пользу использования сжатия данных при сериализации, что крайне важно для эффективного использования ресурсов при работе с большими наборами данных и для оптимизации их передачи.

Требования:
•	Необходимо создать отдельный класс DataItem, который содержит одно поле int value.
•	Класс DataItem должен реализовывать интерфейс Serializable для поддержки сериализации объектов этого класса.
•	В методе main необходимо создать объект ArrayList<DataItem> и заполнить его 10 000 экземплярами DataItem с последовательными значениями поля value.
•	Коллекцию ArrayList<DataItem> нужно сериализовать с помощью ObjectOutputStream в файл с именем "data.ser".
•	Ту же коллекцию ArrayList<DataItem> необходимо сериализовать с помощью ObjectOutputStream, обернутого в GZIPOutputStream, в файл "data.gz".
•	Все используемые потоки для записи должны быть корректно закрыты после завершения сериализации для предотвращения утечек ресурсов.
•	В результате выполнения программы должны быть созданы два файла — "data.ser" и "data.gz", причем размер "data.gz" должен быть заметно меньше, чем "data.ser".

import java.io.Serializable;

/ **
 * Простой класс-объект данных.
 * Содержит одно поле int value и реализует Serializable,
 * чтобы его экземпляры можно было сериализовать.
 * /
public class DataItem implements Serializable {
    private static final long serialVersionUID = 1L; // Явная версия для стабильной сериализации

    int value; // Единственное поле с данными

    public DataItem(int value) {
        this.value = value;
    }
}

public class Solution {
    public static void main(String[] args) throws Exception {
        // 1) Создаем большую коллекцию из 10 000 элементов
        int count = 10_000;
        ArrayList<DataItem> data = new ArrayList<>(count);
        for (int i = 0; i < count; i++) {
            data.add(new DataItem(i)); // Последовательные значения value
        }

        // 2) Сериализация без сжатия в файл data.ser

        // try-with-resources гарантирует корректное закрытие потоков (и flush)


        // 3) Сериализация со сжатием в файл data.gz


        // 4) Сравнение размеров получившихся файлов

    }
}

 */

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.zip.GZIPOutputStream;

public class Solution {
    public static void main(String[] args) throws Exception {
        // 1) Создаем большую коллекцию из 10 000 элементов
        int count = 10_000;
        ArrayList<DataItem> data = new ArrayList<>(count);
        for (int i = 0; i < count; i++) {
            data.add(new DataItem(i)); // Последовательные значения value
        }

        // 2) Сериализация без сжатия в файл data.ser
        // try-with-resources гарантирует корректное закрытие потоков (и flush)
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("data.ser"))) {
            oos.writeObject(data);
        }
        // 3) Сериализация со сжатием в файл data.gz
        try (ObjectOutputStream oos = new ObjectOutputStream(new GZIPOutputStream(new FileOutputStream("data.gz")))) {
            oos.writeObject(data);
            long gzSize = "data.gz".length();
        }

        File ser = new File("data.ser");
        File gz = new File("data.gz");

        long serSize = ser.length();
        long gzSize = gz.length();

        System.out.println("data.ser: " + serSize + " байт");
        System.out.println("data.gz : " + gzSize + " байт");

    }

    // 4) Сравнение размеров получившихся файлов

}

/*
public class Solution {
    public static void main(String[] args) throws Exception {
        // 1) Создаем большую коллекцию из 10 000 элементов
        int count = 10_000;
        ArrayList<DataItem> data = new ArrayList<>(count);
        for (int i = 0; i < count; i++) {
            data.add(new DataItem(i)); // Последовательные значения value
        }

        // 2) Сериализация без сжатия в файл data.ser
        Path ser = Path.of("data.ser");
        // try-with-resources гарантирует корректное закрытие потоков (и flush)
        try (ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(ser))) {
            oos.writeObject(data);
        }

        // 3) Сериализация со сжатием в файл data.gz
        Path gz = Path.of("data.gz");
        try (ObjectOutputStream oos = new ObjectOutputStream(new GZIPOutputStream(Files.newOutputStream(gz)))) {
            oos.writeObject(data);
        }

        // 4) Сравнение размеров получившихся файлов
        long sizeSer = Files.size(ser);
        long sizeGz = Files.size(gz);

        System.out.println("Размеры файлов:");
        System.out.println("data.ser = " + sizeSer + " байт");
        System.out.println("data.gz  = " + sizeGz  + " байт");
        double ratio = (sizeGz * 100.0) / sizeSer;
        System.out.printf("Сжатый файл составляет примерно %.2f%% от несжатого%n", ratio);
    }
}
 */