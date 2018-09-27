package SelefTestDemo.HttpServletDemo;

import SocketDemo.ChatRoom2.CloseUtile;

import java.io.IOException;
import java.net.Socket;

/**
 * @Descriptio: 用于分发请求
 * @retrn: a
 * @Date: 2018/9/27 16:49
 **/
public class Dispatcher implements Runnable {

    //客户端
    private Socket client;
    //响应
    private Response rep;
    private Request req;

    private int code = 200;

    public Dispatcher(Socket client) {
        this.client = client;
        try {
            rep = new Response(client.getOutputStream());
            req = new Request(client.getInputStream());
        } catch (IOException e) {
            return;
        }
    }

    @Override
    public void run() {
        Servlet servlet = new Servlet();
        try {
            servlet.service(req, rep);
            rep.pushToClient(200);
        } catch (IOException e) {

        }
        CloseUtile.close(client);
    }
}
