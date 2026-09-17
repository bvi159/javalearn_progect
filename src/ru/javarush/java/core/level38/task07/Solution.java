package ru.javarush.java.core.level38.task07;
/*
Доступ к секретным чертежам: проверка разрешения на просмотр 👁️

Представьте, что вы — главный инженер в проектном бюро, и вам принесли ссылку на некий файл с секретными чертежами. Прежде чем пытаться открыть его и изучать детали, вы должны убедиться, что у вас есть право на чтение этого документа.
Ваша программа должна принять этот путь к файлу как текстовую строку, затем создать цифровую метку Path для него. Используя метод Files.isReadable, она должна быстро проверить, можете ли вы получить доступ к информации в этом файле.
Результат этой проверки – true (если можно читать) или false (если доступ запрещён) – должен быть выведен на экран, чтобы вы знали, продолжать ли работу с чертежами или искать другие пути доступа.

Требования:
•	Программа должна принимать путь к файлу в виде текстовой строки.
•	На основе переданной строки должен быть создан объект типа Path.
•	Для проверки доступности файла для чтения должен использоваться метод Files.isReadable(Path).
•	Результат работы метода Files.isReadable (true или false) должен быть выведен на экран.

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        // Считываем путь к файлу как текстовую строку


        // Создаем объект Path на основе введенной строки


        // Проверяем право на чтение файла с помощью Files.isReadable(Path)


        // Выводим результат проверки: true или false

    }
}

 */

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String secretLink = console.nextLine();
        // Считываем путь к файлу как текстовую строку
        Path secretLinkPath = Paths.get(secretLink);


        // Создаем объект Path на основе введенной строки


        // Проверяем право на чтение файла с помощью Files.isReadable(Path)


        // Выводим результат проверки: true или false
        System.out.println(Files.isReadable(secretLinkPath));

    }
}
/*
public class Solution {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        // Считываем путь к файлу как текстовую строку
        String inputPath = console.nextLine();

        // Создаем объект Path на основе введенной строки
        Path path = Path.of(inputPath);

        // Проверяем право на чтение файла с помощью Files.isReadable(Path)
        boolean canRead = Files.isReadable(path);

        // Выводим результат проверки: true или false
        System.out.println(canRead);
    }
}
 */