package ru.javarush.java.core.level11.task13;
/*
Модуль доступа к секретным документам 📁
Вы разрабатываете модуль для системы управления секретными документами, который отвечает за их открытие. Ваша задача – создать метод, который "обещает" сообщить о проблеме, если запрошенный файл не будет найден, но сам при этом не будет пытаться её решить, оставляя эту задачу другим частям системы.

Создайте метод public static void accessSecretDocument(String documentPath). Этот метод должен объявить, что он throws FileNotFoundException.

Внутри метода просто попытайтесь создать объект FileReader для указанного documentPath. Не добавляйте никаких try-catch блоков здесь; метод лишь указывает, что потенциальная проблема может возникнуть, и ответственность за её обработку лежит на том, кто этот метод вызовет.

Требования:
•	Метод accessSecretDocument должен быть объявлен с модификатором public static и принимать один параметр типа String с именем documentPath, а также объявлять проброс исключения FileNotFoundException с помощью ключевого слова throws.
•	Внутри метода accessSecretDocument необходимо создать объект FileReader, используя переданный путь documentPath.
•	В методе accessSecretDocument не должно быть try-catch блоков для обработки FileNotFoundException или других исключений.
•	Метод accessSecretDocument должен явно объявлять в сигнатуре, что он может выбросить исключение FileNotFoundException.
•	Сигнатура метода должна быть следующей: public static void accessSecretDocument(String documentPath) throws FileNotFoundException.

 */
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Solution {

    // Метод объявляет проброс исключения: обработка ошибки перекладывается на вызывающий код
    public static void accessSecretDocument(String documentPath) throws FileNotFoundException {
        FileReader myFile = new FileReader(documentPath);
    }

        // Пытаемся открыть файл по указанному пути.
        // Если файл не найден, конструктор FileReader выбросит FileNotFoundException.



    // Небольшая демонстрация использования
    public static void main(String[] args) throws FileNotFoundException {
        accessSecretDocument("c:\\noname.txt");

    }
}
/*
Ихнее решение
public class Solution {

    // Метод объявляет проброс исключения: обработка ошибки перекладывается на вызывающий код
    public static void accessSecretDocument(String documentPath) throws FileNotFoundException {
        // Пытаемся открыть файл по указанному пути.
        // Если файл не найден, конструктор FileReader выбросит FileNotFoundException.
        FileReader reader = new FileReader(documentPath);
    }

    // Небольшая демонстрация использования (не обязательна для проверки)
    public static void main(String[] args) throws FileNotFoundException {
        // Если передан путь аргументом командной строки — попробуем открыть его
        if (args.length > 0) {
            accessSecretDocument(args[0]);
        }
        // Если аргументов нет — ничего не делаем
    }
}
 */