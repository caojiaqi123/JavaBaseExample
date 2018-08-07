package TestFile;

import java.io.File;
import java.io.IOException;

public class FileTest {
    public static void main(String[] args) {
        File f = new File("/Users/caojiaqi/Projects/书籍");

        if (f.isDirectory()) {
            System.out.println("是一个目录");
        }

        File mkFile = new File(f, "text.txt");
        try {
            mkFile.createNewFile();
            return;
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("1");

        }
        finally {
            System.out.println(3);
        }

    }

    static void printFile(File f) {
        System.out.printf(f.getName());
        if (f.isDirectory()) {
            File[] files = f.listFiles();
            for (File file : files) {
                printFile(file);
            }
        }
    }
}
