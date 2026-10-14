package ru.javarush.java.core.level46.task03;
/*
Конфиденциальность данных пользователя 🕵️‍♀️
Представьте, что вы — ведущий разработчик системы безопасности нового секретного портала. Вам поручено создать класс для управления пользовательскими аккаунтами, но с особой заботой о конфиденциальности данных и чистоте передаваемой информации.

Создайте Java-класс PortalUser, который будет хранить такие важные детали, как имя пользователя (username, тип String), его пароль (password, тип String) и возраст (age, тип int). Все эти поля должны быть приватными, и, конечно же, для доступа к ним необходимо добавить стандартные методы получения и установки значений (геттеры и сеттеры).

Ваша основная задача заключается в том, чтобы, когда данные пользователя будут отправляться на сервер в формате JSON, имя пользователя выглядело как "login" вместо "username", а самое главное — пароль вообще не был включен в JSON-строку, чтобы обеспечить его секретность. Для этого используйте специальные аннотации Jackson: @JsonProperty для переименования поля username в "login" и @JsonIgnore для скрытия поля password.

После этого создайте конкретный экземпляр PortalUser с логином "admin", паролем "12345" и возрастом 20 лет. Затем, используя мощный инструмент ObjectMapper, преобразуйте этот объект в JSON-строку и выведите её на консоль. Убедитесь, что в итоговой JSON-строке логин отображается как "login", возраст присутствует, а вот поле password надежно отсутствует, как и требуется для безопасной системы.

Требования:
•	Необходимо создать публичный класс с именем PortalUser.
•	Класс PortalUser должен содержать приватные поля: String username, String password, int age.
•	Класс PortalUser должен содержать публичные геттеры и сеттеры для всех полей.
•	Поле username должно быть аннотировано @JsonProperty("login"), чтобы при сериализации оно отображалось как "login".
•	Поле password должно быть аннотировано @JsonIgnore, чтобы оно не попадало в итоговую JSON-строку.
•	Должен быть создан экземпляр класса PortalUser с username "admin", password "12345" и age 20.
•	Экземпляр PortalUser должен быть сериализован в JSON-строку с помощью класса ObjectMapper из библиотеки Jackson.
•	Получившаяся JSON-строка должна быть выведена на консоль.
•	В итоговой JSON-строке должно присутствовать поле "login" со значением "admin", поле "age" со значением 20, и отсутствовать поле "password".


// Класс для управления учетными записями пользователей портала
public class PortalUser {
    // Переименовываем поле username в "login" при сериализации в JSON

    private String username;

    // Исключаем поле password из итогового JSON

    private String password;

    // Возраст пользователя
    private int age;

    // Пустой конструктор (Jackson требует его для десериализации)
    public PortalUser() {
    }

    // Геттер для поля username
    public String getUsername() {
        return username;
    }

    // Сеттер для поля username
    public void setUsername(String username) {
        this.username = username;
    }

    // Геттер для поля password
    public String getPassword() {
        return password;
    }

    // Сеттер для поля password
    public void setPassword(String password) {
        this.password = password;
    }

    // Геттер для поля age
    public int getAge() {
        return age;
    }

    // Сеттер для поля age
    public void setAge(int age) {
        this.age = age;
    }
}

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

// Главный класс для демонстрации сериализации PortalUser в JSON
public class Solution {
    public static void main(String[] args) throws JsonProcessingException {
        // Создаем экземпляр PortalUser с заданными параметрами
        PortalUser user = new PortalUser();
        user.setUsername("admin");    // логин пользователя
        user.setPassword("12345");    // пароль пользователя (не попадет в JSON)
        user.setAge(20);              // возраст пользователя

        // Создаем ObjectMapper для работы с JSON
        ObjectMapper mapper = new ObjectMapper();
        // Сериализуем объект пользователя в JSON-строку
        String json = mapper.writeValueAsString(user);
        // Выводим результат сериализации на консоль
        System.out.println(json);
        // Ожидаемый вывод: {"login":"admin","age":20}
    }
}

 */

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

// Главный класс для демонстрации сериализации PortalUser в JSON
public class Solution {
    public static void main(String[] args) throws JsonProcessingException {
        // Создаем экземпляр PortalUser с заданными параметрами
        PortalUser user = new PortalUser();
        user.setUsername("admin");    // логин пользователя
        user.setPassword("12345");    // пароль пользователя (не попадет в JSON)
        user.setAge(20);              // возраст пользователя

        // Создаем ObjectMapper для работы с JSON
        ObjectMapper mapper = new ObjectMapper();
        // Сериализуем объект пользователя в JSON-строку
        String json = mapper.writeValueAsString(user);
        // Выводим результат сериализации на консоль
        System.out.println(json);
        // Ожидаемый вывод: {"login":"admin","age":20}
    }
}

/*
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;

// Класс для управления учетными записями пользователей портала
public class PortalUser {
    // Переименовываем поле username в "login" при сериализации в JSON
    @JsonProperty("login")
    private String username;

    // Исключаем поле password из итогового JSON
    @JsonIgnore
    private String password;

    // Возраст пользователя
    private int age;

    // Пустой конструктор (Jackson требует его для десериализации)
    public PortalUser() {
    }

    // Геттер для поля username
    public String getUsername() {
        return username;
    }

    // Сеттер для поля username
    public void setUsername(String username) {
        this.username = username;
    }

    // Геттер для поля password
    public String getPassword() {
        return password;
    }

    // Сеттер для поля password
    public void setPassword(String password) {
        this.password = password;
    }

    // Геттер для поля age
    public int getAge() {
        return age;
    }

    // Сеттер для поля age
    public void setAge(int age) {
        this.age = age;
    }
}
 */