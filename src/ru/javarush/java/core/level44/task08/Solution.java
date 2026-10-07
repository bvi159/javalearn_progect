package ru.javarush.java.core.level44.task08;
/*
Управление инвентарем: идентичность объектов при раздельном хранении 📦
Вы отвечаете за логистику ценных грузов на складе, и вам нужно очень точно отслеживать идентичность каждого предмета. Что произойдет, если один и тот же уникальный объект будет "упакован" в несколько контейнеров, каждый из которых будет отправлен отдельно, а затем распакован? Сохранится ли их идентичность на уровне ссылок Java, или они станут независимыми копиями?

Для этого сценария создайте простой класс Item с полем String name и убедитесь, что он реализует интерфейс Serializable. Затем создайте вспомогательный класс Wrapper с полем типа Item (например, wrappedItem), который также должен быть Serializable.

В вашем методе main сначала создайте один объект Item, скажем, uniqueItem, и присвойте ему имя (например, "Magic Amulet"). Затем создайте два объекта Wrapper: firstWrapper и secondWrapper. Важно, чтобы поле wrappedItem в обоих этих Wrapper объектах ссылалось на один и тот же uniqueItem.

Теперь начинается эксперимент с хранением: сериализуйте firstWrapper в отдельный файл (например, "wrapper1.ser"), а затем сериализуйте secondWrapper во второй отдельный файл (например, "wrapper2.ser"). После этого, представьте, что вы восстанавливаете эти контейнеры независимо друг от друга: десериализуйте firstWrapper из "wrapper1.ser" в restoredFirstWrapper и secondWrapper из "wrapper2.ser" в restoredSecondWrapper.

В завершение, ваша программа должна проверить и вывести результат сравнения (==) между restoredFirstWrapper.wrappedItem и restoredSecondWrapper.wrappedItem. Ожидайте false, поскольку при раздельной сериализации одного и того же исходного объекта в разные потоки и файлы, после десериализации создаются независимые копии. Также для наглядности выведите значения name для restoredFirstWrapper.wrappedItem и restoredSecondWrapper.wrappedItem, чтобы показать, что содержимое данных идентично, но их ссылки — нет.

Требования:
•	Класс Item должен содержать поле String name и реализовывать интерфейс Serializable.
•	Класс Wrapper должен содержать поле типа Item (например, wrappedItem) и также реализовывать интерфейс Serializable.
•	В методе main должен быть создан только один объект Item, которому присваивается имя (например, "Magic Amulet").
•	В методе main должны быть созданы два объекта Wrapper (firstWrapper и secondWrapper), поле wrappedItem у обоих должно ссылаться на один и тот же объект Item.
•	firstWrapper должен быть сериализован в отдельный файл (например, "wrapper1.ser"), а secondWrapper — во второй файл (например, "wrapper2.ser").
•	restoredFirstWrapper должен быть восстановлен из "wrapper1.ser", а restoredSecondWrapper — из "wrapper2.ser". Десериализация должна происходить независимо для каждого файла.
•	Программа должна сравнить ссылки restoredFirstWrapper.wrappedItem и restoredSecondWrapper.wrappedItem с помощью оператора == и вывести результат (ожидается false).
•	Программа должна вывести значения поля name для restoredFirstWrapper.wrappedItem и restoredSecondWrapper.wrappedItem, чтобы показать, что данные идентичны, несмотря на разные ссылки.

import java.io.*;

// Класс Item с именем и поддержкой сериализации
class Item implements Serializable {
    public String name; // простое публичное поле для наглядности
}

// Обертка над Item, тоже сериализуемая
class Wrapper implements Serializable {
    public Item wrappedItem;
}

public class Solution {
    public static void main(String[] args) throws Exception {
        // Создаем один-единственный уникальный Item
        Item uniqueItem = new Item();
        uniqueItem.name = "Magic Amulet";

        // Создаем два Wrapper, оба ссылаются на один и тот же uniqueItem
        Wrapper firstWrapper = new Wrapper();
        firstWrapper.wrappedItem = uniqueItem;

        Wrapper secondWrapper = new Wrapper();
        secondWrapper.wrappedItem = uniqueItem;

        // Сериализуем каждый Wrapper в свой файл (разные потоки, разные файлы)
        // Важно: при раздельной сериализации графы объектов не "делят" идентичность между файлами


        // Независимо десериализуем каждый Wrapper из своего файла


        // Сравниваем ссылки на вложенные Item: ожидается false
        // (== сравнивает именно ссылки, а после раздельной десериализации создаются независимые копии)


        // Для наглядности выводим имена: данные совпадают, ссылки — нет

    }
}

 */

import java.io.*;
import java.util.Arrays;
import java.util.List;

// Класс Item с именем и поддержкой сериализации
class Item implements Serializable {
    public String name; // простое публичное поле для наглядности
}

