package com.hzp.lockSuport;

class TestRunnable implements Runnable{
    public void run(){
        while(true)
        {
            System.out.println( "Thread is running..." );
            long time = System.currentTimeMillis();
            ////空循环1s
            while((System.currentTimeMillis()-time < 1000)) {

            }
        }
    }
}


public class ThreadInterruptDome {

    public static void main(String[] args){
        Thread th1=new Thread(new TestRunnable());
        th1.start();
        th1.interrupt();
    }
}