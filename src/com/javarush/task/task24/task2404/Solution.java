package com.javarush.task.task24.task2404;

/* 
Рефакторинг Rectangle
В классе Rectangle:
1. Измени методы getHeight и getWidth, чтобы они возвращали объекты типов HasHeight и HasWidth соответственно.
2. Для этого внутри методов getHeight и getWidth создай локальные классы - реализации интерфейсов.
3. Переименуй getHeight в castToHasHeight, getWidth в castToHasWidth (на имени метода нажми Shift+F6).
4. Убери наследование интерфейсов в классе Rectangle.

P.S. Ожидается, что после внесения требуемых изменений, закомментированный код в методе станет рабочим и должен быть раскомментирован.

Требования:
•	В класса Rectangle должен быть реализован метод castToHasHeight.
•	В класса Rectangle должен быть реализован метод castToHasWidth.

 public HasHeight castToHasHeight() {
            class HasHeightImpl implements HasHeight {
                public double getHeight() {
                    return Math.abs(point1.getY() - point2.getY());
                }
            }
            return new HasHeightImpl();
        }

        public HasWidth castToHasWidth() {
            class HasWidthImpl implements HasWidth {
                public double getWidth() {
                    return Math.abs(point1.getX() - point2.getX());
                }
            }
            return new HasWidthImpl();
        }
Тоже что и у меня с помощью ИИ

*/

public class Solution {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle(1, 2, 3, 4);
//        System.out.println(getHeight(rectangle));
//        System.out.println(getWidth(rectangle));
        /////////////////////expected//////////////////
        System.out.println(getHeight(rectangle.castToHasHeight()));
        System.out.println(getWidth(rectangle.castToHasWidth()));
    }

    public static double getHeight(HasHeight rectangle) {
        return rectangle.getHeight();
    }

    public static double getWidth(HasWidth rectangle) {
        return rectangle.getWidth();
    }


    public static class Rectangle { // implements HasHeight, HasWidth
        private Point point1;
        private Point point2;

        public Rectangle(double x1, double y1, double x2, double y2) {
            point1 = new Point(x1, y1);
            point2 = new Point(x2, y2);
        }


        public HasHeight castToHasHeight() {
            // Локальный класс, реализующий интерфейс HasHeight
            class HeightImplementation implements HasHeight {
                @Override
                public double getHeight() {
                    return Math.abs(point1.getY() - point2.getY());
                }
            }
            return new HeightImplementation();
        }


        public HasWidth castToHasWidth() {
            // Локальный класс, реализующий интерфейс HasWidth
            class WidthImplementation implements HasWidth {
                @Override
                public double getWidth() {
                    return Math.abs(point1.getX() - point2.getX());
                }
            }
            return new WidthImplementation();
        }
    }
}


/*
public class Solution {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle(1, 2, 3, 4);
        System.out.println(getHeight(rectangle));
        System.out.println(getWidth(rectangle));
        /////////////////////expected//////////////////
        //System.out.println(getHeight(rectangle.castToHasHeight()));
        //System.out.println(getWidth(rectangle.castToHasWidth()));
    }

    public static double getHeight(HasHeight rectangle) {
        return rectangle.getHeight();
    }

    public static double getWidth(HasWidth rectangle) {
        return rectangle.getWidth();
    }


    public static class Rectangle implements HasHeight, HasWidth {
        private Point point1;
        private Point point2;

        public Rectangle(double x1, double y1, double x2, double y2) {
            point1 = new Point(x1, y1);
            point2 = new Point(x2, y2);
        }

        @Override
        public double getHeight() {

            return Math.abs(point1.getY() - point2.getY());
        }

        @Override
        public double getWidth() {
            return Math.abs(point1.getX() - point2.getX());
        }
    }
}
 */