package IODemo.BufferedIO;

import java.io.*;
/**
 * 节点流 外面包装缓冲流
 * */
public class Demo01 {
    public static void main(String[] args) throws IOException {


        File src = new File("");
        File des = new File("");
        InputStream is = new BufferedInputStream(new FileInputStream(src));
        OutputStream os = new BufferedOutputStream(new FileOutputStream(des));
        byte[] inByte = new byte[1024];
        int len = 0;
        while (-1 != (len = is.read(inByte))) {
            os.write(inByte, 0, len);
        }
        os.flush();

        os.close();
        is.close();


        try(InputStream tes2t = new FileInputStream("")){

        }
    }
}
