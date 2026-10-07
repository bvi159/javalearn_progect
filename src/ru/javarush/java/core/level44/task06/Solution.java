package ru.javarush.java.core.level44.task06;
/*
Сохранение топологии сети: сериализация графа с циклическим маршрутом 🌐
Вы — инженер, создающий модель компьютерной сети или маршрутов доставки, где каждый узел знает своих соседей, а сама сеть представляет собой замкнутый цикл, позволяющий данным возвращаться к источнику. Ваша задача — убедиться, что топология этой сети не будет нарушена при сохранении и загрузке, и ссылки на объекты останутся идентичными.

Начните с создания класса Node, который будет представлять узел в вашей сети. Этот класс должен содержать строковое имя (name) для идентификации узла и список (List<Node>) соседей (neighbors), с которыми данный узел напрямую связан. Чтобы сделать возможным сохранение состояния сети, класс Node обязательно должен реализовать интерфейс Serializable.

В вашем методе main создайте три уникальных объекта Node: node1, node2 и node3. Теперь самое важное: установите между ними связи таким образом, чтобы они образовали замкнутый цикл. Например, пусть node1 имеет в качестве соседа node2, node2 — node3, а node3 — node1. Таким образом, вы создадите цикл: node1 -> node2 -> node3 -> node1.

Далее, чтобы сохранить состояние вашей циклической сети, сериализуйте node1 в файл. После этого, чтобы проверить целостность восстановления, десериализуйте его обратно из файла. В заключение, выведите на экран результат сравнения: node1 после десериализации должен быть равен (==) node1.neighbors.get(0).neighbors.get(0).neighbors.get(0). Если все сделано правильно, ожидаемый результат — true, что продемонстрирует, что сериализация корректно обработала циклические ссылки и восстановила идентичность объектов внутри графа.

Требования:
•	Класс Node должен быть объявлен с полем String name и полем List<Node> neighbors.
•	Класс Node должен реализовывать интерфейс Serializable.
•	В методе main необходимо создать три объекта Node: node1, node2 и node3, каждый с уникальным именем.
•	В методе main необходимо настроить связи между объектами так, чтобы получился цикл: node1 -> node2 -> node3 -> node1.
•	Объект node1 должен быть сериализован в файл с помощью ObjectOutputStream.
•	Объект node1 должен быть десериализован из файла с помощью ObjectInputStream.
•	После десериализации необходимо сравнить node1 с node1.neighbors.get(0).neighbors.get(0).neighbors.get(0) с помощью оператора ==.
•	Результат сравнения идентичности должен быть выведен на экран.

import java.io.*;
import java.util.ArrayList;
import java.util.List;

// Класс узла сети: имя и список соседей.
// Реализует Serializable, чтобы можно было сохранять/загружать граф целиком.
class Node implements Serializable {
    private static final long serialVersionUID = 1L;

    String name;
    List<Node> neighbors;

    Node(String name) {
        this.name = name;
        this.neighbors = new ArrayList<>();
    }
}

public class Solution {
    public static void main(String[] args) throws Exception {
        // Создаем три узла с уникальными именами
        Node node1 = new Node("node1");
        Node node2 = new Node("node2");
        Node node3 = new Node("node3");

        // Формируем замкнутый цикл: node1 -> node2 -> node3 -> node1
        node1.neighbors.add(node2);
        node2.neighbors.add(node3);
        node3.neighbors.add(node1);

        // Сериализуем node1 в файл. ObjectOutputStream корректно обрабатывает циклы в графах.


        // Десериализуем обратно: получаем корень восстановленного графа


        // Идем по соседям три раза: должны вернуться к исходному узлу node1


        // Выводим результат проверки идентичности (должно быть true)

    }
}

 */

import java.io.*;
import java.util.ArrayList;
import java.util.List;

// Класс узла сети: имя и список соседей.
// Реализует Serializable, чтобы можно было сохранять/загружать граф целиком.
class Node implements Serializable {
    private static final long serialVersionUID = 1L;

    String name;
    List<Node> neighbors;

    Node(String name) {
        this.name = name;
        this.neighbors = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Имя узла: " + name;
    }
}

public class Solution {
    public static void main(String[] args) throws Exception {
        // Создаем три узла с уникальными именами
        Node node1 = new Node("node1");
        Node node2 = new Node("node2");
        Node node3 = new Node("node3");

        // Формируем замкнутый цикл: node1 -> node2 -> node3 -> node1
        node1.neighbors.add(node2);
        node2.neighbors.add(node3);
        node3.neighbors.add(node1);

        // Сериализуем node1 в файл. ObjectOutputStream корректно обрабатывает циклы в графах.
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("node.ser"));
        oos.writeObject(node1);
        oos.close();

        // Десериализуем обратно: получаем корень восстановленного графа
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("node.ser"));
        Node recoveredNode = (Node) ois.readObject();
        ois.close();

        // Идем по соседям три раза: должны вернуться к исходному узлу node1


        // Выводим результат проверки идентичности (должно быть true)
        System.out.println(recoveredNode == recoveredNode.neighbors.get(0).neighbors.get(0).neighbors.get(0));
        System.out.println(recoveredNode.neighbors.get(0));
        System.out.println(recoveredNode.neighbors.get(0).neighbors.get(0));
        System.out.println(recoveredNode.neighbors.get(0).neighbors.get(0).neighbors.get(0));

    }
}



/*
import java.io.*;
import java.util.ArrayList;
import java.util.List;

// Класс узла сети: имя и список соседей.
// Реализует Serializable, чтобы можно было сохранять/загружать граф целиком.
class Node implements Serializable {
    private static final long serialVersionUID = 1L;

    String name;
    List<Node> neighbors;

    Node(String name) {
        this.name = name;
        this.neighbors = new ArrayList<>();
    }
}

public class Solution {
    public static void main(String[] args) throws Exception {
        // Создаем три узла с уникальными именами
        Node node1 = new Node("node1");
        Node node2 = new Node("node2");
        Node node3 = new Node("node3");

        // Формируем замкнутый цикл: node1 -> node2 -> node3 -> node1
        node1.neighbors.add(node2);
        node2.neighbors.add(node3);
        node3.neighbors.add(node1);

        // Сериализуем node1 в файл. ObjectOutputStream корректно обрабатывает циклы в графах.
        String fileName = "network.bin";
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName))) {
            out.writeObject(node1);
        }

        // Десериализуем обратно: получаем корень восстановленного графа
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName))) {
            node1 = (Node) in.readObject(); // важно сравнивать уже десериализованный node1
        }

        // Идем по соседям три раза: должны вернуться к исходному узлу node1
        boolean same = node1 == node1.neighbors.get(0).neighbors.get(0).neighbors.get(0);

        // Выводим результат проверки идентичности (должно быть true)
        System.out.println(same);
    }
}

 */