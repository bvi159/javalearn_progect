package com.javarush.examples.Lesson_10_7;

import java.io.Serializable;

public class ResourcesInfo implements Serializable {
    private String info;

    public ResourcesInfo(String info) {
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
        return "com.javarush.examples.Lesson_10_7.ResourcesInfo{" +
                "info='" + info + '\'' +
                '}';
    }
}
