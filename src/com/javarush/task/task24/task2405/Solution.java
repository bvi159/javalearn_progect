package com.javarush.task.task24.task2405;

/* 
Black box
1. Восстанови логику метода someAction для поля solutionAction.
2. Пример вывода смотри в комментарии к методу main.
3. Подсказка: метод someAction анонимного класса поля solutionAction должен вызвать метод сабкласса FirstClass, если param > 0, иначе вызвать метод сабкласса SecondClass.

Не изменяй метод main!

Требования:
•	Вывод на экран должен соответствовать условию задачи.
•	Для вывода должны быть использованы строковые константы объявленные в классе SecondClass.
•	В методе someAction анонимного класса Action созданного в классе Solution должен содержаться вызов метода someAction родительского класса (super.someAction()).
•	В методе someAction анонимного класса Action созданного в классе Solution должен быть создан объект типа FirstClass.
•	В методе someAction анонимного класса Action созданного в классе Solution должен быть создан объект типа SecondClass.



*/

public class Solution implements Action {
    public static int countActionObjects;

    private int param;

    private Action solutionAction = new Action() {
        //напишите тут ваш код
        private FirstClass firstClass;
        private SecondClass secondClass;

        public void someAction() {
            //напишите тут ваш код

                if (param > 0) {

                    // Создаем FirstClass если еще не создан
                    if (firstClass == null) {
                        firstClass = new FirstClass() {  // Используются анонимные классы для FirstClass и SecondClass
                            @Override
                            public void someAction() {
                                super.someAction();        // Вызывает оригинальный метод FirstClass
                                Solution.this.someAction(); // Рекурсивный вызов внешнего класса
                            }

                            @Override
                            public Action getDependantAction() {
                                System.out.println(param); // Выводит текущее значение param
                                param--;                   // Уменьшает param на 1
                                return param > 0 ? Solution.this : this; // Возвращает Solution или this
                            }
                        };
                    }

                    // Вызываем метод FirstClass
                    firstClass.getDependantAction().someAction();

                } else {
//                    param--;
                    // Создаем SecondClass если еще не создан
                    if (secondClass == null) {
                        secondClass = new SecondClass() {   //Используются анонимные классы для FirstClass и SecondClass
                            @Override
                            public void someAction() {
                                // Добавляем специфическое действие для анонимного класса
                                sb.append(SecondClass.SPECIFIC_ACTION_FOR_ANONYMOUS_SECOND_CLASS_PARAM)
                                        .append(param);
                                super.someAction();
                            }
                        };
                    }

                    // Вызываем метод SecondClass
                    secondClass.someAction();
                }
            }
//        }
    };

    public Solution(int param) {
        this.param = param;
    }

    @Override
    public void someAction() {
        solutionAction.someAction();
    }

    public static void main(String[] args) {
        Solution solution = new Solution(5);
        solution.someAction();
        System.out.println("Count of created Action objects is " + countActionObjects);

        solution = new Solution(-1);
        solution.someAction();
        System.out.println("Count of created Action objects is " + countActionObjects);
    }
}




    /**
     * 5
     * 4
     * 3
     * 2
     * 1
     * class FirstClass, method someAction
     * class SecondClass, method someAction
     * Specific action for anonymous SecondClass, param = 0
     * Count of created Action objects is 2
     * class SecondClass, method someAction
     * Specific action for anonymous SecondClass, param = -1
     * Count of created Action objects is 3
     */

/*
Исходный текст
public class Solution implements Action {
    public static int countActionObjects;

    private int param;

    private Action solutionAction = new Action() {
        //напишите тут ваш код

        public void someAction() {
            //напишите тут ваш код
        }
    };


    public Solution(int param) {
        this.param = param;
    }

    @Override
    public void someAction() {
        solutionAction.someAction();
    }


      5
      4
      3
      2
      1
      class FirstClass, method someAction
      class SecondClass, method someAction
      Specific action for anonymous SecondClass, param = 0
      Count of created Action objects is 2
      class SecondClass, method someAction
      Specific action for anonymous SecondClass, param = -1
      Count of created Action objects is 3

public static void main(String[] args) {
    Solution solution = new Solution(5);
    solution.someAction();
    System.out.println("Count of created Action objects is " + countActionObjects);

    solution = new Solution(-1);
    solution.someAction();
    System.out.println("Count of created Action objects is " + countActionObjects);
}
}

 */