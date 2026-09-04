package ru.javarush.java.core.level14.task18;
/*
Стандартизация новых книг в издательстве

Вы работаете в издательстве, и чтобы избежать путаницы, вы решили, что каждая новая книга, поступающая в систему, должна иметь базовые, стандартные параметры, даже если они пока не окончательны.
Ваша задача — создать "шаблон" для книги, назвав его Book, с полями для названия (String bookTitle) и количества страниц (int pageCount).
При объявлении этих полей прямо в шаблоне присвойте им стандартные значения: название — "Без названия", а количество страниц — 100.
Затем, в вашем главном сценарии (main методе), "создайте" одну такую книгу, назвав её standardBook, и убедитесь, что эти стандартные значения сразу же присвоены, выведя их на экран.

Требования:
•	Должен быть создан класс с именем Book.
•	В классе Book должны быть объявлены два поля: String bookTitle и int pageCount, и им должны быть присвоены значения "Без названия" и 100 соответственно прямо при объявлении.
•	В методе main должен быть создан объект класса Book с именем standardBook.
•	После создания объекта standardBook значения его полей bookTitle и pageCount должны быть выведены на экран - им должны быть присвоены стандартные значения.
Input data
MEDIUM
1

public class Solution {
    public static void main(String[] args) {
        // Создаем книгу со стандартными значениями полей
        Book standardBook = new Book();

        // Выводим стандартные значения на экран
        System.out.println(standardBook.bookTitle);
        System.out.println(standardBook.pageCount);
    }
}

 */
public class Solution {
    public static void main(String[] args) {
        // Создаем книгу со стандартными значениями полей
        Book standardBook = new Book();

        // Выводим стандартные значения на экран
        System.out.println(standardBook.bookTitle);
        System.out.println(standardBook.pageCount);
    }
}

// "Шаблон" книги с начальными значениями полей прямо при объявлении
class Book {
    String bookTitle = "Без названия";
    int pageCount = 100;

}