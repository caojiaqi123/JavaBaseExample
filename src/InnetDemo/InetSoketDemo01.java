package InnetDemo;

import java.net.InetAddress;
import java.net.InetSocketAddress;

public class InetSoketDemo01 {
    public static void main(String[] args) {
        InetSocketAddress soketadd = new InetSocketAddress("localhost", 8081);
        System.out.println(soketadd.getHostName());
        System.out.println(soketadd.getPort());

        InetAddress addr4 = soketadd.getAddress();

        System.out.println(addr4.getHostAddress());//返回ip
        System.out.println(addr4.getHostName());//返回主机名
    }
}
