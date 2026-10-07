package ru.javarush.java.core.level44.task04;
/*
Управление ассортиментом гипермаркета: иерархия и коллекции товаров 🏪
Вы — главный разработчик системы управления инвентарем для огромного розничного гипермаркета. В этом магазине продаются самые разнообразные товары: от свежих продуктов питания до высокотехнологичной электроники. Каждый тип товара имеет свои уникальные характеристики (например, калории для еды или срок гарантии для техники), и все товары должны быть аккуратно организованы по категориям. Чтобы каталог товаров мог быть сохранен и загружен без проблем, вам необходимо эффективно сериализовать его.

Сначала определите фундамент вашей системы: создайте абстрактный класс Product с основным полем name типа String. Естественно, Product должен быть Serializable. Затем создайте двух наследников этого класса: FoodProduct, который будет содержать дополнительное поле calories типа int, и TechProduct с полем warrantyMonths типа int. Оба наследника, конечно, также должны быть Serializable.

Теперь пришло время создать "сердце" вашего каталога: класс Store. Этот класс будет хранить весь ассортимент в поле products, которое должно представлять собой Map<String, List<Product>>. Здесь ключ карты — это название категории товара (например, "Food" или "Tech"), а значение — список всех продуктов, относящихся к этой категории.

В методе main создайте экземпляр Store. Заполните его каталог, добавив как минимум две категории. В каждой категории создайте по одному продукту соответствующего типа (например, один FoodProduct в категории "Food" и один TechProduct в категории "Tech"). После этого, чтобы сохранить всю информацию о вашем гипермаркете, сериализуйте объект Store в файл с именем "store.ser". И, наконец, чтобы убедиться, что ни один товар не потерялся, десериализуйте его обратно из файла. В заключение, пройдитесь по всем категориям и для каждой из них выведите на экран имена и типы всех продуктов, подтверждая, что вся сложная иерархия и коллекция успешно сохранена и восстановлена.

Требования:
•	Необходимо создать абстрактный класс Product с полем name типа String.
•	Класс Product должен реализовывать интерфейс Serializable.
•	Необходимо создать два класса-наследника Product: FoodProduct с дополнительным полем calories типа int и TechProduct с полем warrantyMonths типа int.
•	Классы FoodProduct и TechProduct также должны реализовывать интерфейс Serializable.
•	Класс Store должен содержать поле products типа Map<String, List<Product>>, где ключ — название категории, а значение — список продуктов этой категории.
•	В методе main необходимо создать экземпляр Store, добавить как минимум две категории, и в каждую категорию по одному продукту соответствующего типа.
•	В методе main необходимо сериализовать объект Store в файл с именем "store.ser".
•	В методе main необходимо десериализовать объект Store из файла "store.ser".
•	После десериализации требуется пройтись по всем категориям и вывести на экран имена и типы всех продуктов в каждой категории.

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution_0 {
    public static void main(String[] args) {
        // 1) Создаём магазин и наполняем как минимум двумя категориями и по одному товару в каждой.
        Store store = new Store();
        store.addProduct("Food", new FoodProduct("Яблоко", 52));
        store.addProduct("Tech", new TechProduct("Смартфон", 24));

        // 2) Сериализуем магазин в файл "store.ser".
        // Используем try-with-resources, чтобы потоки закрылись автоматически.
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("store.ser"))) {
            out.writeObject(store);
        } catch (IOException e) {
            // В учебной задаче — простое сообщение об ошибке.
            System.out.println("Ошибка сериализации: " + e.getMessage());
            return;
        }

        // 3) Десериализуем магазин из файла "store.ser".
        Store restored;
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("store.ser"))) {
            restored = (Store) in.readObject(); // Читаем обратно объект Store
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Ошибка десериализации: " + e.getMessage());
            return;
        }

        // 4) Проходим по всем категориям и выводим имена и типы всех товаров.
        for (Map.Entry<String, List<Product>> entry : restored.getProducts().entrySet()) {
            String category = entry.getKey();
            System.out.println("Категория: " + category);
            for (Product p : entry.getValue()) {
                // getClass().getSimpleName() выводит конкретный тип товара (FoodProduct/TechProduct).
                System.out.println(" - " + p.getName() + " [" + p.getClass().getSimpleName() + "]");
            }
        }
    }
}


 */

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        // 1) Создаём магазин и наполняем как минимум двумя категориями и по одному товару в каждой.
        Store store = new Store();
        store.addProduct("Food", new FoodProduct("Яблоко", 52));
        store.addProduct("Tech", new TechProduct("Смартфон", 24));

        // 2) Сериализуем магазин в файл "store.ser".
        // Используем try-with-resources, чтобы потоки закрылись автоматически.
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("store.ser"))) {
            out.writeObject(store);
        } catch (IOException e) {
            // В учебной задаче — простое сообщение об ошибке.
            System.out.println("Ошибка сериализации: " + e.getMessage());
            return;
        }

        // 3) Десериализуем магазин из файла "store.ser".
        Store restored;
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("store.ser"))) {
            restored = (Store) in.readObject(); // Читаем обратно объект Store
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Ошибка десериализации: " + e.getMessage());
            return;
        }

        // 4) Проходим по всем категориям и выводим имена и типы всех товаров.
        for (Map.Entry<String, List<Product>> entry : restored.getProducts().entrySet()) {
            String category = entry.getKey();
            System.out.println("Категория: " + category);
            for (Product p : entry.getValue()) {
                // getClass().getSimpleName() выводит конкретный тип товара (FoodProduct/TechProduct).
                System.out.println(" - " + p.getName() + " [" + p.getClass().getSimpleName() + "]");
            }
        }
    }
}

