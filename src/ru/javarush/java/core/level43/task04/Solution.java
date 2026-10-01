package ru.javarush.java.core.level43.task04;
/*
Секреты Зарплаты: Временное Исчезновение и Восстановление По Умолчанию
Вы – HR-менеджер в инновационной компании "Цифровые Мастера", и вам нужно создать систему управления данными сотрудников.
Каждый сотрудник (Employee) имеет employeeName, но его employeeSalary (зарплата) является конфиденциальной информацией и
не должна быть частью постоянного файла записи,
если только это не абсолютно необходимо для расчетов в реальном времени. Класс Employee должен быть Serializable.
Для достижения этой цели сделайте поле employeeSalary transient. Это означает, что оно не будет сохраняться при сериализации.
 Но что делать, если после загрузки записи сотрудника нам все-таки нужно установить какое-то значение зарплаты, например,
 для расчетов? Реализуйте приватный метод readObject(ObjectInputStream in), который будет вызываться после стандартной
 десериализации. В этом методе вызовите стандартную десериализацию, а затем, словно по волшебству, установите employeeSalary
 в значение 1000.

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        // Создаем сотрудника и задаем зарплату 5000
        Employee original = new Employee("Иван Петров");
        original.setEmployeeSalary(5000);

        // Сериализуем объект в память (в байтовый массив)
        byte[] data;
        try (ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
             ObjectOutputStream out = new ObjectOutputStream(byteOut)) {

            // Зарплата transient — не попадет в поток
            out.writeObject(original);
            out.flush();
            data = byteOut.toByteArray();
        } catch (Exception e) {
            // Для учебной задачи упрощаем обработку ошибок
            throw new RuntimeException(e);
        }

        // Десериализуем объект из памяти
        Employee restored;
        try (ByteArrayInputStream byteIn = new ByteArrayInputStream(data);
             ObjectInputStream in = new ObjectInputStream(byteIn)) {

            restored = (Employee) in.readObject();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        // Выводим имя и зарплату восстановленного сотрудника.
        // Ожидаемо salary == 1000 благодаря логике в readObject.
        System.out.println(restored.getEmployeeName() + " " + restored.getEmployeeSalary());
    }
}

 */

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        // Создаем сотрудника и задаем зарплату 5000
        Employee original = new Employee("Иван Петров");
        original.setEmployeeSalary(5000);

        // Сериализуем объект в память (в байтовый массив)
        byte[] data;
        try (ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
             ObjectOutputStream out = new ObjectOutputStream(byteOut)) {

            // Зарплата transient — не попадет в поток
            out.writeObject(original);
            out.flush();
            data = byteOut.toByteArray();
        } catch (Exception e) {
            // Для учебной задачи упрощаем обработку ошибок
            throw new RuntimeException(e);
        }

        // Десериализуем объект из памяти
        Employee restored;
        try (ByteArrayInputStream byteIn = new ByteArrayInputStream(data);
             ObjectInputStream in = new ObjectInputStream(byteIn)) {

            restored = (Employee) in.readObject();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        // Выводим имя и зарплату восстановленного сотрудника.
        // Ожидаемо salary == 1000 благодаря логике в readObject.
        System.out.println(restored.getEmployeeName() + " " + restored.getEmployeeSalary());
    }
}

class Employee implements Serializable {
    private String employeeName;
    transient private int employeeSalary;

    public Employee(String name) {
        this.employeeName = name;
//        this.employeeSalary = salary;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public int getEmployeeSalary() {
        return employeeSalary;
    }

    public void setEmployeeSalary(int salary) {
        this.employeeSalary = salary;
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
//        System.out.println("Сохраняем профиль пользователя: "  + playerUsername);
        out.defaultWriteObject();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        this.employeeSalary = 1000;
//        System.out.println("Восстанавливаем профиль пользователя: "  + playerUsername);
    }


}
/*
public class Solution {
    public static void main(String[] args) {
        // Создаем сотрудника и задаем зарплату 5000
        Employee original = new Employee("Иван Петров");
        original.setEmployeeSalary(5000);

        // Сериализуем объект в память (в байтовый массив)
        byte[] data;
        try (ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
             ObjectOutputStream out = new ObjectOutputStream(byteOut)) {

            // Зарплата transient — не попадет в поток
            out.writeObject(original);
            out.flush();
            data = byteOut.toByteArray();
        } catch (Exception e) {
            // Для учебной задачи упрощаем обработку ошибок
            throw new RuntimeException(e);
        }

        // Десериализуем объект из памяти
        Employee restored;
        try (ByteArrayInputStream byteIn = new ByteArrayInputStream(data);
             ObjectInputStream in = new ObjectInputStream(byteIn)) {

            restored = (Employee) in.readObject();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        // Выводим имя и зарплату восстановленного сотрудника.
        // Ожидаемо salary == 1000 благодаря логике в readObject.
        System.out.println(restored.getEmployeeName() + " " + restored.getEmployeeSalary());
    }
}

// Класс сотрудника. Зарплата — конфиденциальная (transient), поэтому не сериализуется.
class Employee implements Serializable {
    private static final long serialVersionUID = 1L; // Явная версия класса (good practice)

    private String employeeName;
    private transient int employeeSalary; // transient: поле не будет записано при сериализации

    public Employee(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public int getEmployeeSalary() {
        return employeeSalary;
    }

    public void setEmployeeSalary(int employeeSalary) {
        this.employeeSalary = employeeSalary;
    }

    // Кастомная десериализация.
    // Вызывается автоматически после стандартной десериализации.
    private void readObject(ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
        in.defaultReadObject();     // Стандартно восстанавливаем не-transient поля (например, имя)
        this.employeeSalary = 1000; // "Волшебно" подставляем дефолтную зарплату
    }
}
 */