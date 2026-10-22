package ru.javarush.java.core.level47.task09;

/*
Запись Даты События как Атрибута 📅
Вы разрабатываете систему управления событиями, и вам нужно, чтобы каждая запись о событии в XML содержала его дату максимально компактно и логично — как часть самого тега события.

Создайте класс Event с двумя полями: String title для названия события и LocalDate date для даты его проведения.

Ваша ключевая задача — реализовать специальный адаптер для поля date, который будет гарантировать, что при сериализации дата всегда записывается в формате "dd.MM.yyyy".

Используйте аннотацию @XmlAttribute, чтобы убедиться, что поле date будет представлено как атрибут XML-тега Event, а не как отдельный элемент.

Затем примените ваш адаптер к этому полю с помощью @XmlJavaTypeAdapter.

Наконец, выполните сериализацию объекта Event в XML. Убедитесь, что в получившемся XML дата события аккуратно вписана как атрибут внутри тега Event.

Требования:
•	Необходимо создать класс с именем Event с двумя полями: String title и LocalDate date.
•	Поле date должно быть помечено аннотацией @XmlAttribute, чтобы при сериализации оно стало атрибутом XML-тега Event.
•	Требуется создать собственный адаптер (класс, наследующий XmlAdapter), который преобразует LocalDate в строку формата "dd.MM.yyyy" и обратно.
•	Адаптер для поля date должен быть назначен с помощью аннотации @XmlJavaTypeAdapter непосредственно на это поле.
•	Необходимо выполнить сериализацию объекта Event в XML так, чтобы поле date отображалось как атрибут с датой в формате "dd.MM.yyyy" внутри тега Event.
•	Дата события в XML должна быть записана строго в формате "dd.MM.yyyy" (например, 05.06.2024).

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlRootElement;
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

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;

import java.time.LocalDate;

public class Solution {
    public static void main(String[] args) throws Exception {
        // Создаем пример события
        Event event = new Event("Java Meetup", LocalDate.of(2024, 6, 5));

        // Инициализируем JAXB-контекст по классу Event
        JAXBContext context = JAXBContext.newInstance(Event.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        marshaller.marshal(event, System.out); // Выведет XML в консоль

        // Настраиваем маршаллер (сериализацию в XML)


        // Сериализуем в XML и печатаем в консоль

    }
}

/*
public class Solution {
    public static void main(String[] args) throws Exception {
        // Создаем пример события
        Event event = new Event("Java Meetup", LocalDate.of(2024, 6, 5));

        // Инициализируем JAXB-контекст по классу Event
        JAXBContext context = JAXBContext.newInstance(Event.class);

        // Настраиваем маршаллер (сериализацию в XML)
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE); // красивый вывод

        // Сериализуем в XML и печатаем в консоль
        marshaller.marshal(event, System.out);
    }
}
 */