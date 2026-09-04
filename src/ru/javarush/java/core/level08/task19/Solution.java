package ru.javarush.java.core.level08.task19;
/*
Настройка размера производственной коробки
Представьте, что вы работаете на фабрике по производству коробок, и каждая коробка имеет строго определенный размер. Вам нужен точный механизм для установки этого размера, но иногда при программировании возникает путаница с именами переменных.

Создайте класс FactoryBox с публичным полем boxSize типа int. Затем в этом же классе реализуйте публичный метод setDimensions(int boxSize).

Внутри метода setDimensions возникает небольшая путаница, ведь имя параметра boxSize совпадает с именем поля класса. Чтобы однозначно указать, что вы хотите изменить именно поле текущего объекта, а не просто локальный параметр, используйте специальное волшебное слово this.

В главном сборочном цехе, в методе main, создайте новую коробку: productBox = new FactoryBox(). Вызовите для неё setDimensions, передав значение 10. После этого немедленно проверьте и выведите на экран текущий boxSize вашей productBox, чтобы убедиться, что размер был установлен корректно.

Требования:
•	В классе FactoryBox должно быть объявлено публичное поле boxSize типа int.
•	В классе FactoryBox должен быть реализован публичный метод setDimensions, принимающий параметр int boxSize.
•	Внутри метода setDimensions для присваивания значения параметра полю класса должно использоваться ключевое слово this (this.boxSize = boxSize;).
•	В методе main должен быть создан объект класса FactoryBox и присвоен переменной productBox.
•	В методе main для объекта productBox должен быть вызван метод setDimensions с аргументом 10.
•	В методе main после вызова setDimensions должно быть выведено на экран значение поля boxSize объекта productBox.

public class Solution {
    public static void main(String[] args) {
        // Создаем объект класса FactoryBox


        // Устанавливаем размер коробки с помощью метода setDimensions


        // Выводим на экран текущий размер коробки

    }
}

class FactoryBox {
    // Публичное поле для хранения размера коробки
    public int boxSize;

    // Публичный метод для установки размера коробки
    public void setDimensions(int boxSize) {
        // Используем ключевое слово this, чтобы указать, что изменяем поле класса

    }
}

 */

public class Solution {
    public static void main(String[] args) {
        // Создаем объект класса FactoryBox
        FactoryBox productBox = new FactoryBox();

        // Устанавливаем размер коробки с помощью метода setDimensions
        productBox.setDimensions(10);

        // Выводим на экран текущий размер коробки
        System.out.println(productBox.boxSize);

    }
}

class FactoryBox {
    // Публичное поле для хранения размера коробки
    public int boxSize;

    // Публичный метод для установки размера коробки
    public void setDimensions(int boxSize) {
        // Используем ключевое слово this, чтобы указать, что изменяем поле класса
        this.boxSize = boxSize;

    }
}