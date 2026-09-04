package ru.javarush.java.core.level16.task06;
/*
Секретное хранилище: уровень доступа 🛡️

Вы проектируете систему безопасности для сверхсекретного хранилища. У хранилища есть глобальный, неизменный уровень защиты, который должен быть известен всем вспомогательным модулям, даже если они работают независимо от основного хранилища.
Создайте класс Vault, представляющий ваше хранилище. Внутри Vault объявите приватное статическое целочисленное поле securityLevel, равное 100. Это будет общий уровень безопасности хранилища. Затем, внутри класса Vault, объявите публичный статический вложенный класс с именем SecurityDisplayUnit. Этот SecurityDisplayUnit должен содержать метод showSecurityLevel(), который выводит значение securityLevel на экран.
В методе main вашей программы создайте объект SecurityDisplayUnit (вам не нужен объект Vault для этого). Затем вызовите метод showSecurityLevel() для созданного SecurityDisplayUnit, чтобы убедиться, что уровень безопасности хранилища корректно отображается.

Требования:
•	Необходимо создать публичный класс с именем Vault.
•	Внутри класса Vault должно быть объявлено приватное статическое целочисленное поле с именем securityLevel, и оно должно быть инициализировано значением 100.
•	Внутри класса Vault должен быть объявлен публичный статический вложенный класс с именем SecurityDisplayUnit.
•	Класс SecurityDisplayUnit должен иметь доступ к приватному статическому полю securityLevel класса Vault.
•	В классе SecurityDisplayUnit должен быть реализован публичный метод showSecurityLevel(), который выводит значение поля securityLevel на экран.
•	В методе main программы объект SecurityDisplayUnit должен быть создан без необходимости создавать объект Vault.
•	В методе main должен быть вызван метод showSecurityLevel() у объекта SecurityDisplayUnit, и на экран должно быть выведено значение 100.

public class Vault {
    // Приватное статическое поле — общий уровень безопасности для всего хранилища
    private static int securityLevel = 100;

    // Публичный статический вложенный класс — не требует объекта Vault для создания


    public static void main(String[] args) {
        // Создаем объект вложенного класса без создания объекта Vault
        SecurityDisplayUnit display = new SecurityDisplayUnit();
        // Показываем текущий уровень безопасности
        display.showSecurityLevel();
    }
}

 */
public class Vault {
    // Приватное статическое поле — общий уровень безопасности для всего хранилища
    private static int securityLevel = 100;

    // Публичный статический вложенный класс — не требует объекта Vault для создания
    public static class SecurityDisplayUnit {
        public void showSecurityLevel() {
            System.out.println(securityLevel);
        }
    }


    public static void main(String[] args) {
        // Создаем объект вложенного класса без создания объекта Vault
        SecurityDisplayUnit display = new SecurityDisplayUnit();
        // Показываем текущий уровень безопасности
        display.showSecurityLevel();
    }
}
/*
public class Vault {
    // Приватное статическое поле — общий уровень безопасности для всего хранилища
    private static int securityLevel = 100;

    // Публичный статический вложенный класс — не требует объекта Vault для создания
    public static class SecurityDisplayUnit {
        // Имеет доступ к приватному статическому полю внешнего класса
        public void showSecurityLevel() {
            System.out.println(securityLevel); // Выводим значение 100
        }
    }

    public static void main(String[] args) {
        // Создаем объект вложенного класса без создания объекта Vault
        Vault.SecurityDisplayUnit display = new Vault.SecurityDisplayUnit();
        // Показываем текущий уровень безопасности
        display.showSecurityLevel();
    }
}
 */
