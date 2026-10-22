package ru.javarush.java.core.level48.task04;

/*
Экспедиция "Великие Воды" 🗺️
Вы — ведущий картограф в экспедиции "Великие Воды", и ваша задача — создать карту только самых значительных и заметных водных объектов.

У вас есть предварительный список "река", "море", "озеро", "ручей", "пруд", но для вашей карты подходят лишь названия, которые, как вы считаете, достаточно длинные, чтобы быть важными (более 4 символов).

А чтобы они выделялись еще сильнее, вы хотите написать их заглавными буквами!

Примените современный инструмент — Stream API — для этой задачи. Сначала тщательно отфильтруйте список, оставив только те названия водных объектов, длина которых превышает 4 символа. Затем, как истинный мастер картографии, преобразуйте все эти важные названия к верхнему регистру, чтобы они выглядели максимально внушительно. Наконец, соберите эти преобразованные названия в совершенно новый список и гордо представьте его на экране, демонстрируя ваш идеальный отбор "Великих Вод".

Требования:
•	Для обработки списка необходимо использовать Stream API.
•	Список должен быть отфильтрован так, чтобы остались только те элементы, длина которых больше 4 символов.
•	Каждое отобранное название должно быть преобразовано в верхний регистр.
•	Преобразованные названия должны быть собраны в новый список.
•	Новый список с преобразованными названиями должен быть выведен на экран.

import java.util.List;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        // Исходный список водных объектов
        List<String> waterBodies = List.of("река", "море", "озеро", "ручей", "пруд");

        // Используем Stream API:


        // Выводим итоговый список на экран

    }
}


 */

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        // Исходный список водных объектов
        List<String> waterBodies = List.of("река", "море", "озеро", "ручей", "пруд");

        // Используем Stream API:
        List<String> greatWaters = waterBodies.stream()
                .filter(s -> s.length() > 4)
                .map(s -> s.toUpperCase())
                .collect(Collectors.toList());


        // Выводим итоговый список на экран
        System.out.println(greatWaters);

    }
}

/*
package ru.javarush.java.core.level48.task04;

import java.util.List;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        // Исходный список водных объектов
        List<String> waterBodies = List.of("река", "море", "озеро", "ручей", "пруд");

        // Используем Stream API:
        List<String> greatWaters = waterBodies.stream()
                .filter(name -> name.length() > 4) // оставляем только "достаточно длинные"
                .map(String::toUpperCase)          // делаем названия "внушительными"
                .collect(Collectors.toList());     // собираем в новый список

        // Выводим итоговый список на экран
        System.out.println(greatWaters);
    }
}
 */