package com.hzp.designPattern.AbstractFactory;

public class SendFactory implements Provider{

    @Override
    public Sender produce() {
        return new MailSender();
    }
}
