package ru.javarush.java.core.level17.task08;
/*
Фруктовые корзины: Что внутри? 🍏

Вы управляете складом, где собирают различные фруктовые корзины. Вам нужно отслеживать, какие именно фрукты попадают в корзины. Сначала определите два класса: общий Fruit и более конкретный Apple, причём Apple должен наследовать от Fruit.
Далее, создайте класс Basket, который будет представлять собой обычную корзину. Внутри Basket реализуйте метод Fruit getFruit(), который просто возвращает новый, общий объект Fruit. Это как будто вы берёте любой фрукт из обычной корзины.
Но у вас есть и специальные корзины! Создайте класс AppleBasket, который наследует от Basket. Эта корзина должна быть специализированной для яблок. Поэтому переопределите метод getFruit() в классе AppleBasket, но на этот раз укажите, что он возвращает объект типа Apple, а не просто Fruit. Это называется ковариантным возвращаемым типом — вы возвращаете более специфичный тип, чем тот, который был в родительском классе.
В вашем основном методе main создайте объект AppleBasket и вызовите у него метод getFruit(). Сохраните результат в переменную, например, harvestedItem. Затем используйте оператор instanceof, чтобы проверить, действительно ли harvestedItem является объектом типа Apple. Если это так, выведите на экран "Apple created", подтверждая, что из специализированной корзины вы получили именно яблоко.

Требования:
•	В программе должен быть определён класс с именем Fruit.
•	В программе должен быть определён класс Apple, который наследуется от класса Fruit.
•	В программе должен быть определён класс Basket, содержащий метод Fruit getFruit(), который возвращает новый объект Fruit.
•	В программе должен быть определён класс AppleBasket, который наследуется от класса Basket.
•	В классе AppleBasket должен быть переопределён метод getFruit(), который возвращает объект типа Apple.
•	В методе main должен быть создан объект типа AppleBasket, у которого вызывается метод getFruit(), а результат сохраняется в переменную.
•	В методе main результат вызова getFruit() должен быть проверен с помощью оператора instanceof на принадлежность к типу Apple.
•	Если результат проверки instanceof положительный, программа должна вывести на экран строку "Apple created".

public class Solution {
    public static void main(String[] args) {
        // Создаём специализированную корзину для яблок
        AppleBasket appleBasket = new AppleBasket();

        // Ковариантность: метод AppleBasket.getFruit() возвращает Apple,
        // но мы можем сохранить результат в переменную типа Fruit
        Fruit harvestedItem = appleBasket.getFruit();

        // Проверяем, действительно ли из корзины пришло яблоко
        if (harvestedItem instanceof Apple) {
            System.out.println("Apple created");
        }
    }
}

 */

public class Solution {
    public static void main(String[] args) {
        // Создаём специализированную корзину для яблок
        AppleBasket appleBasket = new AppleBasket();

        // Ковариантность: метод AppleBasket.getFruit() возвращает Apple,
        // но мы можем сохранить результат в переменную типа Fruit
        Fruit harvestedItem = appleBasket.getFruit();

        // Проверяем, действительно ли из корзины пришло яблоко
        if (harvestedItem instanceof Apple) {
            System.out.println("Apple created");
        }
    }
}

class Fruit {

}

class Apple extends Fruit {

}

class Basket {
    Fruit getFruit() {
        return new Fruit();
    }
}

class AppleBasket extends Basket {
    @Override
    Apple getFruit() {
         return new Apple();
    }
}

/*
// Базовый класс "Фрукт"
class Fruit { }

// Класс "Яблоко", наследуется от Fruit
class Apple extends Fruit { }

// Обычная корзина, возвращает любой фрукт
class Basket {
    // Возвращает новый общий объект Fruit
    Fruit getFruit() {
        return new Fruit();
    }
}

// Специализированная корзина для яблок
class AppleBasket extends Basket {
    // Переопределяем метод с ковариантным возвращаемым типом (Apple вместо Fruit)
    @Override
    Apple getFruit() {
        return new Apple();
    }
}
 */