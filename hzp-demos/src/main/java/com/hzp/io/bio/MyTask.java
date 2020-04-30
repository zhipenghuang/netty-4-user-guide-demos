package com.hzp.io.bio;

import java.io.*;
import java.net.Socket;

public class MyTask extends Thread {

    Socket clientSocket = null;

    public MyTask(Socket socket) {
        this.clientSocket = socket;
    }

    @Override
    public void run() {
        PrintWriter out = null;
        try {
            out = new PrintWriter(clientSocket.getOutputStream(), true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 接收客户端的信息
        BufferedReader in = null;
        try {
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        {
            String inputLine = null;
            while (true) {
                try {
                    if (!((inputLine = in.readLine()) != null)) break;
                } catch (IOException e) {
                    e.printStackTrace();
                }

                // 发送信息给客户端
                out.println(inputLine);
                System.out.println("BlockingEchoServer -> " + clientSocket.getRemoteSocketAddress() + ":" + inputLine);
            }
        }
    }
}