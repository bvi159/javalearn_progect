package ru.javarush.java.core.level37.task04;
/*
Лингвистический эксперимент: Вес слов в разных кодировках ⚖️
Вы — цифровой лингвист, проводящий увлекательный эксперимент по измерению "веса" слов в разных кодировках.

Возьмите особую, многогранную multilingualPhrase: "AБВΓéü😀", которая включает в себя латиницу, кириллицу, греческий символ, французские и немецкие буквы, и даже эмодзи.

Ваша задача — записать эту фразу в три отдельных файла, каждый с уникальной кодировкой:

Первый файл, utf8FileName ("test_utf8.txt"), будет использовать универсальную кодировку UTF-8.
Второй, utf16FileName ("test_utf16.txt"), будет записан в UTF-16.
И третий, latin1FileName ("test_latin1.txt"), попытается принять эту фразу в старой кодировке ISO-8859-1.
После того как каждая multilingualPhrase будет сохранена, вам предстоит стать цифровым архитектором и определить fileSizeInBytes каждого из этих файлов.

Выведите на экран результат ваших измерений, например: "UTF-8: X байт", "UTF-16: Y байт", "ISO-8859-1: Z байт".

Если же при попытке записать multilingualPhrase в файл ISO-8859-1 возникнет неизбежная ошибка (потому что эта кодировка не умеет хранить все эти символы), гордо сообщите миру: "ISO-8859-1: невозможно сохранить строку — ошибка кодировки".

Требования:
•	Программа должна использовать строку multilingualPhrase со значением "AБВΓéü😀".
•	Фраза multilingualPhrase должна быть записана в файл с именем, заданным в переменной utf8FileName ("test_utf8.txt"), с использованием кодировки UTF-8.
•	Фраза multilingualPhrase должна быть записана в файл с именем, заданным в переменной utf16FileName ("test_utf16.txt"), с использованием кодировки UTF-16.
•	Фраза multilingualPhrase должна быть записана в файл с именем, заданным в переменной latin1FileName ("test_latin1.txt"), с использованием кодировки ISO-8859-1.
•	Если при попытке записи multilingualPhrase в файл с кодировкой ISO-8859-1 возникнет ошибка кодирования, программа должна вывести сообщение: "ISO-8859-1: невозможно сохранить строку — ошибка кодировки".
•	Программа должна определить размер каждого из успешно созданных файлов (в байтах).
•	Программа должна вывести на экран размер каждого файла в следующем формате: "UTF-8: X байт", "UTF-16: Y байт", "ISO-8859-1: Z байт" (или сообщение об ошибке для ISO-8859-1).

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CodingErrorAction;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class Solution {
    public static void main(String[] args) throws Exception {
        // Заданная фраза с разноязычными символами и эмодзи
        String multilingualPhrase = "AБВΓéü😀";

        // Имена файлов под разные кодировки
        String utf8FileName = "test_utf8.txt";
        String utf16FileName = "test_utf16.txt";
        String latin1FileName = "test_latin1.txt";

        // 1) Записываем строку в UTF-8 и измеряем размер файла


        // 2) Записываем строку в UTF-16 (c BOM) и измеряем размер файла


        // 3) Пытаемся записать строку в ISO-8859-1
        // По умолчанию Java заменяет неподдерживаемые символы на '?',
        // поэтому явно настраиваем энкодер на REPORT, чтобы получить ошибку кодирования.




        // Вывод результатов измерений

    }
}

 */

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Solution {
    public static void main(String[] args) throws Exception {
        String multilingualPhrase = "AБВΓéü😀";

        String utf8FileName = "test_utf8.txt";
        String utf16FileName = "test_utf16.txt";
        String latin1FileName = "test_latin1.txt";

        long utf8Size = 0;
        long utf16Size = 0;
        Long latin1Size = null;

        try {
            // Запись в UTF-8
            Files.write(Paths.get(utf8FileName),
                    multilingualPhrase.getBytes(StandardCharsets.UTF_8));
            utf8Size = Files.size(Paths.get(utf8FileName));

            // Запись в UTF-16
            Files.write(Paths.get(utf16FileName),
                    multilingualPhrase.getBytes(StandardCharsets.UTF_16));
            utf16Size = Files.size(Paths.get(utf16FileName));

            // Попытка записи в ISO-8859-1
            try {
                byte[] latin1Bytes = multilingualPhrase.getBytes(Charset.forName("ISO-8859-1"));
                // Проверяем, не произошла ли потеря данных (замена символов на '?')
                String decoded = new String(latin1Bytes, Charset.forName("ISO-8859-1"));
                if (!decoded.equals(multilingualPhrase)) {
                    throw new UnsupportedEncodingException("Невозможно сохранить все символы в ISO-8859-1");
                }
                Files.write(Paths.get(latin1FileName), latin1Bytes);
                latin1Size = Files.size(Paths.get(latin1FileName));
            } catch (UnsupportedEncodingException | IllegalArgumentException e) {
                // Ошибка кодировки
                latin1Size = null;
                // Создаём файл с сообщением об ошибке для наглядности
                Files.write(Paths.get(latin1FileName),
                        "Невозможно сохранить строку — ошибка кодировки".getBytes(StandardCharsets.UTF_8));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        // Вывод результатов
        System.out.println("UTF-8: " + utf8Size + " байт");
        System.out.println("UTF-16: " + utf16Size + " байт");

        if (latin1Size != null) {
            System.out.println("ISO-8859-1: " + latin1Size + " байт");
        } else {
            System.out.println("ISO-8859-1: невозможно сохранить строку — ошибка кодировки");
        }

        // Дополнительная информация для понимания
        System.out.println("\nАнализ символов:");
        System.out.println("Строка: \"" + multilingualPhrase + "\"");
        System.out.println("Длина строки (количество символов): " + multilingualPhrase.length());

        System.out.println("\nКодировка UTF-8:");
        byte[] utf8Bytes = multilingualPhrase.getBytes(StandardCharsets.UTF_8);
        System.out.println("  Байт: " + utf8Bytes.length);
        System.out.print("  Hex: ");
        for (byte b : utf8Bytes) {
            System.out.printf("%02X ", b);
        }
        System.out.println();

        System.out.println("\nКодировка UTF-16:");
        byte[] utf16Bytes = multilingualPhrase.getBytes(StandardCharsets.UTF_16);
        System.out.println("  Байт: " + utf16Bytes.length);
        System.out.print("  Hex: ");
        for (byte b : utf16Bytes) {
            System.out.printf("%02X ", b);
        }
        System.out.println();

        System.out.println("\nISO-8859-1 (попытка):");
        try {
            byte[] latin1Bytes = multilingualPhrase.getBytes(Charset.forName("ISO-8859-1"));
            System.out.println("  Байт: " + latin1Bytes.length);
            System.out.print("  Hex: ");
            for (byte b : latin1Bytes) {
                System.out.printf("%02X ", b);
            }
            System.out.println();
            System.out.println("  Результат: символы, которых нет в ISO-8859-1, были заменены на '?' (0x3F)");
        } catch (Exception e) {
            System.out.println("  Ошибка: " + e.getMessage());
        }
        //пример из лекции 37_2
        System.out.println("Доступные кодировки:");
        Charset.availableCharsets().forEach((name, charset) -> System.out.println(name));

    }
}
/*
public class Solution {
    public static void main(String[] args) throws Exception {
        // Заданная фраза с разноязычными символами и эмодзи
        String multilingualPhrase = "AБВΓéü😀";

        // Имена файлов под разные кодировки
        String utf8FileName = "test_utf8.txt";
        String utf16FileName = "test_utf16.txt";
        String latin1FileName = "test_latin1.txt";

        // 1) Записываем строку в UTF-8 и измеряем размер файла
        Path utf8Path = Path.of(utf8FileName);
        Files.writeString(utf8Path, multilingualPhrase, StandardCharsets.UTF_8);
        long sizeUtf8 = Files.size(utf8Path);

        // 2) Записываем строку в UTF-16 (c BOM) и измеряем размер файла
        Path utf16Path = Path.of(utf16FileName);
        Files.writeString(utf16Path, multilingualPhrase, StandardCharsets.UTF_16);
        long sizeUtf16 = Files.size(utf16Path);

        // 3) Пытаемся записать строку в ISO-8859-1
        // По умолчанию Java заменяет неподдерживаемые символы на '?',
        // поэтому явно настраиваем энкодер на REPORT, чтобы получить ошибку кодирования.
        Path latin1Path = Path.of(latin1FileName);
        boolean isoSaved = false;
        long sizeLatin1 = 0;

        try {
            CharsetEncoder encoder = StandardCharsets.ISO_8859_1.newEncoder()
                    .onMalformedInput(CodingErrorAction.REPORT)      // если вход "испорчен" — бросаем исключение
                    .onUnmappableCharacter(CodingErrorAction.REPORT); // если символ нельзя закодировать — бросаем исключение

            // Пробуем закодировать всю строку сразу — при первом непредставимом символе будет исключение
            ByteBuffer encoded = encoder.encode(CharBuffer.wrap(multilingualPhrase));

            // Перекладываем байты из ByteBuffer в массив и записываем в файл
            byte[] data = new byte[encoded.remaining()];
            encoded.get(data);
            Files.write(latin1Path, data);

            isoSaved = true;
            sizeLatin1 = Files.size(latin1Path);
        } catch (CharacterCodingException e) {
            // Некоторые символы (кириллица, греческий и эмодзи) не представимы в ISO-8859-1
            // Сообщаем об ошибке кодировки согласно требованию
        }

        // Вывод результатов измерений
        System.out.println("UTF-8: " + sizeUtf8 + " байт");
        System.out.println("UTF-16: " + sizeUtf16 + " байт");
        if (isoSaved) {
            System.out.println("ISO-8859-1: " + sizeLatin1 + " байт");
        } else {
            System.out.println("ISO-8859-1: невозможно сохранить строку — ошибка кодировки");
        }
    }
}
 */