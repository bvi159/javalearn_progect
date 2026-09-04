package com.javarush.task.task24.task2401;

public class SelfInterfaceMarkerImpl implements SelfInterfaceMarker {
    private String name;
    private String serName;

    public void myName(){
        System.out.println("My name is SelfInterfaceMarkerImpl1");
    }
    public void myImplemented(){
        System.out.println("I implements markers' interface!");
    }
//    public SelfInterfaceMarkerImpl(String name, String serName){
//        this.name = name;
//        this.serName = serName;
//    }
}
