package SelefTestDemo.HttpServletDemo;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    //服务端
    private ServerSocket server;

    public static void main(String[] args) throws IOException {
        new Server().start();
    }

    //启动服务
    private void start() throws IOException {
        server = new ServerSocket(8889);
        receive();
    }

    private void receive() throws IOException {
        Socket client = server.accept();//等待客户端返回

        //requstt可以获得一些参数
        Request request = new Request(client.getInputStream());
        //System.out.println(request.getParam("uname"));
    }

    /**
     * 读取浏览器请求的报文 原始的 现在封装成request类
     */
    private void request(Socket client) throws IOException {
        byte[] date = new byte[20480];
        int length = client.getInputStream().read(date);//接受服务端的报文
        //BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is));
        String context = new String(date, 0, length);
        System.out.println(context);
    }
}
