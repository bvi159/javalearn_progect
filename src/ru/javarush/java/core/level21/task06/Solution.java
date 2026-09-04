package ru.javarush.java.core.level21.task06;
/*
Индивидуальная система логирования 📝

Вы настраиваете пользовательскую систему логирования для своего приложения. Вместо того чтобы каждый раз вручную писать System.out.println(), вы хотите создать более абстрактный и переиспользуемый способ отправки сообщений в консоль.
Ваша задача — объявить переменную, которая будет служить "отправителем сообщений". Эта переменная должна ссылаться на метод println стандартного объекта вывода (System.out). Используйте ссылку на нестатический метод объекта для этой цели. После этого, используя вашего "отправителя", выведите на экран фразу "Hello, method reference!", имитируя отправку лог-сообщения.

Требования:
•	В программе должна быть объявлена переменная, предназначенная для отправки сообщений в консоль.
•	Эта переменная должна быть инициализирована с помощью ссылки на нестатический метод println объекта System.out.
•	В качестве типа переменной должен быть выбран подходящий функциональный интерфейс, совместимый с методом println (например, Consumer<String>).
•	Для вывода строки "Hello, method reference!" необходимо вызвать метод отправителя, а не напрямую System.out.println.
•	В коде не должно быть прямого вызова System.out.println("Hello, method reference!"); — вывод осуществляется только через переменную-отправителя.

public class Solution {
    public static void main(String[] args) {
        // Объявляем "отправителя" как Consumer<String>


        // Используем отправителя для вывода сообщения (без прямого вызова System.out.println)

    }
}

 */
import java.util.function.Consumer;
import java.util.function.Function;

public class Solution {
    public static void main(String[] args) {
        // Объявляем "отправителя" как Consumer<String>
        //Consumer<String> somebody0 = s -> System.out.println(s);
        Consumer<String> somebody = System.out::println;
//Это я придумал, чтобы не использовать подсказку
        Function<String, String> myString = sender -> {
            System.out.println(sender);
                    return sender;
        };

        // Используем отправителя для вывода сообщения (без прямого вызова System.out.println)
        somebody.accept("Hello, method reference!");

        //Это я придумал, чтобы не использовать подсказку
        myString.apply("Hello, method you!");

    }
}

/*
public class Solution {
    public static void main(String[] args) {
        // Объявляем "отправителя" как Consumer<String>
        Consumer<String> sender = System.out::println;

        // Используем отправителя для вывода сообщения (без прямого вызова System.out.println)
        sender.accept("Hello, method reference!");
    }
}
 */

/*

 */