package ru.javarush.java.core.level20.task14;
/*
Игровой Чекер: Высокие Баллы

Вы разрабатываете игру, где нужно быстро проверять, достиг ли игрок определённого порога в очках, чтобы разблокировать достижение "Высокий Балл". Вам нужен гибкий способ определить правило проверки.
Создайте интерфейс NumberChecker (Проверяльщик Чисел) с одним методом boolean check(int n), который будет возвращать true или false в зависимости от проверки числа. Обязательно пометьте его аннотацией @FunctionalInterface. В вашей основной программе реализуйте этот интерфейс с помощью лямбда-выражения. Ваше правило должно быть таким: check возвращает true, если переданное число больше 100, и false в противном случае.
Продемонстрируйте работу вашего NumberChecker для двух тестовых значений: 50 (чтобы увидеть false) и 150 (чтобы увидеть true), выведя результаты проверок на экран.

Требования:
•	Необходимо создать интерфейс NumberChecker с единственным абстрактным методом boolean check(int n).
•	Интерфейс NumberChecker должен быть помечен аннотацией @FunctionalInterface.
•	В основной программе интерфейс NumberChecker должен быть реализован с помощью лямбда-выражения.
•	Метод check должен возвращать true, если переданное число больше 100, и false в противном случае.
•	В программе необходимо проверить работу NumberChecker для значений 50 и 150.
•	Результаты проверки для каждого из двух значений должны быть выведены на экран.

public class Solution {
    public static void main(String[] args) {
        // Лямбда-реализация: возвращает true, если число больше 100
        NumberChecker checker = n -> n > 100;

        // Демонстрация работы на значениях 50 и 150
        System.out.println(checker.check(50));   // ожидаем false
        System.out.println(checker.check(150));  // ожидаем true
    }
}

 */

public class Solution {
    public static void main(String[] args) {
        // Лямбда-реализация: возвращает true, если число больше 100
//   NumberChecker checker = n -> n > 100;
        NumberChecker checker = myInt -> myInt > 100;
//        NumberChecker checker = new NumberChecker(){
//            @Override
//            public boolean check(int n) {
//                return n > 100;
//            }
//        };


        // Демонстрация работы на значениях 50 и 150
        System.out.println(checker.check(50));   // ожидаем false
        System.out.println(checker.check(150));  // ожидаем true
    }
}

@FunctionalInterface
interface NumberChecker {
    boolean check(int n);
}


/*

// Функциональный интерфейс с одним абстрактным методом
@FunctionalInterface
interface NumberChecker {
    boolean check(int n);
}

public class Solution {
    public static void main(String[] args) {
        // Лямбда-реализация: возвращает true, если число больше 100
        NumberChecker checker = n -> n > 100;

        // Демонстрация работы на значениях 50 и 150
        System.out.println(checker.check(50));   // ожидаем false
        System.out.println(checker.check(150));  // ожидаем true
    }
}

 */