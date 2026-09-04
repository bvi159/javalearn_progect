package com.javarush.task.task36.task3608.model;

public interface Model {
    ModelData getModelData();
    void loadUsers();
    void loadDeletedUsers(); // добавляем новый метод
    //MVC -7
    void loadUserById(long userId);
    //MVC -8
    void deleteUserById(long id);
    //MVC -8
    void changeUserData(String name, long id, int level); // новый метод
}
