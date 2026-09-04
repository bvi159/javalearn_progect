package com.javarush.task.task36.task3608.view;

import com.javarush.task.task36.task3608.controller.Controller;
import com.javarush.task.task36.task3608.model.ModelData;

public class EditUserView implements View {
    private Controller controller;

    //MVC - 9
    public void fireEventUserChanged(String name, long id, int level) {
        controller.onUserChange(name, id, level);
    }

    //MVC - 8
    public void fireEventUserDeleted(long id) {
        controller.onUserDelete(id);
    }


    @Override
    public void refresh(ModelData modelData) {
        System.out.println("User to be edited:");
        System.out.println("\t" + modelData.getActiveUser());

//        for (User myUs : modelData.getUsers()) {
//            System.out.println("\t" + myUs);
//        }
        System.out.println("===================================================");
    }

    public void fireEventShowDeletedUsers() {
        controller.onShowAllDeletedUsers();
    }

    public void fireEventShowAllUsers() {
        controller.onShowAllUsers();
    }

    public void setController(Controller myController) {
        this.controller = myController;
    }

}
