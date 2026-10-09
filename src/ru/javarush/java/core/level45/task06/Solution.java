package ru.javarush.java.core.level45.task06;
/*
Генеалогическое древо: автоматическая миграция возраста
Представьте, что вы историк-генеалог, ведущий базу данных людей, и ваша программа хранит информацию о них. Изначально, в "первой версии" вашей программы, для каждого человека вы записывали год рождения в виде текстовой строки, используя класс Person с полем birthYearString типа String. Этот класс, конечно же, был Serializable, и имел serialVersionUID со значением 1L, чтобы вы могли сохранять и загружать свои данные.

Однако со временем вы обнаружили, что хранить год рождения строкой не очень удобно, а для анализа гораздо полезнее сразу иметь возраст человека. Поэтому во "второй версии" вашей программы вы приняли смелое решение: полностью удалить старое поле birthYearString из класса Person и вместо него добавить новое поле calculatedAge типа int. При этом, чтобы не нарушать совместимость со старыми файлами данных, вы предусмотрительно оставили serialVersionUID без изменений, всё те же 1L.

Теперь перед вами стоит сложная, но интересная задача: реализовать кастомную логику десериализации. Вам необходимо переопределить метод readObject в классе Person таким образом, чтобы при загрузке старых объектов (тех, что были сохранены до того, как вы изменили структуру класса), ваша программа могла "прочитать" устаревшее поле birthYearString и на его основе вычислить и присвоить значение новому полю calculatedAge. Например, вы можете определить возраст как 2024 - Integer.parseInt(birthYearString).

Конечная цель: ваша программа должна безупречно загружать как объекты, сериализованные старой версией класса Person, так и новой. При десериализации старых данных, поле calculatedAge должно корректно отображать возраст, вычисленный из birthYearString, обеспечивая плавный и автоматический переход к новой структуре данных. Это демонстрация того, как можно управлять миграцией данных при изменении схемы сериализации.

Требования:
•	Поле serialVersionUID класса Person должно иметь значение 1L и не изменяться между версиями класса.
•	В новой версии класса Person поле birthYearString типа String должно быть полностью удалено, а вместо него добавлено поле calculatedAge типа int.
•	В классе Person должен быть реализован приватный метод readObject(ObjectInputStream in), который корректно обрабатывает оба варианта сериализованных данных (старый и новый).
•	При десериализации объекта, сериализованного старой версией класса, метод readObject должен вручную извлекать значение поля birthYearString из потока.
•	Если при десериализации обнаружено поле birthYearString, метод readObject должен вычислять значение calculatedAge по формуле: 2024 - Integer.parseInt(birthYearString).
•	Если при десериализации объекта поле calculatedAge присутствует (файл сериализован новой версией), оно должно быть корректно восстановлено без дополнительных вычислений.
•	Десериализация должна работать как для объектов, сериализованных старой версией класса (с birthYearString), так и для объектов, сериализованных новой версией (с calculatedAge).
•	Класс Person должен реализовывать интерфейс Serializable, а все нестатические и неtransient поля, требующие сериализации, должны корректно сериализоваться и десериализоваться.
•	В случае невозможности преобразования birthYearString в целое число (например, некорректный формат), метод readObject должен корректно обрабатывать ошибку (например, выбрасывать исключение или устанавливать calculatedAge в значение по умолчанию).

public class Solution {
    public static void main(String[] args) throws Exception {
        // Небольшая демонстрация: создадим объект новой версии, сериализуем и десериализуем его.
        Person modern = new Person(33);

        byte[] data;
        try (ByteArrayOutputStream bos = new ByteArrayOutputStream();
             ObjectOutputStream oos = new ObjectOutputStream(bos)) {
            oos.writeObject(modern);
            data = bos.toByteArray();
        }

        try (ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(data))) {
            Person restored = (Person) ois.readObject();
            System.out.println("Возраст (новый формат): " + restored.getCalculatedAge());
        }

        // Примечание:
        // Для реальной проверки backward-совместимости нужен файл,
        // сериализованный старой версией класса Person (с полем birthYearString).
        // Код ниже умеет корректно прочитать такой файл и вычислить возраст.
        // Добавлять бинарные тестовые файлы по условию не требуется.
    }
}

 */

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        // Небольшая демонстрация: создадим объект новой версии, сериализуем и десериализуем его.
        Person modern = new Person(33);

        byte[] data;
        try (ByteArrayOutputStream bos = new ByteArrayOutputStream();
             ObjectOutputStream oos = new ObjectOutputStream(bos)) {
            oos.writeObject(modern);
            data = bos.toByteArray();
        }

        try (ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(data))) {
            Person restored = (Person) ois.readObject();
            System.out.println("Возраст (новый формат): " + restored.getCalculatedAge());
        }

        // Примечание:
        // Для реальной проверки backward-совместимости нужен файл,
        // сериализованный старой версией класса Person (с полем birthYearString).
        // Код ниже умеет корректно прочитать такой файл и вычислить возраст.
        // Добавлять бинарные тестовые файлы по условию не требуется.
    }
}

