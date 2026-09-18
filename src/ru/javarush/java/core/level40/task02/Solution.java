package ru.javarush.java.core.level40.task02;
/*
Генеральная уборка старых данных 🧹

Ваш цифровой рабочий стол завален старыми, давно неиспользуемыми файлами, и пришло время провести генеральную уборку. Среди них затесался файл 'old_data.txt', который нужно немедленно удалить, если он, конечно, ещё там. Ваша программа должна быть предельно осторожной и проверить его существование перед попыткой удаления.
Если вы успешно избавитесь от этого цифрового мусора, пусть программа гордо объявит: 'Файл old_data.txt удалён'. Но если выяснится, что кто-то уже сделал эту работу до вас, и файла на месте не оказалось, тогда выведите сообщение: 'Файл old_data.txt не найден — удалять нечего'. Это поможет избежать лишних тревог и понять, что порядок уже наведён.

Требования:
•	Программа должна проверить, существует ли файл с именем 'old_data.txt' перед попыткой его удаления.
•	Если файл 'old_data.txt' существует, программа должна попытаться удалить этот файл.
•	Если файл был успешно удалён, программа должна вывести на экран сообщение: 'Файл old_data.txt удалён'.
•	Если файл 'old_data.txt' не существует, программа должна вывести на экран сообщение: 'Файл old_data.txt не найден — удалять нечего'.

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Solution {
    public static void main(String[] args) {
        // Определяем путь к файлу, который нужно удалить


        // Сначала осторожно проверяем, существует ли файл

    }
}

 */

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Solution {
    public static void main(String[] args) {
        // Определяем путь к файлу, который нужно удалить
        Path oldFilePath = Paths.get("old_data.txt");

        // Сначала осторожно проверяем, существует ли файл
        if (Files.exists(oldFilePath)) {
            try {
                Files.delete(oldFilePath);
                System.out.println("Файл old_data.txt удалён");
            } catch (IOException e) {
                System.out.println("Ошибка при удалении файла " + e.getClass().getName());
                ;
            }
        } else {
            System.out.println("Файл old_data.txt не найден — удалять нечего");
        }

    }
}

/*
public class Solution {
    public static void main(String[] args) {
        // Определяем путь к файлу, который нужно удалить
        Path target = Paths.get("old_data.txt");

        // Сначала осторожно проверяем, существует ли файл
        if (Files.exists(target)) {
            try {
                // Пытаемся удалить файл. Если исключения нет — удаление прошло успешно.
                Files.delete(target);
                System.out.println("Файл old_data.txt удалён");
            } catch (IOException e) {
                // В учебной задаче не добавляем дополнительные сообщения об ошибке,
                // чтобы строго соответствовать формату вывода из условия.
            }
        } else {
            System.out.println("Файл old_data.txt не найден — удалять нечего");
        }
    }
}
 */