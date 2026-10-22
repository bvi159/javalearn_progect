package ru.javarush.java.core.level47.task08;

/*
Приложение вашей цифровой библиотеки должно уметь "читать" информацию о книгах из своих XML-хранилищ.

У вас есть файл book.xml со следующими данными:

<book>
    <title>Clean Code</title>
    <author>Robert Martin</author>
</book>
Ваша задача — написать программу, которая, используя JAXB, возьмет этот XML-файл и преобразует его обратно в объект Java класса Book (тот самый, что вы определили в предыдущей задаче).

После успешной десериализации, чтобы подтвердить, что все данные загружены корректно, выведите на экран информацию о книге в удобном для пользователя виде: "Название: Clean Code, Автор: Robert Martin". Это покажет, что ваше приложение успешно "прочитало" книгу из её цифрового формата.

Требования:
•	Класс Book должен быть корректно аннотирован аннотациями JAXB (@XmlRootElement, @XmlElement) для сопоставления с XML-структурой.
•	Программа должна прочитать данные из файла book.xml.
•	Для преобразования XML-файла в объект Book необходимо использовать стандартные средства JAXB (Unmarshaller).
•	Поля title и author класса Book должны быть заполнены на основании данных из XML-файла.
•	После успешной десериализации программа должна вывести на экран строку в формате: "Название: Clean Code, Автор: Robert Martin".
•	В программе должна быть реализована обработка возможных исключений, связанных с чтением файла и десериализацией.

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Unmarshaller;

import java.io.File;

public class Solution {
    public static void main(String[] args) {
        try {
            // Создаем контекст JAXB для класса Book


            // Создаем Unmarshaller для преобразования XML -> объект Java


            // Читаем XML из файла "book.xml" в текущей директории проекта


            // Выполняем десериализацию XML в объект Book


            // Выводим подтверждение корректной загрузки данных

        } catch (Exception e) {
            // Простая обработка возможных ошибок чтения/десериализации
            System.out.println("Ошибка при загрузке книги: " + e.getMessage());
        }
    }
}

 */

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Unmarshaller;

import java.io.File;

public class Solution {
    public static void main(String[] args) {
        try {
            // Создаем контекст JAXB для класса Book
            JAXBContext context = JAXBContext.newInstance(Book.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();

            // Создаем Unmarshaller для преобразования XML -> объект Java


            // Читаем XML из файла "book.xml" в текущей директории проекта
            Book myBook = (Book) unmarshaller.unmarshal(new File("book.xml"));
            System.out.println("Название: " + myBook.getTitle() + ", Автор: " + myBook.getAuthor());


            // Выполняем десериализацию XML в объект Book


            // Выводим подтверждение корректной загрузки данных

        } catch (Exception e) {
            // Простая обработка возможных ошибок чтения/десериализации
            System.out.println("Ошибка при загрузке книги: " + e.getMessage());
        }
    }
}

/*

 */