package com.hzp.producerAndConsumer;

public interface AbstractStorage {
    void consume(int num);

    void produce(int num);
}
