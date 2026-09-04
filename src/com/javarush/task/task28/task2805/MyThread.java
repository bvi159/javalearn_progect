package com.javarush.task.task28.task2805;
public class MyThread extends Thread {
    private static int nextPriority = Thread.MIN_PRIORITY;

    public MyThread() {
        super();
        initPriority(null);
    }

    public MyThread(Runnable target) {
        super(target);
        initPriority(null);
    }

    public MyThread(ThreadGroup group, Runnable target) {
        super(group, target);
        initPriority(group);
    }

    public MyThread(String name) {
        super(name);
        initPriority(null);
    }

    public MyThread(Runnable target, String name) {
        super(target, name);
        initPriority(null);
    }

    public MyThread(ThreadGroup group, String name) {
        super(group, name);
        initPriority(group);
    }

    public MyThread(ThreadGroup group, Runnable target, String name) {
        super(group, target, name);
        initPriority(group);
    }

    public MyThread(ThreadGroup group, Runnable target, String name, long stackSize) {
        super(group, target, name, stackSize);
        initPriority(group);
    }

    private void initPriority(ThreadGroup group) {
        int priority = getNextPriority();

        if (group != null) {
            int maxGroupPriority = group.getMaxPriority();
            if (priority > maxGroupPriority) {
                priority = maxGroupPriority;
            }
        }

        setPriority(priority);
    }

    private synchronized int getNextPriority() {
        int priority = nextPriority;
        nextPriority++;

        if (nextPriority > Thread.MAX_PRIORITY) {
            nextPriority = Thread.MIN_PRIORITY;
        }

        return priority;
    }
}

/*
import java.util.concurrent.atomic.AtomicInteger;

public class MyThread extends Thread {

    private static volatile AtomicInteger priority = new AtomicInteger(1);

    private synchronized void correctPriority() {
        int newPriority = priority.getAndIncrement();
        newPriority = getThreadGroup() != null && newPriority > getThreadGroup().getMaxPriority() ? getThreadGroup().getMaxPriority() : newPriority;
        setPriority(newPriority);
        if (priority.intValue() > MAX_PRIORITY) {
            priority.set(1);
        }
    }

    public MyThread() {
        super();
        correctPriority();
    }

    public MyThread(Runnable target) {
        super(target);
        correctPriority();
    }

    public MyThread(ThreadGroup group, Runnable target) {
        super(group, target);
        correctPriority();
    }

    public MyThread(String name) {
        super(name);
        correctPriority();
    }

    public MyThread(ThreadGroup group, String name) {
        super(group, name);
        correctPriority();
    }

    public MyThread(Runnable target, String name) {
        super(target, name);
        correctPriority();
    }

    public MyThread(ThreadGroup group, Runnable target, String name) {
        super(group, target, name);
        correctPriority();
    }

    public MyThread(ThreadGroup group, Runnable target, String name, long stackSize) {
        super(group, target, name, stackSize);
        correctPriority();
    }
}
*/