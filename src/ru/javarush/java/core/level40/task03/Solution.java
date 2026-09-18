package ru.javarush.java.core.level40.task03;

/*
Перемещение свежего отчёта в архив 📦

Вы работаете в отделе, который каждый день генерирует важные отчёты, и пришло время переместить свежий 'report.txt' из рабочей папки 'data' в более надёжное хранилище — папку 'archive'. Ваша задача — написать программу, которая аккуратно заберёт этот отчёт и поместит его в 'archive', сохранив то же имя файла: 'archive/report.txt'.
Если вдруг в архиве уже лежит старая версия этого отчёта, ваша программа должна без колебаний заменить её новой, свежей копией, чтобы всегда была актуальная информация. Как только операция будет успешно завершена и отчёт займёт своё новое место, пусть на экране появится радостное сообщение: 'Файл перемещён!'.

Требования:
•	Программа должна использовать классы Path и Files для работы с файлами и путями.
•	Программа должна перемещать файл 'report.txt' из папки 'data' в папку 'archive', заменяя существующий файл в папке 'archive', если он уже есть.
•	После перемещения файл в папке 'archive' должен иметь то же имя — 'report.txt'.
•	После успешного завершения операции на экран должно выводиться сообщение: 'Файл перемещён!'.

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class Solution {
    public static void main(String[] args) throws Exception {
        // Источник: файл data/report.txt

        // Назначение: файл archive/report.txt (имя сохраняем тем же)


        // Создаём папку archive, если она ещё не существует


        // Перемещаем файл с заменой, если целевой уже существует


        // Сообщение выводим только при успешном перемещении

    }
}

 */

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class Solution {
    public static void main(String[] args) throws Exception {
        // Источник: файл data/report.txt
        Path newReport = Paths.get("data/report.txt");

        // Назначение: файл archive/report.txt (имя сохраняем тем же)
        Path toArchive = Paths.get("archive/report.txt");


        // Создаём папку archive, если она ещё не существует
        if (!Files.exists(Paths.get("archive"))) {
            Files.createDirectory(Paths.get("archive"));
        }


        // Перемещаем файл с заменой, если целевой уже существует
        try {
            Files.move(newReport, toArchive, StandardCopyOption.ATOMIC_MOVE, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Файл перемещён!");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Сообщение выводим только при успешном перемещении


    }
}
/*
public class Solution {
    public static void main(String[] args) throws Exception {

        // Источник: файл data/report.txt
        Path source = Path.of("data", "report.txt");
        // Назначение: файл archive/report.txt (имя сохраняем тем же)
        Path target = Path.of("archive", "report.txt");

        // Создаём папку archive, если она ещё не существует
        Files.createDirectories(target.getParent());

        // Перемещаем файл с заменой, если целевой уже существует
        Files.move(source, target, StandardCopyOption.REPLACE_EXISTING);

        // Сообщение выводим только при успешном перемещении
        System.out.println("Файл перемещён!");
    }
}
 */