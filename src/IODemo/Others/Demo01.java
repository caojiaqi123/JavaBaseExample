package IODemo.Others;

import java.io.*;

/**
 * bytearray 节点流
 */
public class Demo01 {
    public static void main(String[] args) throws IOException {
        String msg = "这是一个测试";

        read(write(msg));

    }

    private static byte[] write(String msg) throws IOException {

        byte[] dest;
        //写出
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        os.write(msg.getBytes(), 0, msg.getBytes().length);

        dest = os.toByteArray();

        os.close();

        return dest;
    }

    private static void read(byte[] bytes) throws IOException {

        InputStream is = new BufferedInputStream(new ByteArrayInputStream(bytes));

        //操作
        byte[] flush = new byte[1024];
        int len = 0;
        while (-1 != (len = is.read(flush))) {
            System.out.println(new String(flush, 0, len));
        }

        is.close();
    }
}
