package com.hzp.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//ReetrantLock可重入锁例子
class Phone1{

    Lock lock = new ReentrantLock();

    public void sendMessage(){
        try {
            lock.lock();
            System.out.println(Thread.currentThread().getId() + " \t " + " invoked sendMessage");
            sendEmail();
        }finally {
            lock.unlock();
        }

    }

    public synchronized void sendEmail(){
        try {
            lock.lock();

            System.out.println(Thread.currentThread().getId() + " \t " + " ###### invoked sendEmail");
            System.out.println("----------------------------------- 分割线  -----------------------------------");
            System.out.println();
        }finally {
            lock.unlock();
        }

    }
}
public class ReetrantLockDemo {

    public static void main(String[] args) throws InterruptedException {

        Phone1 phone = new Phone1();

        new Thread(()->{
            phone.sendMessage();
        }).start();

        new Thread(()->{
            phone.sendMessage();
        }).start();
    }
}
