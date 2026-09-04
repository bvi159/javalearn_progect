package com.javarush.task.task25.task2502;

import java.util.*;

/* 
Машину на СТО не повезем!

Инициализируй поле wheels используя данные из loadWheelNamesFromDB.
Выкинь исключение в случае некорректных данных.

Подсказка: если что-то не то с колесами, то это не машина!
Сигнатуры не менять.

Требования:
•	Enum Wheel в классе Solution менять нельзя.
•	Сигнатуры в классе Car менять нельзя.
•	Во время создания машины нужно вызвать метод loadWheelNamesFromDB.
•	В случае возврата неправильных данных о колесах, нужно кинуть исключение.
•	Инициализируй поле wheels полученными данными.

public class Solution {
    public enum Wheel {
        FRONT_LEFT,
        FRONT_RIGHT,
        BACK_LEFT,
        BACK_RIGHT
    }

Ихнее решение
    public static class Car {
        protected List<Wheel> wheels;

        public Car() {
            Set<Wheel> wheelSet = new HashSet<>(4);
            String[] wheelNamesFromDb = loadWheelNamesFromDB();
            if (wheelNamesFromDb.length != 4) throw new IllegalArgumentException();
            for (String wheelName : wheelNamesFromDb) {
                wheelSet.add(Wheel.valueOf(wheelName));
            }
            if (wheelSet.size() != 4) throw new IllegalArgumentException();
            wheels = new ArrayList<>(wheelSet);
        }

        protected String[] loadWheelNamesFromDB() {
            //this method returns mock data
            return new String[]{"FRONT_LEFT", "FRONT_RIGHT", "BACK_LEFT", "BACK_RIGHT"};
        }
    }

    public static void main(String[] args) {
    }
}

Моё решение посимпатичнее

*/

public class Solution {
    public static enum Wheel {
        FRONT_LEFT,
        FRONT_RIGHT,
        BACK_LEFT,
        BACK_RIGHT
    }

    public static class Car {
        protected List<Wheel> wheels;

        public Car() {
            //init wheels here
            // Инициализируем wheels здесь
            this.wheels = new ArrayList<>(); // ← добавляем эту строку
            String[] myWheels = loadWheelNamesFromDB();
            int i = 0;
            for (String mWh : myWheels){
                wheels.add(i, Wheel.valueOf(mWh));
                i++;
            }

            // Проверка на null и пустой список
            if (wheels == null || wheels.isEmpty() || wheels.size() != 4) {
                throw new IllegalArgumentException("Wheels cannot be null or empty");
            }
//                        wheels = Arrays.stream(Wheel.values()).toList();

        }

        protected String[] loadWheelNamesFromDB() {
            //this method returns mock data
            return new String[]{"FRONT_LEFT", "FRONT_RIGHT", "BACK_LEFT", "BACK_RIGHT"};
        }
    }

    public static void main(String[] args){

        Car car = new Car();
        System.out.println(car.wheels);
    }
}
