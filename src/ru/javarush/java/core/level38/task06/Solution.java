package ru.javarush.java.core.level38.task06;
/*
Аудит безопасности: проверка подлинности секретного досье 🛡️

Вы — ведущий аудитор в сверхсекретном агентстве, и вам предстоит проверить подлинность крайне важного файла "check.txt", в котором хранится ценная информация.
Для начала, создайте этот файл и запишите в него любую тестовую строку – это будет ваш оригинал.
Ваша задача — написать программу, которая вычислит уникальный цифровой отпечаток (SHA-256-хеш) этого файла.
Затем этот полученный отпечаток необходимо сравнить с контрольным значением, которое, как вам известно, заведомо неправильное (например, "это_неправильная_контрольная_сумма_12345").
Если цифровые отпечатки не совпадут – а они, конечно, не совпадут, учитывая заведомо неверное контрольное значение – ваша система должна немедленно выдать предупреждение: "Файл check.txt повреждён! Попробуйте восстановить из резервной копии.".
Используйте стандартный класс MessageDigest для создания этого мощного цифрового отпечатка.

Требования:
•	Программа должна создать файл с именем "check.txt" и записать в него любую тестовую строку.
•	Программа должна вычислить SHA-256-хеш содержимого файла "check.txt" с помощью класса MessageDigest.
•	Программа должна сравнить полученный SHA-256-хеш с заведомо неправильной контрольной суммой (например, "это_неправильная_контрольная_сумма_12345").
•	Если рассчитанный хеш не совпадает с контрольным значением, программа должна вывести сообщение: "Файл check.txt повреждён! Попробуйте восстановить из резервной копии."
•	Для вычисления хеша должен быть использован стандартный класс MessageDigest из пакета java.security.

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.MessageDigest;

public class Solution {
    public static void main(String[] args) throws Exception {
        Path file = Path.of("check.txt");

        // 1) Создаем файл и записываем в него тестовую строку — наш "оригинал"


        // 2) Вычисляем SHA-256-хеш содержимого файла с помощью стандартного класса MessageDigest


        // 3) Сравниваем с заведомо неправильной контрольной суммой


        // 4) При несовпадении выводим предупреждение

    }

    // Утилитный метод: перевод массива байт в hex-строку (нижний регистр)
    private static String toHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder(bytes.length * 2);
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }
}

 */

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.MessageDigest;

public class Solution {
    public static void main(String[] args) throws Exception {
        Path file = Path.of("check.txt");

        // 1) Создаем файл и записываем в него тестовую строку — наш "оригинал"
        Files.createFile(file);
        Files.writeString(file, "оригинал", StandardCharsets.UTF_8);

        // 2) Вычисляем SHA-256-хеш содержимого файла с помощью стандартного класса MessageDigest
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        // 3) Читаем файл и обновляем digest
        byte[] fileBytes = Files.readAllBytes(file);
        md.update(fileBytes);
        String controlChekSumm = toHex(md.digest());

        // 3) Сравниваем с заведомо неправильной контрольной суммой
        if (!controlChekSumm.equals("123456")) {
            System.out.println("Файл check.txt повреждён! Попробуйте восстановить из резервной копии.");
        }


        // 4) При несовпадении выводим предупреждение

    }

    // Утилитный метод: перевод массива байт в hex-строку (нижний регистр)
    private static String toHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder(bytes.length * 2);
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }
}
/*
public class Solution {
    public static void main(String[] args) throws Exception {
        Path file = Path.of("check.txt");

        // 1) Создаем файл и записываем в него тестовую строку — наш "оригинал"
        Files.writeString(file, "Секретная проверка: тестовая строка.", StandardCharsets.UTF_8);

        // 2) Вычисляем SHA-256-хеш содержимого файла с помощью стандартного класса MessageDigest
        byte[] content = Files.readAllBytes(file);          // читаем все байты файла
        MessageDigest md = MessageDigest.getInstance("SHA-256"); // алгоритм SHA-256
        byte[] hash = md.digest(content);                   // считаем хеш
        String hexHash = toHex(hash);                       // переводим байты хеша в шестнадцатеричную строку

        // 3) Сравниваем с заведомо неправильной контрольной суммой
        String control = "это_неправильная_контрольная_сумма_12345";

        // 4) При несовпадении выводим предупреждение
        if (!hexHash.equals(control)) {
            System.out.println("Файл check.txt повреждён! Попробуйте восстановить из резервной копии.");
        }
    }

    // Утилитный метод: перевод массива байт в hex-строку (нижний регистр)
    private static String toHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder(bytes.length * 2);
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }
}
 */