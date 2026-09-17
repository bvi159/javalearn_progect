package ru.javarush.java.core.level38.task08;
/*
Подготовка склада для новых поставок: проверка разрешения на хранение 📦
Вы — заведующий складом, и вам нужно определить, можно ли размещать новые партии товаров (записывать файлы) в определённую секцию на складе (директорию).

Ваша программа получает путь к этой секции в виде текстовой строки и создаёт для неё цифровую метку (Path).

Затем, используя метод Files.isWritable, она должна быстро проверить, доступна ли эта секция для записи новых товаров.

Результат проверки – true (если можно записывать) или false (если секция заблокирована или нет места) – должен быть выведен на экран, чтобы вы могли эффективно планировать размещение новых поставок.

Требования:
•	Программа должна принимать путь к директории в виде текстовой строки.
•	На основе полученной строки программа должна создать объект Path для указанной директории.
•	Программа должна использовать метод Files.isWritable для проверки, доступна ли директория для записи.
•	Результат проверки (true или false) должен быть выведен на экран.

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        // Создаем Scanner для чтения пути к директории из консоли
        Scanner console = new Scanner(System.in);
        String dirPath = console.nextLine().trim();

        // Создаем объект Path на основе введенной строки


        // Проверяем, доступна ли директория для записи



        // Выводим результат проверки: true или false

    }
}

 */

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        // Создаем Scanner для чтения пути к директории из консоли
        Scanner console = new Scanner(System.in);
        String dirPath = console.nextLine().trim();

        // Создаем объект Path на основе введенной строки
        Path shopPath = Path.of(dirPath);

        // Проверяем, доступна ли директория для записи
        System.out.println(Files.isWritable(shopPath));

        // Выводим результат проверки: true или false

    }
}
/*
public class Solution {
    public static void main(String[] args) {
        // Создаем Scanner для чтения пути к директории из консоли
        Scanner console = new Scanner(System.in);
        String dirPath = console.nextLine().trim();

        // Создаем объект Path на основе введенной строки
        Path path = Path.of(dirPath);

        // Проверяем, доступна ли директория для записи
        // Files.isWritable вернет true, если по указанному пути можно выполнять операции записи
        boolean canWrite = Files.isWritable(path);

        // Выводим результат проверки: true или false
        System.out.println(canWrite);
    }
}
 */