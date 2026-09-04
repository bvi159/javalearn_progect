package ru.javarush.java.core.level20.task18;
/*
Уведомления Пользователям: Гибкий Способ Отправки

Вы создаёте сервис уведомлений для своего приложения. Ваша основная логика уведомлений должна быть независима от того, как именно отправляются сообщения — будь то электронная почта, SMS или что-то ещё.
Определите "контракт отправителя сообщений" — интерфейс MessageSender с методом void send(String text).
Реализуйте этот контракт в классе EmailSender (Отправитель Email), который при вызове send() будет выводить на экран: "Email отправлен: " и затем сам текст сообщения.
Теперь создайте класс Notification (Уведомление). Этот класс не должен "знать", как именно отправлять сообщения; вместо этого он будет получать "отправителя" (объект MessageSender) через свой конструктор. Внутри Notification создайте метод notifyUser(String text), который будет просто вызывать send(text) у того MessageSender, который был ему передан.
В основной части вашей программы создайте Notification, передав ему EmailSender в качестве способа отправки. Затем вызовите notifyUser("Привет!") и убедитесь, что сообщение было отправлено через "почту".

Требования:
•	Должен быть создан интерфейс MessageSender с методом void send(String text).
•	Должен быть реализован класс EmailSender, который реализует интерфейс MessageSender.
•	Метод send класса EmailSender должен выводить на экран строку "Email отправлен: " и текст сообщения.
•	Класс Notification должен принимать объект типа MessageSender через свой конструктор и сохранять его для дальнейшего использования.
•	Класс Notification должен содержать метод notifyUser(String text), который вызывает метод send(text) у переданного MessageSender.
•	Класс Notification не должен зависеть от конкретной реализации отправителя сообщений, а должен работать только с интерфейсом MessageSender.
•	В основной части программы должен быть создан объект Notification с EmailSender и вызван notifyUser("Привет!"), после чего в консоль должно быть выведено "Email отправлен: Привет!".

public class Solution {
    public static void main(String[] args) {
        // Внедряем реализацию EmailSender в Notification
        MessageSender emailSender = new EmailSender();
        Notification notification = new Notification(emailSender);

        // Тестируем отправку уведомления
        notification.notifyUser("Привет!"); // Ожидаемый вывод: "Email отправлен: Привет!"
    }
}

 */
public class Solution {
    public static void main(String[] args) {
        // Внедряем реализацию EmailSender в Notification
        MessageSender emailSender = new EmailSender();
        Notification notification = new Notification(emailSender);

        // Тестируем отправку уведомления
        notification.notifyUser("Привет!"); // Ожидаемый вывод: "Email отправлен: Привет!"
    }
}

interface MessageSender {
    void send(String text);
}

class EmailSender implements MessageSender {
    @Override
    public void send(String text) {
        System.out.println("Email отправлен: "+text);
    }
}

class Notification {
    MessageSender mesSender;
    Notification(MessageSender mySender) {
        this.mesSender = mySender;
    }
    void notifyUser(String text) {
        mesSender.send(text);
    }
}


/*
// Контракт отправителя сообщений
interface MessageSender {
    void send(String text);
}

// Реализация отправителя: Email
class EmailSender implements MessageSender {
    @Override
    public void send(String text) {
        // Требуемый формат вывода
        System.out.println("Email отправлен: " + text);
    }
}

// Класс уведомления, не знает конкретный способ отправки — работает через интерфейс
class Notification {
    private final MessageSender sender; // внедряем зависимость через конструктор

    public Notification(MessageSender sender) {
        this.sender = sender;
    }

    // Делегируем отправку переданному отправителю
    public void notifyUser(String text) {
        sender.send(text);
    }
}

public class Solution {
    public static void main(String[] args) {
        // Внедряем реализацию EmailSender в Notification
        MessageSender emailSender = new EmailSender();
        Notification notification = new Notification(emailSender);

        // Тестируем отправку уведомления
        notification.notifyUser("Привет!"); // Ожидаемый вывод: "Email отправлен: Привет!"
    }
}

 */