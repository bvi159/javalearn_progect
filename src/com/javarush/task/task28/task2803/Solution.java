package com.javarush.task.task28.task2803;

import java.util.concurrent.ThreadLocalRandom;

/* 
ThreadLocalRandom

Класс Solution будет использоваться трэдами.
Реализуй логику всех методов, используй класс ThreadLocalRandom.
getRandomIntegerBetweenNumbers должен возвращать случайный int между from и to.
getRandomDouble должен возвращать случайный double.
getRandomLongBetween0AndN должен возвращать случайный long между 0 и n.

Требования:
•	В классе Solution должны быть только статические методы.
•	Метод getRandomIntegerBetweenNumbers с помощью ThreadLocalRandom должен возвращать случайный int [from..to].
•	Метод getRandomDouble с помощью ThreadLocalRandom должен возвращать случайный double [0..1).
•	Метод getRandomLongBetween0AndN с помощью ThreadLocalRandom должен возвращать случайный long [0..n].

public class Solution {
    public static int getRandomIntegerBetweenNumbers(int from, int to) {
        return 0;
    }

    public static double getRandomDouble() {
        return 0;
    }

    public static long getRandomLongBetween0AndN(long n) {
        return 0;
    }

    public static void main(String[] args) {
    }
}

всё сделлал ИИ, включая main
*/

public class Solution {
    public static int getRandomIntegerBetweenNumbers(int from, int to) {
        // Возвращаем случайный int в диапазоне [from, to]
        return ThreadLocalRandom.current().nextInt(from, to + 1);
    }

    public static double getRandomDouble() {
        // Возвращаем случайный double в диапазоне [0, 1)
        return ThreadLocalRandom.current().nextDouble();
    }

    public static long getRandomLongBetween0AndN(long n) {
        // Возвращаем случайный long в диапазоне [0, n]
        return ThreadLocalRandom.current().nextLong(0, n + 1);
    }
    public static void main(String[] args) {
        System.out.println("=== Примеры использования методов класса Solution ===\n");

        // Пример 1: getRandomIntegerBetweenNumbers
        System.out.println("1. Примеры getRandomIntegerBetweenNumbers:");
        System.out.println("   Случайное число от 1 до 10: " + getRandomIntegerBetweenNumbers(1, 10));
        System.out.println("   Случайное число от -5 до 5: " + getRandomIntegerBetweenNumbers(-5, 5));
        System.out.println("   Случайное число от 100 до 1000: " + getRandomIntegerBetweenNumbers(100, 1000));

        // Пример 2: getRandomDouble
        System.out.println("\n2. Примеры getRandomDouble:");
        System.out.println("   Случайное double [0, 1): " + getRandomDouble());
        System.out.println("   Ещё одно случайное double [0, 1): " + getRandomDouble());

        // Пример 3: getRandomLongBetween0AndN
        System.out.println("\n3. Примеры getRandomLongBetween0AndN:");
        System.out.println("   Случайное long от 0 до 50: " + getRandomLongBetween0AndN(50));
        System.out.println("   Случайное long от 0 до 1000: " + getRandomLongBetween0AndN(1000));
        System.out.println("   Случайное long от 0 до 10000: " + getRandomLongBetween0AndN(10000));

        // Пример 4: Демонстрация многократных вызовов
        System.out.println("\n4. 10 случайных чисел от 0 до 9:");
        for (int i = 0; i < 10; i++) {
            System.out.print(getRandomIntegerBetweenNumbers(0, 9) + " ");
        }

        System.out.println("\n\n5. 5 случайных double значений:");
        for (int i = 0; i < 5; i++) {
            System.out.print(String.format("%.4f", getRandomDouble()) + " ");
        }
    }

}
