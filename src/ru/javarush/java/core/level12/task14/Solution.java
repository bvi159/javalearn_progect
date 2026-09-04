package ru.javarush.java.core.level12.task14;
/*
Скачивание файла с помощью transferTo
Вы продолжаете улучшать свой модуль загрузки файлов, стремясь к максимальной эффективности. На этот раз вам нужно загрузить JPEG-изображение, используя более современный и потоковый подход к передаче данных.

Напишите программу, которая скачивает файл по адресу https://httpbin.org/image/jpeg. Сохраните его на диск с именем "image02.jpg".

Для получения входного потока данных по URL используйте класс URL и метод openStream(), как и раньше. Однако для записи в выходной поток примените метод transferTo(), который позволяет напрямую передать данные из InputStream в OutputStream. Выходной поток для файла создайте с помощью Files.newOutputStream(). Убедитесь, что после выполнения программы на вашем диске появится файл "image02.jpg".

Требования:
•	Программа должна использовать класс URL и его метод openStream() для получения InputStream с данными изображения по адресу https://httpbin.org/image/jpeg.
•	Для записи файла на диск программа должна создать OutputStream с помощью метода Files.newOutputStream() и указать имя файла "image02.jpg".
•	Программа должна использовать метод transferTo() объекта InputStream для передачи всех данных напрямую в OutputStream.
•	В результате выполнения программы на диске должен появиться файл с именем "image02.jpg" и корректным содержимым изображения.

public class Solution {
    public static void main(String[] args) throws IOException {
        // Создаем объект URL для указания адреса изображения
        URL url = new URL("https://httpbin.org/image/jpeg");

        // Открываем InputStream из URL (открытие соединения и получение данных)


        // Создаем OutputStream для записи данных в файл image02.jpg


        // Метод transferTo напрямую передаст все байты из input в output

    }
}

VM options: -Dhttps.proxyHost=223.1.1.57 -Dhttps.proxyPort=3128
 */

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;

public class Solution {
    public static void main(String[] args) throws IOException {
        // Настройка прокси (если нужен)
//        System.setProperty("http.proxyHost", "223.1.1.57");
//        System.setProperty("http.proxyPort", "3128");
//        System.setProperty("https.proxyHost", "223.1.1.57");
//        System.setProperty("https.proxyPort", "3128");

        // Создаем объект URL для указания адреса изображения
        URL url = new URL("https://httpbin.org/image/jpeg");
        try {

            // Открываем InputStream из URL (открытие соединения и получение данных)
            InputStream myImageIn = url.openStream();

            // Создаем OutputStream для записи данных в файл image02.jpg
            OutputStream myOut = Files.newOutputStream(Path.of("image02.jpg"));

            // Метод transferTo напрямую передаст все байты из input в output
            myImageIn.transferTo(myOut);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
/*
Ихнее решение

public class Solution {
    public static void main(String[] args) throws IOException {
        // Создаем объект URL для указания адреса изображения
        URL url = new URL("https://httpbin.org/image/jpeg");

        // Открываем InputStream из URL (открытие соединения и получение данных)
        InputStream input = url.openStream();

        // Создаем OutputStream для записи данных в файл image02.jpg
        OutputStream output = Files.newOutputStream(Path.of("image02.jpg"));

        // Метод transferTo напрямую передаст все байты из input в output
        input.transferTo(output);
    }
}

 */