package ru.javarush.java.core.level47.task06;
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
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.InputStream;

public class Solution {
    public static void main(String[] args) throws Exception {
        // Создаем фабрику и открываем поток к файлу sample.xml




        // После создания reader уже указывает на текущее событие (обычно START_DOCUMENT)
        // Идем по всем событиям до END_DOCUMENT включительно
        while (true) {
            int event = reader.getEventType();


            if (event == XMLStreamConstants.END_DOCUMENT) {

            }


        }



    }

    // Преобразуем числовой код события в человекочитаемое имя
    private static String eventName(int type) {
        switch (type) {
            case XMLStreamConstants.START_ELEMENT: return "START_ELEMENT";
            case XMLStreamConstants.END_ELEMENT: return "END_ELEMENT";
            case XMLStreamConstants.CHARACTERS: return "CHARACTERS";
            case XMLStreamConstants.CDATA: return "CDATA";
            case XMLStreamConstants.COMMENT: return "COMMENT";
            case XMLStreamConstants.SPACE: return "SPACE";
            case XMLStreamConstants.START_DOCUMENT: return "START_DOCUMENT";
            case XMLStreamConstants.END_DOCUMENT: return "END_DOCUMENT";
            case XMLStreamConstants.PROCESSING_INSTRUCTION: return "PROCESSING_INSTRUCTION";
            case XMLStreamConstants.ENTITY_REFERENCE: return "ENTITY_REFERENCE";
            case XMLStreamConstants.DTD: return "DTD";
            case XMLStreamConstants.ATTRIBUTE: return "ATTRIBUTE";
            case XMLStreamConstants.NAMESPACE: return "NAMESPACE";
            case XMLStreamConstants.NOTATION_DECLARATION: return "NOTATION_DECLARATION";
            case XMLStreamConstants.ENTITY_DECLARATION: return "ENTITY_DECLARATION";
            default: return "UNKNOWN(" + type + ")";
        }
    }
}

 */
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.InputStream;

public class Solution {
    public static void main(String[] args) throws Exception {
        // Создаем фабрику и открываем поток к файлу sample.xml
        XMLInputFactory factory = XMLInputFactory.newInstance();
        XMLStreamReader reader = factory.createXMLStreamReader(new FileInputStream("sample.xml"));

        // После создания reader уже указывает на текущее событие (обычно START_DOCUMENT)
        // Идем по всем событиям до END_DOCUMENT включительно
        while (true) {
            int event = reader.getEventType();
            System.out.println(eventName(event));
            if (reader.hasNext()) {
                reader.next();
            }
            if (event == XMLStreamConstants.END_DOCUMENT) {
                break;
            }

        }

    }

    // Преобразуем числовой код события в человекочитаемое имя
    private static String eventName(int type) {
        switch (type) {
            case XMLStreamConstants.START_ELEMENT: return "START_ELEMENT";
            case XMLStreamConstants.END_ELEMENT: return "END_ELEMENT";
            case XMLStreamConstants.CHARACTERS: return "CHARACTERS";
            case XMLStreamConstants.CDATA: return "CDATA";
            case XMLStreamConstants.COMMENT: return "COMMENT";
            case XMLStreamConstants.SPACE: return "SPACE";
            case XMLStreamConstants.START_DOCUMENT: return "START_DOCUMENT";
            case XMLStreamConstants.END_DOCUMENT: return "END_DOCUMENT";
            case XMLStreamConstants.PROCESSING_INSTRUCTION: return "PROCESSING_INSTRUCTION";
            case XMLStreamConstants.ENTITY_REFERENCE: return "ENTITY_REFERENCE";
            case XMLStreamConstants.DTD: return "DTD";
            case XMLStreamConstants.ATTRIBUTE: return "ATTRIBUTE";
            case XMLStreamConstants.NAMESPACE: return "NAMESPACE";
            case XMLStreamConstants.NOTATION_DECLARATION: return "NOTATION_DECLARATION";
            case XMLStreamConstants.ENTITY_DECLARATION: return "ENTITY_DECLARATION";
            default: return "UNKNOWN(" + type + ")";
        }
    }
}
/*

public class Solution {
    public static void main(String[] args) throws Exception {
        // Создаем фабрику и открываем поток к файлу sample.xml
        XMLInputFactory factory = XMLInputFactory.newInstance();
        try (InputStream in = new FileInputStream("sample.xml")) {
            XMLStreamReader reader = factory.createXMLStreamReader(in);

            // После создания reader уже указывает на текущее событие (обычно START_DOCUMENT)
            // Идем по всем событиям до END_DOCUMENT включительно
            while (true) {
                int event = reader.getEventType();
                System.out.println(eventName(event)); // Печатаем тип события

                if (event == XMLStreamConstants.END_DOCUMENT) {
                    break; // Достигнут конец документа — завершаем цикл
                }

                reader.next(); // Переходим к следующему событию
            }

            reader.close(); // Явно закрываем парсер
        }
    }


 */