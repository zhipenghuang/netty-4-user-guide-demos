package com.hzp.lockSuport;

class MyThreadStop extends Thread {

    private int temp;

    public MyThreadStop(int temp) {
        this.temp = temp;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("i=" + i);
            if (Thread.interrupted()) {
                System.out.println("线程已经停止了哦");
                break;
            }
        }
        System.out.println(Thread.currentThread().getName() + temp);
    }

}

public class ThreadStopDome {

    public static void main(String orgs[]) {
        MyThreadStop myThread = new MyThreadStop(1);
        myThread.start();
        myThread.interrupt();
        System.out.println("运行完毕");
    }
}
