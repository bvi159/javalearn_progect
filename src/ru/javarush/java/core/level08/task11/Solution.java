package ru.javarush.java.core.level08.task11;
/*
Выбор победителя в соревновании по очкам 🏆

Представьте, что вы создаете систему для анализа результатов спортивных соревнований, и вам постоянно нужно быстро определять, кто показал лучший результат среди двух участников.

Разработайте специальный метод под названием getHigherScore. Он будет принимать два целых числа, например, playerOneScore и playerTwoScore, представляющие очки двух спортсменов.

Задача getHigherScore — определить, какое из двух чисел больше, и вернуть именно это наибольшее значение.

В главном судейском центре вашей программы, в методе main, проведите тестовое сравнение для результатов 10 и 25. Сохраните результат, который вернет getHigherScore, в переменную championsScore, а затем гордо объявите на экране: "Наивысший балл: " с отображением значения championsScore.

Требования:
•	В программе должен быть определен метод с именем getHigherScore, принимающий два целых числа в качестве параметров.
•	Метод getHigherScore должен сравнивать два переданных ему числа и возвращать то, которое больше.
•	В методе main результат вызова getHigherScore должен быть сохранен в переменную с именем championsScore.
•	В методе main должно быть выведено сообщение "Наивысший балл: " с последующим значением переменной championsScore.

public class Solution {

    // Метод getHigherScore принимает два целых числа и возвращает большее из них
    public static int getHigherScore(int playerOneScore, int playerTwoScore) {
        // Используем условный оператор для сравнения двух чисел

    }

    public static void main(String[] args) {
        // Тестовые данные: очки двух игроков
        int playerOneScore = 10;
        int playerTwoScore = 25;

        // Вызов метода getHigherScore и сохранение результата в переменную championsScore
        int championsScore = getHigherScore(playerOneScore, playerTwoScore);

        // Вывод на экран наивысшего балла
        System.out.println("Наивысший балл: " + championsScore);
    }
}

*/

public class Solution {

    // Метод getHigherScore принимает два целых числа и возвращает большее из них
    public static int getHigherScore(int playerOneScore, int playerTwoScore) {
        // Используем условный оператор для сравнения двух чисел
        return Math.max(playerOneScore, playerTwoScore);

    }

    public static void main(String[] args) {
        // Тестовые данные: очки двух игроков
        int playerOneScore = 10;
        int playerTwoScore = 25;

        // Вызов метода getHigherScore и сохранение результата в переменную championsScore
        int championsScore = getHigherScore(playerOneScore, playerTwoScore);

        // Вывод на экран наивысшего балла
        System.out.println("Наивысший балл: " + championsScore);
    }


}
/*
Ихнее решение

public class Solution {

    // Метод getHigherScore принимает два целых числа и возвращает большее из них
    public static int getHigherScore(int playerOneScore, int playerTwoScore) {
        // Используем условный оператор для сравнения двух чисел
        return (playerOneScore > playerTwoScore) ? playerOneScore : playerTwoScore;
    }

    public static void main(String[] args) {
        // Тестовые данные: очки двух игроков
        int playerOneScore = 10;
        int playerTwoScore = 25;

        // Вызов метода getHigherScore и сохранение результата в переменную championsScore
        int championsScore = getHigherScore(playerOneScore, playerTwoScore);

        // Вывод на экран наивысшего балла
        System.out.println("Наивысший балл: " + championsScore);
    }
}
 */