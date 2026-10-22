package ru.javarush.java.core.level47.task10;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


@XmlRootElement(name = "calendar")
@XmlAccessorType(XmlAccessType.FIELD) // JAXB будет работать с полями напрямую
public class Calendar {

    // Создаём контейнер <holidays> и внутри него элементы <date> для каждой даты
    @XmlElementWrapper(name = "holidays")              // общий контейнер для списка
    @XmlElement(name = "date")                         // имя каждого элемента списка
    @XmlJavaTypeAdapter(LocalDateAdapter.class)        // применяем адаптер к элементам списка
    private List<LocalDate> holidays = new ArrayList<>();

    // Пустой конструктор обязателен для JAXB
    public Calendar() {
    }

    public List<LocalDate> getHolidays() {
        return holidays;
    }

    public void setHolidays(List<LocalDate> holidays) {
        this.holidays = holidays;
    }

    // Удобный метод для добавления праздничной даты
    public void addHoliday(LocalDate date) {
        holidays.add(date);
    }
}

/*
package ru.javarush.java.core.level47.task10;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlRootElement(name = "calendar")
@XmlAccessorType(XmlAccessType.FIELD) // JAXB будет работать с полями напрямую
public class Calendar {

    // Создаём контейнер <holidays> и внутри него элементы <date> для каждой даты
    @XmlElementWrapper(name = "holidays")              // общий контейнер для списка
    @XmlElement(name = "date")                         // имя каждого элемента списка
    @XmlJavaTypeAdapter(LocalDateAdapter.class)        // применяем адаптер к элементам списка
    private List<LocalDate> holidays = new ArrayList<>();

    // Пустой конструктор обязателен для JAXB
    public Calendar() {
    }

    public List<LocalDate> getHolidays() {
        return holidays;
    }

    public void setHolidays(List<LocalDate> holidays) {
        this.holidays = holidays;
    }

    // Удобный метод для добавления праздничной даты
    public void addHoliday(LocalDate date) {
        holidays.add(date);
    }
}

 */