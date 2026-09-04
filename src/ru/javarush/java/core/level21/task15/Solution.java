package ru.javarush.java.core.level21.task15;
/*
Математический помощник для инженера 📐
Вы помогаете инженеру, которому часто нужны быстрые вычисления квадратов и кубов чисел. При этом, функция вычисления квадрата может быть частью конкретного инструмента, а функция вычисления куба — общей полезной утилитой, доступной всегда.

Создайте интерфейс MathHelper. В нём определите default-метод void printSquare(int n), который выводит квадрат переданного числа n. Также в этом интерфейсе создайте static-метод void printCube(int n), который выводит куб числа n.

Затем создайте класс NumberPrinter, который реализует MathHelper. В основной программе создайте объект NumberPrinter и через него вызовите printSquare (демонстрируя его как метод экземпляра). Затем вызовите printCube напрямую через имя интерфейса, показывая его как статическую утилиту.

Требования:
•	Необходимо создать интерфейс с именем MathHelper.
•	В интерфейсе MathHelper должен быть определён default-метод void printSquare(int n), который выводит квадрат переданного числа n.
•	В интерфейсе MathHelper должен быть определён static-метод void printCube(int n), который выводит куб переданного числа n.
•	Необходимо создать класс NumberPrinter, который реализует интерфейс MathHelper.
•	В основной программе должен быть создан объект класса NumberPrinter, через который вызывается метод printSquare.
•	В основной программе статический метод printCube должен вызываться напрямую через имя интерфейса MathHelper.

public class Solution {
    public static void main(String[] args) {
        // Создаем объект и вызываем default-метод как метод экземпляра
        NumberPrinter printer = new NumberPrinter();
        printer.printSquare(5); // вывод: 25

        // Вызываем static-метод интерфейса напрямую через имя интерфейса
        MathHelper.printCube(3); // вывод: 27
    }
}

 */
public class Solution {
    public static void main(String[] args) {
        // Создаем объект и вызываем default-метод как метод экземпляра
        NumberPrinter printer = new NumberPrinter();
        printer.printSquare(5); // вывод: 25

        // Вызываем static-метод интерфейса напрямую через имя интерфейса
        MathHelper.printCube(3); // вывод: 27
    }
}

interface MathHelper {
    default void printSquare(int n) {
        System.out.println(n*n);
    }

    static void printCube(int n) {
        System.out.println(n*n*n);
    }
}

class NumberPrinter implements MathHelper {

}

/*
// Интерфейс MathHelper с default- и static-методами
interface MathHelper {
    // default-метод: доступен через объект, реализующий интерфейс
    default void printSquare(int n) {
        System.out.println(n * n);
    }

    // static-метод: утилита интерфейса, вызывается через имя интерфейса
    static void printCube(int n) {
        System.out.println(n * n * n);
    }
}

// Класс, реализующий интерфейс MathHelper.
class NumberPrinter implements MathHelper { }

 */