package ru.javarush.java.core.level43.task09;
/*
Артефакты Чародея: Метка Версии для Сокровищ
Вы – великий чародей, отвечающий за инвентаризацию магических артефактов в вашей лавке "Зачарованный Эмпориум". Каждый артефакт (Product) имеет свое artifactName, и вам нужно убедиться, что даже если вы в будущем обновите свою систему инвентаризации, старые записи об артефактах останутся читаемыми и узнаваемыми. Для этого ваш класс Product должен быть Serializable.

Ваша магическая задача — явно обозначить каждый артефакт уникальной версией, чтобы система знала, как с ним обращаться. Добавьте в класс Product специальное поле private static final long serialVersionUID = 1L;. Это как магическая руна, указывающая на версию схемы сохранения. Затем напишите небольшое заклинание (код), которое создаст один из ваших артефактов, "законсервирует" его в магический фолиант (сериализует) и затем "вызовет" его обратно (десериализует). Ваша демонстрация будет успешной, если процесс сохранения и восстановления пройдет без единой ошибки, подтверждая, что ваша система распознает и корректно работает с помеченными артефактами.

Требования:
•	Класс Product должен реализовывать интерфейс Serializable.
•	В классе Product должно быть объявлено поле private static final long serialVersionUID со значением 1L.
•	Класс Product должен содержать поле artifactName.
•	В программе должен быть реализован код, который создает объект Product и сериализует его в файл с помощью ObjectOutputStream.
•	В программе должен быть реализован код, который десериализует объект Product из файла с помощью ObjectInputStream.
•	Процесс сериализации и десериализации объекта Product должен выполняться без ошибок.
•	serialVersionUID класса Product должен обеспечивать совместимость между сериализованными и десериализованными объектами.

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        // Создаем пример артефакта
        Product original = new Product("Кристалл Астрала");
        File file = new File("artifact.bin");

        // Сериализация: записываем объект в бинарный файл
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            oos.writeObject(original); // запись объекта в поток
            System.out.println("Сериализовано: " + original);
        } catch (IOException e) {
            System.out.println("Ошибка при сериализации: " + e.getMessage());
            return; // Если не удалось записать — дальше нет смысла продолжать
        }

        // Десериализация: читаем объект обратно из файла
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            // В реальных приложениях для безопасности стоит ограничивать допустимые типы через ObjectInputFilter
            Product restored = (Product) ois.readObject(); // чтение и приведение к нужному типу
            System.out.println("Десериализовано: " + restored);

            // Простая проверка корректности данных
            if (original.getArtifactName().equals(restored.getArtifactName())) {
                System.out.println("Успех: артефакт восстановлен корректно.");
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Ошибка при десериализации: " + e.getMessage());
        }
    }
}

 */

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        // Создаем пример артефакта
        Product original = new Product("Кристалл Астрала");
        File file = new File("artifact.bin");

        // Сериализация: записываем объект в бинарный файл
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            oos.writeObject(original); // запись объекта в поток
            System.out.println("Сериализовано: " + original);
        } catch (IOException e) {
            System.out.println("Ошибка при сериализации: " + e.getMessage());
            return; // Если не удалось записать — дальше нет смысла продолжать
        }

        // Десериализация: читаем объект обратно из файла
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            // В реальных приложениях для безопасности стоит ограничивать допустимые типы через ObjectInputFilter
            Product restored = (Product) ois.readObject(); // чтение и приведение к нужному типу
            System.out.println("Десериализовано: " + restored);

            // Простая проверка корректности данных
            if (original.getArtifactName().equals(restored.getArtifactName())) {
                System.out.println("Успех: артефакт восстановлен корректно.");
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Ошибка при десериализации: " + e.getMessage());
        }
    }
}

class Product implements Serializable {
    private String artifactName;
    private static final long serialVersionUID = 1L;

    public Product(String name) {
        this.artifactName = name;
    }

    public String getArtifactName() {
        return artifactName;
    }

    @Override
    public String toString() {
        return "Product{" +
                "artifactName='" + artifactName + '\'' +
                '}';
    }
}

/*

// Класс Product должен быть сериализуемым, чтобы его можно было "сохранить в файл" и восстановить
class Product implements Serializable {
    // Явная версия схемы сериализации — помогает сохранять совместимость при изменениях класса
    private static final long serialVersionUID = 1L;

    // Поле артефакта, которое будет сериализовано
    private final String artifactName;

    public Product(String artifactName) {
        this.artifactName = artifactName;
    }

    public String getArtifactName() {
        return artifactName;
    }

    @Override
    public String toString() {
        return "Product{artifactName='" + artifactName + "'}";
    }
}

public class Solution {
    public static void main(String[] args) {
        // Создаем пример артефакта
        Product original = new Product("Кристалл Астрала");
        File file = new File("artifact.bin");

        // Сериализация: записываем объект в бинарный файл
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            oos.writeObject(original); // запись объекта в поток
            System.out.println("Сериализовано: " + original);
        } catch (IOException e) {
            System.out.println("Ошибка при сериализации: " + e.getMessage());
            return; // Если не удалось записать — дальше нет смысла продолжать
        }

        // Десериализация: читаем объект обратно из файла
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            // В реальных приложениях для безопасности стоит ограничивать допустимые типы через ObjectInputFilter
            Product restored = (Product) ois.readObject(); // чтение и приведение к нужному типу
            System.out.println("Десериализовано: " + restored);

            // Простая проверка корректности данных
            if (original.getArtifactName().equals(restored.getArtifactName())) {
                System.out.println("Успех: артефакт восстановлен корректно.");
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Ошибка при десериализации: " + e.getMessage());
        }
    }
}

 */