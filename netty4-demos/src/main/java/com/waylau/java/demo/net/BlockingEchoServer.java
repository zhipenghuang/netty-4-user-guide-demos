/**
 * Welcome to https://waylau.com
 */
package com.waylau.java.demo.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Blocking Echo Server.
 *
 * @author <a href="https://waylau.com">Way Lau</a>
 * @since 1.0.0 2019年9月28日
 */
public class BlockingEchoServer {

    public static int DEFAULT_PORT = 7;

    /**
     * @param args
     */
    public static void main(String[] args) throws IOException {

        int port;

        try {
            port = Integer.parseInt(args[0]);
        } catch (RuntimeException ex) {
            port = DEFAULT_PORT;
        }

        ServerSocket serverSocket = null;
        try {
            // 服务器监听
            serverSocket = new ServerSocket(port);
            System.out.println("BlockingEchoServer已启动，端口：" + port);
        } catch (IOException e) {
            System.out.println("BlockingEchoServer启动异常，端口：" + port);
            System.out.println(e.getMessage());
        }

        // Java 7 try-with-resource语句
        Socket clientSocket = null;
        int count = 0;
        while (true) {
            // 接受客户端建立链接，生成Socket实例
            clientSocket = serverSocket.accept();
            MyTask task = new MyTask(clientSocket);
            task.start();
            count++;
        }
    }

}
