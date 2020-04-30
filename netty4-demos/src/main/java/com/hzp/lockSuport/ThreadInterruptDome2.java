package com.hzp.lockSuport;

class TestRunnable2 implements Runnable{
    public void run(){
        while(true)
        {
            System.out.println( "Thread is running..." );
            if(Thread.interrupted()){//获取线程停止状态
                break;
            }
        }
        System.out.println("线程停止还是可以执行哦。");
    }
}


public class ThreadInterruptDome2 {

    public static void main(String[] args){
        Thread th1=new Thread(new TestRunnable2());
        th1.start();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        th1.interrupt();//设置状态为停止状态
    }
}