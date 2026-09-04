package ru.javarush.java.core.level23.task09;

/*
Простая картотека автосалона 🚗

Вы менеджер автосалона и вам нужно быстро создать простую систему учета автомобилей. Создайте класс Car, который будет представлять каждую машину. Внутри этого класса объявите два публичных поля: одно строковое carBrand для названия марки и одно целочисленное productionYear для года выпуска. Сделав их публичными, вы позволяете любой части вашей программы напрямую получать и изменять эти данные.
Теперь, в основном методе main, "поставьте" новый автомобиль в ваш виртуальный автосалон, то есть создайте объект класса Car. Присвойте этому новому автомобилю конкретную марку и год выпуска, например, "Toyota" и 2022. После этого выведите на экран информацию о марке и годе выпуска этого автомобиля, чтобы подтвердить, что данные успешно внесены.

Требования:
•	В программе должен быть объявлен класс с именем Car.
•	В классе Car должны быть объявлены два публичных поля: строковое поле carBrand и целочисленное поле productionYear.
•	В методе main должен быть создан объект класса Car.
•	Поля carBrand и productionYear у созданного объекта должны быть заполнены конкретными значениями, например, "Toyota" и 2022.
•	В методе main должна быть выведена на экран информация о марке и годе выпуска автомобиля, используя значения полей объекта Car.

public class Solution {
    public static void main(String[] args) {
        // Создаем новый автомобиль и заполняем его данные
        Car newCar = new Car(); // объект нашей "картотеки"
        newCar.carBrand = "Toyota";       // марка автомобиля
        newCar.productionYear = 2022;     // год выпуска

        // Выводим информацию, чтобы убедиться, что данные внесены
        System.out.println("Марка: " + newCar.carBrand);
        System.out.println("Год выпуска: " + newCar.productionYear);
    }
}

 */

public class Solution {
    public static void main(String[] args) {
        // Создаем новый автомобиль и заполняем его данные
        Car newCar = new Car(); // объект нашей "картотеки"
        newCar.carBrand = "Toyota";       // марка автомобиля
        newCar.productionYear = 2022;     // год выпуска

        // Выводим информацию, чтобы убедиться, что данные внесены
        System.out.println("Марка: " + newCar.carBrand);
        System.out.println("Год выпуска: " + newCar.productionYear);
    }
}

class Car {
    public String carBrand;
    public int productionYear;

}

/*
public class Solution {
    public static void main(String[] args) {
        // Создаем новый автомобиль и заполняем его данные
        Car newCar = new Car(); // объект нашей "картотеки"
        newCar.carBrand = "Toyota";       // марка автомобиля
        newCar.productionYear = 2022;     // год выпуска

        // Выводим информацию, чтобы убедиться, что данные внесены
        System.out.println("Марка: " + newCar.carBrand);
        System.out.println("Год выпуска: " + newCar.productionYear);
    }
}

// Класс-модель автомобиля с публичными полями
class Car {
    public String carBrand;     // название марки
    public int productionYear;  // год выпуска
}
 */