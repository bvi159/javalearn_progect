package ru.javarush.java.core.level46.task04;
/*
Управление событиями в университетском календаре 🗓️
Вы — архитектор новой системы планирования мероприятий для университета. Ваша задача — создать удобное представление для событий, чтобы они корректно отображались в JSON-формате, особенно это касается дат, которые должны быть единообразными и легко читаемыми.

Создайте Java-класс UniversityEvent с двумя приватными полями: eventTitle (название события, тип String) и eventDate (дата проведения, тип java.util.Date). Конечно, не забудьте про геттеры и сеттеры для доступа к этим полям.

Самое важное: для поля eventDate используйте специальную аннотацию @JsonFormat с шаблоном "yyyy-MM-dd". Это гарантирует, что при преобразовании объекта в JSON дата всегда будет выглядеть в привычном и понятном формате "Год-Месяц-День".

Затем создайте конкретное событие: объект UniversityEvent с названием "Выпускной экзамен" и датой "2024-06-10". Помните, что вам потребуется использовать SimpleDateFormat для правильного преобразования этой строковой даты в объект java.util.Date.

Наконец, вооружившись ObjectMapper, превратите ваш объект события в JSON-строку и выведите её на экран. Убедитесь, что полученная строка идеально соответствует вашим требованиям: название события и его дата представлены именно в корректном, заданном формате.

Требования:
•	Необходимо создать класс UniversityEvent с двумя приватными полями: eventTitle (String) и eventDate (java.util.Date).
•	Класс UniversityEvent должен содержать публичные геттеры и сеттеры для обоих полей: eventTitle и eventDate.
•	Поле eventDate должно быть аннотировано с помощью @JsonFormat(pattern = "yyyy-MM-dd"), чтобы задать формат сериализации даты в JSON.
•	Требуется создать объект UniversityEvent с названием "Выпускной экзамен" и датой "2024-06-10".
•	Для преобразования строки "2024-06-10" в объект java.util.Date необходимо использовать SimpleDateFormat с соответствующим шаблоном.
•	Необходимо использовать ObjectMapper для преобразования объекта UniversityEvent в JSON-строку.
•	Сериализованная JSON-строка должна быть выведена на экран.
•	В итоговой JSON-строке дата события (eventDate) должна быть представлена в формате "yyyy-MM-dd" (например, "2024-06-10").

import com.fasterxml.jackson.databind.ObjectMapper;

import java.text.SimpleDateFormat;
import java.util.Date;

// Главный класс решения задачи
public class Solution {
    public static void main(String[] args) throws Exception {
        // Создаем SimpleDateFormat с шаблоном "yyyy-MM-dd" для парсинга строковой даты
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = sdf.parse("2024-06-10"); // Преобразуем строку в объект java.util.Date

        // Формируем объект UniversityEvent с нужным названием и датой
        UniversityEvent event = new UniversityEvent();
        event.setEventTitle("Выпускной экзамен");
        event.setEventDate(date);

        // Создаем Jackson ObjectMapper и сериализуем объект в JSON-строку
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(event);

        // Выводим результат на экран
        System.out.println(json);
    }
}

// Класс, описывающий событие университета
public class UniversityEvent {
    // Название события
    private String eventTitle;

    // Дата события. Аннотация @JsonFormat задаёт формат при сериализации в JSON

    private Date eventDate;

    // Геттер для поля eventTitle
    public String getEventTitle() {
        return eventTitle;
    }

    // Сеттер для поля eventTitle
    public void setEventTitle(String eventTitle) {
        this.eventTitle = eventTitle;
    }

    // Геттер для поля eventDate
    public Date getEventDate() {
        return eventDate;
    }

    // Сеттер для поля eventDate
    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }
}

 */

import com.fasterxml.jackson.databind.ObjectMapper;

import java.text.SimpleDateFormat;
import java.util.Date;

// Главный класс решения задачи
public class Solution {
    public static void main(String[] args) throws Exception {
        // Создаем SimpleDateFormat с шаблоном "yyyy-MM-dd" для парсинга строковой даты
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = sdf.parse("2024-06-10"); // Преобразуем строку в объект java.util.Date

        // Формируем объект UniversityEvent с нужным названием и датой
        UniversityEvent event = new UniversityEvent();
        event.setEventTitle("Выпускной экзамен");
        event.setEventDate(date);

        // Создаем Jackson ObjectMapper и сериализуем объект в JSON-строку
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(event);

        // Выводим результат на экран
        System.out.println(json);
    }
}

/*
mport java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

// Класс, описывающий событие университета
public class UniversityEvent {
    // Название события
    private String eventTitle;

    // Дата события. Аннотация @JsonFormat задаёт формат при сериализации в JSON
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date eventDate;

    // Геттер для поля eventTitle
    public String getEventTitle() {
        return eventTitle;
    }

    // Сеттер для поля eventTitle
    public void setEventTitle(String eventTitle) {
        this.eventTitle = eventTitle;
    }

    // Геттер для поля eventDate
    public Date getEventDate() {
        return eventDate;
    }

    // Сеттер для поля eventDate
    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }
}
 */