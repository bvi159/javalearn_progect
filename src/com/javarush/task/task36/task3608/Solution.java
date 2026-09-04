package com.javarush.task.task36.task3608;

import com.javarush.task.task36.task3608.controller.Controller;
import com.javarush.task.task36.task3608.model.MainModel;
import com.javarush.task.task36.task3608.model.Model;
import com.javarush.task.task36.task3608.view.EditUserView;
import com.javarush.task.task36.task3608.view.UsersView;
//import com.sun.javafx.scene.traversal.Direction;

public class Solution {

    public static void main(String[] args) {
//        Model model = new FakeModel();
        Model model = new MainModel();
        Controller controller = new Controller();
        UsersView usersView = new UsersView();
        EditUserView editUserView = new EditUserView(); //MVC - 7

        controller.setModel(model);
        controller.setUsersView(usersView);
        controller.setEditUserView(editUserView); //MVC - 7
        usersView.setController(controller);
        editUserView.setController(controller); //MVC - 8

        // Вызовы в требуемой последовательности
        usersView.fireEventShowAllUsers();           // 1. Показать всех пользователей
        usersView.fireEventOpenUserEditForm(126L);   // 2. Открыть форму редактирования пользователя 126
        editUserView.fireEventUserDeleted(124L);     // 3. Удалить пользователя 124
        editUserView.fireEventUserChanged("New Name", 125L, 10); // 4. Изменить пользователя 125
        usersView.fireEventShowDeletedUsers();       // 5. Показать удаленных пользователей

    /* Это проверка примеров из
        Enum, все особенности
        Java Multithreading
        5 уровень, 1 лекция
     */
//        for (Direction direction : Direction.values())
//        {
//            System.out.println(direction);
//        }



    }
}

//// Сначала открываем форму редактирования для пользователя с id=126
//        usersView.fireEventOpenUserEditForm(126L); //MVC - 7
//
//        usersView.fireEventShowAllUsers();
//
//// Вызов нового метода для отображения удаленных пользователей
//        usersView.fireEventShowDeletedUsers();
