package ru.javarush.java.core.level19.task16;
/*
Модуль обработки заказов в розничном магазине 🛒

Вообразите себя архитектором системы обработки заказов для крупного розничного бизнеса, который принимает покупки как через интернет, так и в физических точках продаж. Все заказы, независимо от их типа, имеют общую сумму и проходят этап обработки, но детали этой обработки существенно различаются.
Для начала, создайте абстрактный класс Order с полем double amount для хранения суммы заказа и абстрактным методом process(), который будет отвечать за его обработку. Затем реализуйте два конкретных типа заказа: OnlineOrder и OfflineOrder. Оба класса должны наследовать Order. В классе OnlineOrder метод process() должен выводить на экран "Обработка онлайн-заказа на сумму [сумма]", подставляя реальную сумму.
Аналогично, в классе OfflineOrder метод process() должен выводить "Обработка оффлайн-заказа на сумму [сумма]". Чтобы продемонстрировать мощь вашей системы, в методе main создайте массив, способный хранить объекты типа Order. Смешайте в нём несколько онлайн- и оффлайн-заказов с разными суммами. После этого, используя цикл, пройдитесь по всему массиву и для каждого заказа вызовите метод process(). В результате вы должны увидеть на экране строки, подтверждающие обработку каждого заказа, например: "Обработка онлайн-заказа на сумму 100.0" и "Обработка оффлайн-заказа на сумму 50.0".

Требования:
•	В программе должен быть абстрактный класс Order с полем double amount и абстрактным методом process().
•	Класс OnlineOrder должен наследовать Order и реализовывать метод process(), который выводит строку "Обработка онлайн-заказа на сумму [сумма]" с подстановкой значения поля amount.
•	Класс OfflineOrder должен наследовать Order и реализовывать метод process(), который выводит строку "Обработка оффлайн-заказа на сумму [сумма]" с подстановкой значения поля amount.
•	В методе main должен быть создан массив, способный хранить объекты типа Order, содержащий как OnlineOrder, так и OfflineOrder с разными значениями суммы.
•	В методе main необходимо пройтись по массиву заказов в цикле и для каждого заказа вызвать метод process(), чтобы на экране отобразились соответствующие сообщения о типе и сумме заказа.

 */


// Демонстрация абстракции и полиморфизма на примере обработки заказов
public class Solution {
    public static void main(String[] args) {
        // Создаем массив базового типа Order — он может хранить объекты любых подклассов
        Order[] orders = {
                new OnlineOrder(100.0),
                new OfflineOrder(50.0),
                new OnlineOrder(299.99),
                new OfflineOrder(75.5)
        };

        // Полиморфизм: для каждого заказа вызывается его вариант метода process()
        for (Order order : orders) {
            order.process();
        }
    }
}

abstract class Order {
    protected double amount;

    public Order(double amount) {
        this.amount = amount;
    }
    public abstract void process();
}

class OnlineOrder extends Order {
    public OnlineOrder(double onlineAmount) {
        super(onlineAmount);
    }

    @Override
    public void process() {
        System.out.println("Обработка онлайн-заказа на сумму " + amount);
    }
}

class OfflineOrder extends Order {
    public OfflineOrder(double offlineAmount) {
        super(offlineAmount);
    }

    @Override
    public void process() {
        System.out.println("Обработка оффлайн-заказа на сумму " + amount);
    }
}



/*
// Абстрактный класс — общая сущность "Заказ"
abstract class Order {
    // Общая сумма заказа
    protected double amount;

    public Order(double amount) {
        this.amount = amount;
    }

    // Абстрактный метод обработки заказа (реализация — в наследниках)
    public abstract void process();
}

// Конкретный тип заказа: онлайн
class OnlineOrder extends Order {
    public OnlineOrder(double amount) {
        super(amount);
    }

    @Override
    public void process() {
        // Выводим сообщение с подстановкой суммы заказа
        System.out.println("Обработка онлайн-заказа на сумму " + amount);
    }
}

// Конкретный тип заказа: оффлайн
class OfflineOrder extends Order {
    public OfflineOrder(double amount) {
        super(amount);
    }

    @Override
    public void process() {
        // Выводим сообщение с подстановкой суммы заказа
        System.out.println("Обработка оффлайн-заказа на сумму " + amount);
    }
}

 */