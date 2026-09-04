package com.javarush.task.task25.task2503;

import java.util.*;

public enum Column implements Columnable {
    Customer("Customer"),
    BankName("Bank Name"),
    AccountNumber("Account Number"),
    Amount("Available Amount");

   private String columnName;

    private static int[] realOrder;

    private Column(String columnName) {
        this.columnName = columnName;
    }

    /**
     * Задает новый порядок отображения колонок, который хранится в массиве realOrder.
     * realOrder[индекс в энуме] = порядок отображения; -1, если колонка не отображается.
     *
     * @param newOrder новая последовательность колонок, в которой они будут отображаться в таблице
     * @throws IllegalArgumentException при дубликате колонки
     */
    public static void configureColumns(Column... newOrder) {
        realOrder = new int[values().length];
        for (Column column : values()) {
            realOrder[column.ordinal()] = -1;
            boolean isFound = false;

            for (int i = 0; i < newOrder.length; i++) {
                if (column == newOrder[i]) {
                    if (isFound) {
                        throw new IllegalArgumentException("Column '" + column.columnName + "' is already configured.");
                    }
                    realOrder[column.ordinal()] = i;
                    isFound = true;
                }
            }
        }
    }

    /**
     * Вычисляет и возвращает список отображаемых колонок в сконфигурированом порядке (см. метод configureColumns)
     * Используется поле realOrder.
     *
     * @return список колонок
     */
    public static List<Column> getVisibleColumns() {
        List<Column> result = new LinkedList<>();

        // Создаем список пар (индекс отображения, колонка)
        List<Column> visibleColumns = new ArrayList<>();
        for (Column column : values()) {
            if (realOrder[column.ordinal()] != -1) {
                visibleColumns.add(column);
            }
        }

        // Сортируем по порядку отображения
        visibleColumns.sort(Comparator.comparingInt(column -> realOrder[column.ordinal()]));

        result.addAll(visibleColumns);
        return result;

//        configureColumns();
//        for (Integer myCol : realOrder){
//            result.add(myCol);
//        }


    }


    /**
     * @return полное имя колонки
     */
    @Override
    public String getColumnName() {
            return this.columnName;
    }

    /**
     * @return true, если колонка видимая, иначе false
     */
    @Override
    public boolean isShown() {
        return realOrder != null && realOrder[this.ordinal()] != -1;
    }

    /**
     * Скрывает колонку и сдвигает индексы остальных отображаемых колонок
     */
    @Override
    public void hide() {
        if (realOrder == null) return;

        int currentOrder = realOrder[this.ordinal()];
        if (currentOrder == -1) return; // уже скрыта

        // Скрываем текущую колонку
        realOrder[this.ordinal()] = -1;

        // Сдвигаем индексы остальных видимых колонок
        for (Column column : values()) {
            if (realOrder[column.ordinal()] > currentOrder) {
                realOrder[column.ordinal()]--;
            }
        }
    }
}
////        List<int[]> myList = new ArrayList<>();
//        List<int[]> myList = new LinkedList<>();
//configureColumns();
//        myList = Arrays.asList(realOrder);


/* Исходник

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

в программе:

public enum Column {
    Customer("Customer"),
    BankName("Bank Name"),
    AccountNumber("Account Number"),
    Amount("Available Amount");

    private String columnName;

    private static int[] realOrder;

    private Column(String columnName) {
        this.columnName = columnName;
    }

    / **
     * Задает новый порядок отображения колонок, который хранится в массиве realOrder.
     * realOrder[индекс в энуме] = порядок отображения; -1, если колонка не отображается.
     *
     * @param newOrder новая последовательность колонок, в которой они будут отображаться в таблице
     * @throws IllegalArgumentException при дубликате колонки
     * /
public static void configureColumns(Column... newOrder) {
    realOrder = new int[values().length];
    for (Column column : values()) {
        realOrder[column.ordinal()] = -1;
        boolean isFound = false;

        for (int i = 0; i < newOrder.length; i++) {
            if (column == newOrder[i]) {
                if (isFound) {
                    throw new IllegalArgumentException("Column '" + column.columnName + "' is already configured.");
                }
                realOrder[column.ordinal()] = i;
                isFound = true;
            }
        }
    }
}

/ **
 * Вычисляет и возвращает список отображаемых колонок в сконфигурированом порядке (см. метод configureColumns)
 * Используется поле realOrder.
 *
 * @return список колонок
* /
public static List<Column> getVisibleColumns() {
    List<Column> result = new LinkedList<>();

    return result;
}
}


*/
