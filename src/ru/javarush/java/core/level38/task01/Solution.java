package ru.javarush.java.core.level38.task01;
/*
Поиск потерянной записи в древней библиотеке 📚

Представьте, что вы — смотритель гигантской цифровой библиотеки. К вам пришёл читатель и запросил редкую запись "missing.txt", но вы подозреваете, что её там просто нет или она была удалена. Вам нужно написать небольшую программу-помощника, которая попытается отыскать эту запись с помощью FileReader.
Если программа выяснит, что записи под таким именем нет и её невозможно открыть, она должна сообщить об этом, выведя на экран "Файл не найден". Но если в процессе поиска или попытки доступа к файлу возникнет какая-то другая, непредсказуемая проблема с системой хранения данных (любая ошибка ввода-вывода, кроме отсутствия файла), то ваш помощник должен проинформировать об этом, выдав сообщение "Ошибка ввода-вывода".

Требования:
•	Программа должна использовать класс FileReader для попытки открытия файла "missing.txt".
•	Если при попытке открыть файл возникнет исключение FileNotFoundException, программа должна вывести сообщение "Файл не найден".
•	Если при попытке работы с файлом возникнет любое другое исключение IOException (не FileNotFoundException), программа должна вывести сообщение "Ошибка ввода-вывода".
•	Программа должна корректно закрывать FileReader при необходимости (например, с использованием try-with-resources или вызова close()).

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) {
        // Пытаемся открыть файл "missing.txt" с помощью FileReader.
        // Используем try-with-resources, чтобы гарантировать закрытие ресурса.

    }
}
 */

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) {
        // Пытаемся открыть файл "missing.txt" с помощью FileReader.
        // Используем try-with-resources, чтобы гарантировать закрытие ресурса.
        try (FileReader file = new FileReader("missing.txt")) {

        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден");
        } catch (IOException e) {
            System.out.println("Ошибка ввода-вывода");
        }

    }
}
/*
public class Solution {
    public static void main(String[] args) {
        // Пытаемся открыть файл "missing.txt" с помощью FileReader.
        // Используем try-with-resources, чтобы гарантировать закрытие ресурса.
        try (FileReader reader = new FileReader("missing.txt")) {
            // Для явного доступа к файлу попробуем прочитать хотя бы один символ.
            // Значение нам не важно: задача — продемонстрировать работу с файлом.
            reader.read();
        } catch (FileNotFoundException e) {
            // Если файл не существует или недоступен по имени — сообщаем об этом
            System.out.println("Файл не найден");
        } catch (IOException e) {
            // Любая другая ошибка ввода-вывода
            System.out.println("Ошибка ввода-вывода");
        }
    }
}
 */