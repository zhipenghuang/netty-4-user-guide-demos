package com.waylau.disruptor;


import com.lmax.disruptor.dsl.Disruptor;
import java.util.Arrays;
import java.util.concurrent.Executors;

//触发测试
public class Test {
    public static void main(String[] args) {
        Disruptor<MsgEvent> disruptor = new Disruptor<>(MsgEvent::new, 1024, Executors.defaultThreadFactory());

        //定义消费者
        MsgConsumer msg1 = new MsgConsumer("1");
        MsgConsumer msg2 = new MsgConsumer("2");
        MsgConsumer msg3 = new MsgConsumer("3");

        //绑定配置关系
        disruptor.handleEventsWith(msg1, msg2, msg3);
        disruptor.start();

        // 定义要发送的数据
        MsgProducer msgProducer = new MsgProducer(disruptor);
        msgProducer.send(Arrays.asList("nihao","hah"));
    }
}
