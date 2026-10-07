package ru.javarush.java.core.level43.task07;
/*
Космический Нексус: Обеспечение Единства Существования
Вы – главный архитектор вселенной в грандиозной космической симуляционной игре. В вашей игре может существовать только один-единственный "Космический Нексус" – центральный управляющий узел. Создайте класс SimpleSingleton, который будет представлять этот Нексус. Он должен реализовать интерфейс Serializable, чтобы вы могли сохранять состояние вашей вселенной.

Внутри класса SimpleSingleton объявите приватное статическое финальное поле INSTANCE, которое будет хранить единственный экземпляр Нексуса. Конструктор класса должен быть приватным, чтобы никто не мог создать новый Нексус напрямую. Добавьте публичный статический метод getInstance(), который всегда будет возвращать тот самый, единственный INSTANCE. Самый хитрый шаг: чтобы гарантировать, что Нексус останется единственным даже после попыток "клонирования" через сохранение и загрузку, реализуйте приватный метод readResolve. Этот метод должен всегда возвращать существующий INSTANCE, перехватывая любые попытки создать новый объект при десериализации.

В основном методе вашей программы получите экземпляр SimpleSingleton через getInstance(), затем "законсервируйте" его в файл "singleton.bin" (сериализуйте), а потом "пробудите" его из этого файла (десериализуйте). В конце концов, выведите на экран результат сравнения двух "экземпляров" Нексуса с помощью оператора ==. Ваша миссия будет успешно выполнена, если на экране появится true, подтверждая, что вы всегда работаете с одним и тем же, единственным Космическим Нексусом.

Требования:
•	Класс SimpleSingleton должен реализовывать интерфейс Serializable.
•	В классе SimpleSingleton должно быть приватное статическое финальное поле INSTANCE, содержащее единственный экземпляр класса.
•	Конструктор SimpleSingleton должен быть приватным, чтобы предотвратить создание экземпляров извне.
•	В классе SimpleSingleton должен быть публичный статический метод getInstance(), возвращающий INSTANCE.
•	В классе SimpleSingleton должен быть реализован приватный метод readResolve, который всегда возвращает INSTANCE при десериализации.
•	В основной программе экземпляр SimpleSingleton должен быть сериализован в файл "singleton.bin".
•	В основной программе объект SimpleSingleton должен быть десериализован из файла "singleton.bin".
•	В основной программе должно быть выполнено сравнение оригинального и десериализованного экземпляров SimpleSingleton с помощью оператора ==, и результат должен быть выведен на экран.

import java.io.*;

// Демонстрация сериализации с сохранением синглтона
public class Solution {
    public static void main(String[] args) throws Exception {
        // Получаем единственный экземпляр Нексуса
        SimpleSingleton original = SimpleSingleton.getInstance();

        // Сериализуем объект в файл "singleton.bin"
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("singleton.bin"))) {
            out.writeObject(original);
        }

        // Десериализуем объект из файла "singleton.bin"
        SimpleSingleton deserialized;
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("singleton.bin"))) {
            deserialized = (SimpleSingleton) in.readObject();
        }

        // Проверяем, что это один и тот же объект (должно вывести true)
        System.out.println(original == deserialized);
    }
}

 */

import java.io.*;

// Демонстрация сериализации с сохранением синглтона
public class Solution {
    public static void main(String[] args) throws Exception {
        // Получаем единственный экземпляр Нексуса
        SimpleSingleton original = SimpleSingleton.getInstance();

        // Сериализуем объект в файл "singleton.bin"
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("singleton.bin"))) {
            out.writeObject(original);
        }

        // Десериализуем объект из файла "singleton.bin"
        SimpleSingleton deserialized;
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("singleton.bin"))) {
            deserialized = (SimpleSingleton) in.readObject();
        }

        // Проверяем, что это один и тот же объект (должно вывести true)
        System.out.println(original == deserialized);
    }
}

class SimpleSingleton implements Serializable {
    private static final SimpleSingleton INSTANCE = new SimpleSingleton();

    private SimpleSingleton() {
    }

    public static SimpleSingleton getInstance() {
        return INSTANCE;
    }

    // Гарантируем, что после десериализации вернётся именно INSTANCE
    private Object readResolve() throws ObjectStreamException {
        return INSTANCE;
    }
}
/*
// "Космический Нексус" — класс-синглтон
class SimpleSingleton implements Serializable {
    // Явный serialVersionUID — хорошая практика при Serializable
    private static final long serialVersionUID = 1L;

    // Единственный экземпляр класса хранится здесь
    private static final SimpleSingleton INSTANCE = new SimpleSingleton();

    // Приватный конструктор запрещает создание экземпляров извне
    private SimpleSingleton() {
    }

    // Публичный метод для доступа к единственному экземпляру
    public static SimpleSingleton getInstance() {
        return INSTANCE;
    }

    // Хитрый шаг сериализации: при десериализации всегда возвращаем уже существующий INSTANCE.
    // Это гарантирует сохранение единственности синглтона.
    private Object readResolve() throws ObjectStreamException {
        return INSTANCE;
    }
}
 */