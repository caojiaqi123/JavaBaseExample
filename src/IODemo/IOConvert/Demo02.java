package IODemo.IOConvert;

import java.io.*;

/**
 * 字节转化流
 * InputStreamReader:解码
 * OutputStreamWriter
 */
public class Demo02 {
    public static void main(String[] args) throws IOException {

        File src = new File("/Users/caojiaqi/Projects/JavaProjects/JavaData/test/1.txt");
        File desc = new File("/Users/caojiaqi/Projects/JavaProjects/JavaData/test/aa.txt");
        // 这边有问题 因为你不知道底层文件使用什么编码方式 所以应该使用字节流读取
        //但是自字节流无法直接给reader 所以读取的时候用节点流，外面包装转换流

        BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(new FileInputStream(src), "utf-8")
        );


        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(desc), "utf-8"));

        String info = null;
        //读取字符串 按行
        while ((info = bufferedReader.readLine()) != null) {
            System.out.println(info);
            writer.write(info);
            writer.newLine();
        }

        writer.close();
        bufferedReader.close();
    }
}
