package ru.javarush.java.core.level06.task18;

/*
Перекодировка секретных сообщений для шпиона 🕵️‍♀️

Вы — шпион-криптограф и вам необходимо освоить искусство перекодировки символов в числа и обратно.
Начните с объявления переменной типа char с именем secretAgentLetter и присвойте ей, скажем, символ 'G',
который является частью вашего шифра. Ваша первая миссия — раскрыть числовой код этого символа.

Преобразуйте secretAgentLetter в int, сохраните результат в numericCode, и выведите этот код на экран,
чтобы ваш агент мог его записать. Ваша вторая миссия — доказать, что вы можете восстановить символ из его кода.
Преобразуйте numericCode обратно в char, сохраните результат в decodedAgentLetter, и выведите этот восстановленный
 символ на экран, подтверждая успешную дешифровку.

Требования:
•	В программе должна быть объявлена переменная типа char с именем secretAgentLetter, которой присваивается символ 'G'.
•	Значение переменной secretAgentLetter должно быть преобразовано в тип int и сохранено в переменную numericCode.
•	Значение переменной numericCode должно быть выведено на экран.
•	Значение переменной numericCode должно быть преобразовано обратно в тип char и сохранено в переменную decodedAgentLetter.
•	Значение переменной decodedAgentLetter должно быть выведено на экран.

public class Solution {
    public static void main(String[] args) {
        // Исходный символ агента — часть шифра


        // Явно приводим char к int, получаем числовой код символа


        // Явно приводим int обратно к char, восстанавливаем символ

    }
}

 */

public class Solution {
    public static void main(String[] args) {
        // Исходный символ агента — часть шифра
        char secretAgentLetter = 'G';

        // Явно приводим char к int, получаем числовой код символа
        int numericCode = secretAgentLetter;
        System.out.println(numericCode);

        // Явно приводим int обратно к char, восстанавливаем символ
        char decodedAgentLetter = (char) numericCode;
        System.out.println(decodedAgentLetter);

    }
}