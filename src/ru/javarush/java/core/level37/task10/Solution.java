package ru.javarush.java.core.level37.task10;
/*
Спасатель цифровых данных: Безопасная перекодировка с защитой от сбоев 🚨

Вы — опытный спасатель цифровых данных, и перед вами стоит ответственная задача: безопасно перенести ценную информацию из старого, местами капризного формата sourceCharset ISO-8859-1 в надежный и универсальный targetCharset UTF-8.
inputDataPath и outputDataPath (пути к исходному и целевому файлам) будут четко определены в ваших переменных.
Чтобы гарантировать, что все ресурсы будут чисто закрыты, независимо от исхода операции, используйте надежный блок try-with-resources.
Если же в процессе чтения inputDataPath или записи в outputDataPath возникнут какие-либо непредвиденные проблемы — например, если файл вдруг исчезнет или возникнут другие ошибки ввода-вывода — ваша программа не должна паниковать. Вместо этого она должна вежливо, но твердо сообщить пользователю: "Ошибка при перекодировке файла", давая понять, что операция не завершилась успешно.

Требования:
•	Для работы с файлами программа должна использовать конструкцию try-with-resources для автоматического закрытия всех ресурсов.
•	Исходный файл по пути inputDataPath должен читаться с использованием кодировки ISO-8859-1.
•	Данные должны записываться в файл по пути outputDataPath с использованием кодировки UTF-8.
•	В случае возникновения IOException (или других ошибок ввода-вывода) при чтении или записи программа должна вывести на экран сообщение "Ошибка при перекодировке файла".
•	Программа не должна выбрасывать исключения наружу — все ошибки должны быть обработаны внутри кода и сопровождаться выводом сообщения.
•	Весь текст из исходного файла должен быть полностью прочитан и перекодирован без потери данных или символов.

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class Solution {
    public static void main(String[] args) {
        // Пути к файлам: исходный (ISO-8859-1) и целевой (UTF-8)
        String inputDataPath = "input_iso_8859_1.txt";
        String outputDataPath = "output_utf8.txt";

        // Явно задаём исходную и целевую кодировки

        // try-with-resources гарантирует закрытие файлов даже при ошибках


    }
}


 */

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class Solution {
    public static void main(String[] args) {
        // Пути к файлам: исходный (ISO-8859-1) и целевой (UTF-8)
        String inputDataPath = "input_iso_8859_1.txt";
        String outputDataPath = "output_utf8.txt";

        // Явно задаём исходную и целевую кодировки
        Charset inCodeSet = StandardCharsets.ISO_8859_1;
        Charset outCodeSet = StandardCharsets.UTF_8;


        // try-with-resources гарантирует закрытие файлов даже при ошибках
        try (InputStream inputStream = Files.newInputStream(Path.of(inputDataPath));
             Reader reader = new InputStreamReader(inputStream, "ISO-8859-1");
             OutputStream outputStream = Files.newOutputStream(Path.of(outputDataPath));
             Writer writer = new OutputStreamWriter(outputStream, StandardCharsets.UTF_8)) {

            char[] buffer = new char[8192]; // буфер для эффективного чтения
            int length;
            while ((length = reader.read(buffer)) != -1) {
                writer.write(buffer, 0, length);
            }

//        } catch (UnsupportedEncodingException e) {
//            throw new RuntimeException(e);
        } catch (IOException e) {
            System.out.println("Ошибка при перекодировке файла");
        }
    }
}

/*
public class Solution {
    public static void main(String[] args) {
        // Пути к файлам: исходный (ISO-8859-1) и целевой (UTF-8)
        String inputDataPath = "input_iso_8859_1.txt";
        String outputDataPath = "output_utf8.txt";

        // Явно задаём исходную и целевую кодировки
        Charset sourceCharset = StandardCharsets.ISO_8859_1;
        Charset targetCharset = StandardCharsets.UTF_8;

        // try-with-resources гарантирует закрытие файлов даже при ошибках
        try (BufferedReader reader = Files.newBufferedReader(Path.of(inputDataPath), sourceCharset);
             BufferedWriter writer = Files.newBufferedWriter(Path.of(outputDataPath), targetCharset)) {

            // Копируем весь текст посимвольно через буфер — простая и наглядная перекодировка
            char[] buffer = new char[8192]; // небольшой буфер для эффективности
            int read;
            while ((read = reader.read(buffer)) != -1) {
                writer.write(buffer, 0, read);
            }
            // writer автоматически flush при закрытии
        } catch (IOException | RuntimeException e) {
            // Сообщение об ошибке при любых проблемах ввода-вывода (и неожиданных рантайм-ошибках)
            System.out.println("Ошибка при перекодировке файла");
            // Исключение наружу не выбрасываем — требования задачи
        }
    }
}
 */


/*
    try (InputStream in = Files.newInputStream(Path.of(inputDataPath));
        OutputStream out = Files.newOutputStream(Path.of(outputDataPath)))
        {
            boolean var;
            while (var = in.read() != -1) {
                out.write(in.read(), inCodeSet);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

 */