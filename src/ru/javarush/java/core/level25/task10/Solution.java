package ru.javarush.java.core.level25.task10;
/*
Секретный Портал: Обработка Ошибок Аутентификации 💥

Вы – разработчик системы безопасности для сверхсекретного портала, и каждый сбой авторизации должен быть тщательно зафиксирован. Вам нужна надёжная система обработки ошибок, где все проблемы безопасности имеют общего "родителя".
Начните с создания базового класса исключений для всех нарушений безопасности, назовите его SecurityBreachException. Затем создайте более специфичное исключение для неудачных попыток входа, AuthenticationFailedException, которое, конечно же, должно наследовать от SecurityBreachException.
Теперь, представьте, что у вас есть класс UserAccessService, который отвечает за вход пользователей. В этом классе создайте метод authenticateUser(), который при определённых условиях (например, неверный пароль или несуществующий пользователь) должен выбрасывать именно AuthenticationFailedException, сигнализируя о провале аутентификации.
Наконец, в главном методе main вашей программы имитируйте попытку входа, вызвав метод authenticateUser(). Ваша задача – перехватить возможное исключение, но сделайте это умным способом: поймайте его не по конкретному типу AuthenticationFailedException, а по его более общему предку SecurityBreachException, демонстрируя полиморфизм в обработке исключений. При перехвате выведите сообщение о том, что произошёл сбой безопасности.

Требования:
•	В программе должен быть создан класс исключения с именем SecurityBreachException, который будет базовым для всех исключений, связанных с безопасностью.
•	Должен быть создан класс AuthenticationFailedException, который наследуется от SecurityBreachException.
•	В классе UserAccessService должен быть реализован метод authenticateUser(), который при неудачной попытке входа выбрасывает исключение AuthenticationFailedException.
•	В программе должен присутствовать класс UserAccessService, отвечающий за аутентификацию пользователей.
•	В методе main должна быть реализована попытка вызова метода authenticateUser(), при которой возможна генерация исключения.
•	В методе main перехват исключения должен осуществляться по типу SecurityBreachException (базовый класс), а не по конкретному типу AuthenticationFailedException.
•	При перехвате исключения в блоке catch должно выводиться сообщение о произошедшем сбое безопасности.

// Базовый класс для запуска примера
public class Solution {
    public static void main(String[] args) {
        UserAccessService service = new UserAccessService();

        try {
            // Имитация неудачной попытки входа: неверный пароль
            service.authenticateUser("agent007", "wrong");

            // Если исключения не было — доступ разрешен
            System.out.println("Доступ разрешён.");
        } catch (SecurityBreachException e) {
            // Перехватываем по базовому типу — демонстрация полиморфизма
            System.out.println("Произошёл сбой безопасности: " + e.getMessage());
        }
    }
}

 */

// Базовый класс для запуска примера
public class Solution {
    public static void main(String[] args) {
        UserAccessService service = new UserAccessService();

        try {
            // Имитация неудачной попытки входа: неверный пароль
            service.authenticateUser("agent007", "wrong");

            // Если исключения не было — доступ разрешен
            System.out.println("Доступ разрешён.");
        } catch (SecurityBreachException e) {
            // Перехватываем по базовому типу — демонстрация полиморфизма
            System.out.println("Произошёл сбой безопасности: " + e.getMessage());
        }
    }
}

class SecurityBreachException extends Throwable {

}

class AuthenticationFailedException extends SecurityBreachException {

}

class UserAccessService {
//    String login;
//    String password;
//    UserAccessService(String log, String pass) {
//        this.login = log;
//        this.password = pass;
//    }
    void authenticateUser(String someWord, String otheWord) throws AuthenticationFailedException {
        if(someWord.equals("agent007") && otheWord.equals("wrong") == true) {
            throw new AuthenticationFailedException();
        }
        
    }
}

/*
// Общий базовый класс для всех исключений безопасности
class SecurityBreachException extends Exception {
    public SecurityBreachException() {
    }

    public SecurityBreachException(String message) {
        super(message);
    }

    public SecurityBreachException(String message, Throwable cause) {
        super(message, cause);
    }
}

// Специализированное исключение для неудачной аутентификации
// Наследуется от общего исключения безопасности
class AuthenticationFailedException extends SecurityBreachException {
    public AuthenticationFailedException() {
    }

    public AuthenticationFailedException(String message) {
        super(message);
    }

    public AuthenticationFailedException(String message, Throwable cause) {
        super(message, cause);
    }
}


 */