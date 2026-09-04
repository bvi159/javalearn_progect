package ru.javarush.java.core.level10.task03;
/*
Передача ценников в цифровую корзину 🛒
Представьте, что вы работаете над системой учёта товаров в магазине. У вас есть точная цена товара, но для временного хранения в цифровой "корзине" или списках, где требуются объекты, вам нужно обернуть эту цену. А после использования в этой "корзине" — развернуть обратно для дальнейших расчётов.

Итак, создайте переменную типа double с именем productPrice и присвойте ей значение 3.14. Затем, используя автоматическую "упаковку" (autoboxing), передайте это значение переменной типа Double с именем wrappedPrice. После этого, чтобы вернуть цену для расчётов, используйте автоматическую "распаковку" (unboxing) и присвойте значение из wrappedPrice обратно в новую переменную типа double с именем finalCalculatedPrice. В конце выведите finalCalculatedPrice на экран, чтобы увидеть финальную, уже "распакованную" цену.

Требования:
•	В программе должна быть объявлена переменная с именем productPrice типа double и значением 3.14.
•	В программе должна быть объявлена переменная с именем wrappedPrice типа Double.
•	Значение переменной productPrice должно быть присвоено переменной wrappedPrice с помощью автоматической упаковки (autoboxing).
•	Значение переменной wrappedPrice должно быть присвоено новой переменной с именем finalCalculatedPrice типа double с помощью автоматической распаковки (unboxing).
•	Программа должна вывести значение переменной finalCalculatedPrice на экран.

public class Solution {
    public static void main(String[] args) {
        // Исходная цена товара (примитивный тип double)
        double productPrice = 3.14;

        // Автоматическая упаковка (autoboxing) в объект типа-обёртки Double


        // Автоматическая распаковка (unboxing) обратно в примитивный тип double


        // Вывод финального "разупакованного" значения на экран

    }
}

 */
public class Solution {
    public static void main(String[] args) {
        // Исходная цена товара (примитивный тип double)
        double productPrice = 3.14;

        // Автоматическая упаковка (autoboxing) в объект типа-обёртки Double
        Double wrappedPrice = Double.valueOf(productPrice);

        // Автоматическая распаковка (unboxing) обратно в примитивный тип double
        double finalCalculatedPrice = wrappedPrice;

        // Вывод финального "разупакованного" значения на экран
        System.out.println(finalCalculatedPrice);

    }
}
/*
Ихнее решение
public class Solution {
    public static void main(String[] args) {
        // Исходная цена товара (примитивный тип double)
        double productPrice = 3.14;

        // Автоматическая упаковка (autoboxing) в объект типа-обёртки Double
        Double wrappedPrice = productPrice;

        // Автоматическая распаковка (unboxing) обратно в примитивный тип double
        double finalCalculatedPrice = wrappedPrice;

        // Вывод финального "разупакованного" значения на экран
        System.out.println(finalCalculatedPrice);
    }
}
 */