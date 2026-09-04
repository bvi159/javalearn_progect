package com.javarush.task.task24.task2408;

import java.text.SimpleDateFormat;

public abstract class SuperDog {
    protected String getSuperQuotes() {
        //some logic here
        return " *** ";
    }
//    protected String getSuperQuotes(String dogName) {
//        //some logic here
//        String barbos = " *** " + dogName + " *** ";
//        return barbos;
//    }


    protected SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy EEE");
}
/*
public abstract class SuperDog {
    protected String getSuperQuotes() {

    }

    protected SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy EEE");
}
 */