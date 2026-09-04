package com.javarush.examples.Lesson_10_7;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        //создаем наш объект
        TerritoriesInfo territoriesInfo = new TerritoriesInfo("У Испании 6 провинций, у России 10 провинций, у Франции 8 провинций");
        ResourcesInfo resourcesInfo = new ResourcesInfo("У Испании 100 золота, у России 180 золота, у Франции 90 золота");
        DiplomacyInfo diplomacyInfo =  new DiplomacyInfo("Франция воюет с Россией, Испания заняла позицию нейтралитета");


        SavedGame savedGame = new SavedGame(territoriesInfo, resourcesInfo, diplomacyInfo);

//        FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\Username\\Desktop\\save.ser");
        FileOutputStream fileOutputStream = new FileOutputStream("save.ser");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

        objectOutputStream.writeObject(savedGame);

        objectOutputStream.close();
       //----------------------------
        FileInputStream fileInputStream = new FileInputStream("save.ser");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

        SavedGame savedGame1 = (SavedGame) objectInputStream.readObject();

        System.out.println(savedGame1);

        objectInputStream.close();


    }
}
/*
import java.io.*;


public class com.javarush.examples.Lesson_10_7.Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        //создаем наш объект
        String[] territoryInfo = {"У Испании 6 провинций", "У России 10 провинций", "У Франции 8 провинций"};
        String[] resourcesInfo = {"У Испании 100 золота", "У России 80 золота", "У Франции 90 золота"};
        String[] diplomacyInfo = {"Франция воюет с Россией, Испания заняла позицию нейтралитета"};

        com.javarush.examples.Lesson_10_7.SavedGame savedGame = new com.javarush.examples.Lesson_10_7.SavedGame(territoryInfo, resourcesInfo, diplomacyInfo);

        //создаем 2 потока для сериализации объекта и сохранения его в файл
//        FileOutputStream outputStream = new FileOutputStream("C:\\Users\\Username\\Desktop\\save.ser");
        FileOutputStream outputStream = new FileOutputStream("save.ser");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);

        // сохраняем игру в файл
        objectOutputStream.writeObject(savedGame);

        //закрываем поток и освобождаем ресурсы
        objectOutputStream.close();

//создаем 2 потока для десериализации объекта и сохранения его в файл
//        FileInputStream fileInputStream = new FileInputStream("C:\\Users\\Username\\Desktop\\save.ser");
        FileInputStream fileInputStream = new FileInputStream("save.ser");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

        com.javarush.examples.Lesson_10_7.SavedGame savedGame1 = (com.javarush.examples.Lesson_10_7.SavedGame) objectInputStream.readObject();

        System.out.println(savedGame1);


    }
}
 */