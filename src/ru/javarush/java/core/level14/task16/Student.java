package ru.javarush.java.core.level14.task16;

public class Student {
    String studentName;
    String studentGroup;
    int studentScore;

    Student(String name, String group, int score) {
        this.studentName = name;
        this.studentGroup = group;
        this.studentScore = score;
    }

    Student(String name, String group) {
        this(name, group, 0);
    }

    Student(String studentName) {
        this(studentName,"Unknown");
    }

    Student() {
        this("Unknown");
    }

}
/*
ихнее решение
// Публичный класс Student — "форма зачисления"
public class Student {
    // Поля "анкеты" студента
    public String studentName;
    public String studentGroup;
    public int studentScore;

    // 1) Полный конструктор: все три параметра заданы явно
    public Student(String studentName, String studentGroup, int studentScore) {
        this.studentName = studentName;
        this.studentGroup = studentGroup;
        this.studentScore = studentScore;
    }

    // 2) Имя и группа: балл по умолчанию 0
    public Student(String studentName, String studentGroup) {
        this(studentName, studentGroup, 0); // делегируем в "полный" конструктор
    }

    // 3) Только имя: группа "Unknown", балл 0
    public Student(String studentName) {
        this(studentName, "Unknown", 0); // переиспользуем логику через this(...)
    }

    // 4) Без параметров: имя и группа "Unknown", балл 0
    public Student() {
        this("Unknown", "Unknown", 0); // единая точка инициализации
    }
}

 */