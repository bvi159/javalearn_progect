package ru.javarush.java.core.level08.task12;

/*
Подсчет общего балла за все тесты студента 📚
Вообразите, что вы — учитель, который ведет электронный журнал успеваемости студентов, и вам нужно быстро подсчитать общую сумму баллов за все тесты для конкретного ученика. Вам нужен автоматический помощник, который справится с этой трудоемкой задачей.

Сконструируйте метод под названием calculateTotalGrades. Он будет принимать в качестве единственного параметра studentExamResults — это будет массив целых чисел, представляющий оценки студента за различные экзамены.

Задача calculateTotalGrades — пройти по всем оценкам в массиве, сложить их вместе и вернуть окончательную сумму.

В вашем учительском кабинете, в методе main, создайте виртуальный список оценок для студента, например, currentGrades = {5, 4, 3, 5, 4}. Затем вызовите calculateTotalGrades, передав ему этот список. Сохраните полученную итоговую сумму в переменную finalTotalPoints и с удовлетворением выведите на экран: "Сумма всех оценок: " с указанием finalTotalPoints.

public class Solution {

    // Метод с возвращаемым значением int: принимает массив оценок и возвращает их сумму
    public static int calculateTotalGrades(int[] studentExamResults) {

        // Проходим по всем элементам массива и накапливаем сумму

        // Возвращаем итоговую сумму
    }

    public static void main(String[] args) {
        // Виртуальный список оценок студента
        int[] currentGrades = {5, 4, 3, 5, 4};

        // Вызываем метод подсчёта и сохраняем результат в переменную finalTotalPoints
        int finalTotalPoints = calculateTotalGrades(currentGrades);

        // Выводим результат на экран
        System.out.println("Сумма всех оценок: " + finalTotalPoints);
    }
}

 */

public class Solution {

    // Метод с возвращаемым значением int: принимает массив оценок и возвращает их сумму
    public static int calculateTotalGrades(int[] studentExamResults) {

        // Проходим по всем элементам массива и накапливаем сумму
        int finalTotalPoints = 0;
        for (int fintot : studentExamResults) {
            finalTotalPoints += fintot;
        }

        // Возвращаем итоговую сумму
        return finalTotalPoints;
    }

    public static void main(String[] args) {
        // Виртуальный список оценок студента
        int[] currentGrades = {5, 4, 3, 5, 4};

        // Вызываем метод подсчёта и сохраняем результат в переменную finalTotalPoints
        int finalTotalPoints = calculateTotalGrades(currentGrades);

        // Выводим результат на экран
        System.out.println("Сумма всех оценок: " + finalTotalPoints);
    }
}