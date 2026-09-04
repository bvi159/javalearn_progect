package ru.javarush.java.core.level25.task07;
/*
Воздушные Приключения: Единая Взлётная Полоса 🧩

Добро пожаловать в мир воздушных приключений, где вы управляете различными летающими объектами! Ваша задача – создать систему, которая позволяет запускать в небо всё, что способно летать, независимо от того, это машина или живое существо.
Начните с определения общего контракта для всех летающих объектов, создав интерфейс CanFly с единственным методом soar(), который символизирует взлёт.
Теперь воплотите этот контракт в жизнь для двух совершенно разных сущностей: могучего Aircraft (самолёта) и грациозного Eagle (орла). Каждый из них должен реализовать интерфейс CanFly, выводя при вызове soar() соответствующее сообщение: "Самолёт взлетает!" или "Орёл парит!".
Наконец, в вашем главном методе main, создайте универсальную "взлётную полосу" – статический метод launchIntoSky(CanFly flyingObject), который сможет принять любой объект, способный летать, и заставить его взлететь, вызвав его метод soar(). Создайте по одному экземпляру Aircraft и Eagle и запустите их в небо через вашу универсальную взлётную полосу!

Требования:
•	В программе должен быть создан интерфейс CanFly с единственным методом soar() без параметров.
•	Должен быть создан класс Aircraft, реализующий интерфейс CanFly и переопределяющий метод soar(), который выводит "Самолёт взлетает!".
•	Должен быть создан класс Eagle, реализующий интерфейс CanFly и переопределяющий метод soar(), который выводит "Орёл парит!".
•	В программе должен быть реализован статический метод launchIntoSky, принимающий объект типа CanFly и вызывающий его метод soar().
•	В методе main должны быть созданы экземпляры классов Aircraft и Eagle, которые передаются в метод launchIntoSky для запуска, что приводит к выводу соответствующих сообщений.

public class Solution {
    // Универсальная «взлётная полоса»: принимает любой объект, который умеет летать
    public static void launchIntoSky(CanFly flyingObject) {
        // Полиморфный вызов: конкретный soar() определяется у переданного объекта
        flyingObject.soar();
    }

    public static void main(String[] args) {
        // Создаём летающие объекты разных типов
        Aircraft aircraft = new Aircraft();
        Eagle eagle = new Eagle();

        // Запускаем их в небо через универсальную взлётную полосу
        launchIntoSky(aircraft);
        launchIntoSky(eagle);
    }
}

*/
public class Solution {
    // Универсальная «взлётная полоса»: принимает любой объект, который умеет летать
    public static void launchIntoSky(CanFly flyingObject) {
        // Полиморфный вызов: конкретный soar() определяется у переданного объекта
        flyingObject.soar();
    }

    public static void main(String[] args) {
        // Создаём летающие объекты разных типов
        Aircraft aircraft = new Aircraft();
        Eagle eagle = new Eagle();

        // Запускаем их в небо через универсальную взлётную полосу
        launchIntoSky(aircraft);
        launchIntoSky(eagle);
    }
}

interface CanFly {
    void soar();
}

class Aircraft implements CanFly {
    @Override
    public void soar() {
        System.out.println("Самолёт взлетает!");
    }
}

class Eagle implements CanFly {
    @Override
    public void soar() {
        System.out.println("Орёл парит!");
    }
}

/*
// Интерфейс-«контракт» для всех летающих объектов
interface CanFly {
    void soar(); // метод «взлететь/парить»
}

// Самолёт реализует общий контракт
class Aircraft implements CanFly {
    @Override
    public void soar() {
        System.out.println("Самолёт взлетает!");
    }
}

// Орёл реализует общий контракт
class Eagle implements CanFly {
    @Override
    public void soar() {
        System.out.println("Орёл парит!");
    }
}

public class Solution {
    // Универсальная «взлётная полоса»: принимает любой объект, который умеет летать
    public static void launchIntoSky(CanFly flyingObject) {
        // Полиморфный вызов: конкретный soar() определяется у переданного объекта
        flyingObject.soar();
    }

    public static void main(String[] args) {
        // Создаём летающие объекты разных типов
        Aircraft aircraft = new Aircraft();
        Eagle eagle = new Eagle();

        // Запускаем их в небо через универсальную взлётную полосу
        launchIntoSky(aircraft);
        launchIntoSky(eagle);
    }
}
 */