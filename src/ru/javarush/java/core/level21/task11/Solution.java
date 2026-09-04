package ru.javarush.java.core.level21.task11;
/*
Система двойных уведомлений 🔔🔔

Вы разрабатываете систему уведомлений, которая иногда должна отправлять одно и то же сообщение дважды для привлечения внимания пользователя. У вас есть базовый способ отправки сообщения, но вы хотите предусмотреть удобную функцию "удвоения" отправки прямо в контракте вашей системы.
Определите интерфейс Printer с абстрактным методом print(String message). Добавьте default-метод printTwice(String message), который будет использовать print(message) для вывода одного и того же сообщения два раза. Затем создайте класс ConsolePrinter, который будет конкретной реализацией Printer и будет просто выводить переданное сообщение в консоль. В основной программе создайте объект ConsolePrinter и вызовите его метод printTwice("Java"), чтобы увидеть, как сообщение дублируется.

Требования:
•	Необходимо определить интерфейс с именем Printer.
•	В интерфейсе Printer должен быть объявлен абстрактный метод print, принимающий один параметр типа String.
•	В интерфейсе Printer должен быть реализован default-метод с именем printTwice, который принимает один параметр типа String.
•	Метод printTwice должен дважды вызывать метод print с переданным сообщением.
•	Должен быть создан класс ConsolePrinter, реализующий интерфейс Printer.
•	В классе ConsolePrinter метод print должен выводить переданное сообщение в консоль.
•	В основной программе необходимо создать объект класса ConsolePrinter и вызвать его метод printTwice с аргументом "Java".
•	После вызова printTwice("Java") в консоль должно быть выведено

public class Solution {
    public static void main(String[] args) {
        // Создаем конкретную реализацию интерфейса Printer
        ConsolePrinter printer = new ConsolePrinter();

        // Вызываем default-метод интерфейса, который печатает сообщение дважды
        printer.printTwice("Java");
    }
}

 */
public class Solution {
    public static void main(String[] args) {
        // Создаем конкретную реализацию интерфейса Printer
        ConsolePrinter printer = new ConsolePrinter();

        // Вызываем default-метод интерфейса, который печатает сообщение дважды
        printer.printTwice("Java");
    }
}

interface Printer {
    void print(String message);

    default void printTwice(String message) {
        print(message);
        print(message);
    }
}

class ConsolePrinter implements Printer {
    @Override
    public void print(String message) {
        System.out.println(message);
    }
}

/*
public class Solution {
    public static void main(String[] args) {
        // Создаем конкретную реализацию интерфейса Printer
        ConsolePrinter printer = new ConsolePrinter();

        // Вызываем default-метод интерфейса, который печатает сообщение дважды
        printer.printTwice("Java");
    }
}

// Контракт для печати сообщений
interface Printer {
    // Абстрактный метод: конкретные классы определяют, как именно печатать
    void print(String message);

    // Default-метод: повторно использует абстрактный метод print
    default void printTwice(String message) {
        print(message);
        print(message);
    }
}

// Конкретная реализация, печатает сообщения в консоль
class ConsolePrinter implements Printer {
    @Override
    public void print(String message) {
        // Простая реализация: вывод в стандартный поток
        System.out.println(message);
    }
}
 */