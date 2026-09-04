package ru.javarush.java.core.level10.task13;

/*
Моделирование светофора 🚦
Представьте, что вы моделируете работу светофора на оживленном перекрестке. У светофора есть ограниченное количество состояний, и каждое из них имеет своё чёткое значение.

Ваша задача — объявить перечисление enum под названием TrafficSignalState с тремя возможными значениями: RED (красный), YELLOW (жёлтый) и GREEN (зелёный).

Затем в методе main создайте переменную типа TrafficSignalState и присвойте ей начальное значение RED, имитируя включение красного света. После этого выведите значение этой переменной на экран.

Требования:
•	В программе должно быть объявлено перечисление (enum) с именем TrafficSignalState.
•	Перечисление TrafficSignalState должно содержать ровно три значения: RED, YELLOW и GREEN.
•	В методе main необходимо создать переменную типа TrafficSignalState.
•	Созданной переменной типа TrafficSignalState в методе main должно быть присвоено значение RED.
•	Значение переменной типа TrafficSignalState должно быть выведено на экран.

// Перечисление состояний светофора.
// Содержит ровно три значения: RED, YELLOW и GREEN.



public class Solution {
    public static void main(String[] args) {
        // Создаём переменную типа TrafficSignalState и задаём начальное значение RED


        // Выводим текущее состояние светофора на экран

    }
}
*/
// Перечисление состояний светофора.
public enum TrafficSignalState {
    RED ("красный"),
    YELLOW ("жёлтый"),
    GREEN ("зелёный");

    private final String color;

    TrafficSignalState(String whatInBraces) {
        this.color = whatInBraces;
    }

    public String getColor() {
        return color;
    }
}
