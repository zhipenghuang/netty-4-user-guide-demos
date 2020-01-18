package com.waylau.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class DynamicProxy implements InvocationHandler {
    Object mObj;

    public DynamicProxy(Object pObj) {
        mObj = pObj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = null;
        System.out.println("this is Dynamic proxy invoke");
        if (mObj != null) {
            result = method.invoke(mObj, args);
        }
        return result;
    }
}
