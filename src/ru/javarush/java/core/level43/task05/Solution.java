package ru.javarush.java.core.level43.task05;
/*
Профиль Пользователя: Контролируемая Запись Данных
Представьте, что вы разрабатываете продвинутую систему управления пользовательскими профилями, где важна строгая
конфиденциальность и минимизация хранимых данных. Вы создаете класс Person, который будет хранить userFirstName,
userLastName и userAge. Для тотального контроля над процессом сохранения и загрузки данных, ваш класс Person
должен реализовать интерфейс Externalizable.

Ваша задача — убедиться, что при сохранении профиля ( writeExternal ), вы передаете на запись только userFirstName и userAge. Поле userLastName должно быть намеренно проигнорировано. Соответственно, при загрузке профиля ( readExternal ), вы должны считывать только userFirstName и userAge, оставляя userLastName без изменения, то есть, оно должно остаться null после десериализации, как будто его никогда и не было в файле.

Создайте экземпляр Person, заполните все его поля, затем сохраните его и загрузите обратно. Ваша миссия завершится успехом, если вы сможете вывести на экран восстановленные данные и подтвердить, что userLastName действительно равно null, в то время как userFirstName и userAge были успешно восстановлены.

Требования:
•	Класс Person должен реализовывать интерфейс Externalizable.
•	Класс Person должен содержать три поля: userFirstName (String), userLastName (String), userAge (int).
•	В методе writeExternal(ObjectOutput out) должны сериализоваться только поля userFirstName и userAge. Поле userLastName не должно записываться.
•	В методе readExternal(ObjectInput in) должны считываться только userFirstName и userAge. Значение поля userLastName не должно изменяться и должно оставаться null после десериализации.
•	После восстановления объекта из потока, поле userLastName должно быть равно null, а userFirstName и userAge должны содержать корректные значения, соответствующие сериализованным.
•	В программе должен быть создан объект Person, заполнены все поля, произведена его сериализация и десериализация, а затем выведены значения всех полей для проверки результата.

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        // Создаем объект и заполняем все поля
        Person original = new Person("Ada", "Lovelace", 36);

        // Сериализуем объект в память (в байтовый массив)
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try (ObjectOutputStream oos = new ObjectOutputStream(baos)) {
            oos.writeObject(original); // Для Externalizable будет вызван writeExternal
        }

        // Десериализуем объект из памяти
        byte[] data = baos.toByteArray();
        Person restored;
        try (ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(data))) {
            restored = (Person) ois.readObject(); // Для Externalizable будет вызван readExternal
        }

        // Выводим восстановленные поля.
        // По условию: userFirstName и userAge восстановлены, а userLastName должен быть null.
        System.out.println("Восстановленные данные:");
        System.out.println("Имя: " + restored.userFirstName);
        System.out.println("Фамилия: " + restored.userLastName); // ожидается: null
        System.out.println("Возраст: " + restored.userAge);
        System.out.println("Фамилия == null? " + (restored.userLastName == null));
    }
}

 */

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        // Создаем объект и заполняем все поля
        Person original = new Person("Ada", "Lovelace", 36);

        // Сериализуем объект в память (в байтовый массив)
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try (ObjectOutputStream oos = new ObjectOutputStream(baos)) {
            oos.writeObject(original); // Для Externalizable будет вызван writeExternal
        }

        // Десериализуем объект из памяти
        byte[] data = baos.toByteArray();
        Person restored;
        try (ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(data))) {
            restored = (Person) ois.readObject(); // Для Externalizable будет вызван readExternal
        }

        // Выводим восстановленные поля.
        // По условию: userFirstName и userAge восстановлены, а userLastName должен быть null.
        System.out.println("Восстановленные данные:");
        System.out.println("Имя: " + restored.userFirstName);
        System.out.println("Фамилия: " + restored.userLastName); // ожидается: null
        System.out.println("Возраст: " + restored.userAge);
        System.out.println("Фамилия == null? " + (restored.userLastName == null));
    }
}

class Person implements Externalizable {
    String userFirstName;
    String userLastName;
    int userAge;

    public Person() {
    }

    public Person(String name, String name2, int age) {
        this.userFirstName = name;
        this.userLastName = name2;
        this.userAge = age;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeUTF(userFirstName);
        out.writeInt(userAge);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        userFirstName = in.readUTF();
        userAge = in.readInt();
//        userLastName = null;

    }
}
/*

public class Solution {
    public static void main(String[] args) throws Exception {
        // Создаем объект и заполняем все поля
        Person original = new Person("Ada", "Lovelace", 36);

        // Сериализуем объект в память (в байтовый массив)
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try (ObjectOutputStream oos = new ObjectOutputStream(baos)) {
            oos.writeObject(original); // Для Externalizable будет вызван writeExternal
        }

        // Десериализуем объект из памяти
        byte[] data = baos.toByteArray();
        Person restored;
        try (ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(data))) {
            restored = (Person) ois.readObject(); // Для Externalizable будет вызван readExternal
        }

        // Выводим восстановленные поля.
        // По условию: userFirstName и userAge восстановлены, а userLastName должен быть null.
        System.out.println("Восстановленные данные:");
        System.out.println("Имя: " + restored.userFirstName);
        System.out.println("Фамилия: " + restored.userLastName); // ожидается: null
        System.out.println("Возраст: " + restored.userAge);
        System.out.println("Фамилия == null? " + (restored.userLastName == null));
    }
}

// Класс реализует Externalizable для полного контроля над сериализацией/десериализацией
class Person implements Externalizable {
    // Требуемые поля профиля
    String userFirstName;
    String userLastName;
    int userAge;

    // Обязательный публичный конструктор без аргументов для Externalizable.
    // Он вызывается при десериализации перед readExternal.
    public Person() {
        // Ничего не заполняем — важно, чтобы userLastName оставался null по умолчанию.
    }

    // Удобный конструктор для создания заполненного объекта
    public Person(String userFirstName, String userLastName, int userAge) {
        this.userFirstName = userFirstName;
        this.userLastName = userLastName;
        this.userAge = userAge;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        // Записываем только разрешенные поля: userFirstName и userAge
        // Поле userLastName намеренно игнорируется и не попадает в поток
        out.writeObject(userFirstName);
        out.writeInt(userAge);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        // Считываем только userFirstName и userAge в том же порядке
        // userLastName не трогаем — он останется равным null
        userFirstName = (String) in.readObject();
        userAge = in.readInt();
        // userLastName не изменяем
    }
}
 */