package com.javarush.task.task24.task2406;

import com.javarush.task.task24.task2406.Solution.Building.Apartments;

import java.math.BigDecimal;

/* 
Наследование от внутреннего класса
Внутри класса Solution создай 2 внутренних public класса Apt3Bedroom, BigHall.
Унаследуй их от Apartments и Hall.

Требования:
•	Класс Apt3Bedroom должен быть создан внутри класса Solution.
•	Класс BigHall должен быть создан внутри класса Solution.
•	Класс Apt3Bedroom должен быть публичным.
•	Класс BigHall должен быть публичным.
•	Класс Apt3Bedroom должен быть потомком класса Building.Apartments.
•	Класс BigHall должен быть потомком класса Building.Hall.

public class Solution {
    public class Building {
        public class Hall {
            private BigDecimal square;

            public Hall(BigDecimal square) {
                this.square = square;
            }
        }

        public class Apartments {
        }
    }

    public class Apt3Bedroom extends Building.Apartments {
        public Apt3Bedroom(Building building) {
            building.super();
        }
    }

    public class BigHall extends Building.Hall {
        public BigHall(Building building, BigDecimal square) {
            building.super(square);
        }
    }

    public static void main(String[] args) {

    }
}

*/

public class Solution {
     public class Building {
        public class Hall {
            private BigDecimal square;

            public Hall(BigDecimal square) {
                this.square = square;
            }
        }

        public class Apartments {
            private int aprtNumbres;
            public Apartments(int aprtNumbres) {
                this.aprtNumbres = aprtNumbres;
            }
        }
    }



    //----------Моё
    //----------Исправленные классы
    public class Apt3Bedroom extends Building.Apartments {
        public Apt3Bedroom(Building building, int apartmentNumbers) {
            building.super(apartmentNumbers);
        }
    }

    public class BigHall extends Building.Hall {
        public BigHall(Building building, BigDecimal square) {
            building.super(square);
        }
    }

    public static void main(String[] args) {

    }
}
/* это из следующей лекции просто отфармаировано.
class Car {
    public ArrayList<Car> createPoliceCars(int count) {
        ArrayList<Car> result = new ArrayList<Car>();
        for(int i=0; i<count; i++) {
            final int number = i;
            result.add(new Car(){
                    int policeNumber = number;
            });
        }
        return result;
    }
}
*/
/*
public class Solution {
    public class Building {
        public class Hall {
            private BigDecimal square;

            public Hall(BigDecimal square) {
                this.square = square;
            }
        }

        public class Apartments {
        }
    }

    public static void main(String[] args) {

    }
}

 */