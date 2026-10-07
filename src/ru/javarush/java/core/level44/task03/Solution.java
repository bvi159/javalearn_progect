package ru.javarush.java.core.level44.task03;
/*
Картографирование подземных тоннелей с циклическим маршрутом 🚇
Вы — архитектор сложной сетевой структуры, такой как система взаимосвязанных станций в кольцевом метро или серия узлов в замкнутой цепи передачи данных. Каждый узел в этой системе не только знает, куда идти дальше, но и помнит, откуда он пришел, создавая замкнутый круг. Ваша задача — создать программную модель такого узла и продемонстрировать, как можно сохранить и восстановить всю эту запутанную, но логичную структуру.

Начните с создания класса Node. Этот класс должен содержать строковое значение (value), которое может представлять название станции или идентификатор узла. Самое интересное здесь — это ссылки на следующий (next) и предыдущий (prev) узлы, которые также будут объектами типа Node. Чтобы обеспечить стабильность вашей сети и возможность ее сохранения, класс Node обязательно должен реализовать интерфейс Serializable.

Внутри вашего метода main создайте три уникальных объекта Node, которые будут представлять собой три станции. Назовите их firstNodeInCycle, middleNode и lastNodeInCycle. Теперь самое важное: свяжите их таким образом, чтобы они образовали замкнутый цикл. Пусть firstNodeInCycle указывает на middleNode, middleNode на lastNodeInCycle, а lastNodeInCycle с помощью своей prev ссылки указывает на firstNodeInCycle, формируя кольцо.

Далее, представьте, что вам нужно сохранить состояние всей вашей кольцевой линии: сериализуйте firstNodeInCycle в файл с именем "nodes.ser". После этого, чтобы убедиться, что вся структура восстановлена идеально, десериализуйте этот узел обратно из файла. В заключение, пройдитесь по восстановленной цепочке узлов, используя исключительно поле next, и выведите на экран значения value для всех трёх узлов, демонстрируя, что циклическая структура сохранила свою целостность.

Требования:
•	Необходимо создать класс Node, который содержит строковое поле value и два ссылочных поля next и prev, оба типа Node.
•	Класс Node должен реализовывать интерфейс Serializable для поддержки сериализации.
•	В методе main нужно создать три объекта Node с уникальными значениями value, связать их так, чтобы они образовали замкнутый цикл через поля next и prev: firstNodeInCycle.next = middleNode, middleNode.next = lastNodeInCycle, lastNodeInCycle.next = firstNodeInCycle, а также корректно установить prev для каждого узла.
•	В методе main необходимо сериализовать объект firstNodeInCycle в файл с именем "nodes.ser" с помощью ObjectOutputStream.
•	В методе main необходимо десериализовать объект firstNodeInCycle из файла "nodes.ser" с помощью ObjectInputStream.
•	После десериализации нужно пройти по циклу, начиная с восстановленного firstNodeInCycle, три раза по полю next и вывести значения value каждого узла на экран, чтобы убедиться, что структура осталась циклической и корректной.

import java.io.*;

// Класс узла двусвязного кольца.
// Реализует Serializable, чтобы можно было сохранять/восстанавливать граф объектов с циклами.
class Node implements Serializable {
    String value; // значение узла (например, название станции)
    Node next;    // ссылка на следующий узел
    Node prev;    // ссылка на предыдущий узел

    Node(String value) {
        this.value = value;
    }
}

public class Solution {
    public static void main(String[] args) throws Exception {
        // 1) Создаем три уникальных узла
        Node firstNodeInCycle = new Node("Station A");
        Node middleNode = new Node("Station B");
        Node lastNodeInCycle = new Node("Station C");

        // 2) Связываем их в замкнутый двусвязный цикл
        // Прямые ссылки
        firstNodeInCycle.next = middleNode;
        middleNode.next = lastNodeInCycle;
        lastNodeInCycle.next = firstNodeInCycle; // замыкаем кольцо по next

        // Обратные ссылки


        // 3) Сериализуем первый узел (вся структура сохранится, т.к. сериализуется граф объектов)

            // Стандартная бинарная сериализация корректно обрабатывает циклические ссылки.



        // 4) Десериализуем обратно


        // 5) Проверяем целостность структуры: идем по next и печатаем значения трех узлов

    }
}


 */

