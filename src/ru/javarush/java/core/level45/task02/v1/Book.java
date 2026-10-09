package ru.javarush.java.core.level45.task02.v1;

import java.io.Serializable;

public class Book implements Serializable {
    private final static long serialVersionUID = 1L;
    private final String bookTitle;
    private final String bookAuthor;

    public Book(String title, String author) {
        this.bookTitle = title;
        this.bookAuthor = author;
    }

}
