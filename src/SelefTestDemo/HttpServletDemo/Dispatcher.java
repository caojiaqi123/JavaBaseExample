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
        int code = 200;
        Servlet servlet = WebApp.getServlet(req.getUrl());
        try {
            if (servlet == null) {
                code = 404;
            } else {
                servlet.service(req, rep);
            }
        } catch (Exception e) {
            code = 500;
        }
        try {
            rep.pushToClient(code);
        } catch (IOException e) {

        }
        CloseUtile.close(client);
    }
}
