package ru.javarush.java.core.level16.task12;
/*
Секретная лаборатория: раскрытие зашифрованного послания 🕵

Вы создаёте систему для безопасной передачи ценной информации в секретной лаборатории. Главный модуль системы хранит некое "секретное сообщение", которое должно оставаться приватным. Однако иногда, по специальному запросу, это сообщение нужно раскрыть, но только через временный, строго контролируемый механизм.
Создайте класс SecureLab с приватным строковым полем classifiedSecret, которое инициализируется значением "Секрет раскрыт!".
В классе SecureLab реализуйте метод void revealSecret(). Внутри этого метода создайте объект интерфейса Runnable с помощью анонимного класса. Пусть метод run() этого анонимного класса получает доступ к полю classifiedSecret внешнего класса и выводит его значение. Вызовите метод run() прямо внутри revealSecret().
В главном методе вашей программы (main) создайте объект класса SecureLab и вызовите его метод revealSecret(), чтобы активировать процесс раскрытия и увидеть зашифрованное послание.

Требования:
•	Необходимо создать класс с именем SecureLab.
•	В классе SecureLab должно быть приватное строковое поле с именем classifiedSecret, инициализированное значением "Секрет раскрыт!".
•	В классе SecureLab должен быть реализован метод void revealSecret().
•	Внутри метода revealSecret() необходимо создать объект интерфейса Runnable с помощью анонимного класса.
•	Метод run() анонимного класса должен получать доступ к приватному полю classifiedSecret внешнего класса и выводить его значение на экран.
•	Метод run() анонимного класса должен быть вызван прямо внутри метода revealSecret().
•	В методе main программы должен быть создан объект класса SecureLab и вызван его метод revealSecret().

// Главный класс с методом main
public class Solution {
    public static void main(String[] args) {
        // Создаем объект лаборатории и запускаем механизм раскрытия секрета
        SecureLab lab = new SecureLab();
        lab.revealSecret();
    }
}

// Класс секретной лаборатории
class SecureLab {
    // Приватное поле с секретом
    private String classifiedSecret = "Секрет раскрыт!";

    // Метод, который "раскрывает" секрет через анонимный класс
    void revealSecret() {
        // Создаем объект интерфейса Runnable через анонимный класс


        // Вызываем метод run() прямо здесь, без создания отдельного потока
        revealMechanism.run();
    }
}

 */

// Главный класс с методом main
public class Solution {
    public static void main(String[] args) {
        // Создаем объект лаборатории и запускаем механизм раскрытия секрета
        SecureLab lab = new SecureLab();
        lab.revealSecret();
    }
}

// Класс секретной лаборатории
class SecureLab {
    // Приватное поле с секретом
    private String classifiedSecret = "Секрет раскрыт!";

    // Метод, который "раскрывает" секрет через анонимный класс
    void revealSecret() {
        // Создаем объект интерфейса Runnable через анонимный класс
        Runnable revealMechanism = new Runnable() {
            @Override
            public void run() {
                System.out.println(classifiedSecret);
            }
        };

        // Вызываем метод run() прямо здесь, без создания отдельного потока
        revealMechanism.run();
    }
}

/*
// Главный класс с методом main
public class Solution {
    public static void main(String[] args) {
        // Создаем объект лаборатории и запускаем механизм раскрытия секрета
        SecureLab lab = new SecureLab();
        lab.revealSecret();
    }
}

// Класс секретной лаборатории
class SecureLab {
    // Приватное поле с секретом
    private String classifiedSecret = "Секрет раскрыт!";

    // Метод, который "раскрывает" секрет через анонимный класс
    void revealSecret() {
        // Создаем объект интерфейса Runnable через анонимный класс
        Runnable revealMechanism = new Runnable() {
            @Override
            public void run() {
                // Анонимный класс имеет доступ к приватным полям внешнего класса
                System.out.println(classifiedSecret);
            }
        };

        // Вызываем метод run() прямо здесь, без создания отдельного потока
        revealMechanism.run();
    }
}
 */