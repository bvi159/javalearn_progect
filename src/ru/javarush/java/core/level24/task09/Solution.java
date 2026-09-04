package ru.javarush.java.core.level24.task09;
/*
Детектив данных: Выявление первопричины сбоя

Вы стали инженером по устранению неполадок в сложной системе анализа данных. Иногда система выдаёт общую ошибку обработки, но вы знаете, что часто бывает, что одна проблема влечёт за собой другую, и вам нужно найти «первопричину» сбоя.
Ваша задача — спроектировать собственное исключение, которое назовите DataProcessingFailure. Оно должно быть наследником обычного Exception. Реализуйте два способа создания этого исключения: первый конструктор пусть принимает только строку message (общее описание ошибки), а второй — строку message и дополнительный объект Throwable cause. Второй конструктор очень важен, так как он позволит вам «прикрепить» к вашей ошибке ту самую «первопричину».
Теперь продемонстрируйте, как это работает: создайте объект DataProcessingFailure, используя второй конструктор. В качестве общего сообщения укажите "Ошибка генерации отчёта", а в качестве «первопричины» (cause) передайте любое уже существующее исключение, например, new NullPointerException("данные отсутствуют!").
Наконец, чтобы доказать, что вы успешно «прикрепили» первопричину, выведите на экран результат вызова специального метода getCause() у созданного вами исключения. Вы должны увидеть именно ту «первопричину», которую указали.

Требования:
•	Необходимо создать собственный класс исключения с именем DataProcessingFailure.
•	Класс DataProcessingFailure должен быть наследником стандартного класса Exception.
•	Класс DataProcessingFailure должен содержать конструктор, принимающий только строку message.
•	Класс DataProcessingFailure должен содержать конструктор, принимающий строку message и объект Throwable cause.
•	В основной программе необходимо создать объект DataProcessingFailure, используя конструктор с двумя параметрами: сообщением "Ошибка генерации отчёта" и первопричиной new NullPointerException("данные отсутствуют!").
•	Необходимо вывести на экран результат вызова метода getCause() у созданного объекта DataProcessingFailure.

public class Solution {
    public static void main(String[] args) {
        // Создаем "первопричину" — уже существующее исключение
        Throwable rootCause = new NullPointerException("данные отсутствуют!");

        // Создаем наше исключение и "прикрепляем" к нему первопричину


        // Выводим на экран первопричину через getCause()
        // Ожидаем увидеть NullPointerException с тем же сообщением
        System.out.println(failure.getCause());
    }
}

 */

public class Solution {
    public static void main(String[] args) {
        // Создаем "первопричину" — уже существующее исключение
        Throwable rootCause = new NullPointerException("данные отсутствуют!");

        // Создаем наше исключение и "прикрепляем" к нему первопричину
        DataProcessingFailure failure = new DataProcessingFailure("Ошибка генерации отчёта", rootCause);


        // Выводим на экран первопричину через getCause()
        // Ожидаем увидеть NullPointerException с тем же сообщением
        System.out.println(failure.getCause());
        System.out.println(failure.getMessage());
    }
}

class DataProcessingFailure extends Exception {
    DataProcessingFailure(String message) {
        super(message);
    }

    DataProcessingFailure(String message, Throwable cause) {
        super(message, cause);
    }

}

/*
public class Solution {
    public static void main(String[] args) {
        // Создаем "первопричину" — уже существующее исключение
        Throwable rootCause = new NullPointerException("данные отсутствуют!");

        // Создаем наше исключение и "прикрепляем" к нему первопричину
        DataProcessingFailure failure = new DataProcessingFailure("Ошибка генерации отчёта", rootCause);

        // Выводим на экран первопричину через getCause()
        // Ожидаем увидеть NullPointerException с тем же сообщением
        System.out.println(failure.getCause());
    }
}

// Собственное исключение, наследуется от Exception
class DataProcessingFailure extends Exception {
    // Конструктор, принимающий только сообщение
    public DataProcessingFailure(String message) {
        super(message);
    }

    // Конструктор, принимающий сообщение и первопричину (cause)
    // Вызов super(message, cause) формирует цепочку исключений
    public DataProcessingFailure(String message, Throwable cause) {
        super(message, cause);
    }
}
 */