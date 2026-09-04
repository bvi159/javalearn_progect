package ru.javarush.java.core.level06.task20;

/*
Расчёт среднего балла по смешанным предметам 🎓

Вы — студент, который пытается рассчитать свой средний балл по курсу, где оценки выставляются в разных форматах.
За контрольную quizScore вы получили 4 балла (целое число), а за проект projectScore — 2.7 балла (дробное, с учётом мелких недочётов). Объявите одну переменную типа int (для quizScore) и другую типа double (для projectScore).

Ваша первая задача — сложить их и получить максимально точный средний балл. Сохраните этот результат в переменной типа double с именем exactCourseAverage.

Ваша вторая задача — представить этот средний балл как целое число, отбросив дробную часть (например, для отчёта деканату, который не любит дробные оценки). Явно преобразуйте exactCourseAverage к типу int и сохраните в roundedCourseAverage.

В конце выведите оба значения — exactCourseAverage и roundedCourseAverage — на экран, чтобы увидеть разницу и понять, как Java обрабатывает смешанные типы.

Требования:
•	В программе должны быть объявлены две переменные: одна типа int с именем quizScore, и одна типа double с именем projectScore.
•	Переменная quizScore должна быть инициализирована значением 4, а переменная projectScore — значением 2.7.
•	Для вычисления точного среднего балла необходимо сложить quizScore и projectScore, а затем разделить сумму на 2. Результат должен быть сохранён в переменной типа double с именем exactCourseAverage.
•	Значение переменной exactCourseAverage должно быть явно приведено к типу int и сохранено в переменной с именем roundedCourseAverage.
•	Программа должна вывести на экран значения переменных exactCourseAverage и roundedCourseAverage, чтобы показать разницу между точным и округлённым результатом.

public class Solution {
    public static void main(String[] args) {
        // Объявляем переменную типа int для оценки за контрольную


        // Объявляем переменную типа double для оценки за проект


        // Вычисляем точный средний балл (double) и сохраняем в exactCourseAverage


        // Преобразуем точный средний балл (double) в целое число (int) и сохраняем в roundedCourseAverage


        // Выводим точный средний балл на экран


        // Выводим округленный средний балл на экран

    }
}

 */

public class Solution {
    public static void main(String[] args) {
        // Объявляем переменную типа int для оценки за контрольную
        int quizScore = 4;
        double projectScore = 2.7;

        // Объявляем переменную типа double для оценки за проект


        // Вычисляем точный средний балл (double) и сохраняем в exactCourseAverage
        double exactCourseAverage = (quizScore + projectScore)/2;

        // Преобразуем точный средний балл (double) в целое число (int) и сохраняем в roundedCourseAverage
        int roundedCourseAverage = (int) exactCourseAverage;


        // Выводим точный средний балл на экран
        System.out.println(exactCourseAverage);

        // Выводим округленный средний балл на экран
        System.out.println(roundedCourseAverage);
        double x = 0.1;
        double y = 0.2;
        System.out.println(x + " " + y);
        System.out.println(x + y);
        int der = 300; byte b = (byte) der;
        System.out.println(b);


    }
}