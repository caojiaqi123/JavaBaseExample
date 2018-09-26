package HttpServlet.Demo2;


import SocketDemo.ChatRoom2.CloseUtile;

import java.io.IOException;
import java.net.Socket;

public class Dispatcher implements Runnable {
    private Response rep;
    private Request req;
    private boolean stop;
    private Socket client;
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
        try {
            Servlet servlet = WebApp.getServlet(req.getUrl());
            if (null == servlet) {
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
