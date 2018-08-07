package IODemo.ByteIO;

import java.io.*;

/**
 * 文件拷贝
 */
public class Demo03 {
    public static void main(String[] args) throws IOException {
//        File src = new File("/Users/caojiaqi/Projects/JavaProjects/JavaData/test/1.txt");
//        File des = new File("/Users/caojiaqi/Projects/JavaProjects/JavaData/test/copy.txt");
//        FileUtil.copyFile(src, des);
        copyDir();
    }

    static void copyDir() throws IOException {
        String srcPath = "/Users/caojiaqi/Projects/JavaProjects/JavaData/test/parent";
        String descPath = ("/Users/caojiaqi/Projects/JavaProjects/JavaData/test/copy");

        File src = new File(srcPath);
        File des = new File(descPath);
        if (src.isDirectory()) {
            des = new File(des, src.getName());
        }
        copyDirDetail(src, des);
    }

    private static void copyDirDetail(File src, File des) throws IOException {
        if (src.isFile()) {
            FileUtil.copyFile(src, des);
        } else if (src.isDirectory()) {
            des.mkdirs();
            for (File file : src.listFiles()) {
                copyDirDetail(file, new File(des, file.getName()));
            }

        }
    }
}
