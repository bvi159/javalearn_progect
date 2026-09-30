package ru.javarush.java.core.level40.task08;
/*
Завершение цифровой сессии и полная очистка 🌀

Представьте, что вы — управляющий сложной системой, которая периодически создаёт временные 'рабочие пространства' для выполнения определённых задач. После каждой такой 'сессии' всё должно быть тщательно убрано, чтобы не оставлять цифрового мусора.
Ваша программа должна создать временную директорию, присвоив ей префикс 'session_'. Внутри этой новой 'комнаты' создайте два временных файла с разными суффиксами — это могут быть, например, лог-файлы или промежуточные результаты.
После того как 'сессия' закончена, наступает самый ответственный момент: вам нужно рекурсивно, то есть очень тщательно, удалить все файлы, которые находятся внутри этой временной директории, а затем убрать и саму директорию, оставив после себя лишь чистоту.
Когда весь процесс уборки будет завершён, программа должна торжественно объявить: 'Временная директория и файлы удалены', подтверждая, что ваша система всегда находится в идеальном порядке.

Требования:
•	Программа должна создать временную директорию, имя которой начинается с префикса 'session_'.
•	Внутри созданной временной директории необходимо создать два временных файла с разными суффиксами.
•	Оба временных файла должны находиться непосредственно внутри созданной временной директории.
•	Все файлы внутри временной директории должны быть удалены рекурсивно, то есть независимо от их количества и вложенности.
•	После удаления всех файлов программа должна удалить и саму временную директорию.
•	После успешного удаления директории и файлов программа должна вывести сообщение: 'Временная директория и файлы удалены'.

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class Solution {
    public static void main(String[] args) throws IOException {
        // 1) Создаем временную директорию с префиксом 'session_'
        Path sessionDir = Files.createTempDirectory("session_");

        // 2) Создаем два временных файла с разными суффиксами строго внутри созданной директории
        Files.createTempFile(sessionDir, "task_", ".log");
        Files.createTempFile(sessionDir, "result_", ".tmp");

        // 3) Рекурсивно удаляем все файлы и подкаталоги, затем удаляем саму директорию
        deleteRecursively(sessionDir);

        // 4) Финальное сообщение об успешной очистке
        System.out.println("Временная директория и файлы удалены");
    }

    // Рекурсивное удаление каталога:
    // используем FileVisitor, чтобы сначала удалить файлы,
    // а затем — директории (postVisitDirectory вызывается после обхода содержимого)
    private static void deleteRecursively(Path root) throws IOException {



    }
}

 */

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class Solution {
    public static void main(String[] args) throws IOException, InterruptedException {
        // 1) Создаем временную директорию с префиксом 'session_'
        Path sessionDir = Files.createTempDirectory("session_");

        // 2) Создаем два временных файла с разными суффиксами строго внутри созданной директории
        Files.createTempFile(sessionDir, "task_", ".log");
        Files.createTempFile(sessionDir, "result_", ".tmp");

        // 3) Рекурсивно удаляем все файлы и подкаталоги, затем удаляем саму директорию
        deleteRecursively(sessionDir);

        // 4) Финальное сообщение об успешной очистке
        System.out.println("Временная директория и файлы удалены");

        //---------Пример из лекции 40_4-----------
        Path dir = Paths.get("data/uploads");
        if (!Files.exists(dir)) {
            Files.createDirectories(dir);
        }

        WatchService watchService = FileSystems.getDefault().newWatchService();
        dir.register(
                watchService,
                StandardWatchEventKinds.ENTRY_CREATE,
                StandardWatchEventKinds.ENTRY_DELETE,
                StandardWatchEventKinds.ENTRY_MODIFY
        );

        System.out.println("Слежение за папкой " + dir.toAbsolutePath());

        while (true) {
            WatchKey key = watchService.take(); // ждём события

            for (WatchEvent<?> event : key.pollEvents()) {
                WatchEvent.Kind<?> kind = event.kind();
                Path filename = (Path) event.context();
                System.out.printf("[%s] %s\n", kind.name(), filename);
            }

            boolean valid = key.reset();
            if (!valid) {
                System.out.println("Папка недоступна, слежение завершено.");
                break;
            }
        }
        //---------Пример из лекции 40_4-----------


    }

    // Рекурсивное удаление каталога:
    // используем FileVisitor, чтобы сначала удалить файлы,
    // а затем — директории (postVisitDirectory вызывается после обхода содержимого)
    private static void deleteRecursively(Path root) throws IOException {

        Files.walk(root)
                .sorted((a, b) -> b.compareTo(a)) // сначала файлы, потом папки
                .forEach(path -> {
                    try {
                        Files.deleteIfExists(path);
                    } catch (IOException ex) {
                        System.err.println("Не удалось удалить " + path + ": " + ex.getMessage());
                    }
                });

    }
}
/*

 */