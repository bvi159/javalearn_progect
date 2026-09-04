package ru.javarush.java.core.level08.task16;
/*
Обновление содержимого волшебной шкатулки 📦
Вообразите, что вы хранитель волшебных шкатулок, каждая из которых содержит в себе некое магическое число, представляющее её силу. Ваша задача — обновить силу одной из шкатулок, но при этом понять, как работают магические заклинания.

Создайте класс MagicalContainer с одним публичным полем magicValue типа int.

В вашем главном хранилище, в методе main, создайте одну такую волшебную шкатулку: myTreasureChest = new MagicalContainer(), и присвойте её начальную силу: myTreasureChest.magicValue = 15.

Теперь создайте специальный метод attemptToEnchantContainer, который будет принимать одну MagicalContainer в качестве параметра. Внутри этого метода вы сначала пытаетесь увеличить силу шкатулки, устанавливая её magicValue на 99. Затем, в порыве волшебства, вы пытаетесь "заменить" саму шкатулку, присваивая параметру метода новый объект MagicalContainer с magicValue равным 42.

После вызова attemptToEnchantContainer с вашей myTreasureChest, немедленно проверьте, какова теперь сила myTreasureChest.magicValue и выведите её на экран. Вы с удивлением обнаружите, что сила шкатулки стала 99, а не 42, что наглядно покажет вам, как работают ссылки на объекты в мире магии Java: метод может изменить содержимое объекта, на который ссылается, но не может изменить саму ссылку, переданную ему извне.

Требования:
•	В программе должен быть создан класс с именем MagicalContainer.
•	Класс MagicalContainer должен содержать одно публичное поле типа int с именем magicValue.
•	В методе main необходимо создать объект класса MagicalContainer и присвоить его переменной myTreasureChest.
•	Полю magicValue объекта myTreasureChest должно быть присвоено значение 15.
•	В программе должен быть реализован отдельный метод с именем attemptToEnchantContainer, который принимает один параметр типа MagicalContainer.
•	Внутри метода attemptToEnchantContainer значение поля magicValue переданного объекта должно быть изменено на 99.
•	Внутри метода attemptToEnchantContainer параметру метода должно быть присвоено новое значение — создан новый объект MagicalContainer с magicValue равным 42.
•	После вызова метода attemptToEnchantContainer с myTreasureChest необходимо вывести на экран значение поля magicValue объекта myTreasureChest.
•	После выполнения всех операций значение myTreasureChest.magicValue должно быть равно 99, а не 42.

// Класс MagicalContainer представляет волшебную шкатулку с магическим значением
class MagicalContainer {
    // Публичное поле magicValue для хранения магического значения
    public int magicValue;
}

public class Solution {
    public static void main(String[] args) {
        // Создаем объект класса MagicalContainer и присваиваем его переменной myTreasureChest
        MagicalContainer myTreasureChest = new MagicalContainer();

        // Инициализируем поле magicValue значением 15
        myTreasureChest.magicValue = 15;

        // Вызываем метод attemptToEnchantContainer с объектом myTreasureChest
        attemptToEnchantContainer(myTreasureChest);

        // Выводим значение magicValue объекта myTreasureChest на экран
        // Ожидаемое значение: 99
        System.out.println(myTreasureChest.magicValue);
    }

    // Метод attemptToEnchantContainer пытается изменить магическое значение и заменить объект
    public static void attemptToEnchantContainer(MagicalContainer container) {
        // Изменяем значение magicValue переданного объекта на 99


        // Пытаемся заменить объект на новый с magicValue равным 42

    }
}

 */

// Класс MagicalContainer представляет волшебную шкатулку с магическим значением
class MagicalContainer {
    // Публичное поле magicValue для хранения магического значения
    public int magicValue;
}

public class Solution {
    public static void main(String[] args) {
        // Создаем объект класса MagicalContainer и присваиваем его переменной myTreasureChest
        MagicalContainer myTreasureChest = new MagicalContainer();
        
        // Инициализируем поле magicValue значением 15
        myTreasureChest.magicValue = 15;

        // Вызываем метод attemptToEnchantContainer с объектом myTreasureChest
        attemptToEnchantContainer(myTreasureChest);

        // Выводим значение magicValue объекта myTreasureChest на экран
        // Ожидаемое значение: 99
        System.out.println(myTreasureChest.magicValue);
    }

    // Метод attemptToEnchantContainer пытается изменить магическое значение и заменить объект
    public static void attemptToEnchantContainer(MagicalContainer container) {
        // Изменяем значение magicValue переданного объекта на 99
        container.magicValue = 99;

        // Пытаемся заменить объект на новый с magicValue равным 42
        container = new MagicalContainer();
        container.magicValue = 42;

    }
}