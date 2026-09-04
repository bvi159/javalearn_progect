package ru.javarush.java.core.level17.task19;
/*
Приёмная комиссия: Путь от человека до студента 🏫

Вы создаёте систему для приёмной комиссии университета, которая отслеживает путь каждого нового человека от простого абитуриента до полноценного студента. Начните с класса Person с конструктором Person(String humanName), который при создании объекта выводит "Person создан: [имя человека]".
Далее, создайте класс Student, который будет наследовать от Person. Когда студент поступает, он сначала регистрируется как человек, а затем как студент. Поэтому в конструкторе Student(String studentName), вызовите конструктор родителя с помощью super(studentName) как самое первое действие. После этого добавьте вывод "Student создан: [имя студента]".
В вашем основном методе main создайте объект Student, например, с именем "Елена". Прежде чем запустить код, подумайте, в каком порядке и что именно будет выведено на экран. Этот пример наглядно демонстрирует, как конструкторы в иерархии наследования работают вместе, обеспечивая правильную инициализацию объекта на каждом уровне.

Требования:
•	Должен быть создан класс Person с конструктором Person(String humanName).
•	Конструктор класса Person должен выводить строку "Person создан: [имя человека]", где [имя человека] — переданный в конструктор параметр.
•	Должен быть создан класс Student, который наследует класс Person.
•	В конструкторе Student(String studentName) первым действием должен быть вызван конструктор родителя через super(studentName).
•	После вызова конструктора родителя, конструктор Student должен выводить строку "Student создан: [имя студента]", где [имя студента] — переданный в конструктор параметр.
•	В методе main должен быть создан объект типа Student с именем, например, "Елена".
•	При создании объекта Student сначала должна выводиться строка от конструктора Person, затем — строка от конструктора Student.

public class Solution {
    public static void main(String[] args) {
        // Создаем объект Student.
        // Порядок вывода:
        // 1) Сначала сработает конструктор Person (через super), затем
        // 2) Конструктор Student.
        Student elena = new Student("Елена");
    }
}

 */

public class Solution {
    public static void main(String[] args) {
        // Создаем объект Student.
        // Порядок вывода:
        // 1) Сначала сработает конструктор Person (через super), затем
        // 2) Конструктор Student.
        Student elena = new Student("Елена");
    }
}

class Person {
    Person(String humanName) {
        System.out.println("Person создан: " + humanName);
    }
}

class Student extends Person {
    Student(String studentName) {
        super(studentName);
        System.out.println("Student создан: " + studentName);
    }
}

/*
// Базовый класс "человек"
class Person {
    public Person(String humanName) {
        // Сообщаем о создании Person
        System.out.println("Person создан: " + humanName);
    }
}

// Подкласс "студент" наследует Person
class Student extends Person {
    public Student(String studentName) {
        super(studentName); // первым действием вызываем конструктор родителя
        // Сообщаем о создании Student
        System.out.println("Student создан: " + studentName);
    }
}
 */