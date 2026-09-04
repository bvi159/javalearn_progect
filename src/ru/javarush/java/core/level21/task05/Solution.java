package ru.javarush.java.core.level21.task05;
/*
Конвертер идентификаторов устройств 📟

Представьте, что вы разрабатываете прошивку для нового смарт-устройства. У каждого устройства есть числовой идентификатор, но для внутреннего логирования и диагностики вам часто требуется его шестнадцатеричное представление.
Вам нужно создать универсальный конвертер, который может принимать целое число и возвращать его строковое представление в шестнадцатеричном формате. Для максимально элегантного решения используйте ссылку на уже существующий статический метод Java, который выполняет именно такую операцию. Примените ваш конвертер к числу 255 и выведите полученный шестнадцатеричный код на экран.

Требования:
•	Для преобразования числа в шестнадцатеричную строку должна быть использована ссылка на существующий статический метод Java.
•	Конвертер должен принимать на вход значение типа int.
•	Конвертер должен возвращать строку с шестнадцатеричным представлением числа.
•	Необходимо применить конвертер к числу 255.
•	Результат преобразования (шестнадцатеричная строка числа 255) должен быть выведен на экран.

public class Solution {
    public static void main(String[] args) {
        // Создаем "конвертер" через ссылку на статический метод Integer.toHexString(int)


        // Применяем конвертер к числу 255


        // Выводим шестнадцатеричное представление на экран

    }
}

 */
import java.util.function.Function;
import java.util.function.IntFunction;

import static java.lang.Integer.toHexString;

public class Solution {
    public static void main(String[] args) {
        // Создаем "конвертер" через ссылку на статический метод Integer.toHexString(int)
//        Function<Integer, String> converterInt = i -> toHexString(i);
        //        Function<Integer, String> converter = Integer::toHexString;
        IntFunction<String> converter = Integer::toHexString;

        // Применяем конвертер к числу 255
        String newConvertedInt = converter.apply(255);

        // Выводим шестнадцатеричное представление на экран
        System.out.println(newConvertedInt);
    }


}
/*
моё первое решение
public class Solution {
    public static void main(String[] args) {
        // Создаем "конвертер" через ссылку на статический метод Integer.toHexString(int)
          String convertedInt = toHexString(255);

        // Применяем конвертер к числу 255

        // Выводим шестнадцатеричное представление на экран
        System.out.println(newConvertedInt);
    }


}
 */
/*

public class Solution {
    public static void main(String[] args) {
        // Создаем "конвертер" через ссылку на статический метод Integer.toHexString(int)
        IntFunction<String> toHexConverter = Integer::toHexString;

        // Применяем конвертер к числу 255
        String hex = toHexConverter.apply(255);

        // Выводим шестнадцатеричное представление на экран
        System.out.println(hex);
    }
}

 */