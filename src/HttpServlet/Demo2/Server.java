package HttpServlet.Demo2;

import SocketDemo.ChatRoom2.CloseUtile;

import java.io.IOException;
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
        Socket client = null;
        try {
            client = server.accept();
            new Thread(new Dispatcher(client)).start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void stop() {
        CloseUtile.close(server);
    }
}
