package HttpServlet;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.cert.CRL;

/**
 * 请求并响应
 */
public class Server3 {
    private final String CRLF = "\r\n";
    private final String BLANK = " ";
    ServerSocket server;

    public static void main(String[] args) throws IOException {
        Server3 server = new Server3();
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
            byte[] data = new byte[20480];
            int length = client.getInputStream().read(data);

            String info = new String(data, 0, length);
            System.out.println(info.trim());

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

        StringBuilder sbHttpHeader = new StringBuilder();
        // 版本协议
        sbHttpHeader.append("HTTP/1.1").append(BLANK).append("200").append(BLANK).append("OK").append(CRLF);
        sbHttpHeader.append("Content-Type: text/html;charset=utf-8").append(CRLF);
        //正文长度 注意 是字节长度
        sbHttpHeader.append("Content-Length:").append(sbContext.toString().getBytes().length).append(CRLF);
        sbHttpHeader.append(CRLF);
        //正文
        sbHttpHeader.append(sbContext);

        //输出流
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
        bw.write(sbHttpHeader.toString());
        bw.flush();
        bw.close();
    }
}
