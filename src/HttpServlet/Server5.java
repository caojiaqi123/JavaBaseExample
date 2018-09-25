package HttpServlet;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


/**
 * 请求并响应
 */
public class Server5 {
    private final String CRLF = "\r\n";
    private final String BLANK = " ";
    ServerSocket server;

    public static void main(String[] args) throws IOException {
        Server5 server = new Server5();
        server.start();
    }

    public void start() throws IOException {
        server = new ServerSocket(8888);
        receive();
    }

    public void receive() {
        Socket client = null;
        try {
            client = server.accept();
            new Thread(new Dispatcher(client)).start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
