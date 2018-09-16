package HttpServlet;

import SocketDemo.ChatRoom2.CloseUtile;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

/**
 * 封装响应信息 构建响应头
 */
public class Response {
    private final String CRLF = "\r\n";
    private final String BLANK = " ";
    //存储头信息
    private StringBuilder headerInfo;
    private StringBuilder content;
    private int Length = 0;

    private BufferedWriter bw;

    public Response() {
        headerInfo = new StringBuilder();
        content = new StringBuilder();
        Length = 0;
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
            headerInfo = null;
        }
    }

    private void createHeadInfo(int code) {
        if (headerInfo == null) {
            code = 500;
        }

        headerInfo.append("HTTP/1.1").append(BLANK).append(code).append(BLANK);
        switch (code) {
            case 200:
                headerInfo.append("OK");
                break;
            case 404:
                headerInfo.append("NOT FOUND");
                break;
            case 500:
                headerInfo.append("SERVER ERROR");
                break;
        }

        headerInfo.append(CRLF);
        headerInfo.append("Content-Type: text/html;charset=utf-8").append(CRLF);
        //正文长度 注意 是字节长度
        headerInfo.append("Content-Length:").append(Length).append(CRLF);
        headerInfo.append(CRLF);
    }

    public Response print(String info) {
        // content = new StringBuilder();
        content.append(info);
        Length += info.getBytes().length;
        return this;
    }

    public void pushToClient(int code) throws IOException {
        createHeadInfo(code);
        //头信息
        bw.write(headerInfo.toString());
        //正文
        bw.write(content.toString());

        bw.flush();

        CloseUtile.close(bw);
    }


}
