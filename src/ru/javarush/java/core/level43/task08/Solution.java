package ru.javarush.java.core.level43.task08;
/*
Хранилище Тайных Данных: Маскировка Информации При Передаче
Вы проектируете сверхсекретное хранилище для учетных записей пользователей в вашей новой кибербезопасной фирме "Щит Авроры". Каждая учетная запись (Account) содержит username и secret — некую конфиденциальную строку, которая никогда не должна попасть в руки злоумышленников при сохранении. Класс Account должен быть Serializable.

Ваша задача — разработать механизм, который при сохранении учетной записи будет маскировать или трансформировать её так, чтобы secret никогда не записывался на диск. Для этого реализуйте приватный метод writeReplace() в классе Account. Этот метод должен возвращать объект вспомогательного класса AccountProxy. Создайте этот AccountProxy как вложенный статический класс, реализующий Serializable, и пусть он содержит только поле username.

Теперь, чтобы при загрузке AccountProxy обратно получить полноценный Account, но без secret (потому что его там и не было), реализуйте в AccountProxy приватный метод readResolve(). Этот метод должен возвращать новый объект Account с тем же username, но с пустым secret.

В основном методе программы создайте Account с любыми значениями username и secret, затем "законсервируйте" его (сериализуйте) и "восстановите" (десериализуйте). Наконец, выведите на экран значения username и secret полученного Account. Ожидаемый результат: username должен совпасть с исходным, а secret должен быть пустой строкой, подтверждая, что тайные данные остались в безопасности и не были записаны.

Требования:
•	Класс Account должен реализовывать интерфейс Serializable.
•	В классе Account должен быть реализован приватный метод writeReplace(), который возвращает экземпляр класса AccountProxy.
•	AccountProxy должен быть статическим вложенным классом внутри Account, реализующим интерфейс Serializable и содержащим только поле username.
•	В классе AccountProxy должен быть реализован приватный метод readResolve(), который возвращает новый объект Account с тем же username и пустой строкой в качестве secret.
•	В основном методе программы должен быть создан объект Account, затем он должен быть сериализован и десериализован обратно.
•	После десериализации необходимо вывести значения username и secret объекта Account; username должен совпадать с исходным, а secret должен быть пустой строкой.

import java.io.*;

// Демонстрация механизма writeReplace/readResolve для маскировки секретных данных
public class Solution {
    public static void main(String[] args) throws Exception {
        // Создаём исходный аккаунт с секретом
        Account original = new Account("aurora.shield", "ULTRA-SECRET-123");

        // Сериализуем объект в массив байт (симулируем сохранение на диск)
        byte[] data;
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream();
             ObjectOutputStream oos = new ObjectOutputStream(baos)) {
            oos.writeObject(original);
            data = baos.toByteArray();
        }

        // Десериализуем обратно
        Account restored;
        try (ByteArrayInputStream bais = new ByteArrayInputStream(data);
             ObjectInputStream ois = new ObjectInputStream(bais)) {
            restored = (Account) ois.readObject(); // Здесь вернётся Account, восстановленный из прокси
        }

        // Выводим результат: username совпадает, secret — пустая строка
        System.out.println(restored.getUsername());
        System.out.println(restored.getSecret()); // ожидается пустая строка
    }
}

 */

import java.io.*;

// Демонстрация механизма writeReplace/readResolve для маскировки секретных данных
public class Solution {
    public static void main(String[] args) throws Exception {
        // Создаём исходный аккаунт с секретом
        Account original = new Account("aurora.shield", "ULTRA-SECRET-123");

        // Сериализуем объект в массив байт (симулируем сохранение на диск)
        byte[] data;
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream();
             ObjectOutputStream oos = new ObjectOutputStream(baos)) {
            oos.writeObject(original);
            data = baos.toByteArray();
        }

        // Десериализуем обратно
        Account restored;
        try (ByteArrayInputStream bais = new ByteArrayInputStream(data);
             ObjectInputStream ois = new ObjectInputStream(bais)) {
            restored = (Account) ois.readObject(); // Здесь вернётся Account, восстановленный из прокси
        }

        // Выводим результат: username совпадает, secret — пустая строка
        System.out.println(restored.getUsername());
        System.out.println(restored.getSecret()); // ожидается пустая строка
    }
}

class Account implements Serializable {
    private String username;
    private String secret;

    public Account(String name, String secret) {
        this.username = name;
        this.secret = secret;
    }

    public String getUsername() {
        return username;
    }

    public String getSecret() {
        return secret;
    }

    private Object writeReplace() {
        return new AccountProxy(username);
    }

    private static class AccountProxy implements Serializable {
        private final String username;

        AccountProxy(String proxyName) {
            this.username = proxyName;
        }

        private Object readResolve() throws ObjectStreamException {
            return new Account(username, ""); // "" — "секрет"
        }
    }


}

/*
import java.io.*;

// Демонстрация механизма writeReplace/readResolve для маскировки секретных данных
public class Solution {
    public static void main(String[] args) throws Exception {
        // Создаём исходный аккаунт с секретом
        Account original = new Account("aurora.shield", "ULTRA-SECRET-123");

        // Сериализуем объект в массив байт (симулируем сохранение на диск)
        byte[] data;
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream();
             ObjectOutputStream oos = new ObjectOutputStream(baos)) {
            oos.writeObject(original);
            data = baos.toByteArray();
        }

        // Десериализуем обратно
        Account restored;
        try (ByteArrayInputStream bais = new ByteArrayInputStream(data);
             ObjectInputStream ois = new ObjectInputStream(bais)) {
            restored = (Account) ois.readObject(); // Здесь вернётся Account, восстановленный из прокси
        }

        // Выводим результат: username совпадает, secret — пустая строка
        System.out.println(restored.getUsername());
        System.out.println(restored.getSecret()); // ожидается пустая строка
    }
}

// Класс учетной записи. Должен быть сериализуемым по условию.
class Account implements Serializable {
    private final String username;
    private final String secret;

    public Account(String username, String secret) {
        this.username = username;
        this.secret = secret;
    }

    public String getUsername() {
        return username;
    }

    public String getSecret() {
        return secret;
    }

    // Ключевой момент:
    // writeReplace вызывается механизмом сериализации и позволяет подменить сохраняемый объект на другой.
    // Мы возвращаем прокси, в котором нет секретной информации.
    private Object writeReplace() throws ObjectStreamException {
        return new AccountProxy(username); // secret намеренно "теряем" — в файл он не попадёт
    }

    // Статический вложенный класс-прокси.
    // Важно: содержит только поле username и тоже сериализуем.
    private static class AccountProxy implements Serializable {
        private final String username;

        AccountProxy(String username) {
            this.username = username;
        }

        // readResolve вызывается после десериализации прокси.
        // Возвращаем новый Account с тем же username, но пустым secret.
        private Object readResolve() throws ObjectStreamException {
            return new Account(username, ""); // секрет не восстанавливаем
        }
    }
}
 */