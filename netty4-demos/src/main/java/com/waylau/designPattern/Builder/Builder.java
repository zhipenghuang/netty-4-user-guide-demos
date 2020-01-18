package com.waylau.designPattern.Builder;

import com.waylau.designPattern.FactoryMethod.MailSender;
import com.waylau.designPattern.FactoryMethod.Sender;
import com.waylau.designPattern.FactoryMethod.SmsSender;

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
