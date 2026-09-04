package ru.javarush.java.core.level17.task12;
/*
Университетская система: Регистрация студентов 👨‍🎓

Вы разрабатываете систему регистрации для университета. Каждый, кто попадает в систему, прежде всего, является человеком, а затем уже может быть студентом.
Начните с создания класса Person. В нём реализуйте конструктор Person(String humanName), который при создании объекта Person выводит на экран "Создан человек: " и переданное имя humanName.
Теперь создайте класс Student, который будет наследовать от Person. Студент, помимо имени, имеет ещё и номер курса (класс). Реализуйте в классе Student конструктор Student(String studentName, int studentGrade). Этот конструктор должен первым делом вызвать конструктор родительского класса Person с помощью super(studentName), чтобы инициализировать часть объекта, отвечающую за "человека". После этого, на новой строке, конструктор Student должен выводить на экран "Создан студент: <имя студента>, класс: <номер класса>".
В вашем основном методе main создайте объект Student, например, с именем "Анна" и классом 3. Система регистрации должна последовательно вывести две строки: сначала о создании человека, а затем о регистрации студента.

Ожидаемый вывод:

Создан человек: Анна
Создан студент: Анна, класс: 3
Требования:
•	В программе должен быть объявлен класс Person.
•	Класс Person должен содержать конструктор Person(String humanName), который выводит на экран строку "Создан человек: " и значение humanName.
•	Класс Student должен быть объявлен как наследник класса Person.
•	В классе Student должен быть реализован конструктор Student(String studentName, int studentGrade), который первым действием вызывает конструктор родительского класса Person с помощью super(studentName).
•	Конструктор класса Student должен выводить на экран строку "Создан студент: <имя студента>, класс: <номер класса>" после вызова конструктора родителя.
•	В методе main должен быть создан объект Student с именем "Анна" и классом 3.
•	Программа должна выводить сначала строку о создании человека, затем строку о создании студента, каждая на новой строке.

public class Solution {
    public static void main(String[] args) {
        // Создаем студента: при создании сначала сработает конструктор Person, затем Student
        Student anna = new Student("Анна", 3);
    }
}

 */
public class Solution {
    public static void main(String[] args) {
        // Создаем студента: при создании сначала сработает конструктор Person, затем Student
        Student anna = new Student("Анна", 3);
    }
}

class Person {
    Person(String humanName) {
        System.out.println("Создан человек: " + humanName);
    }
}

class Student extends Person {

    Student(String studentName, int studentGrade) {
        super(studentName);
        System.out.println("Создан студент: " + studentName + ", класс: " + studentGrade);
    }
}

/*
// Базовый класс "Человек"
class Person {
    // Конструктор выводит сообщение о создании человека
    public Person(String humanName) {
        System.out.println("Создан человек: " + humanName);
    }
}

// Класс "Студент" наследуется от "Человек"
class Student extends Person {
    private final int grade;

    public Student(String studentName, int studentGrade) {
        super(studentName); // Сначала вызываем конструктор родительского класса (Person)
        this.grade = studentGrade;
        // После инициализации части Person выводим сообщение о создании студента
        System.out.println("Создан студент: " + studentName + ", класс: " + studentGrade);
    }
}
 */