package ru.javarush.java.core.level37.task01;

import java.nio.charset.StandardCharsets;

/*
Подготовка секретного сообщения для передачи 🕵️‍♂️

Представьте, что вы — цифровой шпион, и вам нужно подготовить важное secretMessage "Привет" для безопасной передачи через защищенную сеть.
Прежде чем сообщение сможет отправиться в путь, оно должно быть преобразовано в последовательность raw encodedBytes, представляющих собой самые фундаментальные единицы цифровой информации.
Ваша миссия — внимательно изучить этот процесс, используя мощную кодировку UTF-8. После применения метода getBytes("UTF-8") к вашему secretMessage, вы получите массив encodedBytes.
Отобразите каждый byteValue из этого массива на новой строке, словно вы пошагово разбираете каждый элемент сообщения, чтобы убедиться в его полной готовности к отправке.

Требования:
•	В программе должна быть объявлена переменная secretMessage со значением "Привет".
•	Переменная secretMessage должна быть преобразована в массив байтов encodedBytes с использованием метода getBytes и кодировки "UTF-8".
•	Каждое значение byteValue из массива encodedBytes должно быть выведено на экран с новой строки.
•	Для преобразования строки в массив байтов обязательно должна быть использована именно кодировка "UTF-8".
 */
public class Solution {
    public static void main(String[] args) throws Exception {
        // Сообщение, которое нужно закодировать
        String secretMessage = "Привет";


        // Преобразуем строку в массив байтов в кодировке UTF-8
        byte[] encodedBytes = secretMessage.getBytes(StandardCharsets.UTF_8);


        // Выводим каждый байт на новой строке
        for (byte b : encodedBytes) {
            System.out.println(b);
        }

    }
}
/*
public class Solution {
    public static void main(String[] args) throws Exception {
        // Сообщение, которое нужно закодировать
        String secretMessage = "Привет";

        // Преобразуем строку в массив байтов в кодировке UTF-8
        byte[] encodedBytes = secretMessage.getBytes("UTF-8");

        // Выводим каждый байт на новой строке
        for (byte byteValue : encodedBytes) {
            System.out.println(byteValue);
        }
    }
}
 */