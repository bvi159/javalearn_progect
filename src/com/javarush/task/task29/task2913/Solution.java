package com.javarush.task.task29.task2913;

import java.util.Random;

/* 
Замена рекурсии
В программе случайным образом генерируются два целых числа A и В в диапазоне от 0 (включая) до 1000 (не включая). Нужно вывести все целые числа от A до B включительно, в порядке возрастания, если A меньше B, или в порядке убывания в противном случае.

Задача реализована с использованием рекурсии.
Иногда в результате работы программы получаем Exception in thread "main" java.lang.StackOverflowError.

Твоя задача: перепиши код без использования рекурсии.
Метод recursion() переименуй на getAllNumbersBetween().

Требования:
•	Метод recursion() необходимо переименовать на getAllNumbersBetween().
•	Ни в одном методе класса Solution не должно быть рекурсивных вызовов.
•	В конце строчки вывода последовательности чисел не должно быть пробела.
•	Логика работы программы должна остаться прежней.
•	Метод main() не изменять.

public class Solution {
    private static int numberA;
    private static int numberB;

    public static String recursion(int a, int b) {
        if (a > b) {
            return a + " " + recursion(a - 1, b);
        } else {
            if (a == b) {
                return Integer.toString(a);
            }
            return a + " " + recursion(a + 1, b);
        }
    }

    public static void main(String[] args) {
        Random random = new Random();
        numberA = random.nextInt(1000);
        numberB = random.nextInt(1000);
        System.out.println(getAllNumbersBetween(numberA, numberB));
        System.out.println(getAllNumbersBetween(numberB, numberA));
    }
}

*/

public class Solution {
    private static int numberA;
    private static int numberB;

    public static String getAllNumbersBetween(int a, int b) {
        StringBuilder result = new StringBuilder();

        if (a <= b) {
            // Возрастающая последовательность
            for (int i = a; i <= b; i++) {
                result.append(i);
                if (i < b) {
                    result.append(" ");
                }
            }
        } else {
            // Убывающая последовательность
            for (int i = a; i >= b; i--) {
                result.append(i);
                if (i > b) {
                    result.append(" ");
                }
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Random random = new Random();
        numberA = random.nextInt(1000);
        numberB = random.nextInt(1000);
        System.out.println(getAllNumbersBetween(numberA, numberB));
        System.out.println(getAllNumbersBetween(numberB, numberA));
    }
}