package ru.javarush.java.core.level24.task14;
/*
Настройки игры: Единая реакция на сбои загрузки

Ваша новая игра загружает настройки из файла "game_config.txt". Эти настройки могут быть либо недоступны из-за проблем с файлом, либо "испорчены", если, например, вместо числа уровня сложности там оказалась буква. В любом из этих случаев, вам не столь важно, что именно произошло, главное — дать игроку понять, что загрузка настроек не удалась.
Реализуйте программу, которая попытается открыть файл "game_config.txt", прочитать первую строку и преобразовать её в целое число, например, для определения уровня сложности игры.
Используйте один, но очень умный catch-блок, который сможет обрабатывать сразу несколько типов проблем: как проблемы с файлом (IOException), так и проблемы с преобразованием данных (NumberFormatException). Если любая из этих ситуаций произойдёт, ваша программа должна вывести обобщённое, но понятное сообщение: "Ошибка: " и далее добавить техническое описание произошедшего с помощью метода, который возвращает сообщение об исключении (e.getMessage()).
Таким образом, вы сможете сообщить игроку общим текстом, неважно, что именно произошло, главное — дать знать, что загрузка не удалась, и предоставить некоторую информацию для диагностики.

Требования:
•	Программа должна попытаться открыть файл с именем "game_config.txt" для чтения.
•	Программа должна считать первую строку из файла "game_config.txt".
•	Программа должна попытаться преобразовать первую строку из файла в целое число (int).
•	Программа должна использовать один catch-блок для обработки как IOException, так и NumberFormatException.
•	В случае возникновения любого из указанных исключений программа должна вывести на экран строку, начинающуюся с "Ошибка: ", а далее — сообщение исключения, используя метод e.getMessage().

public class Solution {
    public static void main(String[] args) {
        // try-with-resources автоматически закроет файл после работы

                // Читаем первую строку настроек

            // Если строка отсутствует, считаем это ошибкой формата


            // Преобразуем строку в число (может выбросить NumberFormatException)


            // Для наглядности покажем загруженное значение



        // Один "умный" catch обрабатывает сразу два типа проблем:

    }
}

 */

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        try (BufferedReader myBuff = new BufferedReader(new FileReader("game_config.txt"))) {
//        try (InputStream inputStream = Solution.class.getResourceAsStream("game_config.txt");
//             BufferedReader myBuff = new BufferedReader(new InputStreamReader(inputStream))) {
            String fisrtLine = myBuff.readLine();
            if (fisrtLine != null) {
                int transactionAmmount = Integer.parseInt(fisrtLine);
            } else {
                throw new NumberFormatException("Файл пустой!");
            }

        } catch (IOException | NumberFormatException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
    // try-with-resources автоматически закроет файл после работы

    // Читаем первую строку настроек

    // Если строка отсутствует, считаем это ошибкой формата


    // Преобразуем строку в число (может выбросить NumberFormatException)


    // Для наглядности покажем загруженное значение


    // Один "умный" catch обрабатывает сразу два типа проблем:

}

/*
public class Solution {
    public static void main(String[] args) {
        // try-with-resources автоматически закроет файл после работы
        try (BufferedReader reader = new BufferedReader(new FileReader("game_config.txt"))) {
            String firstLine = reader.readLine(); // Читаем первую строку настроек

            // Если строка отсутствует, считаем это ошибкой формата
            if (firstLine == null) {
                throw new NumberFormatException("Первая строка отсутствует или файл пустой");
            }

            // Преобразуем строку в число (может выбросить NumberFormatException)
            int difficulty = Integer.parseInt(firstLine.trim());

            // Для наглядности покажем загруженное значение
            System.out.println("Уровень сложности: " + difficulty);
        }

        // Один "умный" catch обрабатывает сразу два типа проблем:
        catch (IOException | NumberFormatException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}
 */
