package ru.javarush.java.core.level46.task08;
/*
Обработка списка городов для путеводителя 🗺️
Вы разрабатываете умное приложение-путеводитель, которое получает информацию о различных городах мира в виде JSON-массива. Вот пример данных, которые вам приходят из внешнего источника: [{"city":"Rivertown"},{"city":"Northwood"}]. Ваша задача — извлечь названия всех этих городов и вывести их на экран, чтобы пользователь мог их просмотреть и выбрать следующее направление для путешествия.

Используя гибкую библиотеку Jackson и её сердце, ObjectMapper, десериализуйте этот JSON-массив в коллекцию List<Map<String, Object>>. После того как данные будут успешно загружены, пройдитесь по каждому элементу этого списка и для каждого элемента извлеките значение, хранящееся по ключу "city". Каждое найденное название города выведите на экран с новой строки, чтобы ваш путеводитель мог четко показать пользователю все доступные направления.

Требования:
•	В программе должен быть импортирован класс ObjectMapper из библиотеки Jackson.
•	JSON-массив вида [{"city":"Rivertown"},{"city":"Northwood"}] должен быть десериализован в объект типа List<Map<String, Object>> с помощью ObjectMapper.
•	Для каждого элемента списка (каждой Map) необходимо получить значение по ключу "city".
•	Каждое извлечённое название города должно быть выведено на экран с новой строки, в том порядке, в котором они идут в исходном JSON.
•	В качестве структуры данных для хранения результатов десериализации должен использоваться List<Map<String, Object>>.

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        // Считываем весь JSON из stdin (внешний источник) в одну строку
        Scanner console = new Scanner(System.in);
        StringBuilder rawJson = new StringBuilder();
        while (console.hasNextLine()) {
            rawJson.append(console.nextLine());
        }
        String json = rawJson.toString();

        // Создаем ObjectMapper — "сердце" Jackson


        // Из-за стирания типов (type erasure) передаем явный тип результата через TypeReference
        // Десериализуем JSON-массив в List<Map<String, Object>>


        // Для каждого элемента извлекаем значение по ключу "city" и печатаем с новой строки

    }
}

 */
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        // Считываем весь JSON из stdin (внешний источник) в одну строку
        Scanner console = new Scanner(System.in);
        StringBuilder rawJson = new StringBuilder();
        while (console.hasNextLine()) {
            String line = console.nextLine();
            if (line.equals("END")) break;
            rawJson.append(line);
        }
        String json = rawJson.toString();

        // Создаем ObjectMapper — "сердце" Jackson
        ObjectMapper mapper = new ObjectMapper();


        // Из-за стирания типов (type erasure) передаем явный тип результата через TypeReference
        // Десериализуем JSON-массив в List<Map<String, Object>>
        List<Map<String, Object>> cities = mapper.readValue(json, List.class);


        // Для каждого элемента извлекаем значение по ключу "city" и печатаем с новой строки
//        for (Map<String, Object> currentCity : cities) {
        for (var currentCity : cities) {
            System.out.println(currentCity.get("city"));
        }
    }
}

/*
package ru.javarush.java.core.level46.task08;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        // Считываем весь JSON из stdin (внешний источник) в одну строку
        Scanner console = new Scanner(System.in);
        StringBuilder rawJson = new StringBuilder();
        while (console.hasNextLine()) {
            rawJson.append(console.nextLine());
        }
        String json = rawJson.toString();

        // Создаем ObjectMapper — "сердце" Jackson
        ObjectMapper mapper = new ObjectMapper();

        // Из-за стирания типов (type erasure) передаем явный тип результата через TypeReference
        // Десериализуем JSON-массив в List<Map<String, Object>>
        var resultType = new TypeReference<List<Map<String, Object>>>() {};
        List<Map<String, Object>> cities = mapper.readValue(json, resultType);

        // Для каждого элемента извлекаем значение по ключу "city" и печатаем с новой строки
        for (Map<String, Object> item : cities) {
            Object city = item.get("city");
            System.out.println(city);
        }
    }
}

 */