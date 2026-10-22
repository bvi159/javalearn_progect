package ru.javarush.java.core.level47.task09;
/*
public class LocalDateAdapter {
    // Потокобезопасный форматтер можно хранить в статическом поле

}
 */

import jakarta.xml.bind.annotation.adapters.XmlAdapter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LocalDateAdapter extends XmlAdapter<String, LocalDate> {
    // Потокобезопасный форматтер можно хранить в статическом поле
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    @Override
    public LocalDate unmarshal(String v) throws Exception {
        return (v == null || v.isEmpty()) ? null : LocalDate.parse(v, FORMATTER);
    }

    @Override
    public String marshal(LocalDate v) throws Exception {
        return (v == null) ? null : v.format(FORMATTER);
    }
}

/*
public class LocalDateAdapter extends XmlAdapter<String, LocalDate> {
    // Потокобезопасный форматтер можно хранить в статическом поле
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    @Override
    public LocalDate unmarshal(String value) {
        if (value == null || value.isEmpty()) return null; // простая защита от null/пустых строк
        return LocalDate.parse(value, FORMATTER);
    }

    @Override
    public String marshal(LocalDate value) {
        if (value == null) return null;
        return value.format(FORMATTER);
    }
}
 */