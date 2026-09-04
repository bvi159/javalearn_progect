package ru.javarush.java.core.level15.task13;
/*
Глобальный счетчик активных пользователей 🌐

Представьте, что вы разрабатываете приложение и вам нужно отслеживать общее количество активных пользователей. Этот счётчик должен быть единым для всего приложения, а не принадлежать какому-то конкретному пользователю.
Создайте класс ApplicationMetrics. Внутри этого класса объявите приватное статическое поле activeUserCount типа int и сразу же инициализируйте его значением, например, 10, представляющим начальное число активных пользователей при запуске системы.
Важно: поскольку это статическое поле, к нему можно и нужно обращаться напрямую через имя класса, без создания объекта. В вашем классе Solution выведите на экран текущее значение activeUserCount, обратившись к нему через имя класса ApplicationMetrics. Таким образом, вы покажете, как получить доступ к общей, разделяемой переменной приложения.
Требования:
•	В классе ApplicationMetrics должно быть объявлено приватное статическое поле activeUserCount типа int.
•	Поле activeUserCount должно быть сразу инициализировано значением 10 при объявлении.
•	В классе Solution необходимо получить доступ к полю activeUserCount через имя класса ApplicationMetrics, а не через объект.
•	В классе Solution текущее значение поля activeUserCount должно быть выведено на экран.

public class Solution {
    public static void main(String[] args) {
        // Получаем значение статического поля через имя класса (объект не создаем)
        // Поле приватное, поэтому обращаемся к нему через публичный статический геттер
        System.out.println(ApplicationMetrics.getActiveUserCount());
    }
}

 */
public class Solution {
    public static void main(String[] args) {
        // Получаем значение статического поля через имя класса (объект не создаем)
        // Поле приватное, поэтому обращаемся к нему через публичный статический геттер
        System.out.println(ApplicationMetrics.getActiveUserCount());
    }
}

class ApplicationMetrics {
    private static int activeUserCount = 10;

    public static int getActiveUserCount() {
        return activeUserCount;
    }
}

