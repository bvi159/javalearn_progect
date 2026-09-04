package com.javarush.task.task25.task2501;

/* 
Новые возможности!

//Используя возможности enum-а реализуй метод getLetterPosition, который должен возвращать позицию буквы.
//Позиция буквы A - 1.
//
//Требования:
//        •	Класс Solution должен содержать enum Alphabet.
//        •	Alphabet должен содержать по порядку 26 букв английского алфавита.
//•	Метод getLetterPosition у класса Alphabet должен возвращать позицию буквы в алфавите.
//•	Метод getLetterPosition должен вызывать метод ordinal.
//
У меня правильный ответ
*/




public class Solution {
    public static void main(String[] args) {
        System.out.println(Alphabet.G.getLetterPosition());
    }

    public enum Alphabet {
        A, B, C, D, E,
        F, G, H, I, J,
        K, L, M, N, O,
        P, Q, R, S, T,
        U, V, W, X, Y, Z;

        int getLetterPosition() {
              return this.ordinal() + 1;
        }
    }
}

//int letterPosition;
//letterPosition = Alphabet.valueOf("G").ordinal();
//            System.out.println("G - " + letterPosition);
//            return letterPosition;