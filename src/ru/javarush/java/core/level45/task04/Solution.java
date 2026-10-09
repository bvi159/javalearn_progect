package ru.javarush.java.core.level45.task04;

/*
Личный помощник по покупкам: сохранение недельного плана
Представьте, что вы — личный помощник по покупкам, и ваша задача — помочь пользователю упорядочить и сохранить его планы на покупки на целую неделю. Каждый день — новый набор необходимостей, и вы хотите хранить их отдельно, но в рамках одного большого плана.

Начните с создания основного списка, который будет содержать внутри себя другие списки. Каждый из этих вложенных списков будет представлять собой список покупок на конкретный день, состоящий из текстовых наименований товаров. Например, это может быть List<List<String>> weeklyShoppingLists. Заполните этот weeklyShoppingLists несколькими вложенными списками, каждый из которых содержит несколько произвольных наименований товаров – например, "молоко", "хлеб" для понедельника, "яблоки", "сыр" для вторника и так далее.

Теперь, чтобы сохранить этот тщательно составленный недельный план, сериализуйте weeklyShoppingLists в файл. Представьте, что это "сохранение" плана перед тем, как пользователь уходит из приложения.

Затем, когда пользователь "открывает" приложение снова, десериализуйте основной список обратно из файла. Чтобы убедиться, что все ваши планы успешно восстановлены и ничто не потерялось, пройдитесь по каждому вложенному списку (каждому дневному списку покупок) и выведите на экран все его элементы в отдельной строке. Это покажет, что сложные, многоуровневые структуры данных могут быть успешно сохранены и восстановлены с помощью сериализации.

Требования:
•	Необходимо создать переменную weeklyShoppingLists типа List<List<String>>, где каждый вложенный список содержит строки-названия товаров для отдельного дня недели.
•	weeklyShoppingLists должен быть заполнен несколькими вложенными списками, каждый из которых содержит не менее двух произвольных наименований товаров.
•	weeklyShoppingLists должен быть сериализован в файл с помощью стандартных средств сериализации Java (например, ObjectOutputStream).
•	После сериализации weeklyShoppingLists должен быть считан обратно из файла с помощью ObjectInputStream.
•	После десериализации структура weeklyShoppingLists должна сохранять все вложенные списки и их содержимое в неизменном виде.
•	После десериализации необходимо пройтись по каждому вложенному списку weeklyShoppingLists и вывести его элементы в отдельной строке.
•	Все используемые коллекции (ArrayList или другие реализации List) должны поддерживать интерфейс Serializable для успешной сериализации.
•	В коде должна быть предусмотрена обработка возможных исключений, связанных с сериализацией и десериализацией (например, IOException, ClassNotFoundException).

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        // 1) Объявляем generics-структуру: список списков строк (товары по дням недели)
        List<List<String>> weeklyShoppingLists = new ArrayList<>();

        // 2) Заполняем "неделю": каждый вложенный список — это покупки на конкретный день
        // Используем ArrayList, т.к. он Serializable (важно для сериализации)
        List<String> monday = new ArrayList<>();
        monday.add("молоко");
        monday.add("хлеб");

        List<String> tuesday = new ArrayList<>();
        tuesday.add("яблоки");
        tuesday.add("сыр");

        List<String> wednesday = new ArrayList<>();
        wednesday.add("курица");
        wednesday.add("рис");

        List<String> thursday = new ArrayList<>();
        thursday.add("кофе");
        thursday.add("печенье");

        List<String> friday = new ArrayList<>();
        friday.add("овсянка");
        friday.add("бананы");

        List<String> saturday = new ArrayList<>();
        saturday.add("сок");
        saturday.add("шоколад");

        List<String> sunday = new ArrayList<>();
        sunday.add("рыба");
        sunday.add("овощи");

        // Добавляем все дни в общий план недели
        weeklyShoppingLists.add(monday);
        weeklyShoppingLists.add(tuesday);
        weeklyShoppingLists.add(wednesday);
        weeklyShoppingLists.add(thursday);
        weeklyShoppingLists.add(friday);
        weeklyShoppingLists.add(saturday);
        weeklyShoppingLists.add(sunday);

        // 3) Сериализуем коллекцию в файл


        // 4) Десериализуем коллекцию обратно из файла


        // 5) Проходим по каждому вложенному списку и выводим его элементы в отдельной строке

    }
}

 */

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        // 1) Объявляем generics-структуру: список списков строк (товары по дням недели)
        List<List<String>> weeklyShoppingLists = new ArrayList<>();

        // 2) Заполняем "неделю": каждый вложенный список — это покупки на конкретный день
        // Используем ArrayList, т.к. он Serializable (важно для сериализации)
        List<String> monday = new ArrayList<>();
        monday.add("молоко");
        monday.add("хлеб");

        List<String> tuesday = new ArrayList<>();
        tuesday.add("яблоки");
        tuesday.add("сыр");

        List<String> wednesday = new ArrayList<>();
        wednesday.add("курица");
        wednesday.add("рис");

        List<String> thursday = new ArrayList<>();
        thursday.add("кофе");
        thursday.add("печенье");

        List<String> friday = new ArrayList<>();
        friday.add("овсянка");
        friday.add("бананы");

        List<String> saturday = new ArrayList<>();
        saturday.add("сок");
        saturday.add("шоколад");

        List<String> sunday = new ArrayList<>();
        sunday.add("рыба");
        sunday.add("овощи");

        // Добавляем все дни в общий план недели
        weeklyShoppingLists.add(monday);
        weeklyShoppingLists.add(tuesday);
        weeklyShoppingLists.add(wednesday);
        weeklyShoppingLists.add(thursday);
        weeklyShoppingLists.add(friday);
        weeklyShoppingLists.add(saturday);
        weeklyShoppingLists.add(sunday);

        // 3) Сериализуем коллекцию в файл
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("shopping.ser"));
        oos.writeObject(weeklyShoppingLists);
        oos.close();

        // 4) Десериализуем коллекцию обратно из файла
        List<List<String>> resList;
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("shopping.ser"));
        resList = (List<List<String>>) ois.readObject();
        ois.close();

        // 5) Проходим по каждому вложенному списку и выводим его элементы в отдельной строке

        for (var out : resList) {
//            for (String b : out) {
//                System.out.println(b);
//            }
            System.out.println(out);
        }

    }
}

