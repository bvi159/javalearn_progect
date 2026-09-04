package ru.javarush.java.core.level10.task15;

/*
Планирование недели в приложении 🗓️
Вы создаёте планировщик задач, и вам нужно вывести все дни недели, чтобы пользователь мог выбрать, на какой день запланировать задачу.

Объявите перечисление DayOfWeek с семью значениями, представляющими каждый день недели: MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY. В методе main вашей программы, используя цикл, пройдитесь по всем возможным значениям перечисления DayOfWeek и выведите каждое из них на экран с новой строки. Это позволит пользователю увидеть полный список доступных дней.

Требования:
•	В программе должно быть объявлено перечисление (enum) с именем DayOfWeek.
•	Перечисление DayOfWeek должно содержать ровно семь значений: MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY.
•	В методе main программы необходимо с помощью цикла пройтись по всем значениям перечисления DayOfWeek.
•	Каждое значение перечисления DayOfWeek должно быть выведено на экран с новой строки.
// Перечисление дней недели: каждое значение — отдельный день.


public class Solution {
    public static void main(String[] args) {
        // Используем цикл for-each для перебора всех значений перечисления DayOfWeek

    }
}
 */
// Перечисление дней недели: каждое значение — отдельный день.


public class Solution {
    public static void main(String[] args) {
        // Используем цикл for-each для перебора всех значений перечисления DayOfWeek
        for (DayOfWeek someDay : DayOfWeek.values()) {
            System.out.println(someDay);
        }

    }
}

/*
ихнее решение

// Перечисление дней недели: каждое значение — отдельный день.
enum DayOfWeek {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
}

public class Solution {
    public static void main(String[] args) {
        // Используем цикл for-each для перебора всех значений перечисления DayOfWeek
        for (DayOfWeek day : DayOfWeek.values()) {
            System.out.println(day);
        }
    }
}
 */