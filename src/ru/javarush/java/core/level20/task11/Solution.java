package ru.javarush.java.core.level20.task11;
/*
Универсальное Действие: Единая Кнопка для Всего

Представьте, что вы разрабатываете единый пульт управления для различных устройств, и на всех этих устройствах есть кнопка, которая называется одинаково — "Выполнить действие". Ваш пульт должен уметь нажимать эту кнопку, независимо от того, к какому устройству он подключен.

Создайте два независимых контракта управления: InterfaceA и InterfaceB. В каждом из них определите метод void doAction() (выполнить действие). Теперь создайте класс MultiAction (Многофункциональное Действие). Этот класс должен реализовывать оба InterfaceA и InterfaceB.

Реализуйте метод doAction() в классе MultiAction так, чтобы он выводил на экран сообщение "Выполнено действие для обоих интерфейсов". Это покажет, что одно и то же действие, вызываемое через разные контракты, на самом деле выполняется одним и тем же способом.

В вашей основной программе создайте объект MultiAction и вызовите его метод doAction().

Требования:
•	В программе должны быть объявлены два независимых интерфейса с именами InterfaceA и InterfaceB.
•	В каждом из интерфейсов InterfaceA и InterfaceB должен быть определён метод void doAction() без параметров.
•	Должен быть создан класс MultiAction, который реализует оба интерфейса — InterfaceA и InterfaceB.
•	В классе MultiAction должен быть реализован метод doAction(), который выводит на экран сообщение "Выполнено действие для обоих интерфейсов".
•	В основной программе необходимо создать объект класса MultiAction и вызвать у него метод doAction().

public class Solution {
    public static void main(String[] args) {
        // Создаем объект и вызываем его метод doAction()
        MultiAction action = new MultiAction();
        action.doAction();
    }
}

 */
public class Solution {
    public static void main(String[] args) {
        // Создаем объект и вызываем его метод doAction()
        MultiAction action = new MultiAction();
        action.doAction();
    }
}

interface InterfaceA {
    void doAction();
}

interface InterfaceB {
    void doAction();
}

class MultiAction implements InterfaceA, InterfaceB {
    @Override
    public void doAction() {
        System.out.println("Выполнено действие для обоих интерфейсов");
    }
}

/*
interface InterfaceA {
    // Контракт №1: устройство умеет выполнять действие
    void doAction();
}

interface InterfaceB {
    // Контракт №2: устройство тоже умеет выполнять действие
    void doAction();
}

// Класс реализует оба интерфейса сразу.
// Один метод doAction() удовлетворяет требованиям обоих интерфейсов.
class MultiAction implements InterfaceA, InterfaceB {
    @Override
    public void doAction() {
        // Единая реализация для обоих "контрактов"
        System.out.println("Выполнено действие для обоих интерфейсов");
    }
}

public class Solution {
    public static void main(String[] args) {
        // Создаем объект и вызываем его метод doAction()
        MultiAction action = new MultiAction();
        action.doAction();
    }
}
 */