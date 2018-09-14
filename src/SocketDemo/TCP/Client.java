package SocketDemo.TCP;

import java.io.*;
import java.net.Socket;

/**
 * 必须直到服务端 +端口
 */
public class Client {
    public static void main(String[] args) throws IOException {
        Socket client = new Socket("localhost", 8888);

        //  BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
//        int len = 0;
//        String msg = null;
//        while (null != (msg = reader.readLine())) {
//            System.out.println(msg);
//        }
        DataInputStream dis = new DataInputStream(new BufferedInputStream(client.getInputStream()));
        int len = 0;
        // while (-1 != (len = dis.read())) {
        System.out.println(dis.readUTF());
        // }
    }
}
