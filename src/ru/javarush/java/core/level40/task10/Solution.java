package ru.javarush.java.core.level40.task10;
/*
Мониторинг изменений и удалений в ключевой директории 🚨

Вы — дежурный оператор центра контроля за данными, и ваша основная задача — следить за любыми подозрительными действиями в особо чувствительной папке 'watched'. Вам нужно написать программу, которая будет бдительно отслеживать эту папку на два типа 'инцидентов': изменения файлов или папок (ENTRY_MODIFY) и их удаление (ENTRY_DELETE).
Как только ваш 'датчик' зафиксирует любое из этих событий, программа должна немедленно выдать предупреждение на экран, чётко указывая тип события и имя 'пострадавшего' или 'изменившегося' элемента, например: '[MODIFY] [имя файла или папки]' или '[DELETE] [имя файла или папки]'.
Чтобы не перегружать систему и проверить её работу, после того как будет обработано три таких события, ваша программа-наблюдатель должна тактично завершить свою работу. Ваша цель — быть в курсе каждого важного действия в этой папке.

Требования:
•	Программа должна использовать WatchService для отслеживания изменений в файловой системе.
•	Программа должна отслеживать события только в директории 'watched'.
•	Программа должна регистрировать и реагировать только на события ENTRY_MODIFY и ENTRY_DELETE.
•	При обнаружении события программа должна выводить сообщение в формате '[MODIFY] [имя файла или папки]' для изменений и '[DELETE] [имя файла или папки]' для удалений.
•	После обработки трёх событий (ENTRY_MODIFY или ENTRY_DELETE) программа должна завершить свою работу.
•	Программа должна корректно обрабатывать события как для файлов, так и для папок внутри директории 'watched'.

import java.nio.file.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        // Путь к наблюдаемой директории (относительно рабочей директории процесса)


        // Создаём директорию, если её нет — чтобы пример можно было запустить сразу


        // Создаём WatchService и регистрируем интересующие события
        // Регистрируем ТОЛЬКО два вида событий: MODIFY и DELETE


        // счётчик обработанных событий

        // Внешняя метка, чтобы можно было прервать оба цикла сразу после 3 событий

        // Блокирующее ожидание ключа событий (как только что-то произошло — получим ключ)


        // Обрабатываем все события, пришедшие одним "пакетом"

        // OVERFLOW иногда приходит системно — пропускаем его



        // Имя изменённого/удалённого элемента внутри папки 'watched'
        // относительное имя внутри 'watched'

        // Вывод строго в требуемом формате






        // После трёх событий — завершаем работу




        // Подтверждаем готовность снова принимать события по этому ключу

        // Ключ стал невалидным (например, директорию удалили) — выходим




    }
}

 */

import java.nio.file.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        // Путь к наблюдаемой директории (относительно рабочей директории процесса)
        Path pathToWatch = Paths.get("watched");

        // Создаём директорию, если её нет — чтобы пример можно было запустить сразу
        Files.createDirectories(pathToWatch);

        // Создаём WatchService и регистрируем интересующие события
        // Регистрируем ТОЛЬКО два вида событий: MODIFY и DELETE
        WatchService watchService = FileSystems.getDefault().newWatchService();
        pathToWatch.register(watchService
                , StandardWatchEventKinds.ENTRY_MODIFY
                , StandardWatchEventKinds.ENTRY_DELETE);

//        System.out.println("Слежение за папкой: " + pathToWatch.toAbsolutePath());


        // счётчик обработанных событий
        int count = 0;
        while (true) {
            WatchKey key = watchService.take(); // ждём события

            for (WatchEvent<?> event : key.pollEvents()) {
                WatchEvent.Kind<?> kind = event.kind();
                if (event.kind() == StandardWatchEventKinds.ENTRY_MODIFY) {
                    Path filename = (Path) event.context();
                    System.out.println("[MODIFY] " + filename);
                    count++;
                    if (count == 3) {
                        return;
                    }

                }
                if (event.kind() == StandardWatchEventKinds.ENTRY_DELETE) {
                    Path filename = (Path) event.context();
                    System.out.println("[DELETE] " + filename);
                    count++;
                    if (count > 2) {
                        return;
                    }

                }

            }

            key.reset();

        }

        // Внешняя метка, чтобы можно было прервать оба цикла сразу после 3 событий

        // Блокирующее ожидание ключа событий (как только что-то произошло — получим ключ)


        // Обрабатываем все события, пришедшие одним "пакетом"

        // OVERFLOW иногда приходит системно — пропускаем его


        // Имя изменённого/удалённого элемента внутри папки 'watched'
        // относительное имя внутри 'watched'

        // Вывод строго в требуемом формате


        // После трёх событий — завершаем работу


        // Подтверждаем готовность снова принимать события по этому ключу

        // Ключ стал невалидным (например, директорию удалили) — выходим


    }
}

/*

public class Solution {
    public static void main(String[] args) throws Exception {
        // Путь к наблюдаемой директории (относительно рабочей директории процесса)
        Path dir = Paths.get("watched");

        // Создаём директорию, если её нет — чтобы пример можно было запустить сразу
        Files.createDirectories(dir);

        // Создаём WatchService и регистрируем интересующие события
        try (WatchService watchService = FileSystems.getDefault().newWatchService()) {
            // Регистрируем ТОЛЬКО два вида событий: MODIFY и DELETE
            dir.register(
                    watchService,
                    StandardWatchEventKinds.ENTRY_MODIFY,
                    StandardWatchEventKinds.ENTRY_DELETE
            );

            int handled = 0; // счётчик обработанных событий

            // Внешняя метка, чтобы можно было прервать оба цикла сразу после 3 событий
            outer:
            while (handled < 3) {
                // Блокирующее ожидание ключа событий (как только что-то произошло — получим ключ)
                WatchKey key = watchService.take();

                // Обрабатываем все события, пришедшие одним "пакетом"
                for (WatchEvent<?> event : key.pollEvents()) {
                    WatchEvent.Kind<?> kind = event.kind();

                    // OVERFLOW иногда приходит системно — пропускаем его
                    if (kind == StandardWatchEventKinds.OVERFLOW) {
                        continue;
                    }

                    // Имя изменённого/удалённого элемента внутри папки 'watched'
                    @SuppressWarnings("unchecked")
                    WatchEvent<Path> ev = (WatchEvent<Path>) event;
                    Path name = ev.context(); // относительное имя внутри 'watched'

                    // Вывод строго в требуемом формате
                    if (kind == StandardWatchEventKinds.ENTRY_MODIFY) {
                        System.out.println("[MODIFY] " + name);
                        handled++;
                    } else if (kind == StandardWatchEventKinds.ENTRY_DELETE) {
                        System.out.println("[DELETE] " + name);
                        handled++;
                    }

                    // После трёх событий — завершаем работу
                    if (handled >= 3) {
                        break outer;
                    }
                }

                // Подтверждаем готовность снова принимать события по этому ключу
                boolean valid = key.reset();
                if (!valid) {
                    // Ключ стал невалидным (например, директорию удалили) — выходим
                    break;
                }
            }
        }
    }
}

 */