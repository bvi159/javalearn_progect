package ru.javarush.java.core.level15.task17;

public class ApplicationModule {
    static String moduleStatusMessage;

    static{
        moduleStatusMessage = "Приложение: Главный модуль готов к работе!";
        System.out.println(moduleStatusMessage);
    }

}

/*
// Публичный класс главного модуля приложения
public class ApplicationModule {
    // Статическое поле со статусом модуля
    public static String moduleStatusMessage;

    // Статический блок выполняется один раз при первой загрузке класса в память
    static {
        moduleStatusMessage = "Приложение: Главный модуль готов к работе!";
        System.out.println(moduleStatusMessage); // Выводим сообщение сразу после инициализации
    }

    // Конструктор не содержит вывода — это важно по условию
    public ApplicationModule() {
        // пусто
    }
}
 */