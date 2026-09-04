package com.javarush.task.task25.task2503;

/* 
Свой enum
Реализуй интерфейс Columnable у Column, описание методов смотрите в джавадоках.
Реализуй логику метода Column.getVisibleColumns.
Метод Column.configureColumns уже реализован, его не меняй.
Создавать дополнительные поля нельзя.
Метод main не участвует в тестировании.

Требования:
•	Интерфейс Columnable менять нельзя.
•	Класс Column должен реализовывать интерфейс Columnable.
•	Создавать дополнительные поля в классе Column нельзя.
•	Метод Column.configureColumns реализован. Менять его не нужно.
•	Метод Column.getVisibleColumns должен возвращать список отображаемых колонок в скофигурированом порядке.
•	Метод Column.getColumnName должен возвращать полное имя колонки.
•	Метод Column.isShown должен возвращать true, если колонка видимая, иначе false.
•	Метод Column.hide должен скрывать колонку и сдвигать индексы остальных отображаемых колонок.


public enum Column implements Columnable {
...........................без изменений до:
   public static List<Column> getVisibleColumns() {
        List<Column> result = new LinkedList<>();
        int nextIndex = 0;
        boolean hasNextElement = true;
        while (hasNextElement) {
            hasNextElement = false;
            for (int i = 0; i < realOrder.length; i++) {
                if (realOrder[i] == nextIndex) {
                    result.add(values()[i]);
                    break;
                }
            }
            for (int i = 0; i < realOrder.length; i++) {
                if (realOrder[i] == nextIndex + 1) {
                    hasNextElement = true;
                    nextIndex++;
                    break;
                }
            }
        }
        return result;
    }


    @Override
    public String getColumnName() {
        return columnName;
    }

    @Override
    public boolean isShown() {
        return realOrder != null && realOrder[ordinal()] != -1;
    }

    @Override
    public void hide() {
        int oldOrder = realOrder[ordinal()];
        if (oldOrder == -1) return; //already hidden
        realOrder[ordinal()] = -1;
        //reorder
        for (int i = 0; i < realOrder.length; i++) {
            int currentIndex = realOrder[i];
            if (currentIndex != -1 && currentIndex > oldOrder) {
                realOrder[i] -= 1;
            }
        }
    }


*/

public class Solution {
    /**
     * Output:
     * <p/>
     * Available Amount
     * Account Number
     * Bank Name
     * --------------------
     * Available Amount
     * Bank Name
     */
    public static void main(String[] args) {

        Column.configureColumns(Column.Amount, Column.AccountNumber, Column.BankName);

        for (Columnable columnable : Column.getVisibleColumns()) {
            System.out.println(columnable.getColumnName());
        }

        System.out.println("--------------------");
        Column.AccountNumber.hide();

        for (Columnable columnable : Column.getVisibleColumns()) {
            System.out.println(columnable.getColumnName());
        }
    }
}
