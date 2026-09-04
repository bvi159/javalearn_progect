package com.javarush.task.task22.task2207;

import java.io.*;
import java.util.*;

/* 
Обращенные слова
В методе main с консоли считать имя файла, который содержит слова, разделенные пробелами.
Найти в тексте все пары слов, которые являются обращением друг друга. Добавить их в result.
Использовать StringBuilder.
Кодировка файла - UTF-8.

Пример содержимого файла
рот тор торт о
о тот тот тот

Вывод:
рот тор
о о
тот тот

Требования:
•	Метод main должен считывать имя файла с клавиатуры.
•	В методе main должен быть использован StringBuilder.
•	В классе Solution должен содержаться вложенный класс Pair с методами equals, hashCode и toString. Удалять или изменять эти методы нельзя.
•	В классе Pair должен быть объявлен конструктор без параметров (или конструктор по умолчанию).
•	Список result должен быть заполнен корректными парами согласно условию задачи.



*/
//java надо найти в тексте пары слов, которые являются обращением друг друга по программе

public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fileReader = new BufferedReader(new FileReader(bufferedReader.readLine()));
        bufferedReader.close();

        Set<String> unverified = new HashSet<>();

        while (fileReader.ready()) {
            String[] data = fileReader.readLine().split(" ");
            for (String word : data) {
                if (word.isEmpty()) continue; // Пропускаем пустые строки

                StringBuilder stringBuilder = new StringBuilder(word);
                stringBuilder.reverse();
                String reversedWord = stringBuilder.toString();

                if (unverified.contains(reversedWord)) {
                    unverified.remove(reversedWord);
                    Pair pair = new Pair();
                    pair.first = word;
                    pair.second = reversedWord;
                    result.add(pair);
                } else {
                    unverified.add(word);
                }
            }
        }
        fileReader.close();

        // Вывод результата
        for (Pair pair : result) {
            System.out.println(pair);
        }
    }

    public static class Pair {
        String first;
        String second;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (first != null ? !first.equals(pair.first) : pair.first != null) return false;
            return second != null ? second.equals(pair.second) : pair.second == null;

        }

        @Override
        public int hashCode() {
            int result = first != null ? first.hashCode() : 0;
            result = 31 * result + (second != null ? second.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return first == null && second == null ? "" :
                    first == null ? second :
                            second == null ? first :
                                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
/*
  BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();
        String fileName3 = reader.readLine();

        try (FileOutputStream fileOutputStream = new FileOutputStream(fileName1);
             FileInputStream fileInputStream1 = new FileInputStream(fileName2);
             FileInputStream fileInputStream2 = new FileInputStream(fileName3)) {
            while (fileInputStream1.available() > 0) {
                fileOutputStream.write(fileInputStream1.read());
            }
            while (fileInputStream2.available() > 0) {
                fileOutputStream.write(fileInputStream2.read());
            }
        }

---------------------------------
public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) {

    }

    public static class Pair {
        String first;
        String second;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()){
                return false;
            }

            Pair pair = (Pair) o;

            if (first != null ? !first.equals(pair.first) : pair.first != null) {
                return false;
            }

            return second != null ? second.equals(pair.second) : pair.second == null;

        }

        @Override
        public int hashCode() {
            int result = first != null ? first.hashCode() : 0;
            result = 31 * result + (second != null ? second.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return first == null && second == null ? "" :
                    first == null ? second :
                            second == null ? first :
                                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
 */