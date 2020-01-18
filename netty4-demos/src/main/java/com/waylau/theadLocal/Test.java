package com.waylau.theadLocal;

import java.util.HashMap;
import java.util.Map;

public class Test {

    public static ThreadLocal<Map> mapLocal = new ThreadLocal<>();

    public static void main(String[] args) throws InterruptedException {
        Map<String, String> map = new HashMap<>();
        map.put("main", "main");
        Test.mapLocal.set(map);
        System.out.println(Test.mapLocal.get().get("main"));

        Thread thread1 = new Thread(() -> {
            Map<String, String> map1 = new HashMap<>();
            map1.put("main", "ssss");
            Test.mapLocal.set(map1);
            System.out.println(Test.mapLocal.get().get("main"));
        });
        thread1.start();
        thread1.join();

        System.out.println(Test.mapLocal.get().get("main"));
    }
}
