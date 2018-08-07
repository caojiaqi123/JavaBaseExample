package IODemo.ByteIO;

import java.io.*;

/**
 * 读取文件
 */
public class Demo01 {
    public static void main(String[] args) {
        File file = new File("/Users/caojiaqi/Projects/JavaProjects/JavaData/test/1.txt");

        //选择流
        InputStream fileInputStream = null;

        try {
            fileInputStream = new FileInputStream(file);

            //读取
            byte[] bytes = new byte[1024];
            int len = 0;//实际读取长度
            while (-1 != (len = fileInputStream.read(bytes))) {
                //输出 字节数组转为字符串
                String info = new String(bytes, 0, len);
                System.out.println(info);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}
