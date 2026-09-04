package ru.javarush.java.core.level05.task03;

/*
Зеркальное послание волшебника 📜

В старинном свитке вы обнаружили загадочное послание от забытого волшебника.
Его слова имеют необычную природу: чтобы раскрыть их истинный смысл, их нужно прочитать в обратном порядке.
Это как смотреть в волшебное зеркало, которое переворачивает все буквы.

Ваша задача — написать программу, которая поможет вам увидеть его "обратную сторону".
Попросите пользователя ввести любую строку текста (назовите её magicMessage).
Затем ваша программа должна мгновенно отразить это послание, выведя все символы в строго обратном порядке.
Так, если введено слово "cat", должно появиться "tac".

Требования:
•	Программа должна запросить у пользователя ввод строки и сохранить её в переменную с именем magicMessage.
•	Программа должна корректно прочитать строку, введённую пользователем, с помощью стандартных средств ввода Java.
•	Программа должна преобразовать строку magicMessage так, чтобы все символы в ней располагались в обратном порядке.
•	Программа должна вывести преобразованную (инвертированную) строку на экран.
 */

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Просим пользователя ввести строку (послание)
        System.out.println("Напиши что-нибудь: ");
        String magicMessage = scanner.nextLine();

        // Разворачиваем строку с помощью цикла for

        for (int i = magicMessage.length() - 1; i >= 0; i--) {
            // reversedMessage += magicMessage.charAt(i);
            System.out.printf("" + magicMessage.charAt(i));
        }


        // Выводим инвертированную строку

    }
}
/*
можно так
String reversedMessage = new StringBuilder(magicMessage).reverse().toString();
У них так:
public class Solution {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        // Просим пользователя ввести строку (послание)
        System.out.println("Введите волшебное послание:");
        String magicMessage = console.nextLine(); // сохраняем ввод в переменную с нужным именем

        // Разворачиваем строку с помощью цикла for
        String reversed = "";
        for (int i = magicMessage.length() - 1; i >= 0; i--) {
            reversed += magicMessage.charAt(i);
        }

        // Выводим инвертированную строку
        System.out.println(reversed);
    }
}

 */