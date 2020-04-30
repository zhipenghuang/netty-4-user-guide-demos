package com.hzp.dynamicProxy;

import java.lang.reflect.Proxy;

public class Test {
    public static void main(String[] args){
        RealSubject realSubject = new RealSubject();
        DynamicProxy proxy = new DynamicProxy(realSubject);
        Subject subject = (Subject) Proxy.newProxyInstance(
                realSubject.getClass().getClassLoader(),
                realSubject.getClass().getInterfaces(),
                proxy
        );
        subject.test();
    }
}
