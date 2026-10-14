package ru.javarush.java.core.level46.task04;

/*
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

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

// Класс, описывающий событие университета
public class UniversityEvent {
    // Название события
    private String eventTitle;

    // Дата события. Аннотация @JsonFormat задаёт формат при сериализации в JSON
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
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