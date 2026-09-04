package com.javarush.examples.Boeing737Drawing;

public class Boeing737 {

    private int manufactureYear;
    private static int maxPassengersCount = 300;

    public Boeing737(int manufactureYear) {
        this.manufactureYear = manufactureYear;
    }

    public int getManufactureYear() {
        return manufactureYear;
    }

    public static class Drawing {

    }

    // Хотя наш класс Boeing737Drawing наследован от статического класса,
    // сам он не статический! Поэтому ему всегда будет нужен экземпляр внешнего класса.
    public class Boeing737Drawing extends Drawing {

        public int getMaxPassengersCount() {

            return maxPassengersCount;
        }
    }
}

