package com.hamidniazi.endterm_project.patterns;

import java.time.LocalDateTime;

public class LoggerSingleton {

    // 1. Static variable to hold the single instance
    private static LoggerSingleton instance;

    // 2. Private constructor prevents others from making a new instance
    private LoggerSingleton() {
        System.out.println("Logger initialized!");
    }

    // 3. Public static method to get the single instance
    public static synchronized LoggerSingleton getInstance() {
        if (instance == null) {
            instance = new LoggerSingleton();
        }
        return instance;
    }

    public void log(String message) {
        System.out.println("[LOG " + LocalDateTime.now() + "]: " + message);
    }
}