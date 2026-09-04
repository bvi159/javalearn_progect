package com.javarush.examples.Lesson_10_8;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

//        FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\Username\\Desktop\\save.ser");
        FileOutputStream fileOutputStream = new FileOutputStream("save_10_8.ser");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

        UserInfo userInfo = new UserInfo("Ivan", "Ivanov", "Ivan Ivanov's passport data");

        objectOutputStream.writeObject(userInfo);
//        userInfo.writeExternal(objectOutputStream);

        objectOutputStream.close();
        //------------------------------
        FileInputStream fileInputStream = new FileInputStream("save_10_8.ser");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);


//        UserInfo userInfo1 = (UserInfo) objectInputStream.readObject();
        userInfo = (UserInfo) objectInputStream.readObject();
//        UserInfo userInfo1 = readExternal(objectInputStream);

        System.out.println(userInfo);

        objectInputStream.close();

    }
}
/*
тут мои файлы создаются по умолчанию, если просто задать имя файла.
C:\Users\Vic_host.BIG\javarush\3536038\javarush-project

Файл family.ser создаётся в рабочей директории вашего Java-проекта (обычно это корневая папка проекта или папка, из которой запускается программа).

Где именно создаётся файл?
Если запуск из IDE (IntelliJ IDEA, Eclipse и др.)

Файл появится в корневой папке проекта (там, где лежат src/, pom.xml и т. д.).

Пример пути:

text
C:\Users\ВашеИмя\IdeaProjects\YourProject\family.ser
Если запуск из командной строки

Файл создастся в текущей директории, откуда запускается java Solution.

Пример:

text
C:\Users\ВашеИмя\> java Solution  → файл появится в C:\Users\ВашеИмя\family.ser
Если указан абсолютный путь

java
String filename = "C:\\data\\family.ser";  // Windows
// или
String filename = "/home/user/family.ser"; // Linux/Mac
→ тогда файл сохранится точно по указанному пути.

 */