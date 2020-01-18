package com.waylau.designPattern.AbstractFactory;

public class SendFactory implements Provider{

    @Override
    public Sender produce() {
        return new MailSender();
    }
}
