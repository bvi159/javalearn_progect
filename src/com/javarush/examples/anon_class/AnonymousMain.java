package com.javarush.examples.anon_class;

public class AnonymousMain {
    public static void main(String[] args) {
        Monkey monkey = new Monkey();
        // Обезьянка начинает прыгать, как ей и положено.
        monkey.jumpMonkey(true);

        // Создаём человека от обезьянки. (Создавать обезьянку для этого не обязательно, -
        // природа уже обо всём позаботилась за нас.
        Human human = new Human();
        // Начал прыгать, как и она.
        human.jumpMonkey(true);
        // Стал человеком!
        human.jumpHuman();
        // Стартуем нить человечков.
        human.startHuman();
    }
}

class Monkey {
    public void jumpMonkey(boolean isRunning) {
        if (isRunning) {
            System.out.printf("%s start jumping!%n", getClass().getSimpleName());
        } else System.out.printf("%s stop jumping.%n", getClass().getSimpleName());
    }
}

class Human extends Monkey {
    public void jumpHuman() {
        jumpMonkey(false);
        System.out.println("Started to think...");
    }

    public void startHuman() {
        thread.start();
    }

    // Анонимный класс
    Thread thread = new Thread() {
        static int countPeople = 1;

        public void sayHelloWorld() {
            System.out.printf("Hello new world! I'm human number №%d!%n", countPeople++);
        }

        @Override
        public void run() {
            while (countPeople < 4) {
                sayHelloWorld();
                thread.setName("The World, v.0.0.9 beta : ");
                System.out.print(thread.getName());
                jumpHuman();
            }
        }
    }; // Конец анонимного класса
}
