package SocketDemo.ChatRoom3;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server {

    private List<MyChannels> all = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        new Server().start();
    }

    public void start() throws IOException {
        ServerSocket server = new ServerSocket(9999);
        while (true) {
            Socket client = server.accept();
            MyChannels channel = new MyChannels(client);//这样写只能自己发给自己 所以需要使用容器管理
            all.add(channel);//统一分配到容器中
            Thread thread = new Thread(channel);
            thread.start();
        }
    }

    /**
     * 一个客户端一条管道
     */
    private class MyChannels implements Runnable {
        //向服务器输出 即 服务端输入流
        private DataInputStream dis;
        //服务端输出数据
        private DataOutputStream dos;
        private String clientName;
        private boolean isRunning = true;

        public MyChannels(Socket client) {
            try {
                dis = new DataInputStream(client.getInputStream());
                dos = new DataOutputStream(client.getOutputStream());
                this.clientName = dis.readUTF();
                System.out.println("欢迎进入聊天室" + this.clientName);
            } catch (IOException e) {
                isRunning = false;
                CloseUtile.close(dis, dos);
            }
        }

        @Override
        public void run() {
            while (isRunning) {
                String msg = revice();
                send(msg);
                //发送给其他客户端
                sendOthers(msg);
            }
        }

        private String revice() {
            String msg = null;
            try {
                msg = dis.readUTF();
                System.out.println(msg);
            } catch (IOException e) {
                isRunning = false;
                CloseUtile.close(dis, dos);
                all.remove(this);
            }
            return msg;
        }

        private void send(String msg) {
            try {
                dos.writeUTF("服务器响应---->" + msg);
                dos.flush();
            } catch (IOException e) {
                isRunning = false;
                CloseUtile.close(dis, dos);
                all.remove(this);
            }
        }

        private void sendOthers(String msg) {
            for (MyChannels other : all) {
                if (other == this) {
                    continue;
                }
                other.send(msg);
            }
        }

    }
}
