package ru.javarush.java.core.level14.task17;
/*
Наблюдение за появлением виртуальных существ

Вы — биолог в виртуальном зоопарке и хотите понять, как ведут себя ваши цифровые существа, если вы не даёте им никаких конкретных указаний при рождении. Ваша задача — создать шаблон для животного, назвав его Animal, с полями для возраста (int animalAge) и имени (String animalName).

Важно: не присваивайте этим полям никаких значений напрямую в шаблоне.

Затем, в вашем главном сценарии (main методе), "родите" одного такого зверя, назвав его wildAnimal, и посмотрите, какие "характеристики" (значения по умолчанию) он получит от системы, выведя их на экран. Вы должны увидеть стандартные значения для целочисленных и строковых типов.

Требования:
•	Класс Animal должен быть объявлен с двумя полями: int animalAge и String animalName, и этим полям не должны быть присвоены значения напрямую (без инициализации в объявлении и конструкторе).
•	В методе main должен быть создан объект типа Animal с именем wildAnimal с помощью ключевого слова new.
•	В методе main значения полей animalAge и animalName объекта wildAnimal должны быть выведены на экран.
•	Выводимые значения должны соответствовать значениям по умолчанию для int (0) и String (null) в Java.

public class Solution {
    public static void main(String[] args) {
        // "Рождаем" животное без явной инициализации полей
        Animal wildAnimal = new Animal();

        // Выводим значения полей: для int по умолчанию 0, для String — null
        System.out.println(wildAnimal.animalAge);
        System.out.println(wildAnimal.animalName);
    }
}

// Простой шаблон животного: поля не инициализируются вручную


 */
public class Solution {
    public static void main(String[] args) {
        // "Рождаем" животное без явной инициализации полей
        Animal wildAnimal = new Animal();

        // Выводим значения полей: для int по умолчанию 0, для String — null
        System.out.println(wildAnimal.animalAge);
        System.out.println(wildAnimal.animalName);
    }
}

// Простой шаблон животного: поля не инициализируются вручную
class Animal {
    int animalAge;
    String animalName;
}