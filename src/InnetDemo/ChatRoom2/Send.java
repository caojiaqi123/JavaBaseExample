package InnetDemo.ChatRoom2;

import com.sun.deploy.util.StringUtils;

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
    //控制标示
    private boolean isRunning = true;

    public Send() {
        console = new BufferedReader(new InputStreamReader(System.in));
    }

    public Send(Socket client) {
        this();
        this.client = client;
        try {
            dos = new DataOutputStream(client.getOutputStream());
        } catch (IOException e) {
            //  e.printStackTrace();
            isRunning = false;
            CloseUtile.close(dos, console);
        }
    }

    @Override
    public void run() {
        while (isRunning) {
            send();
        }
    }

    private void send() {
        String msg;
        try {
            msg = console.readLine();

            if (null != msg && !msg.equals("")) {
                dos.writeUTF(msg);
                dos.flush();
            }
        } catch (IOException e) {
            isRunning = false;
            CloseUtile.close(dos, console);
        }

    }
}
