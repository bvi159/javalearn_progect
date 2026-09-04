package com.javarush.task.task22.task2210;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/* 
StringTokenizer

Используя StringTokenizer разделить query на части по разделителю delimiter.

Пример
getTokens("level22.lesson13.task01", ".")

возвращает массив строк
{"level22", "lesson13", "task01"}

Требования:
•	Метод getTokens должен использовать StringTokenizer.
•	Метод getTokens должен быть публичным.
•	Метод getTokens должен принимать два параметра типа String.
•	Массив типа String возвращенный методом getTokens должен быть заполнен правильно(согласно условию задачи).

public class Solution {
    public static void main(String[] args) {
    }

    public static String[] getTokens(String query, String delimiter) {
        StringTokenizer stringTokenizer = new StringTokenizer(query, delimiter);
        String[] result = new String[stringTokenizer.countTokens()];
        int i = 0;
        while (stringTokenizer.hasMoreTokens()) {
            result[i++] = stringTokenizer.nextToken();
        }
        return result;
    }
}

*/

public class Solution {
    public static void main(String[] args) {
        String myString = "level22 .lesson13 .task01";
        String[] myMass = myString.split("\\.");
        System.out.println(Arrays.toString(myMass));
//        System.out.println(myMass.toString());
        myMass = getTokens(myString, ".");
        System.out.println(Arrays.toString(myMass));
    }

    public static String[] getTokens(String query, String delimiter) {
        StringTokenizer tokenizer = new StringTokenizer(query, delimiter);
        List<String> myNewList = new ArrayList<>();
        while (tokenizer.hasMoreTokens())
        {
            String token = tokenizer.nextToken();
            myNewList.add(token);
        }

        return myNewList.toArray(new String[myNewList.size()]);
    }
}
/*
public class Solution {
    public static void main(String[] args) {

    }

    public static String[] getTokens(String query, String delimiter) {
        return null
    }
}
 */