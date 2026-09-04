package ru.javarush.java.core.level12.task11;
/*
Запись и чтение бинарных данных

Вы разрабатываете систему для шифрования секретных сообщений и решили начать с простого теста: сохранения и чтения отдельных символов в бинарном формате.

Сформируйте массив байтов, который будет содержать числовые значения 72, 73, 74. Это соответствует символам 'H', 'I', 'J' в кодировке ASCII.

Запишите этот массив байтов в новый файл с именем "letters.bin".

Затем, чтобы убедиться в целостности данных, прочитайте содержимое этого же файла "letters.bin" обратно в новый массив байтов.

После этого пройдитесь по каждому байту в прочитанном массиве и выведите его на экран как соответствующий символ, разделяя символы пробелами.

В итоге вы должны увидеть на экране: H I J.

Требования:
•	Необходимо создать массив байтов, содержащий значения 72, 73 и 74.
•	Требуется записать созданный массив байтов в новый файл с именем "letters.bin" в бинарном формате.
•	Требуется прочитать содержимое файла "letters.bin" обратно в новый массив байтов.
•	Для каждого байта в прочитанном массиве нужно вывести соответствующий символ на экран.
•	Символы должны быть выведены на экран через пробел, итоговая строка вывода: H I J.
public class Solution {
    public static void main(String[] args) throws IOException {
        // 1) Создаем массив байтов с ASCII-кодами букв H, I, J


        // 2) Записываем массив в бинарный файл "letters.bin"


        // 3) Читаем содержимое файла обратно в новый массив байтов


        // 4) Выводим каждый байт как символ, разделяя пробелами

    }
}

*/
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) throws IOException {
        // 1) Создаем массив байтов с ASCII-кодами букв H, I, J
        byte[] secretBox = {72, 73, 74};


        // 2) Записываем массив в бинарный файл "letters.bin"
        Files.write(Path.of("letters.bin"), secretBox);


        // 3) Читаем содержимое файла обратно в новый массив байтов
        byte[] readSecretChars = Files.readAllBytes(Path.of("letters.bin"));

        // 4) Выводим каждый байт как символ, разделяя пробелами
//        System.out.println(Arrays.toString(readSecretChars));
        /*for (byte mySecretLetter : readSecretChars) {
            System.out.print((char) mySecretLetter);

        }*/
        for (int i = 0; i < readSecretChars.length; i++) {
            System.out.print((char)readSecretChars[i]);
            if (i<readSecretChars.length - 1) {
                System.out.print(" ");
            }
        }
    }
}

/*
Ихнее решение

public class Solution {
    public static void main(String[] args) throws IOException {
        // 1) Создаем массив байтов с ASCII-кодами букв H, I, J
        byte[] bytesToWrite = {72, 73, 74};

        // 2) Записываем массив в бинарный файл "letters.bin"
        Path file = Path.of("letters.bin");
        Files.write(file, bytesToWrite); // создаст файл или перезапишет его

        // 3) Читаем содержимое файла обратно в новый массив байтов
        byte[] bytesRead = Files.readAllBytes(file);

        // 4) Выводим каждый байт как символ, разделяя пробелами
        for (int i = 0; i < bytesRead.length; i++) {
            if (i > 0) System.out.print(" "); // разделяем символы пробелом
            System.out.print((char) bytesRead[i]); // преобразуем байт в символ
        }
    }
}

 */