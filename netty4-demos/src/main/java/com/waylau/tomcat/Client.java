package com.waylau.tomcat;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private static int port = 5228;
    private static String host = "127.0.0.1";

    //http://127.0.0.1:8080/com.waylau.tomcat/Index.java?show
    public static void main(String[] args) {
        try {
            Socket con = new Socket(host, port);
            System.out.println("请输入URL地址：");
            Scanner scanner = new Scanner(System.in);
            String info = scanner.nextLine().trim();
            Writer writer = new OutputStreamWriter(con.getOutputStream());
            writer.write(info);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}