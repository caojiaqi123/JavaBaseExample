package HttpServlet;


import java.io.BufferedWriter;
import java.io.IOException;

import java.net.ServerSocket;
import java.net.Socket;


/**
 * 请求并响应
 */
public class Server4 {
    private final String CRLF = "\r\n";
    private final String BLANK = " ";
    ServerSocket server;

    public static void main(String[] args) throws IOException {
        Server4 server = new Server4();
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
            Servlet servlet = new Servlet();
            Request request = new Request(client.getInputStream());
            Response response = new Response(client.getOutputStream());
            servlet.service(request, response);

            response.pushToClient(200);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
