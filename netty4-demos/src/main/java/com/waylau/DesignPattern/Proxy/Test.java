package com.waylau.DesignPattern.Proxy;

public class Test {

    public static void main(String[] args) {
        Sourceable source = new Proxy();
        source.method();
    }

}