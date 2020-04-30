package com.hzp.designPattern.Bridge;

public class MyBridge extends Bridge {
    public void method(){
        getSource().method();
    }
}