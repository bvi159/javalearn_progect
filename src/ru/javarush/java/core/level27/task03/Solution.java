package ru.javarush.java.core.level27.task03;

/*
Словарь инопланетных языков 👽

Представьте, что вы работаете над созданием универсального переводчика для межгалактических путешественников. Вам нужно отобразить все известные переводы из английского на русский.
Создайте HashMap<String, String>, чтобы хранить пары "английское слово" — "русский перевод". Заполните свой словарь такими переводами: "dog" — "собака", "cat" — "кошка" и "bird" — "птица". После этого, чтобы показать пользователю все переводы, которые у вас есть, пройдитесь по каждой паре ключ-значение в вашем словаре. Для каждой найденной пары выведите её на экран в удобном для чтения формате, например, "dog = собака".

Требования:
•	В программе должен быть создан объект HashMap<String, String> для хранения пар "английское слово" — "русский перевод".
•	В HashMap необходимо добавить три пары: "dog" — "собака", "cat" — "кошка", "bird" — "птица".
•	Для перебора всех элементов словаря требуется использовать итератор или for-each цикл по entrySet().
•	Каждая пара ключ-значение должна быть выведена на экран в формате "dog = собака", "cat = кошка" и т.д.

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        // Создаём словарь переводов: английское слово -> русский перевод


        // Заполняем словарь тремя парами


        // Перебираем пары через for-each по entrySet()
        // (под капотом используется Iterator, что и требуется по условию)

            // Форматированный вывод в виде "ключ = значение"


    }
}

 */

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        // Создаём словарь переводов: английское слово -> русский перевод
        Map<String, String> allTranslations = new HashMap<>();
        // Заполняем словарь тремя парами
        allTranslations.put("dog","собака");
        allTranslations.put("cat","кошка");
        allTranslations.put("bird","птица");

        for (var e : allTranslations.entrySet())
            System.out.println(e.getKey()+" = "+e.getValue());

        // Перебираем пары через for-each по entrySet()
        // (под капотом используется Iterator, что и требуется по условию)

            // Форматированный вывод в виде "ключ = значение"


    }
}

/*
public class Solution {
    public static void main(String[] args) {
        // Создаём словарь переводов: английское слово -> русский перевод
        HashMap<String, String> dictionary = new HashMap<>();

        // Заполняем словарь тремя парами
        dictionary.put("dog", "собака");
        dictionary.put("cat", "кошка");
        dictionary.put("bird", "птица");

        // Перебираем пары через for-each по entrySet()
        // (под капотом используется Iterator, что и требуется по условию)
        for (Map.Entry<String, String> entry : dictionary.entrySet()) {
            // Форматированный вывод в виде "ключ = значение"
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
    }
}
 */