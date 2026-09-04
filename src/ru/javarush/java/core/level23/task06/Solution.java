package ru.javarush.java.core.level23.task06;

/*
Собачий оркестр: Расширение звуков, а не замена

Вы разрабатываете симулятор звуков животных. Для начала создайте базовый класс Animal с публичным методом makeSound(), который просто выводит "Some sound". Это будет общий звук для всех животных.
Затем, создайте класс Dog, который наследуется от Animal, потому что собака, конечно, является животным.
Теперь, вместо того чтобы просто переопределить звук, как вы могли бы ожидать, для Dog создайте еще один метод makeSound, но на этот раз добавьте к нему параметр типа String, например, public void makeSound(String intensity). В этом новом методе пусть собака "гавкает" с указанной интенсивностью, например, "Bark! " + intensity.
В основном блоке программы, в main, создайте объект типа Dog и вызовите у него оба метода: сначала makeSound() без параметров, а затем makeSound("громко").
Вы увидите, что программа выведет сначала "Some sound" (потому что был вызван оригинальный метод родителя), а затем "Bark! громко". Это прекрасно демонстрирует, что вы не переопределили родительский метод, а просто "добавили" новую версию метода с другим набором параметров, то есть перегрузили его.

Требования:
•	В программе должен быть объявлен класс Animal.

public class Solution {
    public static void main(String[] args) {
        // Создаем объект собаки
        Dog dog = new Dog();

        // Вызываем унаследованный метод без параметров (не переопределен в Dog)
        dog.makeSound(); // Выведет: Some sound

        // Вызываем перегруженную версию метода с параметром
        dog.makeSound("громко"); // Выведет: Bark! громко
    }
}

 */
public class Solution {
    public static void main(String[] args) {
        // Создаем объект собаки
        Dog dog = new Dog();

        // Вызываем унаследованный метод без параметров (не переопределен в Dog)
        dog.makeSound(); // Выведет: Some sound

        // Вызываем перегруженную версию метода с параметром
        dog.makeSound("громко"); // Выведет: Bark! громко
    }
}

class Animal {
    public void makeSound() {
        System.out.println("Some sound");
    }
}

class Dog extends Animal {
    public void makeSound(String intensily) {
        System.out.println("Bark! " + intensily);
    }
}

/*
public class Solution {
    public static void main(String[] args) {
        // Создаем объект собаки
        Dog dog = new Dog();

        // Вызываем унаследованный метод без параметров (не переопределен в Dog)
        dog.makeSound(); // Выведет: Some sound

        // Вызываем перегруженную версию метода с параметром
        dog.makeSound("громко"); // Выведет: Bark! громко
    }
}

// Базовый класс животного
class Animal {
    // Базовый звук для всех животных
    public void makeSound() {
        System.out.println("Some sound");
    }
}

// Собака наследуется от Animal
class Dog extends Animal {
    // Это не переопределение, так как сигнатура отличается (есть параметр)
    public void makeSound(String intensity) {
        System.out.println("Bark! " + intensity);
    }
}
 */