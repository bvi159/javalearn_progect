package ru.javarush.java.core.level19.task08;
/*
Кадровая система IT-компании 💼

Представьте, что вы создаете сложную кадровую систему для процветающей IT-компании. У каждого сотрудника есть имя, и каждый получает зарплату, но способ её начисления может кардинально отличаться в зависимости от должности.
Для начала, создайте абстрактный класс Employee с полем String name и абстрактным методом double getSalary(), который будет отвечать за расчет уникальной зарплаты для каждой категории.
Далее, воплотите в жизнь две основные категории сотрудников: класс Manager (для которого зарплата фиксирована и хранится в поле double baseSalary) и класс Developer (чьё вознаграждение зависит от часовой ставки double hourlyRate и количества отработанных часов int hoursWorked). В каждом из этих классов вам нужно будет реализовать метод getSalary(): для Manager он просто должен возвращать значение baseSalary, а для Developer — произведение hourlyRate на hoursWorked.
Чтобы продемонстрировать гибкость вашей системы, в методе main создайте массив, способный хранить объекты типа Employee. Добавьте в него двух тестовых сотрудников: Manager по имени "Анна" с базовой зарплатой 100000, и Developer по имени "Иван" с часовой ставкой 500 и 160 отработанными часами. Затем пройдитесь по этому массиву и для каждого сотрудника выведите на экран его имя и рассчитанную зарплату, используя формат "Имя: [имя_сотрудника], зарплата: [зарплата_сотрудника]".

Требования:
•	Необходимо создать абстрактный класс Employee с полем String name и абстрактным методом double getSalary().
•	Класс Manager должен наследоваться от Employee, содержать поле double baseSalary и реализовывать метод getSalary(), возвращающий baseSalary.
•	Класс Developer должен наследоваться от Employee, содержать поля double hourlyRate и int hoursWorked, а также реализовывать метод getSalary(), возвращающий произведение hourlyRate на hoursWorked.
•	Классы Manager и Developer должны корректно инициализировать поле name родительского класса Employee через конструктор.
•	В методе main необходимо создать массив, способный хранить объекты типа Employee.
•	В массив сотрудников должны быть добавлены: Manager с именем "Анна" и базовой зарплатой 100000, а также Developer с именем "Иван", часовой ставкой 500 и 160 отработанными часами.
•	В методе main необходимо пройтись по массиву сотрудников и для каждого вывести на экран строку в формате: "Имя: [имя_сотрудника], зарплата: [зарплата_сотрудника]".

public class Solution {
    public static void main(String[] args) {
        // Массив базового типа Employee может хранить различные подклассы — это полиморфизм
        Employee[] staff = new Employee[2];

        // Добавляем тестовых сотрудников
        staff[0] = new Manager("Анна", 100000);
        staff[1] = new Developer("Иван", 500, 160);

        // Проходим по массиву и выводим имя и зарплату каждого сотрудника
        for (Employee e : staff) {
            System.out.println("Имя: " + e.getName() + ", зарплата: " + e.getSalary());
        }
    }
}

 */
public class Solution {
    public static void main(String[] args) {
        // Массив базового типа Employee может хранить различные подклассы — это полиморфизм
        Employee[] staff = new Employee[2];

        // Добавляем тестовых сотрудников
        staff[0] = new Manager("Анна", 100000);
        staff[1] = new Developer("Иван", 500, 160);

        // Проходим по массиву и выводим имя и зарплату каждого сотрудника
        for (Employee e : staff) {
            System.out.println("Имя: " + e.getName() + ", зарплата: " + e.getSalary());
        }
    }
}

abstract class Employee {
    String name;

    Employee(String name) {
        this.name = name;
    }
    abstract double getSalary();
    abstract String getName();
}

class Manager extends Employee {
    double baseSalary;

    Manager(String name, double baseSalary) {
        super(name);
        this.baseSalary = baseSalary;
    }
    @Override
    double getSalary() {
        return baseSalary;
    }

    @Override
    String getName() {
        return name;
    }

}

class Developer extends Employee {
    double hourlyRate;
    int hoursWorked;
    Developer(String name, double hourlyRate, int hoursWorked) {
        super(name);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }
    @Override
    double getSalary() {
        return hourlyRate * hoursWorked;
    }

    @Override
    String getName() {
        return name;
    }
}

/*
// Демонстрация абстрактного класса и полиморфизма
abstract class Employee {
    protected String name; // Имя сотрудника

    public Employee(String name) {
        this.name = name;
    }

    // Абстрактный метод — у каждой роли свой способ расчёта зарплаты
    public abstract double getSalary();

    public String getName() {
        return name;
    }
}

// Менеджер с фиксированной зарплатой
class Manager extends Employee {
    private double baseSalary;

    public Manager(String name, double baseSalary) {
        super(name); // Инициализация поля name через конструктор базового класса
        this.baseSalary = baseSalary;
    }

    @Override
    public double getSalary() {
        return baseSalary; // Для менеджера — просто базовая зарплата
    }
}

// Разработчик с почасовой оплатой
class Developer extends Employee {
    private double hourlyRate;
    private int hoursWorked;

    public Developer(String name, double hourlyRate, int hoursWorked) {
        super(name); // Инициализация поля name через конструктор базового класса
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    @Override
    public double getSalary() {
        return hourlyRate * hoursWorked; // Почасовая ставка * отработанные часы
    }
}

public class Solution {
    public static void main(String[] args) {
        // Массив базового типа Employee может хранить различные подклассы — это полиморфизм
        Employee[] staff = new Employee[2];

        // Добавляем тестовых сотрудников
        staff[0] = new Manager("Анна", 100000);
        staff[1] = new Developer("Иван", 500, 160);

        // Проходим по массиву и выводим имя и зарплату каждого сотрудника
        for (Employee e : staff) {
            System.out.println("Имя: " + e.getName() + ", зарплата: " + e.getSalary());
        }
    }
}
 */