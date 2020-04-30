package com.hzp.lockSuport;

import java.util.concurrent.locks.LockSupport;

class ThreadParkService extends Thread {

    private Thread thread;

    public ThreadParkService(Thread thread) {
        this.thread = thread;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " wakup before");
        LockSupport.unpark(thread);//解锁后线程2立马就可以执行了。
        try {
            System.out.println("解锁后休息三秒哦");
            Thread.sleep(6000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " wakup after");

    }
}

public class Test2 {

    public static void main(String args[]) {
        Thread thread = Thread.currentThread();

        ThreadParkService service = new ThreadParkService(thread);
        System.out.println(Thread.currentThread().getName()+" start1");
        service.start();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+" center");
        LockSupport.park(thread);
        System.out.println("end");

    }
}
