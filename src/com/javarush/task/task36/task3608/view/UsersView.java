package com.javarush.task.task36.task3608.view;

import com.javarush.task.task36.task3608.bean.User;
import com.javarush.task.task36.task3608.controller.Controller;
import com.javarush.task.task36.task3608.model.ModelData;

import java.util.List;

public class UsersView implements View {
    private Controller controller;


    @Override
    public void refresh(ModelData modelData) {
        boolean who;
        who = modelData.isDisplayDeletedUserList();
        if (who == false) {
            System.out.println("All users:");
            for (User myUs : modelData.getUsers()) {
                System.out.println("\t" + myUs);
            }
        }else{
            System.out.println("All deleted users:");
            modelData.setDisplayDeletedUserList(who);
            for (User myUs : modelData.getUsers()) {
                System.out.println("\t" + myUs);
            }
        }

//        for (User myUs : modelData.getUsers()) {
//            System.out.println("\t" + myUs);
//        }
        System.out.println("===================================================");
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    public void fireEventShowAllUsers() {
        controller.onShowAllUsers();
    }

    //MVC 7
    public void fireEventOpenUserEditForm(long id) {
        controller.onOpenUserEditForm(id);
    }

    public void fireEventShowDeletedUsers() {
        controller.onShowAllDeletedUsers();
    }





}
