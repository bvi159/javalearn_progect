package ru.javarush.java.core.level03.task14;
/*
Использование скобок в логических выражениях 🎸
Вы хотите купить билет на концерт любимой группы. Условия покупки такие:

ticketsOnSale (присвойте ей значение false)
haveMoneyForTicket (присвойте ей значение true)
concertNotCanceled (присвойте ей значение false)
Чтобы купить билет, нужно, чтобы: «либо билеты были в продаже, либо у вас были деньги и концерт не отменили».

Создайте выражение boolean canBuy = ticketsOnSale || haveMoneyForTicket && concertNotCanceled;

Затем создайте новое выражение, добавив скобки так: boolean canBuyWithNewMeaning = (ticketsOnSale || haveMoneyForTicket) && concertNotCanceled;

Выведите оба результата.

Требования:
•	В программе должны быть объявлены и инициализированы три переменные типа boolean: ticketsOnSale (значение false), haveMoneyForTicket (значение true), concertNotCanceled (значение false).
•	Должна быть создана переменная boolean canBuy, которая инициализируется выражением ticketsOnSale || haveMoneyForTicket && concertNotCanceled.
•	Должна быть создана переменная boolean canBuyWithNewMeaning, которая инициализируется выражением (ticketsOnSale || haveMoneyForTicket) && concertNotCanceled.
•	Оба значения, canBuy и canBuyWithNewMeaning, должны быть выведены на экран.

public class Solution {
    public static void main(String[] args) {
        // Объявляем и инициализируем переменные согласно условию задачи


        // Первое логическое выражение без дополнительных скобок


        // Второе логическое выражение с добавлением скобок


        // Выводим результаты обоих выражений на экран


    }
}

 */

public class Solution {
    public static void main(String[] args) {
        // Объявляем и инициализируем переменные согласно условию задачи
        boolean ticketsOnSale = false;
        boolean haveMoneyForTicket = true;
        boolean concertNotCanceled = false;
        // Первое логическое выражение без дополнительных скобок
        boolean canBuy = ticketsOnSale || haveMoneyForTicket && concertNotCanceled;

        // Второе логическое выражение с добавлением скобок
        boolean canBuyWithNewMeaning = (ticketsOnSale || haveMoneyForTicket) && concertNotCanceled;

        // Выводим результаты обоих выражений на экран
        System.out.println(canBuy);
        System.out.println(canBuyWithNewMeaning);

    }
}