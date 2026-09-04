package ru.javarush.java.core.level12.task19;

/*

Получение случайного факта о кошках

Вам пришла идея создать приложение, которое будет развлекать пользователей случайными фактами. Начните с самых популярных — фактов о кошках!

Ваша задача — обратиться к API, который предоставляет такие факты, и просто показать пользователю полученный текст.

Сделайте GET-запрос к адресу "https://catfact.ninja/fact" с помощью HttpClient. Получите тело ответа от сервера в виде обычной строки и выведите его на экран.

Например, результатом может быть что-то вроде:

{"fact":"Cats have five toes on their front paws, but only four on the back.","length":71}
Требования:
•	В программе должны быть использованы классы из пакета java.net.http для выполнения HTTP-запроса.
•	Для отправки GET-запроса по адресу https://catfact.ninja/fact необходимо использовать HttpClient.
•	Программа должна выполнить HTTP-запрос методом GET по указанному адресу.
•	Тело ответа от сервера должно быть получено в виде строки.
•	Полученная строка с фактом о кошках должна быть выведена на экран.

public class Solution {
    public static void main(String[] args) throws Exception {
        // Создаем HTTP‑клиент по умолчанию


        // Готовим GET‑запрос к API фактов о кошках


        // Отправляем запрос и получаем ответ в виде строки


        // Выводим тело ответа на экран (JSON-строка с фактом о кошках)

    }
}

Параметры запуска
-Dhttps.proxyHost=223.1.1.57 -Dhttps.proxyPort=3128
или для http
VM options: -Dhttp.proxyHost=223.1.1.57 -Dhttp.proxyPort=3128
или для https
VM options: -Dhttps.proxyHost=223.1.1.57 -Dhttps.proxyPort=3128

 */

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Solution {
    public static void main(String[] args) throws Exception {
        // Создаем HTTP‑клиент по умолчанию
        String myCantURL = "https://catfact.ninja/fact";
        URI myCatUri = URI.create(myCantURL);
        HttpClient myCatClient = HttpClient.newHttpClient();
        // Готовим GET‑запрос к API фактов о кошках
        HttpRequest myCatRequest = HttpRequest.newBuilder(myCatUri).GET().build();

        // Отправляем запрос и получаем ответ в виде строки
        HttpResponse<String> myCatResponse = myCatClient.send(myCatRequest, HttpResponse.BodyHandlers.ofString());


        // Выводим тело ответа на экран (JSON-строка с фактом о кошках)
        System.out.println(myCatResponse.body());


    }
}