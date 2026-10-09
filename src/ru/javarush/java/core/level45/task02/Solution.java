package ru.javarush.java.core.level45.task02;
/*
Расширение цифровой библиотеки и проверка совместимости
Представьте, что вы — хранитель огромной цифровой библиотеки, и ваша система умеет сохранять информацию о книгах в файлы. На первом этапе, когда система только запускалась, для каждой книги вы сохраняли только её название и автора. Прошло время, библиотека выросла, и в карточку книги понадобилось добавить год издания. Вот только тысячи файлов со старой структурой уже лежат на диске — и их нужно продолжать читать.

Обе версии класса Book должны существовать одновременно, поэтому разложите их по пакетам. В пакете v1 объявите класс Book с полями bookTitle и bookAuthor типа String, сделайте его сериализуемым и задайте статическое финальное поле serialVersionUID со значением 1L. В пакете v2 объявите класс с тем же именем Book: те же два поля плюс новое поле publicationYear типа int, и — это ключевой момент — то же самое значение serialVersionUID, равное 1L.

В методе main сначала создайте объект Book первой версии и сериализуйте его в файл books.bin — это имитация старой базы. Затем прочитайте этот же файл, но уже как объект Book второй версии.

Прямо так прочитать не получится: в файле записано полное имя класса первой версии, и обычный ObjectInputStream вернёт объект из пакета v1. Поэтому объявите наследника ObjectInputStream и переопределите в нём метод resolveClass: если в потоке встретился класс первой версии — верните класс второй версии. Такая подмена работает только потому, что простое имя класса у обеих версий одинаковое — при десериализации JDK сверяет имя класса без учёта пакета. Если бы вы назвали классы BookV1 и BookV2, подменить один на другой было бы нельзя.

В конце выведите на экран значения всех трёх полей восстановленного объекта. Вы увидите, что bookTitle и bookAuthor восстановились из файла, а publicationYear, которого в старых данных не было, получил значение по умолчанию для типа int:

bookTitle: Тайна старого маяка
bookAuthor: Мартин Хейл
publicationYear: 0
Требования:
•	В пакете v1 должен быть объявлен сериализуемый класс Book с полями bookTitle и bookAuthor типа String и статическим финальным полем serialVersionUID со значением 1L.
•	В пакете v2 должен быть объявлен сериализуемый класс с тем же именем Book, содержащий поля bookTitle, bookAuthor типа String и новое поле publicationYear типа int.
•	Значение serialVersionUID во второй версии класса Book должно остаться равным 1L, то есть таким же, как в первой версии.
•	Обе версии должны называться именно Book и отличаться только пакетом — от этого зависит возможность подмены класса при десериализации.
•	В методе main должен быть создан объект Book первой версии и сериализован в файл books.bin.
•	В программе должен быть объявлен наследник ObjectInputStream с переопределённым методом resolveClass, который подменяет класс Book первой версии на класс Book второй версии.
•	Файл books.bin должен быть прочитан через этот наследник ObjectInputStream, а полученный объект приведён к типу Book второй версии.
•	После десериализации значения полей bookTitle и bookAuthor должны быть восстановлены из файла.
•	После десериализации поле publicationYear должно иметь значение по умолчанию для типа int, то есть 0, так как в старых данных этого поля не было.
•	Значения всех трёх полей bookTitle, bookAuthor и publicationYear должны быть выведены на экран.

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamClass;

public class Solution {
    private static final String FILE_NAME = "books.bin";

    public static void main(String[] args) throws Exception {
        // Создать объект книги первой версии и сохранить его в файл


        // Прочитать тот же файл классом второй версии,
        // подменив класс с помощью собственного потока


        // Вывести название, автора и год издания восстановленного объекта

    }
}

// Здесь объявить наследник ObjectInputStream, который подменяет
// класс первой версии на класс второй версии

 */

import ru.javarush.java.core.level45.task02.v1.Book;

import java.io.*;

public class Solution {
    private static final String FILE_NAME = "books.bin";

    public static void main(String[] args) throws Exception {
        // Создать объект книги первой версии и сохранить его в файл
        ru.javarush.java.core.level45.task02.v1.Book bookV1 = new Book("King Artur", "Unknown");
        ObjectOutputStream oos1 = new ObjectOutputStream(new FileOutputStream(FILE_NAME));
        oos1.writeObject(bookV1);
        oos1.close();

        // Прочитать тот же файл классом второй версии,
        // подменив класс с помощью собственного потока
        ru.javarush.java.core.level45.task02.v2.Book bookV2;
        ObjectInputStreamV2 ois2 = new ObjectInputStreamV2(new FileInputStream(FILE_NAME));
        bookV2 = (ru.javarush.java.core.level45.task02.v2.Book) ois2.readObject();

        // Вывести название, автора и год издания восстановленного объекта
        System.out.println(bookV2.getBookTitle());
        System.out.println(bookV2.getBookAuthor());
        System.out.println(bookV2.getPublicationYear());

    }
}

// Здесь объявить наследник ObjectInputStream, который подменяет
// класс первой версии на класс второй версии
class ObjectInputStreamV2 extends ObjectInputStream {
    public ObjectInputStreamV2(InputStream in) throws IOException {
        super(in);
    }

    @Override
    protected Class<?> resolveClass(ObjectStreamClass desc) throws IOException, ClassNotFoundException {
        // desc = Class.forName("ru.javarush.java.core.level45.task02.v1.Book");
        // подменяем старый класс на новый
        if ("ru.javarush.java.core.level45.task02.v1.Book".equals(desc.getName())) {
            return Class.forName("ru.javarush.java.core.level45.task02.v2.Book");
        }
        return super.resolveClass(desc);
    }
}



/*
public class Solution {
    private static final String FILE_NAME = "books.bin";

    public static void main(String[] args) throws Exception {
        // 1) Старая система: сохраняем книгу, у которой ещё нет года издания.
        //    Полное имя класса пишется целиком — импортировать два класса Book сразу нельзя.
        ru.javarush.java.core.level45.task02.v1.Book oldBook =
                new ru.javarush.java.core.level45.task02.v1.Book("Тайна старого маяка", "Мартин Хейл");

        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            out.writeObject(oldBook);
        }

        // 2) Новая система: тот же файл читаем уже классом второй версии.
        //    Подменой класса занимается поток VersionMappingObjectInputStream.
        Book restored;
        try (ObjectInputStream in = new VersionMappingObjectInputStream(new FileInputStream(FILE_NAME))) {
            restored = (Book) in.readObject();
        }

        // 3) Старые поля восстановились из файла, а нового в файле не было —
        //    оно получило значение по умолчанию для int, то есть 0.
        System.out.println("bookTitle: " + restored.bookTitle);
        System.out.println("bookAuthor: " + restored.bookAuthor);
        System.out.println("publicationYear: " + restored.publicationYear);
    }
}

// В файле записано имя класса первой версии, поэтому обычный ObjectInputStream вернул бы v1.Book.
// Этот поток подменяет его на v2.Book. Подмена возможна только потому, что простое имя класса
// у обеих версий одинаковое (Book): при десериализации JDK сверяет имя класса без учёта пакета.
class VersionMappingObjectInputStream extends ObjectInputStream {
    public VersionMappingObjectInputStream(InputStream in) throws IOException {
        super(in);
    }

    @Override
    protected Class<?> resolveClass(ObjectStreamClass desc) throws IOException, ClassNotFoundException {
        if (desc.getName().equals(ru.javarush.java.core.level45.task02.v1.Book.class.getName())) {
            return Book.class;
        }
        return super.resolveClass(desc);
    }
}

 */