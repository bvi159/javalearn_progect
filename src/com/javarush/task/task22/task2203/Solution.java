package com.javarush.task.task22.task2203;

/* 
Между табуляциями
public class Solution {
    public static void main(String[] args) throws Exception {
        System.out.println(getPartOfString("\tJavaRush - лучший сервис \tобучения Java\t."));
    }

    public static String getPartOfString(String string) throws TooShortStringException {
        if (string == null) {
            throw new TooShortStringException();
        }
        String[] splitWithTabs = string.split("\\t");

        if (splitWithTabs.length < 3) throw new TooShortStringException();

        return splitWithTabs[1];
    }

    public static class TooShortStringException extends Exception {
    }
}
У меня тоже правильно

*/

public class Solution {
    public static String getPartOfString(String string) throws TooShortStringException {
        if(string == null){
            throw new TooShortStringException();
        }
        int firstTab = string.indexOf("\t");
        int secondTab = string.indexOf("\t", firstTab + 1);
        if(string == null || firstTab == -1 || secondTab == -1){
            throw new TooShortStringException();
        }
        String substr = string.substring(firstTab +1, secondTab);
        return substr;
    }

    public static class TooShortStringException extends Exception {
    }

    public static void main(String[] args) throws TooShortStringException {
//        System.out.println("\tJavaRush - лучший сервис \tобучения Java\t.");
        System.out.println(getPartOfString("\tJavaRush - лучший сервис \tобучения Java\t."));

    }
}
/*
public class Solution {
    public static String getPartOfString(String string) {
        return null;
    }

    public static class TooShortStringException extends Exception {
    }

    public static void main(String[] args) throws TooShortStringException {
        System.out.println(getPartOfString("\tJavaRush - лучший сервис \tобучения Java\t."));
    }
}

 */