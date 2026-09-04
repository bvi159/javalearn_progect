package ru.javarush.java.core.level23.task19;

/*
Налоговая ставка: Больше никаких "магических чисел"! 💸

Вы разрабатываете систему расчета зарплаты для компании. В коде, который вы получили, есть "магическое число", используемое для расчета налога: double tax = salary * 0.13;. Это число 0.13 – налоговая ставка, и оно может быть труднопонятным для того, кто будет читать код после вас, к тому же его легко случайно изменить.
Ваша задача — сделать код более чистым и понятным, заменив это число на именованную константу. Создайте класс и объявите внутри него static final double константу, назовите ее, например, INCOME_TAX_RATE, и присвойте ей значение 0.13.
Затем, в своем расчете, используйте эту константу. Объявите переменную employeeSalary (например, со значением 5000.0) и рассчитайте calculatedTax с её помощью. После этого выведите результат вычисления переменной calculatedTax на экран. Это улучшит читаемость и обеспечит, что налоговая ставка останется неизменной на протяжении всей программы.

Требования:
•	В классе должна быть объявлена константа с модификаторами static final и типом double для хранения значения налоговой ставки.
•	Константа для налоговой ставки должна иметь осмысленное имя, например, INCOME_TAX_RATE.
•	В расчетах налоговой суммы необходимо использовать объявленную константу, а не непосредственно число 0.13.
•	В коде должна быть объявлена переменная employeeSalary с типом double и заданным значением, например, 5000.0.
•	Необходимо рассчитать налоговую сумму (calculatedTax) как произведение employeeSalary на INCOME_TAX_RATE.
•	Результат вычисления переменной calculatedTax должен быть выведен на экран с помощью System.out.println.

public class Solution {
    // Константа налоговой ставки. Так понятнее и безопаснее, чем "магическое число" 0.13 в коде.


    public static void main(String[] args) {

    }
}

 */

public class Solution {
    // Константа налоговой ставки. Так понятнее и безопаснее, чем "магическое число" 0.13 в коде.
    static final double INCOME_TAX_RATE = 0.13;


    public static void main(String[] args) {
        double employeeSalary = 5000;
        double calculatedTax;
        calculatedTax = employeeSalary * INCOME_TAX_RATE;
        System.out.println(calculatedTax);
//        Solution result = new Solution();
//        result.employeeSalary = 5000.0;
//        System.out.println(result.calculatedTax());

    }
}

/*
public class Solution {
    // Константа налоговой ставки. Так понятнее и безопаснее, чем "магическое число" 0.13 в коде.
    public static final double INCOME_TAX_RATE = 0.13;

    public static void main(String[] args) {
        double employeeSalary = 5000.0;             // Пример зарплаты сотрудника
        double calculatedTax = employeeSalary * INCOME_TAX_RATE; // Расчет налога с использованием константы

        System.out.println(calculatedTax);          // Вывод результата на экран
    }
}
 */