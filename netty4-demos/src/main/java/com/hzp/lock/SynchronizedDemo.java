package com.hzp.lock;


//Synchronized可重入锁例子
class Phone {
    public synchronized void sendMessage() {
        System.out.println(Thread.currentThread().getId() + " \t " + " invoked sendMessage");
        sendEmail();
    }

    public synchronized void sendEmail() {
        System.out.println(Thread.currentThread().getId() + " \t " + " ###### invoked sendEmail");
        System.out.println("----------------------------------- 分割线  -----------------------------------");
        System.out.println();
    }
}

public class SynchronizedDemo {

    public static void main(String[] args) {

        Phone phone = new Phone();
        new Thread(() -> {
            phone.sendMessage();
        }).start();

        new Thread(() -> {
            phone.sendMessage();
        }).start();
    }
}