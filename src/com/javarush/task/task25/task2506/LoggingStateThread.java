package com.javarush.task.task25.task2506;
// это ихнее, но моё тоже работает - условие - в Solution
//public class LoggingStateThread extends Thread {
//
//    private Thread thread;
//
//    public LoggingStateThread(Thread thread) {
//        this.thread = thread;
//        setDaemon(true);
//    }
//
//    @Override
//    public void run() {
//        State currentState = thread.getState();
//        System.out.println(currentState);
//
//        State newState;
//        do {
//            if ((newState = thread.getState()) != currentState) {
//                currentState = newState;
//                System.out.println(newState);
//            }
//        } while (!currentState.equals(State.TERMINATED));
//    }
//}

public class LoggingStateThread extends Thread {
    private Thread myThread;
    public LoggingStateThread(Thread target) {
        myThread = target;

    }
    @Override
    public void run() {
        State previousState = myThread.getState();
        System.out.println(previousState);

        while (true) {
            State currentState = myThread.getState();

            if (currentState != previousState) {
                System.out.println(currentState);
                previousState = currentState;
            }

            if (currentState == State.TERMINATED) {
                break;
            }
        }
    }

}

/*
Моё
public class LoggingStateThread extends Thread {
    private Thread myThread;
    public LoggingStateThread(Thread target) {
       myThread = target;

    }
    @Override
    public void run() {
        State previousState = myThread.getState();
        System.out.println(previousState);

        while (true) {
            State currentState = myThread.getState();

            if (currentState != previousState) {
                System.out.println(currentState);
                previousState = currentState;
            }

            if (currentState == State.TERMINATED) {
                break;
            }
        }
    }

}
 */