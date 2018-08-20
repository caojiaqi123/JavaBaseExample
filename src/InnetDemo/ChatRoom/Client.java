package InnetDemo.ChatRoom;

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
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //输出流 客户端往服务器输出
        DataOutputStream dos = new DataOutputStream(client.getOutputStream());
        //输入流 服务器到客户端的输入
        DataInputStream dis = new DataInputStream(client.getInputStream());
        String msg;
        while (true) {
            //输入
            msg = reader.readLine();
            dos.writeUTF(msg);
            dos.flush();


            System.out.println(dis.readUTF());
        }
    }

}