// Обертка над Item, тоже сериализуемая
class Wrapper implements Serializable {
    public Item wrappedItem;
}

public class Solution {
//    public Solution() throws IOException {
//    }

    public static void main(String[] args) throws Exception {
        // Создаем один-единственный уникальный Item
        Item uniqueItem = new Item();
        uniqueItem.name = "Magic Amulet";

        // Создаем два Wrapper, оба ссылаются на один и тот же uniqueItem
        Wrapper firstWrapper = new Wrapper();
        firstWrapper.wrappedItem = uniqueItem;

        Wrapper secondWrapper = new Wrapper();
        secondWrapper.wrappedItem = uniqueItem;

        // Сериализуем каждый Wrapper в свой файл (разные потоки, разные файлы)
        // Важно: при раздельной сериализации графы объектов не "делят" идентичность между файлами
        ObjectOutputStream oos1 = new ObjectOutputStream(new FileOutputStream("magic1.ser"));
        ObjectOutputStream oos2 = new ObjectOutputStream(new FileOutputStream("magic2.ser"));
        oos1.writeObject(firstWrapper);
        oos2.writeObject(secondWrapper);
        oos1.close();
        oos2.close();

        // Независимо десериализуем каждый Wrapper из своего файла
        ObjectInputStream ois1 = new ObjectInputStream(new FileInputStream("magic1.ser"));
        ObjectInputStream ois2 = new ObjectInputStream(new FileInputStream("magic2.ser"));
        Wrapper restoredFirstWrapper = (Wrapper) ois1.readObject();
        Wrapper restoredSecondWrapper = (Wrapper) ois2.readObject();
        ois1.close();
        ois2.close();
        // Сравниваем ссылки на вложенные Item: ожидается false
        // (== сравнивает именно ссылки, а после раздельной десериализации создаются независимые копии)
        System.out.println(restoredFirstWrapper.wrappedItem == restoredSecondWrapper.wrappedItem);

        // Для наглядности выводим имена: данные совпадают, ссылки — нет
        System.out.println(restoredFirstWrapper.wrappedItem.name);
        System.out.println(restoredSecondWrapper.wrappedItem.name);


        // пример из следующей лекции
        // Сериализация
        List<String> names = Arrays.asList("Анна", "Борис");
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("names.ser"))) {
            oos.writeObject(names);
        }

        // Десериализация (ОПАСНО!)
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("names.ser"))) {
            List<Integer> numbers = (List<Integer>) ois.readObject(); // unchecked cast
            Integer first = numbers.get(0); // БУМ! ClassCastException
        }
    }
}
/*
import java.io.*;

// Класс Item с именем и поддержкой сериализации
class Item implements Serializable {
    public String name; // простое публичное поле для наглядности
}

// Обертка над Item, тоже сериализуемая
class Wrapper implements Serializable {
    public Item wrappedItem;
}

public class Solution {
    public static void main(String[] args) throws Exception {
        // Создаем один-единственный уникальный Item
        Item uniqueItem = new Item();
        uniqueItem.name = "Magic Amulet";

        // Создаем два Wrapper, оба ссылаются на один и тот же uniqueItem
        Wrapper firstWrapper = new Wrapper();
        firstWrapper.wrappedItem = uniqueItem;

        Wrapper secondWrapper = new Wrapper();
        secondWrapper.wrappedItem = uniqueItem;

        // Сериализуем каждый Wrapper в свой файл (разные потоки, разные файлы)
        // Важно: при раздельной сериализации графы объектов не "делят" идентичность между файлами
        try (ObjectOutputStream out1 = new ObjectOutputStream(new FileOutputStream("wrapper1.ser"))) {
            out1.writeObject(firstWrapper);
        }
        try (ObjectOutputStream out2 = new ObjectOutputStream(new FileOutputStream("wrapper2.ser"))) {
            out2.writeObject(secondWrapper);
        }

        // Независимо десериализуем каждый Wrapper из своего файла
        Wrapper restoredFirstWrapper;
        Wrapper restoredSecondWrapper;
        try (ObjectInputStream in1 = new ObjectInputStream(new FileInputStream("wrapper1.ser"))) {
            restoredFirstWrapper = (Wrapper) in1.readObject();
        }
        try (ObjectInputStream in2 = new ObjectInputStream(new FileInputStream("wrapper2.ser"))) {
            restoredSecondWrapper = (Wrapper) in2.readObject();
        }

        // Сравниваем ссылки на вложенные Item: ожидается false
        // (== сравнивает именно ссылки, а после раздельной десериализации создаются независимые копии)
        System.out.println(restoredFirstWrapper.wrappedItem == restoredSecondWrapper.wrappedItem);

        // Для наглядности выводим имена: данные совпадают, ссылки — нет
        System.out.println(restoredFirstWrapper.wrappedItem.name);
        System.out.println(restoredSecondWrapper.wrappedItem.name);
    }
}
 */

