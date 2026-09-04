package com.javarush.task.task23.task2312;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class Layer extends JPanel {
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(java.awt.Color.GREEN); //Задаем цвет элементов зеленый
        g.fillRect(Room.game.getWidth() * 10, 0, 10, (Room.game.getWidth() * 10) + 10);  //Рисуем прямоугольник показывающий край поля справа
        g.fillRect(0, Room.game.getHeight() * 10, (Room.game.getHeight() * 10) + 10, 10); //Рисуем прямоугольник показывающий край поля снизу

        g.fillRect(Room.game.getMouse().getX() * 10, Room.game.getMouse().getY() * 10, 10, 10); //Рисуем прямоугольник показывающий мышь

        List<SnakeSection> getsection = Room.game.getSnake().getSections(); //Получаем секции змейки
        for (int i = 0; i < getsection.size(); i++) {
            g.fillRect(getsection.get(i).getX() * 10, getsection.get(i).getY() * 10, 10, 10); //Рисуем по очереди секции змейки
        }
    }
    /* Второй вариант
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Проверка на существование объекта Room.game
        if (Room.game == null) {
            return;
        }

        g.setColor(java.awt.Color.GREEN); // Задаем цвет элементов зеленым

        // Рисуем прямоугольники, показывающие край поля справа и снизу
        int width = Room.game.getWidth() * 10;
        int height = Room.game.getHeight() * 10;

        g.fillRect(width, 0, 10, height + 10); // Край поля справа
        g.fillRect(0, height, width + 10, 10); // Край поля снизу

        // Рисуем прямоугольник показывающий мышь
        g.setColor(java.awt.Color.RED); // Устанавливаем цвет для мыши
        g.fillRect(Room.game.getMouse().getX() * 10, Room.game.getMouse().getY() * 10, 10, 10); // Рисуем мышь

        // Получаем секции змейки и рисуем их
        g.setColor(java.awt.Color.BLUE); // Устанавливаем цвет для змеи
        List<SnakeSection> sections = Room.game.getSnake().getSections(); // Получаем секции змеи
        for (int i = 0; i < sections.size(); i++) {
            g.fillRect(sections.get(i).getX() * 10, sections.get(i).getY() * 10, 10, 10); // Рисуем секции змеи
        }
    }

     */
}
/*
// Получаем секции змейки и рисуем их
        g.setColor(java.awt.Color.BLUE); // Устанавливаем цвет для змеи
        List<SnakeSection> sections = Room.game.getSnake().getSections(); // Получаем секции змеи
        for (int i = 0; i < sections.size(); i++) {
            g.fillRect(sections.get(i).getX() * 10, sections.get(i).getY() * 10, 10, 10); // Рисуем секции змеи
        }
 */