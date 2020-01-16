package com.waylau.tomcat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private static int port = 5228;

    private static UrlUtil urlutil = new UrlUtil();

    public static void main(String[] args) {
        System.out.println(" My Tomcat is Running");
        try {
            ServerSocket server = new ServerSocket(port);
            while (true) {
                Socket socket = server.accept();// 服务器每接受一次请求，就创建一个socket对象
                InputStream in = socket.getInputStream();
                BufferedReader br = new BufferedReader(
                        new InputStreamReader(in));
                String info = null;
                String infoline = br.readLine();
                while (infoline != null) {
                    info = info + infoline;
                    infoline = br.readLine();
                }
                UrlBean url = urlutil.readString(info);
                if (url != null) {
                    String path = url.getPath();
                    String className = url.getFileName();
                    String methodName = url.getParameter().trim();
                    ClassLoader classloader = ClassLoader.getSystemClassLoader();
                    try {
                        classloader.loadClass(path + "." + className);
                        Class<?> getclass = Class.forName(path + "." + className);
                        Method method = getclass.getMethod(methodName, null);
                        method.invoke(getclass.newInstance(), null);

                    } catch (ClassNotFoundException | NoSuchMethodException | SecurityException |
                            IllegalAccessException | IllegalArgumentException | InvocationTargetException |
                            InstantiationException e) {
                        e.printStackTrace();
                    }
                } else {

                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
