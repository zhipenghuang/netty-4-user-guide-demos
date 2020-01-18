package com.waylau.designPattern.Singleton;

import java.util.Vector;

public class Singleton_Shadow {
    private static Singleton_Shadow instance = null;
    private Vector properties = null;

    public Vector getProperties() {
        return properties;
    }

    private Singleton_Shadow() {
    }

    private static synchronized void syncInit() {
        if (instance == null) {
            instance = new Singleton_Shadow();
        }
    }

    public static Singleton_Shadow getInstance() {
        if (instance == null) {
            syncInit();
        }
        return instance;
    }

    public void updateProperties() {
        Singleton_Shadow shadow = new Singleton_Shadow();
        properties = shadow.getProperties();
    }
}
