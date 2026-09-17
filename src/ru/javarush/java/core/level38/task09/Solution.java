package ru.javarush.java.core.level38.task09;
/*
Создание мимолётной записки: временное хранилище информации 📝
Вы — тайный агент, и вам нужно срочно записать конфиденциальную информацию, которая должна исчезнуть сразу после прочтения. Для этого вам требуется создать временный контейнер для данных, который будет существовать лишь короткое время.

Ваша программа должна создать такой временный файл, используя Files.createTempFile, при этом давая ему надёжный префикс "temp_" и суффикс ".tmp", чтобы его легко было отличить.

Как только этот временный файл будет создан, ваша программа должна немедленно сообщить вам его точный, полный путь на диске, чтобы вы могли быстро использовать его для ваших секретных целей.

Требования:
•	Программа должна создавать временный файл с помощью метода Files.createTempFile.
•	При создании временного файла необходимо явно указать префикс "temp_" и суффикс ".tmp".
•	Программа должна получить и использовать абсолютный путь к созданному временному файлу.
•	Программа должна вывести на экран точный полный путь к созданному временному файлу.
•	Временный файл должен создаваться в безопасном месте, предоставляемом системой, без указания пользовательских директорий.

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Solution {
    public static void main(String[] args) throws IOException {
        // Создаем временный файл в системной директории по умолчанию (безопасное место)
        // Явно задаем префикс "temp_" и суффикс ".tmp"


        // Помечаем файл на удаление при завершении работы JVM
        // (это подчеркивает "мимолетность" записки)


        // Выводим абсолютный путь к созданному временному файлу

    }
}

 */

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Solution {
    public static void main(String[] args) throws IOException {
        // Создаем временный файл в системной директории по умолчанию (безопасное место)
        // Явно задаем префикс "temp_" и суффикс ".tmp"
//        String userHome = System.getProperty("user.home");
//        Path tempFile = Files.createTempFile(Paths.get(userHome),"temp_", ".tmp");
        Path tempFile = Files.createTempFile("temp_", ".tmp");
        Path absTempPath = tempFile.toAbsolutePath();
        // Помечаем файл на удаление при завершении работы JVM
        // (это подчеркивает "мимолетность" записки)


        // Выводим абсолютный путь к созданному временному файлу
        System.out.println(absTempPath);
        Files.deleteIfExists(absTempPath);
    }
}
/*
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Solution {
    public static void main(String[] args) throws IOException {
        // Создаем временный файл в системной директории по умолчанию (безопасное место)
        // Явно задаем префикс "temp_" и суффикс ".tmp"
        Path tempFile = Files.createTempFile("temp_", ".tmp");

        // Помечаем файл на удаление при завершении работы JVM
        // (это подчеркивает "мимолетность" записки)
        tempFile.toFile().deleteOnExit();

        // Выводим абсолютный путь к созданному временному файлу
        System.out.println(tempFile.toAbsolutePath());
    }
}
 */