package com.javarush.task.task21.task2109;

/* 
Запретить клонирование
public class Solution {
    public static class A implements Cloneable {
        private int i;
        private int j;

        public A(int i, int j) {
            this.i = i;
            this.j = j;
        }

        public int getI() {
            return i;
        }

        public int getJ() {
            return j;
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            return super.clone();
        }
    }

    public static class B extends A {
        private String name;

        public B(int i, int j, String name) {
            super(i, j);
            this.name = name;
        }

        public String getName() {
            return name;
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            throw new CloneNotSupportedException();
        }
    }

    public static class C extends B {
        public C(int i, int j, String name) {
            super(i, j, name);
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            return new C(getI(), getJ(), getName());
        }
    }

    public static void main(String[] args) {

    }
}
Разреши клонировать класс А
Запрети клонировать класс B
Разреши клонировать класс C
Не забудь о методах equals и hashCode!

Требования:
•	Класс A должен поддерживать интерфейс Cloneable.
•	Класс B должен быть потомком класса A.
•	При объявлении класса B не должно быть явно указано implements Cloneable.
•	Метод clone в классе B должен быть переопределен таким образом, чтобы при попытке клонирования объекта класса B возникало исключение CloneNotSupportedException.
•	Класс C должен быть потомком класса B.
•	Клонирование объектов класса C должно завершаться успешно.

Моё решение тоже правильное и сам решил без помощи ИИ
*/

import java.util.Arrays;
import java.util.Objects;

public class Solution {
    public static class A implements Cloneable {
        private int i;
        private int j;

        public A(int i, int j) {
            this.i = i;
            this.j = j;
        }

        public int getI() {
            return i;
        }

        public int getJ() {
            return j;
        }
    }

    public static class B extends A {
        private String name;

        public B(int i, int j, String name) {
            super(i, j);
            this.name = name;
        }

        public String getName() {
            return name;
        }
        @Override
        public Object clone() throws CloneNotSupportedException {
            // Некоторая дополнительная логика
            System.out.println("Предпринята незаконная попытка клонирования объекта!!!");

            // Принудительное исключение
            throw new CloneNotSupportedException("Этот объект запрещено клонировать " +
                    "по соображениям безопасности!!!");
        }

    }

    public static class C extends B implements Cloneable {
        public C(int i, int j, String name) {
            super(i, j, name);
        }

        @Override
        public Object clone() throws CloneNotSupportedException {
            return new C(getI(), getJ(), getName());
        }

        @Override
        public String toString() {
            return "Кто получился - {" +
                    "Голова='" + getI() + '\'' +
                    "Ноги='" + getJ() + '\'' +
                    "Вид животного='" + getName() + '\'' +
                    '}';
        }

    }

    public static void main(String[] args) throws CloneNotSupportedException {
        C newobjC = new C(1, 2, "Человек");
        C clonedC = (C) newobjC.clone();
        System.out.println("Новый объект С: " + newobjC);
        System.out.println("Клонированный объект С: " + clonedC);

        B newobjB = new B(1, 2, "Человек");
        B clonedB = (B) newobjB.clone();
    }
}

/*
public class Solution {
    public static class A implements Cloneable {
        private int i;
        private int j;

        public A(int i, int j) {
            this.i = i;
            this.j = j;
        }

        public int getI() {
            return i;
        }

        public int getJ() {
            return j;
        }
    }

    public static class B extends A {
        private String name;

        public B(int i, int j, String name) {
            super(i, j);
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    public static class C extends B {
        public C(int i, int j, String name) {
            super(i, j, name);
        }
    }

    public static void main(String[] args) {

    }
}
 */