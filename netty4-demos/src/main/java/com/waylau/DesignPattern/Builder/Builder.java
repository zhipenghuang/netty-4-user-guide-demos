package com.waylau.DesignPattern.Builder;

import com.waylau.DesignPattern.FactoryMethod.MailSender;
import com.waylau.DesignPattern.FactoryMethod.Sender;
import com.waylau.DesignPattern.FactoryMethod.SmsSender;

import java.util.ArrayList;
import java.util.List;

public class Builder {
    private List<Sender> list = new ArrayList<>();

    public void produceMailSender(int count){
        for(int i=0; i<count; i++){
            list.add(new MailSender());
        }
    }

    public void produceSmsSender(int count){
        for(int i=0; i<count; i++){
            list.add(new SmsSender());
        }
    }
}
