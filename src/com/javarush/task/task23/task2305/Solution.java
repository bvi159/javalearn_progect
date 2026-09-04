package com.javarush.task.task23.task2305;

/* 
Inner
Реализовать метод getTwoSolutions, который должен возвращать массив из 2-х экземпляров класса Solution.
Для каждого экземпляра класса Solution инициализировать поле innerClasses двумя значениями.
Инициализация всех данных должна происходить только в методе getTwoSolutions.

Требования:
•	В классе Solution должен быть реализован метод getTwoSolutions.
•	Метод getTwoSolutions должен быть статическим.
•	Метод getTwoSolutions должен быть публичным.
•	Метод getTwoSolutions должен возвращать массив типа Solution заполненный согласно заданию.
*/
public class Solution {
    public InnerClass[] innerClasses = new InnerClass[2];

    public class InnerClass {
    }

    public static Solution[] getTwoSolutions() {
        Solution[] result = new Solution[2];

        Solution solution = new Solution();
        solution.innerClasses[0] = solution.new InnerClass();
        solution.innerClasses[1] = solution.new InnerClass();

        Solution solution2 = new Solution();
        solution2.innerClasses[0] = solution.new InnerClass();
        solution2.innerClasses[1] = solution.new InnerClass();

        result[0] = solution;
        result[1] = solution2;

        return result;
    }

    public static void main(String[] args) {

    }
}

/*
моё решение
public class Solution {
    public InnerClass[] innerClasses = new InnerClass[2];

    public static class InnerClass {
        //метод DoSomething например sout "я метод внутреннего класса"
    }

    public static Solution[] getTwoSolutions() {
        Solution[] myNewTwoSolutions = new Solution[2];
        myNewTwoSolutions[0].innerClasses[0] = new InnerClass();
        myNewTwoSolutions[0].innerClasses[1] = new InnerClass();
        myNewTwoSolutions[1].innerClasses[0] = new InnerClass();
        myNewTwoSolutions[1].innerClasses[1] = new InnerClass();
        return myNewTwoSolutions;
    }

    public static void main(String[] args) {


    }
}


 */