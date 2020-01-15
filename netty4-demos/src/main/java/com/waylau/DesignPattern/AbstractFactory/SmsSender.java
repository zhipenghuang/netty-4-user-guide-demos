package com.waylau.DesignPattern.AbstractFactory;

public class SmsSender implements Sender {
    @Override
    public void Send() {
        System.out.println("this is sms sender!");
    }
}
