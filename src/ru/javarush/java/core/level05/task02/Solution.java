package ru.javarush.java.core.level05.task02;
/*
Тайный код древних стражей 🗝

Вы — хранитель древнего шифра, который позволяет разблокировать вход в тайную библиотеку. Но ключ к библиотеке — не просто число, это должно быть «истинное» число, нерушимое и неделимое, кроме как на себя и единицу.

Ваша миссия: получить от пользователя загадочное целое число (назовите его, например, secretKeyCandidate). Затем вы должны определить, является ли это число истинным ключом, то есть простым числом, которое делится без остатка только на 1 и на себя. Если число окажется простым, вы должны подтвердить его подлинность, выведя на экран "YES". В противном случае, если оно делится на что-то ещё, это просто отвлекающий маневр, и вам следует вывести "NO".

Например, если пользователь введет 7, ваша программа должна будет сказать: YES.

Требования:
•	Программа должна получать целое число от пользователя с помощью ввода с клавиатуры.
•	Программа должна определить, является ли введенное число простым (делится только на 1 и на само себя).
•	Если введенное число является простым, программа должна вывести на экран "YES".
•	Если введенное число не является простым, программа должна вывести на экран "NO".
public class Solution {
    public static void main(String[] args) {
        // Создаем Scanner для чтения числа с клавиатуры
        Scanner console = new Scanner(System.in);
        int secretKeyCandidate = console.nextInt();

        // Числа <= 1 не являются простыми
        if (secretKeyCandidate <= 1) {
            System.out.println("NO");
            return;
        }

        boolean isPrime = true;

        // Проверяем делители от 2 до sqrt(n).
        // Условие i <= n / i эквивалентно i*i <= n, но без риска переполнения int.
        //for (/ инициализация/; / условие /; / изменение /) {
        //if (/ условие /) { // Нашли делитель — число составное

        break;
        }
        }

        // Выводим результат проверки

        }
        }
 */

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        // Создаем Scanner для чтения числа с клавиатуры
        Scanner console = new Scanner(System.in);
        int secretKeyCandidate = console.nextInt();

        // Числа <= 1 не являются простыми
        if (secretKeyCandidate <= 1) {
            System.out.println("NO");
            return;
        }

        boolean isPrime = true;

        // Проверяем делители от 2 до sqrt(n).
        // Условие i <= n / i эквивалентно i*i <= n, но без риска переполнения int.
        int myfigure;
        for (int i = 2; i < secretKeyCandidate; i++) {
            myfigure = secretKeyCandidate % i;
            if (myfigure == 0) { // Нашли делитель — число составное
                System.out.println("NO");
                isPrime = false;
                break;
            }
        }

        // Выводим результат проверки
        if (isPrime)
            System.out.println("YES");
    }
}

/*
У них так - немного короче и тренарный оператор - типа изящней
public class Solution {
    public static void main(String[] args) {
        // Создаем Scanner для чтения числа с клавиатуры
        Scanner console = new Scanner(System.in);
        int secretKeyCandidate = console.nextInt();

        // Числа <= 1 не являются простыми
        if (secretKeyCandidate <= 1) {
            System.out.println("NO");
            return;
        }

        boolean isPrime = true;

        // Проверяем делители от 2 до sqrt(n).
        // Условие i <= n / i эквивалентно i*i <= n, но без риска переполнения int.
        for (int i = 2; i <= secretKeyCandidate / i; i++) {
            if (secretKeyCandidate % i == 0) { // Нашли делитель — число составное
                isPrime = false;
                break;
            }
        }

        // Выводим результат проверки
        System.out.println(isPrime ? "YES" : "NO");
    }
}
 */