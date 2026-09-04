package ru.javarush.java.core.level17.task18;
/*
Семейная бухгалтерия: Секреты и наследство 💰

Вы разрабатываете безопасную систему для ведения семейных финансов, где некоторые данные должны быть абсолютно приватными, даже для членов семьи следующего поколения.
Создайте класс Parent с приватным полем int familySecret = 42;. Это секретное число, доступное только самому Parent.
Для демонстрации контролируемого доступа, добавьте в Parent публичный метод void printSecret(), который выводит значение этого familySecret на экран.
Теперь создайте класс Child, который будет наследовать от Parent. Внутри класса Child, попробуйте напрямую обратиться к полю familySecret (например, System.out.println(familySecret); или this.familySecret = 10;).

Запустите компилятор и посмотрите, какую ошибку он выдаст. Этот эксперимент покажет вам, как модификатор доступа private полностью защищает члены класса от прямого доступа извне, включая подклассы, демонстрируя важный принцип инкапсуляции.

Требования:
•	В классе Parent должно быть объявлено приватное поле int familySecret, инициализированное значением 42.
•	В классе Parent должен быть реализован публичный метод void printSecret(), который выводит значение familySecret на экран.
•	Класс Child должен наследовать класс Parent с помощью ключевого слова extends.
•	Внутри класса Child должна быть предпринята попытка прямого обращения к полю familySecret (например, через System.out.println(familySecret); или this.familySecret = 10;).
•	Попытка прямого доступа к приватному полю familySecret в классе Child должна приводить к ошибке компиляции, подтверждая, что private-поля недоступны даже в наследниках.

public class Solution {
    public static void main(String[] args) {
        Parent parent = new Parent();
        parent.printSecret(); // выведет 42 — корректный доступ через публичный метод

        // Вызов ниже демонстрационен. Сам файл не скомпилируется из-за ошибок в Child,
        new Child().demo();
    }
}

 */
public class Solution {
    public static void main(String[] args) {
        Parent parent = new Parent();
        parent.printSecret(); // выведет 42 — корректный доступ через публичный метод

        // Вызов ниже демонстрационен. Сам файл не скомпилируется из-за ошибок в Child,
        new Child().demo();
    }
}

class Parent {
    private int familySecret = 42;

    public void printSecret() {
        System.out.println(familySecret);
    }
}

class Child extends Parent {
//    this.familySecret = 10;

    public void demo() {
        System.out.println("Это детский секрет!");
//        System.out.println(familySecret);
    }

}

/*
// Родитель хранит секрет как private и предоставляет только контролируемый доступ
class Parent {
    private int familySecret = 42; // приватное поле — доступно только внутри Parent

    public void printSecret() {
        System.out.println(familySecret); // корректный доступ внутри самого класса
    }
}

// Наследник пытается обратиться к приватному полю напрямую — это ошибка компиляции
class Child extends Parent {
    void demo() {
        // Обе строки ниже демонстрируют недоступность private-поля в наследнике.
        System.out.println(familySecret); // Ошибка: familySecret имеет private-доступ в Parent
        this.familySecret = 10;           // Ошибка: familySecret имеет private-доступ в Parent
    }
}
 */