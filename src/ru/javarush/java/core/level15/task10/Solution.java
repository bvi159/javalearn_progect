package ru.javarush.java.core.level15.task10;
/*
Управление возрастом студента в базе данных 🎓

Вы — часть команды, которая разрабатывает систему управления студенческими записями. Важно хранить возраст каждого студента и иметь возможность его корректировать, а также получать эту информацию.
Создайте класс StudentProfile. Внутри него объявите приватное поле studentAge типа int. Реализуйте для этого поля два публичных метода: getStudentAge(), который будет возвращать текущий возраст студента, и setStudentAge(int newAge), который позволит обновить возраст студента. Не забудьте также добавить публичный конструктор для инициализации studentAge при создании объекта.
В классе Solution создайте объект StudentProfile. Используя метод setStudentAge(), установите возраст студента, например, на 20 лет. Затем, чтобы убедиться, что возраст был успешно обновлён и доступен для чтения, выведите результат вызова метода getStudentAge() на экран.

Требования:
•	В классе StudentProfile должно быть объявлено приватное поле int studentAge.
•	В классе StudentProfile должен быть публичный метод getStudentAge(), возвращающий текущее значение поля studentAge.
•	В классе StudentProfile должен быть публичный метод setStudentAge(int newAge), который устанавливает значение поля studentAge.
•	В классе StudentProfile должен быть публичный конструктор, принимающий параметр int для инициализации поля studentAge при создании объекта.
•	В классе Solution должен быть создан объект StudentProfile.
•	В классе Solution для объекта StudentProfile должен быть вызван метод setStudentAge с аргументом, например, 20.
•	В классе Solution должен быть вызван метод getStudentAge для объекта StudentProfile, и результат должен быть выведен на экран.

public class Solution {
    public static void main(String[] args) {
        // Создаем объект профиля студента с начальным возрастом (например, 18)
        StudentProfile profile = new StudentProfile(18);

        // Обновляем возраст до 20 с помощью сеттера
        profile.setStudentAge(20);

        // Выводим текущий возраст, чтобы убедиться, что он обновился
        System.out.println(profile.getStudentAge());
    }
}

 */


public class Solution {
    public static void main(String[] args) {
        // Создаем объект профиля студента с начальным возрастом (например, 18)
        StudentProfile profile = new StudentProfile(18);

        // Обновляем возраст до 20 с помощью сеттера
        profile.setStudentAge(20);

        // Выводим текущий возраст, чтобы убедиться, что он обновился
        System.out.println(profile.getStudentAge());
    }
}

class StudentProfile {
    private int studentAge;

    public StudentProfile(int age) {
        this.studentAge = age;
    }

    public int getStudentAge() {
        return studentAge;
    }

    public void setStudentAge(int studentAge) {
        this.studentAge = studentAge;
    }
}