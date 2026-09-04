package ru.javarush.java.core.level19.task17;
/*
Создаем основу для менеджера задач ✍️

Представьте, что вы занимаетесь разработкой умного менеджера задач, который поможет вашей команде оставаться продуктивной. Каждая задача в этом менеджере имеет название, и, конечно же, её можно выполнить, но вот сам процесс выполнения может варьироваться.
Для начала, создайте абстрактный класс Task. В нём определите поле String title для хранения названия задачи и добавьте абстрактный метод void complete(), который будет символизировать завершение работы над задачей.
Не забудьте также реализовать конструктор для Task, который будет принимать название задачи и сохранять его.
После этого создайте первый, базовый тип задачи — SimpleTask. Этот класс должен наследовать Task и реализовать метод complete() таким образом, чтобы он выводил на экран фразу: "Задача '<название_задачи>' выполнена", подставляя реальное название задачи.

Требования:
•	Должен быть создан абстрактный класс с именем Task.
•	В классе Task должно быть приватное или защищённое поле типа String с именем title для хранения названия задачи.
•	Класс Task должен иметь конструктор, принимающий один параметр — название задачи, и сохраняющий его в поле title.
•	В классе Task должен быть объявлен абстрактный метод void complete().
•	Должен быть создан класс SimpleTask, который наследуется от Task.
•	Класс SimpleTask должен реализовать метод complete() таким образом, чтобы он выводил на экран строку: "Задача '<название_задачи>' выполнена", где <название_задачи> — значение поля title соответствующего объекта.

// Небольшая демонстрация работы
public class Solution {
    public static void main(String[] args) {
        Task task = new SimpleTask("Купить кофе");
        task.complete(); // Ожидаемый вывод: Задача 'Купить кофе' выполнена
    }
}

 */

// Небольшая демонстрация работы
public class Solution {
    public static void main(String[] args) {
        Task task = new SimpleTask("Купить кофе");
        task.complete(); // Ожидаемый вывод: Задача 'Купить кофе' выполнена
    }
}

abstract class Task {
    protected String title;

    public Task(String taskTitle) {
        title = taskTitle;
    }

    public abstract void complete();
}

class SimpleTask extends Task {
    public SimpleTask(String simpleTaskTitle) {
        super(simpleTaskTitle);
    }

    @Override
    public void complete() {
        System.out.println("Задача '" + title + "' выполнена");
    }

}

/*
// Абстрактный класс-основа для любой задачи
abstract class Task {
    // Название задачи — защищённое поле, доступно наследникам
    protected String title;

    // Конструктор принимает название задачи и сохраняет его
    public Task(String title) {
        this.title = title;
    }

    // Абстрактный метод: как именно завершать задачу — решают наследники
    public abstract void complete();
}

// Простой тип задачи, который умеет "выполняться"
class SimpleTask extends Task {
    public SimpleTask(String title) {
        super(title); // Передаём название в базовый класс
    }

    @Override
    public void complete() {
        // Требуемый вывод при завершении задачи
        System.out.println("Задача '" + title + "' выполнена");
    }
}

// Небольшая демонстрация работы
public class Solution {
    public static void main(String[] args) {
        Task task = new SimpleTask("Купить кофе");
        task.complete(); // Ожидаемый вывод: Задача 'Купить кофе' выполнена
    }
}
 */