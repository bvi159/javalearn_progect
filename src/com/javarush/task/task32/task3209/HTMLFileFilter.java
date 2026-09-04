package com.javarush.task.task32.task3209;

import javax.swing.filechooser.FileFilter;
import java.io.File;

public class HTMLFileFilter extends FileFilter {
    @Override
    public boolean accept(File file) {
        // Проверяем, является ли файл директорией
        if (file.isDirectory()) {
            return true;
        }

        // Получаем имя файла
        String fileName = file.getName().toLowerCase();

        // Проверяем расширение файла (без учета регистра)
        return fileName.endsWith(".html") || fileName.endsWith(".htm");
    }

    @Override
    public String getDescription() {
        return "HTML и HTM файлы";
    }
}
