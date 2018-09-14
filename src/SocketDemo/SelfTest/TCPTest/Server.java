package SocketDemo.SelfTest.TCPTest;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * tcp server端 可以直接使用浏览器访问 浏览器是基于tcp/ip协议的
 */
public class Server {
    //tcp server
    private ServerSocket server;

    public static void main(String[] args) throws IOException {
        new Server().start();
    }

    public void start() throws IOException {
        server = new ServerSocket(8888);

        //获取客户端返回
        Socket client = server.accept();
        char[] chs = new char[1024];
        int length = 0;
        // Reader is = new InputStreamReader(client.getInputStream());
        // while (-1 != (length = is.read(chs))) {
        //     String outStr = new String(chs, 0, length);
        //     System.out.println(outStr);
        // }
        // is.close();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()))) {
            String outStr;
            while ((outStr = br.readLine()).length() > 0) {
                System.out.println(outStr);
            }
        }
    }
}
