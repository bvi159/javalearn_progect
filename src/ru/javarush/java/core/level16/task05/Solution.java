package ru.javarush.java.core.level16.task05;
/*
Инструментарий волшебника: активизация заклинания 🔮

Вы разрабатываете универсальный инструментарий для молодого волшебника. Некоторые заклинания являются настолько общими и фундаментальными, что их можно активировать, не имея в руках конкретной волшебной палочки или книги заклинаний – они просто существуют как часть магического мира.
Вам нужно создать класс Spellbook, представляющий общий сборник заклинаний. Внутри Spellbook объявите статический вложенный класс с именем BasicCharm. Этот BasicCharm должен содержать метод castSpell(), который выводит на экран фразу: "Hello from static basic charm!".
В главном методе вашей программы (main) создайте экземпляр BasicCharm, не привязываясь к конкретному Spellbook. Затем вызовите метод castSpell() для созданного BasicCharm, чтобы убедиться, что заклинание успешно активировано.

Требования:
•	Внутри класса Spellbook должен быть объявлен статический вложенный класс с именем BasicCharm.
•	Класс BasicCharm должен содержать публичный метод с именем castSpell.
•	Метод castSpell должен выводить на экран строку "Hello from static basic charm!".
•	В методе main должен быть создан экземпляр класса Spellbook.BasicCharm без необходимости создания экземпляра Spellbook.
•	В методе main должен быть вызван метод castSpell() для созданного экземпляра BasicCharm.

public class Solution {
    public static void main(String[] args) {
        // Создаём экземпляр статического вложенного класса
        // Важно: объект внешнего класса Spellbook не нужен
        Spellbook.BasicCharm charm = new Spellbook.BasicCharm();

        // Активируем заклинание
        charm.castSpell();
    }
}

 */
public class Solution {
    public static void main(String[] args) {
        // Создаём экземпляр статического вложенного класса
        // Важно: объект внешнего класса Spellbook не нужен
        Spellbook.BasicCharm charm = new Spellbook.BasicCharm();

        // Активируем заклинание
        charm.castSpell();
    }
}

class Spellbook {
    static class BasicCharm {
        public void castSpell() {
            System.out.println("Hello from static basic charm!");
        }
    }
}

/*
// Класс-«сборник заклинаний»
class Spellbook {
    // Статический вложенный класс — существует независимо от экземпляров Spellbook
    public static class BasicCharm {
        // Публичный метод, который выводит требуемую строку
        public void castSpell() {
            System.out.println("Hello from static basic charm!");
        }
    }
}
 */