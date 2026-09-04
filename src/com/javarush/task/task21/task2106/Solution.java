package com.javarush.task.task21.task2106;

import java.util.Date;

/* 
Ошибка в equals/hashCode
public class Solution {
    private int anInt;
    private String string;
    private double aDouble;
    private Date date;
    private Solution solution;

    public Solution(int anInt, String string, double aDouble, Date date, Solution solution) {
        this.anInt = anInt;
        this.string = string;
        this.aDouble = aDouble;
        this.date = date;
        this.solution = solution;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Solution)) return false;

        Solution solution1 = (Solution) o;

        if (Double.compare(solution1.aDouble, aDouble) != 0) return false;
        if (anInt != solution1.anInt) return false;
        if (date != null ? !date.equals(solution1.date) : solution1.date != null) return false;
        if (solution != null ? !solution.equals(solution1.solution) : solution1.solution != null) return false;
        return string != null ? string.equals(solution1.string) : solution1.string == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = anInt;
        result = 31 * result + (string != null ? string.hashCode() : 0);
        temp = aDouble != +0.0d ? Double.doubleToLongBits(aDouble) : 0L;
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (solution != null ? solution.hashCode() : 0);
        return result;
    }

    public static void main(String[] args) {

    }
}
Исправьте ошибки реализаций методов equals и hashCode для класса Solution.

Требования:
•	Хешкоды одинаковых объектов должны быть равны.
•	Метод equals должен проверять равен ли переданный объект равен текущему (сравнение через ==).
•	Метод equals должен проверять является ли переданный объект объектом класса Solution.
•	Метод equals должен проверять значения всех полей у переданного объекта и текущего (учти что некоторые из них могут быть равны null).
•	Должно быть обеспечено корректное поведение HashSet с типом элементов Solution.
•	В классе Solution должен быть реализован метод hashCode.

моё тоже правильное с помощью ИИ

*/
//java что значит temp ^ (temp >>> 32) в программе:

public class Solution {
    private int anInt;
    private String string;
    private double aDouble;
    private Date date;
    private Solution solution;

    public Solution(int anInt, String string, double aDouble, Date date, Solution solution) {
        this.anInt = anInt;
        this.string = string;
        this.aDouble = aDouble;
        this.date = date;
        this.solution = solution;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

//        if (o instanceof Solution) {
//            return false;
//        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Solution solution1 = (Solution) o;

        if (Double.compare(solution1.aDouble, aDouble) != 0) {
            return false;
        }

        if (anInt != solution1.anInt) {
            return false;
        }

//        if (date != null ? !date.equals(solution1.date) : solution1.date == null) {
//            return false;}
        // Сравнение даты (с учётом null)
        if (date == null) {
            if (solution1.date != null) {
                return false;
            }
        } else if (!date.equals(solution1.date)) {
            return false;
        }

//        if (solution != null ? !solution.equals(solution1.solution) : solution1.solution == null){
//            return false;}
        // Сравнение вложенного Solution (рекурсивно, с учётом null)
        if (solution == null) {
            if (solution1.solution != null) {
                return false;
            }
        } else if (!solution.equals(solution1.solution)) {
            return false;
        }



//        if (string != null ? !string.equals(solution1.string) : solution1.string == null){
//            return false;}
        // Сравнение строки (с учётом null)
        if (string == null) {
            if (solution1.string != null) {
                return false;
            }
        } else if (!string.equals(solution1.string)) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = anInt;
        temp = aDouble != +0.0d ? Double.doubleToLongBits(aDouble) : 0L;
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (solution != null ? solution.hashCode() : 0);
        return result;
    }

    public static void main(String[] args) {

    }
}
