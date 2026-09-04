package com.javarush.task.task25.task2504;

/* 
Switch для нитей
Java в порограмме:
public class Solution {
    public static void processThreads(Thread... threads) {
        //implement this method - реализуйте этот метод
    }

    public static void main(String[] args) {

    }
}

Обработай список нитей в зависимости от состояния:
1. Если нить еще не запущена, то запусти ее.
2. Если нить в ожидании, то прерви ее.
3. Если нить работает, то проверь маркер isInterrupted.
4. Если нить прекратила работу, то выведи в консоль ее приоритет.
Используй switch.

Требования:
•	Метод processThreads принимает аргументом массив нитей.
•	Если переданная нить не запущена, нужно ее запустить.
•	Если переданная нить находится в ожидании, нужно ее прервать.
•	Если переданная нить работает, то нужно проверить маркер isInterrupted.
•	Если переданная нить завершила работу, нужно вывести в консоль ее приоритет.
•	Метод processThreads должен использовать оператор switch.

*/


public class Solution {
    public static void processThreads(Thread... threads) {
        //implement this method - реализуйте этот метод
        Thread.State tekState;
        for (Thread mythread : threads) {
            tekState = mythread.getState();
            switch (tekState) {
                case NEW:
                    mythread.start();
                    break;
//                Благодаря тому, что в Java можно объединять несколько case-меток для одного блока кода,
//                все три состояния ожидания (WAITING, TIMED_WAITING, BLOCKED) обрабатываются одинаково - вызовом interrupt().
                case WAITING:
                case TIMED_WAITING:
                case BLOCKED:
                    // Если нить в ожидании, то прерви ее
                    mythread.interrupt();
                    break;
                case RUNNABLE:
                    // Если нить работает, то проверь маркер isInterrupted
                    boolean isInterrupted = mythread.isInterrupted();
                    // Дополнительная логика может быть добавлена здесь
                    // в зависимости от значения isInterrupted
                    break;
                case TERMINATED:
                    System.out.println(mythread.getPriority());
                    break;
//                default:
//                    System.out.println(mythread.getState());
            }
        }
    }

    public static void main(String[] args) {
        // Пример использования
        Thread thread1 = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted");
            }
        });

        Thread thread2 = new Thread(() -> {
            // Просто выполняем какую-то работу
            for (int i = 0; i < 1000000; i++) {
                Math.sqrt(i);
            }
        });

        Thread thread3 = new Thread(() -> {
            // Уже завершенная нить
        });
        thread3.start();
        try {
            thread3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        processThreads(thread1, thread2, thread3);
    }


}
        /*
         public static void main(String[] args) {
        // Создаем потоки с анонимными классами вместо лямбд
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Поток 1 выполняется");
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Поток 2 выполняется");
            }
        });

        // Запускаем и обрабатываем
        processThreads(thread1, thread2);
    }
         */

/*
public enum State
{
NEW,
RUNNABLE,
BLOCKED,
WAITING,
TIMED_WAITING,
TERMINATED;
}
 */