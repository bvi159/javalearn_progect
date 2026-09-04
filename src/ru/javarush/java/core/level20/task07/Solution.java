package ru.javarush.java.core.level20.task07;
/*
Мультифункциональное Устройство Офиса

Вы получили задание смоделировать новое поколение офисной техники — универсальное устройство, которое умеет выполнять сразу несколько задач.
Определите два отдельных протокола способностей: Printable (Печатаемый) с командой void print() и Scannable (Сканируемый) с командой void scan(). Затем сконструируйте класс MultiFunctionDevice (Мультифункциональное Устройство). Это устройство должно быть настоящим универсалом, реализуя оба протокола: и Printable, и Scannable.
Когда MultiFunctionDevice получает команду print(), оно должно выводить на экран сообщение "Печать...". И аналогично, когда ему отдают команду scan(), оно должно сообщать "Сканирование...".

Требования:
•	Необходимо создать интерфейс с именем Printable, содержащий абстрактный метод void print().
•	Необходимо создать интерфейс с именем Scannable, содержащий абстрактный метод void scan().
•	Класс MultiFunctionDevice должен реализовывать оба интерфейса: Printable и Scannable.
•	В классе MultiFunctionDevice метод print() должен выводить на экран сообщение "Печать...".
•	В классе MultiFunctionDevice метод scan() должен выводить на экран сообщение "Сканирование...".

public class Solution {
    public static void main(String[] args) {
        // Небольшая демонстрация: устройство умеет и печатать, и сканировать
        MultiFunctionDevice device = new MultiFunctionDevice();
        device.print();
        device.scan();
    }
}

 */
public class Solution {
    public static void main(String[] args) {
        // Небольшая демонстрация: устройство умеет и печатать, и сканировать
        MultiFunctionDevice device = new MultiFunctionDevice();
        device.print();
        device.scan();
    }
}

interface Printable {
    void print();
}

interface Scannable {
    void scan();
}

class MultiFunctionDevice implements Printable, Scannable {
    public void print() {
        System.out.println("Печать...");
    }

    public void scan() {
        System.out.println("Сканирование...");
    }
}

/*
// Интерфейс "Печатаемый" с одной командой печати
interface Printable {
    void print();
}

// Интерфейс "Сканируемый" с одной командой сканирования
interface Scannable {
    void scan();
}

// Многофункциональное устройство реализует оба интерфейса
class MultiFunctionDevice implements Printable, Scannable {
    @Override
    public void print() {
        // Реакция на команду печати
        System.out.println("Печать...");
    }

    @Override
    public void scan() {
        // Реакция на команду сканирования
        System.out.println("Сканирование...");
    }
}

public class Solution {
    public static void main(String[] args) {
        // Небольшая демонстрация: устройство умеет и печатать, и сканировать
        MultiFunctionDevice device = new MultiFunctionDevice();
        device.print();
        device.scan();
    }
}
 */