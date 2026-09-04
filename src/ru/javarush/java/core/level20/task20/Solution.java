package ru.javarush.java.core.level20.task20;

/*
Новостной Канал: Издатель и Подписчики

Представьте, что вы создаёте систему для рассылки новостей, где есть «издатель» новостей и множество «подписчиков», которые хотят получать обновления. Когда издатель публикует новость, все подписчики должны быть немедленно уведомлены. Это классический пример паттерна Наблюдатель.
Определите «контракт подписчика» — интерфейс Subscriber с методом void update(String news). Это то, что любой, кто хочет получать новости, должен уметь делать.
Создайте класс NewsPublisher (Издатель Новостей). Этот издатель будет хранить список всех своих Subscriber'ов. В нём должны быть методы для addSubscriber(Subscriber subscriber) (добавить подписчика), removeSubscriber(Subscriber subscriber) (удалить подписчика) и notifySubscribers(String news) (уведомить подписчиков) — последний метод должен вызывать update(news) для каждого подписчика из списка.
Создайте класс Person (Человек), который будет выступать в роли подписчика, реализуя интерфейс Subscriber. В конструкторе Person можно задать его имя. В методе update() Person должен выводить на экран сообщение: "<имя> получил новость: <news>".
В основной части вашей программы создайте NewsPublisher. Создайте двух Person с разными именами, подпишите их на новости у издателя. Затем вызовите notifySubscribers("Обновление курса Java!") у вашего издателя. Вы должны увидеть, как оба ваших подписчика получают и выводят новость:

<Имя1> получил новость: Обновление курса Java!
<Имя2> получил новость: Обновление курса Java!
Требования:
•	Необходимо создать интерфейс Subscriber с методом void update(String news).
•	Класс NewsPublisher должен содержать список всех подписчиков типа Subscriber.
•	Класс NewsPublisher должен реализовывать методы addSubscriber(Subscriber subscriber) для добавления подписчика и removeSubscriber(Subscriber subscriber) для удаления подписчика.
•	Класс NewsPublisher должен реализовывать метод notifySubscribers(String news), который вызывает метод update(news) у каждого подписчика из списка.
•	Класс Person должен реализовывать интерфейс Subscriber и определять поведение метода update(String news).
•	Класс Person должен иметь конструктор, принимающий имя подписчика и сохраняющий его для последующего использования.
•	В методе update класса Person должно выводиться сообщение в формате "<имя> получил новость: <news>".
•	В основной части программы необходимо создать объект NewsPublisher, двух Person с разными именами, подписать их на издателя и вызвать notifySubscribers с новостью, чтобы на экране появились корректные сообщения для каждого подписчика.
Input data
1
Опрос

public class Solution {
    public static void main(String[] args) {
        // Создаем издателя
        NewsPublisher publisher = new NewsPublisher();

        // Создаем двух подписчиков с разными именами
        Person andrey = new Person("Андрей");
        Person boris = new Person("Борис");

        // Подписываем их на новости
        publisher.addSubscriber(andrey);
        publisher.addSubscriber(boris);

        // Оповещаем всех подписчиков о новой новости
        publisher.notifySubscribers("Обновление курса Java!");
    }
}

 */

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        // Создаем издателя
        NewsPublisher publisher = new NewsPublisher();

        // Создаем двух подписчиков с разными именами
        Person andrey = new Person("Андрей");
        Person boris = new Person("Борис");

        // Подписываем их на новости
        publisher.addSubscriber(andrey);
        publisher.addSubscriber(boris);

        // Оповещаем всех подписчиков о новой новости
        publisher.notifySubscribers("Обновление курса Java!");
    }
}

interface Subscriber {
    void update(String news);
}

class NewsPublisher {
    List<Subscriber> mySubscribers = new ArrayList<>();

    void addSubscriber(Subscriber subscriber) {
        mySubscribers.add(subscriber);
    }

    void removeSubscriber(Subscriber subscriber) {
        mySubscribers.remove(subscriber);
    }

    void notifySubscribers(String news) {
        for (Subscriber currentSubscriber : mySubscribers) {
            currentSubscriber.update(news);
        }
    }
}

class Person implements Subscriber {
    String subscriberName;

    Person(String name) {
        subscriberName = name;
    }
    @Override
    public void update(String newNews) {
        System.out.println(subscriberName + " получил новость: " + newNews);
    }
}

/*
// "Контракт подписчика": любой подписчик обязан уметь принимать обновление новости
interface Subscriber {
    void update(String news);
}

// Издатель новостей хранит список подписчиков и оповещает их о новых событиях
class NewsPublisher {
    private final List<Subscriber> subscribers = new ArrayList<>();

    // Добавляем подписчика в список
    public void addSubscriber(Subscriber subscriber) {
        subscribers.add(subscriber);
    }

    // Удаляем подписчика из списка
    public void removeSubscriber(Subscriber subscriber) {
        subscribers.remove(subscriber);
    }

    // Оповещаем всех подписчиков — вызываем у каждого метод update
    public void notifySubscribers(String news) {
        for (Subscriber s : subscribers) {
            s.update(news);
        }
    }
}

// Класс Person реализует интерфейс Subscriber и описывает реакцию на новость
class Person implements Subscriber {
    private final String name;

    public Person(String name) {
        this.name = name;
    }

    @Override
    public void update(String news) {
        // Сообщение строго в заданном формате
        System.out.println(name + " получил новость: " + news);
    }
}

public class Solution {
    public static void main(String[] args) {
        // Создаем издателя
        NewsPublisher publisher = new NewsPublisher();

        // Создаем двух подписчиков с разными именами
        Person andrey = new Person("Андрей");
        Person boris = new Person("Борис");

        // Подписываем их на новости
        publisher.addSubscriber(andrey);
        publisher.addSubscriber(boris);

        // Оповещаем всех подписчиков о новой новости
        publisher.notifySubscribers("Обновление курса Java!");
    }
}
 */


