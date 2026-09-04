package ru.javarush.java.core.level27.task04;
/*
Управление списком технологий для проекта 🛠️

Вы курируете список технологий, используемых в вашем IT-проекте. Внезапно выясняется, что некоторые старые или специфические технологии, содержащие символ +, больше не поддерживаются и их нужно удалить из общего списка.
Создайте множество HashSet<String> и добавьте в него названия технологий: "java", "python", "c++", "javascript". Теперь, ваша задача — очистить список от тех технологий, которые содержат устаревший символ +. Для этого используйте итератор. После того как ненужные технологии будут удалены, с помощью цикла for-each выведите оставшиеся, актуальные элементы множества, каждый на новой строке, чтобы убедиться, что список обновлён корректно.

Требования:
•	В программе должно быть создано множество типа HashSet<String>.
•	В множество должны быть добавлены строки: "java", "python", "c++", "javascript".
•	Для удаления технологий, содержащих символ '+', должен быть использован Iterator и его метод remove().
•	Удаляться должны только те элементы множества, в названии которых содержится символ '+'.
•	После удаления, программа должна вывести оставшиеся элементы множества, используя цикл for-each.
•	Каждая оставшаяся технология должна быть выведена на новой строке.

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        // Создаем множество HashSet<String> для хранения технологий


        // Добавляем названия технологий


        // Удаляем элементы, содержащие символ '+', используя итератор


        // Выводим оставшиеся элементы множества, каждый на новой строке (порядок не гарантируется)

    }
}

 */

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        // Создаем множество HashSet<String> для хранения технологий
        Set<String> tecnologies = new HashSet<>();
        tecnologies.addAll(Arrays.asList("java", "python", "c++", "javascript"));

        Iterator<String> it = tecnologies.iterator();

        while (it.hasNext()) {
            String techn = it.next();
            if (techn.contains("+")) {
                it.remove();
            }
        }

        for (String s : tecnologies) {
            System.out.println(s);
        }

        // Добавляем названия технологий


        // Удаляем элементы, содержащие символ '+', используя итератор


        // Выводим оставшиеся элементы множества, каждый на новой строке (порядок не гарантируется)

    }
}

/*
public class Solution {
    public static void main(String[] args) {
        // Создаем множество HashSet<String> для хранения технологий
        Set<String> technologies = new HashSet<>();

        // Добавляем названия технологий
        technologies.add("java");
        technologies.add("python");
        technologies.add("c++");
        technologies.add("javascript");

        // Удаляем элементы, содержащие символ '+', используя итератор
        // Важно: удаление через итератор — корректный способ во время обхода коллекции
        Iterator<String> it = technologies.iterator();
        while (it.hasNext()) {
            String tech = it.next();
            if (tech.contains("+")) { // проверяем наличие символа '+'
                it.remove();          // удаляем текущий элемент безопасно
            }
        }

        // Выводим оставшиеся элементы множества, каждый на новой строке (порядок не гарантируется)
        for (String tech : technologies) {
            System.out.println(tech);
        }
    }
}
 */