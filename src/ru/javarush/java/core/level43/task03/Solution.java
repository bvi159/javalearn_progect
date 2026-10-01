package ru.javarush.java.core.level43.task03;

/*
Метка Времени для Персональных Данных: Версионирование Сущности
Представьте, что вы цифровой архивариус, ответственный за долгосрочное хранение личных данных в вашей системе. Для того чтобы ваши записи о людях Person были совместимы с будущими версиями программного обеспечения, вам критически важно присвоить каждой записи уникальный идентификатор версии.

Создайте класс Person, который, конечно же, должен быть Serializable.

Внутри этого класса Person добавьте специальную, неизменяемую метку времени: private static final long serialVersionUID = 100L;. Это как штамп, который говорит: "Эта запись соответствует версии 100".

Убедитесь, что ваш класс компилируется без единой ошибки. Затем, в главном методе вашей программы, создайте экземпляр Person с любыми значениями, которые придут вам в голову, и просто выведите его на экран с помощью System.out.println, чтобы продемонстрировать, что класс готов к работе и содержит необходимый идентификатор версии.

Требования:
•	Класс Person должен быть объявлен как public и находиться в отдельном файле или внутри основного класса, если позволяет синтаксис.
•	Класс Person должен реализовывать интерфейс Serializable для поддержки сериализации.
•	В классе Person должно быть объявлено приватное статическое финальное поле serialVersionUID типа long со значением 100L.
•	Поле serialVersionUID должно быть объявлено именно так: private static final long serialVersionUID = 100L;.
•	В методе main программы должен быть создан хотя бы один объект класса Person с любыми корректными значениями полей.
•	Объект класса Person должен быть выведен на экран с помощью System.out.println.
•	Код должен компилироваться без ошибок.

public class Solution {
    public static void main(String[] args) {
        // Создаем объект Person с любыми данными
        Person person = new Person("Алиса", 30);

        // Выводим объект на экран — вызовется метод toString()
        System.out.println(person);
    }
}

 */
public class Solution {
    public static void main(String[] args) {
        // Создаем объект Person с любыми данными
        Person person = new Person("Алиса", 30);

        // Выводим объект на экран — вызовется метод toString()
        System.out.println(person);
    }
}

/*
//Простейшая сущность Person, поддерживающая сериализацию.
public class Person implements Serializable {
    // Фиксированная метка версии сериализуемого класса.
    // Требование задачи: объявить ровно так и со значением 100L.
    private static final long serialVersionUID = 100L;

    private final String name;
    private final int age;

    // Простой конструктор для инициализации полей
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Переопределяем toString, чтобы вывод через System.out.println был информативным
    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + "}";
    }
}
 */