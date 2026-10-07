package ru.javarush.java.core.level44.task07;
/*
Совместная работа с общим документом: сохранение разделяемых объектов 📝
Представьте, что вы разрабатываете базовую систему для облачного сервиса совместной работы, где несколько "редакторов" или "пользователей" (представленных объектами DataHolder) могут одновременно работать над одним и тем же общим документом (который будет ArrayList<String>). При сохранении состояния этой системы критически важно, чтобы после загрузки общий документ оставался именно общим, а не превратился в независимые копии.

Для этого создайте класс DataHolder с полем ArrayList<String> под названием data. Конечно, DataHolder должен быть Serializable.

В вашем методе main сначала создайте один-единственный экземпляр ArrayList<String>, который будет выступать в роли вашего общего документа. Назовите его, например, sharedDataList. Затем создайте два объекта DataHolder, скажем, firstEditor и secondEditor, и оба они должны ссылаться на один и тот же sharedDataList. То есть, firstEditor.data и secondEditor.data должны указывать на один и тот же объект в памяти.

После этого, чтобы имитировать сохранение состояния всей системы, сериализуйте массив, содержащий firstEditor и secondEditor, в файл. Затем десериализуйте эти объекты обратно. После восстановления добавьте новый элемент в sharedDataList только через один из десериализованных объектов, например, restoredFirstEditor.data.add("New entry"). В завершение, выведите содержимое списка data через оба восстановленных объекта — restoredFirstEditor и restoredSecondEditor. Программа должна наглядно продемонстрировать, что изменения, внесенные через один объект, видны и через другой, подтверждая, что список остался общим.

Требования:
•	Класс DataHolder должен быть объявлен как public и реализовывать интерфейс Serializable.
•	В классе DataHolder должно быть поле с именем data типа ArrayList<String>.
•	В методе main должен быть создан только один экземпляр ArrayList<String>, который будет использоваться как общий документ.
•	При создании объектов firstEditor и secondEditor оба их поля data должны ссылаться на один и тот же экземпляр ArrayList<String>.
•	Вся система (оба объекта DataHolder) должна быть сериализована в файл в виде массива объектов.
•	После сериализации массив объектов должен быть десериализован из файла.
•	После десериализации изменение списка data через один объект (restoredFirstEditor) должно быть видно и через другой объект (restoredSecondEditor), что подтверждает сохранение идентичности объекта.
•	Содержимое списка data должно быть выведено на экран через оба восстановленных объекта для наглядной демонстрации общей ссылки.

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws Exception {
        // 1) Создаем один-единственный общий список — общий "документ"
        ArrayList<String> sharedDataList = new ArrayList<>();

        // 2) Создаем два редактора, которые ССЫЛАЮТСЯ НА ОДИН И ТОТ ЖЕ список
        DataHolder firstEditor = new DataHolder();
        DataHolder secondEditor = new DataHolder();
        firstEditor.data = sharedDataList;
        secondEditor.data = sharedDataList;

        // 3) Сериализуем всю систему (оба объекта) в виде МАССИВА в один файл.
        // Важно: записываем единый граф объектов — это гарантирует сохранение идентичности ссылок.


        // 4) Десериализуем массив обратно


        // 5) Добавляем запись в общий список ТОЛЬКО через один из восстановленных объектов


        // 6) Выводим содержимое списка через оба восстановленных объекта.
        // Должно быть одинаковым, что подтверждает, что список остался общим.


        // Наглядная проверка идентичности ссылки (необязательная, но полезная):

    }
}



 */

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws Exception {
        // 1) Создаем один-единственный общий список — общий "документ"
        ArrayList<String> sharedDataList = new ArrayList<>();

        // 2) Создаем два редактора, которые ССЫЛАЮТСЯ НА ОДИН И ТОТ ЖЕ список
        DataHolder firstEditor = new DataHolder();
        DataHolder secondEditor = new DataHolder();
        firstEditor.data = sharedDataList;
        secondEditor.data = sharedDataList;

        // 3) Сериализуем всю систему (оба объекта) в виде МАССИВА в один файл.
        // Важно: записываем единый граф объектов — это гарантирует сохранение идентичности ссылок.
        Object[] all = {firstEditor, secondEditor};
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("common.ser"));
        oos.writeObject(all);
        oos.close();

        // 4) Десериализуем массив обратно
        Object[] restoredAll;
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("common.ser"));
        restoredAll = (Object[]) ois.readObject();
        ois.close();

        // 5) Добавляем запись в общий список ТОЛЬКО через один из восстановленных объектов
        DataHolder restoredFirstEditor = (DataHolder) restoredAll[0];
        DataHolder restoredSecondEditor = (DataHolder) restoredAll[1];
        //  sharedDataList.add(restoredFirstEditor.data.get(0));
        restoredFirstEditor.data.add("Hello");

        // 6) Выводим содержимое списка через оба восстановленных объекта.
        // Должно быть одинаковым, что подтверждает, что список остался общим.
        System.out.println(restoredFirstEditor.data);
        System.out.println(restoredSecondEditor.data);

        // Наглядная проверка идентичности ссылки (необязательная, но полезная):
        System.out.println(restoredFirstEditor.data == restoredSecondEditor.data);

    }
}

/*
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws Exception {
        // 1) Создаем один-единственный общий список — общий "документ"
        ArrayList<String> sharedDataList = new ArrayList<>();

        // 2) Создаем два редактора, которые ССЫЛАЮТСЯ НА ОДИН И ТОТ ЖЕ список
        DataHolder firstEditor = new DataHolder();
        DataHolder secondEditor = new DataHolder();
        firstEditor.data = sharedDataList;
        secondEditor.data = sharedDataList;

        // 3) Сериализуем всю систему (оба объекта) в виде МАССИВА в один файл.
        // Важно: записываем единый граф объектов — это гарантирует сохранение идентичности ссылок.
        DataHolder[] systemState = { firstEditor, secondEditor };
        String fileName = "system_state.bin";
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(systemState);
        }

        // 4) Десериализуем массив обратно
        DataHolder[] restoredSystem;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            restoredSystem = (DataHolder[]) ois.readObject();
        }

        DataHolder restoredFirstEditor = restoredSystem[0];
        DataHolder restoredSecondEditor = restoredSystem[1];

        // 5) Добавляем запись в общий список ТОЛЬКО через один из восстановленных объектов
        restoredFirstEditor.data.add("New entry");

        // 6) Выводим содержимое списка через оба восстановленных объекта.
        // Должно быть одинаковым, что подтверждает, что список остался общим.
        System.out.println("Через restoredFirstEditor: " + restoredFirstEditor.data);
        System.out.println("Через restoredSecondEditor: " + restoredSecondEditor.data);

        // Наглядная проверка идентичности ссылки (необязательная, но полезная):
        System.out.println("Один и тот же экземпляр списка? " +
                (restoredFirstEditor.data == restoredSecondEditor.data));
    }
}
 */