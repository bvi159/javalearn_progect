package ru.javarush.java.core.level45.task08;
/*
Обновление профилей пользователей: интеллектуальная миграция возраста
Представьте, что вы — разработчик системы управления профилями пользователей. Изначально, в первой версии вашей системы, информация о пользователе хранилась в классе User из пакета v1. Этот класс имел поля userName типа String и userAgeInt типа int, и, конечно же, был Serializable с serialVersionUID равным 200L.

Для демонстрации, создайте объект User первой версии (например, "Alice", 30 лет) и сериализуйте его в файл с именем "userV1.dat". Это будет имитировать базу данных старой версии.

Со временем вы обнаружили, что формат хранения возраста как целого числа не всегда удобен; например, вы хотите отображать возраст как "30 лет", "неизвестно" или "младше 18". Поэтому во второй версии вашей системы вы решили обновить класс пользователя — новая версия User лежит в пакете v2. В этом новом классе поле userAgeInt было заменено на userAgeString типа String. Очень важно, что вы сохранили тот же самый serialVersionUID = 200L, чтобы система могла распознавать старые данные.

Ваша главная задача — обеспечить плавную миграцию данных. Вам нужно реализовать специальный метод readObject в классе User второй версии. Этот метод должен уметь "читать" старое поле userAgeInt (которое было целым числом) из сериализованного потока и преобразовывать его в текстовое представление для нового поля userAgeString. Например, если старое userAgeInt было 30, новое userAgeString должно стать "30".

В файле "userV1.dat" записано имя класса первой версии, поэтому обычный ObjectInputStream вернёт объект v1.User. Чтобы прочитать старые данные сразу как v2.User, создайте наследник ObjectInputStream (в шаблоне он называется VersionMappingObjectInputStream) и переопределите в нём метод resolveClass: если в потоке встретился класс первой версии — верните класс второй. Обратите внимание: такая подмена возможна только потому, что у обеих версий одинаковое имя класса User — при десериализации JDK сверяет имя класса без учёта пакета, и подменить UserV1 на UserV2 таким способом нельзя.

После реализации readObject десериализуйте объект из файла "userV1.dat" уже как User второй версии. В конце, выведите значения полей десериализованного объекта в удобном формате, например: "Имя пользователя: <userName>, Возраст: <userAgeString>". Это покажет, как можно не только адаптировать класс к изменениям, но и активно переформатировать данные во время десериализации, обеспечивая бесшовный переход между версиями.

Требования:
•	Класс User первой версии (пакет v1) должен реализовывать интерфейс Serializable и иметь serialVersionUID, равный 200L.
•	Программа должна создать объект User первой версии с конкретными значениями (например, "Alice", 30) и сериализовать его в файл "userV1.dat".
•	Класс User второй версии (пакет v2) должен реализовывать интерфейс Serializable, иметь serialVersionUID = 200L и содержать поля userName типа String и userAgeString типа String (вместо userAgeInt).
•	В классе User второй версии должен быть реализован метод readObject, который при десериализации из потока корректно извлекает старое поле userAgeInt (если оно присутствует) и преобразует его в строку, присваивая полученное значение полю userAgeString.
•	Программа должна десериализовать объект из файла "userV1.dat" как экземпляр User второй версии, используя наследник ObjectInputStream с переопределённым методом resolveClass, который подменяет класс первой версии на класс второй версии.
•	После десериализации программа должна вывести значения полей userName и userAgeString в формате: "Имя пользователя: <userName>, Возраст: <userAgeString>".

import ru.javarush.java.core.level45.task08.v2.User;

import java.io.*;

// Демонстрация миграции сериализованных данных между версиями класса User.
// Первая версия лежит в пакете v1: userName + userAgeInt (int),      serialVersionUID = 200L
// Вторая версия лежит в пакете v2: userName + userAgeString (String), serialVersionUID = 200L
public class Solution {
    public static void main(String[] args) throws Exception {
        String fileName = "userV1.dat";

        // 1) Сериализуем объект старой версии (имитация "старой базы")
        ru.javarush.java.core.level45.task08.v1.User oldUser = new ru.javarush.java.core.level45.task08.v1.User("Alice", 30);
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName))) {
            out.writeObject(oldUser);
        }

        // 2) Десериализуем файл как User второй версии (v2) с миграцией полей.
        //    Используем специальный ObjectInputStream, который подменяет класс v1.User на v2.User
        User migrated;
        try (ObjectInputStream in = new VersionMappingObjectInputStream(new FileInputStream(fileName))) {
            migrated = (User) in.readObject(); // readObject внутри v2.User выполнит миграцию возраста
        }

        // 3) Вывод результата
        System.out.println("Имя пользователя: " + migrated.userName + ", Возраст: " + migrated.userAgeString);
    }
}

 */

import ru.javarush.java.core.level45.task08.v2.User;

import java.io.*;

// Демонстрация миграции сериализованных данных между версиями класса User.
// Первая версия лежит в пакете v1: userName + userAgeInt (int),      serialVersionUID = 200L
// Вторая версия лежит в пакете v2: userName + userAgeString (String), serialVersionUID = 200L
public class Solution {
    public static void main(String[] args) throws Exception {
        String fileName = "userV1.dat";
//        ru.javarush.java.core.level45.task08.v1.User userV1 = new ru.javarush.java.core.level45.task08.v1.User("Alice", 30);
        // 1) Сериализуем объект старой версии (имитация "старой базы")
        ru.javarush.java.core.level45.task08.v1.User oldUser =
                new ru.javarush.java.core.level45.task08.v1.User("Alice", 30);
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName))) {
            out.writeObject(oldUser);
        }

        // 2) Десериализуем файл как User второй версии (v2) с миграцией полей.
        //    Используем специальный ObjectInputStream, который подменяет класс v1.User на v2.User
        ru.javarush.java.core.level45.task08.v2.User migrated;
        try (ObjectInputStream in = new VersionMappingObjectInputStream(new FileInputStream(fileName))) {
            migrated = (User) in.readObject(); // readObject внутри v2.User выполнит миграцию возраста
        }

        // 3) Вывод результата
        System.out.println("Имя пользователя: " + migrated.userName + ", Возраст: " + migrated.userAgeString);
    }
}

class VersionMappingObjectInputStream extends ObjectInputStream {
    String newAgeString = "userAgeString";

    @Override
    protected Class<?> resolveClass(ObjectStreamClass desc) throws IOException, ClassNotFoundException {
        if (desc.getName().equals("ru.javarush.java.core.level45.task08.v1.User")) {
            return User.class;
        }
        return super.resolveClass(desc);
    }

    public VersionMappingObjectInputStream(InputStream in) throws IOException {
        super(in);
    }

//    protected VersionMappingObjectInputStream() throws IOException, SecurityException {
//    }
//

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