package SocketDemo.ChatRoom2;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * 用于接受数据
 */
public class Receive implements Runnable {
    private DataInputStream dis;
    private boolean isRunning = true;

    public Receive() {
    }

    public Receive(Socket client) {
        try {

            dis = new DataInputStream(new BufferedInputStream(client.getInputStream()));
        } catch (IOException e) {
            isRunning = false;
            CloseUtile.close(dis);
        }
    }

    @Override
    public void run() {
        while (isRunning) {
            String msg = getMsg();
            System.out.println("客户端读取数据----->" + msg);
        }
    }

    private String getMsg() {
        String msg = null;
        if (dis != null) {
            try {
                msg = dis.readUTF();
            } catch (IOException e) {
                isRunning = false;
                CloseUtile.close(dis);
            }
        }
        return msg;
    }
}
