package ru.javarush.java.core.level06.task09;

/*
Проверка точности химического раствора 🧪

Представьте, что вы учёный-химик, который смешивает два очень точных компонента, 0.1 и 0.2, в растворе,
и ожидаете получить идеально 0.3.

Вы создаёте две переменные типа double: mixtureResult (ей присвойте результат сложения 0.1 + 0.2)
и expectedConcentration (ей присвойте значение 0.3).

Ваша задача — провести эксперимент: сравните mixtureResult и expectedConcentration
с помощью оператора == и выведите результат этого сравнения на экран.

Будьте готовы к неожиданностям, ведь мир чисел с плавающей точкой полон сюрпризов!

Требования:
•	В программе должны быть объявлены две переменные типа double: mixtureResult и expectedConcentration.
•	Переменная mixtureResult должна быть инициализирована результатом выражения 0.1 + 0.2.
•	Переменная expectedConcentration должна быть инициализирована значением 0.3.
•	Программа должна сравнить значения mixtureResult и expectedConcentration с помощью оператора ==.
•	Программа должна вывести на экран результат сравнения (true или false).

public class Solution {
    public static void main(String[] args) {
        // Объявляем переменную mixtureResult и присваиваем ей результат сложения 0.1 + 0.2


        // Объявляем переменную expectedConcentration и присваиваем ей значение 0.3


        // Сравниваем значения переменных mixtureResult и expectedConcentration с помощью оператора ==


        // Выводим результат сравнения на экран

    }
}

 */

public class Solution {
    public static void main(String[] args) {
        // Объявляем переменную mixtureResult и присваиваем ей результат сложения 0.1 + 0.2
        double mixtureResult = 0.1 + 0.2;

        // Объявляем переменную expectedConcentration и присваиваем ей значение 0.3
        double expectedConcentration = 0.3;

        // Сравниваем значения переменных mixtureResult и expectedConcentration с помощью оператора ==
        boolean compareResult = (mixtureResult == expectedConcentration);

        // Выводим результат сравнения на экран
        System.out.println(compareResult);
    }
}