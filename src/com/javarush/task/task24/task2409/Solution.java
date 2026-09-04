package com.javarush.task.task24.task2409;

import java.util.List;

/* 
Интернет-магазин продажи джинсов
1. Создай 2 интерфейса в отдельных файлах:
1.1) Item с методами int getId(), double getPrice(), String getTM()
1.2) Jeans extends Item с методами int getLength() и int getSize()

2. В классе Util в методе getAllJeans добавь пропущенную часть java-кода:
2.1) разберись в том, что уже есть в методе getAllJeans класса Util
2.2) создай абстрактный class AbstractJeans от интерфейса Jeans с одним абстрактным методом, реализуй остальные методы
2.3) создай классы Levis и Denim от AbstractJeans, реализуй оставшийся метод
2.4) в классе AbstractJeans реализуй метод toString() (можешь воспользоваться Alt+Insert -> toString())
2.5) метод toString класса AbstractJeans должен начинаться с имени подкласса, например, Levis{id=1, length=34, size=6, price=150.0}

Требования:
•	Интерфейс Item должен быть создан в отдельном файле.
•	Интерфейс Jeans должен расширять интерфейс Item и быть создан в отдельном файле.
•	В интерфейсе Item должны присутствовать все методы перечисленные в условии.
•	В классе Jeans должны присутствовать все методы перечисленные в условии.
•	В методе getAllJeans класса Util должен быть создан локальный абстрактный класс AbstractJeans, поддерживающий интерфейс Jeans.
•	В методе getAllJeans класса Util должен быть создан локальный класс Levis, унаследованный от класса AbstractJeans.
•	В методе getAllJeans класса Util должен быть создан локальный класс Denim, унаследованный от класса AbstractJeans.
•	В классе AbstractJeans должен быть реализован метод toString(), начинающийся с имени подкласса.

public class Util {
    protected static Collection<Object[]> jeansArray = new LinkedList<>();

    static {
        jeansArray.add(new Object[]{1, Company.Levis, 34, 6, 150.0});
        jeansArray.add(new Object[]{2, Company.Denim, 35, 8, 154.0});
        jeansArray.add(new Object[]{3, Company.Colins, 32, 6, 120.0});
        jeansArray.add(new Object[]{4, Company.CalvinKleinJeans, 31, 8, 125.0});
    }

    public static List<Jeans> getAllJeans() {
        abstract class AbstractJeans implements Jeans {
            private int id;
            private int length;
            private int size;
            private double price;

            protected AbstractJeans(int id, int length, int size, double price) {
                this.id = id;
                this.length = length;
                this.size = size;
                this.price = price;
            }

            public abstract String getTM();

            public int getId() {
                return id;
            }

            public int getLength() {
                return length;
            }

            public int getSize() {
                return size;
            }

            public double getPrice() {
                return price;
            }

            @Override
            public String toString() {
                return getClass().getSimpleName() + "{" +
                        "id=" + id +
                        ", length=" + length +
                        ", size=" + size +
                        ", price=" + price +
                        '}';
            }
        }

        class Levis extends AbstractJeans {
            Levis(int id, int length, int size, double price) {
                super(id, length, size, price);
            }

            @Override
            public String getTM() {
                return "Levis";
            }
        }
        class Denim extends AbstractJeans {
            Denim(int id, int length, int size, double price) {
                super(id, length, size, price);
            }

            @Override
            public String getTM() {
                return "Denim";
            }
        }

        List<Jeans> allJeans = new LinkedList<>();

        for (Object[] obj : getJeansArray()) {
            int id = (int) obj[0];
            final Company company = (Company) obj[1];
            int length = (int) obj[2];
            int size = (int) obj[3];
            double price = (double) obj[4];

            Jeans jeans = null;
            if (Company.Levis == company) {
                jeans = new Levis(id, length, size, price);
            } else if (Company.Denim == company) {
                jeans = new Denim(id, length, size, price);
            } else {
                jeans = new AbstractJeans(id, length, size, price) {
                    @Override
                    public String getTM() {
                        return company.fullName;
                    }
                };
            }
            allJeans.add(jeans);
        }
        return allJeans;
    }

    public static Collection<Object[]> getJeansArray() {
        return jeansArray;
    }

    enum Company {
        Levis("Levi's"),
        Denim("Denim"),
        Colins("COLIN'S"),
        CalvinKleinJeans("Calvin Klein Jeans");

        final String fullName;

        Company(String name) {
            this.fullName = name;
        }
    }
}




*/

public class Solution {

    public static List<Jeans> allJeans = Util.getAllJeans();

    public static void main(String[] args) {
        for (Jeans jeans : allJeans) {
            System.out.println(jeans);
        }
    }

}

/*
class Car {
    public ArrayList<Car> createPoliceCars(int count) {
        ArrayList<Car> result = new ArrayList<Car>();
        for (int i = 0; i < count; i++) {
            final int number = i;
            result.add(new Car() {
                int policeNumber;

                {
                    policeNumber = number;
                }
            });
        }
        return result;
    }
}

 */

/*
class Car {
    public ArrayList<Car> createPoliceCars(int count) {
        ArrayList<Car> result = new ArrayList<Car>();
        for (int i = 0; i < count; i++) {
            final int number = i;
            result.add(new Car() {
                public String toString() {
                    return "" + number;
                }
            });
        }
        return result;
    }
}

class Car {
    public ArrayList<Car> createPoliceCars(int count) {
        ArrayList<Car> result = new ArrayList<Car>();
        for (int i = 0; i < count; i++) {
            final int number = i;
            result.add(new Anonymous2(number));
        }
        return result;
    }

    class Anonymous2 {
        final int number;

        Anonymous2(int number) {
            this.number = number;
        }

        public String toString() {
            return "" + number;
        }
    }
}
*/