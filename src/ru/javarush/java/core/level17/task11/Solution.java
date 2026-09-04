package ru.javarush.java.core.level17.task11;
/*
Родословная питомца: Имена на разных уровнях 🐾

Вы создаёте базу данных для генеалогического древа животных, где каждое животное имеет общее видовое название, а затем более конкретное. Создайте класс Animal и объявите в нём поле String name, сразу присвоив ему значение "Животное". Это будет общее имя для всех животных.
Теперь создайте класс Cat, который наследует от Animal. В классе Cat также объявите поле String name, но присвойте ему значение "Кошка". Обратите внимание, что поле name из Animal теперь "затенено" полем name из Cat.
Чтобы продемонстрировать, как получить доступ к обоим именам, реализуйте в классе Cat метод void printNames(). Этот метод должен выводить на экран две строки: сначала "Имя из Cat: " и значение поля name из класса Cat (которое "Кошка"). Затем, на новой строке, он должен выводить "Имя из Animal: " и значение поля name из базового класса Animal, используя для этого super.name.
В вашем основном методе main создайте объект Cat и вызовите у него метод printNames(). Ваша программа должна чётко показать различие:

Имя из Cat: Кошка
Имя из Animal: Животное
Требования:
•	Должен быть создан класс Animal, в котором объявлено поле String name с присвоенным значением "Животное".
•	Должен быть создан класс Cat, который наследует Animal и также содержит поле String name, которому присвоено значение "Кошка".
•	Поле name в классе Cat должно затенять (скрывать) поле name из класса Animal.
•	В классе Cat должен быть реализован метод void printNames(), который выводит две строки: сначала значение поля name из Cat, затем значение поля name из Animal с помощью super.name.
•	В методе printNames() для получения значения поля name из Animal необходимо использовать выражение super.name.
•	В методе main должен быть создан объект класса Cat, у которого вызывается метод printNames() для вывода значений обоих полей name.

public class Solution {
    public static void main(String[] args) {
        // Создаем объект кошки и печатаем оба имени
        Cat cat = new Cat();
        cat.printNames();
    }
}

 */


public class Solution {
    public static void main(String[] args) {
        // Создаем объект кошки и печатаем оба имени
        Cat cat = new Cat();
        cat.printNames();
    }
}

class Animal {
    String name = "Животное";
}

class Cat extends Animal {
    String name = "Кошка";

    void printNames() {
        System.out.println("Имя из Cat: " + name);
        System.out.println("Имя из Animal: " + super.name);
    }
}

/*
// Базовый класс с общим именем для всех животных
class Animal {
    String name = "Животное";
}

// Класс Cat наследует Animal и "затеняет" поле name своим
class Cat extends Animal {
    String name = "Кошка";

    // Печатаем имя из текущего класса и из базового класса через super
    void printNames() {
        System.out.println("Имя из Cat: " + name);          // обращение к полю Cat
        System.out.println("Имя из Animal: " + super.name);  // обращение к полю Animal через super
    }
}
 */