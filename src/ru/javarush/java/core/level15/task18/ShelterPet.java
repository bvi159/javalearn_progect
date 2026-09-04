package ru.javarush.java.core.level15.task18;

public class ShelterPet {
    {
        System.out.println("Начинаем регистрацию нового питомца...");

    }

    public ShelterPet() {
        System.out.println( "Запись о питомце успешно создана!");
    }
}

/*
public class ShelterPet {
    // Нестатический блок инициализации — выполняется при создании каждого объекта, до конструктора
    {
        System.out.println("Начинаем регистрацию нового питомца...");
    }

    // Публичный конструктор без параметров
    public ShelterPet() {
        System.out.println("Запись о питомце успешно создана!");
    }
}
 */