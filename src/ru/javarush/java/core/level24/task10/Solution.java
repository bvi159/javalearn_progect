package ru.javarush.java.core.level24.task10;
/*
Путь к ошибке: Цепочка сбоев в системе отчётности

Представьте, что вы разрабатываете сложную систему отчётности, где данные проходят через несколько этапов обработки. Если на одном из этапов что-то идёт не так, это может вызвать цепную реакцию ошибок, но вам важно понять, с чего всё началось.
Ваша задача — создать три метода, каждый из которых представляет собой этап обработки данных:
Метод prepareSourceData: он должен имитировать сбой на самом первом этапе, например, когда "файл с исходными данными не найден". Пусть этот метод "выбрасывает" IOException с сообщением "Исходный файл не найден".
Метод processRawData: этот метод будет вызывать prepareSourceData. Он должен быть готов "перехватить" IOException, если prepareSourceData не справился. После перехвата processRawData должен создать и "выбросить" новое, более общее исключение, которое вы назовете DataLoadingError, с сообщением "Ошибка загрузки данных". Крайне важно, чтобы при выбрасывании DataLoadingError вы указали оригинальное IOException как "первопричину" (cause).
Метод generateFinalReport: этот метод будет вызывать processRawData. Он, в свою очередь, должен быть готов "перехватить" DataLoadingError.
Наконец, в главной части вашей программы (методе main) вызовите generateFinalReport в блоке try-catch. Если generateFinalReport "выбросит" DataLoadingError, перехватите его и выведите на экран не только сообщение самого DataLoadingError, но и сообщение его "первопричины" (то есть, сообщение из оригинального IOException). Таким образом, вы сможете проследить весь путь "падения" и выявить корень всех бед.

Требования:
•	В программе должно быть объявлено собственное исключение с именем DataLoadingError, расширяющее подходящий базовый класс исключений.
•	Метод prepareSourceData должен выбрасывать исключение IOException с сообщением "Исходный файл не найден".
•	Метод processRawData должен вызывать prepareSourceData и перехватывать возможное IOException.
•	В случае перехвата IOException в processRawData должно быть выброшено новое исключение DataLoadingError с сообщением "Ошибка загрузки данных", при этом оригинальное IOException должно быть передано как причина (cause) через конструктор.
•	Метод generateFinalReport должен вызывать processRawData и быть готовым перехватить исключение DataLoadingError.
•	В методе main необходимо вызвать generateFinalReport в блоке try-catch, перехватить DataLoadingError и вывести на экран сообщение из DataLoadingError и сообщение его "первопричины" (cause).
•	При перехвате DataLoadingError в main должно быть выведено сообщение этого исключения и сообщение из его причины (IOException "Исходный файл не найден").

public class Solution {

    // Этап 1: имитация сбоя при подготовке исходных данных
    public static void prepareSourceData() throws IOException {
        // Специально "падаем" с IOException с нужным сообщением

    }

    // Этап 2: загрузка/обработка сырых данных
    public static void processRawData() throws DataLoadingError {

    }

    // Этап 3: генерация итогового отчёта
    public static void generateFinalReport() throws DataLoadingError {

    }

    public static void main(String[] args) {
        try {
            generateFinalReport();
        } catch (DataLoadingError e) {
            // Выводим сообщение нашего исключения
            System.out.println(e.getMessage());

            // И сообщение первопричины (IOException)
            Throwable cause = e.getCause();
            if (cause != null) {
                System.out.println(cause.getMessage());
            }
        }
    }
}

// Пользовательское исключение для обобщённой ошибки загрузки данных
class DataLoadingError extends Exception {
    public DataLoadingError(String message) {
        super(message);
    }

    public DataLoadingError(String message, Throwable cause) {
        super(message, cause);
    }
}

 */

import java.io.IOException;

public class Solution {

    // Этап 1: имитация сбоя при подготовке исходных данных
    public static void prepareSourceData() throws IOException {
        // Специально "падаем" с IOException с нужным сообщением
//        Throwable lostFile = new IOException("Исходный файл не найден");
//        throws lostFile
//        throw new IOException() = (Throwable)lostFile;*/
        throw new IOException("Исходный файл не найден");
    }

    // Этап 2: загрузка/обработка сырых данных
    public static void processRawData() throws DataLoadingError {
        try {
            prepareSourceData();
        } catch (IOException e) {
            throw new DataLoadingError("Ошибка загрузки данных", e);
        }
    }


    // Этап 3: генерация итогового отчёта
    public static void generateFinalReport() throws DataLoadingError {
        try {
            processRawData();
        } catch (DataLoadingError e) {
            throw e;
        }
    }

    public static void main(String[] args) {
        try {
            generateFinalReport();
        } catch (DataLoadingError e) {
            // Выводим сообщение нашего исключения
            System.out.println(e.getMessage());

            // И сообщение первопричины (IOException)
            Throwable cause = e.getCause();
            if (cause != null) {
                System.out.println(cause.getMessage());
            }
        }
    }
}

// Пользовательское исключение для обобщённой ошибки загрузки данных
class DataLoadingError extends Exception {
    public DataLoadingError(String message) {
        super(message);
    }

    public DataLoadingError(String message, Throwable cause) {
        super(message, cause);
    }
}

/*
public class Solution {

    // Этап 1: имитация сбоя при подготовке исходных данных
    public static void prepareSourceData() throws IOException {
        // Специально "падаем" с IOException с нужным сообщением
        throw new IOException("Исходный файл не найден");
    }

    // Этап 2: загрузка/обработка сырых данных
    public static void processRawData() throws DataLoadingError {
        try {
            prepareSourceData(); // вызываем предыдущий этап
        } catch (IOException e) {
            // Перехватываем первопричину и заворачиваем её в наше исключение
            throw new DataLoadingError("Ошибка загрузки данных", e);
        }
    }

    // Этап 3: генерация итогового отчёта
    public static void generateFinalReport() throws DataLoadingError {
        try {
            processRawData(); // вызываем предыдущий этап
            // Здесь могла бы быть логика генерации отчёта
        } catch (DataLoadingError e) {
            // Метод "готов перехватить" исключение, но пробрасывает его дальше,
            // чтобы main смог показать цепочку причин
            throw e;
        }
    }

    public static void main(String[] args) {
        try {
            generateFinalReport();
        } catch (DataLoadingError e) {
            // Выводим сообщение нашего исключения
            System.out.println(e.getMessage());

            // И сообщение первопричины (IOException)
            Throwable cause = e.getCause();
            if (cause != null) {
                System.out.println(cause.getMessage());
            }
        }
    }
}

// Пользовательское исключение для обобщённой ошибки загрузки данных
class DataLoadingError extends Exception {
    public DataLoadingError(String message) {
        super(message);
    }

    public DataLoadingError(String message, Throwable cause) {
        super(message, cause);
    }
}
 */