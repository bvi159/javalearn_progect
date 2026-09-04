package ru.javarush.java.core.level04.task12;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        // Создаем Scanner для чтения пароля с клавиатуры
        Scanner scanner = new Scanner(System.in);
        // переменная для введенного пароля
        String password;

        // Цикл do-while гарантирует минимум один запрос пароля
        do {
            // Запрашиваем ввод пароля
            System.out.println("Введите пароль, plz:");
            // читаем строку целиком
            password  = scanner.nextLine();
            System.out.println(password);

        } while (password.length() < 6); // повторяем, пока пароль короче 6 символов

        // Сообщение об успешной регистрации
        System.out.println("Пароль надёжен, аккаунт создан!");

    }
}