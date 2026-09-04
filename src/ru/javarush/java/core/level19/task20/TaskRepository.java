package ru.javarush.java.core.level19.task20;

import java.util.List;

public interface TaskRepository {
    void add(Task task);

    List<Task> findAll();
}
