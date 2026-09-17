package ru.javarush.java.core.level39.task04;
/*
Цифровой следователь: досье на файл
Вы — цифровой следователь, и в вашем распоряжении оказался загадочный файл под названием "info.txt". Вам нужно немедленно получить о нём как можно больше информации, чтобы понять, когда он был создан, когда его последний раз трогали, и можете ли вы вообще его прочитать.

Создайте специальный путь, который указывает на этот "info.txt". Затем, используя арсенал ваших цифровых инструментов, получите детальные атрибуты этого файла. Ваша миссия — вывести на экран три ключевые улики.

Сначала покажите, когда файл был создан, в формате "Дата создания: ...".
Затем укажите, когда он был последний раз изменён, используя формат "Дата последнего изменения: ...".
И, наконец, сообщите, можете ли вы его прочитать, выведя "Можно читать: ..." и указав true или false.
Если же этот жизненно важный "info.txt" файл вдруг отсутствует, сообщите об этом, выведя "Файл не найден", чтобы предотвратить дальнейшие бесполезные поиски.

Требования:
•	Программа должна создавать объект Path, указывающий на файл "info.txt".
•	Программа должна проверять, существует ли файл "info.txt". Если файл отсутствует, программа должна вывести "Файл не найден" и завершить выполнение.
•	Если файл существует, программа должна получить дату его создания и вывести её на экран в формате "Дата создания: ...".
•	Если файл существует, программа должна получить дату последнего изменения и вывести её на экран в формате "Дата последнего изменения: ...".
•	Если файл существует, программа должна проверить, доступен ли файл для чтения, и вывести на экран "Можно читать: ..." с указанием true или false.

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;

public class Solution {
    public static void main(String[] args) throws Exception {
        // Создаем путь к файлу "info.txt"


        // Проверяем существование файла


        // Получаем базовые атрибуты файла (создание, изменение и др.)


        // Выводим требуемую информацию

    }
}

 */

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;

public class Solution {
    public static void main(String[] args) throws Exception {
        // Создаем путь к файлу "info.txt"
        Path path = Paths.get("info.txt");

        // Проверяем существование файла

        try {
            if (Files.exists(path)) {
                BasicFileAttributes attrs = Files.readAttributes(path, BasicFileAttributes.class);

                FileTime creationDate = attrs.creationTime();
                FileTime lastMod = attrs.lastModifiedTime();
                Boolean canRead = Files.isReadable(path);

                System.out.println("Дата создания: " + creationDate);
                System.out.println("Дата последнего изменения: " + lastMod);
                System.out.println("Можно читать: " + canRead);
            } else {
                System.out.println("Файл не найден");
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Получаем базовые атрибуты файла (создание, изменение и др.)


        // Выводим требуемую информацию

    }
}
/*
public class Solution {
    public static void main(String[] args) throws Exception {
        // Создаем путь к файлу "info.txt"
        Path path = Path.of("info.txt");

        // Проверяем существование файла
        if (Files.notExists(path)) {
            System.out.println("Файл не найден");
            return; // Завершаем программу, если файла нет
        }

        // Получаем базовые атрибуты файла (создание, изменение и др.)
        BasicFileAttributes attrs = Files.readAttributes(path, BasicFileAttributes.class);

        // Выводим требуемую информацию
        System.out.println("Дата создания: " + attrs.creationTime());
        System.out.println("Дата последнего изменения: " + attrs.lastModifiedTime());
        System.out.println("Можно читать: " + Files.isReadable(path));
    }
}
 */