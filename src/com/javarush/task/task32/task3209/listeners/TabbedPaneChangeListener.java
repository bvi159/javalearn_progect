package com.javarush.task.task32.task3209.listeners;

import com.javarush.task.task32.task3209.View;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class TabbedPaneChangeListener implements ChangeListener {
    // 5.1.1. Поле для хранения представления
    private View view;

    // 5.1.1. Конструктор, принимающий представление
    public TabbedPaneChangeListener(View view) {
        this.view = view;
    }

    // 5.1.2. Переопределение метода из интерфейса ChangeListener
    @Override
    public void stateChanged(ChangeEvent e) {
        // Вызываем метод selectedTabChanged() у представления
        view.selectedTabChanged();
    }
}
