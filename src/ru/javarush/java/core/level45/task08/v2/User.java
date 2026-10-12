package ru.javarush.java.core.level45.task08.v2;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

public class User implements Serializable {
    private final static long serialVersionUID = 200L;
    public String userName;
    public String userAgeString;

    public User() {

    }

    public User(String name, String age) {
        this.userName = name;
        this.userAgeString = age;
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        ObjectInputStream.GetField fields = in.readFields();
        // Имя совпадает по названию и типу
        this.userName = (String) fields.get("userName", null);
        // Старое поле: int age
        int age = fields.get("userAgeInt", -1);
        // Новое поле: String ageStr
        this.userAgeString = String.valueOf(age);
    }

}
/*
// Новая версия класса — хранит возраст как String.
// serialVersionUID тот же самый, чтобы можно было читать старые данные.
public class User implements Serializable {
    private static final long serialVersionUID = 200L;

    public String userName;
    public String userAgeString;

    // Кастомная десериализация с миграцией данных:
    // - читаем имя пользователя (оно совпадает между версиями)
    // - если в потоке нет нового поля userAgeString, читаем старое userAgeInt и конвертируем в строку
    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        // Читаем поля "как есть" из потока (даже если их нет в текущем классе)
        ObjectInputStream.GetField fields = in.readFields();

        // Имя совпадает по названию и типу
        this.userName = (String) fields.get("userName", null);

        // Если поток уже содержит строковое поле возраста — просто читаем его
        if (!fields.defaulted("userAgeString")) {
            this.userAgeString = (String) fields.get("userAgeString", null);
        } else {
            // Иначе это старые данные: читаем int и преобразуем в строку
            int oldAge = fields.get("userAgeInt", 0);
            this.userAgeString = String.valueOf(oldAge);
        }
    }
}
 */

