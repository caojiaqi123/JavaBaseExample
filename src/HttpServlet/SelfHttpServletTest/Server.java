package HttpServlet.SelfHttpServletTest;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private final String CRLF = "\r\n";
    private final String BLANK = " ";
    ServerSocket server;

    public static void main(String[] args) throws IOException {
        new Server().start();

    }

    public void start() throws IOException {
        server = new ServerSocket(8888);
        receive();
    }

    public void receive() throws IOException {
        Socket client = server.accept();
        byte[] data = new byte[10240];
        // BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
        // String info = "";
        // while (((info = br.readLine()) != "" && info != null)) {
        //     System.out.println(info);
        // }

        int length = client.getInputStream().read(data);
        String info = new String(data, 0, length);
        System.out.println(info);
        send(client);
    }

    public void send(Socket client) throws IOException {
        StringBuilder sbContext = new StringBuilder();
        sbContext.append("<html>\n<head><title>第一个html</title></head>\n<body>\n" +
                "正文\n<p>段落</p>\n</body>\n</html>");

        Response response = new Response(client.getOutputStream());
        response.appendContext(sbContext.toString());
        response.pushToClient(500);
    }

}
