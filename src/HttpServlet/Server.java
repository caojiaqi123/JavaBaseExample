package HttpServlet;

import SocketDemo.ChatRoom2.CloseUtile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @description 1创建服务器并启动
 * @params
 */
public class Server {
    private ServerSocket server;

    public static void main(String[] args) throws IOException {
        Server server = new Server();


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
            BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));

            while ((msg = br.readLine()).length() > 0) {
                if (msg == "") {
                    break;
                }
                //System.out.println(msg);
                sb.append(msg);
                sb.append(System.getProperty("line.separator"));
            }
            String output = sb.toString().trim();
            System.out.println(output);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void stop() {
        CloseUtile.close(server);
    }
}
