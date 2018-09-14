package SocketDemo;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Demo01 {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress addr4 = InetAddress.getLocalHost();

        System.out.println(addr4.getHostAddress());//返回ip
        System.out.println(addr4.getHostName());//返回主机名


        addr4 = InetAddress.getByName("www.163.com");
        System.out.println(addr4.getHostAddress());//返回ip
        System.out.println(addr4.getHostName());//返回主机名

        addr4 = InetAddress.getByName("61.135.253.15");
        System.out.println(addr4.getHostAddress());//返回ip
        System.out.println(addr4.getHostName());//返回主机名
    }
}
