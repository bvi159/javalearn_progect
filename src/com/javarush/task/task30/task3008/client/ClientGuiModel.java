package com.javarush.task.task30.task3008.client;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class ClientGuiModel {
    // 2) Множество имен всех участников чата
    private final Set<String> allUserNames = new HashSet<>();

    // 3) Поле для хранения нового сообщения
    private String newMessage;

    // 4) Геттер для allUserNames с запретом модификации
    public Set<String> getAllUserNames() {
        return Collections.unmodifiableSet(allUserNames);
    }

    // 5) Геттер и сеттер для поля newMessage
    public String getNewMessage() {
        return newMessage;
    }

    public void setNewMessage(String newMessage) {
        this.newMessage = newMessage;
    }

    // 6) Метод для добавления имени участника
    public void addUser(String newUserName) {
        allUserNames.add(newUserName);
    }

    // 7) Метод для удаления имени участника
    public void deleteUser(String userName) {
        allUserNames.remove(userName);
    }
}
