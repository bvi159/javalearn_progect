package com.javarush.task.task22.task2202;

/* 
Найти подстроку
public class Solution {
    public static void main(String[] args) {
        System.out.println(getPartOfString("JavaRush - лучший сервис обучения Java."));
    }

    public static String getPartOfString(String string) {
        if (string == null) {
            throw new TooShortStringException();
        }
        String[] splitWithSpaces = string.split(" ");

        if (splitWithSpaces.length < 5) throw new TooShortStringException();
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 1; i < 5; i++) {
            stringBuilder.append(splitWithSpaces[i]);
            stringBuilder.append(" ");
        }
        return stringBuilder.toString().trim();
    }

    public static class TooShortStringException extends RuntimeException {
    }
}

У меня тоже правильно

*/

public class Solution {
    public static void main(String[] args) throws TooShortStringException {
        System.out.println(getPartOfString("JavaRush - лучший сервис обучения Java."));
    }

    public static String getPartOfString(String string) throws TooShortStringException {
//        int firstTab = string.indexOf(" ");
//        int secondTab = string.lastIndexOf(" ");
        if(string == null){
            throw new TooShortStringException();
        }
//        String substr = string.substring(firstTab +1, secondTab);
//        return substr;

        String[] splitWithSpace = string.split(" ");
        if(splitWithSpace.length <= 4){
            throw new TooShortStringException();
        }
        return splitWithSpace[1] + " " + splitWithSpace[2]+ " "
               + splitWithSpace[3]+ " "  + splitWithSpace[4];
    }

    public static class TooShortStringException extends RuntimeException {
    }
}
