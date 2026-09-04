package ru.javarush.java.core.level24.task11;
/*
"Внешняя ошибка" с "корнем": Исследование причин

Вы создаёте умную систему для проверки пользовательского ввода. Иногда система выдаёт общую "внешнюю ошибку", но за ней всегда скрывается более конкретная проблема, например, "некорректный аргумент". Ваша задача — не только уведомить пользователя об ошибке, но и дать системному администратору полную информацию о её источнике.
Сначала создайте собственное исключение, назовите его InputValidationException. Оно должно быть наследником Exception и иметь конструктор, который принимает как строку message (общее описание), так и объект Throwable cause (конкретную причину).
Затем, в главной части вашей программы (методе main), внутри блока try, симулируйте возникновение этой "внешней ошибки": "выбросьте" новый InputValidationException с сообщением "Внешняя ошибка обработки ввода". В качестве "корня" (cause) этой ошибки передайте новый IllegalArgumentException с сообщением "Передан некорректный формат данных".
В блоке catch перехватите ваш InputValidationException. После этого выведите на экран три важные детали:

Сообщение самого InputValidationException.
Сообщение исключения-источника (используя специальный метод для доступа к "корню").
Имя класса исключения-источника (чтобы понять, что именно пошло не так).
Это позволит вам не только обработать проблему, но и получить полную диагностику её происхождения.

Требования:
•	Необходимо создать собственный класс исключения с именем InputValidationException, который наследуется от Exception.
•	Класс InputValidationException должен иметь конструктор, принимающий два параметра: строку message и объект Throwable cause.
•	Внутри метода main требуется выбросить новый экземпляр InputValidationException с сообщением "Внешняя ошибка обработки ввода" и в качестве причины (cause) передать новый IllegalArgumentException с сообщением "Передан некорректный формат данных".
•	В методе main необходимо перехватить выброшенное InputValidationException с помощью блока catch.
•	В блоке catch необходимо вывести на экран сообщение, содержащееся в InputValidationException.
•	В блоке catch необходимо получить и вывести на экран сообщение исключения-источника (cause) с помощью метода getCause().
•	В блоке catch необходимо получить и вывести на экран имя класса исключения-источника (cause) с помощью метода getCause().getClass().getName().

public class Solution {
    public static void main(String[] args) {
        try {
            // Симулируем "внешнюю ошибку" с конкретной причиной (цепочка исключений)


        } catch (... e) {
            // 1) сообщение внешнего исключения
            System.out.println(e.getMessage());

            // 2) сообщение исключения-источника (корня)
            System.out.println(e.getCause().getMessage());

            // 3) имя класса исключения-источника
            System.out.println(e.getCause().getClass().getName());
        }
    }
}

 */
public class Solution {
    public static void main(String[] args) {
        try {
            // Симулируем "внешнюю ошибку" с конкретной причиной (цепочка исключений)
            IllegalArgumentException wrongArg = new IllegalArgumentException("Передан некорректный формат данных");

            InputValidationException wrongInput = new InputValidationException("Внешняя ошибка обработки ввода", wrongArg);

            throw wrongInput;
            // или так как я написал в самом начале 24.07.2026
//            throw new InputValidationException("Внешняя ошибка обработки ввода",
//                    new IllegalArgumentException("Передан некорректный формат данных"));
            
        } catch (InputValidationException e) {
            // 1) сообщение внешнего исключения
            System.out.println(e.getMessage());

            // 2) сообщение исключения-источника (корня)
            System.out.println(e.getCause().getMessage());

            // 3) имя класса исключения-источника
            System.out.println(e.getCause().getClass().getName());
        }
    }
}

class InputValidationException extends Exception {
    public InputValidationException(String message) {
        super(message);
    }

    public InputValidationException(String message, Throwable cause) {
        super(message, cause);
    }
}

/*
public class Solution {
    public static void main(String[] args) {
        try {
            // Симулируем "внешнюю ошибку" с конкретной причиной (цепочка исключений)
            IllegalArgumentException exception = new IllegalArgumentException("Передан некорректный формат данных");
            throw new InputValidationException("Внешняя ошибка обработки ввода", exception);

        } catch (InputValidationException e) {
            // 1) сообщение внешнего исключения
            System.out.println(e.getMessage());

            // 2) сообщение исключения-источника (корня)
            System.out.println(e.getCause().getMessage());

            // 3) имя класса исключения-источника
            System.out.println(e.getCause().getClass().getName());
        }
    }
}

// Собственное исключение для валидации ввода.
class InputValidationException extends Exception {
    public InputValidationException(String message, Throwable cause) {
        super(message, cause); // передаем и сообщение, и причину в базовый класс
    }
}

 */