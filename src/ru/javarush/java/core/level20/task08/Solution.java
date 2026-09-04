package ru.javarush.java.core.level20.task08;
/*
Смартфон: От Общих Устройств к Персональным Гаджетам

Представьте, что вы создаёте базовую архитектуру для системы "умного дома". Все устройства в доме имеют общие черты, например, их можно включить, и они выполняют некую "работу". Но некоторые устройства, такие как смартфоны, обладают дополнительной специфической функцией — их можно заряжать.

Сперва определите общий шаблон устройства в виде абстрактного класса Appliance (Прибор). У Appliance будет метод turnOn() (включить), который при вызове просто выводит "Устройство включено". Также у него должен быть абстрактный метод work() (работать), который каждое конкретное устройство будет реализовывать по-своему.

Затем объявите специальный протокол зарядки — интерфейс Chargeable (Заряжаемый) с одним методом void charge() (заряжать).

Теперь создайте класс SmartPhone (Смартфон). SmartPhone должен быть потомком Appliance (наследуя его базовые функции) и одновременно реализовать интерфейс Chargeable (получая возможность зарядки). Реализуйте метод work() для смартфона так, чтобы он выводил "Смартфон работает", а метод charge() — "Смартфон заряжается".

В основной части вашей программы создайте новый SmartPhone и последовательно вызовите все три его уникальных действия: turnOn(), work() и charge().

Требования:
•	Должен быть создан абстрактный класс Appliance с методом turnOn() и абстрактным методом work().
•	Метод turnOn() в классе Appliance должен выводить на экран "Устройство включено".
•	Абстрактный метод work() должен быть объявлен в классе Appliance и реализован в дочерних классах.
•	Должен быть создан интерфейс Chargeable с методом void charge().
•	Класс SmartPhone должен наследоваться от Appliance и реализовывать интерфейс Chargeable.
•	Метод work() в классе SmartPhone должен выводить "Смартфон работает".
•	Метод charge() в классе SmartPhone должен выводить "Смартфон заряжается".
•	В основной части программы должен быть создан объект SmartPhone, для которого последовательно вызываются методы turnOn(), work() и charge().

public class Solution {
    public static void main(String[] args) {
        // Создаем смартфон и последовательно вызываем его действия
        SmartPhone phone = new SmartPhone();
        phone.turnOn();
        phone.work();
        phone.charge();
    }
}

 */
public class Solution {
    public static void main(String[] args) {
        // Создаем смартфон и последовательно вызываем его действия
        SmartPhone phone = new SmartPhone();
        phone.turnOn();
        phone.work();
        phone.charge();
    }
}

abstract class Appliance {
    void turnOn() {
        System.out.println("Устройство включено");
    }

    abstract void work();
}

interface Chargeable {
    void charge();
}

class SmartPhone extends Appliance implements Chargeable {
    @Override
    void work() {
        System.out.println("Смартфон работает");
    }

    @Override
    public void charge() {
        System.out.println("Смартфон заряжается");
    }

}

/*
// Базовый абстрактный класс "Прибор"
abstract class Appliance {
    // Общий для всех приборов метод включения
    public void turnOn() {
        System.out.println("Устройство включено");
    }

    // Абстрактный метод работы — конкретная реализация в наследниках
    public abstract void work();
}

// Интерфейс "Заряжаемый" — описывает возможность зарядки
interface Chargeable {
    void charge();
}

// Класс "Смартфон": и прибор, и заряжаемое устройство
class SmartPhone extends Appliance implements Chargeable {
    @Override
    public void work() {
        System.out.println("Смартфон работает");
    }

    @Override
    public void charge() {
        System.out.println("Смартфон заряжается");
    }
}

public class Solution {
    public static void main(String[] args) {
        // Создаем смартфон и последовательно вызываем его действия
        SmartPhone phone = new SmartPhone();
        phone.turnOn();
        phone.work();
        phone.charge();
    }
}
 */