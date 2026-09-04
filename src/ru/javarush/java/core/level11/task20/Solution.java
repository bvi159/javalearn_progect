package ru.javarush.java.core.level11.task20;

/*
Глубокое погружение: анализ сбоя в многоуровневой системе 🪆
Представьте, что вы работаете над сложной системой, где функционал разбит на множество маленьких, взаимосвязанных методов, передающих управление друг другу. Вам нужно понять, как трассировать ошибку, которая происходит на нескольких уровнях вложенности.

Создайте четыре метода: main, processInitialRequest, handleIntermediateStep, и executeFinalAction. Пусть main вызывает processInitialRequest, тот вызывает handleIntermediateStep, который в свою очередь вызывает executeFinalAction.

В методе executeFinalAction создайте небольшой массив int[] temporaryData (например, из 2 элементов) и намеренно попробуйте обратиться к элементу с индексом 10 (который, очевидно, выходит за пределы массива).

Запустите программу. Тщательно проанализируйте полученный Stack Trace. Он покажет вам подробную историю "путешествия" программы от main до самого глубокого метода, executeFinalAction, и точно укажет на строку, где произошла ошибка доступа к массиву. Это незаменимый инструмент для отладки в больших проектах.

Требования:
•	В программе должны быть реализованы четыре метода: main, processInitialRequest, handleIntermediateStep и executeFinalAction. Метод main вызывает processInitialRequest, тот вызывает handleIntermediateStep, а тот, в свою очередь, вызывает executeFinalAction.
•	В методе executeFinalAction необходимо создать массив int[] temporaryData размером два элемента.
•	В методе executeFinalAction нужно попытаться обратиться к элементу массива temporaryData с индексом 10, что приведет к выбросу исключения ArrayIndexOutOfBoundsException.
•	Программа должна быть запущена так, чтобы в консоли был виден stack trace, отображающий цепочку вызовов от main до executeFinalAction, с указанием строки, на которой произошла ошибка.

public class Solution {
    public static void main(String[] args) {
        // Начальная точка программы

    }


}

 */
public class Solution {
    public static void main(String[] args) {
        // Начальная точка программы
        processInitialRequest();
    }

    public static void processInitialRequest() {
        handleIntermediateStep();
    }

    public static void handleIntermediateStep() {
        executeFinalAction();
    }

    public static void executeFinalAction() {
        int[] temporaryData = new int[2];
        System.out.println(temporaryData[10]);
    }


}