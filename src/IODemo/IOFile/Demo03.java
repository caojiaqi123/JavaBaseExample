package IODemo.IOFile;

import java.io.File;
import java.io.IOException;

/**
 * 常用的方法
 */
public class Demo03 {
    public static void main(String[] args) {
        File file = new File("/Users/caojiaqi/Projects/JavaProjects/JavaData/test/1.txt");

        Test2(file);
        System.out.println("---- 下面时文件夹-------");
        File file2 = new File("/Users/caojiaqi/Projects/JavaProjects/JavaData/test");
        Test2(file2);

        System.out.println("---- 相对-------");
        File file3 = new File("2.test");
        Test2(file3);

        mdFile(file);

        System.out.println("创建临时文件");
        mdTempFile();


    }

    private static void Test2(File file) {
        System.out.println("是否是件夹：" + file.isDirectory());

        System.out.println("文件是否存在：" + file.exists());

        System.out.println("是否可写：" + file.canRead());

        System.out.println("是否是绝对路径" + file.isAbsolute());
        System.out.println("是否是文件" + file.isFile());

        System.out.println("长度" + file.length());
    }

    public static void mdFile(File file) {
        System.out.println("创建文件------");
        if (file.exists()) {
            try {
                System.out.println("是否创建成功" + file.createNewFile());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    static void mdTempFile(){
        try {
            File.createTempFile("temp",".txt",new File("/Users/caojiaqi/Projects/JavaProjects/JavaData/test"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
