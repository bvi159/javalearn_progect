package ru.javarush.java.core.level48.task03;
/*
Система "КРИКЛИВЫХ" Продуктов 📢
Представьте, что вы разрабатываете новую, ультрасовременную систему инвентаризации для супермаркета. Старые, скучные названия товаров (такие как "молоко", "сыр", "хлеб") больше не подходят для ваших ярких, мигающих табло. Вам нужно, чтобы каждое название буквально "кричало" о себе, то есть отображалось заглавными буквами!

Ваша задача состоит в том, чтобы взять существующий список названий продуктов. Затем, используя мощный метод replaceAll и короткое, но эффективное лямбда-выражение, пройтись по каждому названию в списке и преобразовать его в верхний регистр. После этого, гордо выведите на экран ваш преобразованный список, чтобы все увидели, насколько "громкими" стали названия ваших товаров.

Требования:
•	В программе должен использоваться метод replaceAll для преобразования элементов списка.
•	В метод replaceAll должен быть передан лямбда-выражение для преобразования строки в верхний регистр.
•	Каждое название продукта в исходном списке должно быть преобразовано в строку верхнего регистра.
•	Преобразованный список названий продуктов должен быть выведен на экран.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        // Исходный список названий продуктов
        List<String> products = new ArrayList<>(Arrays.asList(
                "молоко", "сыр", "хлеб", "йогурт", "яблоко"
        ));

        // Преобразуем каждое название в верхний регистр с помощью replaceAll и лямбды


        // Выводим преобразованный список на экран

    }
}

 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        // Исходный список названий продуктов
        List<String> products = new ArrayList<>(Arrays.asList(
                "молоко", "сыр", "хлеб", "йогурт", "яблоко"
        ));

        // Преобразуем каждое название в верхний регистр с помощью replaceAll и лямбды
        products.replaceAll(s -> {
            return s.toUpperCase();
        } );

        // Выводим преобразованный список на экран
        System.out.println(products);

    }
}

/*
package ru.javarush.java.core.level48.task03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        // Исходный список названий продуктов
        List<String> products = new ArrayList<>(Arrays.asList(
                "молоко", "сыр", "хлеб", "йогурт", "яблоко"
        ));

        // Преобразуем каждое название в верхний регистр с помощью replaceAll и лямбды
        products.replaceAll(s -> s.toUpperCase());

        // Выводим преобразованный список на экран
        System.out.println(products);
    }
}
 */