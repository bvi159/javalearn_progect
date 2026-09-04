package ru.javarush.java.core.level24.task06;
/*
Пароль-крепость: Защита данных пользователя

Вы отвечаете за безопасность нового пользовательского портала, и ваша главная задача — убедиться, что пароли пользователей достаточно надёжны. Слишком короткий пароль — это открытая дверь для злоумышленников. Вам нужно создать "систему безопасности", которая не пропустит слабые пароли.
Приступайте к разработке класса PasswordGuard. Внутри него создайте метод, назовите его enforcePasswordStrength, который будет принимать на вход строку — предлагаемый пользователем пароль. Если длина этого пароля окажется меньше 6 символов, ваш метод должен "выбросить" особое исключение — WeakPasswordException. Это исключение должно содержать предупреждающее сообщение "Пароль слишком короткий!", и оно, конечно же, должно быть наследником обычного Exception.
В главной части вашей программы, симулируйте попытку пользователя установить короткий пароль, вызвав ваш метод enforcePasswordStrength с такой строкой. Ваша задача — убедиться, что ваша система правильно реагирует на слабый пароль, перехватывает WeakPasswordException и выводит на экран то самое предупреждающее сообщение, чтобы пользователь мог понять, что его пароль недостаточно надёжен.

Требования:
•	Должен быть создан новый класс исключения WeakPasswordException, который наследуется от Exception.
•	Класс WeakPasswordException должен иметь конструктор, принимающий строку-сообщение и передающий его в конструктор суперкласса.
•	В классе PasswordGuard должен быть реализован метод enforcePasswordStrength, принимающий строку-пароль.
•	Метод enforcePasswordStrength должен выбрасывать исключение WeakPasswordException, если длина пароля меньше 6 символов.
•	При выбрасывании WeakPasswordException должно использоваться сообщение "Пароль слишком короткий!".
•	В главном методе программы должен быть вызван enforcePasswordStrength с коротким паролем, и выброшенное исключение должно быть перехвачено.
•	При перехвате WeakPasswordException в главной программе должно быть выведено на экран сообщение из исключения ("Пароль слишком короткий!").

// Главный класс с методом main
public class Solution {
    public static void main(String[] args) {
        try {
            // Симулируем установку слишком короткого пароля

        } catch (... e) {
            // Перехватываем и выводим сообщение из исключения
            System.out.println(e.getMessage());
        }
    }
}

// Собственное проверяемое исключение, наследуется от Exception
class WeakPasswordException extends Exception {
    // Конструктор, принимающий сообщение и передающий его в суперкласс
    public WeakPasswordException(String message) {
        super(message);
    }
}

 */
// Главный класс с методом main
public class Solution {
    public static void main(String[] args) {
        try {
            // Симулируем установку слишком короткого пароля
            PasswordGuard passPass = new PasswordGuard();
            passPass.enforcePasswordStrength("123456");
//            PasswordGuard.enforcePasswordStrength("12345");
            System.out.println("Всё ok, Пароль принят!");
        } catch (WeakPasswordException e) {
            // Перехватываем и выводим сообщение из исключения
            System.out.println(e.getMessage());
        }

    }
}

// Собственное проверяемое исключение, наследуется от Exception
class WeakPasswordException extends Exception {
    // Конструктор, принимающий сообщение и передающий его в суперкласс
    public WeakPasswordException(String message) {
        super(message);
    }
}

class PasswordGuard {
    void enforcePasswordStrength(String strPass) throws WeakPasswordException {
        if (strPass.length() < 6) {
            throw new WeakPasswordException("Пароль слишком короткий!");
        }
    }
}

/*
// Главный класс с методом main
public class Solution {
    public static void main(String[] args) {
        try {
            // Симулируем установку слишком короткого пароля
            PasswordGuard.enforcePasswordStrength("123");
        } catch (WeakPasswordException e) {
            // Перехватываем и выводим сообщение из исключения
            System.out.println(e.getMessage());
        }
    }
}

// Класс-"охранник" пароля
class PasswordGuard {
    // Метод проверяет минимальную длину пароля
    public static void enforcePasswordStrength(String password) throws WeakPasswordException {
        // Если пароль короче 6 символов — бросаем наше исключение с требуемым сообщением
        if (password.length() < 6) {
            throw new WeakPasswordException("Пароль слишком короткий!");
        }
    }
}

// Собственное проверяемое исключение, наследуется от Exception
class WeakPasswordException extends Exception {
    // Конструктор, принимающий сообщение и передающий его в суперкласс
    public WeakPasswordException(String message) {
        super(message);
    }
}
 */