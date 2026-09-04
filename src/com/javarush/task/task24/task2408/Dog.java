package com.javarush.task.task24.task2408;

import java.util.Date;

/*
В работе вам иногда будет нужно закастить класс к какому-нибудь другому классу, не интерфейсу :)))
Класс DogPet использует 2 класса - SuperDog и Dog, разберись с getName в классе DogPet
Так намного лучше, чем Copy+Paste!

В классе Dog реализуй логику метода toSayable, которая описана в джавадоке.

Требования:
•	В классе Dog должен быть реализован публичный метод toSayable с одним параметром типа int.
•	Метод toSayable должен возвращать объект типа Sayable.
•	Объект возвращаемый методом toSayable должен быть потомком класса SuperDog.
•	В случае, если параметр переданный в метод toSayable меньше 1, метод say должен вернуть строку с сообщением о том что собака спит (формат согласно javadoc).
•	В случае, если параметр переданный в метод toSayable больше либо равен 1, метод say должен вернуть строку с сообщением о том что собака лает и текущую дату (формат согласно javadoc).
•	Программа должна выводить данные на экран.
•	В методе getName класса DogPet должен быть вызван метод getSuperQuotes класса SuperDog.

  public Sayable toSayable(final int i) {
        class DogPet extends SuperDog implements Sayable {
            private String getName() {
                //we use logic from Dog and SuperDog - 2 classes!
                return getSuperQuotes() + Dog.this.name + getSuperQuotes();
            }

            @Override
            public String say() {
                if (i < 1)
                    return getName() + " спит.";

                StringBuilder sb = new StringBuilder(getName()).append(" лает г");
                for (int j = 0; j < i; j++)
                    sb.append("а");
                sb.append("в!");
                sb.append(" ");
                sb.append(formatter.format(new Date()));
                return sb.toString();
            }
        }
        return new DogPet();
    }

Моё вообще-то тоже работает (закоментировано) и
SuperDog немножко другой

 */
public class Dog implements Pet {
    private String name;

    public Dog(String name) {
        this.name = name;
    }

    /**
     * Если так получилось, что есть готовый класс А (тут SuperDog) с логикой, которую вы хотите использовать.
     * То возможны 3 способа:
     * 1) из класса А скопировать логику себе (это плохо, т.к. поддерживать несколько копий одного и того же кода проблематично)
     * 2) создать экземпляр класса А внутри нашего класса и использовать его, связь has-a (не всегда подходит, т.к. класс А сам по себе)
     * 3) создать внутренний класс, который наследуется от А, использовать его методы вместе с
     * методами и полями нашего класса, т.к. внутренний класс имеет доступ к своему родителю как наследник,
     * а также ко всем полям и методам включая private того класса, в который он вложен.
     * <p/>
     * Итак, разбираемся с п.3:
     * Внутри метода toSayable создайте class DogPet, который наследуется от SuperDog и реализует интерфейс Sayable
     * создайте метод private String getName(), который будет использовать логику двух классов - Dog и SuperDog.
     * Пусть этот метод возвращает имя собаки (класс Dog), которое с обеих сторон выделено getSuperQuotes (класс SuperDog)
     * Пример, " *** Барбос *** "
     * Логика метода say:
     * Если i < 1, то используя метод getName вывести на экран, что собака спит. Пример, " *** Шарик ***  спит."'
     * Иначе вывести фразу: "имя_собаки лает гааав! сегодняшняя_дата". Пример для i=3, " *** Тузик ***  лает гааав! 13-ноя-2013 Ср"
     * Для форматирования даты используйте formatter из класса SuperDog.
     * <p/>
     * <b>Пример вывода:</b>
     *  *** Барбос ***  лает гааааав! 13-ноя.-2013 ср
     *  *** Тузик ***  лает гаав! 13-ноя.-2013 ср
     *  *** Бобик ***  лает гааав! 13-ноя.-2013 ср
     * Мышь пищит.
     *  *** Шарик ***  спит.
     *
     * @param i количество букв 'а' в слове гав
     * @return экземпляр класса DogPet
     */
//    public Sayable toSayable(final int i) {
//        class DogPet extends SuperDog implements Sayable{
//            private String getName() {
//                String ourDogName = getSuperQuotes(Dog.this.name);
//                return ourDogName;
//            }
//            String formattedDate = formatter.format(new Date());
//            @Override
//            public String say() {
//                    if (i < 1) {
////                        System.out.println(getName() + " спит.");
//                        return (getName() + " спит.").toString();
//                    } else {
//                        String gaff = " лает г" + "a".repeat(i) + "в! ";

    /// /                        System.out.println(getName() + gaff + formattedDate);
    /// /                        System.out.println(Dog.this.name + " говорит " + meow);
//                        return (getName() + gaff + formattedDate).toString();
//                    }
//
//            }
//        }
//        return new DogPet();
//    }
    public Sayable toSayable(final int i) {
        class DogPet extends SuperDog implements Sayable {
            private String getName() {
                //we use logic from Dog and SuperDog - 2 classes!
                return getSuperQuotes() + Dog.this.name + getSuperQuotes();
            }

            @Override
            public String say() {
                if (i < 1)
                    return getName() + " спит.";

                StringBuilder sb = new StringBuilder(getName()).append(" лает г");
                for (int j = 0; j < i; j++) {
                    sb.append("а");
                }
                sb.append("в!");
                sb.append(" ");
                sb.append(formatter.format(new Date()));
                return sb.toString();
            }
        }
        return new DogPet();
    }

}