package ru.javarush.java.core.level13.task15;
/*
Персонализация: дата с локальным колоритом 🗓️

Для вашего приложения-органайзера необходимо отображать даты в привычном для пользователя формате, например, "15.03.2023".

Создайте объект LocalDate для specificEventDate (15 марта 2023 года).

Затем примените DateTimeFormatter.ofPattern("dd.MM.yyyy"), чтобы преобразовать specificEventDate в friendlyDisplayDateString — строку, которая идеально вписывается в локальные предпочтения.

Выведите friendlyDisplayDateString на экран, чтобы порадовать пользователя.

Требования:
•	В программе должен быть создан объект LocalDate с датой 15 марта 2023 года и присвоен переменной specificEventDate.
•	Для форматирования даты должен быть использован объект DateTimeFormatter, созданный через ofPattern с шаблоном "dd.MM.yyyy".
•	Должна быть выполнена операция преобразования specificEventDate в строку с помощью созданного форматтера. Результат должен быть сохранён в переменную friendlyDisplayDateString.
•	Значение переменной friendlyDisplayDateString должно быть выведено на экран.
public class Solution {
    public static void main(String[] args) {
        // Создаем объект LocalDate с датой 15 марта 2023 года


        // Готовим форматтер с шаблоном "dd.MM.yyyy" (например, "15.03.2023")


        // Форматируем дату в строку с учетом заданного шаблона


        // Выводим получившуюся строку на экран

    }
}

 */
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Solution {
    public static void main(String[] args) {
        // Создаем объект LocalDate с датой 15 марта 2023 года
        LocalDate specificEventDate = LocalDate.of(2023,03,15);

        // Готовим форматтер с шаблоном "dd.MM.yyyy" (например, "15.03.2023")
        DateTimeFormatter myTemplateFormater = DateTimeFormatter.ofPattern("dd MMMM yyyy", new Locale("ru"));

        // Форматируем дату в строку с учетом заданного шаблона
        String friendlyDisplayDateString = specificEventDate.format(myTemplateFormater);

        // Выводим получившуюся строку на экран
        System.out.println(friendlyDisplayDateString);
    }
}

