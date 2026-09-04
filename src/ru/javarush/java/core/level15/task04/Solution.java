package ru.javarush.java.core.level15.task04;
/*
Неизменяемые бирки товаров на складе 🏷️
Вы разрабатываете систему учёта товаров для склада. Каждый товар имеет уникальный идентификатор и наименование. После того как товар попадает на склад, его идентификатор и название не должны меняться – это как нестираемая бирка. Вы, однако, должны иметь возможность посмотреть эти данные.
Создайте класс Product. Внутри него определите два приватных поля: productID типа int и productName типа String.
Ваша задача — реализовать для этих полей только "окошки для просмотра" – публичные геттеры: getProductID() и getProductName(). Сеттеры для этих полей создавать не нужно, так как их значения после создания объекта не должны изменяться.
Добавьте публичный конструктор, который позволит установить productID и productName при создании нового объекта Product.
В классе Solution создайте экземпляр Product, например, с ID 101 и названием "Молоко". Затем используйте методы getProductID() и getProductName() для того, чтобы вывести эти данные на экран. Попробуйте также изменить поля productID или productName напрямую, как вы делали это с Person в предыдущих задачах — вы должны увидеть, что это невозможно, поскольку для них нет публичных сеттеров, и они защищены от прямого доступа.

Требования:
•	В классе Product должны быть определены два приватных поля: productID типа int и productName типа String.
•	В классе Product должны быть реализованы публичные методы getProductID() и getProductName(), которые возвращают значения соответствующих полей.
•	В классе Product не должно быть публичных сеттеров для полей productID и productName, чтобы исключить возможность их изменения после создания объекта.

public class Solution {
    public static void main(String[] args) {
        // Создаём товар с ID 101 и названием "Молоко"
        Product product = new Product(101, "Молоко");

        // Выводим данные через геттеры
        System.out.println(product.getProductID());
        System.out.println(product.getProductName());

        // Попытки изменить поля напрямую или через сеттеры невозможны:
        product.productID = 202;          // ошибка компиляции: поле private
        product.productName = "Кефир";    // ошибка компиляции: поле private
        product.setProductID(202);        // ошибка компиляции: метода нет
        product.setProductName("Кефир");  // ошибка компиляции: метода нет
    }
}

 */

public class Solution {
    public static void main(String[] args) {
        // Создаём товар с ID 101 и названием "Молоко"
        Product product = new Product(101, "Молоко");

        // Выводим данные через геттеры
        System.out.println(product.getProductID());
        System.out.println(product.getProductName());

        // Попытки изменить поля напрямую или через сеттеры невозможны:
//        product.productID = 202;          // ошибка компиляции: поле private
//        product.productName = "Кефир";    // ошибка компиляции: поле private
//        product.setProductID(202);        // ошибка компиляции: метода нет
//        product.setProductName("Кефир");  // ошибка компиляции: метода нет
    }
}

class Product {
    private int productID;
    private String productName;

    public int getProductID() {
        return this.productID;
    }
    public String getProductName() {
        return this.productName;
    }

    public Product(int id, String name) {
        this.productID = id;
        this.productName = name;
    }

}

/*
ихнее решение
// Класс товара с неизменяемыми полями — демонстрация инкапсуляции
public class Product {
    // Приватные поля скрывают детали реализации от внешнего кода
    private final int productID;
    private final String productName;

    // Публичный конструктор задаёт значения один раз при создании объекта
    public Product(int productID, String productName) {
        this.productID = productID;
        this.productName = productName;
    }

    // "Окошки для просмотра" — только геттеры
    public int getProductID() {
        return productID;
    }

    public String getProductName() {
        return productName;
    }

    // Сеттеры намеренно отсутствуют — значения менять нельзя после создания
}

 */