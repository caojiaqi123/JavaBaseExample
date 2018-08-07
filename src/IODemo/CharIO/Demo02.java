package IODemo.CharIO;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Demo02 {
    public static void main(String[] args) throws IOException {
        File file = new File("/Users/caojiaqi/Projects/JavaProjects/JavaData/test/3.txt");

        FileWriter fileWriter = new FileWriter(file);
        String msg = "这是一个测试 成都市vds s \r \n";
        fileWriter.write(msg);
        fileWriter.flush();
        fileWriter.close();
    }
}
