package com.javarush.task.task32.task3209.listeners;

import com.javarush.task.task32.task3209.View;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

// 3.2.1. Унаследован от WindowAdapter
public class FrameListener extends WindowAdapter {
    // 3.2.2. Поле View view
    private View view;

    // 3.2.3. Конструктор принимающий View
    public FrameListener(View view) {
        this.view = view;
    }

    // 3.2.4. Переопределенный метод windowClosing
    @Override
    public void windowClosing(WindowEvent windowEvent) {
        // Вызываем exit() у представления
        view.exit();
    }
}
