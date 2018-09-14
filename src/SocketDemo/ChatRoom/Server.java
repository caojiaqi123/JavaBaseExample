package SocketDemo.ChatRoom;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(9999);
        Socket client = server.accept();

        //向服务器输出 即 服务端输入流
        DataInputStream dis = new DataInputStream(client.getInputStream());
        String msg = dis.readUTF();
        System.out.println("服务器已收到，" + msg);

        DataOutputStream dos = new DataOutputStream(client.getOutputStream());
        dos.writeUTF("服务器---->" + msg);
        dos.flush();

    }
}
