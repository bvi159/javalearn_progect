package ru.javarush.java.core.level17.task04;
/*
Фруктовая лавка: Разноцветные дары природы 🍎🍌

Вы владелец виртуальной фруктовой лавки и вам нужно систематизировать ваш товар. Все фрукты, независимо от их вида, обладают цветом. Создайте базовый класс Fruit с полем String fruitColor для хранения этого свойства. Добавьте в класс Fruit метод void printColor(), который будет выводить на экран строку "Цвет: <цвет фрукта>".
Теперь пришло время наполнить вашу лавку разнообразными фруктами. Создайте два новых класса: Apple и Banana. Оба этих класса должны наследовать все свойства и методы от вашего класса Fruit.
В вашем основном методе main создайте по одному объекту каждого из этих новых видов фруктов. Для объекта Apple задайте fruitColor как "красный", а для объекта Banana — как "жёлтый". Затем для каждого из этих фруктов вызовите метод printColor(), чтобы продемонстрировать их цвет. Ваша программа должна отобразить:

Цвет: красный
Цвет: жёлтый
Требования:
•	Должен быть создан класс с именем Fruit.
•	Класс Fruit должен содержать поле типа String с именем fruitColor.
•	Класс Fruit должен содержать метод void printColor(), который выводит на экран строку "Цвет: <цвет фрукта>", где <цвет фрукта> — значение поля fruitColor.
•	Должны быть созданы два класса — Apple и Banana, которые наследуют класс Fruit с помощью ключевого слова extends.
•	В методе main должны быть созданы объекты классов Apple и Banana.
•	Поле fruitColor объекта Apple должно быть установлено в значение "красный", а объекта Banana — в значение "жёлтый".
•	Для каждого объекта (Apple и Banana) должен быть вызван метод printColor(), в результате чего программа выведет: Цвет: красный Цвет: жёлтый

public class Solution {
    public static void main(String[] args) {
        // Создаем объекты яблока и банана
        Apple apple = new Apple();
        Banana banana = new Banana();

        // Задаем цвета для каждого фрукта (поле унаследовано от Fruit)
        apple.fruitColor = "красный";
        banana.fruitColor = "жёлтый";

        // Выводим цвет каждого фрукта
        apple.printColor();
        banana.printColor();
    }
}

 */
public class Solution {
    public static void main(String[] args) {
        // Создаем объекты яблока и банана
        Apple apple = new Apple();
        Banana banana = new Banana();

        // Задаем цвета для каждого фрукта (поле унаследовано от Fruit)
        apple.fruitColor = "красный";
        banana.fruitColor = "жёлтый";

        // Выводим цвет каждого фрукта
        apple.printColor();
        banana.printColor();
    }
}

class Fruit {
    String fruitColor;

    void printColor() {
        System.out.println("Цвет: " + fruitColor);
    }
}

class Apple extends Fruit {

}

class Banana extends Fruit {

}

/*
// Базовый класс с общим свойством "цвет"
class Fruit {
    String fruitColor; // цвет фрукта

    // Метод печатает цвет в требуемом формате
    void printColor() {
        System.out.println("Цвет: " + fruitColor);
    }
}

// Класс Apple наследует Fruit
class Apple extends Fruit {
    // Дополнительных полей и методов не требуется для задачи
}

// Класс Banana наследует Fruit
class Banana extends Fruit {
    // Дополнительных полей и методов не требуется для задачи
}
 */