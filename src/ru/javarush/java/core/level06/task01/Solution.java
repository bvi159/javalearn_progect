package ru.javarush.java.core.level06.task01;
/*
Создание инвентаря для героя RPG 🎮

Представьте, что вы — разработчик новой, захватывающей ролевой игры. Вам нужно создать базовый инвентарь
для вашего первого героя, чтобы отслеживать его характеристики. Для этого объявите несколько переменных
с различными числовыми типами и присвойте им стартовые значения.

Создайте переменную byte characterLevel для уровня персонажа, short armorRating для показателя брони, i
nt experiencePoints для накопленного опыта, long goldCoins для несметных сокровищ, float magicResistance
для сопротивления магии (может быть дробным!), и double criticalHitChance для шанса критического удара (требует высокой точности).

После присвоения значений с гордостью выведите всю эту жизненно важную статистику на экран, убедившись,
что каждая из них отображается на новой строке, чтобы каждый мог восхититься силой вашего героя!

Требования:
•	В программе должны быть объявлены переменные: characterLevel типа byte, armorRating типа short, experiencePoints типа int, goldCoins типа long, magicResistance типа float, criticalHitChance типа double.
•	Каждой из перечисленных переменных должно быть присвоено стартовое значение.
•	Все переменные должны быть выведены на экран.
•	Каждая переменная должна выводиться на отдельной строке.

public class Solution {
    public static void main(String[] args) {
        // Объявляем уровень персонажа (тип byte)

        // Объявляем показатель брони (тип short)

        // Объявляем накопленный опыт (тип int)

        // Объявляем количество золотых монет (тип long)

        // Объявляем сопротивление магии (тип float)

        // Объявляем шанс критического удара (тип double)


        // Выводим каждую характеристику героя на новой строке





    }
}

 */
public class Solution {
    public static void main(String[] args) {
        // Объявляем уровень персонажа (тип byte)
        byte characterLevel = 0;

        // Объявляем показатель брони (тип short)
        short armorRating = 10000;

        // Объявляем накопленный опыт (тип int)
        int experiencePoints = 2_128_001_002;

        // Объявляем количество золотых монет (тип long)
        long goldCoins = 200_200_128_001_002L;

        // Объявляем сопротивление магии (тип float)
        float magicResistance = -3.158654600125f;

        // Объявляем шанс критического удара (тип double)
        double criticalHitChance = -1.7E+308;

        // Выводим каждую характеристику героя на новой строке

        System.out.println("characterLevel: " + characterLevel);
        System.out.println("armorRating:" + armorRating);
        System.out.println("experiencePoints: " + experiencePoints);
        System.out.println("goldCoins :" + goldCoins);
        System.out.println("magicResistance: " + magicResistance);
        System.out.println("criticalHitChance: " + criticalHitChance);

    }
}