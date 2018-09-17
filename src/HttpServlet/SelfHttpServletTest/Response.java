package HttpServlet.SelfHttpServletTest;

import SocketDemo.ChatRoom2.CloseUtile;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class Response {
    private final String CRLF = "\r\n";
    private final String BLANK = " ";
    //输出流
    BufferedWriter bw;
    private StringBuilder header;
    private StringBuilder context;
    private int contextLength;

    private Response() {
        header = new StringBuilder();
        context = new StringBuilder();
        contextLength = 0;
    }

    public Response(OutputStream os) {
        this();
        bw = new BufferedWriter(new OutputStreamWriter(os));
    }

    public Response(Socket client) {
        this();
        try {
            bw = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
        } catch (IOException e) {
            header = null;
        }
    }

    /**
     * @Description 创建头
     * @retun: a
     * @Date: 2018/9/17 15:53
     **/
    private void createHeader(int code) {
        if (header == null) {
            code = 500;
        }

        header.append("HTTP/1.1").append(BLANK).append(code).append(BLANK);
        switch (code) {
            case 200:
                header.append("OK");
                break;
            case 404:
                header.append("NOT FOUND");
                break;
            case 500:
                header.append("SERVER ERROR");
                break;
        }
        header.append(CRLF);
        header.append("Content-Type: text/html;charset=utf-8").append(CRLF);
        header.append("Content-Length:").append(contextLength).append(CRLF);
        //换行
        header.append(CRLF);
    }

    /**
     * @Descriptio:
     * @retrn: a
     * @Date: 2018/9/17 16:02
     **/
    public Response appendContext(String info) {
        context.append(info);
        contextLength += info.getBytes().length;
        return this;
    }

    public void pushToClient(int code) throws IOException {
        createHeader(code);
        //写入头
        bw.write(header.toString());
        //写入body
        appendContext(context.toString());

        bw.write(context.toString());
        bw.flush();
        //关闭
        CloseUtile.close(bw);
    }
}
