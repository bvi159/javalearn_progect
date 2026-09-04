package ru.javarush.java.core.level05.task11;
/*
Вы — молодой маг, которому поручено найти скрытый кристалл мудрости.
Хитрый дух загадал число от 1 до 100, и оно спрятано в его башне. Чтобы приблизиться к разгадке, вы называете числа, а дух подсказывает:

Если ваше число меньше загаданного, он говорит: Больше!
Если число больше — отвечает: Меньше!
Если угадали точно — дух признаёт поражение и говорит: Верно!, после чего испытание завершается.
Ваша задача — написать программу, которая реализует эту игру, где игрок вводит числа в цикле, пока не угадает.

Требования:
•	Программа должна сгенерировать и сохранить загаданное число от 1 до 100.
•	На каждом шаге игрок должен вводить число с клавиатуры.
•	Если введённое число меньше загаданного — программа выводит Больше!.
•	Если введённое число больше загаданного — программа выводит Меньше!.
•	Если введённое число равно загаданному — программа выводит Верно! и завершает выполнение.
•	Программа должна работать в цикле до тех пор, пока число не будет угадано.
import java.util.Random;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Random rand = new Random();
        int secret = rand.nextInt(100) + 1; // 1..100
        Scanner console = new Scanner(System.in);

        // Игра с духом
        while (true) {

        }
    }
}

 */
import java.util.Random;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Random rand = new Random();
        int secret = rand.nextInt(100) + 1; // 1..100
        //System.out.println(secret);
        Scanner console = new Scanner(System.in);
        int myFig; //= console.nextInt();
        // Игра с духом
        while (true) {
            myFig = console.nextInt();
            if (secret == myFig) {
                System.out.println("Верно!");
                break;
            }else if (secret < myFig){
                System.out.println("Меньше!");
                //myFig = console.nextInt();
            } else {
                System.out.println("Больше!");
                //myFig = console.nextInt();
            }
        }
    }
}

/* ихнее правильное
public class Solution {
    public static void main(String[] args) {
        Random rand = new Random();
        int secret = rand.nextInt(100) + 1; // 1..100
        Scanner console = new Scanner(System.in);

        // Игра с духом
        while (true) {
            System.out.print("Введите число (1-100): ");
            int guess = console.nextInt();

            if (guess < secret) {
                System.out.println("Больше!");
            } else if (guess > secret) {
                System.out.println("Меньше!");
            } else {
                System.out.println("Верно!");
                break;
            }
        }
    }
}

 */