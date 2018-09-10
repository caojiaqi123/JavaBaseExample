package SocketDemo.UDP;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * @description 服务端
 * 1。创建服务端+端口
 * @params
 */
public class MyServer {
    public static void main(String[] args) throws IOException {
        System.out.println("服务器开启");
        DatagramSocket server = new DatagramSocket(8888);
        //2准备接受容器
        byte[] contain = new byte[1024];
        //3 封装包
        DatagramPacket packet = new DatagramPacket(contain, contain.length);
        //4 接受数据
        server.receive(packet);
        //分析数据
        byte[] data = packet.getData();
        int len = packet.getLength();
        // System.out.println(new String(data, 0, len));

        System.out.println(getData(data));
        server.close();
        System.out.println("服务器关闭");
    }

    private static double getData(byte[] data) throws IOException {
        ByteArrayInputStream in = new ByteArrayInputStream(data);
        DataInputStream dis = new DataInputStream(in);
        double num = dis.readDouble();
        dis.close();
        return num;
    }
}
