package com.javarush.task.task32.task3209.listeners;

import com.javarush.task.task32.task3209.View;

import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

public class UndoMenuListener implements MenuListener {
    // 10.1. Поля класса
    private View view;
    private JMenuItem undoMenuItem;
    private JMenuItem redoMenuItem;

    // 10.2. Конструктор
    public UndoMenuListener(View view, JMenuItem undoMenuItem, JMenuItem redoMenuItem) {
        this.view = view;
        this.undoMenuItem = undoMenuItem;
        this.redoMenuItem = redoMenuItem;
    }

    // 10.3. Метод, вызываемый перед показом меню
    @Override
    public void menuSelected(MenuEvent menuEvent) {
        // 10.3.1. Запрашиваем у представления, можем ли отменить действие
        // 10.3.2. Делаем пункт меню "Отменить" доступным/недоступным
        undoMenuItem.setEnabled(view.canUndo());

        // 10.3.3. Аналогично для пункта меню "Вернуть"
        redoMenuItem.setEnabled(view.canRedo());
    }

    @Override
    public void menuDeselected(MenuEvent menuEvent) {
        // Не требуется для текущей задачи
    }

    @Override
    public void menuCanceled(MenuEvent menuEvent) {
        // Не требуется для текущей задачи
    }
}
