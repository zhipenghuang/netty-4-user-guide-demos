package com.waylau.DynamicProxy;

public class RealSubject implements Subject {
    @Override
    public void test() {
        System.out.print("this is dynamic RealSubject test");
    }
}