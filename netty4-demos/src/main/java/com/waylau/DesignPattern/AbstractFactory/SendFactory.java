package com.waylau.DesignPattern.AbstractFactory;

import com.waylau.DesignPattern.FactoryMethod.SmsSender;

public class SendFactory implements Provider{

    @Override
    public Sender produce() {
        return new MailSender();
    }
}
