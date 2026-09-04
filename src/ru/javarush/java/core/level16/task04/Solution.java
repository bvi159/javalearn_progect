package ru.javarush.java.core.level16.task04;
/*

Умный дом: адресация помещений 🏠

Вы создаёте сложную систему управления умным домом, которая должна чётко различать общий адрес дома и уникальный идентификатор каждой комнаты внутри него. Представьте, что адрес дома — это широкое понятие, а адрес комнаты — это её собственный, уникальный "адрес" в пределах дома, например, "Гостиная" или "Кабинет".
Создайте класс House с приватным строковым полем houseAddress, которое будет инициализироваться через конструктор. Внутри класса House объявите внутренний класс Room. Класс Room также должен иметь приватное строковое поле roomIdentifier, которое инициализируется через конструктор Room. В классе Room реализуйте метод printAddresses(). Этот метод должен выводить две строки: сначала уникальный идентификатор комнаты (обращаясь к this.roomIdentifier), а затем общий адрес дома (используя House.this.houseAddress).
В методе main вашей программы создайте объект House с адресом "Sunny Valley Lane". Затем, через этот House, создайте объект Room с идентификатором "Master Bedroom" и вызовите метод printAddresses(). Ваша программа должна последовательно показать оба "адреса", подтверждая, что система умного дома успешно различает их.

Требования:
•	Необходимо создать класс с именем House.
•	В классе House должно быть приватное строковое поле houseAddress.
•	Поле houseAddress должно инициализироваться через конструктор класса House.
•	Внутри класса House требуется объявить внутренний (non-static inner) класс Room.
•	В классе Room должно быть приватное строковое поле roomIdentifier.
•	Поле roomIdentifier должно инициализироваться через конструктор класса Room.
•	В классе Room необходимо реализовать метод printAddresses(), который выводит две строки: сначала значение roomIdentifier, затем значение houseAddress родительского объекта House.
•	В методе main нужно создать объект House с адресом "Sunny Valley Lane", затем через него создать объект Room с идентификатором "Master Bedroom" и вызвать у него метод printAddresses().

public class Solution {
    public static void main(String[] args) {
        // Создаём дом с общим адресом
        House house = new House("Sunny Valley Lane");

        // Через объект внешнего класса создаём объект внутреннего класса.
        // Синтаксис house.new Room(...) обязателен для non-static inner класса.
        House.Room room = house.new Room("Master Bedroom");

        // Выводим идентификатор комнаты и общий адрес дома
        room.printAddresses();
    }
}

 */

public class Solution {
    public static void main(String[] args) {
        // Создаём дом с общим адресом
        House house = new House("Sunny Valley Lane");

        // Через объект внешнего класса создаём объект внутреннего класса.
        // Синтаксис house.new Room(...) обязателен для non-static inner класса.
        House.Room room = house.new Room("Master Bedroom");

        // Выводим идентификатор комнаты и общий адрес дома
        room.printAddresses();
    }
}

class House {
    private String houseAddress;

    House(String adress){
        this.houseAddress = adress;
    }

    class Room {
        private String roomIdentifier;

        Room(String identifier){
            this.roomIdentifier = identifier;
        }

        void printAddresses(){
            System.out.println(this.roomIdentifier);
            System.out.println(House.this.houseAddress);
        }

    }

}

/*
// Класс House — внешний класс
class House {
    private String houseAddress; // приватный адрес дома

    // Инициализация адреса дома через конструктор
    public House(String houseAddress) {
        this.houseAddress = houseAddress;
    }

    // Нестатический внутренний класс Room: принадлежит конкретному объекту House
    class Room {
        private String roomIdentifier; // приватный идентификатор комнаты

        // Инициализация идентификатора комнаты через конструктор
        public Room(String roomIdentifier) {
            this.roomIdentifier = roomIdentifier;
        }

        // Выводим: сначала идентификатор комнаты, затем адрес дома
        public void printAddresses() {
            // this — ссылка на текущую комнату
            System.out.println(this.roomIdentifier);
            // Обращаемся к полю внешнего объекта через House.this
            System.out.println(House.this.houseAddress);
        }
    }
}
 */
