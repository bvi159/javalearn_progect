package ru.javarush.java.core.level23.task08;

/*
Интеллектуальная система логирования чисел

Вы работаете над универсальной системой логирования, которая должна уметь выводить на экран различные типы числовых данных. Вы хотите, чтобы ваша система была гибкой, поэтому создайте класс OverloadDemo, который будет содержать два метода с одинаковым именем print. Один из них будет принимать целые числа, например public void print(int valueToPrint), и выводить "int: " + valueToPrint. Второй метод будет принимать числа с плавающей точкой, public void print(double valueToPrint), и выводить "double: " + valueToPrint.
Теперь самое интересное: в основном методе main создайте объект OverloadDemo и попробуйте вызвать метод print, передав ему число 5L (то есть число 5 типа long). Вы увидите, что Java, стремясь найти наиболее подходящий метод, автоматически "расширит" тип long до double (потому что long не может быть преобразован в int без потери точности, а double может вместить long), и вызовет именно метод print(double x). В результате на экране появится "double: 5.0", демонстрируя, как Java разрешает неоднозначность при вызове перегруженных методов.

Требования:
•	Необходимо создать класс с именем OverloadDemo.
•	В классе OverloadDemo должны быть объявлены два метода с одинаковым именем print, но с разными параметрами: один принимает int, другой — double.
•	Метод print, принимающий int, должен выводить на экран строку в формате "int: " + значение параметра.
•	Метод print, принимающий double, должен выводить на экран строку в формате "double: " + значение параметра.
•	В методе main необходимо создать объект OverloadDemo и вызвать у него метод print, передав значение типа long (например, 5L).
•	При передаче значения типа long должно быть вызвано именно перегруженное объявление print(double), а не print(int), и на экран должно быть выведено "double: 5.0".

public class Solution {
    public static void main(String[] args) {
        OverloadDemo demo = new OverloadDemo();

        long value = 5L; // Явно используем тип long

        // Здесь Java выберет перегрузку print(double),
        demo.print(value); // Ожидаемый вывод: "double: 5.0"
    }
}

 */

public class Solution {
    public static void main(String[] args) {
        OverloadDemo demo = new OverloadDemo();

        long value = 5L; // Явно используем тип long

        // Здесь Java выберет перегрузку print(double),
        demo.print(value); // Ожидаемый вывод: "double: 5.0"
    }
}

class OverloadDemo {
    void print(int valueToPrint) {
        System.out.println("int: " + valueToPrint);
    }

    void print(double valueToPrint) {
        System.out.println("double: " + valueToPrint);

    }
}

/*
// Класс с двумя перегруженными методами print: для int и для double
class OverloadDemo {
    public void print(int valueToPrint) {
        System.out.println("int: " + valueToPrint);
    }

    public void print(double valueToPrint) {
        System.out.println("double: " + valueToPrint);
    }
}
 */