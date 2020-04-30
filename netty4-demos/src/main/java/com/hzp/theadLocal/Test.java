package com.hzp.theadLocal;

public class Test {

    public static ThreadLocal<String> mapLocal = new ThreadLocal<>();

    public static void main(String[] args) throws InterruptedException {
        Test.mapLocal.set("ssss");
        System.out.println(Test.mapLocal.get());

        Thread thread1 = new Thread(() -> {
            Test.mapLocal.set("aaaa");
            System.out.println(Test.mapLocal.get());
        });
        thread1.start();
        thread1.join();

        System.out.println(Test.mapLocal.get());
    }
}
