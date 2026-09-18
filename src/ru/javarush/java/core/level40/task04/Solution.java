package ru.javarush.java.core.level40.task04;
/*
Переименование устаревшего документа 📝
Представьте, что вы решили навести порядок в своих цифровых документах. Один из важных отчётов, 'report.txt', который находится в папке 'data', устарел и теперь должен храниться как историческая справка.

Вам нужно написать программу, которая переименует этот файл в 'report_old.txt', оставив его в той же папке 'data'.

После того как имя файла будет успешно изменено и порядок наведён, программа должна вежливо сообщить вам об этом, выведя на экран: 'Файл переименован!'.

Требования:
•	Программа должна использовать классы из пакета java.nio.file (например, Path и Files) или java.io.File для переименования файла.
•	Программа должна корректно указывать путь к исходному файлу 'data/report.txt'.
•	Программа должна переименовать файл, изменив его имя на 'report_old.txt' в той же папке 'data'.
•	Программа должна убедиться, что операция переименования прошла успешно (например, с помощью исключений или проверки результата).
•	После успешного переименования программа должна вывести на экран строку 'Файл переименован!'.

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Solution {
    public static void main(String[] args) throws IOException {
        // Формируем путь к исходному файлу относительно рабочей директории


        // Формируем путь к файлу с новым именем в той же папке (через resolveSibling)


        // Переименование фактически реализовано как перемещение в тот же каталог с новым именем


        // Сообщаем об успешном переименовании

    }
}

 */

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Solution {
    public static void main(String[] args) throws IOException {
        // Формируем путь к исходному файлу относительно рабочей директории
        Path oldReport = Paths.get("data", "report.txt");


        // Формируем путь к файлу с новым именем в той же папке (через resolveSibling)
        Path newReport = oldReport.resolveSibling("report_old.txt");


        // Переименование фактически реализовано как перемещение в тот же каталог с новым именем
        try {
            Files.move(oldReport, newReport);
            System.out.println("Файл переименован!");
        } catch (IOException e) {
            System.out.println("что-то не так: " + e.getClass().getName());
        }

        // Сообщаем об успешном переименовании

    }
}

/*
public class Solution {
    public static void main(String[] args) throws IOException {
        // Формируем путь к исходному файлу относительно рабочей директории
        Path source = Paths.get("data", "report.txt");

        // Формируем путь к файлу с новым именем в той же папке (через resolveSibling)
        Path target = source.resolveSibling("report_old.txt");

        // Переименование фактически реализовано как перемещение в тот же каталог с новым именем
        Files.move(source, target);

        // Сообщаем об успешном переименовании
        System.out.println("Файл переименован!");
    }
}
 */