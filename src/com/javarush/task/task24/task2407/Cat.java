package com.javarush.task.task24.task2407;

/*
В работе вам иногда будет нужно закастить класс к какому-нибудь интерфейсу (тут Sayable),
который не реализован в текущем классе
В классе Cat реализуй логику метода toSayable, которая описана в джавадоке.

Требования:
•	В классе Cat должен быть реализован публичный метод toSayable с одним параметром типа int.
•	Метод toSayable должен возвращать объект типа Sayable.
•	Если полученный параметр меньше 1, метод say() должен вернуть строку формата: "name спит.", где name - имя текущего кота.
•	Если полученный параметр больше либо равен 1, метод say() должен вернуть строку формата: "name говорит мяяяу!", где name - имя текущего кота, а количество букв "я" в слове "мяяяу" равно полученному параметру.
•	Программа должна выводить данные на экран.

public class Cat implements Pet {
    private String name;

    public Cat(String name) {
        this.name = name;
    }

public Sayable toSayable(final int i) {
    class CatPet implements Sayable {
        @Override
        public String say() {
            if (i < 1)
                return Cat.this.name + " спит.";

            StringBuilder sb = new StringBuilder(Cat.this.name).append(" говорит м");
            for (int j = 0; j < i; j++)
                sb.append("я");
            sb.append("у!");
            return sb.toString();
        }
    }
    return new CatPet();
}
}

 */
public class Cat implements Pet {
    private String name;

    public Cat(String name) {
        this.name = name;
    }

    /**
     * Это - механизм адаптирования к другому интерфейсу - Sayable
     * Внутри метода toSayable создайте class CatPet, реализующий интерфейс Sayable
     * Логика метода say:
     * Если i < 1, то вывести на экран, что кот спит. Пример, "Васька спит."
     * Иначе вывести фразу: "имя_кота говорит мяу!". Пример для i=3, "Васька говорит мяяяу!"
     * <p/>
     * <b>Пример вывода:</b>
     * Мурзик спит.
     * Васька говорит мяяу!
     * Кошка говорит мяяяяяу!
     * Мышь пищит.
     * Томас говорит мяу!
     * <p/>
     *
     * @param i количество букв 'я' в слове мяу
     * @return экземпляр класса CatPet
     */
//    public Sayable toSayable(final int i) {
//        class CatPet implements Sayable {
//            @Override
//            public String say() {
//                if (i < 1)
//                    return Cat.this.name + " спит.";
//
//                StringBuilder sb = new StringBuilder(Cat.this.name).append(" говорит м");
//                for (int j = 0; j < i; j++)
//                    sb.append("я");
//                sb.append("у!");
//                return sb.toString();
//            }
//        }
//        return new CatPet();
//    }

    public Sayable toSayable(int i) {
        class CatPet implements Sayable {
            @Override
            public String say() {
                if (i < 1) {
                    System.out.println(name + " спит.");
                } else {
                    String meow = "м" + "я".repeat(i) + "у!";
                    System.out.println(Cat.this.name + " говорит " + meow);
                }
                return "";
            }
        }
        return (Sayable) new CatPet();
    }

}

/*

 */

/*
public class Cat implements Pet {
    private String name;

    public Cat(String name) {
        this.name = name;
    }

public Sayable toSayable(final int i) {
    return null;
}
}
 */