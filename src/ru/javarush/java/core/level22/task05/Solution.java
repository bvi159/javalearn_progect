package ru.javarush.java.core.level22.task05;
/*
Запись в личную библиотеку 📖

Вы решили создать простое приложение для учета прочитанных книг. Для начала вам нужно определить, как будет храниться информация о каждой книге.
Создайте специальный класс-запись, который будет содержать название книги и имя её автора.
Затем в основной части вашей программы создайте экземпляр этой записи, например, для вашей любимой книги, указав её название и автора.
В завершение, выведите всю информацию об этой книге на экран, чтобы убедиться, что запись была создана корректно.

Требования:
•	В программе должен быть объявлен record-класс, содержащий два компонента: название книги и имя автора.
•	Поля record-класса должны быть неизменяемыми (final) и задаваться только через конструктор.
•	В основной части программы должен быть создан объект record-класса для конкретной книги с указанием названия и автора.
•	Программа должна вывести на экран всю информацию о созданной книге (название и автора).
•	В record-классе не должно быть сеттеров или других способов изменить поля после создания объекта.

public class Solution {
    public static void main(String[] args) {
        // Создаём экземпляр записи для любимой книги
        Book favoriteBook = new Book("Effective Java", "Joshua Bloch");

        // Выводим всю информацию о книге: название и автора
        System.out.println("Название: " + favoriteBook.title());
        System.out.println("Автор: " + favoriteBook.author());
    }
}

 */

public class Solution {
    public static void main(String[] args) {
        // Создаём экземпляр записи для любимой книги
        Book favoriteBook = new Book("Effective Java", "Joshua Bloch");
        Book book1 = new Book("Game of Thrones", "Victor Bakshee");

        // Выводим всю информацию о книге: название и автора
        System.out.println("Название: " + favoriteBook.title());
        System.out.println("Автор: " + favoriteBook.author());
        System.out.println(favoriteBook);
        System.out.println("Hashcode: "+favoriteBook.hashCode());
        System.out.println(favoriteBook.equals(book1));
        System.out.println("Hashcode book1: "+book1.hashCode());
    }
}

record Book(String title, String author) {

}

/*

// Объявляем record-класс для книги с двумя компонентами: название и автор.
record Book(String title, String author) {}

public class Solution {
    public static void main(String[] args) {
        // Создаём экземпляр записи для любимой книги
        Book favoriteBook = new Book("Effective Java", "Joshua Bloch");

        // Выводим всю информацию о книге: название и автора
        System.out.println("Название: " + favoriteBook.title());
        System.out.println("Автор: " + favoriteBook.author());
    }
}
 */