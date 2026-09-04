package com.javarush.task.task24.task2410;

import java.util.LinkedList;
import java.util.List;

/* 
Рефакторинг, анонимные классы
Сделайте так, чтобы метод getIterator возвращал анонимный класс.
Перенесите логику LocalIterator в анонимный класс.
Меняйте только тело метода getIterator.

Требования:
•	Метод getIterator должен возвращать объект типа Iterator.
•	Объект возвращаемый методом getIterator должен быть экземпляром анонимного класса.
•	Программа должна выводить данные на экран.
•	Логика поведения программы должна остаться прежней.


*/

public class Solution {
    public static List<Iterator> iterators = new LinkedList<>();

    private int countItems;

    public Iterator getIterator(final String name) {
        Iterator myIter = new Iterator(){
            {
                countItems++;
                System.out.println(name + " item " + countItems);
            }

            @Override
            public Iterator next() {
                return getIterator(name);
            }
        };
        return myIter;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        Iterator iterator = solution.getIterator("iterator");
        for (int i = 1; i < 5; i++) {
            iterators.add(iterator.next());
        }
    }
}

/*
           Iterator myIter = new Iterator() {
           @Override
            public Iterator next() {
                countItems++;
                System.out.println(name + " item " + countItems);
                return getIterator(name);
            }

        };
*/

//        class LocalIterator implements Iterator {
//
//            public LocalIterator() {
//                countItems++;
//                System.out.println(name + " item " + countItems);
//            }
//
//            public Iterator next() {
//                return new LocalIterator();
//            }
//        }
//        return new LocalIterator();
//        return myIter;


/*
public class Solution {
    public static List<Iterator> iterators = new LinkedList<>();

    private int countItems;

    public Iterator getIterator(final String name) {
        class LocalIterator implements Iterator {
            public LocalIterator() {
                countItems++;
                System.out.println(name + " item " + countItems);
            }

            public Iterator next() {
                return new LocalIterator();
            }
        }
        return new LocalIterator();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        Iterator iterator = solution.getIterator("iterator");
        for (int i = 1; i < 5; i++) {
            iterators.add(iterator.next());
        }
    }
}
 */