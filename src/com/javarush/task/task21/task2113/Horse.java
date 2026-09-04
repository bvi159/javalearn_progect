package com.javarush.task.task21.task2113;
/*
 */

public class Horse {
    private String name;
    private double speed;
    private double distance;

    public Horse(String name, double speed, double distance) {
        this.name = name;
        this.speed = speed;
        this.distance = distance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public void move(){
//     System.out.println("Движется конкретная лошадь!");
     distance += speed * Math.random();
    }

    /*
    в ответе такое решение:
     void print() {
        StringBuilder track = new StringBuilder();
        for (int i = 0; i < (int) distance; i++) {
            track.append(".");
        }
        System.out.println(track + name);
    }
     */

    public void print(){
//      System.out.println("Этод метод отрисовывает на экране конкретную лошадь!!");
      int points = (int) distance;
        for (int i = 0; i < points; i++) {
            System.out.print(".");
        }
      System.out.print(name + "\n");

    }


}
