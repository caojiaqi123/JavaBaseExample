package InnetDemo.UDP;

import com.google.common.cache.Cache;
import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;

import java.io.*;
import java.net.*;

/**
 * 服务端
 */
public class MyClient {
    public static void main(String[] args) throws IOException {
        try (DatagramSocket client = new DatagramSocket(6666)) {
            // String msg = "udp编程";
            //数据打包
            byte[] contain = null;
            contain = getBytes(1.12);

            //  InetSocketAddress serverAdd = new InetSocketAddress("localhost", 8888);
            // DatagramPacket packet = new DatagramPacket(contain, contain.length, serverAdd);
            DatagramPacket packet = new DatagramPacket(contain, contain.length, InetAddress.getByName("localhost"), 8888);
            //发送
            client.send(packet);
        }


    }

    /**
     * 使用string
     */
    private static byte[] getBytes(String msg) {
        return msg.getBytes();
    }

    /**
     * 使用double 类型输出
     */
    private static byte[] getBytes(double d) throws IOException {
        byte[] data;
        ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dout = new DataOutputStream(new BufferedOutputStream(arrayOutputStream));
        dout.writeDouble(d);

        dout.flush();
        data = arrayOutputStream.toByteArray();
        arrayOutputStream.close();
        dout.close();
        return data;
    }
}
