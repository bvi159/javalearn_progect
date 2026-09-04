package ru.javarush.java.core.level15.task07.main;
/*
public class ModuleMain {
    public static void main(String[] args) {
        // Классы в одном пакете имеют доступ к package-private методам

    }
}
 */
public class ModuleHelper {
    // Метод без модификатора доступа — package-private.
    void provideInternalAssistance() {
        System.out.println("Предоставляю внутреннюю помощь модуля!");
    }
    // Доступен только внутри этого же пакета.

}