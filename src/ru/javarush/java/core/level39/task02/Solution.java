package ru.javarush.java.core.level39.task02;
/*
Поиск сокровищ разработчика: найдите все Java-файлы

Вы — ведущий разработчик в большой IT-компании, и вам нужно срочно найти все исходные файлы вашего проекта, написанные на Java, чтобы подготовиться к новому релизу. Эти файлы могут быть разбросаны по множеству подпапок, вложенных глубоко одна в другую. Создайте специальный путь, указывающий на корневую директорию вашего исходного кода, обычно называемую "src".
Используя продвинутые средства вашей файловой системы, пройдитесь по всем без исключения папкам и подпапкам внутри "src" и отыщите каждый файл, который является частью вашего Java-кода, то есть имеет расширение ".java". Каждый раз, когда вы находите такой файл, выведите его полный путь на экран, чтобы получить полный список всех частей вашего кода, требующих внимания.

Требования:
•	В программе должен использоваться класс Path для задания пути к корневой директории "src".
•	Для рекурсивного обхода всех папок и подпапок должен использоваться метод Files.walk.
•	Программа должна находить только те файлы, которые имеют расширение ".java".
•	Для каждого найденного Java-файла программа должна выводить его полный путь на экран.
•	Программа не должна выводить пути к папкам, только к файлам с нужным расширением.

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class Solution {
    public static void main(String[] args) {
        // Задаем корневую директорию "src" через Path (требование задачи)


        // Рекурсивно обходим все поддиректории с помощью Files.walk
        // Используем try-with-resources, чтобы корректно закрыть поток путей

    }
}

 */

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.atomic.AtomicInteger;

public class Solution {
    public static void main(String[] args) {
        // Задаем корневую директорию "src" через Path (требование задачи)
        Path myRoot = Paths.get("C:\\Users\\Vic_host.BIG\\javarush\\3536038\\javarush-project\\src");
        // Рекурсивно обходим все поддиректории с помощью Files.walk
        // Используем try-with-resources, чтобы корректно закрыть поток путей
        // 15.09.2026 Подсчёт файлов я добавил от себя - ради спортивного интереса
        AtomicInteger count = new AtomicInteger();
        try (var myJava = Files.walk(myRoot)) {
            myJava.filter(Files::isRegularFile)
                    .filter(path -> path.toString().endsWith(".java"))
                    .peek(path -> count.getAndIncrement())
                    .forEach(System.out::println);

            System.out.println("Всего .java файлов: " + count);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
/*


public class Solution {
    public static void main(String[] args) {
        // Задаем корневую директорию "src" через Path (требование задачи)
        Path root = Path.of("src");

        // Рекурсивно обходим все поддиректории с помощью Files.walk
        // Используем try-with-resources, чтобы корректно закрыть поток путей
        try (Stream<Path> paths = Files.walk(root)) {
            paths
                // Оставляем только обычные файлы (исключаем директории)
                .filter(Files::isRegularFile)
                // Фильтруем по расширению ".java"
                .filter(p -> p.getFileName().toString().endsWith(".java"))
                // Преобразуем к абсолютному пути и выводим на экран
                .map(Path::toAbsolutePath)
                .forEach(System.out::println);
        } catch (IOException e) {
            // Минимальная обработка ошибок: выводим сообщение в stderr
            System.err.println("Ошибка при обходе директории: " + e.getMessage());
        }
    }
}
 */