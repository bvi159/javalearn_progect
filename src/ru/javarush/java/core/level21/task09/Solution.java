package ru.javarush.java.core.level21.task09;
/*
Пульт управления умным устройством ⚙️

Представьте, что вы программируете пульт управления для нового умного устройства. Устройство должно
уметь выполнять базовую операцию увеличения значения и иметь стандартную функцию сброса настроек до заводских.
Функция сброса является общей для многих устройств, поэтому её логика должна быть определена прямо в "чертеже" устройства (интерфейсе).
Сначала определите интерфейс Counter, который включает абстрактный метод increment() и default-метод reset().
Метод reset() при вызове должен просто выводить "Counter reset". Затем создайте класс MyCounter, который будет конкретной реализацией вашего Counter. Метод increment() в MyCounter должен выводить "Counter incremented". В основной части программы создайте экземпляр MyCounter и последовательно вызовите increment(), а затем reset(), чтобы продемонстрировать, как устройство выполняет свои функции.

Требования:
•	Необходимо создать интерфейс с именем Counter.
•	Интерфейс Counter должен содержать абстрактный метод increment() без реализации.
•	Интерфейс Counter должен содержать default-метод reset(), реализованный прямо в интерфейсе.
•	Метод reset() в интерфейсе Counter должен выводить на экран строку "Counter reset".
•	Должен быть создан класс MyCounter, реализующий интерфейс Counter.
•	В классе MyCounter метод increment() должен выводить на экран строку "Counter incremented".
•	В основной части программы необходимо создать объект типа MyCounter и вызвать у него методы increment() и reset() по очереди.

public class Solution {
    public static void main(String[] args) {
        // Создаем устройство и демонстрируем работу методов
        MyCounter device = new MyCounter();
        device.increment(); // должен вывести "Counter incremented"
        device.reset();     // должен вывести "Counter reset"
    }
}


 */
public class Solution {
    public static void main(String[] args) {
        // Создаем устройство и демонстрируем работу методов
        MyCounter device = new MyCounter();
        device.increment(); // должен вывести "Counter incremented"
        device.reset();     // должен вывести "Counter reset"
    }
}

interface Counter {
    void increment();

    default void reset() {
        System.out.println("Counter reset");
    }
}

class MyCounter implements Counter {
    @Override
    public void increment() {
        System.out.println("Counter incremented");
    }
}


/*
// Интерфейс с абстрактным методом и default-методом
interface Counter {
    // Абстрактный метод без реализации
    void increment();

    // Default-метод: реализация прямо в интерфейсе
    default void reset() {
        System.out.println("Counter reset");
    }
}

// Конкретная реализация интерфейса Counter
class MyCounter implements Counter {
    @Override
    public void increment() {
        System.out.println("Counter incremented");
    }
}

 */