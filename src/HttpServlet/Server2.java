package HttpServlet;
import SocketDemo.ChatRoom2.CloseUtile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server2 {
    private ServerSocket server;

    public static void main(String[] args) throws IOException {
        Server2 server = new Server2();


        server.start();
    }

    public void start() {
        try {
            server = new ServerSocket(8888);
            receive();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void receive() {
        try {
            StringBuilder sb = new StringBuilder();
            String msg = null;//接受客户端的请求信息
            Socket client = server.accept();
            byte[] data = new byte[20480];
            int length = client.getInputStream().read(data);

            //System.out.println(msg);
            String output = new String(data, 0, length);
            System.out.println(output);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void stop() {
        CloseUtile.close(server);
    }
}

