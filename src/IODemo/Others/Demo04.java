package IODemo.Others;

import java.io.*;

/**
 * 输入到字节数组
 */
public class Demo04 {
    public static void main(String[] args) throws IOException {
        byte[] ss = (write());

        read(ss);
    }

    static byte[] write() throws IOException {
        double point = 2.5;
        long number = 100l;
        String str = "数据类型";

        byte[] dest = null;

        ByteArrayOutputStream bos = new ByteArrayOutputStream();

        DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(bos));

        dos.writeDouble(point);
        dos.writeLong(number);
        dos.writeUTF(str);
        dos.flush();//需要刷新 否则拿不到数据

        dest = bos.toByteArray();


        bos.close();
        dos.close();

        return dest;
    }

    static void read(byte[] bytes) throws IOException {

        ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
        DataInputStream dis = new DataInputStream(new BufferedInputStream(bis));

        System.out.println(dis.readDouble());
        System.out.println(dis.readLong());
        System.out.println(dis.readUTF());

        dis.close();
        bis.close();
    }
}
