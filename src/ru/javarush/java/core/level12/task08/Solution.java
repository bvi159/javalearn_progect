package ru.javarush.java.core.level12.task08;
/*
Подсчёт количества слов в тексте
Вы — аналитик текста и вам поручено выяснить, какие слова чаще всего встречаются в коротком текстовом фрагменте. Ваша цель — подсчитать вхождения каждого слова.

Возьмите заданную строку текста: String textContent = "java core java map".

Создайте ассоциативный массив (HashMap), где ключом будет каждое уникальное слово (String), а значением — количество его вхождений в тексте (Integer).

После того как вы подсчитаете все слова, пройдитесь по вашему словарю и выведите на экран каждую пару "слово: количество", чтобы представить полный анализ частотности слов в тексте.

Требования:
•	В задаче должен использоваться ассоциативный массив (HashMap), где ключами являются уникальные слова из текста, а значениями — количество их вхождений.
•	Строка textContent должна быть разбита на отдельные слова для дальнейшего анализа.
•	Для каждого слова из строки textContent необходимо увеличить соответствующее значение в HashMap на 1 при каждом появлении слова.
•	После подсчёта всех слов необходимо пройтись по всем элементам HashMap и вывести на экран каждую пару "слово: количество".
public class Solution {
    public static void main(String[] args) {
        // Исходный текст для анализа
        String textContent = "java core java map";

        // Создаем HashMap для хранения статистики слов


        // Разбиваем текст на слова, используя пробел как разделитель


        // Подсчитываем количество вхождений каждого слова

            // Получаем значение из словаря


            // Если слово уже есть в HashMap, увеличиваем его счетчик


        // Выводим результаты подсчета на экран

    }
}

 */
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        // Исходный текст для анализа
        String textContent = "java core java map";

        // Создаем HashMap для хранения статистики слов
        HashMap<String, Integer> myStatistic = new HashMap<>();

        // Разбиваем текст на слова, используя пробел как разделитель
        String[] mywords = textContent.split(" ");

        // Подсчитываем количество вхождений каждого слова

            // Получаем значение из словаря
        for (String tekWord : mywords) {
            //int i = 1;
            if (!myStatistic.containsKey(tekWord)) {
                myStatistic.put(tekWord, 1);
            } else {
                myStatistic.put(tekWord, myStatistic.get(tekWord) + 1);
            }
        }

            // Если слово уже есть в HashMap, увеличиваем его счетчик


        // Выводим результаты подсчета на экран
        //System.out.println(Arrays.toString(mywords));
        //        System.out.println(myStatistic);
        for (Map.Entry<String, Integer> tekElement : myStatistic.entrySet()) {
            System.out.println(tekElement.getKey() + ": " + tekElement.getValue());
//            System.out.println(tekElement);
        }

    }
}

/*
Ихнее решение
public class Solution {
    public static void main(String[] args) {
        // Исходный текст для анализа
        String textContent = "java core java map";

        // Создаем HashMap для хранения статистики слов
        HashMap<String, Integer> wordCountMap = new HashMap<>();

        // Разбиваем текст на слова, используя пробел как разделитель
        String[] words = textContent.split(" ");

        // Подсчитываем количество вхождений каждого слова
        for (String word : words) {
            // Получаем значение из словаря
            Integer count = wordCountMap.getOrDefault(word, 0);

            // Если слово уже есть в HashMap, увеличиваем его счетчик
            wordCountMap.put(word, count + 1);
        }

        // Выводим результаты подсчета на экран
        for (var entry : wordCountMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
*/
