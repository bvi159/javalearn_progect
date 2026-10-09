package ru.javarush.java.core.level45.task05;
/*
Эволюция каталога книг: что произойдёт с новыми полями?
Представьте, что вы управляете каталогом старинных книг, и каждая книга в вашей системе представлена простым классом Book. На начальном этапе этот класс был очень простым: он реализовывал интерфейс Serializable, чтобы книги можно было легко сохранять и восстанавливать, и содержал всего лишь одно поле — bookTitle типа String. Также, чтобы обеспечить контроль версий, у этого класса было статическое финальное поле serialVersionUID со значением 1L.

Теперь, спустя некоторое время, возникла необходимость улучшить ваш каталог. Вы хотите, чтобы для каждой книги сохранялась информация не только о её названии, но и об авторе. Поэтому вы решили добавить в класс Book новое поле bookAuthor типа String. При этом вы решили не менять значение serialVersionUID, чтобы сохранить совместимость со старыми сохранёнными данными.

Требования:
•	Класс Book должен реализовывать интерфейс Serializable для поддержки сериализации и десериализации объектов.
•	В классе Book должно быть объявлено поле bookTitle типа String.
•	В классе Book должно быть объявлено статическое финальное поле serialVersionUID со значением 1L.
•	В классе Book должно быть добавлено новое поле bookAuthor типа String.
•	После добавления поля bookAuthor значение поля serialVersionUID должно остаться равным 1L.
•	Класс Book после добавления нового поля должен корректно десериализовать объекты, сохранённые с предыдущей версией, где отсутствовало поле bookAuthor.
•	При десериализации старых объектов, в которых отсутствует поле bookAuthor, его значение должно быть установлено в null (значение по умолчанию для String).

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Solution {
    public static void main(String[] args) throws Exception {
        // Создаем объект новой версии (с полем author)
        Book original = new Book("Песнь о северном ветре", "Элиас Ворн");

        Path file = Paths.get("book.ser");

        // Запись объекта в файл (сериализация)
        try (ObjectOutputStream out = new ObjectOutputStream(Files.newOutputStream(file))) {
            out.writeObject(original);
        }

        // Чтение объекта из файла (десериализация)
        try (ObjectInputStream in = new ObjectInputStream(Files.newInputStream(file))) {
            Book restored = (Book) in.readObject();
            System.out.println(restored);
        }
    }
}

 */

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Solution {
    public static void main(String[] args) throws Exception {
        // Создаем объект новой версии (с полем author)
        Book original = new Book("Песнь о северном ветре", "Элиас Ворн");

        Path file = Paths.get("book.ser");

        // Запись объекта в файл (сериализация)
        try (ObjectOutputStream out = new ObjectOutputStream(Files.newOutputStream(file))) {
            out.writeObject(original);
        }

        // Чтение объекта из файла (десериализация)
        try (ObjectInputStream in = new ObjectInputStream(Files.newInputStream(file))) {
            Book restored = (Book) in.readObject();
            System.out.println(restored);
        }
    }
}

class Book implements Serializable {
    private final static long serialVersionUID = 1L;
    private final String bookTitle;
    private final String bookAuthor;

    Book(String title) {
        this.bookTitle = title;
        this.bookAuthor = null;
    }

    Book(String title, String author) {
        this.bookTitle = title;
        this.bookAuthor = author;
    }

    @Override
    public String toString() {
        return (bookTitle + " (" + bookAuthor + ")");
    }
}

/*
import java.io.Serializable;

/ **
 * Класс Book поддерживает бинарную сериализацию.
 * В первой версии у класса было только поле bookTitle и serialVersionUID = 1L.
 * Во второй версии добавили поле bookAuthor, при этом serialVersionUID оставили тем же (1L),
 * чтобы сохранить совместимость со старыми сериализованными данными.
 *
 * Важно:
 * - При десериализации старых объектов (записанных первой версией класса без поля bookAuthor)
 *   новое поле автоматически получит значение null (значение по умолчанию для String).
 *   Это стандартное поведение Java-сериализации, если serialVersionUID не менялся.
 * /
public class Book implements Serializable {
    // Не меняем UID: это ключ к обратной совместимости при добавлении/удалении полей
    private static final long serialVersionUID = 1L;

    // Было в первой версии класса
    public String bookTitle;

    // Новое поле, добавленное во второй версии
    public String bookAuthor;

    public Book() {
    }

    public Book(String bookTitle, String bookAuthor) {
        this.bookTitle = bookTitle;
        this.bookAuthor = bookAuthor;
    }

    @Override
    public String toString() {
        return "Book{title='" + bookTitle + "', author='" + bookAuthor + "'}";
    }
}
 */