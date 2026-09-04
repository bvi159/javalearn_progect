package ru.javarush.java.core.level08.task04;
/*

Усилитель сообщений для громких объявлений 📣

Вообразите, что вы создаёте специальный текстовый генератор для рекламных щитов или чат-бота, которому иногда нужно очень убедительно повторить одно и то же сообщение, чтобы привлечь внимание. Вам нужен инструмент, который возьмёт любую фразу и умножит её заданное количество раз, выводя сразу на публичное обозрение.

Сконструируйте класс MessageAmplifier, это будет ваш мастер по громким объявлениям. Внутри него создайте публичный статический метод amplifyAndDisplay.

Этот метод должен принимать два входных значения: messageText, то есть саму фразу, и numberOfRepeats — сколько раз её нужно повторить. После этого amplifyAndDisplay должен мгновенно склеить фразу столько раз, сколько указано, и вывести получившуюся длинную, мощную строку прямо на экран.

Для демонстрации его способностей, в вашем главном стартовом блоке main, попросите MessageAmplifier усилить сообщение "Ура!" 4 раза.

Требования:
•	В программе должен быть создан публичный класс с именем MessageAmplifier.
•	В классе MessageAmplifier должен быть определён публичный статический метод amplifyAndDisplay.
•	Метод amplifyAndDisplay должен принимать два параметра: строку messageText и целое число numberOfRepeats.
•	Метод amplifyAndDisplay должен формировать новую строку, которая состоит из messageText, повторённого numberOfRepeats раз подряд.
•	Метод amplifyAndDisplay должен выводить получившуюся строку на экран.
•	В методе main основной программы должен быть вызван метод MessageAmplifier.amplifyAndDisplay с аргументами "Ура!" и 4.

public class MessageAmplifier {

    // Публичный статический метод, который повторяет строку и выводит результат
    public static void amplifyAndDisplay(String messageText, int numberOfRepeats) {
        // Используем обычную строку и оператор +


        // Выводим итоговую "усиленную" строку

    }

    public static void main(String[] args) {
        // Демонстрация работы: усиливаем сообщение "Ура!" четыре раза
        amplifyAndDisplay("Ура!", 4);
    }
}


 */
public class MessageAmplifier {

    // Публичный статический метод, который повторяет строку и выводит результат
    public static void amplifyAndDisplay(String messageText, int numberOfRepeats) {
        // Используем обычную строку и оператор +


        // Выводим итоговую "усиленную" строку
        System.out.println(messageText.repeat(numberOfRepeats));

    }

    public static void main(String[] args) {
        // Демонстрация работы: усиливаем сообщение "Ура!" четыре раза
        amplifyAndDisplay("Ура!", 4);
    }
}

/*
Ихнее решение

public class MessageAmplifier {

    // Публичный статический метод, который повторяет строку и выводит результат
    public static void amplifyAndDisplay(String messageText, int numberOfRepeats) {
        // Используем обычную строку и оператор +
        String result = "";
        for (int i = 0; i < numberOfRepeats; i++) {
            result += messageText;
        }

        // Выводим итоговую "усиленную" строку
        System.out.println(result);
    }

    public static void main(String[] args) {
        // Демонстрация работы: усиливаем сообщение "Ура!" четыре раза
        amplifyAndDisplay("Ура!", 4);
    }
}
 */