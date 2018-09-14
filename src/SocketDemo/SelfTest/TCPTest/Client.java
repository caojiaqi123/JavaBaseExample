package SocketDemo.SelfTest.TCPTest;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class Client {
    private Socket client;

    public static void main(String[] args) throws IOException {
        new Client().start();
    }

    public void start() throws IOException {
        client = new Socket("localhost", 8888);
        OutputStreamWriter ow = new OutputStreamWriter(new BufferedOutputStream(client.getOutputStream()));
        ow.write("这是来自客户端的测试");
        ow.flush();
        ow.close();
    }
}
