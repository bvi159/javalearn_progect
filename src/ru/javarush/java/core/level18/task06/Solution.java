package ru.javarush.java.core.level18.task06;
/*
Умный калькулятор множитель: Перегрузка метода с разными типами параметров

Вы разрабатываете универсальный калькулятор, который способен точно умножать числа, будь то целые значения или числа с плавающей точкой. Вам нужен класс Multiplier.
В этом классе создайте два метода с именем multiply. Первый метод multiply должен принимать два целых числа (int), вычислять их произведение и возвращать его. Второй метод multiply должен принимать два числа с плавающей точкой (double), вычислять их произведение и также возвращать результат.
В методе main создайте экземпляр вашего Multiplier. Затем, используя этот объект, вызовите оба метода multiply: сначала с двумя целыми числами (например, 5 и 4), а затем с двумя числами с плавающей точкой (например, 2.5 и 3.0). Выведите результаты каждого умножения на экран. Вы увидите, как ваш калькулятор прекрасно справляется с разными типами чисел, используя один и тот же "умножающий" функционал.

Требования:
•	В программе должен быть создан класс с именем Multiplier.
•	В классе Multiplier должно быть определено два метода с именем multiply, но с разными параметрами (перегрузка).
•	Один из методов multiply должен принимать два параметра типа int, вычислять их произведение и возвращать результат типа int.
•	Второй метод multiply должен принимать два параметра типа double, вычислять их произведение и возвращать результат типа double.
•	В методе main необходимо создать объект класса Multiplier и вызвать оба метода multiply: сначала с двумя целыми числами, затем с двумя числами типа double.
•	Результаты работы обоих методов multiply должны быть выведены на экран.

public class Solution {
    public static void main(String[] args) {
        // Создаем объект "умного" калькулятора
        Multiplier multiplier = new Multiplier();

        // Сначала умножаем два целых числа
        int intResult = multiplier.multiply(5, 4);

        // Затем умножаем два числа с плавающей точкой
        double doubleResult = multiplier.multiply(2.5, 3.0);

        // Выводим результаты на экран
        System.out.println(intResult);
        System.out.println(doubleResult);
    }
}

 */


public class Solution {
    public static void main(String[] args) {
        // Создаем объект "умного" калькулятора
        Multiplier multiplier = new Multiplier();

        // Сначала умножаем два целых числа
        int intResult = multiplier.multiply(5, 4);

        // Затем умножаем два числа с плавающей точкой
        double doubleResult = multiplier.multiply(2.5, 3.0);

        // Выводим результаты на экран
        System.out.println(intResult);
        System.out.println(doubleResult);

        String stringoPlier = multiplier.multiply("Привет от Вити");
        System.out.println(stringoPlier);

    }
}

class Multiplier {
    int multiply(int numberOne, int numberTwo) {
//        System.out.println(numberOne*numberTwo);
        return numberOne * numberTwo;
    }

    double multiply(double numberOne, double numberTwo) {
//        System.out.println(numberOne*numberTwo);
        return numberTwo * numberOne;
    }

    String multiply(String myString) {
        return myString;
    }

}

/*
public class Solution {
    public static void main(String[] args) {
        // Создаем объект "умного" калькулятора
        Multiplier multiplier = new Multiplier();

        // Сначала умножаем два целых числа
        int intResult = multiplier.multiply(5, 4);

        // Затем умножаем два числа с плавающей точкой
        double doubleResult = multiplier.multiply(2.5, 3.0);

        // Выводим результаты на экран
        System.out.println(intResult);
        System.out.println(doubleResult);
    }
}


// Класс-калькулятор с перегруженными методами multiply
class Multiplier {
    // Перегруженный метод для int: принимает два int и возвращает int
    int multiply(int a, int b) {
        return a * b;
    }

    // Перегруженный метод для double: принимает два double и возвращает double
    double multiply(double a, double b) {
        return a * b;
    }
}

 */