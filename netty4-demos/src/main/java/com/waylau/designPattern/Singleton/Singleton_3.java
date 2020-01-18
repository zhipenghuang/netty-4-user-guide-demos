package com.waylau.designPattern.Singleton;

public class Singleton_3 {

    private static Singleton_3 instance = null;

    private Singleton_3() {
    }

    private static synchronized void syncInit() {
        if (instance == null) {
            instance = new Singleton_3();
        }
    }

    public static Singleton_3 getInstance() {
        if (instance == null) {
            syncInit();
        }
        return instance;
    }
}
