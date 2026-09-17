package ru.javarush.java.core.level39.task09;
/*
Эксперт по безопасности: аудит прав доступа
Вы — эксперт по безопасности в крупной организации, и вам нужно провести быструю проверку критически важных файлов, чтобы убедиться, что доступ к ним настроен корректно.

Ваша задача — создать программу, которая для любого указанного пути к файлу сможет моментально определить и сообщить, какие действия с ним разрешены. Для этого ваша программа должна вывести на экран три отдельные строки.

Первая строка покажет, можно ли этот файл прочитать. Вторая сообщит, разрешена ли запись в этот файл. И третья строка укажет, можно ли его запустить на выполнение.

Используйте специальные системные функции, предназначенные для проверки прав доступа, чтобы получить точный результат для каждой категории.

Требования:
•	Программа должна корректно обрабатывать ситуацию, если указанный файл не существует.
•	Для определения доступа к файлу необходимо использовать специальные методы класса java.io.File или java.nio.file.Files, такие как canRead(), canWrite(), canExecute().
•	Путь к файлу должен передаваться в программу (например, через аргумент командной строки или иным способом).
•	Программа должна выводить три строки: первая — о возможности чтения файла, вторая — о возможности записи, третья — о возможности выполнения.
•	В каждой строке должно явно указываться, разрешено ли соответствующее действие (например, "Readable: true/false", "Writable: true/false", "Executable: true/false").

import java.io.File;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        // Читаем строку с путем к файлу
        Scanner console = new Scanner(System.in);
        String path = console.nextLine();
        File target = new File(path);

        // Явно проверяем существование для наглядности:
        // если файла нет, все права считаем false.


        // Системные проверки прав доступа (java.io.File):


        // Три строки результата в требуемом формате и порядке

    }
}


 */

import java.io.File;
import java.nio.file.Files;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        // Читаем строку с путем к файлу
        Scanner console = new Scanner(System.in);
        String path = console.nextLine();
        File target = new File(path);

        // Явно проверяем существование для наглядности:
        // если файла нет, все права считаем false.
        if (!Files.exists(target.toPath())) {
            System.out.println("Чтение: " + false);
            System.out.println("Запись: " + false);
            System.out.println("Выпольнение: " + false);
            return;
        }

        // Системные проверки прав доступа (java.io.File):

        System.out.println("Чтение: " + Files.isReadable(target.toPath()));
        System.out.println("Запись: " + Files.isWritable(target.toPath()));
        System.out.println("Выпольнение: " + Files.isExecutable(target.toPath()));
//подсмотрено
        System.out.println("Чтение: " + target.canRead());
        System.out.println("Запись: " + target.canWrite());
        System.out.println("Выпольнение: " + target.canExecute());

        // Три строки результата в требуемом формате и порядке

    }
}
/*

public class Solution {
    public static void main(String[] args) {
        // Читаем строку с путем к файлу
        Scanner console = new Scanner(System.in);
        String path = console.nextLine();
        File target = new File(path);

        // Явно проверяем существование для наглядности:
        // если файла нет, все права считаем false.
        boolean exists = target.exists();

        // Системные проверки прав доступа (java.io.File):
        boolean readable = exists && target.canRead();
        boolean writable = exists && target.canWrite();
        boolean executable = exists && target.canExecute();

        // Три строки результата в требуемом формате и порядке
        System.out.println("Readable: " + readable);
        System.out.println("Writable: " + writable);
        System.out.println("Executable: " + executable);
    }
}

 */