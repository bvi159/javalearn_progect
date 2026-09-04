package ru.javarush.java.core.level16.task03;
/*
Магическая библиотека: каталогизация свитков 📜

Вы — главный хранитель тайной магической библиотеки, где каждый свиток с заклинанием является частью большой коллекции. Библиотека содержит свитки, но каждый свиток сам по себе является отдельной сущностью со своим названием.

Создайте класс Library, представляющий вашу магическую обитель. Добавьте в него метод addScroll(String scrollTitle), который пока ничего не делает, но показывает, что библиотека может принимать новые свитки. Внутри класса Library объявите внутренний класс Scroll. Этот внутренний класс Scroll должен иметь приватное строковое поле scrollTitle для хранения названия свитка и метод revealTitle(), который выводит это название на экран.

В методе main вашей программы создайте объект Library. Затем, через этот объект Library, создайте новый Scroll с названием "Ancient Runes" и вызовите его метод revealTitle(). Ваша программа должна показать название этого древнего свитка.

Требования:
•	В программе должен быть объявлен класс с именем Library.
•	Класс Library должен содержать публичный метод addScroll(String scrollTitle), который пока не реализует никакой логики.
•	Внутри класса Library должен быть объявлен внутренний (non-static) класс с именем Scroll.
•	Внутренний класс Scroll должен иметь приватное строковое поле scrollTitle для хранения названия свитка.
•	Внутренний класс Scroll должен содержать публичный метод revealTitle(), который выводит на экран значение поля scrollTitle.
•	В методе main должен быть создан объект класса Library.
•	Через объект класса Library в методе main должен быть создан объект внутреннего класса Scroll с названием "Ancient Runes".
•	В методе main должен быть вызван метод revealTitle() у созданного объекта класса Scroll, и на экран должно быть выведено название свитка "Ancient Runes".

public class Solution {
    public static void main(String[] args) {
        // Создаем объект библиотеки
        Library library = new Library();

        // Создаем объект нестатического внутреннего класса через объект внешнего класса
        // Синтаксис library.new Scroll(...) обязателен для non-static inner классов
        Library.Scroll scroll = library.new Scroll("Ancient Runes");

        // Показываем название свитка
        scroll.revealTitle();
    }
}

 */
public class Solution {
    public static void main(String[] args) {
        // Создаем объект библиотеки
        Library library = new Library();

        // Создаем объект нестатического внутреннего класса через объект внешнего класса
        // Синтаксис library.new Scroll(...) обязателен для non-static inner классов
        Library.Scroll scroll = library.new Scroll("Ancient Runes");

        // Показываем название свитка
        scroll.revealTitle();
    }
}

class Library {
    public void addScroll(String scrollTitle) {

    }

    class Scroll {
        private String scrollTitle;

        Scroll(String title) {
            this.scrollTitle = title;
        }

        public void revealTitle() {
            System.out.println(this.scrollTitle);
        }
    }
}

/*
// Класс Library — магическая библиотека
class Library {
    // Публичный метод-заглушка: библиотека может принимать свитки, но логика пока не нужна
    public void addScroll(String scrollTitle) {
        // Пока ничего не делаем по условию задачи
    }

    // Нестатический внутренний класс Scroll — связан с конкретной библиотекой
    class Scroll {
        // Приватное поле для хранения названия свитка
        private String scrollTitle;

        // Конструктор, принимающий название свитка
        Scroll(String scrollTitle) {
            this.scrollTitle = scrollTitle;
        }

        // Метод выводит на экран название свитка
        public void revealTitle() {
            System.out.println(scrollTitle);
        }
    }
}
 */