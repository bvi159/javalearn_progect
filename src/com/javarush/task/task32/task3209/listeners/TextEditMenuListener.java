package com.javarush.task.task32.task3209.listeners;

import com.javarush.task.task32.task3209.View;

import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import java.awt.*;

public class TextEditMenuListener implements MenuListener {
    private View view;

    public TextEditMenuListener(View view) {
        this.view = view;
    }

    @Override
    public void menuSelected(MenuEvent menuEvent) {
        // Получаем меню, которое было выбрано
        JMenu jMenu = (JMenu) menuEvent.getSource();

        // Получаем все компоненты меню (пункты меню)
        Component[] components = jMenu.getMenuComponents();

        // Для каждого пункта меню устанавливаем доступность
        for (Component component : components) {
            component.setEnabled(view.isHtmlTabSelected());
        }
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
