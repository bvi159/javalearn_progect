package ru.javarush.java.core.level05.task13;
/*
Вы встретили мудрого голема, который охраняет тайную кучу камней. В куче изначально лежит случайное количество камней от 1 до 100 — и это число загадал компьютер.

Правила игры:

Первым ходит игрок. За один ход можно взять от 1 до 10 камней.
Затем ходит голем: он берёт случайное количество камней (от 1 до 10, но не больше оставшегося).
После каждого хода программа выводит, сколько камней осталось.
Игра идёт до тех пор, пока камней не останется.
Тот, кто взял последний камень, становится победителем.
Требования:
•	Компьютер должен выбрать случайное число от 1 до 100 — это количество камней в начале игры.
•	Игрок должен ввести число от 1 до 10 — сколько камней он хочет взять.
•	Компьютер выбирает случайное количество камней от 1 до 10, но не больше, чем осталось в куче.
•	Игрок и компьютер должны ходить по очереди.

public class Solution {
    public static void main(String[] args) {
        // Случайное начальное число камней 1..100
        Random rand = new Random();
        int stones = rand.nextInt(100) + 1;

        // Подготовка ввода
        Scanner sc = new Scanner(System.in);
        System.out.println("Старт игры. В куче " + stones + " камней.");

        // Основной цикл партии
        while (stones > 0) {
            // Ход игрока: вводим, пока не попадём в допустимый диапазон
            int maxTake = Math.min(10, stones);
            int takePlayer;
            while (true) {
                System.out.print("Сколько камней возьмёте (1-" + maxTake + "): ");



            }

            System.out.println("Игрок взял " + takePlayer + ". Осталось: " + stones);


            // Ход компьютера: берём случайно, но не больше остатка
            int takeBot = Math.min(stones, rand.nextInt(10) + 1);

            System.out.println("Компьютер взял " + takeBot + ". Осталось: " + stones);
            if (stones == 0) {
                System.out.println("Компьютер победил!");
                break;
            }
        }
    }
}

 */

import java.util.Random;
import java.util.Scanner;
/*
Вы встретили мудрого голема, который охраняет тайную кучу камней. В куче изначально лежит случайное количество камней от 1 до 100 — и это число загадал компьютер.

Правила игры:

Первым ходит игрок. За один ход можно взять от 1 до 10 камней.
Затем ходит голем: он берёт случайное количество камней (от 1 до 10, но не больше оставшегося).
После каждого хода программа выводит, сколько камней осталось.
Игра идёт до тех пор, пока камней не останется.
Тот, кто взял последний камень, становится победителем.
Требования:
•	Компьютер должен выбрать случайное число от 1 до 100 — это количество камней в начале игры.
•	Игрок должен ввести число от 1 до 10 — сколько камней он хочет взять.
•	Компьютер выбирает случайное количество камней от 1 до 10, но не больше, чем осталось в куче.
•	Игрок и компьютер должны ходить по очереди.
•	После каждого хода количество камней уменьшается и программа сообщает, сколько камней осталось.
•	Кто возьмёт последний камень, тот объявляется победителем.
public class Solution {
    public static void main(String[] args) {
        // Случайное начальное число камней 1..100
        Random rand = new Random();
        int stones = rand.nextInt(100) + 1;

        // Подготовка ввода
        Scanner sc = new Scanner(System.in);
        System.out.println("Старт игры. В куче " + stones + " камней.");

        // Основной цикл партии
        while (stones > 0) {
            // Ход игрока: вводим, пока не попадём в допустимый диапазон
            int maxTake = Math.min(10, stones);
            int takePlayer;
            while (true) {
                System.out.print("Сколько камней возьмёте (1-" + maxTake + "): ");

            }

            System.out.println("Игрок взял " + takePlayer + ". Осталось: " + stones);


            // Ход компьютера: берём случайно, но не больше остатка
            int takeBot = Math.min(stones, rand.nextInt(10) + 1);

            System.out.println("Компьютер взял " + takeBot + ". Осталось: " + stones);
            if (stones == 0) {
                System.out.println("Компьютер победил!");
                break;
            }
        }
    }
}

*/

public class Solution {
    public static void main(String[] args) {
        // Случайное начальное число камней 1..100
        Random rand = new Random();
        int stones = rand.nextInt(100) + 1;

        // Подготовка ввода
        Scanner sc = new Scanner(System.in);
        System.out.println("Старт игры. В куче " + stones + " камней.");

        // Основной цикл партии
        while (stones > 0) {
            // Ход игрока: вводим, пока не попадём в допустимый диапазон
            int maxTake = Math.min(10, stones);
            int takePlayer;

            while (true) {
                System.out.print("Сколько камней возьмёте (1-" + maxTake + "): ");
                takePlayer = sc.nextInt();
//                if (takePlayer <= Math.min(10, maxTake) && takePlayer >= 1 && takePlayer < maxTake){
                if (takePlayer >= 1 && takePlayer <= maxTake){
                    break;
                }
            }
            stones = stones - takePlayer;
            System.out.println("Игрок взял " + takePlayer + ". Осталось: " + stones);
            if (stones == 0) {
                System.out.println("Игрок победил!");
                break;
            }

            // Ход компьютера: берём случайно, но не больше остатка
            int takeBot = Math.min(stones, rand.nextInt(10) + 1);
            stones = stones - takeBot;
            System.out.println("Компьютер взял " + takeBot + ". Осталось: " + stones);
            if (stones == 0) {
                System.out.println("Компьютер победил!");
                break;
            }
        }
    }
}

/*
Ихнее решение

public class Solution {
    public static void main(String[] args) {
        // Случайное начальное число камней 1..100
        Random rand = new Random();
        int stones = rand.nextInt(100) + 1;

        // Подготовка ввода
        Scanner sc = new Scanner(System.in);
        System.out.println("Старт игры. В куче " + stones + " камней.");

        // Основной цикл партии
        while (stones > 0) {
            // Ход игрока: вводим, пока не попадём в допустимый диапазон
            int maxTake = Math.min(10, stones);
            int takePlayer;
            while (true) {
                System.out.print("Сколько камней возьмёте (1-" + maxTake + "): ");
                takePlayer = sc.nextInt(); // ожидаем целое число
                if (takePlayer >= 1 && takePlayer <= maxTake) break;
                System.out.println("Неверный ввод.");
            }
            stones -= takePlayer;
            System.out.println("Игрок взял " + takePlayer + ". Осталось: " + stones);
            if (stones == 0) {
                System.out.println("Игрок победил!");
                break;
            }

            // Ход компьютера: берём случайно, но не больше остатка
            int takeBot = Math.min(stones, rand.nextInt(10) + 1);
            stones -= takeBot;
            System.out.println("Компьютер взял " + takeBot + ". Осталось: " + stones);
            if (stones == 0) {
                System.out.println("Компьютер победил!");
                break;
            }
        }
    }
}
 */