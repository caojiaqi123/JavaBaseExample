package IODemo.IOFile;

import java.io.File;

/**
 * 相对路径
 * */
public class Demo02 {
    public static void main(String[] args) {
        relativePath();

        System.out.println("绝对路径");
        //全路径
        File file = new File("/Users/caojiaqi/Projects/JavaProjects/JavaData/test.txt");
        System.out.println(file.getName());
        System.out.println(file.getPath());
        //只有文件名 回已当前路径来创建
        System.out.println("只有文件名");
        file = new File("test2.txt");

        System.out.println(file.getName());
        System.out.println(file.getPath());
        System.out.println(file.getAbsolutePath());
    }

    private static void relativePath() {
        String parentPath="/Users/caojiaqi/Projects/JavaProjects/JavaData";
        String name ="test.txt";
        File file = new File(parentPath, name);
        file = new File(new File(parentPath),name);

        System.out.println(file.getName());
        System.out.println(file.getPath());
    }
}
