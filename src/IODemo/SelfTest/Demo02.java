package IODemo.SelfTest;

import java.io.*;

/**
 * fileoutputstream
 */
public class Demo02 {
    public static void main(String[] args) throws IOException {
        //FileOutputStream os = new FileOutputStream(new File("E:\\1.书籍\\Code\\JavaBaseExample\\Files\\IOSelfDemo\\Demo02"));
        OutputStream os = new BufferedOutputStream(new FileOutputStream(new File("E:\\1.书籍\\Code\\JavaBaseExample\\Files\\IOSelfDemo\\Demo02")));
        String osStr = "输出流测试 with节点流";
        os.write(osStr.getBytes());
        os.flush();
        os.close();
    }
}
