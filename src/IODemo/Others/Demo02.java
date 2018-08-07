package IODemo.Others;

import java.io.*;

/**
 * 文件->程序->字节数据
 */
public class Demo02 {
    public static void main(String[] args) throws IOException {
        String sourcePath = "/Users/caojiaqi/Projects/JavaProjects/JavaData/test/1.txt";
        String destPath = "/Users/caojiaqi/Projects/JavaProjects/JavaData/test/bytearray.txt";
        byte[] byteFromFile = getByteFromFile(sourcePath);
        writeByteToFile(byteFromFile, destPath);

    }

    //从文件读取流 转化成字节数组输出
    private static byte[] getByteFromFile(String path) throws IOException {
        byte[] dest;

        InputStream fileInputStream = new BufferedInputStream(new FileInputStream(new File(path)));

        ByteArrayOutputStream os = new ByteArrayOutputStream();
        byte[] bytes = new byte[1024];
        int length = 0;
        while (-1 != (length = fileInputStream.read(bytes))) {
            os.write(bytes, 0, length);
        }

        dest = os.toByteArray();

        os.close();
        fileInputStream.close();

        return dest;
    }

    private static void writeByteToFile(byte[] inBytes, String path) throws IOException {
        OutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(new File(path)));

        InputStream inputStream = new BufferedInputStream(new ByteArrayInputStream(inBytes));
        byte[] bytes = new byte[1024];
        int len = 0;
        while (-1 != (len = inputStream.read(bytes))) {
            bufferedOutputStream.write(bytes, 0, len);
        }

        inputStream.close();
        bufferedOutputStream.close();
    }
}
