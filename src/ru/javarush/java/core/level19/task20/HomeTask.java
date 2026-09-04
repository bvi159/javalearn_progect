package ru.javarush.java.core.level19.task20;

public class HomeTask extends Task{
    String location;
    public HomeTask(String title, String s) {
        super(title);
        this.location = s;
    }

    @Override
    public String getTitle() {
        return super.getTitle();
    }

    @Override
    public void complete() {
        System.out.println(location+": Задача " + getTitle() + " завершена!");
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
/*

// Специализированный тип задачи: домашняя задача с указанием места выполнения
public class HomeTask extends Task {
    private final String location;

    public HomeTask(String title, String location) {
        super(title);
        this.location = location;
    }

    public String getLocation() {
        return location;
    }

    @Override
    public void complete() {
        // Демонстрация выполнения: печатаем сообщение
        System.out.println("Выполнена домашняя задача: \"" + title + "\" (место: " + location + ")");
    }

    @Override
    public String toString() {
        // Детализированное описание — чтобы сервис мог печатать информацию, не зная конкретный тип
        return "Домашняя задача — \"" + title + "\", место: " + location;
    }
}
 */