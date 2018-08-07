package IODemo.IOFile;

import java.io.File;
import java.io.FilenameFilter;

/***
 * mkdir():父路径必须存在
 * mkdirs():父目录不存在 一同创建
 * */
public class Demo04 {
    public static void main(String[] args) {
        File file = new File("/Users/caojiaqi/Projects/JavaProjects/JavaData/parent/test/");
        mkdirs(file);

        File file2 = new File("/Users/caojiaqi/Projects/JavaProjects/JavaData/test/");
        if (file2.isDirectory()) {
            String[] list = file2.list();
            for (String s : list) {
                System.out.println(s);
            }

            System.out.println("子目录自文件");
            File[] files = file2.listFiles();
            for (File file1 : files) {
                System.out.println(file1.getAbsolutePath());
            }

            System.out.println("子目录自文件 .txt文件");
            File[] files2 = file2.listFiles(new FilenameFilter() {
                @Override
                public boolean accept(File dir, String name) {

                    return name.endsWith(".txt") && new File(dir, name).isFile();
                }
            });
            for (File file1 : files2) {
                System.out.println(file1.getAbsolutePath());
            }
        }
    }

    private static void mkdirs(File file) {
        boolean mkdir = file.mkdirs();
        System.out.println(mkdir);
    }
}
