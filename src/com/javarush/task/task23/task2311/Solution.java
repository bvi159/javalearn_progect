package com.javarush.task.task23.task2311;

/* 
Повторяем threads
Сделать так, чтобы в методе someActions вызывались только методы класса Solution.

Ожидаемый вывод в методе main:
Amigo: Mmmmm, beef
Amigo: knock knock
Amigo: Zzzzzzz...1 s

Требования:
•	Вывод на экран должен соответствовать условию задачи.
•	В методе someActions должен быть вызван метод sleep класса Solution.
•	В классе Solution должно присутствовать поле name.
•	В классе Solution должно присутствовать поле food.
•	В классе Solution должно присутствовать поле sound.

private void someActions() throws InterruptedException {
                eat();
                play();
                Solution.this.sleep(1000);
            }


*/

class PhoneNumberValidator {


        class PhoneNumber {

            private String phoneNumber;

            public PhoneNumber(String phoneNumber) {
                this.phoneNumber = phoneNumber;
            }
        }



    public void validatePhoneNumber(String phoneNumber) {


        //...код валидации номера
    }
}

public class Solution {
    public final String name;
    public final String food;
    public final String sound;

    public Solution(String name, String food, String sound) {
        this.name = name;
        this.food = food;
        this.sound = sound;
    }

    public void eat() {
        System.out.println(name + ": Mmmmm, " + food);
    }

    public void play() {
        System.out.println(name + ": " + sound + " " + sound);
    }

    public void sleep(long milliseconds) {
        System.out.println(name + ": Zzzzzzz..." + (milliseconds / 1000) + " s");
        try {
            Thread.sleep(milliseconds); // Пауза в текущем потоке
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void live() throws InterruptedException {
        Thread thread = new Thread() {
            @Override
            public void run() {
                try {
                    someActions();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            private void someActions() throws InterruptedException {
                eat();
                play();
                Solution.this.sleep(1000); // 1 секунда сна
            }
        };
        thread.start();
        try {
            thread.join(); // Ждем завершения потока
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new Solution("Amigo", "beef", "knock").live();
    }
}

/*
public class Solution {
    public final String name;
    public final String food;
    public final String sound;

    public Solution(String name, String food, String sound) {
        this.name = name;
        this.food = food;
        this.sound = sound;
    }

    public void eat() {
        System.out.println(name + ": Mmmmm, " + food);
    }

    public void play() {
        System.out.println(name + ": " + sound + " " + sound);
    }

    public void sleep(long milliseconds) {
        System.out.println(name + ": Zzzzzzz..." + (milliseconds / 1000) + " s");
    }

    public void live() throws InterruptedException {
        Thread thread = new Thread() {
            public void run() {
                try {
                    someActions();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            private void someActions() throws InterruptedException {
                eat();
                play();
                sleep(1000);
            }
        };
        thread.start();
        thread.join();
    }

    public static void main(String[] args) throws InterruptedException {
        new Solution("Amigo", "beef", "knock").live();
    }
}
 */
