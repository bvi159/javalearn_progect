package com.javarush.task.task36.task3608.model;

import com.javarush.task.task36.task3608.bean.User;
import com.javarush.task.task36.task3608.model.service.UserService;
import com.javarush.task.task36.task3608.model.service.UserServiceImpl;

import java.util.List;

public class MainModel implements Model {

    //use helpful services
    private UserService userService = new UserServiceImpl();

    //use special object to keep data for view rendering
    private ModelData modelData = new ModelData();

    @Override
    public ModelData getModelData() {
        return modelData;
    }

    @Override
    public void loadUsers() {
        List<User> users = getAllUsers();
        //refresh model data
        modelData.setUsers(users);
        modelData.setDisplayDeletedUserList(false);
    }

    @Override
    public void loadDeletedUsers() {
        List<User> users = userService.getAllDeletedUsers();
        //refresh model data
        modelData.setUsers(users);
        modelData.setDisplayDeletedUserList(true);
    }

    @Override
    public void loadUserById(long userId) {
        User user = userService.getUsersById(userId);
        modelData.setActiveUser(user);
    }

    @Override
    public void deleteUserById(long id) {
        userService.deleteUser(id);
        List<User> users = getAllUsers();
        //refresh model data
        modelData.setUsers(users);
    }

    @Override
    public void changeUserData(String name, long id, int level) {
        userService.createOrUpdateUser(name, id, level);
        // После изменения обновляем список пользователей
        List<User> users = getAllUsers();
        modelData.setUsers(users);
    }

    private List<User> getAllUsers() {
        //model should contain all business logic in the methods
        List<User> allUsers = userService.getUsersBetweenLevels(1, 100);
        allUsers = userService.filterOnlyActiveUsers(allUsers);
        return allUsers;
    }


}


/*
import com.javarush.task.task36.task3608.bean.User;
import com.javarush.task.task36.task3608.model.service.UserService;
import com.javarush.task.task36.task3608.model.service.UserServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MainModel implements Model {
    //use helpful services
    private UserService userService = new UserServiceImpl();

    //use special object to keep data for view rendering
    private ModelData modelData = new ModelData();

    @Override
    public ModelData getModelData() {
        return modelData;
    }

    // Приватный метод для получения активных пользователей MVC - 8
//    private List<User> getAllUsers() {
//        List<User> allUsers = userService.getUsersBetweenLevels(1, 100);
//        return filterOnlyActiveUsers(allUsers);
//    }
    private List<User> getAllUsers() {
        //model should contain all business logic in the methods
        List<User> allUsers = userService.getUsersBetweenLevels(1, 100);
        allUsers = userService.filterOnlyActiveUsers(allUsers);
        return allUsers;
    }

    // Существующий метод фильтрации MVC - 8
//    private List<User> filterOnlyActiveUsers(List<User> allUsers) {
//        // Логика фильтрации активных пользователей
//        return allUsers.stream()
//                .filter(user -> !user.isDeleted()) // предполагаем, что есть метод isDeleted()
//                .collect(Collectors.toList());
//    }

    @Override
    public void deleteUserById(long id) {
        userService.deleteUser(id);
        // После удаления обновляем список пользователей
        List<User> users = getAllUsers();
        modelData.setUsers(users);
    }


//    @Override
//    public void loadUsers() {
//        List<User> users = getAllUsers();
//        //refresh model data
//        modelData.setUsers(users);
//        modelData.setDisplayDeletedUserList(false);
//    }

    @Override
    public void loadUsers() {
        List<User> myUsers = getAllUsers();
        modelData.setDisplayDeletedUserList(false);
        myUsers = userService.getUsersBetweenLevels(1, 100);
        modelData.setUsers(myUsers);
    }

    //MVC -7
    @Override
    public void loadUserById(long userId) {
        User user = userService.getUsersById(userId);
        modelData.setActiveUser(user);
        // Можно также загрузить дополнительные данные пользователя
    }

    @Override
    public void loadDeletedUsers() {
        modelData.setDisplayDeletedUserList(true);
        List<User> users = userService.getAllDeletedUsers();
        modelData.setUsers(users);
        // здесь может быть дополнительная логика, например, уведомление view
    }

}


//    public void setModelData(ModelData modelData) {
//        this.modelData = modelData;
//    }
//        User Victor = new User("Витя", 1, 1);
//        User Maria = new User("Мария", 2, 1);
//        myUsers.add(Victor);
//        myUsers.add(Maria);

//        @Override
//        public User deleteUser(long id) {
//            return null;
//        }
//
//        @Override
//        public User createOrUpdateUser(String name, long id, int level) {
//            return null;
//        }
//
//        @Override
//        public List<User> getUsersByName(String name) {
//            return List.of();
//        }
//
//        @Override
//        public List<User> getAllDeletedUsers() {
//            return List.of();
//        }
//
//        @Override
//        public List<User> getUsersBetweenLevels(int fromLevel, int toLevel) {
//            return List.of();
//        }
//
//        @Override
//        public List<User> filterOnlyActiveUsers(List<User> allUsers) {
//            return List.of();
//        }
//
//        @Override
//        public User getUsersById(long userId) {
//            return null;
//        }

 */