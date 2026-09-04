package ru.javarush.java.core.level10.task04;
/*
Обработка "сломанных" данных 📉

Вы разрабатываете модуль анализа данных с метеостанции, и иногда датчики выдают не числовые значения, а специальный текст, например, "NaN" (Not a Number), что означает "не число". Ваша программа должна уметь распознавать такие некорректные данные.

Создайте строковую переменную sensorReadingText со значением "NaN". Ваша задача — попытаться преобразовать эту текстовую запись в число типа double, используя класс Double. Сохраните результат в переменную parsedSensorData. Затем, используя специальный метод из класса Double, проверьте, является ли parsedSensorData тем самым "не числом". Выведите результат этой проверки на экран.

Требования:
•	В программе должна быть объявлена строковая переменная sensorReadingText со значением "NaN".
•	Строка sensorReadingText должна быть преобразована в число типа double с помощью класса Double и результат сохранён в переменную parsedSensorData.
•	Для проверки, является ли parsedSensorData "не числом" (NaN), должен использоваться специальный статический метод из класса Double.
•	Результат проверки (true или false) должен быть выведен на экран.

public class Solution {
    public static void main(String[] args) {
        // Строковое значение, пришедшее от датчика
        String sensorReadingText = "NaN";

        // Преобразуем строку в число типа double с помощью класса Double


        // Проверяем, является ли полученное значение "не числом" (NaN)


        // Выводим результат проверки (true/false)

    }
}

 */
public class Solution {
    public static void main(String[] args) {
        // Строковое значение, пришедшее от датчика
        String sensorReadingText = "NaN";

        // Преобразуем строку в число типа double с помощью класса Double
        double parsedSensorData = Double.parseDouble(sensorReadingText);

        // Проверяем, является ли полученное значение "не числом" (NaN)
        boolean isNotAnumber = Double.isNaN(parsedSensorData);

        // Выводим результат проверки (true/false)
        System.out.println(isNotAnumber);

    }
}