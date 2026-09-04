package ru.javarush.java.core.level21.task17;

import org.jetbrains.annotations.NotNull;

public class NumberBox implements Comparable<NumberBox>{
    private int numbox;

    NumberBox(int someNumber) {
        this.numbox = someNumber;
    }
    @Override
    public int compareTo(@NotNull NumberBox o) {
        return Integer.compare(this.numbox, o.numbox);
    }

}
