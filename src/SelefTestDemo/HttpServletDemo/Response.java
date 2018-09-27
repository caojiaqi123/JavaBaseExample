package SelefTestDemo.HttpServletDemo;

import SocketDemo.ChatRoom3.CloseUtile;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

/**
 * @Descriptio: 返回http请求报文 格式类似request
 * 这个类主要是拼接 http报文 主要包括 头信息 和 html代码
 * 头信息包括 httpmethod 协议 状态码 报文长度 等
 * HTTP/1.1 200 OK
 * Content-Type: text/html; charset=utf-8
 * Content-Length: 74
 * @retrn: a
 * @Date: 2018/9/27 15:44
 **/
public class Response {
    //空格
    private final String BLANK = " ";
    //回车换号
    private final String CRLF = "\r\n";

    private StringBuilder headInfo;
    private StringBuilder contextInfo;
    private int LENGTH;

    //输出字符缓冲流
    private BufferedWriter bw;

    public Response() {
        headInfo = new StringBuilder();
        contextInfo = new StringBuilder();
        LENGTH = 0;
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
            headInfo = null;
        }
    }

    private void createHeadInfo(int statusCode) {
        if (headInfo == null) {
            statusCode = 500;
        }
        headInfo.append("HTTP/1.1").append(BLANK).append(statusCode).append(BLANK);
        switch (statusCode) {
            case 200:
                headInfo.append("OK");
                break;
            case 404:
                headInfo.append("NOT FOUND");
                break;
            case 500:
                headInfo.append("SERVER ERRORS");
                break;
        }
        headInfo.append(CRLF);
        headInfo.append("Content-Type: text/html; charset=utf-8").append(CRLF);
        headInfo.append("Content-Length:").append(CRLF).append(LENGTH).append(CRLF);
        headInfo.append(CRLF);
    }

    //将需要输出的信息放入context
    public Response print(String context) {
        contextInfo.append(context);
        LENGTH += context.getBytes().length;
        return this;
    }

    public void pushToClient(int code) throws IOException {
        createHeadInfo(code);
        //写入报文头
        bw.write(headInfo.toString());

        //写入html代码
        bw.write(contextInfo.toString());
        bw.flush();
        CloseUtile.close(bw);
    }
}

