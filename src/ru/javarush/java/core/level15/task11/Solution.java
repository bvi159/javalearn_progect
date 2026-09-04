package ru.javarush.java.core.level15.task11;
/*
Управление умной лампой: Включить/Выключить 💡

Вы работаете над системой "умный дом" и ваша первая задача — управлять виртуальной лампой. Вам нужно иметь возможность её включать, выключать и узнавать, горит ли она сейчас.
Создайте класс SmartLamp. Внутри него объявите приватное поле isCurrentlyOn типа boolean, которое будет хранить состояние лампы (true, если включена, false, если выключена). Реализуйте геттер isCurrentlyOn() (обратите внимание на соглашение именования для boolean-геттеров в Java) и сеттер setCurrentlyOn(boolean newState) для этого поля. Добавьте конструктор для начальной установки состояния лампы, например, по умолчанию выключено.
В классе Solution создайте объект SmartLamp. Затем используйте метод setCurrentlyOn() для того, чтобы "включить" лампу, передав ему true. После этого выведите на экран результат вызова метода isCurrentlyOn(), чтобы убедиться, что лампа теперь "горит".

Требования:
•	В классе SmartLamp должно быть объявлено приватное поле isCurrentlyOn типа boolean, которое хранит состояние лампы.
•	В классе SmartLamp должен быть реализован публичный геттер с именем isCurrentlyOn(), возвращающий текущее значение поля isCurrentlyOn.
•	В классе SmartLamp должен быть реализован публичный сеттер setCurrentlyOn(boolean newState), который изменяет значение поля isCurrentlyOn.
•	Класс SmartLamp должен содержать конструктор, устанавливающий начальное состояние лампы (по умолчанию выключено, то есть isCurrentlyOn = false).
•	В классе Solution должен быть создан объект SmartLamp, после чего должен быть вызван метод setCurrentlyOn(true) для включения лампы.
•	В классе Solution должен быть вызван метод isCurrentlyOn() для объекта SmartLamp, и его результат должен быть выведен на экран.

// Класс Solution — точка входа в программу
public class Solution {
    public static void main(String[] args) {
        // Создаем объект "умной лампы" (по умолчанию выключена)
        SmartLamp lamp = new SmartLamp();

        // Включаем лампу
        lamp.setCurrentlyOn(true);

        // Проверяем состояние через boolean-геттер и выводим результат
        System.out.println(lamp.isCurrentlyOn());
    }
}
 */

// Класс Solution — точка входа в программу
public class Solution {
    public static void main(String[] args) {
        // Создаем объект "умной лампы" (по умолчанию выключена)
        SmartLamp lamp = new SmartLamp(false);

        // Включаем лампу
        lamp.setCurrentlyOn(true);

        // Проверяем состояние через boolean-геттер и выводим результат
        System.out.println(lamp.isCurrentlyOn());
    }
}

// Класс SmartLamp инкапсулирует состояние лампы
class SmartLamp {
    private boolean isCurrentlyOn;

    public SmartLamp(boolean onOrNon) {
        this.isCurrentlyOn = onOrNon;
    }

    public boolean isCurrentlyOn() {
        return isCurrentlyOn;
    }

    public void setCurrentlyOn(boolean currentlyOn) {
        isCurrentlyOn = currentlyOn;
    }
}