package ru.javarush.java.core.level37.task03;
/*
Попытка отправить кириллицу через устаревшую систему связи 📟
Представьте, что вы пытаетесь отправить важное secretCyrillicMessage "Привет, мир!" через старинную, очень ограниченную систему связи, которая понимает только латинские символы. Эта система использует ancientEncodingStandard, известный как ISO-8859-1. Ваша secretCyrillicMessage должна быть записана в файл с именем failFileName ("latin1fail.txt") с использованием этой устаревшей кодировки. Попытайтесь выполнить эту запись.

Однако, если система столкнется с символами, которые она не понимает (как это часто бывает с кириллицей в ISO-8859-1), она выдаст ошибку. В этом случае ваша программа должна будет сообщить об этой неудаче, выведя на экран сообщение "Ошибка записи: невозможно сохранить кириллицу в ISO-8859-1", чтобы каждый понял, что старая технология не справилась с современным языком.

Требования:
•	Программа должна пытаться записать строку secretCyrillicMessage в файл failFileName с использованием кодировки ISO-8859-1.
•	Программа должна осуществлять попытку записи строки "Привет, мир!" (secretCyrillicMessage) в файл "latin1fail.txt" (failFileName).
•	Если при записи возникнет ошибка, связанная с невозможностью сохранить кириллические символы в кодировке ISO-8859-1, программа должна корректно обработать это исключение.
•	В случае возникновения ошибки программа должна вывести на экран сообщение "Ошибка записи: невозможно сохранить кириллицу в ISO-8859-1".
•	Если происходит ошибка кодирования, в файл не должно быть записано некорректных или повреждённых данных.

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CodingErrorAction;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Solution {
    public static void main(String[] args) throws Exception {
        // Сообщение на кириллице и имя файла из условия
        String secretCyrillicMessage = "Привет, мир!";
        String failFileName = "latin1fail.txt";

        // Готовим энкодер ISO-8859-1 и настраиваем, чтобы при несопоставимых символах бросалось исключение


        try {
            // 1) Сначала пробуем закодировать строку целиком.
            // Если символы нельзя представить в ISO-8859-1, будет выброшено CharacterCodingException.


            // 2) Если кодирование удалось, записываем байты в файл.
            // Такой порядок гарантирует, что при ошибке кодирования мы вообще ничего не запишем на диск.


        } catch (CharacterCodingException e) {
            // Если кириллица не может быть сохранена в ISO-8859-1 — выводим требуемое сообщение
            System.out.println("Ошибка записи: невозможно сохранить кириллицу в ISO-8859-1");
        }
    }
}

 */

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CodingErrorAction;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Solution {
    public static void main(String[] args) throws Exception {
        // Сообщение на кириллице и имя файла из условия
        String secretCyrillicMessage = "Привет, мир!";
        String failFileName = "latin1fail.txt";

        // Готовим энкодер ISO-8859-1 и настраиваем, чтобы при несопоставимых символах бросалось исключение
        CharsetEncoder encoder = StandardCharsets.ISO_8859_1
                .newEncoder()
                .onMalformedInput(CodingErrorAction.REPORT)      // некорректные последовательности
                .onUnmappableCharacter(CodingErrorAction.REPORT); // несопоставимые символы (например, кириллица)

        try {
            // 1) Сначала пробуем закодировать строку целиком.
            // Если символы нельзя представить в ISO-8859-1, будет выброшено CharacterCodingException.
            ByteBuffer encoded = encoder.encode(CharBuffer.wrap(secretCyrillicMessage));

            // 2) Если кодирование удалось, записываем байты в файл.
            // Такой порядок гарантирует, что при ошибке кодирования мы вообще ничего не запишем на диск.
            byte[] bytes = new byte[encoded.remaining()];
            encoded.get(bytes);
            Files.write(Paths.get(failFileName), bytes);

        } catch (CharacterCodingException e) {
            // Если кириллица не может быть сохранена в ISO-8859-1 — выводим требуемое сообщение
            System.out.println("Ошибка записи: невозможно сохранить кириллицу в ISO-8859-1");
            // Ничего в файл не пишем — некорректных данных не будет
        }
    }
}
/*

 */