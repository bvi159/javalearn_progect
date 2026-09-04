package ru.javarush.java.core.level24.task03;
/*
Система оповещений: Проверяемые и непроверяемые угрозы

Представьте, что вы настраиваете систему оповещений для сложного программного комплекса.
Вам нужно различать, какие "угрозы" требуют немедленного обязательного реагирования (проверяемые),
а какие могут быть неожиданными, но необязательными для немедленной обработки (непроверяемые).
Создайте переменную с именем unexpectedGlitch и пусть она будет типа RuntimeException, которое
представляет собой своего рода "неожиданный сбой" во время работы программы. Затем создайте переменную
с именем missingConfigurationFile, которая будет типа FileNotFoundException, означающего, что какой-то
критически важный файл "потерялся".
Теперь для каждой из этих "угроз" вам нужно чётко определить и вывести на экран, что за "характер"
у каждой из них: является ли она "проверяемой" (checked) или "непроверяемой" (unchecked) с точки зрения системы. Используйте // комментарии в коде рядом с каждой переменной, чтобы наглядно показать эту классификацию, а затем выведите соответствующее сообщение, например: "RuntimeException — unchecked", или "FileNotFoundException — checked".

// unchecked: неожиданная угроза
RuntimeException unexpectedGlitch = new RuntimeException();

// checked: критически важная угроза
FileNotFoundException missingConfigurationFile = new FileNotFoundException();

System.out.println("RuntimeException — unchecked");
System.out.println("FileNotFoundException — checked");
Требования:
•	В программе должна быть создана переменная с именем unexpectedGlitch типа RuntimeException.
•	В программе должна быть создана переменная с именем missingConfigurationFile типа FileNotFoundException.
•	Возле объявления переменной unexpectedGlitch в коде должен быть комментарий, указывающий, что RuntimeException является непроверяемым (unchecked) исключением.
•	Возле объявления переменной missingConfigurationFile в коде должен быть комментарий, указывающий, что FileNotFoundException является проверяемым (checked) исключением.
•	Программа должна вывести на экран строки, указывающие, является ли каждая из переменных checked или unchecked, например: "RuntimeException — unchecked" и "FileNotFoundException — checked".

public class Solution {
    public static void main(String[] args) {
        // "Неожиданный сбой": RuntimeException — непроверяемое (unchecked) исключение


        // "Потерянный файл конфигурации": FileNotFoundException — проверяемое (checked) исключение


        // Выводим классификацию исключений

    }
}

 */
import java.io.FileNotFoundException;

public class Solution {
    public static void main(String[] args) {
        // "Неожиданный сбой": RuntimeException — непроверяемое (unchecked) исключение
        RuntimeException unexpectedGlitch = new RuntimeException("Неожиданный сбоей");


        // "Потерянный файл конфигурации": FileNotFoundException — проверяемое (checked) исключение
        FileNotFoundException missingConfigurationFile = new FileNotFoundException("Не могу найти файл конфигурации");


        // Выводим классификацию исключений
        System.out.println("RuntimeException — unchecked");
        System.out.println("FileNotFoundException — checked");



    }
}

/*
public class Solution {
    public static void main(String[] args) {
        // "Неожиданный сбой": RuntimeException — непроверяемое (unchecked) исключение
        RuntimeException unexpectedGlitch = new RuntimeException("Неожиданный сбой во время работы");

        // "Потерянный файл конфигурации": FileNotFoundException — проверяемое (checked) исключение
        FileNotFoundException missingConfigurationFile = new FileNotFoundException("Критически важный файл конфигурации не найден");

        // Выводим классификацию исключений
        System.out.println("RuntimeException — unchecked");
        System.out.println("FileNotFoundException — checked");
    }
}
 */