package ru.javarush.java.core.level14.task07;

/*
Цифровой счётчик событий

Представьте, что вы создаёте простой цифровой счётчик для игры или для отслеживания чего-либо, например, количества нажатий на кнопку или собранных монет. Ваша задача — создать такой счётчик, который будет хранить своё текущее значение (int currentValue), уметь увеличивать его по вашей команде и сообщать, какое значение он сейчас показывает. Объявите класс Counter с полем currentValue.

Добавьте метод increment(), который будет увеличивать currentValue на единицу, и метод printValue(), который будет выводить текущее значение на экран. В вашем основном сценарии (main методе) "запустите" этот счётчик, "нажмите на кнопку" (вызовите increment()) 3 раза, а затем попросите его "показать" своё текущее значение. На экране должно появиться число 3.

Требования:
•	Необходимо объявить публичный класс с именем Counter.
•	Класс Counter должен содержать поле типа int с именем currentValue.
•	В классе Counter должен быть реализован метод increment(), который увеличивает значение currentValue на 1.
•	В классе Counter должен быть реализован метод printValue(), который выводит текущее значение currentValue на экран.
•	В методе main необходимо создать объект класса Counter.
•	В методе main метод increment() должен быть вызван три раза для созданного объекта Counter.
•	В методе main должен быть вызван метод printValue() для объекта Counter после трёх вызовов increment(), и на экран должно быть выведено число 3.
public class Solution {
    public static void main(String[] args) {
        // Создаем и "запускаем" счётчик


        // "Нажимаем кнопку" три раза


        // Просим счётчик показать текущее значение (ожидается число 3)

    }
}

 */

public class Solution {
    public static void main(String[] args) {
        // Создаем и "запускаем" счётчик
        Counter myButton = new Counter();


        // "Нажимаем кнопку" три раза
        myButton.increment();
        myButton.increment();
        myButton.increment();

        // Просим счётчик показать текущее значение (ожидается число 3)
        myButton.printValue();

    }

   public static class Counter {
        int currentValue = 0;

        void increment() {
            this.currentValue++;
        }

       void printValue() {
           System.out.println(this.currentValue);
       }

    }

}

/*
ихнее решение

// Публичный класс цифрового счётчика
public class Counter {
    // Поле для хранения текущего значения счётчика
    int currentValue;

    // Конструктор по умолчанию: стартуем с нуля (для наглядности, хотя int по умолчанию и так 0)
    public Counter() {
        currentValue = 0;
    }

    // Увеличиваем значение счётчика на 1
    public void increment() {
        currentValue++;
    }

    // Выводим текущее значение счётчика на экран
    public void printValue() {
        System.out.println(currentValue);
    }
}

 */