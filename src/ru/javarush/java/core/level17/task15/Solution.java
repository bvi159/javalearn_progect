package ru.javarush.java.core.level17.task15;
/*
Школьная иерархия: Кто я? 🎓

Вы создаёте систему управления данными для крупного образовательного учреждения, которая включает в себя людей разных статусов: от простого человека до школьника.
Создайте три класса, отражающие эту иерархию:
Person: Самый общий класс, с методом void introduce(), который выводит "Я человек.".
Student: Класс, который наследует от Person.
SchoolStudent: Класс, который наследует от Student.
В классе SchoolStudent переопределите метод introduce() так, чтобы он выводил более конкретное сообщение: "Я школьник.".
В вашем основном методе main создайте объект SchoolStudent и вызовите для него метод introduce().
Ваша программа должна показать, как самый специфичный тип в иерархии представляется сам: "Я школьник.".

Требования:
•	Должен быть создан класс Person с методом void introduce(), который выводит "Я человек.".
•	Должен быть создан класс Student, который наследует класс Person.
•	Должен быть создан класс SchoolStudent, который наследует класс Student.
•	В классе SchoolStudent метод introduce() должен быть переопределён так, чтобы выводить "Я школьник.".
•	В методе main должен быть создан объект класса SchoolStudent и для него должен быть вызван метод introduce(), результатом чего должно быть сообщение "Я школьник.".

public class Solution {
    public static void main(String[] args) {
        // Создаем самый специфичный тип в иерархии — школьника
        SchoolStudent schoolStudent = new SchoolStudent();

        // Вызываем переопределенный метод introduce()
        // Ожидаемый вывод: "Я школьник."
        schoolStudent.introduce();
    }
}

 */
public class Solution {
    public static void main(String[] args) {
        // Создаем самый специфичный тип в иерархии — школьника
        SchoolStudent schoolStudent = new SchoolStudent();

        // Вызываем переопределенный метод introduce()
        // Ожидаемый вывод: "Я школьник."
        schoolStudent.introduce();
    }
}

class Person {
    void introduce() {
        System.out.println("Я человек.");
    }
}

class Student extends Person {

}

class SchoolStudent extends Student {
    @Override
    void introduce() {
        System.out.println("Я школьник.");
    }
}

/*
// Базовый класс: человек
class Person {
    // Метод "представиться": базовая реализация
    void introduce() {
        System.out.println("Я человек.");
    }
}

// Класс Student наследует поведение Person
class Student extends Person {
    // Специального поведения не добавляем — наследуем как есть
}

// Класс SchoolStudent — более конкретный, наследует Student
class SchoolStudent extends Student {
    // Переопределяем метод, чтобы представление стало конкретнее
    @Override
    void introduce() {
        System.out.println("Я школьник.");
    }
}
 */