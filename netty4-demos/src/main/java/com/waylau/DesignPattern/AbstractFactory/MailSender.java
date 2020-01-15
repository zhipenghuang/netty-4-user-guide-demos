package com.waylau.DesignPattern.AbstractFactory;

public class MailSender implements Sender {

    @Override
    public void Send() {
        System.out.println("this is mailsender!");
    }

}
