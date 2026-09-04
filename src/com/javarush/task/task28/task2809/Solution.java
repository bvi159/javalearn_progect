package com.javarush.task.task28.task2809;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Phaser;

/* 
Plants vs Zombies
1. Почитай про java.util.concurrent.Phaser.
2. Расставь методы в нужных местах:
- arriveAndDeregister() - начинает запускать методы run у тасок,
- arriveAndAwaitAdvance() - ждет, когда все трэды будут созданы.

Пример вывода см. в output.txt.
Логика:
Сначала все персонажи присоединяются к игре.
После того, как все персонажи присоединятся к игре и готовы играть, выводится фраза "Игра началась!".
После этого персонажи вступают в игру, после чего умирают.

Требования:
•	Класс Character менять не нужно.
•	Классы Plant и Zombie менять не нужно.
•	В классе Solution вызови метод phaser.arriveAndDeregister в правильном месте.
•	В классе Solution вызови метод phaser.arriveAndAwaitAdvance в правильном месте.

public class Solution {
    public static void main(String[] args) throws InterruptedException {
        List<Character> characters = new ArrayList<>();
        characters.add(new Plant());
        characters.add(new Plant());
        characters.add(new Zombie());
        characters.add(new Zombie());
        characters.add(new Zombie());
        start(characters);
    }

    private static boolean isEveryoneReady = false;

    private static void start(List<Character> characters) throws InterruptedException {
        final Phaser phaser = new Phaser(1 + characters.size());

        for (final Character character : characters) {
            final String member = character.toString();
            System.out.println(member + " присоединился к игре");
            new Thread() {
                @Override
                public void run() {
                    System.out.println(member + " готовится играть");
                    if (!isEveryoneReady) {
                        isEveryoneReady = true;
                        System.out.println("Игра началась!");
                    }
                    character.run();
                }
            }.start();
        }
    }
}



*/

public class Solution {
    public static void main(String[] args) throws InterruptedException {
        List<Character> characters = new ArrayList<>();
        characters.add(new Plant());
        characters.add(new Plant());
        characters.add(new Zombie());
        characters.add(new Zombie());
        characters.add(new Zombie());
        start(characters);
    }

    private static boolean isEveryoneReady = false;

    private static void start(List<Character> characters) throws InterruptedException {
        final Phaser phaser = new Phaser(1 + characters.size());

        for (final Character character : characters) {
            final String member = character.toString();
            System.out.println(member + " присоединился к игре");
            new Thread() {
                @Override
                public void run() {
                    System.out.println(member + " готовится играть");
                    // Ждем, пока все потоки будут созданы
                    phaser.arriveAndAwaitAdvance();

                    // Проверка "готовности" должна быть синхронизирована
                    // synchronized (Solution.class) {
                        if (!isEveryoneReady) {
                            isEveryoneReady = true;
                            System.out.println("Игра началась!");
                        }
                    //}

                    // Начинаем выполнение задачи
                    character.run();
                }
            }.start();
        }

        // Ждем, пока все потоки будут созданы, затем запускаем выполнение
        phaser.arriveAndDeregister();
    }
}
