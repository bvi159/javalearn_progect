package ru.javarush.java.core.level16.task16;
/*

Анализатор текстовых данных: краткий отчет по имени 📊

Вы создаёте умный анализатор текстовых данных, который умеет обрабатывать имена. Когда вы передаёте имя для анализа, система должна сгенерировать краткий отчёт. Этот отчёт должен включать исходное имя, его версию в верхнем регистре и его длину. Вам понадобится временный, "локальный" компонент для создания такого отчёта.
В классе TextAnalyzer объявите метод generateNameReport(String customerName). Внутри этого метода объявите локальный класс с именем NameStatistics. У NameStatistics должно быть поле originalCustomerName (строка), метод printUpperCaseName(), который выводит имя в верхнем регистре, и метод printNameLength(), который выводит длину имени. Создайте объект NameStatistics, передав ему customerName. Затем последовательно вызовите оба его метода, чтобы на экране отобразились имя в верхнем регистре и его длина.

Требования:
•	В классе TextAnalyzer должен быть объявлен метод generateNameReport с параметром String customerName.
•	Внутри метода generateNameReport должен быть объявлен локальный класс с именем NameStatistics.
•	Локальный класс NameStatistics должен иметь конструктор, принимающий строку customerName и сохраняющий её в поле originalCustomerName.
•	В классе NameStatistics должно быть приватное или защищённое поле originalCustomerName типа String, в котором хранится исходное имя.
•	В классе NameStatistics должен быть метод printUpperCaseName, который выводит на экран значение originalCustomerName, преобразованное к верхнему регистру.
•	В классе NameStatistics должен быть метод printNameLength, который выводит на экран длину строки originalCustomerName.
•	Внутри метода generateNameReport должен быть создан объект класса NameStatistics, используя переданное имя customerName.
•	Внутри метода generateNameReport должны быть последовательно вызваны методы printUpperCaseName и printNameLength для созданного объекта NameStatistics.

public class TextAnalyzer {

    // Метод-обработчик имени: внутри объявляем локальный класс и используем его
    public void generateNameReport(String customerName) {
        // Локальный класс доступен только внутри этого метода


        // Создаем объект локального класса и последовательно вызываем методы отчета

    }

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String name = console.nextLine();          // читаем имя с консоли
        new TextAnalyzer().generateNameReport(name);
    }
}

 */

import java.util.Scanner;

public class TextAnalyzer {

    // Метод-обработчик имени: внутри объявляем локальный класс и используем его
    public void generateNameReport(String customerName) {
        // Локальный класс доступен только внутри этого метода
        class NameStatistics {
            private String originalCustomerName;

            NameStatistics() {
                this.originalCustomerName = customerName;
            }

            void printUpperCaseName() {
                if (originalCustomerName != null) {
                    System.out.println(originalCustomerName.toUpperCase());
                }
            }

            void printNameLength() {
                if (originalCustomerName != null) {
                    System.out.println(originalCustomerName.length());
                }
            }
        }
        // Создаем объект локального класса и последовательно вызываем методы отчета
        NameStatistics someName = new NameStatistics();
        someName.printUpperCaseName();
        someName.printNameLength();

    }

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String name = console.nextLine();          // читаем имя с консоли
        new TextAnalyzer().generateNameReport(name);
    }
}

/*
public class TextAnalyzer {

    // Метод-обработчик имени: внутри объявляем локальный класс и используем его
    public void generateNameReport(String customerName) {
        // Локальный класс доступен только внутри этого метода
        class NameStatistics {
            // Храним исходное имя
            private final String originalCustomerName;

            // Конструктор принимает имя и сохраняет его в поле
            NameStatistics(String customerName) {
                this.originalCustomerName = customerName;
            }

            // Печать имени в верхнем регистре
            void printUpperCaseName() {
                System.out.println(originalCustomerName.toUpperCase());
            }

            // Печать длины имени
            void printNameLength() {
                System.out.println(originalCustomerName.length());
            }
        }

        // Создаем объект локального класса и последовательно вызываем методы отчета
        NameStatistics stats = new NameStatistics(customerName);
        stats.printUpperCaseName();
        stats.printNameLength();
    }

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String name = console.nextLine();          // читаем имя с консоли
        new TextAnalyzer().generateNameReport(name);
    }
}
 */