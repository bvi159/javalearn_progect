package ru.javarush.java.core.level21.task14;
/*
Универсальная система приветствий 🌐

Вы создаёте модульную систему, где различные компоненты (например, консоль, графический интерфейс, или сетевое устройство) могут выводить сообщения. Вы хотите, чтобы для всех этих компонентов была единая, универсальная функция для вывода стандартного приветствия.
Определите интерфейс Printer с одним абстрактным методом void print (String text), который предназначен для вывода любого текста. В этом же интерфейсе создайте static-метод printHello, который будет принимать любой объект, реализующий Printer, и вызывать его метод print со строкой "Hello, world!".
Затем создайте класс ConsolePrinter, который просто реализует Printer, выводя текст в консоль. В основной программе создайте объект ConsolePrinter и используйте Printer.printHello для вывода приветствия через ваш объект, демонстрируя универсальность статического метода.

Требования:
•	Необходимо создать интерфейс Printer с одним абстрактным методом void print(String text).
•	В интерфейсе Printer должен быть определён статический метод printHello, принимающий объект Printer и вызывающий у него метод print со строкой "Hello, world!".
•	Должен быть создан класс ConsolePrinter, который реализует интерфейс Printer и выводит переданный текст в консоль.
•	В основной программе необходимо создать объект ConsolePrinter и вызвать Printer.printHello, передав этот объект, чтобы вывести "Hello, world!" на консоль.
•	Статический метод printHello должен работать с любым объектом, реализующим интерфейс Printer, а не только с ConsolePrinter.

public class Solution {
    public static void main(String[] args) {
        // Создаем объект ConsolePrinter
        Printer printer = new ConsolePrinter();

        // Используем статический метод интерфейса для вывода приветствия
        Printer.printHello(printer);
    }
}
 */

public class Solution {
    public static void main(String[] args) {
        // Создаем объект ConsolePrinter
        Printer printer = new ConsolePrinter();

        // Используем статический метод интерфейса для вывода приветствия
        Printer.printHello(printer);
    }
}

@FunctionalInterface
interface Printer {
    void print(String text);

    static void printHello(Printer prn) {
        prn.print("Hello, world!");
    }
}

class ConsolePrinter implements Printer {
    @Override
    public void print(String text) {
        System.out.println(text);
    }
}

/*
// Функциональный интерфейс с одним абстрактным методом
@FunctionalInterface
interface Printer {
    void print(String text);

    // Статический метод интерфейса: принимает любой Printer
    // и выводит стандартное приветствие через его реализацию print
    static void printHello(Printer printer) {
        printer.print("Hello, world!");
    }
}

// Простая реализация Printer, печатающая текст в консоль
class ConsolePrinter implements Printer {
    @Override
    public void print(String text) {
        System.out.println(text);
    }
}

public class Solution {
    public static void main(String[] args) {
        // Создаем объект ConsolePrinter
        Printer printer = new ConsolePrinter();

        // Используем статический метод интерфейса для вывода приветствия
        Printer.printHello(printer);
    }
}

 */