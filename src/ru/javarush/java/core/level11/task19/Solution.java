package ru.javarush.java.core.level11.task19;
/*
Детектив кода: расследование сбоя в системе отчетов 📉
Вы как детектив пытаетесь понять, почему ваша сложная система отчётов внезапно "падает". Система состоит из нескольких взаимосвязанных модулей.

Создайте три метода: main, calculateReportData (который main будет вызывать), и processRawNumbers (который будет вызван из calculateReportData). Внутри processRawNumbers намеренно спровоцируйте деление на ноль (например, 100 / 0). Запустите программу.

Ваша задача – внимательно изучить появившийся "Stack Trace". Он покажет вам полную цепочку вызовов: от того места, где программа начала свою работу (main), через все промежуточные методы (calculateReportData), до самого корня проблемы (processRawNumbers), где и произошла критическая ошибка. Это помогает быстро найти источник проблемы.

Требования:
•	В программе должны быть объявлены три метода: main, calculateReportData и processRawNumbers.
•	Метод main должен вызывать метод calculateReportData, который в свою очередь должен вызывать метод processRawNumbers.
•	Внутри метода processRawNumbers должно происходить деление на ноль (например, 100 / 0), что вызывает исключение ArithmeticException.
•	Программа не должна перехватывать исключение — стек вызовов должен быть выведен автоматически JVM.
•	В появившемся Stack Trace должны быть отражены все три метода: main, calculateReportData и processRawNumbers, показывая последовательность вызовов до места ошибки.

public class Solution {

    public static void main(String[] args) {
        // Вызов метода calculateReportData из main

    }

}

 */
public class Solution {
    static void calculateReportData() {
        processRawNumbers();
    }

    static void processRawNumbers() {
        int nullDevision = 100 / 0;
    }

    public static void main(String[] args) {
        // Вызов метода calculateReportData из main
        calculateReportData();

    }

}