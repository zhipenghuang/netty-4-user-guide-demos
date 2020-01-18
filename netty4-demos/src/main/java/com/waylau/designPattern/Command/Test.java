package com.waylau.designPattern.Command;

public class Test {

    public static void main(String[] args) {
        Receiver receiver = new Receiver();
        Command cmd = new MyCommand(receiver);
        cmd.exe();
        Invoker invoker = new Invoker(cmd);
        invoker.action();
    }
}