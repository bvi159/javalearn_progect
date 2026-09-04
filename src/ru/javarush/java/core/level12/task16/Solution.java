package ru.javarush.java.core.level12.task16;
/*
Получение типа содержимого и размера файла

Ваша задача — не просто скачать файл, но и получить о нем важную метаинформацию прямо во время загрузки. Вы хотите узнать его тип и размер, прежде чем сохранить его.

Скачайте файл по адресу https://httpbin.org/image/png, используя HttpClient. После того как получите ответ от сервера, извлеките и выведите на экран два ключевых значения: тип содержимого файла (который находится в заголовке Content-Type ответа) и общий размер файла в байтах.

Формат вывода должен быть таким: "Тип: image/png, Размер: 1234 байт".

Только после вывода этой информации сохраните загруженное изображение на диск с именем "image04.png".

Требования:
•	Для скачивания файла должен использоваться класс HttpClient из стандартной библиотеки Java.
•	Программа должна отправлять GET-запрос по адресу https://httpbin.org/image/png.
•	После получения ответа необходимо извлечь значение заголовка Content-Type и использовать его для вывода типа содержимого.
•	Программа должна определить общий размер загруженного файла в байтах на основе ответа сервера.
•	Информация о типе содержимого и размере файла должна выводиться в формате: "Тип: image/png, Размер: 1234 байт".

public class Solution {
    public static void main(String[] args) throws Exception {
        // Создаем HttpClient из стандартной библиотеки Java


        // Готовим GET-запрос на указанный URL


        // Отправляем запрос и сразу получаем тело как массив байт


        // Извлекаем тип содержимого из заголовка Content-Type


        // Определяем размер файла по длине массива байт ответа


        // Сначала выводим информацию о типе и размере


        // Только после вывода сохраняем изображение на диск

    }
}

Параметры запуска
-Dhttps.proxyHost=223.1.1.57 -Dhttps.proxyPort=3128
VM options: -Dhttps.proxyHost=223.1.1.57 -Dhttps.proxyPort=3128
 */

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;


//public class CatFactsInRussian {
public class Solution {
    public static void main(String[] args) {
        // URL с указанием параметра lang=rus для получения факта на русском языке
        String url = "https://meowfacts.herokuapp.com/?lang=rus";

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();

        try {
            // Важно: указываем UTF-8 для корректного отображения русских букв
            HttpResponse<String> response = client.send(request,
                    HttpResponse.BodyHandlers.ofString(StandardCharsets.UTF_8));

            // API возвращает JSON, где факт находится внутри массива "data"
            // Пример ответа: {"data": ["Коты спят 70% своей жизни"]}
            String jsonResponse = response.body();

            // Простой способ извлечь факт из JSON (для демонстрации)
            // В реальном проекте лучше использовать библиотеку для парсинга JSON, например, Jackson или Gson
            String fact = extractFactFromJson(jsonResponse);

            System.out.println("🐱 Факт о коте: " + fact);

        } catch (Exception e) {
            System.err.println("Ошибка при запросе: " + e.getMessage());
        }
    }

    // Простой метод для извлечения текста из JSON ({"data": ["текст факта"]})
    private static String extractFactFromJson(String json) {
        int start = json.indexOf("\"data\":[\"") + 9;
        int end = json.indexOf("\"]", start);
        if (start > 8 && end > start) {
            return json.substring(start, end);
        }
        return "Не удалось получить факт";
    }
}
/*
Ихнее решение

public class Solution {
    public static void main(String[] args) throws Exception {
        // Создаем HttpClient из стандартной библиотеки Java
        HttpClient client = HttpClient.newHttpClient();

        // Готовим GET-запрос на указанный URL
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://httpbin.org/image/png"))
                .GET()
                .build();

        // Отправляем запрос и сразу получаем тело как массив байт
        HttpResponse<byte[]> response = client.send(request, HttpResponse.BodyHandlers.ofByteArray());

        // Извлекаем тип содержимого из заголовка Content-Type
        String contentType = response.headers()
                .firstValue("Content-Type")
                .orElse("unknown");

        // Определяем размер файла по длине массива байт ответа
        byte[] body = response.body();
        int size = body.length;

        // Сначала выводим информацию о типе и размере
        System.out.println("Тип: " + contentType + ", Размер: " + size + " байт");

        // Только после вывода сохраняем изображение на диск
        Files.write(Path.of("image04.png"), body);
    }
}

 */