package com.javarush.task.task29.task2902;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

/* 
Рефакторинг в соответствии с Naming and Code Convention 2
Исправить код в соответствии с Naming and Code Convention (Shift+F6 для рефакторинга).

Требования:
•	Переименуй переменную Solution типа Solution в соответствии с Naming and Code Convention.
•	Переименуй переменную name_of_file_to_be_opened_by_notepad типа String в соответствии с Naming and Code Convention.
•	Переименуй переменную NOTEPAD типа Process в соответствии с Naming and Code Convention.
•	Переименуй метод getstartnotepadprocess() в соответствии с Naming and Code Convention.
•	Переименуй параметр FILE_NAME метода принимающего String в соответствии с Naming and Code Convention.
•	Переименуй переменную cmd_array типа String[] в соответствии с Naming and Code Convention.
•	Переименуй метод Getabsolutepathtodefaulttxtfile() в соответствии с Naming and Code Convention.
•	Переименуй переменную uRi типа URI в соответствии с Naming and Code Convention.

public class Solution {
    public static void main(String[] args) throws IOException, InterruptedException, URISyntaxException {
        Solution Solution = new Solution();
        String name_of_file_to_be_opened_by_notepad = Solution.Getabsolutepathtodefaulttxtfile().toString();
        Process NOTEPAD = Solution.getstartnotepadprocess(name_of_file_to_be_opened_by_notepad);
        NOTEPAD.waitFor();
    }

    public Process getstartnotepadprocess(String FILE_NAME) throws IOException {
        String[] cmd_array = new String[]{"notepad.exe", FILE_NAME};
        return Runtime.getRuntime().exec(cmd_array);
    }

    public Path Getabsolutepathtodefaulttxtfile() throws URISyntaxException {
        URI uRi = Solution.class.getResource("file.txt").toURI();
        return Paths.get(uRi);
    }
}


*/

public class Solution {
    public static void main(String[] args) throws IOException, InterruptedException, URISyntaxException {
        Solution solution = new Solution();
        String nameOfFileToBeOpenedByNotepad = solution.getAbsolutePathToDefaultTxtFile().toString();
        Process notepad = solution.getStartNotepadProcess(nameOfFileToBeOpenedByNotepad);
        notepad.waitFor();
    }

    public Path getAbsolutePathToDefaultTxtFile() throws URISyntaxException {
        URI uri = Solution.class.getResource("file.txt").toURI();
        return Paths.get(uri);
    }

    public Process getStartNotepadProcess(String fileName) throws IOException {
        String[] cmdArray = new String[]{"notepad.exe", fileName};
        return Runtime.getRuntime().exec(cmdArray);
    }

}
