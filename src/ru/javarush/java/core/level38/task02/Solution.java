package ru.javarush.java.core.level38.task02;
/*
Запись важного донесения в королевский архив 📜

Вы — королевский писец, и вам поручено записать очень важное донесение, а именно строку "Hello, world!", в официальный архивный файл под названием "output.txt". Для этого ответственного задания вы используете BufferedWriter, чтобы запись была аккуратной и эффективной. Однако королевская система архивирования иногда бывает капризной.
Если в процессе записи возникнет какая-либо проблема, связанная с вводом-выводом (например, архивный пергамент закончится или чернила засохнут в неподходящий момент), ваш программный помощник должен немедленно вывести на экран тревожное сообщение: "Ошибка при записи в файл", чтобы вы могли доложить о неполадке и предотвратить потерю ценных данных.

Требования:
•	Программа должна использовать класс BufferedWriter для записи данных в файл.
•	Программа должна записывать строку "Hello, world!" в файл с именем "output.txt".
•	Если при записи возникает исключение IOException, программа должна обработать его.
•	В случае возникновения IOException программа должна вывести на экран сообщение "Ошибка при записи в файл".
•	BufferedWriter должен быть корректно закрыт после завершения записи (вручную или через try-with-resources).

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) {
        // try-with-resources автоматически закроет BufferedWriter после использования

    }
}

 */

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Solution {
    public static void main(String[] args) {
        // try-with-resources автоматически закроет BufferedWriter после использования
        try (BufferedWriter fileWr = Files.newBufferedWriter(Path.of("output.txt"))) {
            fileWr.write("Hello, world!");
            Files.delete(Path.of("outpit.txt"));
        } catch (IOException e) {
            System.out.println("Ошибка при записи в файл");
            ;
        }

    }
}

/*
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) {
        // try-with-resources автоматически закроет BufferedWriter после использования
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"))) {
            // Записываем строку в файл
            writer.write("Hello, world!");
        } catch (IOException e) {
            // В случае любой ошибки ввода-вывода выводим требуемое сообщение
            System.out.println("Ошибка при записи в файл");
        }
    }
}
 */