package com.waylau.disruptor;

public class MsgEvent {

    public String name;

    public void setValue(String name) {
        this.name = name;
    }

    public String getValue() {
        return name;
    }
}
