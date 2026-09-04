package ru.javarush.java.core.level17.task07;
/*
Иерархия приветствий: Кто кого приветствует? 🤝

Представьте, что вы строите систему, где члены семьи по-разному приветствуют друг друга в зависимости от их роли. Начните с класса Parent, который имеет публичный метод public void greet(), выводящий "Hello from Parent". Это стандартное приветствие от родителя.
Затем создайте класс Child, который наследует от Parent. Ребёнок, конечно, перенимает некоторые манеры, но может иметь и свой собственный способ приветствия! Переопределите метод greet() в классе Child, также с модификатором доступа public, чтобы он выводил "Hello from Child".
В вашем основном методе main создайте переменную типа Parent, но присвойте ей экземпляр класса Child (то есть, Parent person = new Child();). Затем вызовите метод greet() через эту переменную person. Подумайте, какой вывод вы ожидаете увидеть. Ваша программа должна показать: "Hello from Child", демонстрируя, что более специфичное поведение потомка преобладает.

Требования:
•	Должен быть создан класс Parent, содержащий публичный метод void greet(), который выводит строку "Hello from Parent".
•	Должен быть создан класс Child, который наследует класс Parent с помощью ключевого слова extends.
•	В классе Child должен быть переопределён (override) публичный метод greet(), который выводит строку "Hello from Child".
•	В классе Child перед переопределяемым методом greet() должна быть использована аннотация @Override.
•	В методе main должна быть создана переменная типа Parent, которой присваивается объект класса Child (Parent person = new Child();).
•	В методе main должен быть вызван метод greet() через переменную person, и программа должна вывести "Hello from Child".
•	Программа должна продемонстрировать, что при вызове переопределённого метода greet() через переменную типа родительского класса вызывается реализация из класса Child.

public class Solution {
    public static void main(String[] args) {
        // Полиморфизм: переменная типа Parent ссылается на объект типа Child
        Parent person = new Child();

        // Динамический полиморфизм: вызывается версия метода из класса Child
        person.greet(); // Ожидаемый вывод: "Hello from Child"
    }
}

 */


public class Solution {
    public static void main(String[] args) {
        // Полиморфизм: переменная типа Parent ссылается на объект типа Child
        Parent person = new Child();

        // Динамический полиморфизм: вызывается версия метода из класса Child
        person.greet(); // Ожидаемый вывод: "Hello from Child"
    }
}

class Parent {
    public void greet() {
        System.out.println("Hello from Parent");
    }
}

class Child extends Parent {
    @Override
    public void greet() {
        System.out.println("Hello from Child");
    }
}

/*
// Класс-потомок, наследует Parent и переопределяет поведение greet()
class Child extends Parent {
    @Override // Аннотация помогает компилятору убедиться, что метод действительно переопределён
    public void greet() {
        System.out.println("Hello from Child");
    }
}

public class Solution {
    public static void main(String[] args) {
        // Полиморфизм: переменная типа Parent ссылается на объект типа Child
        Parent person = new Child();

        // Динамический полиморфизм: вызывается версия метода из класса Child
        person.greet(); // Ожидаемый вывод: "Hello from Child"
    }
}
 */