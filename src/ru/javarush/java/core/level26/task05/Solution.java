package ru.javarush.java.core.level26.task05;
/*
Умный планировщик задач: дни недели 🗓️

Представьте, что вы создаёте умный планировщик задач, который связывает дни недели с их порядковыми номерами. Вам нужна удобная структура для хранения такой информации.
Создайте коллекцию, где каждый день недели ("Monday", "Tuesday", "Wednesday") будет ключом, а его порядковый номер (1, 2, 3) — значением. Занесите в него данные для "Monday" (1), "Tuesday" (2) и "Wednesday" (3).
Теперь вам нужно вывести на экран полный список дней и их значений, чтобы пользователь мог быстро ориентироваться. Сделайте это в формате: "День: [Название дня], Номер: [Номер дня]" для каждого элемента.

Требования:
•	Для хранения соответствий между днями недели и их порядковыми номерами должна использоваться коллекция типа Map.
•	Ключами в коллекции должны быть строки (названия дней недели), а значениями — целые числа (их порядковые номера).
•	В коллекцию должны быть добавлены три элемента: "Monday" с номером 1, "Tuesday" с номером 2 и "Wednesday" с номером 3.
•	Необходимо вывести все элементы коллекции на экран.
•	Каждая строка вывода должна соответствовать формату: "День: [Название дня], Номер: [Номер дня]" для каждого элемента коллекции.

import java.util.TreeMap;
public class Solution {
    public static void main(String[] args) {
        // Создаём Map: ключ — название дня недели (String), значение — его номер (Integer)


        // Добавляем элементы согласно условию задачи


        // Проходим по всем парам ключ-значение и выводим в требуемом формате

    }
}

 */
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) {
        // Создаём Map: ключ — название дня недели (String), значение — его номер (Integer)
        Map<String, Integer> plan = new TreeMap<>();

        // Добавляем элементы согласно условию задачи
        plan.put("Monday", 1);
        plan.put("Tuesday", 2);
        plan.put("Wednesday", 3);
//        plan.put("Thirthday", 4);
//        plan.put("Friday", 5);
//        plan.put("Saturday", 6);
//        plan.put("Sundday", 7);


        for (Map.Entry<String, Integer> entry : plan.entrySet()) {
            System.out.println("День: " + entry.getKey() + ", Номер: " + entry.getValue());
        }


        // Проходим по всем парам ключ-значение и выводим в требуемом формате

    }
}

/*


public class Solution {
    public static void main(String[] args) {
        // Создаём Map: ключ — название дня недели (String), значение — его номер (Integer)
        TreeMap<String, Integer> days = new TreeMap<>();

        // Добавляем элементы согласно условию задачи
        days.put("Monday", 1);
        days.put("Tuesday", 2);
        days.put("Wednesday", 3);

        // Проходим по всем парам ключ-значение и выводим в требуемом формате
        for (var entry : days.entrySet()) {
            System.out.println("День: " + entry.getKey() + ", Номер: " + entry.getValue());
        }
    }
}

 */