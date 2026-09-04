package ru.javarush.java.core.level20.task19;

/*
Приветствия на Разный Лад: Приветливый или Формальный

Вы разрабатываете приложение, которое должно здороваться с пользователями, но стиль приветствия может меняться в зависимости от контекста — иногда нужно быть дружелюбным, иногда — более официальным. Вы хотите легко переключаться между этими "стратегиями" приветствия.
Создайте контракт стратегии приветствия — интерфейс GreetingStrategy с методом void greet(String name).
Реализуйте две конкретные стратегии:
FriendlyGreeting (Дружелюбное Приветствие), которое при вызове greet() выводит: "Привет, " + name "!".
FormalGreeting (Формальное Приветствие), которое выводит: "Здравствуйте, " + name ".".
Теперь создайте класс Greeter (Приветствующий). Внутри Greeter будет храниться текущая GreetingStrategy. Добавьте метод setStrategy(GreetingStrategy strategy) для изменения стратегии "на лету", а также метод greet(String name), который просто вызывает greet() у текущей выбранной стратегии.
В основной части вашей программы создайте объект Greeter. Сначала установите ему FriendlyGreeting и попросите его поприветствовать "Васю". Затем измените стратегию на FormalGreeting и снова попросите поприветствовать "Васю". Вы должны увидеть, как стиль приветствия меняется:

Привет, Вася!
Здравствуйте, Вася.
Требования:
•	Необходимо создать интерфейс GreetingStrategy с методом void greet(String name).
•	Класс FriendlyGreeting должен реализовывать интерфейс GreetingStrategy и выводить "Привет, " + name + "!" при вызове метода greet.
•	Класс FormalGreeting должен реализовывать интерфейс GreetingStrategy и выводить "Здравствуйте, " + name + "." при вызове метода greet.
•	Класс Greeter должен содержать приватное поле типа GreetingStrategy для хранения текущей стратегии приветствия.
•	Класс Greeter должен предоставлять публичный метод setStrategy(GreetingStrategy strategy) для изменения стратегии приветствия во время выполнения.
•	Класс Greeter должен предоставлять метод greet(String name), который делегирует выполнение методу greet текущей стратегии.
•	В основной части программы необходимо создать объект Greeter, установить ему сначала FriendlyGreeting и вызвать greet("Вася"), затем сменить стратегию на FormalGreeting и снова вызвать greet("Вася"), чтобы увидеть разницу в стиле приветствия.

// Демонстрация паттерна "Стратегия": переключаем стиль приветствия на лету.
public class Solution {
    public static void main(String[] args) {
        Greeter greeter = new Greeter();

        // Сначала используем дружелюбную стратегию
        greeter.setStrategy(new FriendlyGreeting());
        greeter.greet("Вася");

        // Затем переключаемся на формальную стратегию
        greeter.setStrategy(new FormalGreeting());
        greeter.greet("Вася");
    }
}

 */
// Демонстрация паттерна "Стратегия": переключаем стиль приветствия на лету.
public class Solution {
    public static void main(String[] args) {
        Greeter greeter = new Greeter();

        // Сначала используем дружелюбную стратегию
        greeter.setStrategy(new FriendlyGreeting());
        greeter.greet("Вася");

        // Затем переключаемся на формальную стратегию
        greeter.setStrategy(new FormalGreeting());
        greeter.greet("Вася");
    }
}

interface GreetingStrategy {
    void greet(String name);
}

class FriendlyGreeting implements GreetingStrategy {
    @Override
    public void greet(String name) {
        System.out.println("Привет, " + name + "!");
    }
}

class FormalGreeting implements GreetingStrategy {
    @Override
    public void greet(String name) {
        System.out.println("Здравствуйте, " + name + ".");
    }

}

class Greeter {
    private GreetingStrategy currentStrategy;
//    Greeter(GreetingStrategy currentStrategy) {
//        this.currentStrategy = currentStrategy;
//    }

    public void setStrategy(GreetingStrategy myStrategy) {
        currentStrategy = myStrategy;
    }
    void greet(String name) {
        currentStrategy.greet(name);
    }

}

/*
// Контракт стратегии приветствия
interface GreetingStrategy {
    void greet(String name);
}

// Дружелюбная стратегия: "Привет, <name>!"
class FriendlyGreeting implements GreetingStrategy {
    @Override
    public void greet(String name) {
        System.out.println("Привет, " + name + "!");
    }
}

// Формальная стратегия: "Здравствуйте, <name>."
class FormalGreeting implements GreetingStrategy {
    @Override
    public void greet(String name) {
        System.out.println("Здравствуйте, " + name + ".");
    }
}

// Класс-контекст: хранит текущую стратегию и делегирует ей вызов greet
class Greeter {
    // Текущая выбранная стратегия приветствия
    private GreetingStrategy strategy;

    // Позволяет менять стратегию "на лету"
    public void setStrategy(GreetingStrategy strategy) {
        this.strategy = strategy;
    }

    // Делегируем приветствие текущей стратегии
    public void greet(String name) {
        // Предполагаем, что стратегия установлена перед вызовом
        strategy.greet(name);
    }
}
 */