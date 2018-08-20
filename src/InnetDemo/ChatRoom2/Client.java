package InnetDemo.ChatRoom2;

import java.io.*;
import java.net.Socket;

/**
 * 发送数据+接受数据
 * 写出数据 输出流
 * 读取数据 输入流
 *
 *
 *
 * 输入流与输出流在同一个线程内 应该使用多线程 使之独立
 */
public class Client {
    public static void main(String[] args) throws IOException {
        Socket client = new Socket("localhost", 9999);
        //输出流 客户端往服务器输出
        Thread sendThread = new Thread(new Send(client));
        //输入流 服务器到客户端的输入
        Thread receiveThread = new Thread(new Receive(client));
        sendThread.start();
        receiveThread.start();


    }

}
