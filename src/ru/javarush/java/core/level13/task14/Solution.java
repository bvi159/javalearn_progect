package ru.javarush.java.core.level13.task14;
/*
Расшифровка входящих данных: парсинг даты из строки 📝

В вашу систему поступили важные данные в виде обычной текстовой строки: "2024-12-31". Но для дальнейшей обработки вам нужен не просто текст, а полноценный объект даты.

Ваша миссия — преобразовать эту inputDateString в объект parsedLocalDate типа LocalDate. Используйте стандартный форматтер DateTimeFormatter.ISO_LOCAL_DATE для точной расшифровки.

После успешного преобразования выведите parsedLocalDate на экран, подтверждая, что данные готовы к работе.

Требования:
•	В программе должны быть импортированы классы LocalDate и DateTimeFormatter из пакета java.time.
•	Входная строка с датой должна быть представлена в переменной inputDateString и иметь значение "2024-12-31".
•	Строка inputDateString должна быть преобразована в объект LocalDate с помощью метода LocalDate.parse.
•	Для парсинга строки должен быть использован стандартный форматтер DateTimeFormatter.ISO_LOCAL_DATE.
•	После успешного преобразования объект parsedLocalDate должен быть выведен на экран.
public class Solution {
    public static void main(String[] args) {
        // Входная строка с датой в формате ISO (год-месяц-день)
        String inputDateString = "2024-12-31";

        // Парсим строку в объект LocalDate, явно указывая стандартный ISO форматтер


        // Выводим полученный объект даты на экран

    }
}

 */
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Solution {
    public static void main(String[] args) {
        // Входная строка с датой в формате ISO (год-месяц-день)
        String inputDateString = "2024-12-31";

        // Парсим строку в объект LocalDate, явно указывая стандартный ISO форматтер
        LocalDate parsedLocalDate = LocalDate.parse(inputDateString, DateTimeFormatter.ISO_LOCAL_DATE);

        // Выводим полученный объект даты на экран
        System.out.println(parsedLocalDate);


    }
}