package ru.javarush.java.core.level23.task20;
/*
Идеальная структура для вашего продукта 📦

Вы строите чётко организованную систему инвентаризации, где каждый элемент имеет своё место и цель. Вы хотите, чтобы каждый "чертеж" (класс) был составлен по идеальному порядку, чтобы другие разработчики могли легко его читать и понимать. Ваша миссия — не просто создать класс Product, но и расположить все его компоненты в соответствии с рекомендованными Java code conventions.
Внутри класса Product вам понадобится:
Статическое целочисленное поле totalProductCount, которое будет отслеживать общее количество созданных продуктов.
Обычное строковое поле productName, чтобы каждый конкретный продукт имел свое имя.
Конструктор, который принимает имя продукта в качестве параметра и присваивает его полю productName, а также увеличивает totalProductCount при каждом создании нового продукта.
Публичный метод getProductName, который позволит безопасно получить имя продукта извне.
Расположите все эти элементы класса в стандартном порядке: сначала статические поля, затем обычные поля, потом конструкторы, и в конце методы.

В основном методе main "создайте" один продукт, например, "Банан", и затем выведите его имя на экран, чтобы подтвердить, что ваш идеально структурированный класс работает как часы.

Требования:
•	В классе Product должно быть объявлено статическое целочисленное поле totalProductCount для хранения общего количества созданных продуктов.
•	В классе Product должно быть объявлено нестатическое строковое поле productName для хранения имени продукта.
•	В классе Product сначала должны быть объявлены все статические поля, затем обычные поля, после них конструкторы, и только затем методы, в строгом соответствии с Java code conventions.
•	В классе Product должен быть реализован конструктор, принимающий имя продукта в качестве параметра, присваивающий это значение полю productName и увеличивающий totalProductCount при каждом создании объекта.
•	В классе Product должен быть реализован публичный метод getProductName, возвращающий значение поля productName.
•	В методе main должен быть создан объект класса Product (например, с именем "Банан"), после чего имя этого продукта должно быть выведено на экран с помощью метода getProductName.

public class Solution {
    public static void main(String[] args) {
        // Создаем один продукт и проверяем работу геттера
        Product banana = new Product("Банан");
        System.out.println(banana.getProductName());
    }
}

 */

public class Solution {
    public static void main(String[] args) {
        // Создаем один продукт и проверяем работу геттера
        Product banana = new Product("Банан");
        System.out.println(banana.getProductName());
    }
}

class Product {
    static int totalProductCount = 0;
    private String productName;
    Product(String prodName) {
        productName = prodName;
        totalProductCount++;
    }

    public String getProductName(){
        return this.productName;
    }
}

/*
public class Solution {
    public static void main(String[] args) {
        // Создаем один продукт и проверяем работу геттера
        Product banana = new Product("Банан");
        System.out.println(banana.getProductName());
    }
}

// Класс Product оформлен по code conventions:
class Product {

    // 1) Статические поля — общие для всех объектов класса
    private static int totalProductCount;

    // 2) Обычные (нестатические) поля — состояние конкретного объекта
    private String productName;

    // 3) Конструктор с параметром: сохраняем имя и увеличиваем общий счетчик
    public Product(String productName) {
        this.productName = productName;
        totalProductCount++; // фиксируем факт создания нового продукта
    }

    // 4) Публичный геттер — безопасно возвращаем имя продукта
    public String getProductName() {
        return productName;
    }
}
 */