package com.javarush.task.task22.task2209;

import java.io.*;
import java.util.*;

/* 
Составить цепочку слов

В методе main считай с консоли имя файла, который содержит слова, разделенные пробелом.
В методе getLine используя StringBuilder расставь все слова в таком порядке, чтобы последняя буква данного слова совпадала с первой буквой следующего не учитывая регистр.
Каждое слово должно участвовать 1 раз.
Считай, что абсолютно все слова из исходного списка могут (и должны!) быть включены в результат (лишних слов нет).
Метод getLine должен возвращать любой правильный вариант при наличии нескольких таковых (см. пример).
Слова разделять пробелом.
Вывести полученную строку на экран.

Пример тела входного файла:
Киев Нью-Йорк Амстердам Вена Мельбурн

Результат:
Амстердам Мельбурн Нью-Йорк Киев Вена
или
Вена Амстердам Мельбурн Нью-Йорк Киев
или
Мельбурн Нью-Йорк Киев Вена Амстердам
и т.п.

Требования:
•	Метод main должен считывать имя файла с клавиатуры.
•	В классе Solution не должно быть статических полей.
•	В методе getLine должен быть использован StringBuilder.
•	Метод getLine должен возвращать пустую строку (пустой StringBuilder) в случае если ему не были переданы параметры (слова).
•	Метод getLine не должен изменять переданные ему параметры (слова).
•	Все слова переданные в метод getLine должны быть включены в результирующую строку.
•	Вывод на экран должен соответствовать условию задачи.


public class Solution {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedReader fileReader = new BufferedReader(new InputStreamReader(new FileInputStream(reader.readLine())))) {
            while (fileReader.ready()) {
                list.add(fileReader.readLine());
            }
        } catch (IOException ignored) {
        }

        List<String> resultList = new ArrayList<>();
        for (String line : list) {
            StringTokenizer tokenizer = new StringTokenizer(line);
            while (tokenizer.hasMoreTokens()) {
                resultList.add(tokenizer.nextToken());
            }
        }

        StringBuilder result = getLine(getWords(resultList));
        System.out.println(result.toString());
    }

    private static String[] getWords(List<String> list) {
        String[] array = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            array[i] = list.get(i);
        }
        return array;
    }

    private static boolean isTheSameChars(String firstWord, String secondWord) {
        if (firstWord.endsWith(" ")) {
            firstWord = firstWord.substring(0, firstWord.length() - 1);
        }
        return firstWord.isEmpty() || (secondWord != null &&
                Character.toUpperCase(firstWord.charAt(firstWord.length() - 1)) == Character.toUpperCase(secondWord.charAt(0)));
    }

    private static <T> T getLastElement(List<? extends T> list) {
        return list.get(list.size() - 1);
    }


    public static StringBuilder getLine(String... words) {
        StringBuilder builder = new StringBuilder();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            list.add(i);
            if (findSolutions(list, words)) {
                for (Integer integer : list) {
                    builder.append(words[integer]);
                    builder.append(" ");
                }
                return builder;
            }
            list.remove(Integer.valueOf(i));
        }

        return builder;
    }

    private static boolean findSolutions(List<Integer> list, String... words) {
        if (list.size() == words.length) {
            return true;
        }
        for (int i = 0; i < words.length; i++) {
            if (isValid(list, words[i], words)) {
                list.add(i);
                if (findSolutions(list, words)) {
                    return true;
                }
                list.remove(Integer.valueOf(i));
            }
        }
        return false;
    }

    private static boolean isValid(List<Integer> list, String word, String... words) {
        for (Integer integer : list) {
            if (words[integer].equals(word)) {
                return false;
            }
        }
        return isTheSameChars(words[getLastElement(list)], word);
    }

}
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //...
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
        String newFile = buff.readLine();
        BufferedReader fileReader = new BufferedReader(new FileReader(newFile));
        buff.close();
        String fullWord = null;
//        while (fileReader.ready()) {
            fullWord = fileReader.readLine();
            String[] cities = fullWord.split(" ");

            StringBuilder result = getLine(cities);
            System.out.println(result.toString());
    }

    public static StringBuilder getLine(String... words) {
        if (words.length == 0) return new StringBuilder();

        List<String> cities = new ArrayList<>(Arrays.asList(words));
        List<String> bestChain = new ArrayList<>();

        // Пробуем начать с каждого города
        for (String startCity : cities) {
            List<String> remaining = new ArrayList<>(cities);
            remaining.remove(startCity);

            List<String> chain = new ArrayList<>();
            chain.add(startCity);

            buildChain(chain, remaining);

            if (chain.size() > bestChain.size()) {
                bestChain = new ArrayList<>(chain);
            }
        }

        // Собираем результат
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < bestChain.size(); i++) {
            if (i > 0) result.append(" ");
            result.append(bestChain.get(i));
        }

        return result;
    }

    private static void buildChain(List<String> chain, List<String> remaining) {
        if (remaining.isEmpty()) return;

        String lastCity = chain.get(chain.size() - 1);
        char lastChar = getLastCharacter(lastCity);

        // Ищем город, который начинается на последнюю букву
        for (int i = 0; i < remaining.size(); i++) {
            String city = remaining.get(i);
            char firstChar = getFirstCharacter(city);

            if (Character.toLowerCase(lastChar) == Character.toLowerCase(firstChar)) {
                chain.add(city);
                remaining.remove(i);
                buildChain(chain, remaining);
                return;
            }
        }

        // Если не нашли подходящий город, пробуем вставить в начало
        String firstCity = chain.get(0);
        char firstChar = getFirstCharacter(firstCity);

        for (int i = 0; i < remaining.size(); i++) {
            String city = remaining.get(i);
            char cityLastChar = getLastCharacter(city);

            if (Character.toLowerCase(firstChar) == Character.toLowerCase(cityLastChar)) {
                chain.add(0, city);
                remaining.remove(i);
                buildChain(chain, remaining);
                return;
            }
        }

        // Если ничего не нашли, добавляем оставшиеся города в конец
        chain.addAll(remaining);
        remaining.clear();
    }

    private static char getLastCharacter(String city) {
        String clean = city.replace("-", "").toLowerCase();
        return clean.charAt(clean.length() - 1);
    }

    private static char getFirstCharacter(String city) {
        String clean = city.replace("-", "").toLowerCase();
        return clean.charAt(0);
    }
}

/*
public class Solution {
    public static void main(String[] args) {
        //...
        StringBuilder result = getLine();
        System.out.println(result.toString());
    }

    public static StringBuilder getLine(String... words) {
        return null;
    }
}
 */