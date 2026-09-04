package ru.javarush.java.core.level24.task08;
/*

Управление складом магических артефактов: Точные детали переполнения

Вы — главный менеджер склада магических артефактов, и ваша задача — следить, чтобы склад не переполнился. Каждый артефакт уникален, и если вы попытаетесь добавить слишком много, произойдёт катастрофа. Вам нужно не просто знать, что склад переполнен, но и понимать, сколько артефактов вы пытались добавить и каков был лимит склада.
Создайте собственное исключение, назовите его StorageCapacityExceededException. Оно должно быть наследником Exception и содержать два дополнительных поля: currentItemCount (текущее количество предметов на складе) и maximumCapacity (максимальная вместимость склада). Реализуйте конструктор, который будет принимать сообщение об ошибке, а также текущее количество и лимит. Добавьте методы getCurrentItemCount() и getMaximumCapacity() для доступа к этим полям.
Теперь создайте метод, назовите его tryAddItem, который будет принимать количество добавляемых предметов ( value) и лимит склада ( limit). Этот метод должен "выбросить" StorageCapacityExceededException, если value превышает limit. В противном случае, если всё в порядке, метод просто выведет сообщение "Операция успешна!".
В главной части вашей программы симулируйте попытку добавить 150 артефактов на склад с лимитом в 100. Если возникнет ваше исключение, перехватите его и выведите на экран не только сообщение об ошибке, но и точные детали: сколько артефактов вы пытались добавить (текущее значение) и каков был предел (лимит). Это позволит вам точно определить, почему склад "отказался" принять новые предметы.

Требования:
•	Необходимо создать класс StorageCapacityExceededException, который наследуется от Exception.
•	Класс StorageCapacityExceededException должен содержать два приватных поля: currentItemCount (текущее количество предметов) и maximumCapacity (максимальная вместимость склада).
•	Класс StorageCapacityExceededException должен иметь конструктор, принимающий сообщение об ошибке, текущее количество предметов и максимальную вместимость склада.
•	В классе StorageCapacityExceededException должны быть методы getCurrentItemCount() и getMaximumCapacity() для получения значений соответствующих полей.
•	Должен быть реализован метод tryAddItem, принимающий два аргумента: количество добавляемых предметов (value) и лимит склада (limit).
•	Метод tryAddItem должен выбрасывать StorageCapacityExceededException, если value превышает limit.
•	Если value не превышает limit, метод tryAddItem должен вывести на экран сообщение "Операция успешна!".
•	В основной части программы необходимо попытаться добавить 150 предметов при лимите 100, перехватить StorageCapacityExceededException, и вывести сообщение об ошибке, а также значения currentItemCount и maximumCapacity.

public class Solution {

    // Метод пытается "добавить" value предметов при лимите limit
    // Если value > limit — бросаем наше пользовательское исключение с деталями
    public static void tryAddItem(int value, int limit) throws ... {

            // Формируем понятное сообщение и передаем вместе с деталями


        // Если всё в порядке — просто сообщаем об успехе
        System.out.println("Операция успешна!");
    }

    public static void main(String[] args) {
        try {
            // Симулируем попытку добавить 150 при лимите 100
            tryAddItem(150, 100);
        } catch (... e) {
            // Перехватываем и выводим сообщение об ошибке и точные детали
            System.out.println("Ошибка: " + e.getMessage());
            System.out.println("Текущее значение: " + e.getCurrentItemCount());
            System.out.println("Лимит: " + e.getMaximumCapacity());
        }
    }
}

 */

// Главный класс с точкой входа и методом tryAddItem
public class Solution {

    // Метод пытается "добавить" value предметов при лимите limit
    // Если value > limit — бросаем наше пользовательское исключение с деталями
    public static void tryAddItem(int value, int limit) throws StorageCapacityExceededException {

        // Формируем понятное сообщение и передаем вместе с деталями
        if (value > limit) {
            throw new StorageCapacityExceededException("Ошибочка", value, limit);
        }

        // Если всё в порядке — просто сообщаем об успехе
        System.out.println("Операция успешна!");
    }

    public static void main(String[] args) {
        try {
            // Симулируем попытку добавить 150 при лимите 100
            tryAddItem(150, 100);
        } catch (StorageCapacityExceededException e) {
            // Перехватываем и выводим сообщение об ошибке и точные детали
            System.out.println("Ошибка: " + e.getMessage());
            System.out.println("Текущее значение: " + e.getCurrentItemCount());
            System.out.println("Лимит: " + e.getMaximumCapacity());
        }
    }
}

class StorageCapacityExceededException extends Exception {
    private int currentItemCount;
    private int maximumCapacity;

    StorageCapacityExceededException(String exceptionMessage, int currItem, int maxCapas) {
        super(exceptionMessage);
        currentItemCount = currItem;
        maximumCapacity = maxCapas;

    }

    public int getCurrentItemCount() {
        return currentItemCount;
    }

    public int getMaximumCapacity() {
        return maximumCapacity;
    }


}



/*

// Главный класс с точкой входа и методом tryAddItem
public class Solution {

    // Метод пытается "добавить" value предметов при лимите limit
    // Если value > limit — бросаем наше пользовательское исключение с деталями
    public static void tryAddItem(int value, int limit) throws StorageCapacityExceededException {
        if (value > limit) {
            // Формируем понятное сообщение и передаем вместе с деталями
            throw new StorageCapacityExceededException("Превышена вместимость склада",value,limit);
        }
        // Если всё в порядке — просто сообщаем об успехе
        System.out.println("Операция успешна!");
    }

    public static void main(String[] args) {
        try {
            // Симулируем попытку добавить 150 при лимите 100
            tryAddItem(150, 100);
        } catch (StorageCapacityExceededException e) {
            // Перехватываем и выводим сообщение об ошибке и точные детали
            System.out.println("Ошибка: " + e.getMessage());
            System.out.println("Текущее значение: " + e.getCurrentItemCount());
            System.out.println("Лимит: " + e.getMaximumCapacity());
        }
    }
}

// Пользовательское проверяемое исключение, содержащее точные детали переполнения
class StorageCapacityExceededException extends Exception {
    // Текущее количество (сколько пытались добавить)
    private final int currentItemCount;
    // Максимальная вместимость склада
    private final int maximumCapacity;

    // Конструктор принимает сообщение, текущее количество и максимальную вместимость
    public StorageCapacityExceededException(String message, int currentItemCount, int maximumCapacity) {
        super(message);
        this.currentItemCount = currentItemCount;
        this.maximumCapacity = maximumCapacity;
    }

    // Геттер для текущего количества
    public int getCurrentItemCount() {
        return currentItemCount;
    }

    // Геттер для максимальной вместимости
    public int getMaximumCapacity() {
        return maximumCapacity;
    }
}

 */