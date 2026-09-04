package ru.javarush.java.core.level07.task18;
/*
Инициализация пустых складских ячеек 📦
Вы готовите новую партию из 6 складских ячеек для системы управления складом. Изначально все эти ячейки полностью пусты и готовы к заполнению продуктами. Вместо того чтобы вручную помечать каждую ячейку как "Empty", вы знаете, что есть быстрый способ присвоить всем им это значение с помощью специальной утилиты. После этого вам нужно будет распечатать статус всех ячеек, чтобы подтвердить, что они готовы к использованию.

Создайте массив String[] warehouseSlots из 6 элементов типа String. Заполните все элементы этого массива значением "Empty" с помощью метода Arrays.fill. После заполнения выведите получившийся массив на экран, используя Arrays.toString. Ожидаемый результат: [Empty, Empty, Empty, Empty, Empty, Empty].

Требования:
•	Необходимо создать массив типа String длиной 6 элементов с именем warehouseSlots.
•	Все элементы массива warehouseSlots должны быть заполнены значением "Empty" с помощью метода Arrays.fill.
•	Для заполнения и вывода массива необходимо использовать методы класса Arrays из пакета java.util.
•	Массив warehouseSlots должен быть выведен на экран с помощью метода Arrays.toString.
•	Вывод на экран должен быть в формате: [Empty, Empty, Empty, Empty, Empty, Empty].
public class Solution {
    public static void main(String[] args) {
        // Создаем массив строк длиной 6 элементов


        // Заполняем все элементы массива значением "Empty" с помощью метода Arrays.fill


        // Выводим массив на экран в формате [Empty, Empty, Empty, Empty, Empty, Empty]

    }
}

 */
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        // Создаем массив строк длиной 6 элементов
        String[] warehouseSlots = new String[6];

        // Заполняем все элементы массива значением "Empty" с помощью метода Arrays.fill
        Arrays.fill(warehouseSlots, "Empty");

        // Выводим массив на экран в формате [Empty, Empty, Empty, Empty, Empty, Empty]
        System.out.println(Arrays.toString(warehouseSlots));

    }
}