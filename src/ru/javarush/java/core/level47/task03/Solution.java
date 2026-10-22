package ru.javarush.java.core.level47.task03;
/*
Опознание Главного Раздела Библиотеки 🏛️
Вы — цифровой архивариус, которому предстоит работать с множеством электронных библиотечных фондов, каждый из которых представлен в виде XML-файла. Ваша первая задача — быстро определить, что собой представляет корневая коллекция в одном из таких файлов.

Для начала, создайте XML-файл с названием, например, "library_catalog.xml", и поместите в него следующую структуру:

<library>
    <book>
        <title>Java для начинающих</title>
    </book>
</library>
Теперь, вооружившись мощью DOM-парсера, напишите программу, которая откроет этот файл. Ваша главная цель — выяснить и гордо вывести на экран имя самого главного элемента, который управляет всей структурой документа. Это поможет вам сразу понять, с каким типом коллекции вы имеете дело.

Требования:
•	Программа должна использовать DOM-парсер для открытия и чтения XML-файла.
•	Программа должна открывать файл с именем library_catalog.xml.
•	Программа должна определить имя корневого элемента XML-документа.
•	Программа должна вывести на экран имя корневого элемента, управляющего структурой документа.

import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class Solution {
    public static void main(String[] args) throws Exception {
        // Создаем фабрику и билдер DOM (стандартный способ парсить XML в память)


        // Открываем и парсим XML-файл library_catalog.xml


        // Нормализация приводит документ к каноничному виду (убирает лишние текстовые узлы и т.п.)


        // Получаем имя корневого элемента (главного узла)


        // Выводим имя корневого элемента на экран

    }
}

 */
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class Solution {
    public static void main(String[] args) throws Exception {
        // Создаем фабрику и билдер DOM (стандартный способ парсить XML в память)
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        // Открываем и парсим XML-файл library_catalog.xml
        Document doc = builder.parse(new File("library_catalog.xml"));

        // Нормализация приводит документ к каноничному виду (убирает лишние текстовые узлы и т.п.)
        Element root = doc.getDocumentElement();
        System.out.println("Корневой элемент: " + root.getTagName());

        NodeList books = root.getElementsByTagName("book");

        for (int i = 0; i < books.getLength(); i++) {
            Element mybook = (Element) books.item(i);
//            String myTitle = mybook.getAttribute("title");
            String myTitle = mybook.getElementsByTagName("title").item(0).getTextContent();
//            String id = person.getAttribute("id");
//            String name = person.getElementsByTagName("name").item(0).getTextContent();
//            String email = person.getElementsByTagName("email").item(0).getTextContent();
            System.out.println("Title: " + myTitle);
//            System.out.println("id: " + id + ", name: " + name + ", email: " + email);
        }

//        String myTitle = book.getElementsByTagName("title").item(0).getTextContent();

        // Получаем имя корневого элемента (главного узла)


        // Выводим имя корневого элемента на экран
//        System.out.println("Title: " + books);
    }
}

/*
package ru.javarush.java.core.level47.task03;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;

public class Solution {
    public static void main(String[] args) throws Exception {
        // Создаем фабрику и билдер DOM (стандартный способ парсить XML в память)
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        // Открываем и парсим XML-файл library_catalog.xml
        Document document = builder.parse(new File("library_catalog.xml"));

        // Нормализация приводит документ к каноничному виду (убирает лишние текстовые узлы и т.п.)
        document.getDocumentElement().normalize();

        // Получаем имя корневого элемента (главного узла)
        String rootName = document.getDocumentElement().getTagName();

        // Выводим имя корневого элемента на экран
        System.out.println(rootName);
    }
}
 */