package ru.javarush.java.core.level15.task08;

/*
Управление цифровой библиотекой: кто что может делать 🏛️
Представьте, что вы и ваша команда разрабатываете большой программный модуль. Внутри этого модуля есть несколько классов, которые должны «сотрудничать» и обмениваться определёнными внутренними функциями. Однако эти функции не предназначены для использования за пределами вашего модуля (пакета).
Ваша задача — создать два класса: ModuleHelper и ModuleMain. Убедитесь, что они находятся в одном и том же пакете (например, "com.mycompany.module"). В классе ModuleHelper реализуйте метод provideInternalAssistance(), не указывая при этом никакого модификатора доступа (что сделает его package-private). Пусть этот метод выводит на экран сообщение, например, "Предоставляю внутреннюю помощь модуля!".
В классе ModuleMain создайте объект ModuleHelper и вызовите у него метод provideInternalAssistance(). Ваша программа должна успешно скомпилироваться и выполнить этот вызов, демонстрируя, что классы в одном пакете имеют доступ к таким методам.
Для полноты эксперимента, если бы вы попытались вызвать provideInternalAssistance() из класса, находящегося в совершенно другом пакете, ваша программа не должна была бы скомпилироваться, что подтвердило бы её защиту от внешнего вмешательства.

Требования:
•	Классы ModuleHelper и ModuleMain должны быть объявлены внутри одного и того же пакета, например, com.mycompany.module.
•	Метод provideInternalAssistance в классе ModuleHelper должен быть объявлен без модификатора доступа, то есть он должен быть package-private.
•	Метод provideInternalAssistance должен выводить на экран сообщение "Предоставляю внутреннюю помощь модуля!".
•	Класс ModuleMain должен создавать объект ModuleHelper и успешно вызывать у него метод provideInternalAssistance.
•	Если попытаться вызвать метод provideInternalAssistance из класса, находящегося в другом пакете, программа не должна компилироваться.

// Класс Solution находится в том же пакете (default package), что и DigitalLibraryManager
public class Solution {
    public static void main(String[] args) {
        // Создаем объект управляющего цифровой библиотекой
        DigitalLibraryManager manager = new DigitalLibraryManager();

        // Вызов public-метода — доступен всем
        manager.announceOpening();

        // Вызов protected-метода — доступен в том же пакете (и в подклассах)
        manager.conductStaffMeeting();

        // Вызов package-private метода — доступен в том же пакете
        manager.manageBookInventory();

        // Попытка вызова private-метода приведет к ошибке компиляции,
        manager.handleFinancialAudits();
    }
}

 */

// Класс Solution находится в том же пакете (default package), что и DigitalLibraryManager
public class Solution {
    public static void main(String[] args) {
        // Создаем объект управляющего цифровой библиотекой
        DigitalLibraryManager manager = new DigitalLibraryManager();

        // Вызов public-метода — доступен всем
        manager.announceOpening();

        // Вызов protected-метода — доступен в том же пакете (и в подклассах)
        manager.conductStaffMeeting();

        // Вызов package-private метода — доступен в том же пакете
        manager.manageBookInventory();

        // Попытка вызова private-метода приведет к ошибке компиляции,
       // manager.handleFinancialAudits();
    }
}

class DigitalLibraryManager {
    public void announceOpening() {
        System.out.println("Библиотека открыта для посетителей!");
    }

    protected void conductStaffMeeting() {
        System.out.println("Проведено собрание персонала библиотеки.");
    }
    void manageBookInventory() {
        System.out.println("Инвентаризация книг завершена.");
    }

    private void handleFinancialAudits(){
        System.out.println("Финансовый аудит успешно завершен.");
    }
}