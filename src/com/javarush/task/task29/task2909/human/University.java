package com.javarush.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.List;

public class University extends UniversityPerson {
    private List<Student> students = new ArrayList<>();
    String name;
    int age;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int getAge() {
        return age;
    }

    @Override
    public void setAge(int age) {
        this.age = age;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }



    public University(String name, int age) {
        super(name, age);
    }

    public Student getStudentWithAverageGrade(double averageGrade) {
        //TODO:
        for (Student student : students) {
            if (student.getAverageGrade() == averageGrade) {
                return student;
            }
        }
        return null; // не найден

    }

    public Student getStudentWithMaxAverageGrade() {
        //TODO:
        if (students == null || students.isEmpty()) {
            return null;
        }

        Student bestStudent = students.get(0);
        for (Student student : students) {
            if (student.getAverageGrade() > bestStudent.getAverageGrade()) {
                bestStudent = student;
            }
        }
        return bestStudent;
    }

    public Student getStudentWithMinAverageGrade() {
        //TODO:
        if (students == null || students.isEmpty()) {
            return null;
        }

        Student worstStudent = students.get(0);
        for (Student student : students) {
            if (student.getAverageGrade() < worstStudent.getAverageGrade()) {
                worstStudent = student;
            }
        }
        return worstStudent;
    }

    public void expel(Student expelHim) {
        //TODO:
        students.remove(expelHim);
    }
}