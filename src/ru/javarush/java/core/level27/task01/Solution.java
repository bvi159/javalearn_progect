package ru.javarush.java.core.level27.task01;
/*
Поиск цвета в палитре 🎨
Представьте, что вы создаёте графический редактор, и вам нужно выбрать определённый цвет из заранее определённой палитры. Ваша палитра хранит цвета в виде названий.

Создайте переменную List<String>, используя LinkedList для хранения вашей палитры. Добавьте в эту палитру названия цветов: "красный", "зелёный" и "синий". Затем, чтобы отобразить выбранный цвет, получите второй элемент из вашей палитры (помните, что нумерация начинается с нуля, поэтому это будет элемент с индексом 1) и выведите его на экран.

Требования:
•	Переменная для палитры должна быть объявлена с типом List<String>.
•	Для создания палитры должна быть использована реализация LinkedList.
•	В палитру должны быть добавлены три элемента: "красный", "зелёный" и "синий".
•	Для получения выбранного цвета должен быть использован метод получения элемента по индексу (get).
•	На экран должен быть выведен второй элемент палитры (элемент с индексом 1, то есть "зелёный").

import java.util.LinkedList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        // Объявляем переменную палитры через интерфейс List,
        // а в качестве реализации используем LinkedList


        // Добавляем три цвета в палитру


        // Получаем второй элемент (индекс 1) методом get и выводим его

    }
}
 */
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        // Объявляем переменную палитры через интерфейс List,
        // а в качестве реализации используем LinkedList
        List<String> palitra = new LinkedList<>();
        palitra.add("красный");
        palitra.add("зелёный");
        palitra.add("синий");

        System.out.println(palitra.get(1));

        // Добавляем три цвета в палитру


        // Получаем второй элемент (индекс 1) методом get и выводим его

    }
}

/*
import java.util.List;
import java.util.LinkedList;

public class Solution {
    public static void main(String[] args) {
        // Объявляем переменную палитры через интерфейс List,
        // а в качестве реализации используем LinkedList
        List<String> palette = new LinkedList<>();

        // Добавляем три цвета в палитру
        palette.add("красный");
        palette.add("зелёный");
        palette.add("синий");

        // Получаем второй элемент (индекс 1) методом get и выводим его
        String selectedColor = palette.get(1);
        System.out.println(selectedColor);
    }
}
 */