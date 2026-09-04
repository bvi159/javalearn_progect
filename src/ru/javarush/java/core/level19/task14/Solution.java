package ru.javarush.java.core.level19.task14;
/*
Универсальная система рассылки сообщений 📧💬

Вы создаете универсальную систему для рассылки уведомлений. Все сообщения имеют какой-то текст, но способ их доставки, будь то электронная почта или СМС, кардинально отличается.
Для начала, создайте абстрактный класс Message с полем String text для хранения содержимого сообщения и абстрактным методом send(), который будет отвечать за процесс отправки.
Затем реализуйте два конкретных типа сообщений: EmailMessage и SmsMessage. Оба класса должны наследовать Message.
В классе EmailMessage метод send() должен выводить на экран сообщение, начинающееся с "Отправка email: " и затем сам текст сообщения. Аналогично, в классе SmsMessage метод send() должен выводить "Отправка SMS: " с последующим текстом сообщения.
Чтобы протестировать вашу систему рассылки, в методе main создайте по одному объекту каждого класса, например, с текстом "Привет!". После этого для каждого объекта вызовите его метод send().

В результате на экране должны появиться строки: "Отправка email: Привет!" и "Отправка SMS: Привет!", подтверждающие успешную отправку.

Требования:
•	Должен быть создан абстрактный класс Message с полем String text для хранения содержимого сообщения.
•	В абстрактном классе Message должен быть объявлен абстрактный метод void send().
•	Классы EmailMessage и SmsMessage должны наследовать абстрактный класс Message.
•	В классе EmailMessage метод send() должен выводить на экран строку, начинающуюся с "Отправка email: " и далее текст сообщения.
•	В классе SmsMessage метод send() должен выводить на экран строку, начинающуюся с "Отправка SMS: " и далее текст сообщения.
•	В методе main должны быть созданы объекты EmailMessage и SmsMessage с текстом "Привет!" и для каждого должен быть вызван метод send().
•	В результате выполнения программы на экране должны появиться строки: "Отправка email: Привет!" и "Отправка SMS: Привет!".

 */
public class Solution {
    public static void main(String[] args) {
        // Создаем два сообщения с текстом "Привет!"
        Message email = new EmailMessage("Привет!");
        Message sms = new SmsMessage("Привет!");

        // Отправляем каждое сообщение — будут вызваны их переопределенные методы send()
        email.send();
        sms.send();
    }
}

abstract class Message {
    String text;
    public abstract void send();
}

class EmailMessage extends Message {
    public EmailMessage(String text) {
        this.text = text;
    }

    @Override
    public void send() {
        System.out.println("Отправка email: " + text);
    }

}

class SmsMessage extends Message{
    public SmsMessage(String smsText) {
        text = smsText;
    }

    @Override
    public void send() {
        System.out.println("Отправка SMS: "+ text);
    }
}

/*
public class Solution {
    public static void main(String[] args) {
        // Создаем два сообщения с текстом "Привет!"
        Message email = new EmailMessage("Привет!");
        Message sms = new SmsMessage("Привет!");

        // Отправляем каждое сообщение — будут вызваны их переопределенные методы send()
        email.send();
        sms.send();
    }
}

// Абстрактный класс, задающий общий контракт для всех сообщений
abstract class Message {
    protected final String text; // общий текст сообщения

    public Message(String text) {
        this.text = text;
    }

    // Абстрактный метод отправки: каждая реализация определяет свой способ доставки
    public abstract void send();
}

// Конкретная реализация для отправки email-сообщений
class EmailMessage extends Message {
    public EmailMessage(String text) {
        super(text);
    }

    @Override
    public void send() {
        System.out.println("Отправка email: " + text);
    }
}

// Конкретная реализация для отправки SMS-сообщений
class SmsMessage extends Message {
    public SmsMessage(String text) {
        super(text);
    }

    @Override
    public void send() {
        System.out.println("Отправка SMS: " + text);
    }
}
 */