package IODemo.IOExampleTest;

import java.io.DataInputStream;
import java.io.IOException;

/**
 * 字节流
 */
public class Demo01 {
    public static void main(String[] args) throws IOException {
        DataInputStream is = new DataInputStream(System.in);
        int len = 0;
        byte[] flush = new byte[1024];
        while (-1 != (len = is.read(flush))) {
            System.out.println(new String(flush));
        }

    }
}
