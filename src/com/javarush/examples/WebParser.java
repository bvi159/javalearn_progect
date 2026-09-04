package com.javarush.examples;


import java.net.*;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class WebParser {
//public class HttpBinTest {
    public static void main(String[] args) throws Exception {
        String proxyUser = "Vic_host.BIG";
        String proxyPass = "firstimpire";
        HttpClient client = HttpClient.newBuilder()
                .proxy(ProxySelector.of(new InetSocketAddress("223.1.1.57", 3128)))
                .authenticator(new Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(proxyUser, proxyPass.toCharArray());
                    }
                })
                .build();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI("https://yahoo.com"))
                .header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/109.0.0.0 Safari/537.36")
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
//        System.out.println(2%5);
    }
}

/*
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;

public class WebParser {
    public static void main(String[] args) {
        // Настройка прокси для всех HTTP-запросов
        System.setProperty("http.proxyHost", "223.1.1.57");
        System.setProperty("http.proxyPort", "3128");

        // Опционально: для HTTPS (если нужен)
//        System.setProperty("https.proxyHost", "your.proxy.com");
//        System.setProperty("https.proxyPort", "8080");
        System.setProperty("https.proxyHost", "223.1.1.57");
        System.setProperty("https.proxyPort", "3128");

//        String proxyUser = "Vic_host.BIG";
//        String proxyPass = "firstimpire";
//        // Вариант 1: Через системные свойства
//        System.setProperty("https.proxyUser", proxyUser);
//        System.setProperty("https.proxyPassword", proxyPass);
//        // Вариант 1: Через системные свойства
//        System.setProperty("http.proxyUser", proxyUser);
//        System.setProperty("http.proxyPassword", proxyPass);


        try {
            // 1. Загружаем страницу
//            Document doc = Jsoup.connect("https://dzen.ru/news?issue_tld=ru").get();
//            Document doc = Jsoup.connect("https://www.yandex.ru/news").get();
            //Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36
//            Document doc = Jsoup.connect("https://www.bbc.com/news")
//                    .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/109.0.0.0 Safari/537.36")
//                    .get();
            Document doc = Jsoup.connect("https://www.yahoo.com/news")
            .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/109.0.0.0 Safari/537.36")
            .get();
//            Document doc = Jsoup.connect("https://httpbin.org/get").get();
//            https://httpbin.org/get

            // 2. Ищем заголовки (например, по CSS-селектору)
            Elements headlines = doc.select("h3[class='gs-c-promo-heading__title']");

            // 3. Выводим результаты
            for (Element headline : headlines) {
                System.out.println(headline.text());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
*/