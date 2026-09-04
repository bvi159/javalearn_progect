package com.javarush.task.task24.task2403;

import java.io.Serializable;
import java.rmi.Remote;
import java.util.ArrayDeque;
import java.util.EventListener;

/* 
Так-с... сопоставим
Исправь ошибки: перемести методы clone в те классы, в которых они должны быть реализованы.
Лишние методы удали.
Не удаляй метод main.

Требования:
•	В классе C должен быть реализован метод clone без параметров.
•	В классе Solution должен существовать метод main.
•	В классе Solution должны существовать 4 вложенных класса.
•	В классе Solution должен существовать 1 метод.
•	Метод clone в классе C должен возвращать объект типа C.

public class Solution {
    public static class A implements Serializable {
    }

    public static class B implements Remote {
    }

    public static class C extends ArrayDeque {
        public C clone() {
            return (C) super.clone();
        }
    }

    public static class D implements EventListener {
    }

    public static void main(String[] args) {

    }
}



*/

public class Solution {
    public static class A implements Serializable, Cloneable {
        @Override
        protected A clone() throws CloneNotSupportedException {
            return (A) super.clone();
        }
    }

    public static class B implements Remote, Cloneable {
        @Override
        protected final B clone() throws CloneNotSupportedException {
            return (B) super.clone();
        }
    }

    public static class C extends ArrayDeque implements Cloneable {
        public C clone() {
            return (C) super.clone();
        }
    }

    public static class D implements EventListener, Cloneable {
        protected D clone() throws CloneNotSupportedException {
            return (D) super.clone();
        }
    }



    public static void main(String[] args) {
        // Тестирование клонирования
        try {
            A a = new A();
            A aClone = a.clone();
            System.out.println("A Успешно клонирован!");

            B b = new B();
            B bClone = b.clone();
            System.out.println("В Успешно клонирован!");

            C c = new C();
            C cClone = c.clone();
            System.out.println("С Успешно клонирован!");

            D d = new D();
            D dClone = d.clone();
            System.out.println("D Успешно клонирован!");

        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}
/*
public class Solution {
    public static class A implements Serializable {
    }

    public static class B implements Remote {
    }

    public static class C extends ArrayDeque {
    }

    public static class D implements EventListener {
    }

    protected A clone() throws CloneNotSupportedException {
        return (A) super.clone();
    }

    protected Thread clone() throws CloneNotSupportedException {
        return (Thread) super.clone();
    }

    protected final B clone() throws CloneNotSupportedException {
        return (B) super.clone();
    }

    protected ArrayDeque clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public C clone() {
        return (C) super.clone();
    }

    protected D clone() throws CloneNotSupportedException {
        return (D) super.clone();
    }

    public static void main(String[] args) {

    }
}
 */
