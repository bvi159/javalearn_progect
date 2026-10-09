package ru.javarush.java.core.level45.task07;
/*
Система учёта животных: добавление цвета без потери старых данных
Представьте, что вы разрабатываете систему учёта животных в зоопарке. Изначально для каждого животного вы хранили только его вид и примерный вес.

Создайте класс Animal, который будет представлять одно животное. Он должен быть Serializable, чтобы вы могли сохранять данные о ваших питомцах. Добавьте в него два поля: animalType типа String (например, "Лев") и animalWeight типа int (например, 200 кг). Очень важно сразу же присвоить этому классу статический финальный serialVersionUID со значением 100L.

Имитируя работу первой версии вашей системы, создайте объект Animal (например, "Зебра", 350 кг) и сериализуйте его в файл с именем "animal.dat". Это как бы "сохранение состояния" вашего зоопарка.

Спустя некоторое время, у вас возникла идея дополнить данные о животных информацией об их окрасе. Для этого вы решите изменить класс Animal, добавив в него новое поле animalColor типа String. Однако, чтобы не потерять совместимость со старыми сохранёнными файлами, вы сознательно не меняете значение serialVersionUID, оставляя его 100L.

После изменения класса, попробуйте десериализовать тот самый объект Animal из файла "animal.dat", который вы сохранили до всех изменений. После успешной десериализации, выведите на экран значения всех полей этого объекта: animalType, animalWeight и animalColor. Вы должны убедиться, что animalColor, которого не было в старом сериализованном файле, автоматически принял значение null – это стандартное поведение для объектов, демонстрирующее, как Java справляется с добавлением новых полей без изменения serialVersionUID.

Требования:
•	Класс Animal должен реализовывать интерфейс Serializable.
•	В классе Animal должно быть объявлено статическое финальное поле serialVersionUID со значением 100L.
•	В первой версии класса Animal должны присутствовать два поля: animalType типа String и animalWeight типа int.
•	В первой версии программы необходимо создать объект Animal (например, "Зебра", 350) и сериализовать его в файл с именем "animal.dat".
•	Во второй версии класса Animal нужно добавить новое поле animalColor типа String, не изменяя значение serialVersionUID.
•	После добавления нового поля, необходимо десериализовать объект Animal из файла "animal.dat".
•	После десериализации следует вывести значения всех трёх полей: animalType, animalWeight и animalColor. Поле animalColor должно иметь значение null.
•	serialVersionUID должен оставаться неизменным (100L) для обеспечения совместимости между версиями класса при десериализации.

import java.io.*;

// Для демонстрации в одном запуске мы используем два класса:
// 1) OldAnimal — "первая версия" (без цвета)
// 2) Animal    — "вторая версия" (с добавленным полем цвета)
// При чтении из файла мы подменяем имя класса OldAnimal на Animal через
// ObjectInputStream.resolveClass(...). Это имитирует ситуацию, когда
// старый файл читается новым классом с тем же serialVersionUID.
public class Solution {
    public static void main(String[] args) throws Exception {
        // 1) "Первая версия" системы: создаем объект без поля цвета и сериализуем его
        OldAnimal zebraV1 = new OldAnimal("Зебра", 350);

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("animal.dat"))) {
            oos.writeObject(zebraV1); // сохраняем старую версию объекта
        }

        // 2) "Вторая версия" класса Animal: добавлено поле animalColor, serialVersionUID не меняем.
        // Десериализуем старый файл. При чтении маппим OldAnimal -> Animal.
        Animal loaded;
        try (ObjectInputStream ois = new MappingObjectInputStream(new FileInputStream("animal.dat"))) {
            loaded = (Animal) ois.readObject();
        }

        // Выводим все поля. animalColor должен быть null, т.к. его не было в старом файле
        System.out.println("animalType=" + loaded.animalType);
        System.out.println("animalWeight=" + loaded.animalWeight);
        System.out.println("animalColor=" + loaded.animalColor); // ожидается: null
    }
}

 */

import java.io.*;

// Для демонстрации в одном запуске мы используем два класса:
// 1) OldAnimal — "первая версия" (без цвета)
// 2) Animal    — "вторая версия" (с добавленным полем цвета)
// При чтении из файла мы подменяем имя класса OldAnimal на Animal через
// ObjectInputStream.resolveClass(...). Это имитирует ситуацию, когда
// старый файл читается новым классом с тем же serialVersionUID.
public class Solution {
    public static void main(String[] args) throws Exception {
        // 1) "Первая версия" системы: создаем объект без поля цвета и сериализуем его
        ru.javarush.java.core.level45.task07.v1.Animal zebraV1 = new ru.javarush.java.core.level45.task07.v1.Animal("Зебра", 350);
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("animal.dat"))) {
//        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("animal.dat"))) {
            oos.writeObject(zebraV1); // сохраняем старую версию объекта
        }

        // 2) "Вторая версия" класса Animal: добавлено поле animalColor, serialVersionUID не меняем.
        // Десериализуем старый файл. При чтении маппим OldAnimal -> Animal.
        // Чтение — через MappingObjectInputStream
        Animal loaded;
        try (ObjectInputStream ois = new MappingObjectInputStream(new FileInputStream("animal.dat"))) {
            loaded = (Animal) ois.readObject();
        }

        System.out.println("animalType=" + loaded.animalType);
        System.out.println("animalWeight=" + loaded.animalWeight);
        System.out.println("animalColor=" + loaded.animalColor); // null
    }
}

class Animal implements Serializable {
    private static final long serialVersionUID = 100L;
    final String animalType;
    final int animalWeight;
    final String animalColor;

    public Animal(String name, int weight, String color) {
        this.animalType = name;
        this.animalWeight = weight;
        this.animalColor = color;
    }
}

class MappingObjectInputStream extends ObjectInputStream {
    public MappingObjectInputStream(InputStream in) throws IOException {
        super(in);
    }

    @Override
    protected Class<?> resolveClass(ObjectStreamClass desc) throws IOException, ClassNotFoundException {
        if (desc.getName().equals("ru.javarush.java.core.level45.task07.v1.Animal")) {
            return Animal.class;
        }
        return super.resolveClass(desc);
    }
}
/*


 */