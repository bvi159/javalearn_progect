package com.javarush.task.task28.task2802;

/*
Пишем свою ThreadFactory
В классе Solution создай публичный статический класс AmigoThreadFactory, реализующий интерфейс ThreadFactory.
1. Реализация интерфейсного метода - создай и верни трэд, который должен:
1.1. не быть демоном,
1.2. иметь нормальный приоритет,
1.3. имя трэда должно иметь шаблон "GN-pool-A-thread-B",
где GN - это имя группы,
A - это номер фабрики инкрементируется в пределах класса начиная с 1, используй AtomicInteger,
B - номер треда инкрементируется в пределах конкретной фабрики начиная с 1, используй AtomicInteger.
2. Каждая фабрика должна иметь ту группу тредов (ThreadGroup), в которой она была создана.
3. Методы main и emulateThreadFactory не участвуют в тестировании.

Пример вывода:
secondGroup-pool-2-thread-1
firstGroup-pool-1-thread-1
firstGroup-pool-1-thread-3
secondGroup-pool-2-thread-3
firstGroup-pool-1-thread-2
secondGroup-pool-2-thread-2

Требования:
•	В классе Solution нужно создать класс public static AmigoThreadFactory, который реализует интерфейс ThreadFactory.
•	Фабрика AmigoThreadFactory должна создавать трэды, которые не являются демоном.
•	Фабрика AmigoThreadFactory должна создавать трэды, которые имеют нормальный приоритет.
•	Фабрика AmigoThreadFactory должна создавать имена для трэдов по шаблону "GN-pool-A-thread-B".
•	Каждая фабрика должна производить трэды с группой (ThreadGroup), в которой она была создана.
public class Solution {

    public static void main(String[] args) {
        class EmulatorThreadFactoryTask implements Runnable {
            @Override
            public void run() {
                emulateThreadFactory();
            }
        }

        ThreadGroup group = new ThreadGroup("firstGroup");
        Thread thread = new Thread(group, new EmulatorThreadFactoryTask());

        ThreadGroup group2 = new ThreadGroup("secondGroup");
        Thread thread2 = new Thread(group2, new EmulatorThreadFactoryTask());

        thread.start();
        thread2.start();
    }

    private static void emulateThreadFactory() {
        AmigoThreadFactory factory = new AmigoThreadFactory();
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        };
        factory.newThread(r).start();
        factory.newThread(r).start();
        factory.newThread(r).start();
    }
}


*/


import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class Solution {

    public static void main(String[] args) {
        class EmulatorThreadFactoryTask implements Runnable {
            @Override
            public void run() {
                emulateThreadFactory();
            }
        }

        ThreadGroup group = new ThreadGroup("firstGroup");
        Thread thread = new Thread(group, new EmulatorThreadFactoryTask());

        ThreadGroup group2 = new ThreadGroup("secondGroup");
        Thread thread2 = new Thread(group2, new EmulatorThreadFactoryTask());

        thread.start();
        thread2.start();
    }

    private static void emulateThreadFactory() {
        AmigoThreadFactory factory = new AmigoThreadFactory();
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        };
        factory.newThread(r).start();
        factory.newThread(r).start();
        factory.newThread(r).start();
    }

//    public static class AmigoThreadFactory implements ThreadFactory{
//
//        @Override
//        public Thread newThread(@NotNull Runnable runnable) {
//            return null;
//        }
//    }
    public static class AmigoThreadFactory implements ThreadFactory {
        // Статический счетчик для всех фабрик
        private static final AtomicInteger factoryCounter = new AtomicInteger(1);

        // Счетчик для потоков в конкретной фабрике
        private final AtomicInteger threadCounter = new AtomicInteger(1);

        // Номер текущей фабрики
        private final int factoryNumber;

        // Группа потоков (берется из текущего потока при создании фабрики)
        private final ThreadGroup group;

        // Конструктор без параметров - получаем группу из текущего потока
        public AmigoThreadFactory() {
            this.factoryNumber = factoryCounter.getAndIncrement();
            this.group = Thread.currentThread().getThreadGroup();
        }

        @Override
        public Thread newThread(Runnable r) {
            // Создаем поток с правильным именем
            String threadName = String.format("%s-pool-%d-thread-%d",
                    group.getName(), factoryNumber, threadCounter.getAndIncrement());

            Thread thread = new Thread(group, r, threadName);

            // Устанавливаем нормальный приоритет
            thread.setPriority(Thread.NORM_PRIORITY);

            // Убеждаемся, что поток не является демоном
            thread.setDaemon(false);

            return thread;
        }
    }
}

