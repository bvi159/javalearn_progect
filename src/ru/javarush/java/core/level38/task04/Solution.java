package ru.javarush.java.core.level38.task04;
/*
Создание убежища для ценностей: резервная копия 🔐
Представьте, что вы строите надёжное убежище для ваших самых ценных цифровых сокровищ, которым нужно хранилище для "backup". Прежде чем начать перенос, вам необходимо убедиться, что такое убежище уже существует.

Создайте цифровую ссылку (Path) на эту папку "backup" прямо в текущем месте. Используя класс Files, проверьте, есть ли это убежище. Если его ещё нет, ваша задача — незамедлительно создать его с помощью Files.createDirectory и с гордостью заявить: "Папка создана". Но если убежище уже стоит на месте и готово к использованию, просто подтвердите это сообщением: "Папка уже существует", чтобы не тратить время на повторное строительство.

Требования:
•	В программе должен быть создан объект Path, указывающий на папку с именем "backup" в текущей директории.
•	Для проверки существования папки "backup" необходимо использовать метод Files.exists(Path).
•	Если папка "backup" не существует, программа должна создать её с помощью метода Files.createDirectory(Path).
•	Если папка была создана, программа должна вывести на экран сообщение: "Папка создана".
•	Если папка "backup" уже существует, программа должна вывести на экран сообщение: "Папка уже существует".

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Solution {
    public static void main(String[] args) throws IOException {
        // Создаем объект Path, указывающий на папку "backup" в текущей директории


        // Проверяем существование папки с помощью Files.exists(Path)

    }
}

 */

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Solution {
    public static void main(String[] args) throws IOException {
        // Создаем объект Path, указывающий на папку "backup" в текущей директории
        Path somthingExpensive = Paths.get("backup");
        if (!Files.exists(somthingExpensive) || !Files.isDirectory(somthingExpensive)) {
            Files.createDirectory(somthingExpensive);
            System.out.println("Папка создана");
        } else {
            System.out.println("Папка уже существует");
        }


        // Проверяем существование папки с помощью Files.exists(Path)

    }
}
/*
public class Solution {
    public static void main(String[] args) throws IOException {
        // Создаем объект Path, указывающий на папку "backup" в текущей директории
        Path backupDir = Paths.get("backup");

        // Проверяем существование папки с помощью Files.exists(Path)
        if (Files.exists(backupDir)) {
            System.out.println("Папка уже существует");
        } else {
            // Если папки нет — создаем её
            Files.createDirectory(backupDir);
            System.out.println("Папка создана");
        }
    }
}
 */