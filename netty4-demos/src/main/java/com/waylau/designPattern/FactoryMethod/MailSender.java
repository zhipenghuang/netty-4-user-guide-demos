package com.waylau.designPattern.FactoryMethod;

public class MailSender implements Sender {

    @Override
    public void Send() {
        System.out.println("this is mailsender!");
    }

}
