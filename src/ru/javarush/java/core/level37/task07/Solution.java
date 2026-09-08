package ru.javarush.java.core.level37.task07;
/*
Попытка расшифровать древний свиток неверной линзой 🔎

Представьте, что вы — цифровой историк, и в ваши руки попал ancientScrollPath (текстовый файл), наполненный таинственными не-ASCII символами, записанными на современном, универсальном языке UTF-8. Ваша задача — попытаться прочесть этот свиток, но вы по ошибке используете устаревший decryptionCharset — ISO-8859-1, как будто пытаетесь прочесть сложные письмена через старую, неподходящую линзу.
Используя Files.newBufferedReader, укажите эту неправильную кодировку и попробуйте извлечь decodedContent. Выведите на экран то, что получится в результате вашего "чтения". Но будьте готовы: скорее всего, из-за несоответствия кодировок возникнет exceptionType. Если это произойдет, ваша программа должна будет сообщить об errorMessage и указать тип исключения, чтобы показать, что попытка расшифровки оказалась безуспешной из-за неправильного инструмента.

Требования:
•	Программа должна использовать Files.newBufferedReader для открытия файла с путем ancientScrollPath, указав явно кодировку decryptionCharset (ISO-8859-1).
•	Программа должна попытаться прочитать содержимое файла, который на самом деле закодирован в UTF-8, используя неправильную кодировку ISO-8859-1.
•	Программа должна сохранить результат чтения файла (decodedContent), даже если символы будут отображаться некорректно из-за несовпадения кодировок.
•	Программа должна вывести на экран полученное decodedContent, независимо от его корректности.
•	Если при чтении файла возникнет исключение, программа должна отловить его, вывести errorMessage и указать тип возникшего исключения (exceptionType).
•	Программа должна использовать переменные ancientScrollPath, decryptionCharset, decodedContent, exceptionType и errorMessage в соответствии с их назначением.

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Solution {
    public static void main(String[] args) {
        // Путь к "древнему свитку" — UTF-8 файл с не-ASCII символами
        Path ancientScrollPath = Paths.get("ancient_scroll.txt");

        // "Неверная линза": намеренно указываем кодировку ISO-8859-1
        Charset decryptionCharset = StandardCharsets.ISO_8859_1;

        // Сюда сохраним результат чтения при расшифровке неверной кодировкой
        String decodedContent = "";

        // Поля для информации об ошибке, если она случится
        String exceptionType = "";
        String errorMessage = "";

        // Пытаемся прочитать UTF-8 файл как ISO-8859-1 через Files.newBufferedReader
        try ( ... ) {

        } catch (IOException e) {
            // Если при чтении что-то пошло не так — сообщаем об этом

        }
    }
}

 */

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Solution {
    public static void main(String[] args) {
        // Путь к "древнему свитку" — UTF-8 файл с не-ASCII символами
        Path ancientScrollPath = Paths.get("ancient_scroll.txt");

        // "Неверная линза": намеренно указываем кодировку ISO-8859-1
        Charset decryptionCharset = StandardCharsets.ISO_8859_1;
        // Сюда сохраним результат чтения при расшифровке неверной кодировкой
        String decodedContent = "";
        // Поля для информации об ошибке, если она случится
        String exceptionType = "";
        String errorMessage = "";
        try (BufferedReader buf = Files.newBufferedReader(ancientScrollPath, decryptionCharset)) {
            decodedContent = buf.readLine();
        } catch (Exception e) {
//            System.out.println("Ошибка: " + e.getClass().getName());
            errorMessage = e.getMessage();
            System.out.println(errorMessage);
            exceptionType = e.getClass().getName();
            System.out.println(exceptionType);
        } finally {
            System.out.println(decodedContent);
        }

        System.out.println(decodedContent);


        // Пытаемся прочитать UTF-8 файл как ISO-8859-1 через Files.newBufferedReader
        try (BufferedReader buf = Files.newBufferedReader(ancientScrollPath, StandardCharsets.UTF_8)) {
            decodedContent = buf.readLine();
            System.out.println(decodedContent);
        } catch (IOException e) {
            // Если при чтении что-то пошло не так — сообщаем об этом
            errorMessage = e.getMessage();
            System.out.println(errorMessage);
            exceptionType = e.getClass().getName();
            System.out.println(exceptionType);
        }
    }
}
/*
public class Solution {
    public static void main(String[] args) {
        // Путь к "древнему свитку" — UTF-8 файл с не-ASCII символами
        Path ancientScrollPath = Paths.get("ancient_scroll.txt");

        // "Неверная линза": намеренно указываем кодировку ISO-8859-1
        Charset decryptionCharset = StandardCharsets.ISO_8859_1;

        // Сюда сохраним результат чтения при расшифровке неверной кодировкой
        String decodedContent = "";

        // Поля для информации об ошибке, если она случится
        String exceptionType = "";
        String errorMessage = "";

        // Пытаемся прочитать UTF-8 файл как ISO-8859-1 через Files.newBufferedReader
        try (BufferedReader reader = Files.newBufferedReader(ancientScrollPath, decryptionCharset)) {
            StringBuilder sb = new StringBuilder();
            String line;
            // Читаем построчно и накапливаем содержимое
            while ((line = reader.readLine()) != null) {
                sb.append(line).append(System.lineSeparator());
            }
            decodedContent = sb.toString(); // сохраняем то, что получилось (возможна "моджибака")
            System.out.print(decodedContent); // выводим результат "расшифровки" на экран
        } catch (IOException e) {
            // Если при чтении что-то пошло не так — сообщаем об этом
            exceptionType = e.getClass().getName();
            errorMessage = "Ошибка чтения файла: " + e.getMessage();

            System.out.println(errorMessage);
            System.out.println("Тип исключения: " + exceptionType);
        }
    }
}
 */