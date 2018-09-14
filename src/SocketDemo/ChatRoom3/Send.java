package SocketDemo.ChatRoom3;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Send implements Runnable {
    //输入流
    private BufferedReader console;
    //管道输出流
    private DataOutputStream dos;
    private Socket client;
    private String clientNme;
    //控制标示
    private boolean isRunning = true;

    public Send() {
        console = new BufferedReader(new InputStreamReader(System.in));
    }

    public Send(Socket client, String name) {
        this();
        this.client = client;
        this.clientNme = name;
        try {
            dos = new DataOutputStream(client.getOutputStream());
            send(this.clientNme);
        } catch (IOException e) {
            //  e.printStackTrace();
            isRunning = false;
            CloseUtile.close(dos, console);
        }
    }

    @Override
    public void run() {
        while (isRunning) {
            try {
                String msg = console.readLine();
                send(msg);
            } catch (IOException e) {
                isRunning = false;
                CloseUtile.close(dos, console);
            }
        }
    }

    private void send(String msg) throws IOException {
        if (null != msg && !msg.equals("")) {
            dos.writeUTF(msg);
            dos.flush();
        }
    }
}
