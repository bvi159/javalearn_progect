package ru.javarush.java.core.level11.task15;

/*
Конвейер обработки данных: ожидаемые проблемы с файлом ⚙️
Вы отвечаете за ключевую часть конвейера обработки данных: чтение файла и извлечение из него первой строки. При этом вы прекрасно понимаете, что могут возникнуть две основные проблемы: файл может не существовать, или что-то пойдёт не так во время самого чтения.

Создайте метод public static void extractFirstLineFromData(String dataFile). Этот метод должен в своей сигнатуре объявить, что он "пробрасывает" (throws) как FileNotFoundException, так и IOException.

Внутри метода сначала попробуйте создать FileReader для dataFile, а затем, используя BufferedReader (обернув им FileReader), попытайтесь прочитать первую строку. Важно: этот метод сам не должен обрабатывать эти исключения; он лишь передает ответственность за их обработку наверх, тому, кто его вызовет.

Требования:
•	Метод extractFirstLineFromData должен явно объявлять в своей сигнатуре, что он пробрасывает (throws) FileNotFoundException и IOException.
•	Метод extractFirstLineFromData не должен самостоятельно обрабатывать (catch) исключения FileNotFoundException и IOException; они должны передаваться вызывающему коду.
•	Внутри метода необходимо создать объект FileReader для файла, путь к которому передан в параметре dataFile.
•	Для чтения строк из файла FileReader должен быть обёрнут в BufferedReader.
•	Метод должен попытаться прочитать первую строку файла с помощью BufferedReader.
•	Метод extractFirstLineFromData должен быть объявлен с модификаторами public static.

public class Solution {

    public static void extractFirstLineFromData(String dataFile)  {
        // Создаем FileReader для чтения файла


        // Оборачиваем FileReader в BufferedReader для построчного чтения


        // Читаем первую строку из файла


        // Закрываем BufferedReader (он автоматически закроет и FileReader)


        // Выводим первую строку на экран (опционально, если требуется)

    }

    public static void main(String[] args) {

    }
}


 */
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Solution {

    public static void extractFirstLineFromData(String dataFile) throws FileNotFoundException, IOException {
        // Создаем FileReader для чтения файла
        FileReader myFile = new FileReader(dataFile);
        
        // Оборачиваем FileReader в BufferedReader для построчного чтения
        BufferedReader whatWeRead = new BufferedReader(myFile);

        
        // Читаем первую строку из файла
        String firstString = whatWeRead.readLine();
        
        // Закрываем BufferedReader (он автоматически закроет и FileReader)
        whatWeRead.close();
        
        // Выводим первую строку на экран (опционально, если требуется)
        System.out.println(firstString);

    }

    public static void main(String[] args) {
//        Solution myNewSolution = new Solution();
        try {
            extractFirstLineFromData("some_file.txt");
        } catch (FileNotFoundException e) {
            System.out.println("Нет такого файла: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Файл повреждён или занят: " + e.getMessage());
        }

        
    }
}
/*
Ихнее решение
public class Solution {

    public static void extractFirstLineFromData(String dataFile) throws FileNotFoundException, IOException {
        // Создаем FileReader для чтения файла
        FileReader fileReader = new FileReader(dataFile);

        // Оборачиваем FileReader в BufferedReader для построчного чтения
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        // Читаем первую строку из файла
        String firstLine = bufferedReader.readLine();

        // Закрываем BufferedReader (он автоматически закроет и FileReader)
        bufferedReader.close();

        // Выводим первую строку на экран (опционально, если требуется)
        System.out.println(firstLine);
    }

    public static void main(String[] args) {

    }
}

 */