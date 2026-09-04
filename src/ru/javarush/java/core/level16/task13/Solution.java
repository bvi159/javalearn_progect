package ru.javarush.java.core.level16.task13;
/*
Интерактивная доска объявлений: временное приветствие 👋

Представьте, что вы разрабатываете интерактивную доску объявлений, которая умеет показывать различные сообщения. Иногда вам нужно вывести очень специфичное, временное сообщение, которое актуально только в определённый момент выполнения кода, и вам не требуется создавать для него отдельный глобальный класс.
В классе DisplayBoard объявите метод showTemporaryMessage(). Внутри этого метода showTemporaryMessage() объявите локальный класс с именем GreetingDisplay. Этот GreetingDisplay должен содержать метод displayMessage(), который выводит на экран строку "Привет из локального класса!". Создайте объект GreetingDisplay и вызовите его метод displayMessage(), чтобы на экране появилось это временное приветствие.

Требования:
•	В классе DisplayBoard должен быть объявлен метод showTemporaryMessage().
•	Внутри метода showTemporaryMessage() должен быть объявлен локальный класс с именем GreetingDisplay.
•	Локальный класс GreetingDisplay должен содержать метод displayMessage(), который выводит строку "Привет из локального класса!".
•	Внутри метода showTemporaryMessage() должен быть создан объект класса GreetingDisplay.
•	После создания объекта GreetingDisplay должен быть вызван его метод displayMessage(), чтобы на экран было выведено временное приветствие.

public class Solution {
    public static void main(String[] args) {
        // Небольшая демонстрация работы доски объявлений
        DisplayBoard board = new DisplayBoard();
        board.showTemporaryMessage();
    }
}

class DisplayBoard {

    // Метод, внутри которого объявляется локальный класс
    public void showTemporaryMessage() {
        // Локальный класс доступен только в пределах этого метода


        // Создаем объект локального класса и вызываем его метод

    }
}

 */

public class Solution {
    public static void main(String[] args) {
        // Небольшая демонстрация работы доски объявлений
        DisplayBoard board = new DisplayBoard();
        board.showTemporaryMessage();
    }
}

class DisplayBoard {

    // Метод, внутри которого объявляется локальный класс
    public void showTemporaryMessage() {
        // Локальный класс доступен только в пределах этого метода
        class GreetingDisplay {
            void displayMessage() {
                System.out.println("Привет из локального класса!");
            }
        }
        // Создаем объект локального класса и вызываем его метод
        GreetingDisplay mySmile = new GreetingDisplay();
        mySmile.displayMessage();

    }
}