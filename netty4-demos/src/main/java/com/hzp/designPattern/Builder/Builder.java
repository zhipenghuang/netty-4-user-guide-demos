package com.hzp.designPattern.Builder;

import com.hzp.designPattern.FactoryMethod.MailSender;
import com.hzp.designPattern.FactoryMethod.Sender;
import com.hzp.designPattern.FactoryMethod.SmsSender;

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
