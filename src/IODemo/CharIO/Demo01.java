package IODemo.CharIO;

import java.io.File;

import java.io.FileReader;
import java.io.IOException;

/**
 * filereader 只能读取文本文件之类
 */
public class Demo01 {
    public static void main(String[] args) throws IOException {
        File file = new File("/Users/caojiaqi/Projects/JavaProjects/JavaData/test/2.txt");
        FileReader fileReader = new FileReader(file);
        int len = 0;
        char[] flush = new char[1024];
        while (-1 != (len = fileReader.read(flush))) {
            String str = new String(flush, 0, len);
            System.out.println(str);
        }

        fileReader.close();
    }
}
