package com.hzp.interrupt;

public class Test {

    private static final String THREAD_Name = "biz-thread";

    public static void main(String[] args) throws InterruptedException {
        //创建线程，内部任务是死循环
        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                //如果当前线程被中断则退出循环
                while (!Thread.currentThread().isInterrupted())
                    System.out.println(Thread.currentThread()+"Hello");
            }
        });
        //启动
        thread.start();
        //用户线程休眠3s
        Thread.sleep(3000);

        //中断子线程
        System.out.println("--begin interrupt sub thread--");
        thread.interrupt();
        System.out.println("--end   interrupt sub thread--");

    }
}
