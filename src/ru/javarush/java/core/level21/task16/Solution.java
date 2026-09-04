package ru.javarush.java.core.level21.task16;
/*
Централизованная система логирования 🛡️

Вы отвечаете за создание надёжной системы логирования для критически важного приложения. Ваша задача — обеспечить, чтобы все сообщения, будь то информационные или сообщения об ошибках, форматировались единообразно. Для этого вы хотите использовать внутренний, скрытый от прямого использования, метод форматирования.
Создайте интерфейс Logger. В нём определите два static-метода: info(String message) и error(String message). Оба эти метода должны использовать внутренний, private static-метод format(String level, String message), который будет возвращать отформатированную строку в виде "[УРОВЕНЬ] сообщение". Методы info и error должны выводить сообщения, используя этот приватный формат, с соответствующими префиксами "[INFO]" или "[ERROR]".
В основной программе вызовите Logger.info("Start") и Logger.error("Failure") и выведите результаты, чтобы показать, как работает ваша унифицированная система логирования.

Требования:
•	В программе должен быть объявлен интерфейс с именем Logger.
•	В интерфейсе Logger должны быть определены два статических метода: info(String message) и error(String message).
•	В интерфейсе Logger должен быть реализован приватный статический метод format(String level, String message), который возвращает строку в формате "[УРОВЕНЬ] сообщение".
•	Методы info и error должны использовать приватный статический метод format для форматирования своих сообщений.
•	Метод info должен выводить сообщение с префиксом "[INFO]", а метод error — с префиксом "[ERROR]".
•	В основной программе должны быть вызваны Logger.info("Start") и Logger.error("Failure") для демонстрации работы системы логирования.

public class Solution {
    public static void main(String[] args) {
        // Демонстрация работы: оба вызова печатают сообщения в едином формате
        Logger.info("Start");
        Logger.error("Failure");
    }
}

 */
public class Solution {
    public static void main(String[] args) {
        // Демонстрация работы: оба вызова печатают сообщения в едином формате
        Logger.info("Start");
        Logger.error("Failure");
    }
}

interface Logger {
    static void info(String message) {
        System.out.println(format("INFO", message));
    }

    static void error(String message) {
        System.out.println(format("ERROR", message));
    }

    private static String format(String level, String message) {
        return "["+level+"] "+message;
    }
}

/*
// Интерфейс с единой точкой форматирования и вывода логов
interface Logger {
    // Печатает информационное сообщение с единым форматом
    static void info(String message) {
        // Используем приватный метод форматирования и выводим результат
        System.out.println(format("INFO", message));
    }

    // Печатает сообщение об ошибке с единым форматом
    static void error(String message) {
        // Используем приватный метод форматирования и выводим результат
        System.out.println(format("ERROR", message));
    }

    // Приватный статический метод скрыт от прямого использования извне
    // Возвращает строку в виде "[УРОВЕНЬ] сообщение"
    private static String format(String level, String message) {
        return "[" + level + "] " + message;
    }
}

public class Solution {
    public static void main(String[] args) {
        // Демонстрация работы: оба вызова печатают сообщения в едином формате
        Logger.info("Start");
        Logger.error("Failure");
    }
}
 */