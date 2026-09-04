package com.javarush.task.task36.task3608.model;

import com.javarush.task.task36.task3608.bean.User;

import java.util.ArrayList;
import java.util.List;

public class FakeModel implements Model {
    private ModelData modelData = new ModelData();


    @Override
    public void loadUsers() {
        List<User> myUsers = new ArrayList<>();
        User Victor = new User("Витя", 1, 1);
        User Maria = new User("Мария", 2, 1);
        myUsers.add(Victor);
        myUsers.add(Maria);

        modelData.setUsers(myUsers);
    }
    @Override
    public ModelData getModelData() {
        return modelData;
    }

    @Override
    public void loadDeletedUsers() {
//        System.out.println("UnsupportedOperationException");
        throw new UnsupportedOperationException();
    }

    //MVC - 7
    @Override
    public void loadUserById(long userId) {
        throw new UnsupportedOperationException();
    }

    //MVC -8
    @Override
    public void deleteUserById(long id) {
        throw new UnsupportedOperationException();
    }

    //MVC -9
    @Override
    public void changeUserData(String name, long id, int level) {
        throw new UnsupportedOperationException();
    }

}
