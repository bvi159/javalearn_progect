package com.javarush.task.task26.task2601;

import java.util.Arrays;
import java.util.Comparator;

/* 
Почитать в инете про медиану выборки
Реализуй логику метода sort, который должен сортировать данные в массиве по удаленности от его медианы.
Верни отсортированный массив от минимального расстояния до максимального.
Если удаленность одинаковая у нескольких чисел, то сортируй их в порядке возрастания.

Пример входящего массива:
13, 8, 15, 5, 17
медиана - 13

Отсортированный масив:
13, 15, 17, 8, 5

Требования:
•	Программа не должна выводить текст в консоль.
•	Программа не должна считывать данные с консоли.
•	Класс Solution должен содержать публичный статический метод Integer[] sort(Integer[] array).
•	Метод sort(Integer[] array) класса Solution должен сортировать данные в массиве по удаленности от его медианы.
Ихнее решение
public class Solution {

    public static void main(String[] args) {

    }

    public static Integer[] sort(Integer[] array) {
        final double mediana = getMediana(array);

        Arrays.sort(array, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                double v1 = o1.intValue() - mediana;
                double v2 = o2.intValue() - mediana;
                return (int) ((v1 * v1 - v2 * v2) * 100);
            }
        });

        return array;
    }

    private static double getMediana(Integer[] array) {
        Arrays.sort(array);
        double res;
        int length = array.length;

        if (length % 2 == 1) {
            res = array[length / 2];
        } else {
            res = (array[length / 2 - 1] + array[length / 2]) / 2.;
        }
        return res;
    }
}

*/
// решение ИИ
public class Solution {

    public static void main(String[] args) {
        // Для тестирования
//        Integer[] array = {13, 8, 15, 5, 17};
//        Integer[] sorted = sort(array);
//        System.out.println(Arrays.toString(sorted)); // [13, 15, 17, 8, 5]
    }

    public static Integer[] sort(Integer[] array) {
        //implement logic here
        if (array == null || array.length == 0) {
            return array;
        }

        // Создаем копию массива для сортировки
        Integer[] sortedArray = array.clone();

        // Сортируем массив для нахождения медианы
        Integer[] temp = array.clone();
        Arrays.sort(temp);

        // Находим медиану
        double median;
        int n = temp.length;
        if (n % 2 == 1) {
            // Нечетное количество элементов
            median = temp[n / 2];
        } else {
            // Четное количество элементов - берем среднее двух центральных
            median = (temp[n / 2 - 1] + temp[n / 2]) / 2.0;
        }

        // Сортируем по удаленности от медианы
        Arrays.sort(sortedArray, new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                // Вычисляем удаленность от медианы
                double distA = Math.abs(a - median);
                double distB = Math.abs(b - median);

                // Сравниваем по удаленности
                if (Math.abs(distA - distB) < 1e-10) {
                    // Если удаленность одинаковая, сортируем по возрастанию значения
                    return a.compareTo(b);
                } else {
                    // Сортируем по возрастанию удаленности
                    return Double.compare(distA, distB);
                }
            }
        });

        return sortedArray;
    }
}

/*
public class Solution {

    public static void main(String[] args) {

    }

    public static Integer[] sort(Integer[] array) {
        //implement logic here
        return array;
    }
}

 */