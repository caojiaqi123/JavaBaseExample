package IODemo.SelfTest;

import java.io.*;

/**
 *fileinputstream
 * */
public class Demo01 {
    public static void main(String[] args) throws IOException {
      //  InputStream is = new FileInputStream(new File("E:\\1.书籍\\Code\\JavaBaseExample\\Files\\2.html"));
       // 改造下使用 处理流
        BufferedInputStream is = new BufferedInputStream(new FileInputStream(new File("E:\\1.书籍\\Code\\JavaBaseExample\\Files\\2.html")));
        byte[] data = new byte[1024];
        int length = 0;
        while (-1 != (length = is.read(data))) {
            System.out.println(new String(data, 0, length));
        }
        is.close();
    }
}
