package SocketDemo.ChatRoom3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * 发送数据+接受数据
 * 写出数据 输出流
 * 读取数据 输入流
 * <p>
 * <p>
 * <p>
 * 输入流与输出流在同一个线程内 应该使用多线程 使之独立
 */
public class Client {
    public static void main(String[] args) throws IOException {
        System.out.println("清输入用户名：");
        BufferedReader nameStream = new BufferedReader(new InputStreamReader(System.in));
        String name = nameStream.readLine();
        nameStream.close();

        Socket client = new Socket("localhost", 9999);
        //输出流 客户端往服务器输出
        Thread sendThread = new Thread(new Send(client, name));
        //输入流 服务器到客户端的输入
        Thread receiveThread = new Thread(new Receive(client));
        sendThread.start();
        receiveThread.start();


    }

}
