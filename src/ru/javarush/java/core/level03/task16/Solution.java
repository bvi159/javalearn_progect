package ru.javarush.java.core.level03.task16;
/*
Условия получения кредита в банке 💰
Банк рассматривает вашу заявку на кредит по двум разным правилам.

yourAge = 25
hasJob = true
hasCreditHistory = false
hasGuarantor = true

Первое правило: Кредит одобрят, если «ваш возраст больше 21 и у вас есть работа» ИЛИ «у вас есть кредитная история
и поручитель».

Второе правило: Кредит одобрят, если «ваш возраст больше 21» И «либо у вас есть работа, либо кредитная история»
И «есть поручитель».

Создайте два выражения с учетом этих правил, выведите их результаты.

Требования:
•	В программе должны быть объявлены переменные yourAge (int), hasJob (boolean), hasCreditHistory (boolean),
 hasGuarantor (boolean) и им должны быть присвоены значения: 25, true, false, true соответственно.
•	Первое логическое выражение должно соответствовать правилу: (yourAge > 21 && hasJob) || (hasCreditHistory &&
hasGuarantor), с правильным использованием скобок для приоритета операций.
•	Второе логическое выражение должно соответствовать правилу: (yourAge > 21) && (hasJob || hasCreditHistory) &&
hasGuarantor, с правильным использованием скобок для приоритета операций.
•	Программа должна вывести на экран значения обоих логических выражений (результаты по двум правилам).

public class Solution {
    public static void main(String[] args) {
        // Исходные данные


        // Кредит одобрят, если (возраст > 21 и есть работа) ИЛИ (есть кредитная история и поручитель)


        // Кредит одобрят, если (возраст > 21) И (есть работа ИЛИ кредитная история) И (есть поручитель)


        // Выводим результаты по двум правилам


    }
}

 */

public class Solution {
    public static void main(String[] args) {
        // Исходные данные
        int yourAge = 25;
        boolean hasJob = true;
        boolean hasCreditHistory = false;
        boolean hasGuarantor = true;

        // Кредит одобрят, если (возраст > 21 и есть работа) ИЛИ (есть кредитная история и поручитель)
        boolean creditApproved =  (yourAge > 21 && hasJob) || (hasCreditHistory && hasGuarantor);

        // Кредит одобрят, если (возраст > 21) И (есть работа ИЛИ кредитная история) И (есть поручитель)
        boolean creditMaybeApproved =  (yourAge > 21) && (hasJob || hasCreditHistory) && hasGuarantor;

        // Выводим результаты по двум правилам
        System.out.println(creditApproved);
        System.out.println(creditMaybeApproved);

    }
}