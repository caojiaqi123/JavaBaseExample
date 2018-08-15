package InnetDemo.TCP;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        //不同协议可以用同一个端口
        ServerSocket server = new ServerSocket(8888);
        //1. 接收客户端连接 阻塞式 浏览器里输入localhost:8888看看有啥结果
        Socket socket = server.accept();
        System.out.println("一个客户端建立连接");
        //2.发送数据 +接受数据
        String msg = "欢迎使用测试测试\r\n第二行";

//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
//        bw.write(msg);
//        bw.flush();

        //或者使用下面
        DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
        dos.writeUTF(msg);
        dos.flush();
    }
}
