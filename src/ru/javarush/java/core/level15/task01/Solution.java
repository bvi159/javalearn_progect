package ru.javarush.java.core.level15.task01;
/*
Секретные данные членов клуба 🕵️‍♀️
Представьте, что вы начинаете разрабатывать систему учёта для эксклюзивного клуба. Самое первое, что вам нужно сделать, это определить, какие данные будут храниться о каждом члене. Важно, чтобы эти данные были приватными, то есть к ним нельзя было напрямую получить доступ извне класса.
Ваша задача — создать класс Person. Внутри этого класса объявите два приватных поля: одно для имени члена клуба, пусть оно будет называться memberName и иметь тип String, и второе для возраста члена клуба, назовите его memberAge с типом int. Не добавляйте в этот класс никаких методов.
Затем, в другом классе (например, в Solution), создайте экземпляр вашего класса Person. Попробуйте обратиться напрямую к полям memberName и memberAge из Solution — вы должны убедиться, что это невозможно, что означает, что данные члена клуба надёжно защищены от прямого внешнего доступа.

Требования:
•	Необходимо создать отдельный класс с именем Person.
•	В классе Person должны быть объявлены два приватных поля: String memberName и int memberAge.
•	В классе Person не должно быть объявлено никаких методов.
•	В другом классе (например, Solution) должен быть создан экземпляр класса Person.
•	В классе Solution должна быть предпринята попытка обращения к полям memberName и memberAge экземпляра Person напрямую.
•	Попытка прямого доступа к приватным полям memberName и memberAge из класса Solution должна быть невозможна (приватные поля не доступны вне класса Person).

public class Solution {
    public static void main(String[] args) {
        // Создаем экземпляр класса Person
        Person person = new Person();

        // Ниже — намеренные попытки прямого доступа к приватным полям.
        person.memberName = "Alice"; // Ошибка компиляции: memberName имеет модификатор private
        person.memberAge = 30;       // Ошибка компиляции: memberAge имеет модификатор private

        // Демонстрационное сообщение
        System.out.println("Экземпляр Person создан. Прямой доступ к полям memberName и memberAge запрещён (private).");
    }
}

 */
public class Solution {
    public static void main(String[] args) {
        // Создаем экземпляр класса Person
        Person person = new Person();

        try {

               // Ниже — намеренные попытки прямого доступа к приватным полям.
//            person.memberName = "Alice"; // Ошибка компиляции: memberName имеет модификатор private
//            person.memberAge = 30;       // Ошибка компиляции: memberAge имеет модификатор private

        } catch (Exception e) {
            // Демонстрационное сообщение
            System.out.println("Экземпляр Person создан. Прямой доступ к полям memberName и memberAge запрещён (private).");
            throw new RuntimeException(e);
        }
    }
}

class Person {
    private String memberName;
    private int memberAge;
}