/*
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        // 1) Объявляем generics-структуру: список списков строк (товары по дням недели)
        List<List<String>> weeklyShoppingLists = new ArrayList<>();

        // 2) Заполняем "неделю": каждый вложенный список — это покупки на конкретный день
        // Используем ArrayList, т.к. он Serializable (важно для сериализации)
        List<String> monday = new ArrayList<>();
        monday.add("молоко");
        monday.add("хлеб");

        List<String> tuesday = new ArrayList<>();
        tuesday.add("яблоки");
        tuesday.add("сыр");

        List<String> wednesday = new ArrayList<>();
        wednesday.add("курица");
        wednesday.add("рис");

        List<String> thursday = new ArrayList<>();
        thursday.add("кофе");
        thursday.add("печенье");

        List<String> friday = new ArrayList<>();
        friday.add("овсянка");
        friday.add("бананы");

        List<String> saturday = new ArrayList<>();
        saturday.add("сок");
        saturday.add("шоколад");

        List<String> sunday = new ArrayList<>();
        sunday.add("рыба");
        sunday.add("овощи");

        // Добавляем все дни в общий план недели
        weeklyShoppingLists.add(monday);
        weeklyShoppingLists.add(tuesday);
        weeklyShoppingLists.add(wednesday);
        weeklyShoppingLists.add(thursday);
        weeklyShoppingLists.add(friday);
        weeklyShoppingLists.add(saturday);
        weeklyShoppingLists.add(sunday);

        // 3) Сериализуем коллекцию в файл
        String fileName = "weeklyShoppingLists.bin";
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName))) {
            out.writeObject(weeklyShoppingLists); // Сохраняем всю структуру целиком
        } catch (IOException e) {
            // Простейшая обработка исключений ввода-вывода
            System.out.println("Ошибка при сериализации: " + e.getMessage());
            return;
        }

        // 4) Десериализуем коллекцию обратно из файла
        List<List<String>> restored;
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName))) {
            // При чтении из ObjectInputStream возвращается Object, выполняем безопасное приведение.
            // Предупреждение компилятора подавляем, так как тип известен по логике: мы сами писали этот объект.
            @SuppressWarnings("unchecked")
            List<List<String>> tmp = (List<List<String>>) in.readObject();
            restored = tmp;
        } catch (IOException | ClassNotFoundException e) {
            // Обрабатываем как ошибки IO, так и отсутствие класса при чтении
            System.out.println("Ошибка при десериализации: " + e.getMessage());
            return;
        }

        // 5) Проходим по каждому вложенному списку и выводим его элементы в отдельной строке
        for (List<String> dayList : restored) {
            // String.join печатает элементы через разделитель ", "
            System.out.println(String.join(", ", dayList));
        }
    }
}

 */