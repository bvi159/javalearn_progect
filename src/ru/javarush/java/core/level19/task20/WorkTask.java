package ru.javarush.java.core.level19.task20;

public class WorkTask extends Task{
    String deadline;
    public WorkTask(String title, String s) {
        super(title);
        this.deadline = s;
    }

    @Override
    public String getTitle() {
        return super.getTitle();
    }

    @Override
    public void complete() {
        System.out.println(deadline +": Задача " + getTitle() + " завершена!");
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
/*
// Специализированный тип задачи: рабочая задача со сроком выполнения (deadline)
public class WorkTask extends Task {
    private final String deadline;

    public WorkTask(String title, String deadline) {
        super(title);
        this.deadline = deadline;
    }

    public String getDeadline() {
        return deadline;
    }

    @Override
    public void complete() {
        // Демонстрация выполнения: печатаем сообщение
        System.out.println("Выполнена рабочая задача: \"" + title + "\" (срок: " + deadline + ")");
    }

    @Override
    public String toString() {
        // Детализированное описание — чтобы сервис мог печатать информацию, не зная конкретный тип
        return "Рабочая задача — \"" + title + "\", срок: " + deadline;
    }
}
 */