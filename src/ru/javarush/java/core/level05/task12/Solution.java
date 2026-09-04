package ru.javarush.java.core.level05.task12;
/*
В подземелье прячется дракон с 50 жизнями. У храброго рыцаря есть лишь 10 ударов, чтобы его победить.

Правила боя:

Каждый ход программа спрашивает у рыцаря, какой урон (число от 1 до 10) нанести.
Из здоровья дракона вычитается это число.
Если жизни дракона стали 0 или меньше — программа выводит: Дракон повержен!
Если удары закончились, а дракон всё ещё жив — программа сообщает: Рыцарь проиграл!
Требования:
•	Установить здоровье дракона = 50, количество ударов рыцаря = 10.
•	На каждом ходу программа должна запрашивать у пользователя число от 1 до 10.
•	Значение удара вычитается из текущего здоровья дракона.
•	Если здоровье дракона ≤ 0, программа выводит Дракон повержен! и завершает выполнение.
•	После каждого удара уменьшается счётчик оставшихся ударов рыцаря.
•	Если удары закончились, а здоровье дракона > 0, программа выводит Рыцарь проиграл!.

public class Solution {
    public static void main(String[] args) {
        int dragonHp = 50;
        int knightHits = 10;
        Scanner console = new Scanner(System.in);
        System.out.print("Вы напали на спящего дракона - дракон расстроился");

        // цикл боя
        while (knightHits > 0 && dragonHp > 0) {
            // Игрок указывает силу удара
            System.out.print("Сила удара (1-10): ");

            // Если слишком сильно или слишком слабо - то промах


            // отнимаем жизнь у дракона и ход у игрока


            // проверка, что дракон побежден

        }

        //проверка, что рыцарь проиграл

    }
}

 */
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        int dragonHp = 50;
        int knightHits = 10;
        Scanner console = new Scanner(System.in);
        System.out.print("Вы напали на спящего дракона - дракон расстроился");

        int power;
        // цикл боя
        while (knightHits > 0 && dragonHp > 0) {
            // Игрок указывает силу удара
            System.out.print("Сила удара (1-10): ");
            power = console.nextInt();
            // Если слишком сильно или слишком слабо - то промах
            if (power < 1 || power > 10) {
                System.out.println("Сила удара не соответсвтует заданным параметрам. Повторить!");
                continue;
            }
            // отнимаем жизнь у дракона и ход у игрока
            dragonHp = dragonHp - power;
            knightHits = --knightHits;
            // проверка, что дракон побежден
            if (dragonHp <= 0){
                System.out.println("Дракон повержен!");
                break;
            }

        }
        //проверка, что рыцарь проиграл
        if (knightHits <= 0 && dragonHp >= 0){
            System.out.println("Рыцарь проиграл!");
        }

    }
}
/*
Ихнее решение
public class Solution {
    public static void main(String[] args) {
        int dragonHp = 50;
        int knightHits = 10;
        Scanner console = new Scanner(System.in);
        System.out.print("Вы напали на спящего дракона - дракон расстроился");

        // цикл боя
        while (knightHits > 0 && dragonHp > 0) {
            // Игрок указывает силу удара
            System.out.print("Сила удара (1-10): ");

            // Если слишком сильно или слишком слабо - то промах
            int dmg = console.nextInt();
            if (dmg < 1 || dmg > 10) {
                System.out.println("Вы промахнулись.");
                continue;
            }

            // отнимаем жизнь у дракона и ход у игрока
            dragonHp -= dmg;
            knightHits--;

            // проверка, что дракон побежден
            if (dragonHp <= 0) {
                System.out.println("Дракон повержен!");
                return;
            }
        }

        //проверка, что рыцарь проиграл
        if (dragonHp > 0) {
            System.out.println("Рыцарь проиграл!");
        }
    }
}
 */