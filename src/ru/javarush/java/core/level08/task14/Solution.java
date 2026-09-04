package ru.javarush.java.core.level08.task14;
/*
Попытка обновить список бонусов игрока 🎁
Вообразите, что вы отвечаете за обновление списка доступных бонусных предметов в игре. Вы хотите написать специальную функцию, которая "выдаст" игроку совершенно новый набор бонусов, заменив старые.

Создайте метод tryToSwapBonusList, который будет принимать playerCurrentBonuses — массив целых чисел, представляющий текущие бонусы игрока. Внутри этого метода вы полны решимости и присваиваете playerCurrentBonuses совершенно новый массив, например, new int[]{10, 20, 30}, наивно надеясь, что бонусы игрока полностью заменятся.

В главной мастерской вашей игры, в методе main, сначала создайте стартовый набор бонусов игрока: myBonusCollection = {1, 2, 3}. Затем вызовите tryToSwapBonusList, передав ему myBonusCollection. После этого, с волнением, проверьте, какой бонус стоит на первом месте в myBonusCollection, и выведите его на экран. Вы с удивлением обнаружите, что там все еще находится 1, демонстрируя, что ваша попытка полностью заменить список игрока не удалась так, как вы ожидали, ведь изменилась только локальная ссылка внутри метода.

Требования:
•	В программе должен быть реализован метод с именем tryToSwapBonusList, принимающий в качестве параметра массив целых чисел (int[]).
•	Внутри метода tryToSwapBonusList параметру playerCurrentBonuses должно быть присвоено новое значение — новый массив, например new int[]{10, 20, 30}.
•	В методе main должен быть создан массив myBonusCollection, инициализированный значениями {1, 2, 3}.
•	В методе main необходимо вызвать tryToSwapBonusList, передав в качестве аргумента массив myBonusCollection.
•	После вызова tryToSwapBonusList в методе main требуется вывести на экран первый элемент массива myBonusCollection, чтобы убедиться, что он остался равен 1.
•	Результат вывода должен показать, что массив myBonusCollection не был полностью заменён внутри метода, поскольку в Java массивы передаются по значению ссылки, а не по ссылке как объект.

public class Solution {

    public static void main(String[] args) {
        // Создаем массив с начальными бонусами игрока
        int[] myBonusCollection = {1, 2, 3};

        // Вызываем метод tryToSwapBonusList, передавая массив myBonusCollection
        tryToSwapBonusList(myBonusCollection);

        // Выводим первый элемент массива myBonusCollection
        // Ожидаем, что он останется равным 1, так как массивы передаются по значению ссылки
        System.out.println(myBonusCollection[0]);
    }

    public static void tryToSwapBonusList(int[] playerCurrentBonuses) {


    }
}


 */
public class Solution {

    public static void main(String[] args) {
        // Создаем массив с начальными бонусами игрока
        int[] myBonusCollection = {1, 2, 3};

        // Вызываем метод tryToSwapBonusList, передавая массив myBonusCollection
        tryToSwapBonusList(myBonusCollection);

        // Выводим первый элемент массива myBonusCollection
        // Ожидаем, что он останется равным 1, так как массивы передаются по значению ссылки
        System.out.println(myBonusCollection[0]);
    }

    public static void tryToSwapBonusList(int[] playerCurrentBonuses) {
        playerCurrentBonuses = new int[]{10, 20, 30};

    }
}