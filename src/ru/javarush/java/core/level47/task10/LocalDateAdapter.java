package ru.javarush.java.core.level47.task10;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class LocalDateAdapter extends XmlAdapter<String, LocalDate> {
    // Единый форматтер для сериализации и десериализации
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    @Override
    public LocalDate unmarshal(String value) {
        // Преобразуем строку в дату (обратное преобразование)
        if (value == null || value.isBlank()) return null;
        return LocalDate.parse(value, FORMATTER);
    }

    @Override
    public String marshal(LocalDate value) {
        // Преобразуем дату в строку требуемого формата
        if (value == null) return null;
        return value.format(FORMATTER);
    }
}
/*
public class LocalDateAdapter extends XmlAdapter<String, LocalDate> {
    // Единый форматтер для сериализации и десериализации
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    @Override
    public LocalDate unmarshal(String value) {
        // Преобразуем строку в дату (обратное преобразование)
        if (value == null || value.isBlank()) return null;
        return LocalDate.parse(value, FORMATTER);
    }

    @Override
    public String marshal(LocalDate value) {
        // Преобразуем дату в строку требуемого формата
        if (value == null) return null;
        return value.format(FORMATTER);
    }
}
 */