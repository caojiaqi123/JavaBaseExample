package IODemo.ByteIO;

import java.io.*;

public class FileUtil {
    public static void copyFile(String srcPath, String descFile) throws IOException {
        File src = new File(srcPath);
        File des = new File(descFile);
        copyFile(src, des);
    }

    public static void copyFile(File src, File des) throws IOException {

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
    }
}
