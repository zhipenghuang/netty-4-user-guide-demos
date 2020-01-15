package com.waylau.DesignPattern.Iterator;

public interface Iterator {
    //前移
    Object previous();

    //后移
    Object next();

    //是否还有元素
    boolean hasNext();

    //取得第一个元素
    Object first();
}
