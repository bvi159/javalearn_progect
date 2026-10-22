package ru.javarush.java.core.level47.task04;
/*
Список Персонажей или Пользователей в Системе 👤
Представьте, что вы системный администратор, который управляет базой данных пользователей, или гейм-мастер, ведущий учёт всех персонажей в своей виртуальной вселенной.

У вас есть XML-файл с информацией о пользователях. Вот его содержимое:

<users>
    <user id="101" name="Alice"/>
    <user id="102" name="Bob"/>
</users>
Ваша задача — написать программу на Java, используя DOM-парсер, которая сможет "пройтись" по этому файлу и извлечь идентификатор (id) и имя (name) каждого пользователя.

Затем выведите эти данные на экран в следующем, легко читаемом формате для каждого пользователя:

id: [значение_id], name: [значение_name]
Это позволит вам быстро получить обзор всех зарегистрированных сущностей в вашей системе.

Требования:
•	Программа должна использовать DOM-парсер для разбора XML-файла.
•	Программа должна корректно загружать и парсить XML-файл, содержащий список пользователей.
•	Программа должна находить все элементы <user> внутри корневого элемента <users>.
•	Для каждого элемента <user> необходимо извлекать значения атрибутов id и name.
•	Для каждого пользователя программа должна выводить строку в формате: id: [значение_id], name: [значение_name].
•	Программа должна корректно обрабатывать и выводить информацию о каждом пользователе, присутствующем в XML-файле.

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class Solution {
    public static void main(String[] args) throws Exception {
        // Пусть путь к XML можно передать аргументом, а по умолчанию читаем файл "users.xml" из текущей папки
        String filePath = (args.length > 0) ? args[0] : "users.xml";

        // Создаем фабрику DOM-парсера и сам парсер

        // Разбираем XML-файл в объект Document (DOM-дерево)


        // Нормализуем документ (склеивает текстовые узлы, убирает лишние пробелы между тегами и т.п.)


        // Находим все элементы <user> в документе


        // Проходим по всем найденным <user>


            // Проверяем, что узел — это именно элемент (а не, например, текстовый узел)


                // Извлекаем значения атрибутов id и name


                // Выводим информацию в требуемом формате



    }
}

 */
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class Solution {
    public static void main(String[] args) throws Exception {
        // Пусть путь к XML можно передать аргументом, а по умолчанию читаем файл "users.xml" из текущей папки
        String filePath = (args.length > 0) ? args[0] : "users.xml";

        // Создаем фабрику DOM-парсера и сам парсер
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        Document doc = builder.parse(filePath);;

        // Нормализация приводит документ к каноничному виду (убирает лишние текстовые узлы и т.п.)
        Element root = doc.getDocumentElement();
        System.out.println("Корневой элемент: " + root.getTagName());

        NodeList users = root.getElementsByTagName("user");

        for (int i = 0; i < users.getLength(); i++) {
            Element myUser = (Element) users.item(i);
            String id = myUser.getAttribute("id");
            String name = myUser.getAttribute("name");
//            String id = person.getAttribute("id");
//            String name = person.getElementsByTagName("name").item(0).getTextContent();
//            String email = person.getElementsByTagName("email").item(0).getTextContent();
            System.out.println("id: " + id + ", name: " + name);
        }

    }
}

/*

package ru.javarush.java.core.level47.task04;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class Solution {
    public static void main(String[] args) throws Exception {
        // Пусть путь к XML можно передать аргументом, а по умолчанию читаем файл "users.xml" из текущей папки
        String filePath = (args.length > 0) ? args[0] : "users.xml";

        // Создаем фабрику DOM-парсера и сам парсер
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        // Разбираем XML-файл в объект Document (DOM-дерево)
        Document document = factory.newDocumentBuilder().parse(new File(filePath));

        // Нормализуем документ (склеивает текстовые узлы, убирает лишние пробелы между тегами и т.п.)
        document.getDocumentElement().normalize();

        // Находим все элементы <user> в документе
        NodeList users = document.getElementsByTagName("user");

        // Проходим по всем найденным <user>
        for (int i = 0; i < users.getLength(); i++) {
            Node node = users.item(i);

            // Проверяем, что узел — это именно элемент (а не, например, текстовый узел)
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element userElement = (Element) node;

                // Извлекаем значения атрибутов id и name
                String id = userElement.getAttribute("id");
                String name = userElement.getAttribute("name");

                // Выводим информацию в требуемом формате
                System.out.println("id: " + id + ", name: " + name);
            }
        }
    }
}

 */