import java.io.*;

// Класс узла двусвязного кольца.
// Реализует Serializable, чтобы можно было сохранять/восстанавливать граф объектов с циклами.
class Node implements Serializable {
    String value; // значение узла (например, название станции)
    Node next;    // ссылка на следующий узел
    Node prev;    // ссылка на предыдущий узел

    Node(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node = " + value;
    }
}

public class Solution {
    public static void main(String[] args) throws Exception {
        // 1) Создаем три уникальных узла
        Node firstNodeInCycle = new Node("Station A");
        Node middleNode = new Node("Station B");
        Node lastNodeInCycle = new Node("Station C");

        // 2) Связываем их в замкнутый двусвязный цикл
        // Прямые ссылки
        firstNodeInCycle.next = middleNode;
        middleNode.next = lastNodeInCycle;
        lastNodeInCycle.next = firstNodeInCycle; // замыкаем кольцо по next

        // Обратные ссылки
        firstNodeInCycle.prev = lastNodeInCycle;
        middleNode.prev = firstNodeInCycle;
        lastNodeInCycle.prev = middleNode;


        // 3) Сериализуем первый узел (вся структура сохранится, т.к. сериализуется граф объектов)
        // Стандартная бинарная сериализация корректно обрабатывает циклические ссылки.
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("nodes.ser"));
        oos.writeObject(firstNodeInCycle);
        oos.close();


        // 4) Десериализуем обратно
        // 5) Проверяем целостность структуры: идем по next и печатаем значения трех узлов
        Node loadedNode;
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("nodes.ser"));
        loadedNode = (Node) ois.readObject();
        // Перебор всех узлов кольца
        Node current = loadedNode;
        do {
            System.out.println(current);
            current = current.next;
        } while (current != loadedNode);
        ois.close();

    }
}
/*
import java.io.*;

// Класс узла двусвязного кольца.
// Реализует Serializable, чтобы можно было сохранять/восстанавливать граф объектов с циклами.
class Node implements Serializable {
    String value; // значение узла (например, название станции)
    Node next;    // ссылка на следующий узел
    Node prev;    // ссылка на предыдущий узел

    Node(String value) {
        this.value = value;
    }
}

public class Solution {
    public static void main(String[] args) throws Exception {
        // 1) Создаем три уникальных узла
        Node firstNodeInCycle = new Node("Station A");
        Node middleNode = new Node("Station B");
        Node lastNodeInCycle = new Node("Station C");

        // 2) Связываем их в замкнутый двусвязный цикл
        // Прямые ссылки
        firstNodeInCycle.next = middleNode;
        middleNode.next = lastNodeInCycle;
        lastNodeInCycle.next = firstNodeInCycle; // замыкаем кольцо по next

        // Обратные ссылки
        middleNode.prev = firstNodeInCycle;
        lastNodeInCycle.prev = middleNode;
        firstNodeInCycle.prev = lastNodeInCycle; // замыкаем кольцо по prev

        // 3) Сериализуем первый узел (вся структура сохранится, т.к. сериализуется граф объектов)
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("nodes.ser"))) {
            // Стандартная бинарная сериализация корректно обрабатывает циклические ссылки.
            oos.writeObject(firstNodeInCycle);
        }

        // 4) Десериализуем обратно
        Node restoredFirstNodeInCycle;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("nodes.ser"))) {
            restoredFirstNodeInCycle = (Node) ois.readObject();
        }

        // 5) Проверяем целостность структуры: идем по next и печатаем значения трех узлов
        Node current = restoredFirstNodeInCycle;
        for (int i = 0; i < 3; i++) {
            System.out.println(current.value);
            current = current.next; // двигаемся только по next
        }
    }
}
 */