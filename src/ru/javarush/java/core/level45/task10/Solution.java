package ru.javarush.java.core.level45.task10;
/*
Разработчик игры: оценка производительности сохранения инвентаря
Представьте, что вы — разработчик видеоигры, и вам предстоит сохранить огромный инвентарь игрока, состоящий из тысяч уникальных предметов. Вы хотите быть уверены, что процесс сохранения не займёт вечность и не испортит игровой опыт пользователя.

Для начала, создайте класс GameItem, который будет представлять собой один предмет инвентаря. Он должен быть Serializable и иметь два поля: itemId типа int для уникального идентификатора и itemName типа String для названия предмета.

Затем создайте огромный список playerInventory, который будет содержать 10 000 объектов GameItem. Важно, чтобы каждый предмет в этом списке имел уникальные значения itemId и itemName – это имитирует реалистичный игровой инвентарь.

Теперь самое интересное: вам нужно сериализовать этот playerInventory в файл с именем "items.bin". Для оптимизации производительности при работе с большим объёмом данных обязательно используйте BufferedOutputStream в сочетании с ObjectOutputStream.

Во время процесса сериализации, вам необходимо измерить, сколько времени это занимает. Для точного измерения используйте System.nanoTime() до и после операции записи. Затем преобразуйте полученное значение в миллисекунды и выведите его на экран. Это позволит вам оценить производительность сохранения большого объёма игровых данных и убедиться, что ваша система эффективно справляется с нагрузкой.

Требования:
•	Класс GameItem обязан реализовывать интерфейс Serializable для поддержки сериализации.
•	Класс GameItem должен содержать два поля: itemId типа int и itemName типа String.
•	Список playerInventory должен содержать 10 000 объектов GameItem, причём значения itemId и itemName у каждого объекта должны быть уникальными.
•	Для хранения инвентаря игрока необходимо использовать коллекцию типа List<GameItem>.
•	Для записи playerInventory в файл "items.bin" необходимо использовать ObjectOutputStream, обёрнутый в BufferedOutputStream.
•	Время сериализации должно измеряться с помощью System.nanoTime() непосредственно до и после записи playerInventory в файл.
•	Разница между двумя значениями System.nanoTime() должна быть преобразована в миллисекунды.
•	Полученное время сериализации в миллисекундах должно быть выведено на экран.

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        // Создаем список инвентаря игрока на 10 000 предметов
        List<GameItem> playerInventory = new ArrayList<>(10_000);

        // Заполняем инвентарь уникальными предметами (уникальные itemId и itemName)
        for (int i = 1; i <= 10_000; i++) {
            playerInventory.add(new GameItem(i, "Item-" + i));
        }

        // Сериализуем список в файл "items.bin" с использованием буферизации для повышения производительности


    }
}

// Класс предмета инвентаря. Должен быть сериализуемым.
class GameItem implements Serializable {
    // Поля по условию: уникальный идентификатор и имя предмета
    int itemId;
    String itemName;

    GameItem(int itemId, String itemName) {
        this.itemId = itemId;
        this.itemName = itemName;
    }
}

 */

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException {
        // Создаем список инвентаря игрока на 10 000 предметов
        List<GameItem> playerInventory = new ArrayList<>(10_000);

        // Заполняем инвентарь уникальными предметами (уникальные itemId и itemName)
        for (int i = 1; i <= 10_000; i++) {
            playerInventory.add(new GameItem(i, "Item-" + i));
        }
        long begin;
        long end;
        // Сериализуем список в файл "items.bin" с использованием буферизации для повышения производительности
        try (ObjectOutputStream oos = new ObjectOutputStream(
                new BufferedOutputStream(new FileOutputStream("items.bin")))) {
            begin = System.nanoTime();
            oos.writeObject(playerInventory);
            end = System.nanoTime();
        }

        System.out.println("Сериализация 10_000 предметов заняло " + (end - begin) / 1_000_000 + " мс");
        System.out.println("1 миллисекунда = 1_000_000 наносекунд");
    }
}

// Класс предмета инвентаря. Должен быть сериализуемым.
class GameItem implements Serializable {
    // Поля по условию: уникальный идентификатор и имя предмета
    int itemId;
    String itemName;

    GameItem(int itemId, String itemName) {
        this.itemId = itemId;
        this.itemName = itemName;
    }
}
/*
public class Solution {
    public static void main(String[] args) {
        // Создаем список инвентаря игрока на 10 000 предметов
        List<GameItem> playerInventory = new ArrayList<>(10_000);

        // Заполняем инвентарь уникальными предметами (уникальные itemId и itemName)
        for (int i = 1; i <= 10_000; i++) {
            playerInventory.add(new GameItem(i, "Item-" + i));
        }

        // Сериализуем список в файл "items.bin" с использованием буферизации для повышения производительности
        try (ObjectOutputStream oos = new ObjectOutputStream(
                new BufferedOutputStream(new FileOutputStream("items.bin")))) {

            // Измеряем время сериализации строго вокруг операции записи
            long start = System.nanoTime();           // до записи
            oos.writeObject(playerInventory);         // запись большого списка объектов
            oos.flush();                               // принудительно выталкиваем буфер в файл
            long end = System.nanoTime();             // после записи

            // Переводим наносекунды в миллисекунды
            double millis = (end - start) / 1_000_000.0;

            // Выводим время сериализации на экран
            System.out.printf("Время сериализации: %.3f мс%n", millis);

        } catch (IOException e) {
            // Для учебной задачи просто выведем стек-трейс
            e.printStackTrace();
        }
    }
}

// Класс предмета инвентаря. Должен быть сериализуемым.
class GameItem implements Serializable {
    // Поля по условию: уникальный идентификатор и имя предмета
    int itemId;
    String itemName;

    GameItem(int itemId, String itemName) {
        this.itemId = itemId;
        this.itemName = itemName;
    }
}


 */