package ru.javarush.java.core.level15.task07.other;

import ru.javarush.java.core.level15.task07.main.ModuleHelper;

public class ExternalCaller {
    public static void main(String[] args) {
        // Ошибка компиляции: метод недоступен из другого пакета
        // Классы в одном пакете имеют доступ к package-private методам
        ModuleHelper h = new ModuleHelper();
//        h.provideInternalAssistance();


    }
}