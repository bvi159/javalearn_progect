package ru.javarush.java.core.level20.task12;

/*
Медиацентр: И Воспроизведение, И Запись

Вы разрабатываете универсальный медиацентр, который должен уметь как воспроизводить медиаконтент, так и записывать его. Ваша задача — создать систему, которая может тестировать эти разнообразные функции через единые универсальные процедуры.
Сначала определите два протокола медиаспособностей: Player (Воспроизводящий) с методом void play() и Recorder (Записывающий) с методом void record(). Затем создайте класс MediaDevice (Медиаустройство). Это устройство должно быть способно выполнять действия из обоих протоколов.
В методе play() выводите "Воспроизведение", а в методе record() — "Запись". Теперь напишите специальный статический метод testDevice(Player p, Recorder r). Этот метод должен принимать в качестве аргументов любой объект, который может быть Player, и любой объект, который может быть Recorder. Внутри этого метода вызовите p.play() и r.record().
В основной части вашей программы создайте один объект MediaDevice и продемонстрируйте его универсальность, передав его в метод testDevice таким образом, чтобы он выполнял роль как Player, так и Recorder.

Требования:
•	Должен быть объявлен интерфейс с именем Player, содержащий метод void play().
•	Должен быть объявлен интерфейс с именем Recorder, содержащий метод void record().
•	Класс MediaDevice должен реализовывать оба интерфейса: Player и Recorder.
•	Метод play() в классе MediaDevice должен выводить на экран строку "Воспроизведение", а метод record() — строку "Запись".
•	Должен быть реализован статический метод testDevice(Player p, Recorder r), который вызывает методы p.play() и r.record().
•	В основной части программы необходимо создать объект MediaDevice и передать его одновременно как аргумент p и r в метод testDevice.
•	В результате работы программы объект MediaDevice должен успешно выполнять обе функции — воспроизведение и запись — через единый универсальный метод testDevice.

public class Solution {
    // Универсальная процедура тестирования: принимает любой Player и любой Recorder
    public static void testDevice(Player p, Recorder r) {
        // Вызовы соответствующих возможностей
        p.play();
        r.record();
    }

    public static void main(String[] args) {
        // Создаём одно устройство
        MediaDevice device = new MediaDevice();

        // Передаём один и тот же объект сразу в обе роли: и Player, и Recorder
        testDevice(device, device);
    }
}

 */

public class Solution {
    // Универсальная процедура тестирования: принимает любой Player и любой Recorder
    public static void testDevice(Player p, Recorder r) {
        // Вызовы соответствующих возможностей
        p.play();
        r.record();
    }

    public static void main(String[] args) {
        // Создаём одно устройство
        MediaDevice device = new MediaDevice();

        // Передаём один и тот же объект сразу в обе роли: и Player, и Recorder
        testDevice(device, device);
    }
}

interface Player {
    void play();
}

interface Recorder {
    void record();
}

class MediaDevice implements Player, Recorder {
    @Override
    public void play() {
        System.out.println("Воспроизведение");
    }

    @Override
    public void record() {
        System.out.println("Запись");
    }
}

/*
// Протоколы медиаспособностей: воспроизведение и запись
interface Player {
    void play();
}

interface Recorder {
    void record();
}

// Универсальное медиаустройство, умеет и воспроизводить, и записывать
class MediaDevice implements Player, Recorder {
    @Override
    public void play() {
        // Действие "воспроизведение"
        System.out.println("Воспроизведение");
    }

    @Override
    public void record() {
        // Действие "запись"
        System.out.println("Запись");
    }
}

public class Solution {
    // Универсальная процедура тестирования: принимает любой Player и любой Recorder
    public static void testDevice(Player p, Recorder r) {
        // Вызовы соответствующих возможностей
        p.play();
        r.record();
    }

    public static void main(String[] args) {
        // Создаём одно устройство
        MediaDevice device = new MediaDevice();

        // Передаём один и тот же объект сразу в обе роли: и Player, и Recorder
        testDevice(device, device);
    }
}
 */