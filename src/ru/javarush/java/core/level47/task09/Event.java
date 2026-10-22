package ru.javarush.java.core.level47.task09;

/*
import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import java.time.LocalDate;

public class Event {
    // Название события будет элементом внутри <Event> (по умолчанию для поля)

    public String title;

    // Дата события — атрибут тега <Event>, форматируется через адаптер

    public LocalDate date;

    // Пустой конструктор обязателен для JAXB
    public Event() { }

    public Event(String title, LocalDate date) {
        this.title = title;
        this.date = date;
    }
}

 */

import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import java.time.LocalDate;

@XmlRootElement
public class Event {
    // Название события будет элементом внутри <Event> (по умолчанию для поля)
    @XmlElement
    public String title;

    // Дата события — атрибут тега <Event>, форматируется через адаптер
    @XmlAttribute
    @XmlJavaTypeAdapter(LocalDateAdapter.class)
    public LocalDate date;

    // Пустой конструктор обязателен для JAXB
    public Event() { }

    public Event(String title, LocalDate date) {
        this.title = title;
        this.date = date;
    }

//    public String getTitle() {
//        return title;
//    }
//
//
//    public LocalDate getDate() {
//        return date;
//    }
}

/*
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import java.time.LocalDate;

@XmlRootElement(name = "Event")
@XmlAccessorType(XmlAccessType.FIELD)
public class Event {
    // Название события будет элементом внутри <Event> (по умолчанию для поля)
    public String title;

    // Дата события — атрибут тега <Event>, форматируется через адаптер
    @XmlAttribute(name = "date")
    @XmlJavaTypeAdapter(LocalDateAdapter.class)
    public LocalDate date;

    // Пустой конструктор обязателен для JAXB
    public Event() { }

    public Event(String title, LocalDate date) {
        this.title = title;
        this.date = date;
    }
}
 */