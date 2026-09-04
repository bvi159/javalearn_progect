package ru.javarush.java.core.level06.task04;
/*
Двусторонняя магия символов и чисел ✨

Вы — начинающий волшебник, осваивающий искусство трансформации.
Ваше первое заклинание позволяет превращать числа в символы и обратно.

Начните с создания переменной int secretSpellCode и присвойте ей числовое значение 8364 — это код,
который, как вы слышали, скрывает в себе символ Евро в Unicode.

Затем произнесите заклинание, чтобы преобразовать secretSpellCode в char,
сохраните результат в revealedSymbol и покажите миру, какой символ скрывался за этим числом,
выведя на экран сообщение: "Символ с кодом 8364: " за которым следует ваш только что раскрытый символ.

Но магия работает в обе стороны! Теперь возьмите другой символ, например, букву 'Ж',
и присвойте её переменной char enigmaticLetter.

Ваша следующая задача — раскрыть её числовую сущность, превратив enigmaticLetter обратно в int
и сохранив результат в numericEssenceOfLetter.

Завершите своё волшебство, показав всем, какой числовой код соответствует символу 'Ж',
выведя сообщение: "Код символа 'Ж': " за которым следует его числовое откровение.

Требования:
•	В программе должна быть объявлена переменная int с именем secretSpellCode и значением 8364.
•	Переменная secretSpellCode должна быть приведена к типу char, а результат сохранён в переменную char с именем revealedSymbol.
•	На экран должно быть выведено сообщение: "Символ с кодом 8364: " и далее символ, который был получен из secretSpellCode.
•	В программе должна быть объявлена переменная char с именем enigmaticLetter и значением 'Ж'.
•	Переменная enigmaticLetter должна быть приведена к типу int, а результат сохранён в переменную int с именем numericEssenceOfLetter.
•	На экран должно быть выведено сообщение: "Код символа 'Ж': " и далее числовое значение переменной numericEssenceOfLetter.
public class Solution {
    public static void main(String[] args) {
        // Объявляем переменную secretSpellCode типа int и присваиваем ей значение 8364


        // Явно приводим число secretSpellCode к типу char и сохраняем в revealedSymbol


        // Выводим символ, соответствующий коду 8364


        // Объявляем переменную enigmaticLetter типа char и присваиваем ей символ 'Ж'


        // Явно приводим символ enigmaticLetter к типу int и сохраняем в numericEssenceOfLetter


        // Выводим числовой код символа 'Ж'

    }
}

*/

public class Solution {
    public static void main(String[] args) {
        // Объявляем переменную secretSpellCode типа int и присваиваем ей значение 8364
        int secretSpellCode = 8364;

        // Явно приводим число secretSpellCode к типу char и сохраняем в revealedSymbol
        char revealedSymbol = (char) 8364;

        // Выводим символ, соответствующий коду 8364
        System.out.println( "Символ с кодом 8364: " + revealedSymbol);

        // Объявляем переменную enigmaticLetter типа char и присваиваем ей символ 'Ж'
        char enigmaticLetter = 'Ж';


        // Явно приводим символ enigmaticLetter к типу int и сохраняем в numericEssenceOfLetter
        int numericEssenceOfLetter = enigmaticLetter;

        // Выводим числовой код символа 'Ж'
        System.out.println("Код символа 'Ж': " + numericEssenceOfLetter);
    }
}