package ru.javarush.java.core.level23.task10;
/*
Безопасное управление ценами в онлайн-магазине 💰

Вы администратор онлайн-магазина, и ваша задача — обеспечить строгий контроль над ценами товаров, чтобы они не могли быть изменены кем угодно напрямую. Создайте класс Product, который будет представлять каждый товар. Внутри него объявите приватное поле productPrice типа double. Это поле productPrice должно быть скрыто от прямого доступа извне. Чтобы другие части программы могли безопасно получать или изменять цену, вам понадобится реализовать два публичных метода: getPrice (для чтения значения productPrice) и setPrice (для установки нового значения productPrice).
В основном методе main "выложите" новый товар на полку магазина, то есть создайте объект Product. Сначала установите ему цену, используя метод setPrice, например, 49.99. Затем, чтобы убедиться, что цена правильно установлена, получите её обратно с помощью метода getPrice и выведите на экран. Это покажет, как вы контролируемо управляете важными данными вашего товара.

Требования:
•	Поле productPrice должно быть объявлено с модификатором доступа private внутри класса Product.
•	Доступ к полю productPrice должен осуществляться только через публичные методы, прямой доступ к нему извне невозможен.
•	В классе Product должен быть реализован публичный метод getPrice, возвращающий текущее значение productPrice.
•	В классе Product должен быть реализован публичный метод setPrice, позволяющий установить новое значение productPrice.
•	В методе main должен быть создан объект Product, цена должна быть установлена через setPrice и считана через getPrice.

public class Solution {
    public static void main(String[] args) {
        // "Выкладываем" товар на полку — создаем объект Product
        Product product = new Product();

        // Устанавливаем цену товара через публичный сеттер (прямого доступа к полю нет)
        product.setPrice(49.99);

        // Считываем цену через геттер и выводим на экран — контролируемый доступ к данным
        double currentPrice = product.getPrice();
        System.out.println(currentPrice);
    }
}


 */

public class Solution {
    public static void main(String[] args) {
        // "Выкладываем" товар на полку — создаем объект Product
        Product product = new Product();

        // Устанавливаем цену товара через публичный сеттер (прямого доступа к полю нет)
        product.setPrice(49.99);

        // Считываем цену через геттер и выводим на экран — контролируемый доступ к данным
        double currentPrice = product.getPrice();
        System.out.println(currentPrice);
    }
}

class Product {
    private double productPrice;

    public double getPrice() {
        return productPrice;
    }

    public void setPrice(double currentPrice) {
        productPrice = currentPrice;
    }

}

/*
public class Solution {
    public static void main(String[] args) {
        // "Выкладываем" товар на полку — создаем объект Product
        Product product = new Product();

        // Устанавливаем цену товара через публичный сеттер (прямого доступа к полю нет)
        product.setPrice(49.99);

        // Считываем цену через геттер и выводим на экран — контролируемый доступ к данным
        double currentPrice = product.getPrice();
        System.out.println(currentPrice);
    }
}

// Класс, инкапсулирующий цену товара
class Product {
    // Приватное поле: извне напрямую недоступно
    private double productPrice;

    // Публичный метод для чтения текущей цены
    public double getPrice() {
        return productPrice;
    }

    // Публичный метод для установки новой цены
    public void setPrice(double price) {
        this.productPrice = price;
    }
}
 */



/*

 */