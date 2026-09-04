package com.javarush.task.task28.task2808;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/* 
Осваиваем Callable
Реализуй логику метода getTask, который должен возвращать объект Callable.
Объект Callable должен вычислять сумму всех чисел от 1 до переданного числа i включая его, и возвращать его в виде строки.
Метод main не участвует в тестировании.

Требования:
•	Класс Solution должен содержать статический метод getTask(int).
•	Метод getTask должен возвращать объект Callable<String>.
•	Объект Callable должен возвращать в виде строки сумму всех чисел от 1 до переданного числа i, включая его
•	Сумма должна правильно считаться для чисел произвольной длины.
public class Solution {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        List<Future<String>> futures = new ArrayList<>();
        ExecutorService executor = Executors.newFixedThreadPool(5);
        for (int i = 1000; i <= 1010; i++) {
            futures.add(executor.submit(getTask(i)));
        }

        futures.add(executor.submit(getTask(10000000)));

        for (Future<String> future : futures) {
            System.out.println(future.get());
        }

        executor.shutdown();
        executor.awaitTermination(10, TimeUnit.SECONDS);

/// output
//500500
//501501
//502503
//503506
//504510
//505515
//506521
//507528
//508536
//509545
//510555
//50000005000000
///
    }

public static Callable<String> getTask(final int i) {
    return null;
}
}

*/

public class Solution {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        List<Future<String>> futures = new ArrayList<>();
        ExecutorService executor = Executors.newFixedThreadPool(5);
        for (int i = 1000; i <= 1010; i++) {
            futures.add(executor.submit(getTask(i)));
        }

        futures.add(executor.submit(getTask(10000000)));

        for (Future<String> future : futures) {
            System.out.println(future.get());
        }

        executor.shutdown();
        executor.awaitTermination(10, TimeUnit.SECONDS);

/* output
500500
501501
502503
503506
504510
505515
506521
507528
508536
509545
510555
50000005000000
*/
    }

    public static Callable<String> getTask(final int i) {
        return new Callable<String>() {
            @Override
            public String call() throws Exception {
                // Используем формулу для суммы арифметической прогрессии: n*(n+1)/2
                // Применяем long для избежания переполнения
                long sum = (long) i * (i + 1) / 2;
                return String.valueOf(sum);
            }
        };
    }
}

