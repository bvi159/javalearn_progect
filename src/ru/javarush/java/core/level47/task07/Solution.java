package ru.javarush.java.core.level47.task07;
/*
Проектирование Книжной Записи для Цифровой Библиотеки 📖
Вы создаете цифровую библиотеку, и вам нужно определить, как информация о каждой книге будет храниться в формате XML. Ваша задача — спроектировать класс Book в Java таким образом, чтобы он мог быть автоматически преобразован в XML и обратно с помощью JAXB.

В этом классе должны быть два закрытых поля: String title для названия книги и String author для её автора.

Важно добавить аннотацию к самому классу Book, чтобы указать JAXB, что он должен быть корневым элементом при создании XML. Для обоих полей (title и author) реализуйте публичные методы-геттеры и сеттеры. Не забудьте также включить публичный конструктор без параметров, так как это требование для JAXB.

В результате, если вы создадите объект Book с названием "Java" и автором "Smith", его XML-представление должно выглядеть следующим образом:

<book>
    <title>Java</title>
    <author>Smith</author>
</book>
Требования:
•	Класс Book должен быть аннотирован так, чтобы JAXB воспринимал его как корневой элемент XML (например, с помощью @XmlRootElement).
•	Класс Book должен содержать два закрытых (private) поля: String title и String author.
•	Для каждого поля (title и author) должны быть реализованы публичные методы-геттеры и сеттеры.
•	Класс Book должен содержать публичный конструктор без параметров (no-args constructor).
•	При маршалинге экземпляра Book с title="Java" и author="Smith" результатом должен быть XML вида: <book> <title>Java</title> <author>Smith</author> </book>

import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

// Помечаем класс как корневой элемент XML <book>...</book>

// Явно задаем порядок элементов в XML: сначала <title>, затем <author>

public class Book {
    // Приватные поля по условию задачи
    private String title;
    private String author;

    public Book() {
        // Публичный конструктор без параметров обязателен для JAXB
    }

    // Дополнительный удобный конструктор (не обязателен, но полезен для примеров и тестов)
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    // Публичные геттеры и сеттеры по условию задачи
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
*/
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;

import java.io.File;

public class Solution {
    public static void main(String[] args) throws Exception {
        // Создаем тестовый объект
        Book book = new Book("Java", "Smith");

        // Создаем JAXB-контекст только для класса Book
        JAXBContext context = JAXBContext.newInstance(Book.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE); // Красивый вывод

        marshaller.marshal(book, System.out); // Пишем XML в консоль
//         marshaller.marshal(book, new File("player.xml")); // Или в файл


        // Подготавливаем маршалер (преобразователь объекта в XML)


        // Выводим XML-представление в консоль

    }
}

/*
package ru.javarush.java.core.level47.task07;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;

public class Solution {
    public static void main(String[] args) throws Exception {
        // Создаем тестовый объект
        Book book = new Book("Java", "Smith");

        // Создаем JAXB-контекст только для класса Book
        JAXBContext context = JAXBContext.newInstance(Book.class);

        // Подготавливаем маршалер (преобразователь объекта в XML)
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE); // Красивое форматирование

        // Выводим XML-представление в консоль
        marshaller.marshal(book, System.out);
    }
}
 */