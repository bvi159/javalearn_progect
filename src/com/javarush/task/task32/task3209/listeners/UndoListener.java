package com.javarush.task.task32.task3209.listeners;

import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.UndoManager;

public class UndoListener implements UndoableEditListener {
    // 11.3.1. Поле UndoManager
    private UndoManager undoManager;

    // 11.3.2. Конструктор
    public UndoListener(UndoManager undoManager) {
        this.undoManager = undoManager;
    }

    // 11.3.3. Метод, вызываемый при возникновении отменяемого события
    @Override
    public void undoableEditHappened(UndoableEditEvent e) {
        // Получаем правку из события и добавляем её в undoManager
        undoManager.addEdit(e.getEdit());
    }
}
