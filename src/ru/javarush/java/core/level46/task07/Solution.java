package ru.javarush.java.core.level46.task07;
/*
Извлечение данных из игрового профиля 🎮
Представьте, что вы — аналитик данных в игровой студии, и вам пришёл фрагмент данных о новом персонаже, который готовится к запуску. Эти данные выглядят как загадочный JSON-объект: {"id":100,"name":"Bob","active":false}. Ваша задача — быстро извлечь имя этого персонажа, не создавая при этом полноценный класс для него, ведь данные могут быть разными и постоянно меняться.

Используя мощь библиотеки Jackson и её класс ObjectMapper, десериализуйте этот JSON-фрагмент в универсальную структуру Map<String, Object>. Как только данные окажутся в карте, найдите и выведите на экран значение, которое хранится по ключу "name". Это поможет вам быстро идентифицировать персонажа и продолжить анализ!

Требования:
•	Необходимо подключить библиотеку Jackson (com.fasterxml.jackson.databind.ObjectMapper) для работы с JSON.
•	JSON-строку '{"id":100,"name":"Bob","active":false}' нужно десериализовать с помощью ObjectMapper в объект типа Map<String, Object>.
•	Для хранения данных должен использоваться именно Map<String, Object>, а не какой-либо специализированный Java-класс.
•	Из полученного Map необходимо получить значение по ключу "name".
•	Программа должна вывести на экран полученное значение имени персонажа.

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Map;

public class Solution {
    public static void main(String[] args) throws Exception {
        // Исходная JSON-строка с данными персонажа
        String json = "{\"id\":100,\"name\":\"Bob\",\"active\":false}";

        // ObjectMapper — основной класс Jackson для работы с JSON


        // Десериализация JSON в универсальную структуру Map<String, Object>
        // Используем TypeReference, чтобы сохранить дженерики при чтении


        // Извлекаем значение по ключу "name"


        // Выводим имя на экран
        System.out.println(name);
    }
}

 */
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Map;

public class Solution {
    public static void main(String[] args) throws Exception {
        // Исходная JSON-строка с данными персонажа
        String json = "{\"id\":100,\"name\":\"Bob\",\"active\":false}";

        // ObjectMapper — основной класс Jackson для работы с JSON
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> data = mapper.readValue(json, Map.class);
        String name = data.get("name").toString();

        // Десериализация JSON в универсальную структуру Map<String, Object>
        // Используем TypeReference, чтобы сохранить дженерики при чтении


        // Извлекаем значение по ключу "name"


        // Выводим имя на экран
        System.out.println(name);
    }
}
/*
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Map;

public class Solution {
    public static void main(String[] args) throws Exception {
        // Исходная JSON-строка с данными персонажа
        String json = "{\"id\":100,\"name\":\"Bob\",\"active\":false}";

        // ObjectMapper — основной класс Jackson для работы с JSON
        ObjectMapper objectMapper = new ObjectMapper();

        // Десериализация JSON в универсальную структуру Map<String, Object>
        // Используем TypeReference, чтобы сохранить дженерики при чтении
        Map<String, Object> data = objectMapper.readValue(json,
                new TypeReference<Map<String, Object>>() {}
        );

        // Извлекаем значение по ключу "name"
        String name = (String) data.get("name");

        // Выводим имя на экран
        System.out.println(name);
    }
}
 */