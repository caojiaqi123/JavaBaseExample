package IODemo.PrintStream;

import java.io.*;

/**
 * printstream 打印流
 */
public class Demo01 {
    public static void main(String[] args) {
        System.out.println("");



        //输出到文件
        File dest = new File("");
        try (PrintStream ps = new PrintStream(new BufferedOutputStream(new FileOutputStream(dest)))) {
            ps.println("io is so easy");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
