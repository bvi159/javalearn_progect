package ru.javarush.java.core.level23.task15;
/*
Умный дом: Кипящий чайник

Вы управляете умным домом, и вам нужно иметь возможность универсально включать различные электроприборы. Создайте абстрактный класс Appliance с абстрактным методом turnOn(), который будет представлять общую команду "включить".

Теперь создайте два конкретных прибора: Kettle (чайник) и Toaster (тостер), оба они наследуют от Appliance. В классе Kettle добавьте уникальный метод boil(), который выводит "Вода закипела", ведь только чайник умеет кипятить воду.

В основном методе main объявите переменную общего типа Appliance и "подключите" к ней объект Kettle. Вы захотите убедиться, что "подключенный" прибор действительно является чайником, прежде чем пытаться вскипятить воду. Используйте оператор instanceof, чтобы проверить, является ли ваш homeAppliance на самом деле Kettle. Если это действительно так, безопасно приведите его тип к Kettle и вызовите специфический метод boil(). Программа выведет "Вода закипела", подтверждая, что вы корректно определили тип прибора и использовали его уникальные возможности.

Требования:
•	Необходимо создать абстрактный класс Appliance с абстрактным методом turnOn().
•	Должны быть созданы два класса Kettle и Toaster, которые наследуются от Appliance и реализуют метод turnOn().
•	Класс Kettle должен содержать уникальный метод boil(), который выводит на экран "Вода закипела".
•	В методе main должна быть объявлена переменная типа Appliance, которой присваивается объект класса Kettle.
•	Перед вызовом метода boil() необходимо проверить с помощью оператора instanceof, что объект действительно является экземпляром Kettle.
•	Если объект является Kettle, его тип должен быть приведён к Kettle, после чего вызывается метод boil().
•	В результате выполнения программы на экран должно быть выведено "Вода закипела".

public class Solution {
    public static void main(String[] args) {
        // Полиморфная переменная базового типа "Appliance"
        Appliance homeAppliance = new Kettle();

        // Перед вызовом специфичного метода проверяем реальный тип прибора
        if (homeAppliance instanceof Kettle) {
            // Безопасное приведение типа после instanceof
            Kettle kettle = (Kettle) homeAppliance;
            kettle.boil(); // Выведет: "Вода закипела"
        }
    }
}

 */

public class Solution {
    public static void main(String[] args) {
        // Полиморфная переменная базового типа "Appliance"
        Appliance homeAppliance = new Kettle();

        // Перед вызовом специфичного метода проверяем реальный тип прибора
        if (homeAppliance instanceof Kettle) {
            // Безопасное приведение типа после instanceof
            ((Kettle) homeAppliance).boil();
//            Kettle kettle = (Kettle) homeAppliance;
//            kettle.boil(); // Выведет: "Вода закипела"
        }
    }
}

abstract class Appliance {
    abstract void turnOn();
}

class Kettle extends Appliance {

    @Override
    void turnOn() {
            System.out.println("включить");
    }

    public void boil() {
        System.out.println("Вода закипела");
    }
}

class Toaster extends Appliance {
    @Override
    void turnOn() {
        System.out.println("включить");
    }
}

/*

// Абстрактный класс, общий для всех электроприборов
abstract class Appliance {
    // Универсальная команда "включить" для любого прибора
    public abstract void turnOn();
}

// Конкретный прибор: чайник
class Kettle extends Appliance {
    @Override
    public void turnOn() {
        // Имитация включения прибора; в этой задаче вывод не требуется
    }

    // Уникальная возможность чайника — кипятить воду
    public void boil() {
        System.out.println("Вода закипела");
    }
}

// Конкретный прибор: тостер
class Toaster extends Appliance {
    @Override
    public void turnOn() {
        // Имитация включения прибора; в этой задаче вывод не требуется
    }
}

public class Solution {
    public static void main(String[] args) {
        // Полиморфная переменная базового типа "Appliance"
        Appliance homeAppliance = new Kettle();

        // Перед вызовом специфичного метода проверяем реальный тип прибора
        if (homeAppliance instanceof Kettle) {
            // Безопасное приведение типа после instanceof
            Kettle kettle = (Kettle) homeAppliance;
            kettle.boil(); // Выведет: "Вода закипела"
        }
    }
}

 */