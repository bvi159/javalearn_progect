package ru.javarush.java.core.level16.task14;
/*
Хранитель тайны: контролируемое раскрытие секрета 🔐

Вы создаёте систему для хранения ценной информации, которая должна быть строго конфиденциальной. Сама система SecretKeeper хранит "секрет", доступ к которому ограничен. Однако, в определённых условиях, когда владелец системы даёт разрешение, "секрет" может быть временно раскрыт специальным временным агентом.
В классе SecretKeeper объявите приватное строковое поле hiddenSecret со значением "Java — круто!". В методе revealSecret() этого класса объявите локальный класс с именем TruthRevealer. TruthRevealer должен содержать метод printSecret(), который выводит на экран значение поля hiddenSecret. Создайте объект TruthRevealer и вызовите его метод printSecret(), чтобы увидеть секретное послание на экране.

Требования:
•	В классе SecretKeeper должно быть объявлено приватное строковое поле с именем hiddenSecret и значением "Java — круто!".
•	В методе revealSecret() класса SecretKeeper должен быть объявлен локальный класс с именем TruthRevealer.
•	Класс TruthRevealer должен иметь доступ к приватному полю hiddenSecret внешнего класса SecretKeeper.
•	В классе TruthRevealer должен быть реализован метод printSecret(), который выводит на экран значение поля hiddenSecret.
•	В методе revealSecret() должен быть создан объект класса TruthRevealer и вызван его метод printSecret().

public class Solution {
    public static void main(String[] args) {
        // Демонстрация работы SecretKeeper
        SecretKeeper keeper = new SecretKeeper();
        keeper.revealSecret();
    }
}

// Класс-хранитель секрета
class SecretKeeper {
    // Приватное поле с секретом
    private String hiddenSecret = "Java — круто!";

    // Метод, внутри которого объявляется локальный класс
    public void revealSecret() {
        // Локальный класс, объявленный внутри метода


        // Создаём объект локального класса и раскрываем секрет

    }
}

 */
public class Solution {
    public static void main(String[] args) {
        // Демонстрация работы SecretKeeper
        SecretKeeper keeper = new SecretKeeper();
        keeper.revealSecret();
    }
}

// Класс-хранитель секрета
class SecretKeeper {
    // Приватное поле с секретом
    private String hiddenSecret = "Java — круто!";

    // Метод, внутри которого объявляется локальный класс
    public void revealSecret() {
        // Локальный класс, объявленный внутри метода
        class TruthRevealer {
            void printSecret() {
                System.out.println(hiddenSecret);
            }
        }

        // Создаём объект локального класса и раскрываем секрет
        TruthRevealer traitor = new TruthRevealer();
        traitor.printSecret();

    }
}