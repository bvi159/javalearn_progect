package com.javarush.examples.Boeing737Drawing;

public class Main {

    public static void main(String[] args) {

        Boeing737 boeing737 = new Boeing737(1990);

        // Наш класс Boeing737Drawing наследован от статического класса,
        // сам он не статический! Поэтому ему всегда будет нужен экземпляр внешнего класса.
        Boeing737.Boeing737Drawing drawing = boeing737.new Boeing737Drawing();

        System.out.println("Число пассажиров - " + drawing.getMaxPassengersCount());

        System.out.println("Год выпуска - " + boeing737.getManufactureYear());

    }

}
