package HttpServlet;

import SocketDemo.ChatRoom2.CloseUtile;

import java.io.IOException;
import java.net.Socket;

public class Dispatcher implements Runnable {
    private Response rep;
    private Request req;
    private boolean stop;
    private Socket client;
    private int code =200;

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
            rep.pushToClient(code);
        } catch (IOException e) {

        }
        CloseUtile.close(client);
    }
}
