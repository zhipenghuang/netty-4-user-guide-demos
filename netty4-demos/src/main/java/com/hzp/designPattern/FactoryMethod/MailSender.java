package com.hzp.designPattern.FactoryMethod;

public class MailSender implements Sender {

    @Override
    public void Send() {
        System.out.println("this is mailsender!");
    }

}
