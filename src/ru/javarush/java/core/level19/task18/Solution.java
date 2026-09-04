package ru.javarush.java.core.level19.task18;

/*
Интеллектуальный сервис задач 🧠

Продолжая работу над вашим менеджером задач, пришло время создать "мозг" системы — класс TaskService. Этот сервис будет отвечать за высокоуровневые операции с задачами, не вдаваясь в детали их хранения. Поэтому он должен содержать поле типа TaskRepository (предполагается, что вы уже определили интерфейс или абстрактный класс TaskRepository в контексте этой задачи, хотя его создание здесь не описывается явно, но подразумевается для корректной работы).
В классе TaskService реализуйте два ключевых метода: addTask(Task task), который будет не что иное, как делегирование сохранения новой задачи в репозиторий, и completeTask(String title). Последний метод должен самостоятельно найти задачу по её названию через репозиторий, и если такая задача будет найдена, то вызвать у неё метод complete(), сигнализируя о её выполнении.
Чтобы убедиться в функциональности вашего TaskService, продемонстрируйте его работу: создайте новую задачу, добавьте её через сервис, а затем попробуйте выполнить её, используя метод completeTask().

Требования:
•	Класс TaskService должен содержать поле типа TaskRepository для взаимодействия с хранилищем задач.
•	В классе TaskService должен быть реализован метод addTask(Task task), который делегирует сохранение задачи репозиторию.
•	В классе TaskService должен быть реализован метод completeTask(String title), который ищет задачу по названию через репозиторий.
•	Если задача с указанным названием найдена, метод completeTask(String title) должен вызвать у неё метод complete().
•	В решении должна быть показана работа TaskService: создание новой задачи, добавление её через сервис и выполнение задачи методом completeTask().

public class Solution {
    public static void main(String[] args) {
        // Создаём хранилище и сервис, который опирается только на абстракцию TaskRepository
        TaskRepository repository = new InMemoryTaskRepository();
        TaskService service = new TaskService(repository);

        // Демонстрация: создаём новую задачу
        Task task = new Task("Написать демо для TaskService");

        // Добавляем задачу через сервис (делегирование в репозиторий)
        service.addTask(task);

        // Смотрим состояние до выполнения
        System.out.println("До выполнения:  " + task);

        // Выполняем задачу по названию через сервис
        service.completeTask("Написать демо для TaskService");

        // Смотрим состояние после выполнения
        System.out.println("После выполнения: " + task);
    }
}

 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        // Создаём хранилище и сервис, который опирается только на абстракцию TaskRepository
        TaskRepository repository = new InMemoryTaskRepository();
        TaskService service = new TaskService(repository);

        // Демонстрация: создаём новую задачу
        Task task = new Task("Написать демо для TaskService");

        // Добавляем задачу через сервис (делегирование в репозиторий)
        service.addTask(task);

        // Смотрим состояние до выполнения
        System.out.println("До выполнения:  " + task);

        // Выполняем задачу по названию через сервис
        service.completeTask("Написать демо для TaskService");

        // Смотрим состояние после выполнения
        System.out.println("После выполнения: " + task);
    }
}

// Модель "Задача"
class Task {
    private final String title;
    private boolean completed;

    public Task(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public boolean isCompleted() {
        return completed;
    }

    // Изменяет состояние задачи на "выполнена"
    public void complete() {
        this.completed = true;
    }

    @Override
    public String toString() {
        return "Task{title='" + title + "', completed=" + completed + "}";
    }
}

// Абстракция хранилища задач
interface TaskRepository {
    void save(Task task);              // Сохранение/обновление задачи
    Task findByTitle(String title);    // Поиск задачи по названию (или null, если не найдена)
}

// Простая in-memory реализация хранилища для демонстрации
class InMemoryTaskRepository implements TaskRepository {
    // Храним задачи в мапе по названию; в реальном приложении это может быть БД, файл и т.д.
    private final Map<String, Task> storage = new HashMap<>();

    @Override
    public void save(Task task) {
        storage.put(task.getTitle(), task);
    }

    @Override
    public Task findByTitle(String title) {
        return storage.get(title);
    }
}

// "Мозг" системы: высокоуровневые операции над задачами
class TaskService {
    // Сервис зависит от абстракции, а не от конкретной реализации хранилища
    private final TaskRepository repository;

    public TaskService(TaskRepository repository) {
        this.repository = repository;
    }

    // Делегирование сохранения задачи репозиторию
    public void addTask(Task task) {
        repository.save(task);
    }

    // Находит задачу по названию и, если нашлась, помечает её выполненной
    public void completeTask(String title) {
        Task task = repository.findByTitle(title); // сервис не знает, где и как хранятся задачи
        if (task != null) {
            task.complete(); // меняем состояние найденной задачи
        }
    }
}

/*

 */