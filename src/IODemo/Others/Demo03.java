package IODemo.Others;

import java.io.*;

/**
 * 数据类型(基本数据类型+String)处理流
 */
public class Demo03 {
    public static void main(String[] args) throws IOException {

        String path = "/Users/caojiaqi/Projects/JavaProjects/JavaData/test/other_demo03.txt";
        write(path);

        read(path);
    }

    /**
     * 保留了数据加类型 所以是电脑读取
     */
    static void write(String path) throws IOException {
        double point = 2.5;
        long number = 100l;
        String str = "数据类型";

        File dest = new File(path);
        DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(dest)));

        dos.writeDouble(point);
        dos.writeLong(number);
        dos.writeUTF(str);

        dos.flush();
        dos.close();
    }

    static void read(String path) throws IOException {
        File file = new File(path);
        DataInputStream dis = new DataInputStream(new BufferedInputStream(new FileInputStream(file)));
        System.out.println(dis.readDouble());
        System.out.println(dis.readLong());
        System.out.println(dis.readUTF());

        dis.close();

    }
}
