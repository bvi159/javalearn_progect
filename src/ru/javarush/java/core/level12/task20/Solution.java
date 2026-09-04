package ru.javarush.java.core.level12.task20;
/*
Получение и вывод координат МКС из JSON-ответа
Ваше приложение по отслеживанию МКС становится все более продвинутым, и теперь вам нужно не просто получить данные, а извлечь из них конкретную информацию — текущие координаты станции.

Ваша задача — вручную "разобрать" JSON-ответ, чтобы получить широту и долготу.

Сделайте GET-запрос к адресу "http://api.open-notify.org/iss-now.json" с помощью HttpClient.

Получите все тело ответа в виде строки. Затем, без использования сторонних библиотек для парсинга JSON, найдите в этой строке значения latitude и longitude, которые расположены внутри объекта iss_position.

Для этого используйте методы класса String, такие как indexOf для нахождения начала нужного фрагмента и substring для извлечения самого значения.

В конце выведите найденные координаты на экран в удобном формате: "Текущие координаты МКС: широта = [значение], долгота = [значение]".

Требования:
•	Программа должна выполнять GET-запрос по адресу http://api.open-notify.org/iss-now.json с помощью класса HttpClient.
•	Программа должна получить полное тело ответа сервера как строку.
•	Для извлечения значений latitude и longitude из объекта iss_position необходимо использовать только методы класса String (например, indexOf, substring), без сторонних библиотек для парсинга JSON.
•	Программа должна корректно найти и извлечь значения широты (latitude) и долготы (longitude) из строки-ответа.
•	Результат должен быть выведен на экран в формате: "Текущие координаты МКС: широта = [значение], долгота = [значение]".

public class Solution {
    public static void main(String[] args) throws Exception {
        // Создаем HttpClient и формируем GET-запрос
        HttpClient client = HttpClient.newHttpClient();
        URI uri = URI.create("http://api.open-notify.org/iss-now.json");


        // Отправляем запрос и получаем тело ответа целиком как строку


        // Вручную находим в строке объект "iss_position"


        // Находим границы объекта iss_position: от '{' до соответствующей '}'


        // Внутри iss_position извлекаем значения полей "latitude" и "longitude"


        // Форматированный вывод координат
        System.out.println("Текущие координаты МКС: широта = " + latitude + ", долгота = " + longitude);
    }

    // Вспомогательный метод: извлекает строковое значение поля по его имени внутри JSON-фрагмента.
    // Логика простая: находим "ключ", затем двоеточие, затем первую и вторую кавычки значения.
    private static String extractQuotedValue(String jsonFragment, String fieldName) {
        int keyPos = jsonFragment.indexOf("\"" + fieldName + "\""); // позиция ключа "fieldName"
        int colonPos = jsonFragment.indexOf(':', keyPos);           // двоеточие после ключа
        int firstQuote = jsonFragment.indexOf('"', colonPos + 1);   // открывающая кавычка значения
        int secondQuote = jsonFragment.indexOf('"', firstQuote + 1); // закрывающая кавычка значения
        return jsonFragment.substring(firstQuote + 1, secondQuote);  // само значение между кавычками
    }
}

Параметры запуска
-Dhttps.proxyHost=223.1.1.57 -Dhttps.proxyPort=3128
или для http
VM options: -Dhttp.proxyHost=223.1.1.57 -Dhttp.proxyPort=3128
или для https
VM options: -Dhttps.proxyHost=223.1.1.57 -Dhttps.proxyPort=3128

более адекватный сайт для iss
 urlWeather = "https://api.wheretheiss.at/v1/satellites/25544";

 */
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Solution {
    public static void main(String[] args) throws Exception {
        // Создаем HttpClient и формируем GET-запрос
        HttpClient client = HttpClient.newHttpClient();
        URI uri = URI.create("http://api.open-notify.org/iss-now.json");
//        URI uri = URI.create("https://api.wheretheiss.at/v1/satellites/25544"); // более адекватный сайт

        // Отправляем запрос и получаем тело ответа целиком как строку
        HttpRequest myIssRequest = HttpRequest.newBuilder(uri).GET().build();

        // Вручную находим в строке объект "iss_position"
        HttpResponse <String> myIssResponse = client.send(myIssRequest, HttpResponse.BodyHandlers.ofString());
        System.out.println(myIssResponse.body());
        // Находим границы объекта iss_position: от '{' до соответствующей '}'
        String issPosition = extractBracesValue(myIssResponse.body(), "iss_position");
        System.out.println(issPosition);
        // Внутри iss_position извлекаем значения полей "latitude" и "longitude"
//        String latitude = extractQuotedValue(myIssResponse.body(), "latitude");
//        String longitude = extractQuotedValue(myIssResponse.body(), "longitude");
        String latitude = extractQuotedValue(issPosition, "latitude");
        String longitude = extractQuotedValue(issPosition, "longitude");


        // Форматированный вывод координат
        System.out.println("Текущие координаты МКС: широта = " + latitude + ", долгота = " + longitude);
    }

    // Вспомогательный метод: извлекает строковое значение поля по его имени внутри JSON-фрагмента.
    // Логика простая: находим "ключ", затем двоеточие, затем первую и вторую фигурные скобки значения.
    // Это я сам написал
    private static String extractBracesValue(String jsonFragment, String fieldName) {
        int keyPos = jsonFragment.indexOf("\"" + fieldName + "\""); // позиция ключа "fieldName"
        int colonPos = jsonFragment.indexOf(':', keyPos);           // двоеточие после ключа
        int firstQuote = jsonFragment.indexOf('{', colonPos + 1);   // открывающая скобка значения
        int secondQuote = jsonFragment.indexOf('}', firstQuote + 1); // закрывающая скобка значения
        return jsonFragment.substring(firstQuote + 1, secondQuote);  // само значение между скобками
    }

    // Вспомогательный метод: извлекает строковое значение поля по его имени внутри JSON-фрагмента.
    // Логика простая: находим "ключ", затем двоеточие, затем первую и вторую кавычки значения.
    private static String extractQuotedValue(String jsonFragment, String fieldName) {
        int keyPos = jsonFragment.indexOf("\"" + fieldName + "\""); // позиция ключа "fieldName"
        int colonPos = jsonFragment.indexOf(':', keyPos);           // двоеточие после ключа
        int firstQuote = jsonFragment.indexOf('"', colonPos + 1);   // открывающая кавычка значения
        int secondQuote = jsonFragment.indexOf('"', firstQuote + 1); // закрывающая кавычка значения
        return jsonFragment.substring(firstQuote + 1, secondQuote);  // само значение между кавычками
    }

}
/*
Ихнее решение

public class Solution {
    public static void main(String[] args) throws Exception {
        // Создаем HttpClient и формируем GET-запрос
        HttpClient client = HttpClient.newHttpClient();
        URI uri = URI.create("http://api.open-notify.org/iss-now.json");
        HttpRequest request = HttpRequest.newBuilder(uri).GET().build();

        // Отправляем запрос и получаем тело ответа целиком как строку
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        String body = response.body();

        // Вручную находим в строке объект "iss_position"
        int issPosIndex = body.indexOf("\"iss_position\"");
        if (issPosIndex < 0) {
            System.out.println("Не удалось найти объект iss_position в ответе.");
            return;
        }

        // Находим границы объекта iss_position: от '{' до соответствующей '}'
        int startBrace = body.indexOf('{', issPosIndex); // открывающая скобка объекта
        int endBrace = body.indexOf('}', startBrace);    // закрывающая скобка объекта (внутри нет вложенных объектов)
        String issObject = body.substring(startBrace, endBrace + 1);

        // Внутри iss_position извлекаем значения полей "latitude" и "longitude"
        String latitude = extractQuotedValue(issObject, "latitude");
        String longitude = extractQuotedValue(issObject, "longitude");

        // Форматированный вывод координат
        System.out.println("Текущие координаты МКС: широта = " + latitude + ", долгота = " + longitude);
    }

    // Вспомогательный метод: извлекает строковое значение поля по его имени внутри JSON-фрагмента.
    // Логика простая: находим "ключ", затем двоеточие, затем первую и вторую кавычки значения.
    private static String extractQuotedValue(String jsonFragment, String fieldName) {
        int keyPos = jsonFragment.indexOf("\"" + fieldName + "\""); // позиция ключа "fieldName"
        int colonPos = jsonFragment.indexOf(':', keyPos);           // двоеточие после ключа
        int firstQuote = jsonFragment.indexOf('"', colonPos + 1);   // открывающая кавычка значения
        int secondQuote = jsonFragment.indexOf('"', firstQuote + 1); // закрывающая кавычка значения
        return jsonFragment.substring(firstQuote + 1, secondQuote);  // само значение между кавычками
    }
}

 */
