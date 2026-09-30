package ru.javarush.java.core.level42.task02;
/*
Извлечение файла из ZIP-архива
Ваша миссия продолжается! Теперь вам нужно извлечь то самое сверхсекретное послание, которое вы упаковали в архив.

Реализуйте программу, которая "вскроет" архив "hello.zip", найдёт внутри него файл "hello.txt" и аккуратно извлечёт его содержимое, сохранив его в обычный текстовый файл "output.txt" в текущей директории.

Используйте ZipInputStream, чтобы безопасно получить доступ к вашей ценной информации.

Требования:
•	Программа должна использовать класс ZipInputStream для работы с ZIP-архивом.
•	Программа должна открывать архив с именем "hello.zip" в текущей директории.
•	Программа должна находить внутри архива файл с именем "hello.txt".
•	Программа должна извлекать содержимое файла "hello.txt" из архива.
•	Извлечённое содержимое должно быть сохранено в файл "output.txt" в текущей директории.
•	Все потоки ввода/вывода должны быть корректно закрыты после завершения работы.

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class Solution {
    public static void main(String[] args) throws IOException {
        // Открываем ZIP-архив "hello.zip" из текущей директории
        // try-with-resources гарантирует корректное закрытие потока

        ZipEntry entry;
        boolean extracted = false;

        // Перебираем все записи внутри архива

        String name = entry.getName();

        // Ищем файл "hello.txt" (игнорируем директории)

        // Создаем выходной файл "output.txt" в текущей директории
        // Поток также будет закрыт автоматически

        byte[] buffer = new byte[8192];
        int read;
        // Копируем данные из текущей записи ZIP в обычный файл




        // Закрываем текущую запись архива и выходим — файл найден и извлечен





        // Переходим к следующей записи



        // Небольшое сообщение, если файл не найден (для наглядности)


    }
}

 */

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class Solution {
    public static void main(String[] args) throws IOException {
        // Открываем ZIP-архив "hello.zip" из текущей директории
        // try-with-resources гарантирует корректное закрытие потока
        try (ZipInputStream zis = new ZipInputStream(new FileInputStream("hello.zip"))) {

            ZipEntry entry;
            boolean extracted = false;


            // Перебираем все записи внутри архива
            while ((entry = zis.getNextEntry()) != null) {
                String name = entry.getName();

                // Игнорируем директории: у записей-папок имя заканчивается на "/"
                if (entry.isDirectory()) {
                    zis.closeEntry();
                    continue;
                }

                // Ищем hello.txt
                if (name.equals("hello.txt")) {
                    // нашли — извлекаем
                    try (OutputStream out = Files.newOutputStream(Paths.get("output.txt"))) {
                        byte[] buffer = new byte[8192];
                        int read;
                        while ((read = zis.read(buffer)) != -1) {
                            out.write(buffer, 0, read);
                        }
                    }
                    break; // выходим из цикла — файл найден
                }

                zis.closeEntry();
            }


            // Небольшое сообщение, если файл не найден (для наглядности)
            System.out.println("Файл не найден!");
        }

        //Пример из следующей лекции
        User user = new User("Bob", 22);

        // Сериализация
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("user.ser"))) {
            oos.writeObject(user);
            System.out.println("Сериализация завершена!");
        } catch (IOException e) {
            System.out.println("Ошибка сериализации: " + e.getMessage());
        }

        // Десериализация
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("user.ser"))) {
            User loaded = (User) ois.readObject();
            System.out.println("Десериализация завершена! " + loaded);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Ошибка десериализации: " + e.getMessage());
        }

    }

}

// то же для примера из следующей лекции
class User implements Serializable {
    private String name;
    private int age;

    // Конструктор, геттеры и сеттеры
    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Для красоты: метод toString()
    @Override
    public String toString() {
        return "User{name='" + name + "', age=" + age + "}";
    }
}
/*
public class Solution {
    public static void main(String[] args) throws IOException {
        // Открываем ZIP-архив "hello.zip" из текущей директории
        // try-with-resources гарантирует корректное закрытие потока
        try (ZipInputStream zip = new ZipInputStream(new FileInputStream("hello.zip"))) {

            ZipEntry entry;
            boolean extracted = false;

            // Перебираем все записи внутри архива
            while ((entry = zip.getNextEntry()) != null) {
                String name = entry.getName();

                // Ищем файл "hello.txt" (игнорируем директории)
                if (!entry.isDirectory() && ("hello.txt".equals(name) || name.endsWith("/hello.txt"))) {
                    // Создаем выходной файл "output.txt" в текущей директории
                    // Поток также будет закрыт автоматически
                    try (FileOutputStream out = new FileOutputStream("output.txt")) {
                        byte[] buffer = new byte[8192];
                        int read;
                        // Копируем данные из текущей записи ZIP в обычный файл
                        while ((read = zip.read(buffer)) != -1) {
                            out.write(buffer, 0, read);
                        }
                    }

                    // Закрываем текущую запись архива и выходим — файл найден и извлечен
                    zip.closeEntry();
                    extracted = true;
                    break;
                }

                // Переходим к следующей записи
                zip.closeEntry();
            }

            // Небольшое сообщение, если файл не найден (для наглядности)
            if (!extracted) {
                System.out.println("Файл 'hello.txt' не найден в архиве 'hello.zip'.");
            }
        }
    }
}
 */