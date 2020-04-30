package com.hzp.semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class SemaphoreTest {


    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();
        Semaphore semaphor = new Semaphore(0);

        executor.execute(new Runnable() {

            @Override
            public void run() {

                try {
                    System.out.println("want to have a hamburger！");
                    semaphor.acquire();

                    System.out.println("start eat!");
                    Thread.currentThread().sleep(1000);
                    System.out.println("end!");

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });


        executor.execute(new Runnable() {

            @Override
            public void run() {

                try {

                    if(semaphor.availablePermits()==0){
                        System.out.println("there is no hamburger,cook make one");
                        Thread.currentThread().sleep(1000);
                        System.out.println("release a hamburger!");

                        semaphor.release();
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });

    }

}