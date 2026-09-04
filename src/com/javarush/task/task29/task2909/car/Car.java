package com.javarush.task.task29.task2909.car;

import java.util.Date;

/*
Пришло время немного порефакторить.

Википедия говорит: "Рефакторинг (англ. refactoring) или реорганизация кода - процесс изменения внутренней структуры программы, не затрагивающий её внешнего поведения и имеющий целью облегчить понимание её работы. В основе рефакторинга лежит последовательность небольших эквивалентных (то есть сохраняющих поведение) преобразований. Поскольку каждое преобразование маленькое, программисту легче проследить за его правильностью, и в то же время вся последовательность может привести к существенной перестройке программы и улучшению её согласованности и четкости."
Такими маленькими преобразованиями мы и будем заниматься. После каждого изменения следи за сохранностью работоспособности кода. Многие методы рефакторинга не однократно применены и проверены сообществом программистов. Получили свои названия. Каждое задание будет сопровождено названием рефакторинга. Ты всегда можешь прочитать более подробно о нем в книге Мартина Фаулера "Рефакторинг: Улучшение существующего кода".

Начнем. Внимательно ознакомься с кодом пакета human (человек).

Задания:
1.1. Подъем поля. Подними поле children в базовый класс.
1.2. Подъем метода. Подними сеттер и геттер для children в базовый класс.
1.3. Инкапсуляция коллекции.
1.3.1. Метод getChildren должен возвращать не модифицируемое представление списка children.
1.3.2. Убери сеттер для children.
1.3.3. Добавь методы addChild(Human) и removeChild(Human). Реализуй их логику.

Требования:
•	Поле children должно быть расположено в классе Human, и не должно быть расположено в классах Teacher и Student.
•	Сеттер и геттер для поля children должны быть расположены в классе Human, и не должны быть расположены в классах Teacher и Student.
•	Метод getChildren в классе Human должен возвращать Collections.unmodifiableList(children).
•	Необходимо удалить метод setChildren из класса Human.
•	Необходимо добавить методы addChild(Human) и removeChild(Human) в класс Human, и реализовать их.


 */
public abstract class Car {
    static public final int TRUCK = 0;
    static public final int SEDAN = 1;
    static public final int CABRIOLET = 2;

    // Объявляем константы (обычно в начале класса)
    public static final int MAX_TRUCK_SPEED = 80;
    public static final int MAX_SEDAN_SPEED = 120;
    public static final int MAX_CABRIOLET_SPEED = 90;

    double fuel;

    public double summerFuelConsumption;
    public double winterFuelConsumption;
    public double winterWarmingUp;

    private int type;

    private boolean driverAvailable;
    private int numberOfPassengers;

    protected Car(int type, int numberOfPassengers) {
        this.type = type;
        this.numberOfPassengers = numberOfPassengers;
    }

    // ВНУТРЕННИЙ метод - используется только внутри класса
    private boolean canPassengersBeTransferred() {
//        return isEngineOk && hasFuel && passengerCount > 0;
        return isDriverAvailable() && fuel > 0;
    }

    public static Car create(int type, int numberOfPassengers) {
        switch (type) {
            case TRUCK:
                return new Truck(numberOfPassengers);
            case SEDAN:
                return new Sedan(numberOfPassengers);
            case CABRIOLET:
                return new Cabriolet(numberOfPassengers);
            default:
                return null;
        }
    }

    //    public int fill(double numberOfLiters) {
//        if (numberOfLiters < 0)
//            return -1;
//        fuel += numberOfLiters;
//        return 0;
//    }
    public double getWinterConsumption(int length) {
        double consumption;
        consumption = length * winterFuelConsumption + winterWarmingUp;
        return consumption;
    }

    public double getSummerConsumption(int length) {
        double consumption;
        consumption = length * summerFuelConsumption;
        return consumption;
    }


    public boolean isSummer(Date date, Date summerStart, Date summerEnd) {
        return !date.before(summerStart) && !date.after(summerEnd);
//        или
//        if ((date.after(summerStart) || date.equals(summerStart)) &&
//                (date.before(summerEnd) || date.equals(summerEnd))) {
//            return true;
//        }
//        return false;
    }

    public void fill(double numberOfLiters) {
        if (numberOfLiters < 0)
            throw new RuntimeException("Ничего не заправили");

        fuel += numberOfLiters;
    }

    //    public double getTripConsumption(Date date, int length, Date SummerStart, Date SummerEnd) {
    public double getTripConsumption(Date date, int length, Date SummerStart, Date SummerEnd) {
//        double consumption;
//        boolean isSummer = isSummer(date, SummerStart, SummerEnd);
//        if (isSummer) {
//            consumption = getWinterConsumption(length);
//        } else {
//            consumption = getSummerConsumption(length);
//        }
//        return consumption;
        if (isSummer(date, SummerStart, SummerEnd)) {
            return getSummerConsumption(length);
        } else {
            return getWinterConsumption(length);
        }
    }

    public int getNumberOfPassengersCanBeTransferred() {
//        if (!isDriverAvailable())
//            return 0;
//        if (fuel <= 0)
//            return 0;
        if (canPassengersBeTransferred()) {
            return numberOfPassengers;
        }
        return 0;
    }

    public boolean isDriverAvailable() {
        return driverAvailable;
    }

    public void setDriverAvailable(boolean driverAvailable) {
        this.driverAvailable = driverAvailable;
    }

    public void startMoving() {
        if (numberOfPassengers > 0) {
            fastenPassengersBelts();
        }
            fastenDriverBelt();
    }

    public void fastenPassengersBelts() {
    }

    public void fastenDriverBelt() {
    }

    public abstract int getMaxSpeed();
}