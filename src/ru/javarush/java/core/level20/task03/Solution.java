package ru.javarush.java.core.level20.task03;
/*
Профессор-Калькулятор и Его Неизменные Истины

Вы заняты разработкой высокоточного научного калькулятора, и одна из его ключевых особенностей — использование фундаментальных математических констант, таких как число Пи. Крайне важно, чтобы значение Пи было одинаковым и абсолютно точным во всех вычислениях калькулятора, и чтобы его нельзя было случайно изменить.
Создайте «библиотеку неизменных математических истин» в виде интерфейса MathConstants. Внутри этой библиотеки объявите константу PI с типом double, и присвойте ей точное значение 3.14159.
Затем сконструируйте главный модуль вашего калькулятора — класс Calculator. Ваш Calculator должен "понимать" и использовать "библиотеку математических истин" MathConstants. Добавьте в класс Calculator специальный метод printPi(), который будет аккуратно выводить на экран точное значение PI, взятое из вашей библиотеки констант.
В основной части вашей программы создайте экземпляр Calculator и попросите его printPi(). Программа должна вывести 3.14159.

Требования:
•	В программе должен быть объявлен интерфейс с именем MathConstants.
•	В интерфейсе MathConstants должна быть объявлена константа PI типа double с точным значением 3.14159.
•	В программе должен быть создан класс с именем Calculator.
•	Класс Calculator должен использовать интерфейс MathConstants для доступа к константе PI.
•	В классе Calculator должен быть реализован публичный метод printPi(), который выводит значение константы PI на экран.
•	При вызове метода printPi() у экземпляра класса Calculator на экран должно быть выведено значение 3.14159.

public class Solution {
    public static void main(String[] args) {
        // Создаем экземпляр калькулятора и выводим значение PI
        Calculator calculator = new Calculator();
        calculator.printPi(); // ожидаемый вывод: 3.14159
    }
}

*/

public class Solution {
    public static void main(String[] args) {
        // Создаем экземпляр калькулятора и выводим значение PI
        Calculator calculator = new Calculator();
        calculator.printPi(); // ожидаемый вывод: 3.14159
    }
}

class Calculator implements MathConstants {
    public void printPi() {
        System.out.println(PI);
    }
}

/*
// Интерфейс-библиотека неизменных математических истин
interface MathConstants {
    // Константа PI (в интерфейсах поля по умолчанию public static final)
    double PI = 3.14159;
}

// Главный модуль калькулятора, использующий интерфейс MathConstants
class Calculator implements MathConstants {
    // Выводит значение PI на экран
    public void printPi() {
        System.out.println(PI); // используем константу из интерфейса
    }
}

public class Solution {
    public static void main(String[] args) {
        // Создаем экземпляр калькулятора и выводим значение PI
        Calculator calculator = new Calculator();
        calculator.printPi(); // ожидаемый вывод: 3.14159
    }
}
 */
