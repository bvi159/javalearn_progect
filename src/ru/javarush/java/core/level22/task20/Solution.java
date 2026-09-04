package ru.javarush.java.core.level22.task20;
/*
Сравнение изменяемых и неизменяемых профилей пользователей 🧑‍🤝‍🧑

Представьте, что вы разрабатываете систему для управления пользовательскими профилями. Для некоторых профилей (например, текущих пользователей) может потребоваться возможность обновления данных, в то время как другие (например, архивные записи) должны оставаться неизменными.
Создайте два класса: обычный класс, который будет представлять "гибкий" профиль пользователя с именем и возрастом, и обязательно добавьте к нему методы для изменения этих данных (сеттеры).
Затем создайте класс-запись, который будет представлять "фиксированный" профиль пользователя с теми же полями.
В основной программе создайте экземпляр "гибкого" профиля и покажите его начальные данные, затем измените их и снова выведите. После этого создайте экземпляр "фиксированного" профиля, покажите его начальные данные и попытайтесь изменить их.

Требования:
•	Необходимо создать обычный класс (не record) с двумя приватными полями: имя (String) и возраст (int).
•	Обычный класс должен содержать публичные методы-сеттеры для изменения имени и возраста.
•	Необходимо создать record-класс с двумя компонентами: имя (String) и возраст (int).
•	В основной программе необходимо создать экземпляр обычного класса, вывести его поля, затем изменить их с помощью сеттеров и снова вывести изменённые значения.
•	В основной программе необходимо создать экземпляр record-класса, вывести его поля и попытаться изменить их значения (что должно быть невозможно из-за отсутствия сеттеров и неизменяемости record).

public class Solution {
    public static void main(String[] args) {
        // Создаём "гибкий" профиль (обычный класс)
        FlexibleUser flexible = new FlexibleUser("Иван", 30);
        System.out.println("Гибкий профиль (до изменений): " + flexible);

        // Меняем имя и возраст с помощью сеттеров
        flexible.setName("Пётр");
        flexible.setAge(25);
        System.out.println("Гибкий профиль (после изменений): " + flexible);

        // Создаём "фиксированный" профиль (record)
        FixedUser fixed = new FixedUser("Анна", 28);
        System.out.println("Фиксированный профиль (record): " + fixed);

        fixed.setName("Мария");   // Ошибка компиляции: у record нет сеттера setName
        fixed.age = 29;           // Ошибка компиляции: поле age недоступно и final
        fixed.name("Мария");      // Ошибка компиляции: метод name() — геттер без параметров
    }
}

 */
public class Solution {
    public static void main(String[] args) {
        // Создаём "гибкий" профиль (обычный класс)
        FlexibleUser flexible = new FlexibleUser("Иван", 30);
        System.out.println("Гибкий профиль (до изменений): " + flexible);

        // Меняем имя и возраст с помощью сеттеров
        flexible.setName("Пётр");
        flexible.setAge(25);
        System.out.println("Гибкий профиль (после изменений): " + flexible);

        // Создаём "фиксированный" профиль (record)
        FixedUser fixed = new FixedUser("Анна", 28);
        System.out.println("Фиксированный профиль (record): " + fixed);

//        fixed.setName("Мария");   // Ошибка компиляции: у record нет сеттера setName
//        fixed.age = 29;           // Ошибка компиляции: поле age недоступно и final
//        fixed.name("Мария");      // Ошибка компиляции: метод name() — геттер без параметров
    }
}

class FlexibleUser {
    private String name;
    private int age;

    FlexibleUser(String flexName, int flexAge) {
        name = flexName;
        age = flexAge;
    }

    public String getName() {
        return name;
    }

    public void setName(String flexName) {
        this.name = flexName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int flexAge) {
        this.age = flexAge;
    }

    @Override
    public String toString() {
        // Компактное представление для демонстрации
        return "FlexibleUser{name='" + name + "', age=" + age + "}";
    }
}

record FixedUser(String name, int age) {
}

/*
// Обычный (мутабельный) класс — состояние можно менять через сеттеры
class FlexibleUser {
    private String name;
    private int age;

    public FlexibleUser(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Сеттеры позволяют изменять состояние объекта
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // Геттеры — удобный способ читать поля (и использовать в toString)
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        // Компактное представление для демонстрации
        return "FlexibleUser{name='" + name + "', age=" + age + "}";
    }
}

// Record-класс — неизменяемый: компоненты не имеют сеттеров, а их значения final
record FixedUser(String name, int age) { }
 */