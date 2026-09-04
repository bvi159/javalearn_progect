package com.javarush.examples.Lesson_10_7;

import java.io.Serializable;

public class DiplomacyInfo implements Serializable {
    private String info;

    public DiplomacyInfo(String info) {
        this.info = info;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "com.javarush.examples.Lesson_10_7.DiplomacyInfo{" +
                "info='" + info + '\'' +
                '}';
    }
}