abstract class Product implements Serializable {
    String name;

    Product(String n) {
        this.name = n;
    }

    public String getName() {
        return name;
    }
}

class FoodProduct extends Product {
    int calories;

    FoodProduct(String n, int cal) {
        super(n);
        this.calories = cal;
    }
}

class TechProduct extends Product {
    int warrantyMonths;

    TechProduct(String n, int warrant) {
        super(n);
        this.warrantyMonths = warrant;
    }
}

class Store implements Serializable {
    Map<String, List<Product>> products = new HashMap<>();

    public void addProduct(String category, Product product) {
        products.computeIfAbsent(category, k -> new ArrayList<>()).add(product);
    }

    public Map<String, List<Product>> getProducts() {
        return products;
    }
}

/*

// Абстрактный базовый класс для всех товаров.
// Реализует Serializable, чтобы экземпляры можно было записывать/читать из файла.
abstract class Product implements Serializable {
    private final String name;

    public Product(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

// Товар категории "Еда" с дополнительным полем калорий.
// Явно реализуем Serializable, как требует задание (хотя это уже наследуется от Product).
class FoodProduct extends Product implements Serializable {
    private final int calories;

    public FoodProduct(String name, int calories) {
        super(name);
        this.calories = calories;
    }

    public int getCalories() {
        return calories;
    }
}

// Товар категории "Техника" с полем месяцев гарантии.
// Также явно реализуем Serializable.
class TechProduct extends Product implements Serializable {
    private final int warrantyMonths;

    public TechProduct(String name, int warrantyMonths) {
        super(name);
        this.warrantyMonths = warrantyMonths;
    }

    public int getWarrantyMonths() {
        return warrantyMonths;
    }
}

// "Сердце" каталога — магазин с коллекцией товаров по категориям.
// Поле products: ключ — название категории, значение — список товаров этой категории.
class Store implements Serializable {
    private final Map<String, List<Product>> products = new HashMap<>();

    // Удобный метод для добавления товара в нужную категорию.
    public void addProduct(String category, Product product) {
        // Если категории ещё нет, создаём новый список (computeIfAbsent делает это компактно).
        products.computeIfAbsent(category, k -> new ArrayList<>()).add(product);
    }

    public Map<String, List<Product>> getProducts() {
        return products;
    }
}

public class Solution {
    public static void main(String[] args) {
        // 1) Создаём магазин и наполняем как минимум двумя категориями и по одному товару в каждой.
        Store store = new Store();
        store.addProduct("Food", new FoodProduct("Яблоко", 52));
        store.addProduct("Tech", new TechProduct("Смартфон", 24));

        // 2) Сериализуем магазин в файл "store.ser".
        // Используем try-with-resources, чтобы потоки закрылись автоматически.
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("store.ser"))) {
            out.writeObject(store);
        } catch (IOException e) {
            // В учебной задаче — простое сообщение об ошибке.
            System.out.println("Ошибка сериализации: " + e.getMessage());
            return;
        }

        // 3) Десериализуем магазин из файла "store.ser".
        Store restored;
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("store.ser"))) {
            restored = (Store) in.readObject(); // Читаем обратно объект Store
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Ошибка десериализации: " + e.getMessage());
            return;
        }

        // 4) Проходим по всем категориям и выводим имена и типы всех товаров.
        for (Map.Entry<String, List<Product>> entry : restored.getProducts().entrySet()) {
            String category = entry.getKey();
            System.out.println("Категория: " + category);
            for (Product p : entry.getValue()) {
                // getClass().getSimpleName() выводит конкретный тип товара (FoodProduct/TechProduct).
                System.out.println(" - " + p.getName() + " [" + p.getClass().getSimpleName() + "]");
            }
        }
    }
}

 */