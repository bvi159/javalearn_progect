package ru.javarush.java.core.level38.task05;
/*
Расшифровка древнего послания: ожидание полного текста 🧩

Вы — криптограф, который пытается расшифровать древнее бинарное послание, записанное в файле "numbers.bin". Известно, что это послание должно содержать ровно два числовых кода (int). Однако ваш артефакт (файл) подозрительно мал, и есть опасения, что он повреждён.

Ваша программа-дешифровщик должна попытаться прочитать из этого файла четыре числовых кода подряд, как будто вы ожидаете продолжения истории.

Если в процессе чтения, после двух правильных чисел, вы внезапно наткнётесь на конец файла (то есть получите EOFException), это будет явным признаком повреждения. В таком случае программа должна вывести на экран тревожное сообщение: "Файл неожиданно закончился! Возможно, он повреждён.", чтобы вы знали, что не весь код удалось восстановить.

Требования:
•	Программа должна использовать DataInputStream для побайтового чтения int-значений из бинарного файла "numbers.bin".
•	Программа должна попытаться прочитать из файла четыре int-значения подряд, даже если известно, что файл может содержать меньше данных.
•	Если при чтении третьего или четвёртого int-значения возникнет EOFException, программа должна перехватить это исключение.
•	В случае возникновения EOFException программа должна вывести на экран сообщение: "Файл неожиданно закончился! Возможно, он повреждён."
•	Программа должна корректно закрывать все потоки после завершения чтения, используя try-with-resources или явное закрытие.
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) {
        // Читаем бинарный файл с помощью DataInputStream

    }
}

 */

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;


public class Solution {
    public static void main(String[] args) {
        // Читаем бинарный файл с помощью DataInputStream
        try (DataInputStream in = new DataInputStream(new FileInputStream("numbers.bin"))) {
            for (int i = 0; i < 4; i++) {
                int number = in.readInt();
                System.out.println("Прочитано число: " + number);
            }
        } catch (EOFException e) {
            System.err.println("Файл неожиданно закончился! Возможно, он повреждён.");
        } catch (IOException e) {
            System.err.println("Ошибка чтения: " + e.getMessage());
        }

    }
}
/*
public class Solution {
    public static void main(String[] args) {
        // Читаем бинарный файл с помощью DataInputStream
        try (DataInputStream in = new DataInputStream(new FileInputStream("numbers.bin"))) {
            int readCount = 0; // Счётчик успешно прочитанных int

            // Пытаемся прочитать четыре int подряд
            for (int i = 0; i < 4; i++) {
                try {
                    in.readInt(); // Читаем очередное int-значение
                    readCount++;
                } catch (EOFException e) {
                    // Если конец файла настиг после двух корректных чисел — считаем файл повреждённым
                    if (readCount >= 2) {
                        System.out.println("Файл неожиданно закончился! Возможно, он повреждён.");
                    }
                    // Дальше читать бессмысленно — выходим из цикла
                    break;
                }
            }
        } catch (IOException e) {
            // (файл закроется автоматически благодаря try-with-resources)
        }
    }
}
 */