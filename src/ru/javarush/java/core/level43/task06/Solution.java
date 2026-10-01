package ru.javarush.java.core.level43.task06;
/*
Координаты Навигации: Игра с Порядком
Вы работаете над навигационной системой для космического корабля "Одиссея", и вам необходимо сохранять координаты точек в пространстве. Создайте класс Point с целочисленными полями pointX и pointY. Чтобы получить полный контроль над тем, как эти координаты записываются и считываются, ваш класс Point должен реализовать интерфейс Externalizable.

Здесь начинается самое интересное: в методе writeExternal вы намеренно нарушите обычный порядок и сначала запишете pointY, а затем pointX (out.writeInt(pointY), out.writeInt(pointX)). Теперь, в методе readExternal, вы попробуете восстановить данные, но считывая их в правильном порядке: сначала pointX, затем pointY (pointX = in.readInt(); pointY = in.readInt()).

Ваша цель — создать объект Point с конкретными значениями (например, pointX = 10, pointY = 20), затем сохранить его и загрузить обратно. Выведите значения pointX и pointY после десериализации. Этот эксперимент должен наглядно продемонстрировать, насколько критически важен точный порядок записи и чтения данных при работе с Externalizable, ведь малейшее нарушение может привести к совершенно непредсказуемым результатам, например, pointX может оказаться равным 20, а pointY — 10!

Требования:
•	Класс Point должен реализовывать интерфейс Externalizable.
•	Класс Point должен содержать два целочисленных поля: pointX и pointY.
•	В методе writeExternal необходимо записывать сначала значение поля pointY, а затем pointX, используя методы out.writeInt(pointY) и out.writeInt(pointX).
•	В методе readExternal необходимо считывать сначала pointX (pointX = in.readInt()), потом pointY (pointY = in.readInt()).
•	После сериализации и последующей десериализации объекта Point значения полей pointX и pointY должны поменяться местами по сравнению с исходными.
•	Необходимо создать объект Point с конкретными значениями (например, pointX = 10, pointY = 20), сериализовать его, затем десериализовать.
•	После десериализации необходимо вывести значения pointX и pointY объекта Point на экран.

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        // Создаем исходную точку с координатами X=10, Y=20
        Point original = new Point(10, 20);

        // "Сохраняем" объект в байтовый массив (сериализация)
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(baos);
        out.writeObject(original);
        out.close();
        byte[] data = baos.toByteArray();

        // "Загружаем" объект из байтового массива (десериализация)
        ObjectInputStream in = new ObjectInputStream(new ByteArrayInputStream(data));
        Point restored = (Point) in.readObject();
        in.close();

        // Выводим значения полей после десериализации
        // Из-за намеренно нарушенного порядка записи/чтения они поменяются местами: станут X=20, Y=10
        System.out.println(restored.pointX);
        System.out.println(restored.pointY);
    }
}


 */

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        // Создаем исходную точку с координатами X=10, Y=20
        Point original = new Point(10, 20);

        // "Сохраняем" объект в байтовый массив (сериализация)
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(baos);
        out.writeObject(original);
        out.close();
        byte[] data = baos.toByteArray();

        // "Загружаем" объект из байтового массива (десериализация)
        ObjectInputStream in = new ObjectInputStream(new ByteArrayInputStream(data));
        Point restored = (Point) in.readObject();
        in.close();

        // Выводим значения полей после десериализации
        // Из-за намеренно нарушенного порядка записи/чтения они поменяются местами: станут X=20, Y=10
        System.out.println(restored.pointX);
        System.out.println(restored.pointY);
    }
}

class Point implements Externalizable {
    int pointX;
    int pointY;

    public Point() {

    }

    public Point(int x, int y) {
        this.pointX = x;
        this.pointY = y;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeInt(pointY);
        out.writeInt(pointX);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        this.pointX = in.readInt();
        this.pointY = in.readInt();

    }
}

/*
public class Solution {
    public static void main(String[] args) throws Exception {
        // Создаем исходную точку с координатами X=10, Y=20
        Point original = new Point(10, 20);

        // "Сохраняем" объект в байтовый массив (сериализация)
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(baos);
        out.writeObject(original);
        out.close();
        byte[] data = baos.toByteArray();

        // "Загружаем" объект из байтового массива (десериализация)
        ObjectInputStream in = new ObjectInputStream(new ByteArrayInputStream(data));
        Point restored = (Point) in.readObject();
        in.close();

        // Выводим значения полей после десериализации
        // Из-за намеренно нарушенного порядка записи/чтения они поменяются местами: станут X=20, Y=10
        System.out.println(restored.pointX);
        System.out.println(restored.pointY);
    }
}

// Класс точки, полностью контролирующий сериализацию через Externalizable
class Point implements Externalizable {
    // Поля координат
    int pointX;
    int pointY;

    // Обязательный публичный конструктор без параметров для Externalizable
    public Point() {
    }

    public Point(int pointX, int pointY) {
        this.pointX = pointX;
        this.pointY = pointY;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        // Намеренно нарушаем "естественный" порядок: сначала пишем Y, потом X
        out.writeInt(pointY);
        out.writeInt(pointX);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        // Читаем в "правильном" порядке: сначала X, потом Y
        // Из-за несоответствия порядков записи/чтения координаты поменяются местами
        pointX = in.readInt();
        pointY = in.readInt();
    }
}
 */