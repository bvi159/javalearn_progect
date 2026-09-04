package ru.javarush.java.core.level24.task07;
/*
Возрастной контроль в парке аттракционов: Гибкие сообщения об ошибках
Представьте, что вы создаёте систему проверки возраста для виртуального парка аттракционов. Иногда вам нужно просто сказать "Не подходит по возрасту", а иногда — дать более конкретное объяснение, например, "Вам должно быть не менее 16 лет для этого аттракциона". Ваша система должна быть гибкой в своих "отказах".
Ваша задача — спроектировать собственное исключение, которое назовите InvalidAgeException, и пусть оно будет наследником класса Exception. Внутри этого исключения реализуйте два способа "кричать" об ошибке: один конструктор пусть будет "безмолвным" (без параметров), позволяя просто сказать "проблема с возрастом", а второй конструктор пусть принимает на вход строку сообщения, позволяя вам дать конкретное объяснение, например, "Вам нет 18 лет". Этот строковый параметр, конечно же, должен быть передан в конструктор родительского класса Exception.
В главной части вашей программы продемонстрируйте, как вы можете "выбросить" это исключение, используя второй конструктор, и снабдите его осмысленным сообщением, чтобы показать, что ваша система возрастного контроля способна на большее, чем просто общие фразы.
Требования:
•	Необходимо создать новый класс исключения с именем InvalidAgeException, который должен наследоваться от класса Exception.
•	Класс InvalidAgeException должен содержать два конструктора: один без параметров и один с параметром типа String.
•	Конструктор InvalidAgeException, принимающий строку, должен передавать эту строку в конструктор класса Exception.
•	В основной части программы должно быть показано, как выбросить исключение InvalidAgeException с помощью конструктора, принимающего строку.
•	При выбрасывании исключения через конструктор с параметром, необходимо передать в него осмысленное сообщение, объясняющее причину отказа.

public class Solution {
    public static void main(String[] args) {
        int userAge = 14;
        int requiredAge = 16;

        try {
            // Пытаемся пройти возрастной контроль
            checkRideAge(userAge, requiredAge);
            System.out.println("Добро пожаловать на аттракцион!");
        } catch (... e) {
            // Показываем осмысленное сообщение из нашего исключения
            System.out.println("Отказ: " + e.getMessage());
        }
    }

    // Метод, который проверяет возраст и может "выбросить" наше исключение
    static void checkRideAge(int age, int minAge) throws ... {
        if (age < minAge) {
            // Демонстрация выбрасывания исключения с осмысленным сообщением
            throw new ...(
                "Вам должно быть не менее " + minAge + " лет для этого аттракциона (сейчас " + age + ")."
            );
        }
    }
}
 */


public class Solution {
    public static void main(String[] args) {
        int userAge = 38;
        int requiredAge = 16;

        try {
            // Пытаемся пройти возрастной контроль
            checkRideAge(userAge, requiredAge);
            System.out.println("Добро пожаловать на аттракцион!");
        } catch (InvalidAgeException e) {
            // Показываем осмысленное сообщение из нашего исключения
            System.out.println("Отказ: " + e.getMessage());
        }
    }

    // Метод, который проверяет возраст и может "выбросить" наше исключение
    static void checkRideAge(int age, int minAge) throws InvalidAgeException {
        if (age < minAge) {
            // Демонстрация выбрасывания исключения с осмысленным сообщением
            throw new InvalidAgeException(
                "Вам должно быть не менее " + minAge + " лет для этого аттракциона (сейчас " + age + ")."
            );
        }
        if (age > 36) {
            throw new InvalidAgeException();
        }
    }
}

class InvalidAgeException extends Exception {
    InvalidAgeException() {
        System.out.println("проблема с возрастом");;
    }

    InvalidAgeException(String messaga) {
        super(messaga);
    }
}

/*
public class Solution {
    public static void main(String[] args) {
        int userAge = 14;
        int requiredAge = 16;

        try {
            // Пытаемся пройти возрастной контроль
            checkRideAge(userAge, requiredAge);
            System.out.println("Добро пожаловать на аттракцион!");
        } catch (InvalidAgeException e) {
            // Показываем осмысленное сообщение из нашего исключения
            System.out.println("Отказ: " + e.getMessage());
        }
    }

    // Метод, который проверяет возраст и может "выбросить" наше исключение
    static void checkRideAge(int age, int minAge) throws InvalidAgeException {
        if (age < minAge) {
            // Демонстрация выбрасывания исключения с осмысленным сообщением
            throw new InvalidAgeException(
                "Вам должно быть не менее " + minAge + " лет для этого аттракциона (сейчас " + age + ")."
            );
        }
    }
}

// Собственное исключение, наследуется от Exception
class InvalidAgeException extends Exception {

    // "Безмолвный" конструктор без параметров
    public InvalidAgeException() {
        // Ничего не передаем родителю — общее сообщение может быть задано позже
    }

    // Конструктор с сообщением: передаем строку в конструктор родительского класса Exception
    public InvalidAgeException(String message) {
        super(message); // Важно: сообщение поднимается в Exception
    }
}
 */