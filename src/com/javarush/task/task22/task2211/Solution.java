package com.javarush.task.task22.task2211;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/*
В метод main первым параметром приходит имя файла, тело которого в кодировке Windows-1251.
В метод main вторым параметром приходит имя файла, в который необходимо записать содержимое первого файла в кодировке UTF-8.

Требования:
•	Программа НЕ должна считывать данные с клавиатуры.
•	Программа НЕ должна выводить данные на экран.
•	Программа должна записывать данные в файл.
•	Содержимое второго файла должно соответствовать содержимому первого файла за исключением кодировки(UTF-8).


Смена кодировки
public class Solution {
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(args[0]), "Windows-1251"));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(args[1]), StandardCharsets.UTF_8))) {

            String s;
            while ((s = reader.readLine()) != null) {
                writer.write(s + "\n");
            }
        }
    }
}


*/

public class Solution {
    public static void main(String[] args) throws IOException {
        String file1 = args[0];
        String file2 = args[1];
            Charset windows1251 = Charset.forName("Windows-1251");
            Charset utf8 = Charset.forName("UTF-8");

            try (BufferedReader inputStream = new BufferedReader(
                    new InputStreamReader(new FileInputStream(file1), windows1251));
                 BufferedWriter outputStream = new BufferedWriter(
                         new OutputStreamWriter(new FileOutputStream(file2), utf8))) {

                    char[] buffer = new char[1024];
                    int bytesRead;

                    while ((bytesRead = inputStream.read(buffer)) != -1) {
                            String s = new String(buffer, 0, bytesRead);
                            outputStream.write(s);
                    }
            }
    }
}


//        String s = new String(myBuff, windows1251);
//        System.out.println(s);

//        System.out.println(Arrays.toString(myBuff));


//byte[] myBuff; // = reader.readLine().getBytes(windows1251);
//            String line1;
//            String s;
//            while ((line1 = reader.readLine()) != null) {
//                myBuff = line1.getBytes(windows1251);
//                s = new String(myBuff, UTF8);
//                writer.write(s);


//        byte[] buffer = s.getBytes(UTF8);
//        outputStream.write("Фсем Привет!");
//byte[] buffer = new byte[1000];
//        inputStream.read();
//        outputStream.write(myBuff.toString());

//        byte[] buffer = inutFileReader.toString().getBytes("Windows-1251");



// buff.close();