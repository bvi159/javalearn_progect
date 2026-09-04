package com.javarush.task.task31.task3110.exception;

public class PathIsNotFoundException extends Exception {
    public PathIsNotFoundException() {
        super();
    }

    public PathIsNotFoundException(String message) {
        super(message);
    }

    public PathIsNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public PathIsNotFoundException(Throwable cause) {
        super(cause);
    }
}
