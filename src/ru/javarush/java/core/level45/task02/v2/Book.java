package ru.javarush.java.core.level45.task02.v2;

import java.io.Serializable;

public class Book implements Serializable {
    private final static long serialVersionUID = 1L;
    private final String bookTitle;
    private final String bookAuthor;
    private final int publicationYear;

    public Book(String title, String author, int year) {
        this.bookTitle = title;
        this.bookAuthor = author;
        this.publicationYear = year;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

}
