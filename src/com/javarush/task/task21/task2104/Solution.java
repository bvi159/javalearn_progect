package com.javarush.task.task21.task2104;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/* 
Equals and HashCode

public class Solution {
    private final String first, last;

    public Solution(String first, String last) {
        this.first = first;
        this.last = last;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Solution)) return false;

        Solution solution = (Solution) o;

        if (first != null ? !first.equals(solution.first) : solution.first != null) return false;
        return last != null ? last.equals(solution.last) : solution.last == null;
    }

    @Override
    public int hashCode() {
        int result = first != null ? first.hashCode() : 0;
        result = 31 * result + (last != null ? last.hashCode() : 0);
        return result;
    }

    public static void main(String[] args) {
        Set<Solution> s = new HashSet<>();
        s.add(new Solution("Donald", "Duck"));
        System.out.println(s.contains(new Solution("Donald", "Duck")));
    }
}


В классе Solution исправить пару методов equals/hashCode в соответствии с правилами реализации этих методов(детали уточни у своего любимого поисковика).
Обе строки first и last должны принимать участие в сравнении с помощью метода equals и вычислении hashcode.
Метод main не участвует в тестировании.

Требования:
•	Хешкоды одинаковых объектов должны быть равны.
•	Метод equals должен проверять равен ли переданный объект текущему(сравнение через ==).
•	Метод equals должен проверять является ли переданный объект объектом класса Solution.
•	Метод equals должен возвращать true в случае, если поля first и last равны у переданного объекта и текущего(не забудь что они могут быть равны null).
•	Должно быть обеспечено корректное поведение HashSet с типом элементов Solution.

моё тоже правильное с помощью ИИ
*/
// java в чём ошибка в программе:

public class Solution {
    private final String first, last;
//    private Solution solution;

    public Solution(String first, String last) {
        this.first = first;
        this.last = last;
    }

    @Override
    public boolean equals(Object n) {
        if (this == n) {
            return true;
        }

        if (!(n instanceof Solution)) {
            return false;
        }

        if (n == null || getClass() != n.getClass()) {
            return false;
        }

        Solution other = (Solution) n;

        return Objects.equals(first, other.first) && Objects.equals(last, other.last);
    }

    public int hashCode() {
//        return 31 * first.hashCode() + last.hashCode();
        return Objects.hash(first, last);
    }

    public static void main(String[] args) {
        Set<Solution> s = new HashSet<>();
        s.add(new Solution("Donald", "Duck"));
        System.out.println(s.contains(new Solution("Donald", "Duck")));
    }
}
/*
//        Solution n = (Solution) n;

        // Сравнение вложенного Solution (рекурсивно, с учётом null)
//        if (n == null) {
//            if (this != null) {
//                return false;
//            }
//        } else if (!n.equals(this)) {
//            return false;
//        }

//        if (o instanceof Solution) {
//            return false;
//        }
//        if (n.getClass() != Solution.class) {
//            return false;
//        }
//        if (n.getClass().getName() != "Solution") {
//            return false;
//        }
        if (solution == null) {
            if (n.solution != null) {
                return false;
            }
        } else if (!solution.equals(n.solution)) {
            return false;
        }
//        !solution.equals(solution1.solution)

---------------------

package com.javarush.task.task21.task2104;

import java.util.HashSet;
import java.util.Set;


// Equals and HashCode


public class Solution {
    private final String first, last;

    public Solution(String first, String last) {
        this.first = first;
        this.last = last;
    }

    public boolean equals(Solution n) {
        return n.first.equals(first) && n.last.equals(last);
    }

    public int hashCode() {
        return 31 * first.hashCode() + last.hashCode();
    }

    public static void main(String[] args) {
        Set<Solution> s = new HashSet<>();
        s.add(new Solution("Donald", "Duck"));
        System.out.println(s.contains(new Solution("Donald", "Duck")));
    }
}


 */