package ru.javarush.java.core.level47.task05;
/*
Подготовка Потокового Анализа Данных ⚙️
Вы — аналитик данных, которому нужно обработать непрерывный поток информации, поступающей в формате XML. Прежде чем приступить к глубокому анализу, вам необходимо подготовить инструменты для чтения этого потока.

Ваша задача — использовать XMLInputFactory, чтобы создать объект XMLStreamReader.

Этот ридер будет отвечать за последовательное чтение вашего "потокового" XML-файла, который для упражнения назовем "example.xml" и который находится в вашей текущей рабочей директории. Как только вы успешно создадите этот важный инструмент, подтвердите его готовность, выведя на экран сообщение "Парсер создан". Это станет сигналом, что ваш механизм чтения потока готов к работе.

Требования:
•	В программе должны быть импортированы необходимые классы из пакета javax.xml.stream для работы с StAX (например, XMLInputFactory и XMLStreamReader).
•	В коде должен быть создан объект XMLInputFactory с помощью метода XMLInputFactory.newInstance().
•	С помощью созданного XMLInputFactory должен быть создан объект XMLStreamReader для файла "example.xml", расположенного в текущей рабочей директории.
•	Имя файла, для которого создается XMLStreamReader, должно быть "example.xml".
•	После успешного создания XMLStreamReader программа должна вывести на экран сообщение "Парсер создан".

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.InputStream;

public class Solution {
    public static void main(String[] args) throws Exception {
        // Создаем фабрику StAX-парсеров


        // Открываем файл "example.xml" из текущей директории

            // Создаем XMLStreamReader на основе входного потока


            // Если объект успешно создан — сообщаем об этом


            // Закрываем ридер (поток закроется автоматически благодаря try-with-resources)


    }
}

 */
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.InputStream;

public class Solution {
    public static void main(String[] args) throws Exception {
        // Создаем фабрику StAX-парсеров
        XMLInputFactory factory = XMLInputFactory.newInstance();
        // Открываем файл "example.xml" из текущей директории

            // Создаем XMLStreamReader на основе входного потока
        XMLStreamReader reader = factory.createXMLStreamReader(new FileInputStream("example.xml"),"UTF-8");

        System.out.println("Парсер создан");
            // Если объект успешно создан — сообщаем об этом
        reader.close();

            // Закрываем ридер (поток закроется автоматически благодаря try-with-resources)


    }
}



/*

public class Solution {
    public static void main(String[] args) throws Exception {
        // Создаем фабрику StAX-парсеров
        XMLInputFactory factory = XMLInputFactory.newInstance();

        // Открываем файл "example.xml" из текущей директории
        try (InputStream is = new FileInputStream("example.xml")) {
            // Создаем XMLStreamReader на основе входного потока
            XMLStreamReader reader = factory.createXMLStreamReader(is);

            // Если объект успешно создан — сообщаем об этом
            System.out.println("Парсер создан");

            // Закрываем ридер (поток закроется автоматически благодаря try-with-resources)
            reader.close();
        }
    }
}

 */