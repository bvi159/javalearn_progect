package ru.javarush.java.core.level43.task01;
/*
Сущность Волшебного Кота: Сохранение и Пробуждение с Журналированием
Представьте, что вы создаете систему для волшебного питомника, где каждая цифровая сущность кота должна быть бережно сохранена и, при необходимости, пробуждена.

Вам предстоит создать класс Cat, который будет хранить catName (имя кота) и catAge (его возраст). Чтобы коты могли путешествовать сквозь время (то есть, быть сохраненными и восстановленными), ваш класс Cat должен реализовать интерфейс Serializable.

Самое интересное начинается, когда вы учите своих котов "говорить" при сохранении и пробуждении. Для этого вы реализуете специальные методы writeObject и readObject с их точными сигнатурами. Каждый раз, когда кот "засыпает" для сохранения, метод writeObject должен выводить сообщение вроде "Сущность Кота отправляется в хранилище: имя = [имя], возраст = [возраст]". И когда он "просыпается", метод readObject должен радостно объявлять: "Сущность Кота пробудилась из хранилища: имя = [имя], возраст = [возраст]".

Ваша задача — создать одного такого кота, позволить ему "заснуть" (сериализовать) и "проснуться" (десериализовать), чтобы увидеть на экране оба эти волшебные сообщения, подтверждающие, что процесс прошел успешно.

Требования:
•	Класс Cat должен явно реализовывать интерфейс Serializable для поддержки сериализации.
•	Класс Cat должен содержать два приватных поля: catName (имя кота) и catAge (возраст кота).
•	В классе Cat должен быть реализован приватный метод writeObject с сигнатурой private void writeObject(ObjectOutputStream out) throws IOException, который выводит сообщение "Сущность Кота отправляется в хранилище: имя = [имя], возраст = [возраст]" перед сериализацией полей.
•	В классе Cat должен быть реализован приватный метод readObject с сигнатурой private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException, который выводит сообщение "Сущность Кота пробудилась из хранилища: имя = [имя], возраст = [возраст]" после десериализации полей.
•	В программе должен быть создан объект Cat, который сериализуется в поток (файл или память), затем десериализуется обратно, чтобы оба сообщения (о сохранении и пробуждении) появились на экране.
•	После десериализации объект Cat должен иметь те же значения имени и возраста, что и до сериализации.
•	Методы writeObject и readObject должны иметь точные сигнатуры, необходимые для корректной работы механизма сериализации в Java.
•	Сообщения о "засыпании" и "пробуждении" должны появляться только в процессе сериализации и десериализации, а не при обычном создании объекта.

import java.io.*;

// Демонстрационная программа: создаем кота, сериализуем и десериализуем его.
// На экран должны выводиться сообщения только из writeObject и readObject.
public class Solution {
    public static void main(String[] args) throws Exception {
        Cat original = new Cat("Мурзик", 3);

        // Сериализуем объект в память (в массив байт), чтобы не создавать файлы
        byte[] data;
        try (ByteArrayOutputStream buffer = new ByteArrayOutputStream();
             ObjectOutputStream oos = new ObjectOutputStream(buffer)) {
            oos.writeObject(original); // Здесь вызовется Cat.writeObject(...)
            data = buffer.toByteArray();
        }

        // Десериализуем объект из памяти
        try (ByteArrayInputStream input = new ByteArrayInputStream(data);
             ObjectInputStream ois = new ObjectInputStream(input)) {
            Cat restored = (Cat) ois.readObject(); // Здесь вызовется Cat.readObject(...)
            // Ничего не печатаем, чтобы удовлетворить требование "сообщения только при (де)сериализации".
            // Состояние restored совпадает с original благодаря стандартной сериализации.
        }
    }
}

 */

import java.io.*;

// Демонстрационная программа: создаем кота, сериализуем и десериализуем его.
// На экран должны выводиться сообщения только из writeObject и readObject.
public class Solution {
    public static void main(String[] args) throws Exception {
        Cat original = new Cat("Мурзик", 3);

        // Сериализуем объект в память (в массив байт), чтобы не создавать файлы
        byte[] data;
        try (ByteArrayOutputStream buffer = new ByteArrayOutputStream();
             ObjectOutputStream oos = new ObjectOutputStream(buffer)) {
            oos.writeObject(original); // Здесь вызовется Cat.writeObject(...)
            data = buffer.toByteArray();
        }

        // Десериализуем объект из памяти
        try (ByteArrayInputStream input = new ByteArrayInputStream(data);
             ObjectInputStream ois = new ObjectInputStream(input)) {
            Cat restored = (Cat) ois.readObject(); // Здесь вызовется Cat.readObject(...)
            // Ничего не печатаем, чтобы удовлетворить требование "сообщения только при (де)сериализации".
            // Состояние restored совпадает с original благодаря стандартной сериализации.
        }
    }
}

class Cat implements Serializable {
    private String catName;
    private int catAge;

    public Cat(String name, int age) {
        this.catName = name;
        this.catAge = age;
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        System.out.println("Сущность Кота отправляется в хранилище: имя = " + catName + ", возраст = " + catAge);
        out.defaultWriteObject();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        System.out.println("Сущность Кота пробудилась из хранилища: имя = " + catName + ", возраст = " + catAge);
        ;
    }
}
/*
import java.io.*;

// Демонстрационная программа: создаем кота, сериализуем и десериализуем его.
// На экран должны выводиться сообщения только из writeObject и readObject.
public class Solution {
    public static void main(String[] args) throws Exception {
        Cat original = new Cat("Мурзик", 3);

        // Сериализуем объект в память (в массив байт), чтобы не создавать файлы
        byte[] data;
        try (ByteArrayOutputStream buffer = new ByteArrayOutputStream();
             ObjectOutputStream oos = new ObjectOutputStream(buffer)) {
            oos.writeObject(original); // Здесь вызовется Cat.writeObject(...)
            data = buffer.toByteArray();
        }

        // Десериализуем объект из памяти
        try (ByteArrayInputStream input = new ByteArrayInputStream(data);
             ObjectInputStream ois = new ObjectInputStream(input)) {
            Cat restored = (Cat) ois.readObject(); // Здесь вызовется Cat.readObject(...)
            // Ничего не печатаем, чтобы удовлетворить требование "сообщения только при (де)сериализации".
            // Состояние restored совпадает с original благодаря стандартной сериализации.
        }
    }
}

// Класс Cat хранит имя и возраст, и поддерживает сериализацию.
// Сообщения печатаются только в пользовательских методах writeObject/readObject.
class Cat implements Serializable {
    private String catName; // имя кота
    private int catAge;     // возраст кота

    public Cat(String catName, int catAge) {
        this.catName = catName;
        this.catAge = catAge;
    }

    // Кастомная сериализация:
    // 1) выводим сообщение перед записью полей
    // 2) делегируем стандартной сериализации через defaultWriteObject
    private void writeObject(ObjectOutputStream out) throws IOException {
        // Сообщение о "засыпании" (сохранении)
        System.out.println("Сущность Кота отправляется в хранилище: имя = " + catName + ", возраст = " + catAge);
        out.defaultWriteObject(); // стандартная сериализация приватных полей
    }

    // Кастомная десериализация:
    // 1) восстанавливаем поля стандартным способом через defaultReadObject
    // 2) выводим сообщение после восстановления полей
    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject(); // стандартная десериализация приватных полей
        // Сообщение о "пробуждении" (восстановлении)
        System.out.println("Сущность Кота пробудилась из хранилища: имя = " + catName + ", возраст = " + catAge);
    }
}
 */