package com.waylau.designPattern.Visitor;

public interface Subject {
    void accept(Visitor visitor);

    String getSubject();
}
