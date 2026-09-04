package ru.javarush.java.core.level24.task12;

/*
Космическая катастрофа: Многоуровневая цепочка сбоев

Представьте, что вы — инженер на борту космического корабля, и система начинает сбоить по цепочке: сначала одна небольшая проблема, потом она вызывает более серьёзную, и, наконец, происходит критический отказ. Вам важно видеть всю картину произошедшего, чтобы понять, какие модули затронул каждый сбой.
Вам предстоит создать три класса исключений, которые будут отражать уровни этих сбоев: FirstSystemFailure, SecondSystemFailure, ThirdSystemFailure. Все они должны быть наследниками Exception, и каждый из них должен иметь конструктор, принимающий строку message и объект Throwable cause.
Теперь создайте три метода, которые будут имитировать эту цепочку сбоев:
initiateSystemFailure: он должен "выбросить" FirstSystemFailure с сообщением "Проблема в ядре системы". У этого исключения "первопричины" (cause) пока нет, поэтому передайте null.
triggerNavigationMalfunction: этот метод будет вызывать initiateSystemFailure. Если FirstSystemFailure "сработает", triggerNavigationMalfunction должен "перехватить" его и затем "выбросить" SecondSystemFailure с сообщением "Навигационная система отказала", при этом передав перехваченный FirstSystemFailure как "первопричину".
provokeLifeSupportCrisis: этот метод, в свою очередь, будет вызывать triggerNavigationMalfunction. Если SecondSystemFailure "сработает", provokeLifeSupportCrisis должен "перехватить" его и "выбросить" ThirdSystemFailure с сообщением "Критический отказ системы жизнеобеспечения", передав перехваченный SecondSystemFailure как "первопричину".
Наконец, в главной части вашей программы (методе main) вызовите provokeLifeSupportCrisis внутри блока try-catch. В блоке catch перехватите ThirdSystemFailure и незамедлительно вызовите у него специальный метод printStackTrace(). Это действие позволит вам увидеть полный "отчёт о катастрофе", включая всю многоуровневую цепочку исключений, чтобы вы могли проследить весь путь "падения" и понять, какие модули затронул каждый сбой.

Требования:
•	Должны быть созданы три класса исключений: FirstSystemFailure, SecondSystemFailure и ThirdSystemFailure, каждый из которых наследуется от Exception.
•	Каждый из классов исключений должен иметь конструктор, принимающий строку message и объект Throwable cause, и корректно передавать их в конструктор суперкласса Exception.
•	Должен быть реализован метод initiateSystemFailure, который выбрасывает FirstSystemFailure с сообщением "Проблема в ядре системы" и с cause == null.
•	Должен быть реализован метод triggerNavigationMalfunction, который вызывает initiateSystemFailure. При возникновении FirstSystemFailure он перехватывается и выбрасывается SecondSystemFailure с сообщением "Навигационная система отказала" и переданным cause (перехваченный FirstSystemFailure).
•	Должен быть реализован метод provokeLifeSupportCrisis, который вызывает triggerNavigationMalfunction. При возникновении SecondSystemFailure он перехватывается и выбрасывается ThirdSystemFailure с сообщением "Критический отказ системы жизнеобеспечения" и переданным cause (перехваченный SecondSystemFailure).
•	В методе main должен быть вызов provokeLifeSupportCrisis внутри блока try-catch, где в блоке catch перехватывается ThirdSystemFailure.
•	В блоке catch после перехвата ThirdSystemFailure должен быть вызван метод printStackTrace() для вывода полной цепочки исключений.


public class Solution {
    // Инициирует первый сбой без первопричины (cause == null)
    public static void initiateSystemFailure() throws ... {

    }

    // Вызывает initiateSystemFailure и, при сбое, оборачивает его во второй уровень
    public static void triggerNavigationMalfunction() throws ... {

    }

    // Вызывает triggerNavigationMalfunction и, при сбое, оборачивает его в третий уровень
    public static void provokeLifeSupportCrisis() throws ... {

    }

    public static void main(String[] args) {
        try {
            // Запускаем цепочку сбоев
            provokeLifeSupportCrisis();
        } catch (... e) {
            // Печатаем полный стек-трейс с цепочкой причин (chained exceptions)
            e.printStackTrace();
        }
    }
}

 */

