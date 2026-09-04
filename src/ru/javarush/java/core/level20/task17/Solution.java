package ru.javarush.java.core.level20.task17;
/*
Гибкая Система Журналирования: Консоль или Файл

Представьте, что вы разрабатываете критически важное приложение, и вам нужна система журналирования (логирования) событий. Иногда сообщения должны появляться мгновенно в консоли для отладки, а иногда — сохраняться в файл для последующего анализа. Вы хотите, чтобы ваш код мог легко переключаться между этими режимами.
Сначала определите универсальный "контракт журналиста" — интерфейс Logger (Журналист) с одним методом void log(String message).
Затем создайте два класса, каждый из которых будет по-своему выполнять этот контракт: Один класс, ConsoleLogger, должен просто выводить полученное сообщение прямо в консоль.
Другой класс, FileLogger, должен имитировать запись в файл, выводя на экран сообщение: "Лог записан в файл: " и затем само сообщение.
В вашей основной программе создайте объекты обоих типов логгеров и вызовите их метод log() с одинаковым "Тестовым сообщением". Вы должны увидеть два разных вывода, демонстрирующих гибкость вашей системы журналирования:

Тестовое сообщение
Лог записан в файл: Тестовое сообщение
Требования:
•	Необходимо создать интерфейс с именем Logger, содержащий метод void log(String message).
•	Необходимо создать класс ConsoleLogger, реализующий интерфейс Logger, и реализовать метод log так, чтобы он выводил переданное сообщение в консоль без изменений.
•	Необходимо создать класс FileLogger, реализующий интерфейс Logger, и реализовать метод log так, чтобы он выводил в консоль строку "Лог записан в файл: " и затем само сообщение.
•	В основной программе необходимо создать объекты обоих классов (ConsoleLogger и FileLogger) и вызвать их метод log с одинаковым тестовым сообщением.
•	После вызова метода log для каждого объекта в консоли должны появиться две разные строки: одна — просто сообщение, вторая — сообщение с префиксом "Лог записан в файл: ".

public class Solution {
    public static void main(String[] args) {
        // Демонстрация гибкости: две реализации одного интерфейса
        Logger consoleLogger = new ConsoleLogger();
        Logger fileLogger = new FileLogger();

        String testMessage = "Тестовое сообщение";

        // Оба вызываем одинаково, но поведение разное
        consoleLogger.log(testMessage);              // Выведет: Тестовое сообщение
        fileLogger.log(testMessage);                 // Выведет: Лог записан в файл: Тестовое сообщение
    }
}

 */
public class Solution {
    public static void main(String[] args) {
        // Демонстрация гибкости: две реализации одного интерфейса
        Logger consoleLogger = new ConsoleLogger();
        Logger fileLogger = new FileLogger();

        String testMessage = "Тестовое сообщение";

        // Оба вызываем одинаково, но поведение разное
        consoleLogger.log(testMessage);              // Выведет: Тестовое сообщение
        fileLogger.log(testMessage);                 // Выведет: Лог записан в файл: Тестовое сообщение
    }
}

interface Logger {
    void log(String message);
}

class ConsoleLogger implements Logger {
    String message;
    @Override
    public void log(String message) {
        this.message = message;
        System.out.println(message);
    }
}

class FileLogger implements Logger {
    String message;
    @Override
    public void log(String message) {
        this.message = message;
        System.out.println("Лог записан в файл: "+message);
    }
}

/*
// Контракт "журналиста": любой логгер должен уметь выводить сообщение
interface Logger {
    void log(String message);
}

// Реализация 1: печатаем сообщение как есть в консоль
class ConsoleLogger implements Logger {
    @Override
    public void log(String message) {
        System.out.println(message);
    }
}

// Реализация 2: имитируем запись в файл, добавляя префикс
class FileLogger implements Logger {
    @Override
    public void log(String message) {
        System.out.println("Лог записан в файл: " + message);
    }
}

public class Solution {
    public static void main(String[] args) {
        // Демонстрация гибкости: две реализации одного интерфейса
        Logger consoleLogger = new ConsoleLogger();
        Logger fileLogger = new FileLogger();

        String testMessage = "Тестовое сообщение";

        // Оба вызываем одинаково, но поведение разное
        consoleLogger.log(testMessage);              // Выведет: Тестовое сообщение
        fileLogger.log(testMessage);                 // Выведет: Лог записан в файл: Тестовое сообщение
    }
}
 */