package ru.javarush.java.core.level48.task09;
/*
Цензура в цифровом зоопарке 🦒
Представьте, что вы — строгий директор цифрового зоопарка. У вас есть список животных, но вы решили, что только те, чьи имена достаточно "длинные" (не менее 4 символов), заслуживают место в вашей престижной коллекции. Короткие имена, по вашему мнению, звучат недостаточно солидно.

Возьмите список названий животных: "dog", "cow", "horse", "sheep". Ваша задача — очистить этот список, удалив всех "недостаточно длинных" обитателей.

Используйте для этого метод removeIf и создайте специальный "фильтр" с помощью анонимного класса, который реализует Predicate<String>. Этот фильтр должен проверять каждое имя и исключать те, что имеют менее 4 символов.

После "чистки", выведите итоговый, очищенный список на экран. Ожидается, что на вашей выставке останутся только [horse, sheep].

Требования:
•	Задача должна работать со списком строк, содержащим названия животных: "dog", "cow", "horse", "sheep".
•	Для удаления элементов из списка должен использоваться метод removeIf.
•	В качестве аргумента метода removeIf необходимо использовать анонимный класс, реализующий интерфейс Predicate<String>.
•	Анонимный класс должен реализовывать метод test так, чтобы возвращать true для строк длиной менее 4 символов.
•	После удаления неподходящих элементов итоговый список должен быть выведен на экран.
•	В итоговом списке должны остаться только элементы "horse" и "sheep".

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Solution {
    public static void main(String[] args) {
        // Исходный список животных
        List<String> animals = new ArrayList<>(Arrays.asList("dog", "cow", "horse", "sheep"));

        // Удаляем из списка все строки короче 4 символов,
        // передавая в removeIf анонимный класс, реализующий Predicate<String>.


        // Вывод очищенного списка
        System.out.println(animals); // Ожидается: [horse, sheep]
    }
}

 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Solution {
    public static void main(String[] args) {
        // Исходный список животных
        List<String> animals = new ArrayList<>(Arrays.asList("dog", "cow", "horse", "sheep"));

        // Удаляем из списка все строки короче 4 символов,
        // передавая в removeIf анонимный класс, реализующий Predicate<String>.
        animals.removeIf(new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return (s.length() < 4);
            }
        });

        // Вывод очищенного списка
        System.out.println(animals); // Ожидается: [horse, sheep]
    }
}
/*

public class Solution {
    public static void main(String[] args) {
        // Исходный список животных
        List<String> animals = new ArrayList<>(Arrays.asList("dog", "cow", "horse", "sheep"));

        // Удаляем из списка все строки короче 4 символов,
        // передавая в removeIf анонимный класс, реализующий Predicate<String>.
        animals.removeIf(new Predicate<String>() {
            @Override
            public boolean test(String name) {
                // Вернуть true — значит элемент нужно удалить.
                return name.length() < 4;
            }
        });

        // Вывод очищенного списка
        System.out.println(animals); // Ожидается: [horse, sheep]
    }
}
 */