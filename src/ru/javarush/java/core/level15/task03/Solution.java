package ru.javarush.java.core.level15.task03;
/*
Корректировка данных и защита от ошибок 🚫
Представьте, что вы — секретарь клуба, и вам нужно обновлять информацию о членах, но при этом важно, чтобы данные всегда оставались корректными. Например, возраст не может быть отрицательным!
Продолжайте работать с вашим классом Person. Добавьте в него два публичных метода-сеттера: setMemberName(String newName) для изменения имени и setMemberAge(int newAge) для изменения возраста.
В методе setMemberAge() реализуйте важную проверку: если кто-то пытается установить отрицательный возраст (то есть newAge < 0), ваш метод должен отказаться изменять поле memberAge. Вместо этого он должен вывести на экран сообщение "Ошибка: Возраст не может быть отрицательным. Значение не изменено." В противном случае, если возраст корректен, спокойно обновите поле memberAge.
В классе Solution создайте новый объект Person, например, "Иван", с возрастом 25. Затем попробуйте установить Ивану возраст -5. После этого выведите его текущий возраст на экран, чтобы убедиться, что возраст не изменился, и вы увидите то самое сообщение об ошибке. Затем попробуйте установить ему корректный возраст, например, 35, и снова выведите возраст, чтобы подтвердить успешное изменение.

Требования:
•	В классе Person должны быть объявлены два публичных метода-сеттера: setMemberName(String newName) и setMemberAge(int newAge).
•	Метод setMemberAge(int newAge) должен проверять, что переданное значение newAge не меньше 0.
•	Если newAge меньше 0, метод setMemberAge не должен изменять значение поля memberAge и должен вывести сообщение "Ошибка: Возраст не может быть отрицательным. Значение не изменено." на экран.
•	Если newAge больше или равен 0, метод setMemberAge должен изменить поле memberAge на новое значение.
•	В методе main класса Solution должен быть создан объект Person с именем "Иван" и возрастом 25, после чего должны быть произведены попытки изменить возраст на -5 и 35 с соответствующей проверкой результата через вывод текущего возраста на экран.

public class Solution {
    public static void main(String[] args) {
        // Создаём участника Иван, 25 лет
        Person person = new Person("Иван", 25);

        // Пытаемся установить некорректный возраст (-5) — должно появиться сообщение об ошибке,
        // а возраст остаться без изменений
        person.setMemberAge(-5);
        System.out.println(person.getMemberAge()); // Ожидается: 25

        // Теперь устанавливаем корректный возраст (35)
        person.setMemberAge(35);
        System.out.println(person.getMemberAge()); // Ожидается: 35
    }
}

 */

public class Solution {
    public static void main(String[] args) {
        // Создаём участника Иван, 25 лет
        Person person = new Person("Иван", 25);

        // Пытаемся установить некорректный возраст (-5) — должно появиться сообщение об ошибке,
        // а возраст остаться без изменений
        person.setMemberAge(-5);
        System.out.println(person.getMemberAge()); // Ожидается: 25

        // Теперь устанавливаем корректный возраст (35)
        person.setMemberAge(35);
        System.out.println(person.getMemberAge()); // Ожидается: 35
    }
}

class Person {
    private String memberName;
    private int memberAge;

    public String getMemberName() {
        return memberName;
    }

    public int getMemberAge() {
        return memberAge;
    }

    public void setMemberName(String name) {
        this.memberName = name;
    }

    public void setMemberAge(int age) {
       if (age<0) {
           System.out.println("Ошибка: Возраст не может быть отрицательным. Значение не изменено.");
//           throw new RuntimeException("Ошибка: Возраст не может быть отрицательным. Значение не изменено.");
           return;
       }
        this.memberAge = age;
    }

    public Person(String name, int age) {
        this.memberName = name;
        //this.memberAge = age; - моё решение - тоже работает но видимо не так эффективно на этапе ввода возраста
        //ихнее решение
        setMemberAge(age); // используем логику проверки из сеттера
    }
}