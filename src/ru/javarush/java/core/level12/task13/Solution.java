package ru.javarush.java.core.level12.task13;
/*
Скачивание файла через URL
Представьте, что вы создаете модуль для загрузки изображений для вашего нового фотоальбома. Ваша первая задача — реализовать базовую функцию скачивания изображения из интернета.

Создайте программу, которая обратится по веб-адресу https://httpbin.org/image/png и загрузит находящееся там PNG-изображение. Сохраните это изображение на свой диск с именем "image01.png".

Для установления соединения и получения потока данных используйте класс URL и его метод openStream(). Для эффективной записи файла на диск воспользуйтесь методом Files.copy().

После успешного выполнения программы в вашей рабочей папке должен появиться файл "image01.png", содержащий загруженное изображение.

Требования:
•	Программа должна использовать класс URL для указания адреса изображения в интернете.
•	Для получения потока данных с удалённого ресурса должен быть использован метод openStream() класса URL.
•	Программа должна скачивать изображение, доступное по адресу https://httpbin.org/image/png.
•	Загруженное изображение должно быть сохранено в файл с именем "image01.png" в рабочей директории.
•	Для записи полученного потока данных на диск должен быть использован метод Files.copy() из пакета java.nio.file.
public class Solution {
    public static void main(String[] args) throws IOException {
        // URL изображения, которое нужно скачать
        String imageUrl = "https://httpbin.org/image/png";
        // Имя файла, в который будет сохранено изображение
        String fileName = "image01.png";


    }
}

VM options: -Dhttps.proxyHost=223.1.1.57 -Dhttps.proxyPort=3128
 */
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;

public class Solution {
    public static void main(String[] args) throws IOException {
        // Настройка прокси (если нужен)
//        System.setProperty("http.proxyHost", "223.1.1.57");
//        System.setProperty("http.proxyPort", "3128");
        System.setProperty("https.proxyHost", "223.1.1.57");
        System.setProperty("https.proxyPort", "3128");

        // URL изображения, которое нужно скачать
        String imageUrl = "https://httpbin.org/image/png";
        // Имя файла, в который будет сохранено изображение
        String fileName = "image01.png";
        URL myUrlPath = new URL(imageUrl);
      Files.copy(myUrlPath.openStream(), Path.of(fileName));
  //      Files.copy(Path.of(imageUrl), Path.of(fileName));
    }
}