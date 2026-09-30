package ru.javarush.java.core.level40.task09;
/*
Установка бдительного наблюдателя за новой папкой 👁️‍🗨️
Представьте, что вы — руководитель службы безопасности, и вам поручено следить за 'тайной комнатой' в вашей цифровой системе, которая называется 'watched'. Эта комната создаётся в текущей рабочей директории, если её там ещё нет.

Ваша задача — настроить бдительного 'наблюдателя' — WatchService, который будет мгновенно реагировать на любые новые 'явления': будь то появление свежего файла или целой новой папки внутри 'watched'.

Вам нужно зарегистрировать эту папку для отслеживания именно таких событий создания (StandardWatchEventKinds.ENTRY_CREATE). Как только ваш 'наблюдатель' будет готов и займёт свой пост, программа должна громко объявить: 'Слежение за папкой: [абсолютный путь к watched]', чтобы все знали, что за этим местом теперь ведётся неусыпный контроль.

Требования:
•	Программа должна проверить наличие папки с именем 'watched' в текущей рабочей директории и создать её, если она отсутствует.
•	Программа должна создать экземпляр WatchService для отслеживания изменений в файловой системе.
•	Папка 'watched' должна быть зарегистрирована в WatchService для слежения только за событиями создания файлов и папок (StandardWatchEventKinds.ENTRY_CREATE).
•	После успешной регистрации папки в WatchService программа должна вывести на экран строку 'Слежение за папкой: [абсолютный путь к watched]', где путь должен быть абсолютным.

import java.nio.file.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        // Путь к папке 'watched' в текущей рабочей директории
        // Paths.get("watched") интерпретируется относительно user.dir


        // Создаем папку, если её нет (и недостающие родительские директории тоже)


        // Создаем сервис слежения за изменениями в файловой системе (NIO2)


            // Регистрируем папку только на события создания (файлов и папок)
            // ENTRY_CREATE покрывает появление новых элементов внутри 'watched'


            // Сообщаем, что слежение настроено


    }
}

 */

import java.nio.file.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        // Путь к папке 'watched' в текущей рабочей директории
        // Paths.get("watched") интерпретируется относительно user.dir
        Path pathToWatch = Paths.get("watched");


        // Создаем папку, если её нет (и недостающие родительские директории тоже)
        Files.createDirectories(pathToWatch);


        // Создаем сервис слежения за изменениями в файловой системе (NIO2)
        WatchService watchService = FileSystems.getDefault().newWatchService();
        pathToWatch.register(watchService, StandardWatchEventKinds.ENTRY_CREATE);

        System.out.println("Слежение за папкой: " + pathToWatch.toAbsolutePath());

        // Регистрируем папку только на события создания (файлов и папок)
        // ENTRY_CREATE покрывает появление новых элементов внутри 'watched'


        // Сообщаем, что слежение настроено


    }
}
/*
public class Solution {
    public static void main(String[] args) throws Exception {
        // Путь к папке 'watched' в текущей рабочей директории
        // Paths.get("watched") интерпретируется относительно user.dir
        Path watchedDir = Paths.get("watched");

        // Создаем папку, если её нет (и недостающие родительские директории тоже)
        Files.createDirectories(watchedDir);

        // Создаем сервис слежения за изменениями в файловой системе (NIO2)
        try (WatchService watchService = FileSystems.getDefault().newWatchService()) {

            // Регистрируем папку только на события создания (файлов и папок)
            // ENTRY_CREATE покрывает появление новых элементов внутри 'watched'
            watchedDir.register(watchService, StandardWatchEventKinds.ENTRY_CREATE);

            // Сообщаем, что слежение настроено
            System.out.println("Слежение за папкой: " + watchedDir.toAbsolutePath());
        }
    }
}
 */