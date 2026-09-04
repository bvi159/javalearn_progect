package ru.javarush.java.core.level08.task17;
/*
Открытый реестр жителей деревни 🏡
Представьте, что вы создаете самый простой открытый реестр для жителей деревни, где имя каждого человека должно быть доступно для прямого просмотра и изменения всеми желающими. Ваша задача — разработать класс VillageResident, который будет иметь публичное поле residentName типа String. Это поле должно быть прямо видно и изменяемо из любой точки вашей программы, как информация на доске объявлений.

В главной деревенской площади, в методе main, создайте запись для нового жителя: newVillager = new VillageResident(). Затем прямо и без стеснения присвойте его полю residentName значение "Иван" и немедленно выведите это имя на экран, чтобы все убедились, что запись успешно создана и доступна.

Требования:
•	В программе должен быть создан класс с именем VillageResident.
•	Класс VillageResident должен содержать публичное поле residentName типа String.
•	Поле residentName должно быть доступно для чтения и изменения из любой части программы (используется модификатор public).
•	В методе main должен быть создан объект класса VillageResident и сохранён в переменную newVillager.
•	В методе main полю residentName объекта newVillager должно быть присвоено значение "Иван".
•	В методе main значение поля residentName объекта newVillager должно быть выведено на экран.

public class Solution {
    public static void main(String[] args) {
        // Создаем объект класса VillageResident
        VillageResident newVillager = new VillageResident();

        // Прямо присваиваем значение "Иван" полю residentName
        newVillager.residentName = "Иван";

        // Выводим значение поля residentName на экран
        System.out.println(newVillager.residentName);
    }
}

 */
public class Solution {
    public static void main(String[] args) {
        // Создаем объект класса VillageResident
        VillageResident newVillager = new VillageResident();

        // Прямо присваиваем значение "Иван" полю residentName
        newVillager.residentName = "Иван";

        // Выводим значение поля residentName на экран
        System.out.println(newVillager.residentName);
    }
}

// Класс VillageResident с публичным полем residentName
class VillageResident {
    public String residentName;
}