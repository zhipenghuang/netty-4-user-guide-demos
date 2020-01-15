package com.waylau.DesignPattern.Visitor;

public interface Subject {
    void accept(Visitor visitor);

    String getSubject();
}
