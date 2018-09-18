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
            Request request = new Request(client.getInputStream());
            System.out.println(request.getParamter("uname"));
            //响应
            response(client);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void response(Socket client) throws IOException {
        StringBuilder sbContext = new StringBuilder();
        sbContext.append("<html>\n<head><title>第一个html</title></head>\n<body>\n" +
                "正文\n<p>段落</p>\n</body>\n</html>");

        Response rsp = new Response(client);
        rsp.print(sbContext.toString());
        rsp.pushToClient(404);
    }
}
