package com.waylau.lock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class CacheResource{
    private volatile Map<String, Object> map = new HashMap<>();
    private ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();

    public void put(String key, Object value){
        try {
            reentrantReadWriteLock.writeLock().lock();
            System.out.println("--------------------------------------------------------------");
            System.out.println(Thread.currentThread().getId() + " \t " + "正在写入" + key);

        }finally {
            System.out.println(Thread.currentThread().getId() + " \t " + "写入成功" + key);
            System.out.println("--------------------------------------------------------------");

            reentrantReadWriteLock.writeLock().unlock();
        }
    }

    public void get(String key){
        try {
            reentrantReadWriteLock.readLock().lock();
            System.out.println(Thread.currentThread().getId() + " \t " + "正在读取 \t" + key);
        }finally {
            System.out.println(Thread.currentThread().getId() + " \t " + "读取成功 \t" + key);
            reentrantReadWriteLock.readLock().unlock();
        }

    }
}
public class ReadWriteLock {

    public static void main(String[] args) {
        CacheResource resource = new CacheResource();

        for (int i = 0; i < 5; i++){
            final int tmp = i;
            new Thread(()->{
                resource.put(tmp + "", "");
            }).start();
        }

        for (int i = 0; i < 5; i++){
            final int tmp = i;
            new Thread(()->{
                resource.get(tmp + "");
            }).start();
        }
    }
}
