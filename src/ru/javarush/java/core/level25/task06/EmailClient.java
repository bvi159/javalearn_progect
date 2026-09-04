package ru.javarush.java.core.level25.task06;
/*
//Продвинутый Почтовый Клиент: Составление Письма 📦

Вы работаете над продвинутым почтовым клиентом, который должен максимально эффективно управлять сообщениями. Представьте, что сам почтовый клиент – это основной контейнер EmailClient, а каждое отдельное письмо – это Email, которое не существует вне контекста этого клиента.
Создайте класс EmailClient, а внутри него – внутренний класс Email. В классе Email добавьте поле content, чтобы хранить текст письма.

Теперь, чтобы пользователь мог отправлять сообщения, в классе EmailClient создайте метод composeEmail(String messageContent), который будет принимать текст сообщения, а затем создавать и возвращать новый объект Email с этим текстом.

В главном методе main воплотите в жизнь ваш почтовый клиент, создав его объект, а затем используйте его для написания и отправки тестового письма, вызвав метод composeEmail() и убедившись, что сообщение создано.

Требования:
•	В программе должен быть объявлен основной класс с именем EmailClient.
•	Внутри класса EmailClient должен быть объявлен нестатический внутренний класс с именем Email.
•	Класс Email должен содержать поле content для хранения текста письма.
•	Класс EmailClient должен содержать метод composeEmail(String messageContent), который создает и возвращает новый объект Email с переданным содержимым.
•	В методе main должен быть создан объект класса EmailClient, а затем с его помощью создано тестовое письмо через вызов метода composeEmail.
•	В методе main должно быть продемонстрировано, что письмо успешно создано (например, через обращение к его полю content или другим способом).

public class EmailClient {

    // Нестатический внутренний класс: письмо существует только в контексте EmailClient


    // Метод, который "составляет" письмо и возвращает новый объект Email
    public Email composeEmail(String messageContent) {
        // Создаем письмо, привязанное к текущему экземпляру EmailClient

    }

    public static void main(String[] args) {
        // Создаем почтовый клиент


        // Составляем тестовое письмо через метод composeEmail


        // Проверяем, что письмо создано: выводим его содержимое

    }
}

*/

public class EmailClient {

    // Нестатический внутренний класс: письмо существует только в контексте EmailClient
    class Email {
        String content;
        Email(String someMess) {
            content = someMess;
        }
    }


    // Метод, который "составляет" письмо и возвращает новый объект Email
    public Email composeEmail(String messageContent) {
        // Создаем письмо, привязанное к текущему экземпляру EmailClient
        Email myEml = new Email(messageContent);

        return myEml;

    }

    public static void main(String[] args) {
        // Создаем почтовый клиент
        EmailClient myNewEmlClnt = new EmailClient();

        // Составляем тестовое письмо через метод composeEmail
        Email mmm = myNewEmlClnt.composeEmail("Привет уроды!");


        // Проверяем, что письмо создано: выводим его содержимое
        System.out.println(mmm.content);

    }
}



/*
 public class EmailClient {

    // Нестатический внутренний класс: письмо существует только в контексте EmailClient
    public class Email {
        // Храним текст письма
        public final String content;

        // Конструктор письма принимает содержимое
        public Email(String content) {
            this.content = content;
        }
    }

    // Метод, который "составляет" письмо и возвращает новый объект Email
    public Email composeEmail(String messageContent) {
        // Создаем письмо, привязанное к текущему экземпляру EmailClient
        return new Email(messageContent);
    }

    public static void main(String[] args) {
        // Создаем почтовый клиент
        EmailClient client = new EmailClient();

        // Составляем тестовое письмо через метод composeEmail
        EmailClient.Email email = client.composeEmail("Привет! Это тестовое письмо.");

        // Проверяем, что письмо создано: выводим его содержимое
        System.out.println("Содержимое письма: " + email.content);
    }
}


 */