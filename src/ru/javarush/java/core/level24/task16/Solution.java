package ru.javarush.java.core.level24.task16;
/*
Сервис логирования: Ни одна ошибка не должна быть потеряна!

Вы разрабатываете фоновую службу, которая записывает важные события в системный лог-файл. Это критически важно, чтобы ни одна ошибка, возникающая при записи, не исчезла бесследно. Иногда могут возникнуть проблемы с доступом к лог-файлу (IOException).
Реализуйте программу, в которой симулируется попытка записи в лог-файл, что может потенциально привести к IOException. В блоке "плана спасения" (catch) вам нельзя оставлять его пустым. Вместо этого, чтобы убедиться, что даже если что-то пойдёт не так, вы получите полную "историю преступления", используйте специальный метод исключения, который выводит весь стек вызовов и детальную информацию об ошибке (printStackTrace()).
Ваша программа должна продемонстрировать, что даже при возникновении проблемы, ошибка не "теряется" и вся необходимая информация о ней отображается в консоли, что позволяет оперативно выявить и исправить причину сбоя.

Требования:
•	В программе должна быть реализована попытка записи в лог-файл, которая может привести к возникновению IOException.
•	Операция записи в лог-файл должна быть заключена в блок try-catch для перехвата возможного исключения IOException.
•	Блок catch для обработки IOException не должен быть пустым — необходимо реализовать обработку исключения.
•	Внутри блока catch для IOException должен быть вызван метод printStackTrace() для вывода полного стека вызовов и подробной информации об ошибке в консоль.
•	Программа должна демонстрировать, что при возникновении IOException информация об ошибке отображается в консоли и не теряется.

public class Solution {
    public static void main(String[] args) {
        System.out.println("Фоновая служба логирования запущена.");

        try {
            // Создаём временную директорию и намеренно используем её как путь к "файлу" лога.


            // Симулируем запись важного события в лог-файл


            // До этой строки выполнение не дойдёт из-за выброшенного выше исключения

        } catch (IOException e) {
            // Блок catch не пустой — здесь печатается полный стек вызовов.

        }

        System.out.println("Демонстрация завершена.");
    }

    // Бизнес-уровень: сохранение события делегирует фактическую запись.
    private static void saveEvent(String message, Path logFile) throws IOException {
        writeLog(logFile, message);
    }

    // Низкоуровневый метод: попытка записи в указанный путь.
    private static void writeLog(Path logFile, String text) throws IOException {
        // Пытаемся записать строку. В нашей демонстрации logFile указывает на директорию - будет исключение
        Files.writeString(logFile, text + System.lineSeparator(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
    }
}

 */
import javax.lang.model.element.PackageElement;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Timer;

public class Solution {
    public static void main(String[] args) {
        System.out.println("Фоновая служба логирования запущена.");
        Path tempDir = null;
        try {
            // Создаём временную директорию и намеренно используем её как путь к "файлу" лога.
            tempDir = Files.createTempDirectory("my_temp_logs_");

            // Симулируем запись важного события в лог-файл
            File logFile = tempDir.toFile(); // Это НЕ файл, а директория!
            try (FileWriter writer = new FileWriter(logFile)) {
                writer.write("Это сообщение лога");
                writer.flush();
                System.out.println("Лог записан (но этого не должно было случиться!)");
            }
            // До этой строки выполнение не дойдёт из-за выброшенного выше исключения

        } catch (IOException e) {
            // Блок catch не пустой — здесь печатается полный стек вызовов.
            System.out.println("Ошибка при записи в лог-файл! Полная информация об ошибке:");
            e.printStackTrace();

        }
//        for (int i = 0; i < 1000; i++) {
//            double j = Math.sqrt(i);
//            System.out.println(j);
//        }

        System.out.println("Демонстрация завершена.");
    }

    // Бизнес-уровень: сохранение события делегирует фактическую запись.
    private static void saveEvent(String message, Path logFile) throws IOException {
        writeLog(logFile, message);
    }

    // Низкоуровневый метод: попытка записи в указанный путь.
    private static void writeLog(Path logFile, String text) throws IOException {
        // Пытаемся записать строку. В нашей демонстрации logFile указывает на директорию - будет исключение
        Files.writeString(logFile, text + System.lineSeparator(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
    }
}

/*
public class Solution {
    public static void main(String[] args) {
        System.out.println("Фоновая служба логирования запущена.");

        try {
            // Создаём временную директорию и намеренно используем её как путь к "файлу" лога.
            Path pathPointingToDirectory = Files.createTempDirectory("log-service-demo");

            // Симулируем запись важного события в лог-файл
            saveEvent("Важное событие: тестируем надёжность логирования.", pathPointingToDirectory);

            // До этой строки выполнение не дойдёт из-за выброшенного выше исключения
            System.out.println("Запись лога завершена.");
        } catch (IOException e) {
            // Блок catch не пустой — здесь печатается полный стек вызовов.
            System.out.println("Ошибка при записи в лог-файл! Полная информация об ошибке:");
            e.printStackTrace(); // ключевое требование задачи — вывести стек вызовов
        }

        System.out.println("Демонстрация завершена.");
    }

    // Бизнес-уровень: сохранение события делегирует фактическую запись.
    private static void saveEvent(String message, Path logFile) throws IOException {
        writeLog(logFile, message);
    }

    // Низкоуровневый метод: попытка записи в указанный путь.
    private static void writeLog(Path logFile, String text) throws IOException {
        // Пытаемся записать строку. В нашей демонстрации logFile указывает на директорию - будет исключение
        Files.writeString(logFile, text + System.lineSeparator(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
    }
}
 */