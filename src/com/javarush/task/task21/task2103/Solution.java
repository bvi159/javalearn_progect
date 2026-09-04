package com.javarush.task.task21.task2103;

/*
Все гениальное - просто!
public class Solution {
    public static boolean calculate(boolean a, boolean b, boolean c, boolean d) {
        return c;
    }

    public static void main(String[] args) {

    }
}

Упростить. Переменные не переименовывать, комментарии не оставлять.

Требования:
•	Метод calculate должен быть статическим.
•	Метод calculate должен возвращать значение типа boolean.
•	Метод calculate должен принимать четыре параметра типа boolean.
•	Метод calculate должен быть максимально упрощен(поведение должно остаться прежним).
    }
}

*/

public class Solution {
    public static boolean calculate(boolean a, boolean b, boolean c, boolean d) {
        return c;
    }

    public static void main(String[] args) {

    }
}
/*
java надо упростить: public static boolean calculate(boolean a, boolean b, boolean c, boolean d) {
        return (a && b && c && !d) || (!a && c) || (!b && c) || (c && d);
    } и пояснить результат

Упростим логическое выражение шаг за шагом:

Исходное выражение:

(a && b && c && !d) || (!a && c) || (!b && c) || (c && d)
Факторизуем c (вынесем его за скобки):

java
c && ( (a && b && !d) || !a || !b || d )
Упростим выражение в скобках:

Применим закон де Моргана к !a || !b, получим !(a && b)

Теперь выражение в скобках: (a && b && !d) || !(a && b) || d

Применим закон дистрибутивности:

(a && b && !d) || !(a && b) можно переписать как ( (a && b) && !d ) || !(a && b)

Это эквивалентно !(a && b) || !d (по правилу (x && y) || !x ≡ !x || y)

Теперь выражение в скобках:

java
!(a && b) || !d || d
!d || d всегда истинно (закон исключённого третьего)

!(a && b) || true всегда истинно

Исходное выражение упрощается до:

java
c && true
Что равно просто c

Итоговое упрощённое выражение:

public static boolean calculate(boolean a, boolean b, boolean c, boolean d) {
    return c;
}
Объяснение: В исходном выражении все варианты содержат c как обязательное условие (во всех частях ИЛИ есть c),
а остальные условия в скобках всегда упрощаются до истины. Таким образом,
результат функции зависит исключительно от значения c.

 */

/*

public class Solution {
    public static boolean calculate(boolean a, boolean b, boolean c, boolean d) {
        return (a && b && c && !d) || (!a && c) || (!b && c) || (c && d);
    }

    public static void main(String[] args) {

    }
}

 */