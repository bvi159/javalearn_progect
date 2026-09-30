package ru.javarush.java.core.level41.task10;
/*
Великое архивирование: Сбор текстовых свитков Цифровой Библиотеки 📚

Представьте себя главным хранителем в древней, но цифровой библиотеке, корневой директорией которой является "docs".
Эта библиотека полна тысяч свитков, спрятанных в бесчисленных лабиринтах и потайных комнатах (подпапках).
Ваша священная задача — найти все свитки, написанные на древнем "текстовом" языке (то есть, все файлы
 с расширением ".txt"), где бы они ни находились.
После того как вы их найдете, вам нужно бережно собрать их все в один-единственный, компактный "цифровой сундук"
 под названием "docs.zip". При этом крайне важно сохранить их изначальное расположение внутри библиотеки, чтобы, распаковав сундук, можно было точно восстановить их положение.
Для этой грандиозной экспедиции вы будете использовать магию Files.walk для исследования лабиринтов и
специальное заклинание "glob:**//*.txt" для фильтрации, а для создания самого сундука — ZipOutputStream.

        Требования:
        •	Программа должна использовать Files.walk для рекурсивного обхода всех подпапок внутри директории "docs" с целью поиска файлов с расширением ".txt".
        •	Для отбора нужных файлов необходимо применить фильтрацию по шаблону glob:**//*.txt, чтобы выбрать только файлы с расширением ".txt" вне зависимости от глубины вложенности.
•	Все найденные .txt файлы должны быть добавлены в архив docs.zip, который создаётся в корневой директории "docs" или в текущей рабочей директории.
•	В архиве docs.zip для каждого файла должна быть сохранена его относительная структура путей внутри "docs", чтобы при распаковке файлы оказались на тех же местах.
•	Для создания и наполнения архива необходимо использовать класс ZipOutputStream из пакета java.util.zip.
•	Содержимое каждого .txt файла должно быть корректно считано и записано в соответствующий элемент архива без потери данных.
•	Программа должна корректно обрабатывать файлы, находящиеся на любой глубине вложенности внутри "docs", включая вложенные и скрытые подпапки.
•	Все файловые и архивные потоки должны быть корректно закрыты после завершения работы, чтобы избежать утечек ресурсов.
import java.io.IOException;
import java.nio.file.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Solution {
    public static void main(String[] args) throws IOException {
        // Корневая папка "древней библиотеки"


        if (!Files.isDirectory(docsRoot)) {
            // Для простоты — лишь сообщение и выход (полную обработку ошибок не делаем)


        }

        // Имя создаваемого архива в текущей рабочей директории


        // Глоббинг по шаблону glob:**//*.txt — совпадение всех .txt на любой глубине


        // 1) Рекурсивно обходим все файлы внутри "docs" с помощью Files.walk
        // 2) Оставляем только обычные файлы
        // 3) Фильтруем по glob-шаблону, чтобы взять только .txt








        // Создаем архив и добавляем в него найденные файлы

        for (Path file : txtFiles) {
        // Относительный путь внутри "docs" — так сохраняется структура директорий


        // Добавляем запись в архив


        // Переносим содержимое файла прямо в архив (без лишних буферов)


        // Закрываем текущую запись

        }




        }
        }

 */

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Solution {
    public static void main(String[] args) throws IOException {
        Path docsRoot = Paths.get("docs");

        if (!Files.isDirectory(docsRoot)) {
            System.out.println("this is not a directory!");
            return;   // <-- лучше выйти, иначе дальше будет ошибка
        }

        Path zipOut = Paths.get("docs.zip");

        PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:**/*.txt");

        // Два ресурса в одном try: ZipOutputStream и Stream<Path>
        try (ZipOutputStream zos = new ZipOutputStream(Files.newOutputStream(zipOut));
             Stream<Path> stream = Files.walk(docsRoot)) {

            stream.filter(Files::isRegularFile)
                    .filter(matcher::matches)
                    .forEach(path -> {
                        String entryName = docsRoot.relativize(path)
                                .toString()
                                .replace("\\", "/");
                        try (InputStream is = Files.newInputStream(path)) {
                            zos.putNextEntry(new ZipEntry(entryName));
                            is.transferTo(zos);
                            zos.closeEntry();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });
        }
    }
}

/*

public class Solution {
    public static void main(String[] args) throws IOException {
        // Корневая папка "древней библиотеки"
        Path docsRoot = Paths.get("docs");

        if (!Files.isDirectory(docsRoot)) {
            // Для простоты — лишь сообщение и выход (полную обработку ошибок не делаем)
            System.out.println("Папка 'docs' не найдена рядом с программой.");
            return;
        }

        // Имя создаваемого архива в текущей рабочей директории
        Path zipTarget = Paths.get("docs.zip");

        // Глоббинг по шаблону glob:**//*.txt — совпадение всех .txt на любой глубине
PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:**//*.txt");

// 1) Рекурсивно обходим все файлы внутри "docs" с помощью Files.walk
// 2) Оставляем только обычные файлы
// 3) Фильтруем по glob-шаблону, чтобы взять только .txt
List<Path> txtFiles;
        try (Stream<Path> walk = Files.walk(docsRoot)) {
txtFiles = walk
        .filter(Files::isRegularFile)
                    .filter(matcher::matches)
                    .sorted() // упорядочим для стабильности результата
                    .collect(Collectors.toList());
        }

        // Создаем архив и добавляем в него найденные файлы
        try (ZipOutputStream zos = new ZipOutputStream(Files.newOutputStream(zipTarget))) {
        for (Path file : txtFiles) {
// Относительный путь внутри "docs" — так сохраняется структура директорий
String entryName = docsRoot.relativize(file).toString()
        .replace('\\', '/'); // в zip используются прямые слеши

// Добавляем запись в архив
                zos.putNextEntry(new ZipEntry(entryName));

        // Переносим содержимое файла прямо в архив (без лишних буферов)
        Files.copy(file, zos);

// Закрываем текущую запись
                zos.closeEntry();
            }
                    }

                    System.out.println("Создан архив: " + zipTarget.toAbsolutePath());
        System.out.println("Добавлено .txt файлов: " + txtFiles.size());
        }
        }
 */


