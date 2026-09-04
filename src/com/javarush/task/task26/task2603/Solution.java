package com.javarush.task.task26.task2603;

import java.util.Comparator;

/* 
Убежденному убеждать других не трудно
В таблице есть колонки, по которым можно сортировать.
Пользователь имеет возможность настроить под себя список колонок, которые будут сортироваться.
Напиши public static компаратор CustomizedComparator, который будет:
1. В конструкторе принимать массив компараторов.
2. Сортировать данные в порядке, соответствующем последовательности компараторов.
Все переданные компараторы сортируют дженерик тип Т.
В конструктор передается как минимум один компаратор.

Требования:
•	Класс Solution должен содержать public static компаратор CustomizedComparator.
•	Класс CustomizedComparator должен содержать приватное поле comparators типа Comparator<T>[].
•	Класс CustomizedComparator должен содержать конструктор с параметром vararg компараторов.
•	Метод compare() класса CustomizedComparator должен сравнивать объекты в порядке, соответствующем последовательности компараторов comparators.



*/

public class Solution {
    public static class CustomizedComparator<T> implements Comparator<T> {
        // Приватное поле для хранения массива компараторов
        private final Comparator<T>[] comparators;

        // Конструктор с параметром vararg компараторов
        @SafeVarargs
        public CustomizedComparator(Comparator<T>... comparators) {
            if (comparators == null || comparators.length == 0) {
                throw new IllegalArgumentException("Должен быть передан как минимум один компаратор");
            }
            this.comparators = comparators;
        }

        // Метод compare для сравнения объектов
        @Override
        public int compare(T o1, T o2) {
            // Проходим по всем компараторам по порядку
            for (Comparator<T> comparator : comparators) {
                // Сравниваем объекты с помощью текущего компаратора
                int result = comparator.compare(o1, o2);

                // Если компаратор определил различие, возвращаем результат
                if (result != 0) {
                    return result;
                }
            }

            // Если все компараторы считают объекты равными, возвращаем 0
            return 0;
        }

    }


    public static void main(String[] args) {
        // Пример использования
        Comparator<String> lengthComparator = Comparator.comparingInt(String::length);
        Comparator<String> alphabetComparator = Comparator.naturalOrder();

        CustomizedComparator<String> customizedComparator =
                new CustomizedComparator<>(lengthComparator, alphabetComparator);

        // Тестирование компаратора
        String str1 = "apple";
        String str2 = "banana";

        int result = customizedComparator.compare(str1, str2);
        System.out.println("Результат сравнения: " + result);
    }

}
/*
public class Solution {

    public static void main(String[] args) {

    }
}
 */