public class Solution {
    // Инициирует первый сбой без первопричины (cause == null)
    public static void initiateSystemFailure() throws FirstSystemFailure {
        throw new FirstSystemFailure("Проблема в ядре системы", null);
    }

    // Вызывает initiateSystemFailure и, при сбое, оборачивает его во второй уровень
    public static void triggerNavigationMalfunction() throws SecondSystemFailure {
        try{
            initiateSystemFailure();
        } catch (FirstSystemFailure e) {
            throw new SecondSystemFailure("Навигационная система отказала", e);
        }

    }

    // Вызывает triggerNavigationMalfunction и, при сбое, оборачивает его в третий уровень
    public static void provokeLifeSupportCrisis() throws ThirdSystemFailure {
        try {
            triggerNavigationMalfunction();
        } catch (SecondSystemFailure e) {
            throw new ThirdSystemFailure("Критический отказ системы жизнеобеспечения",e);
        }
    }

    public static void main(String[] args) {
        try {
            // Запускаем цепочку сбоев
            provokeLifeSupportCrisis();
        } catch (ThirdSystemFailure e) {
            // Печатаем полный стек-трейс с цепочкой причин (chained exceptions)
            e.printStackTrace();
        }
    }
}

class FirstSystemFailure extends Exception {
    public FirstSystemFailure(String message, Throwable cause) {
        super(message, cause);
    }
}

class SecondSystemFailure extends Exception {
    public SecondSystemFailure(String message, Throwable cause) {
        super(message, cause);
    }
}

class ThirdSystemFailure extends Exception {
    public ThirdSystemFailure(String message, Throwable cause) {
        super(message, cause);
    }
}

/*
public class Solution {
    // Инициирует первый сбой без первопричины (cause == null)
    public static void initiateSystemFailure() throws FirstSystemFailure {
        throw new FirstSystemFailure("Проблема в ядре системы", null);
    }

    // Вызывает initiateSystemFailure и, при сбое, оборачивает его во второй уровень
    public static void triggerNavigationMalfunction() throws SecondSystemFailure {
        try {
            initiateSystemFailure();
        } catch (FirstSystemFailure e) {
            // Пробрасываем новый SecondSystemFailure, сохраняя исходную причину
            throw new SecondSystemFailure("Навигационная система отказала", e);
        }
    }

    // Вызывает triggerNavigationMalfunction и, при сбое, оборачивает его в третий уровень
    public static void provokeLifeSupportCrisis() throws ThirdSystemFailure {
        try {
            triggerNavigationMalfunction();
        } catch (SecondSystemFailure e) {
            // Пробрасываем новый ThirdSystemFailure, сохраняя предыдущую причину
            throw new ThirdSystemFailure("Критический отказ системы жизнеобеспечения", e);
        }
    }

    public static void main(String[] args) {
        try {
            // Запускаем цепочку сбоев
            provokeLifeSupportCrisis();
        } catch (ThirdSystemFailure e) {
            // Печатаем полный стек-трейс с цепочкой причин (chained exceptions)
            e.printStackTrace();
        }
    }
}

// Первый уровень сбоя: источник цепочки
class FirstSystemFailure extends Exception {
    public FirstSystemFailure(String message, Throwable cause) {
        super(message, cause); // передаем message и cause в Exception
    }
}

// Второй уровень сбоя: навигация
class SecondSystemFailure extends Exception {
    public SecondSystemFailure(String message, Throwable cause) {
        super(message, cause);
    }
}

// Третий уровень сбоя: жизнеобеспечение
class ThirdSystemFailure extends Exception {
    public ThirdSystemFailure(String message, Throwable cause) {
        super(message, cause);
    }
}
 */