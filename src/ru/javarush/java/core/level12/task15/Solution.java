package ru.javarush.java.core.level12.task15;
/*
Скачивание файла через HttpClient

Вы переходите к разработке более надежного загрузчика контента, который должен уметь обрабатывать ответы сервера. Теперь вы будете использовать HttpClient для загрузки изображений, что позволит вам более точно контролировать процесс и проверять статус загрузки.

Реализуйте программу, которая скачивает файл по адресу "https://httpbin.org/image/webp".

Прежде чем сохранять файл, обязательно проверьте, что HTTP-статус ответа сервера равен 200 (что означает успешную загрузку). Только если статус равен 200, сохраните содержимое файла на диск с именем "image03.webp", используя Files.write().

Если же код ответа не равен 200, выведите на экран сообщение, информирующее об ошибке загрузки, например: "Ошибка загрузки: код ответа X", где X — это фактический полученный код ответа.

Требования:
•	Программа должна использовать класс HttpClient для выполнения HTTP-запроса по заданному URL.
•	Перед сохранением файла программа должна проверить, что HTTP-статус ответа сервера равен 200.
•	Содержимое файла должно сохраняться на диск с именем "image03.webp" только если статус ответа равен 200.
•	Для сохранения данных на диск необходимо использовать метод Files.write.
•	Если код ответа не равен 200, программа должна вывести сообщение "Ошибка загрузки: код ответа X", где X — фактический код ответа сервера.

public class Solution {
    public static void main(String[] args) throws Exception {
        // Адрес изображения
        String url = "https://httpbin.org/image/webp";

        // Создаем клиент HTTP (стандартная конфигурация)


        // Готовим GET-запрос к нужному URL


        // Отправляем запрос и получаем ответ как массив байт (тело — бинарные данные картинки)


        int status = response.statusCode(); // Проверяем HTTP-статус
        if (status == 200) {
            // Сохраняем файл только при успешном ответе 200
            Path target = Path.of("image03.webp");
            Files.write(target, response.body()); // Записываем байты на диск
        } else {
            // Если сервер вернул неуспешный код — выводим сообщение об ошибке
            System.out.println("Ошибка загрузки: код ответа " + status);
        }
    }
}
VM options: -Dhttps.proxyHost=223.1.1.57 -Dhttps.proxyPort=3128
 */
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.nio.file.Path;

public class Solution {
    public static void main(String[] args) throws Exception {
        // Адрес изображения
        String url = "https://httpbin.org/image/webp";

        // Создаем клиент HTTP (стандартная конфигурация)
        var uriAdress = URI.create(url);            // URI - более современная версия URL
        var client = HttpClient.newHttpClient();   // Создаем объект HttpClient

        // Готовим GET-запрос к нужному URL
        HttpRequest request = HttpRequest.newBuilder(uriAdress).build(); // Создаем объект "запрос"

        // Отправляем запрос и получаем ответ как массив байт (тело — бинарные данные картинки)
        HttpResponse<byte[]> response = client.send(request, HttpResponse.BodyHandlers.ofByteArray());

        int status = response.statusCode(); // Проверяем HTTP-статус
        if (status == 200) {
            // Сохраняем файл только при успешном ответе 200
            Path target = Path.of("image03.webp");
            Files.write(target, response.body()); // Записываем байты на диск
        } else {
            // Если сервер вернул неуспешный код — выводим сообщение об ошибке
            System.out.println("Ошибка загрузки: код ответа " + status);
        }
    }
}

/*
Ихнее решение

public class Solution {
    public static void main(String[] args) throws Exception {
        // Адрес изображения
        String url = "https://httpbin.org/image/webp";

        // Создаем клиент HTTP (стандартная конфигурация)
        HttpClient client = HttpClient.newHttpClient();

        // Готовим GET-запрос к нужному URL
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();

        // Отправляем запрос и получаем ответ как массив байт (тело — бинарные данные картинки)
        HttpResponse<byte[]> response = client.send(request, HttpResponse.BodyHandlers.ofByteArray());

        int status = response.statusCode(); // Проверяем HTTP-статус
        if (status == 200) {
            // Сохраняем файл только при успешном ответе 200
            Path target = Path.of("image03.webp");
            Files.write(target, response.body()); // Записываем байты на диск
        } else {
            // Если сервер вернул неуспешный код — выводим сообщение об ошибке
            System.out.println("Ошибка загрузки: код ответа " + status);
        }
    }
}


 */