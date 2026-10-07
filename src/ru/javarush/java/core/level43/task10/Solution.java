package ru.javarush.java.core.level43.task10;
/*
Клиенты CRM: Гарантия Целостности Данных При Загрузке
Представьте, что вы – главный разработчик передовой системы управления отношениями с клиентами (CRM) под названием "КлиентКоннект". Когда вы загружаете клиентские данные из архива, критически важно быть абсолютно уверенным, что то, что вы загрузили, действительно является записью о клиенте, а не каким-то поврежденным или ошибочным фрагментом данных. Для начала, ваш класс Customer должен быть Serializable.

Сначала создайте экземпляр Customer и "законсервируйте" его в специальный файл (сериализуйте). Затем наступает момент истины: напишите код, который попытается "пробудить" объект из этого файла. После того как объект будет загружен, вы должны провести тщательную проверку. Используйте оператор instanceof, чтобы убедиться, что восстановленный объект действительно является экземпляром вашего класса Customer.

Если проверка успешна, торжественно выведите на экран "Объект типа Customer успешно десериализован!". В противном случае, если тип объекта окажется неожиданным или некорректным, выведите тревожное сообщение "Ошибка типа объекта: восстановлен не клиентский файл!". Эта проверка является вашей страховкой, гарантирующей, что вы всегда работаете с корректными и ожидаемыми клиентскими данными.

Требования:
•	Класс Customer должен реализовывать интерфейс Serializable для поддержки процесса сериализации и десериализации.
•	Необходимо создать объект класса Customer и сериализовать его, записав в файл с помощью ObjectOutputStream.
•	Необходимо считать объект из файла с помощью ObjectInputStream.
•	После десериализации необходимо проверить, что считанный объект действительно является экземпляром класса Customer с помощью оператора instanceof.
•	Если объект прошёл проверку типа, программа должна вывести на экран "Объект типа Customer успешно десериализован!".
•	Если объект не является экземпляром класса Customer, программа должна вывести на экран "Ошибка типа объекта: восстановлен не клиентский файл!".

import java.io.*;

// Главный класс решения
public class Solution {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String fileName = "customer.ser";

        // 1) Создаем объект клиента
        Customer customer = new Customer("Иван Иванов", "ivan@example.com");

        // 2) Сериализуем объект в файл
        // try-with-resources автоматически закроет поток после записи
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName))) {
            out.writeObject(customer);
        }

        // 3) Десериализуем объект из файла
        Object restored;
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName))) {
            restored = in.readObject(); // Возвращает Object, дальнейшая проверка — через instanceof
        }

        // 4) Проверяем тип десериализованного объекта
        if (restored instanceof Customer) {
            System.out.println("Объект типа Customer успешно десериализован!");
        } else {
            System.out.println("Ошибка типа объекта: восстановлен не клиентский файл!");
        }
    }
}

 */

import java.io.*;

// Главный класс решения
public class Solution {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String fileName = "customer.ser";

        // 1) Создаем объект клиента
        Customer customer = new Customer("Иван Иванов", "ivan@example.com");

        // 2) Сериализуем объект в файл
        // try-with-resources автоматически закроет поток после записи
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName))) {
            out.writeObject(customer);
        }

        // 3) Десериализуем объект из файла
        Object restored;
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName))) {
            restored = (Customer) in.readObject(); // Возвращает Object, дальнейшая проверка — через instanceof
        }

        // 4) Проверяем тип десериализованного объекта
        if (restored instanceof Customer) {
            System.out.println("Объект типа Customer успешно десериализован!");
        } else {
            System.out.println("Ошибка типа объекта: восстановлен не клиентский файл!");
        }
    }
}

class Customer implements Serializable {
    String userName;
    String userEmail;

    public Customer(String name, String email) {
        this.userName = name;
        this.userEmail = email;
    }
}

/*
// Простой класс клиента, поддерживающий сериализацию
class Customer implements Serializable {
    // serialVersionUID — хорошая практика для контроля версии класса при сериализации
    private static final long serialVersionUID = 1L;

    private final String name;
    private final String email;

    public Customer(String name, String email) {
        this.name = name;
        this.email = email;
    }
}

 */