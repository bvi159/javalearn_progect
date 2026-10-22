package ru.javarush.java.core.level48.task01;
/*
Мастерская по сортировке названий 📜
Представьте, что вы — главный сортировщик в волшебной мастерской, где хранится огромное количество предметов с самыми необычными названиями. Ваша задача — не просто разложить их по алфавиту, а рассортировать по длине названий, чтобы самые короткие предметы стояли впереди.

Чтобы выполнить эту задачу, вам потребуется создать особую инструкцию для сравнения названий. Определите переменную, способную хранить этот "сравнитель" (Comparator<String>), используя лямбда-выражение. Эта инструкция должна принимать два названия и решать, какое из них короче, чтобы предметы правильно выстроились.

Затем, примените эту магическую инструкцию к списку из названий "cat", "elephant", "dog". В конце вашей работы, представьте миру (выведите на экран) отсортированный список, чтобы все увидели, как короткие названия встали перед длинными.

Требования:
•	В программе должна быть объявлена переменная типа Comparator<String>, реализованная с использованием лямбда-выражения.
•	Лямбда-выражение должно сравнивать две строки по их длине, чтобы более короткая строка считалась "меньше".
•	В программе должен быть создан список строк, содержащий элементы "cat", "elephant", "dog".
•	Список строк должен быть отсортирован с использованием ранее определённого компаратора, сравнивающего длины строк.
•	После сортировки программа должна вывести отсортированный список строк на экран.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        // Компаратор, который сравнивает строки по их длине (короче — "меньше")


        // Создаем список строк
        List<String> names = new ArrayList<>(Arrays.asList("cat", "elephant", "dog"));

        // Сортируем список с использованием нашего компаратора


        // Выводим отсортированный список

    }
}

 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        // Компаратор, который сравнивает строки по их длине (короче — "меньше")
        Comparator<String> comp = (a, b) -> a.length() - b.length();

        // Создаем список строк
        List<String> names = new ArrayList<>(Arrays.asList("cat", "elephant", "dog"));

        // Сортируем список с использованием нашего компаратора
//        names.sort((a, b) -> a.length() - b.length());
        names.sort(comp);


        // Выводим отсортированный список
        System.out.println(names);

    }
}
/*

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        // Компаратор, который сравнивает строки по их длине (короче — "меньше")
        Comparator<String> byLength = (a, b) -> Integer.compare(a.length(), b.length());

        // Создаем список строк
        List<String> names = new ArrayList<>(Arrays.asList("cat", "elephant", "dog"));

        // Сортируем список с использованием нашего компаратора
        names.sort(byLength);

        // Выводим отсортированный список
        System.out.println(names);
    }
}

 */