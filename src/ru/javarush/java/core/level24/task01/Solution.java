package ru.javarush.java.core.level24.task01;
/*
Разгадываем тайны исключений: Иерархия Родителей

Представьте, что вы стали детективом по багам, и ваша задача — понять происхождение двух таинственных "проблем", которые возникли в вашей Java-программе. Одна из них связана с сетевым подключением, а другая — с внезапным исчезновением данных.
Ваше задание заключается в том, чтобы создать две переменные. Первую назовите networkProblem и пусть она будет представлять собой IOException, сигнализирующее о проблеме с вводом-выводом, например, когда сеть "отвалилась". Вторую переменную назовите missingDataError и пусть она будет представлять NullPointerException, указывающее на попытку использовать что-то, чего на самом деле нет.
Теперь, чтобы понять их происхождение, для каждой из этих "проблем" вам нужно узнать, кто их непосредственный родитель в иерархии исключений. Выведите на экран имя класса-родителя для каждой из них, используя специальные методы, которые позволяют заглянуть в родословную объекта.
Требования:
•	В программе должна быть объявлена переменная с именем networkProblem типа IOException.
•	В программе должна быть объявлена переменная с именем missingDataError типа NullPointerException.
•	Программа должна определить непосредственный родительский класс (superclass) для объекта networkProblem с помощью соответствующих методов класса Class.
•	Программа должна определить непосредственный родительский класс (superclass) для объекта missingDataError с помощью соответствующих методов класса Class.
•	Программа должна вывести на экран имя класса-родителя (superclass) для networkProblem и для missingDataError.

public class Solution {
    public static void main(String[] args) {
        // Создаем две "проблемы": сетевую (IOException) и пропажу данных (NullPointerException)


        // Для каждого исключения получаем непосредственный класс-родитель через рефлексию


        // Выводим имена родительских классов

    }
}

 */

import java.io.IOException;

public class Solution {
    public static void main(String[] args) {
        // Создаем две "проблемы": сетевую (IOException) и пропажу данных (NullPointerException)
        IOException networkProblem = new IOException("Сеть недоступна");
        NullPointerException missingDataError = new NullPointerException("Данные отсутствуют");


        // Для каждого исключения получаем непосредственный класс-родитель через рефлексию
        System.out.println(networkProblem.getMessage() + " " + networkProblem.getClass().getSuperclass().getName());

        // Выводим имена родительских классов
        System.out.println(missingDataError.getMessage() + " " + missingDataError.getClass().getSuperclass().getName());

    }
}

/*
public class Solution {
    public static void main(String[] args) {
        // Создаем две "проблемы": сетевую (IOException) и пропажу данных (NullPointerException)
        IOException networkProblem = new IOException("Сеть недоступна");
        NullPointerException missingDataError = new NullPointerException("Данные отсутствуют");

        // Для каждого исключения получаем непосредственный класс-родитель через рефлексию
        String networkParentName = networkProblem.getClass().getSuperclass().getSimpleName();
        String missingParentName = missingDataError.getClass().getSuperclass().getSimpleName();

        // Выводим имена родительских классов
        System.out.println(networkParentName);
        System.out.println(missingParentName);
    }
}
 */