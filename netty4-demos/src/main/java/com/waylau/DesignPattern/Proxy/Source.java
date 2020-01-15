package com.waylau.DesignPattern.Proxy;

public class Source implements Sourceable {

    @Override
    public void method() {
        System.out.println("the original method!");
    }
}
