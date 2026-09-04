package com.javarush.task.task36.task3608.controller;


import com.javarush.task.task36.task3608.model.Model;
import com.javarush.task.task36.task3608.view.EditUserView;
import com.javarush.task.task36.task3608.view.UsersView;

public class Controller {
    private Model model;
    private UsersView usersView;
    private EditUserView editUserView;

    public void setEditUserView(EditUserView editUserView) {
        this.editUserView = editUserView;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model someModel) {
        this.model = someModel;
    }

    // Добавленный метод
    public void onShowAllUsers() {
        if (model != null) {
            model.loadUsers();
            usersView.refresh(model.getModelData());
        }
    }


    public void setUsersView(UsersView usersView) {
         this.usersView = usersView;
    }

    //MVC 9
    public void onUserChange(String name, long id, int level) {
        model.changeUserData(name, id, level);
        usersView.refresh(model.getModelData());
    }

    //MVC 8
        public void onUserDelete(long id) {
        model.deleteUserById(id);
        usersView.refresh(model.getModelData());
    }

    //MVC 7
    public void onOpenUserEditForm(long userId) {
        model.loadUserById(userId);
        // Переключаемся на вьюху редактирования пользователя
        editUserView.refresh(model.getModelData());
    }

    public void onShowAllDeletedUsers() {
        model.loadDeletedUsers();
        usersView.refresh(model.getModelData());
    }
}

/*
 public void loadUsers() {
        List<User> myUsers = new ArrayList<>();
        User Victor = new User("Витя", 1, 1);
        User Maria = new User("Мария", 2, 1);
        myUsers.add(Victor);
        myUsers.add(Maria);

        modelData.setUsers(myUsers);
        contModel.getModelData();
    }
//    @Override
//    public ModelData getModelData() {
//        return modelData;
//    }

//    void onShowAllUsers(){
//        contModel.loadUsers();
//
////        Model myModel = new Model() {
////            @Override
////            public ModelData getModelData() {
////                return null;
////            }
////
////            @Override
////            public void loadUsers() {
////
////            }
////        };
//    }
 */