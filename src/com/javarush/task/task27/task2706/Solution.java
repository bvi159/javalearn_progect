package com.javarush.task.task27.task2706;

/* 
Убираем deadlock
Используя стратегию избегания deadlock-а сделай так, чтобы он не возник.
Метод main не участвует в тестировании.
Действуй аналогично примеру из лекций.
Изменения вноси только в safeMethod.

Требования:
•	Метод safeMethod не должен вызывать deadlock при использовании из разных потоков.
•	В методе safeMethod должен содержаться вызов метода unsafeMethod, с теми же аргументами.
•	В методе safeMethod должен содержаться вызов метода longTimeMethod.
•	В методе safeMethod должно содержаться два блока synchronized.

public class Solution {
    public void safeMethod(Object obj1, Object obj2) {
        int lock1 = obj1.hashCode();
        int lock2 = obj2.hashCode();

        Object firstLock = lock1 > lock2 ? obj1 : obj2;
        Object secondLock = lock1 > lock2 ? obj2 : obj1;

        synchronized (firstLock) {
            longTimeMethod();
            synchronized (secondLock) {
                unsafeMethod(obj1, obj2);
            }
        }
    }

    public void longTimeMethod() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException ignored) {
        }
    }

    protected void unsafeMethod(Object obj1, Object obj2) {
        System.out.println(obj1 + " " + obj2);
    }

    public static void main(String[] args) {
        final Object o1 = new Object();
        final Object o2 = new Object();
        final Solution solution = new Solution();

        new Thread() {
            @Override
            public void run() {
                solution.safeMethod(o1, o2);
            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                solution.safeMethod(o2, o1);
            }
        }.start();
    }
}

*/

public class Solution {
    public void safeMethod(Object obj1, Object obj2) {
        // Определяем порядок блокировки на основе хэш-кода объектов
        Object firstLock = obj1;
        Object secondLock = obj2;

        // Если хэш-код первого объекта больше, меняем порядок
        if (System.identityHashCode(firstLock) > System.identityHashCode(secondLock)) {
            firstLock = obj2;
            secondLock = obj1;
        }

        synchronized (firstLock) {
            longTimeMethod();
            synchronized (secondLock) {
                unsafeMethod(obj1, obj2);
            }
        }
    }

    public void longTimeMethod() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException ignored) {
        }
    }

    protected void unsafeMethod(Object obj1, Object obj2) {
        System.out.println(obj1 + " " + obj2);
    }

    public static void main(String[] args) {
        final Object o1 = new Object();
        final Object o2 = new Object();
        final Solution solution = new Solution();

        new Thread() {
            @Override
            public void run() {
                System.out.println("Thread one ongo!!!");
                solution.safeMethod(o1, o2);
            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                System.out.println("Thread two ongo too!!!");
                solution.safeMethod(o2, o1);
            }
        }.start();
    }
}
/*
public class Solution {
    public void safeMethod(Object obj1, Object obj2) {
        synchronized (obj1) {
            longTimeMethod();
            synchronized (obj2) {
                unsafeMethod(obj1, obj2);
            }
        }
    }

    public void longTimeMethod() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException ignored) {
        }
    }

    protected void unsafeMethod(Object obj1, Object obj2) {
        System.out.println(obj1 + " " + obj2);
    }

    public static void main(String[] args) {
        final Object o1 = new Object();
        final Object o2 = new Object();
        final Solution solution = new Solution();

        new Thread() {
            @Override
            public void run() {
                solution.safeMethod(o1, o2);
            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                solution.safeMethod(o2, o1);
            }
        }.start();
    }
}
 */