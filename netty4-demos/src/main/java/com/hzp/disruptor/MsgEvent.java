package com.hzp.disruptor;

public class MsgEvent {

    public String name;

    public void setValue(String name) {
        this.name = name;
    }

    public String getValue() {
        return name;
    }
}
