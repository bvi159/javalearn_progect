package ru.javarush.java.core.level45.task01;
/*
Несериализуемое поле для игровой сессии
Представьте, что вы разрабатываете систему для сохранения пользовательских сессий в онлайн-игре или приложении. Ваша задача — надёжно сохранить данные о входе пользователя, но при этом избежать сохранения объектов, которые связаны с прямым взаимодействием (например, ввод с клавиатуры), так как они не могут быть корректно восстановлены из файла и не должны быть частью постоянного состояния.

Создайте класс Session, который будет представлять активную пользовательскую сессию. Внутри этого класса вам понадобятся два поля: userLogin типа String, чтобы хранить имя пользователя или его идентификатор, и inputScanner типа Scanner, который используется для чтения пользовательского ввода. Чтобы этот класс мог быть сохранён и восстановлен из файла, сделайте его сериализуемым.

Теперь самый важный момент: поскольку Scanner является ресурсом, который не предназначен для сериализации и может вызвать проблемы при попытке его восстановления, пометьте поле inputScanner как transient. Это гарантирует, что при сохранении объекта Session в файл, inputScanner будет игнорироваться.

После этого создайте реальный объект Session, заполните его userLogin (например, "PlayerOne") и инициализируйте inputScanner (хотя он и не будет сохранён, для полноты демонстрации). Сериализуйте этот объект Session в файл, а затем, имитируя перезапуск программы или загрузку сохранения, десериализуйте его обратно из того же файла. В завершение, выведите на консоль значение поля userLogin, чтобы убедиться, что оно успешно восстановилось. Убедитесь также, что поле inputScanner после десериализации действительно стало null, подтверждая, что оно было правильно исключено из процесса сохранения.

Требования:
•	Класс Session должен реализовывать интерфейс Serializable, чтобы объекты этого класса можно было сериализовать и десериализовать.

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        // Создаем Scanner для имитации ввода с клавиатуры
        Scanner console = new Scanner(System.in);

        // Заполняем объект Session: логин сохраняем, Scanner помечен transient
        Session session = new Session("PlayerOne", console);

        // Имя файла для сохранения
        String fileName = "session.bin";

        // Сериализация объекта Session в файл
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName))) {
            out.writeObject(session);
        }

        // Десериализация объекта Session из того же файла
        Session loaded;
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName))) {
            loaded = (Session) in.readObject();
        }

        // Проверяем восстановление: userLogin должен быть сохранен
        System.out.println(loaded.userLogin);

        // Проверяем transient-поле: после десериализации должно быть null
        System.out.println(loaded.inputScanner == null);
    }
}

 */

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        // Создаем Scanner для имитации ввода с клавиатуры
        Scanner console = new Scanner(System.in);

        // Заполняем объект Session: логин сохраняем, Scanner помечен transient
        Session session = new Session("PlayerOne", console);

        // Имя файла для сохранения
        String fileName = "session.bin";

        // Сериализация объекта Session в файл
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName))) {
            out.writeObject(session);
        }

        // Десериализация объекта Session из того же файла
        Session loaded;
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName))) {
            loaded = (Session) in.readObject();
        }

        // Проверяем восстановление: userLogin должен быть сохранен
        System.out.println(loaded.userLogin);

        // Проверяем transient-поле: после десериализации должно быть null
        System.out.println(loaded.inputScanner == null);
    }
}

class Session implements Serializable {
    String userLogin;
    transient Scanner inputScanner;

    public Session(String login, Scanner input) {
        this.userLogin = login;
        this.inputScanner = input;
    }
}

/*

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Scanner;

// Класс сессии: должен быть сериализуемым
class Session implements Serializable {
    private static final long serialVersionUID = 1L; // Версия класса для совместимости

    String userLogin;                // Обычное поле — должно сериализоваться
    transient Scanner inputScanner;  // transient — не сериализуется, после загрузки будет null

    Session(String userLogin, Scanner inputScanner) {
        this.userLogin = userLogin;
        this.inputScanner = inputScanner;
    }
}

public class Solution {
    public static void main(String[] args) throws Exception {
        // Создаем Scanner для имитации ввода с клавиатуры
        Scanner console = new Scanner(System.in);

        // Заполняем объект Session: логин сохраняем, Scanner помечен transient
        Session session = new Session("PlayerOne", console);

        // Имя файла для сохранения
        String fileName = "session.bin";

        // Сериализация объекта Session в файл
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName))) {
            out.writeObject(session);
        }

        // Десериализация объекта Session из того же файла
        Session loaded;
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName))) {
            loaded = (Session) in.readObject();
        }

        // Проверяем восстановление: userLogin должен быть сохранен
        System.out.println(loaded.userLogin);

        // Проверяем transient-поле: после десериализации должно быть null
        System.out.println(loaded.inputScanner == null);
    }
}
 */