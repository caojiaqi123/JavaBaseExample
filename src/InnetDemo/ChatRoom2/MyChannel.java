package InnetDemo.ChatRoom2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class MyChannel implements Runnable {
    //向服务器输出 即 服务端输入流
    private DataInputStream dis;
    //服务端输出数据
    private DataOutputStream dos;
    private boolean isRunning = true;

    public MyChannel(Socket client) {

        try {
            dis = new DataInputStream(client.getInputStream());
            dos = new DataOutputStream(client.getOutputStream());
        } catch (IOException e) {
            isRunning = false;
            CloseUtile.close(dis, dos);
        }
    }

    @Override
    public void run() {
        while (isRunning) {
            doSomething();
        }
    }

    private void doSomething() {
        try {
            String msg = dis.readUTF();
            System.out.println("服务器已收到 " + msg);

            dos.writeUTF("服务器响应---->" + msg);
            dos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
