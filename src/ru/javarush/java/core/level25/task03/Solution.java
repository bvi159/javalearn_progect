package ru.javarush.java.core.level25.task03;

/*
Мудрость Древней Библиотеки: Доступ к Архиву 🏛️

Представьте, что вы главный архитектор цифровой библиотеки, где каждая секция – это отдельный модуль. Вы хотите создать главную секцию Library (внешний класс), а внутри неё – особую, надёжную секцию Archive (статический вложенный класс), которая содержит древние свитки с мудростью. В Archive должен быть статический метод readParchment(), который просто выводит на экран тайное сообщение, например, "Древний свиток разгадан!".

Ваша задача – показать, как можно получить доступ к этой мудрости, не активируя всю библиотеку целиком. То есть, прямо из главного метода main вызовите readParchment() из Archive, не создавая при этом ни единого объекта Library. Это как прочитать книгу из архива, не заходя в само здание!

Требования:
•	Должен быть создан внешний (top-level) класс с именем Library.
•	Внутри класса Library необходимо объявить статический вложенный класс с именем Archive.
•	В классе Archive должен быть реализован статический метод с именем readParchment.
•	Метод readParchment должен выводить на экран строку "Древний свиток разгадан!".
•	Метод readParchment должен быть вызван из метода main напрямую по полному имени (Library.Archive.readParchment()), без создания экземпляра класса Library.

public class Solution {
    public static void main(String[] args) {
        // Вызываем статический метод вложенного класса по полному имени,
        // не создавая объект внешнего класса Library

    }
}

 */

public class Solution {
    public static void main(String[] args) {
        // Вызываем статический метод вложенного класса по полному имени,
        // не создавая объект внешнего класса Library
        Library.Archive.readParchment();

    }
}

class Library {
    static class Archive {
        public static void readParchment() {
            System.out.println("Древний свиток разгадан!");
        }
    }
}


/*
public class Solution {
    public static void main(String[] args) {
        // Вызываем статический метод вложенного класса по полному имени,
        // не создавая объект внешнего класса Library
        Library.Archive.readParchment();
    }
}

// Внешний (top-level) класс Library
class Library {
    // Статический вложенный класс Archive — не требует экземпляра Library
    static class Archive {
        // Статический метод, выводящий секретное сообщение
        static void readParchment() {
            System.out.println("Древний свиток разгадан!");
        }
    }
}
 */