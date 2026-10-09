package ru.javarush.java.core.level45.task03;
/*
Таинственная коробка: проверка содержимого после извлечения
Представьте, что у вас есть таинственная коробка, которая умеет сохранять любые предметы, а затем возвращать их. Вы решаете положить в эту коробку два очень разных предмета: одно текстовое сообщение и одно целое число.

Для начала создайте список mysteryBoxContents типа List<Object>, который сможет хранить объекты любого типа. Добавьте в него одно текстовое сообщение (например, "Hello Java") и одно целое число (например, 123). Теперь представьте, что вы закрываете коробку и отправляете её на хранение: сериализуйте этот список в файл.

Когда придёт время доставать содержимое, вы десериализуете список обратно. Ваша задача — попытаться угадать, что все элементы в этой коробке на самом деле были текстовыми сообщениями, и попытаться привести весь десериализованный список к типу List<String>.

Чтобы убедиться, что вы правильно идентифицировали содержимое (или что ваши предположения неверны), для каждого элемента в десериализованном списке выведите на экран его фактический класс, используя метод getClass(). Если во время попытки приведения всего списка к List<String> возникнет неожиданная ClassCastException – а она возникнет, потому что список содержит не только строки – ваша программа должна аккуратно обработать эту ситуацию, перехватив исключение, и вывести на экран драматичное сообщение: "Ошибка приведения типа". Это покажет, как важно проверять типы при работе с обобщёнными данными после десериализации.

Требования:
•	Необходимо создать список типа List<Object> и добавить в него строку и целое число.
•	Список mysteryBoxContents должен быть сериализован в файл с помощью стандартных средств сериализации Java.
•	Список должен быть десериализован из файла обратно в объект типа List<Object>.
•	После десериализации необходимо попытаться привести список к типу List<String>.
•	Если при приведении к List<String> возникает исключение ClassCastException, программа должна перехватить его и вывести сообщение "Ошибка приведения типа".
•	Для каждого элемента десериализованного списка необходимо вывести его фактический класс с помощью метода getClass().

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws Exception {
        // 1) Создаем список, способный хранить любые объекты
        List<Object> mysteryBoxContents = new ArrayList<>();
        mysteryBoxContents.add("Hello Java"); // строка
        mysteryBoxContents.add(123);          // целое число

        // 2) Сериализуем список в файл


        // 3) Десериализуем список обратно в List<Object>


        // 4) Выводим фактический класс каждого элемента с использованием getClass()


        // 5) Пытаемся привести весь список к List<String>.
        // Из-за стирания типов ошибка возникнет не в момент каста списка,
        // а в момент чтения элементов как String (внутренний runtime-каст).

    }
}


 */

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws Exception {
        // 1) Создаем список, способный хранить любые объекты
        List<Object> mysteryBoxContents = new ArrayList<>();
        mysteryBoxContents.add("Hello Java"); // строка
        mysteryBoxContents.add(123);          // целое число

        // 2) Сериализуем список в файл
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("mystery.ser"));
        oos.writeObject(mysteryBoxContents);
        oos.close();

        // 3) Десериализуем список обратно в List<Object>
        List<Object> ressurectedMysteryBox;
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("mystery.ser"));
        ressurectedMysteryBox = (List<Object>) ois.readObject();
        ois.close();

        // 4) Выводим фактический класс каждого элемента с использованием getClass()
        for (Object obj : ressurectedMysteryBox) {
            System.out.println(obj.getClass());
        }

        // 5) Пытаемся привести весь список к List<String>.
        // Из-за стирания типов ошибка возникнет не в момент каста списка,
        // а в момент чтения элементов как String (внутренний runtime-каст).
        try {
            List<String> strList = (List) ressurectedMysteryBox;
            String str;
            for (Object obj : ressurectedMysteryBox) {
                str = (String) obj;
                System.out.println(str);
            }
        } catch (ClassCastException e) {
            System.out.println("Ошибка приведения типа");
            ;
        }

    }
}
/*

public class Solution {
    public static void main(String[] args) throws Exception {
        // 1) Создаем список, способный хранить любые объекты
        List<Object> mysteryBoxContents = new ArrayList<>();
        mysteryBoxContents.add("Hello Java"); // строка
        mysteryBoxContents.add(123);          // целое число

        // 2) Сериализуем список в файл
        String fileName = "mysteryBox.bin";
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(mysteryBoxContents);
        }

        // 3) Десериализуем список обратно в List<Object>
        List<Object> deserialized;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            // Возвращается Object, приводим к List<Object> (unchecked — это нормально для учебной задачи)
            deserialized = (List<Object>) ois.readObject();
        }

        // 4) Выводим фактический класс каждого элемента с использованием getClass()
        for (Object item : deserialized) {
            System.out.println(item.getClass()); // например: class java.lang.String, class java.lang.Integer
        }

        // 5) Пытаемся привести весь список к List<String>.
        // Из-за стирания типов ошибка возникнет не в момент каста списка,
        // а в момент чтения элементов как String (внутренний runtime-каст).
        try {
            List<String> guessedAsStrings = (List<String>) (List<?>) deserialized; // намеренно небезопасный каст
            // Попытка пройтись по элементам как по строкам — на Integer выбросит ClassCastException
            for (String s : guessedAsStrings) {
                // Нам не важно содержимое, цель — спровоцировать приведение элемента к String
            }
        } catch (ClassCastException e) {
            System.out.println("Ошибка приведения типа");
        }
    }
}

 */