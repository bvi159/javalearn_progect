package ru.javarush.java.core.level15.task06;
/*
Волшебный калькулятор с секретным механизмом ➕

Вы разрабатываете продвинутый калькулятор. У него будет публичная функция сложения, доступная всем, но механизм вывода результата на экран должен быть внутренним и скрытым от посторонних глаз.
Создайте класс MagicCalculator. В нём определите публичный метод addNumbers(int firstNumber, int secondNumber), который будет принимать два целых числа и возвращать их сумму. Также создайте приватный метод displayInternalResult(int calculationResult), который просто выводит переданное ему число на экран, возможно, с каким-нибудь внутренним префиксом типа "Внутренний результат: ".
В классе Solution вызовите публичный метод addNumbers(), передав ему, например, числа 10 и 15. Сохраните полученную сумму в переменную. Затем, используя System.out.println(), выведите эту сумму на экран. Теперь попробуйте вызвать приватный метод displayInternalResult() напрямую из Solution с вашей суммой. Вы должны убедиться, что это невозможно, и ваша программа не скомпилируется, потому что секретный механизм калькулятора надёжно защищён.

Требования:
•	В классе MagicCalculator должен быть определён публичный метод addNumbers(int firstNumber, int secondNumber), который принимает два целых числа и возвращает их сумму.
•	В классе MagicCalculator должен быть определён приватный метод displayInternalResult(int calculationResult), который выводит переданное ему число на экран с внутренним префиксом (например, "Внутренний результат: ").
•	Метод displayInternalResult должен иметь модификатор доступа private, чтобы его нельзя было вызвать вне класса MagicCalculator.
•	В классе Solution необходимо вызвать публичный метод addNumbers класса MagicCalculator, сохранить результат в переменную и вывести эту сумму на экран с помощью System.out.println().
•	Попытка вызвать метод displayInternalResult из класса Solution должна приводить к ошибке компиляции, подтверждая, что приватный метод недоступен вне класса MagicCalculator.

public class Solution {
    public static void main(String[] args) {
        MagicCalculator calculator = new MagicCalculator();

        // Вызываем публичный метод сложения и сохраняем результат
        int sum = calculator.addNumbers(10, 15);

        // Выводим сумму на экран
        System.out.println(sum);

        // Попытка вызвать приватный метод извне класса приведет к ошибке компиляции.
        calculator.displayInternalResult(sum); // Ошибка: displayInternalResult(int) has private access in MagicCalculator
    }
}

 */
public class Solution {
    public static void main(String[] args) {
        MagicCalculator calculator = new MagicCalculator();

        // Вызываем публичный метод сложения и сохраняем результат
        int sum = calculator.addNumbers(10, 15);

        // Выводим сумму на экран
        System.out.println(sum);

        // Попытка вызвать приватный метод извне класса приведет к ошибке компиляции.
//        calculator.displayInternalResult(sum); // Ошибка: displayInternalResult(int) has private access in MagicCalculator
    }
}

class MagicCalculator {
    public int addNumbers(int firstNumber, int secondNumber) {
        return firstNumber + secondNumber;
    }

    private void displayInternalResult(int calculationResult) {
        System.out.println("Внутренний результат: " + calculationResult);
    }
}