class Person implements Serializable {
    private final static long serialVersionUID = 1L;
    //    transient  private String birthYearString;
    private int calculatedAge;

    public Person() {
    }

    public Person(int age) {
        this.calculatedAge = age;
    }

    public int getCalculatedAge() {
        return calculatedAge;
    }

    private void readObject(ObjectInputStream in)
            throws IOException, ClassNotFoundException {
        ObjectInputStream.GetField fields = in.readFields();

        calculatedAge = fields.get("calculatedAge", 0);
        // Поддержка старого формата, где было строковое поле
        Object old = fields.get("birthYearString", (Object) null);
        if (old != null) {
            calculatedAge = 2024 - Integer.parseInt(old.toString());
        }
    }

}

/*
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        // Небольшая демонстрация: создадим объект новой версии, сериализуем и десериализуем его.
        Person modern = new Person(33);

        byte[] data;
        try (ByteArrayOutputStream bos = new ByteArrayOutputStream();
             ObjectOutputStream oos = new ObjectOutputStream(bos)) {
            oos.writeObject(modern);
            data = bos.toByteArray();
        }

        try (ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(data))) {
            Person restored = (Person) ois.readObject();
            System.out.println("Возраст (новый формат): " + restored.getCalculatedAge());
        }

        // Примечание:
        // Для реальной проверки backward-совместимости нужен файл,
        // сериализованный старой версией класса Person (с полем birthYearString).
        // Код ниже умеет корректно прочитать такой файл и вычислить возраст.
        // Добавлять бинарные тестовые файлы по условию не требуется.
    }
}

/ **
 * Новая версия класса Person:
 * - старое поле birthYearString (String) полностью удалено из кода
 * - добавлено поле calculatedAge (int)
 * - serialVersionUID неизменен (1L)
 *
 * Ключевая часть — custom readObject с использованием serialPersistentFields.
 * Мы объявляем в serialPersistentFields и новое, и устаревшее название поля,
 * чтобы уметь прочитать оба варианта потоков:
 * - если в потоке есть calculatedAge — просто читаем его;
 * - если его нет, но есть birthYearString — вычисляем возраст: 2024 - Integer.parseInt(birthYearString).
 * /
class Person implements Serializable {
    private static final long serialVersionUID = 1L;

    // Новое поле вместо старого birthYearString
    private int calculatedAge;

    // serialPersistentFields задаёт "логическую" схему сериализации.
    // Здесь мы перечисляем и новое поле, и устаревшее имя поля, чтобы уметь читать старые данные.
    private static final ObjectStreamField[] serialPersistentFields = {
            new ObjectStreamField("calculatedAge", int.class),
            new ObjectStreamField("birthYearString", String.class) // поля в классе больше нет, но схему для чтения старых данных сохраняем
    };

    public Person(int calculatedAge) {
        this.calculatedAge = calculatedAge;
    }

    public int getCalculatedAge() {
        return calculatedAge;
    }

    @Override
    public String toString() {
        return "Person{calculatedAge=" + calculatedAge + "}";
    }

    / **
     * Кастомная запись.
     * Пишем только новое поле calculatedAge; устаревшее имя поля "birthYearString" не заполняем (уйдёт как null).
     * Такой подход не мешает чтению ни новой, ни старой формы.
     * /
    private void writeObject(ObjectOutputStream out) throws IOException {
        ObjectOutputStream.PutField f = out.putFields();
        f.put("calculatedAge", calculatedAge);
        // birthYearString намеренно не задаём — в поток уйдёт как null (дефолт),
        // что не мешает десериализации новой версии.
        out.writeFields();
    }

    / **
     * Кастомное чтение.
     * Умеет читать:
     * - новый формат: поле calculatedAge присутствует;
     * - старый формат: поля calculatedAge нет, но есть birthYearString — по нему вычисляем возраст.
     *
     * В случае ошибки парсинга birthYearString — ставим значение по умолчанию (0).
     * /
    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        ObjectInputStream.GetField f = in.readFields();

        // Если поле calculatedAge пришло из потока — используем его
        boolean ageDefaulted = f.defaulted("calculatedAge"); // true, если поля calculatedAge в потоке НЕ было
        if (!ageDefaulted) {
            calculatedAge = f.get("calculatedAge", 0);
            return;
        }

        // Иначе пытаемся прочитать устаревшее поле birthYearString и вычислить возраст
        String birthYearString = (String) f.get("birthYearString", null);
        if (birthYearString != null) {
            try {
                int birthYear = Integer.parseInt(birthYearString.trim());
                int age = 2024 - birthYear; // простая формула из условия
                calculatedAge = Math.max(0, age); // чуть-чуть подстрахуемся на случай неверных данных
            } catch (NumberFormatException ex) {
                // Некорректный формат старого поля — устанавливаем значение по умолчанию
                calculatedAge = 0;
            }
        } else {
            // Ни нового, ни старого поля в потоке — оставляем значение по умолчанию
            calculatedAge = 0;
        }
    }
}
 */