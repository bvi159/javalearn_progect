package ru.javarush.java.core.level19.task15;
/*
Управление автопарком компании 🚚🚲

Представьте, что вы разрабатываете централизованную систему управления для крупного транспортного парка. Каждое транспортное средство имеет свою модель и умеет передвигаться, но способ его передвижения индивидуален.
Для начала, создайте абстрактный класс Vehicle с полем String model для хранения названия модели и абстрактным методом move(), который будет символизировать движение.
Затем воплотите в жизнь два конкретных вида транспорта: Car и Bicycle. Оба этих класса должны наследовать Vehicle.
В классе Car метод move() должен выводить на экран "Машина [модель] едет", подставляя реальную модель.
Аналогично, в классе Bicycle метод move() должен выводить "Велосипед [модель] едет".
Чтобы продемонстрировать гибкость вашей системы, в методе main создайте динамический список, способный хранить объекты типа Vehicle. Добавьте в него экземпляр Car с моделью "Lada" и экземпляр Bicycle с моделью "Stels". После этого пройдитесь по всему списку и для каждого транспортного средства вызовите его метод move().
В результате вы должны увидеть на экране строки "Машина Lada едет" и "Велосипед Stels едет", что подтвердит правильную работу вашей системы.

Требования:
•	Должен быть создан абстрактный класс Vehicle с полем String model и абстрактным методом move().
•	Класс Vehicle должен содержать поле String model для хранения названия модели транспортного средства.
•	Классы Car и Bicycle должны наследовать абстрактный класс Vehicle.
•	В классе Car должен быть реализован метод move(), который выводит на экран строку "Машина [модель] едет", где [модель] — значение поля model.
•	В классе Bicycle должен быть реализован метод move(), который выводит на экран строку "Велосипед [модель] едет", где [модель] — значение поля model.
•	В методе main должен быть создан динамический список (например, ArrayList), способный хранить объекты типа Vehicle.
•	В список должны быть добавлены экземпляр Car с моделью "Lada" и экземпляр Bicycle с моделью "Stels".
•	В методе main необходимо пройтись по всем элементам списка и вызвать для каждого их метод move(), чтобы получить корректный вывод на экран.

 */


import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        // Динамический список, способный хранить объекты типа Vehicle (полиморфизм)
        List<Vehicle> vehicles = new ArrayList<>();

        // Добавляем разные виды транспорта
        vehicles.add(new Car("Lada"));
        vehicles.add(new Bicycle("Stels"));

        // Проходим по списку и вызываем move() у каждого транспорта
        for (Vehicle v : vehicles) {
            v.move();
        }
    }
}

abstract class Vehicle {
    protected final String model;

    public Vehicle(String model) {
        this.model = model;
    }

    public abstract void move();
}

class Car extends Vehicle {
    public Car(String carModel) {
        super(carModel);
    }

    @Override
    public void move() {
        System.out.println("Машина " + model + " едет");
    }
}

class Bicycle extends Vehicle {
    public Bicycle(String byceModel) {
        super(byceModel);
    }

    @Override
    public void move() {
        System.out.println("Велосипед " + model+ " едет");
    }
}

/*
// Абстрактный базовый класс для транспорта.
// Содержит поле model и абстрактный метод move(), который реализуют подклассы.
abstract class Vehicle {
    protected final String model;

    public Vehicle(String model) {
        this.model = model;
    }

    public abstract void move();
}

// Конкретный транспорт — Машина
class Car extends Vehicle {
    public Car(String model) {
        super(model);
    }

    @Override
    public void move() {
        System.out.println("Машина " + model + " едет");
    }
}

// Конкретный транспорт — Велосипед
class Bicycle extends Vehicle {
    public Bicycle(String model) {
        super(model);
    }

    @Override
    public void move() {
        System.out.println("Велосипед " + model + " едет");
    }
}
 */