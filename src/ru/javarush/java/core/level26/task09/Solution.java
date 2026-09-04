package ru.javarush.java.core.level26.task09;

/*
Каталог моей цифровой библиотеки 📚✍

Вы разрабатываете небольшой каталог для вашей личной цифровой библиотеки. Каждая запись в каталоге должна содержать информацию о книге: её название и автора.
Сначала опишите, как будет выглядеть каждая "книга" в вашей системе, создав для неё специальный класс, который будет хранить название (строка) и автора (строка).
Затем создайте "полку" или "список" для хранения этих книг.
Добавьте на вашу виртуальную полку две совершенно разные книги, каждую со своим названием и автором.
В конце, пройдитесь по всему вашему каталогу и покажите название и автора каждой книги, чтобы убедиться, что всё на месте и ваш каталог функционирует.

Требования:
•	Необходимо создать отдельный класс, который будет представлять книгу и содержать два поля: название книги (строка) и автор книги (строка).
•	Для хранения списка книг в каталоге должен использоваться дженерик-класс коллекции (например, ArrayList<Book>).
•	В коллекцию необходимо добавить два разных объекта книги, у которых различаются как названия, так и авторы.
•	Программа должна пройтись по всем элементам коллекции и для каждой книги вывести на экран её название и автора.

import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        // Создаем дженерик-коллекцию для хранения книг (каталог)


        // Добавляем две разные книги с разными названиями и авторами


        // Перебираем каталог и выводим название и автора каждой книги

    }
}

// Отдельный класс, представляющий книгу: хранит название и автора
class Book {
    private final String title;
    private final String author;

    // Конструктор инициализирует поля книги
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    // Геттеры для доступа к полям
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }
}


 */

import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        // Создаем дженерик-коллекцию для хранения книг (каталог)
        ArrayList<Book> myBooks = new ArrayList<>();
        myBooks.add(new Book("Алые паруса", "Александр Грин"));
        myBooks.add(new Book("Я робот", "Айзек Азимов"));

        // Добавляем две разные книги с разными названиями и авторами


        // Перебираем каталог и выводим название и автора каждой книги
        for (Book book : myBooks) {
            System.out.println("Название: "+ book.getTitle() +", Автор: " + book.getAuthor());

        }

    }
}

// Отдельный класс, представляющий книгу: хранит название и автора
class Book {
    private final String title;
    private final String author;

    // Конструктор инициализирует поля книги
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    // Геттеры для доступа к полям
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }
}



/*
public class Solution {
    public static void main(String[] args) {
        // Создаем дженерик-коллекцию для хранения книг (каталог)
        ArrayList<Book> catalog = new ArrayList<>();

        // Добавляем две разные книги с разными названиями и авторами
        catalog.add(new Book("Чистый код", "Роберт Мартин"));
        catalog.add(new Book("Эффективная Java", "Джошуа Блох"));

        // Перебираем каталог и выводим название и автора каждой книги
        for (Book book : catalog) {
            System.out.println(book.getTitle() + " - " + book.getAuthor());
        }
    }
}

 */