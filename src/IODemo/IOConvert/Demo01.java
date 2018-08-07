package IODemo.IOConvert;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

public class Demo01 {
    public static void main(String[] args) throws UnsupportedEncodingException {
        test1();


    }

    /**
     *
     * 解码编码方法不一样
     * */
    private static void test1() throws UnsupportedEncodingException {
        //解码
        String str = "中国";
        //编码 字符转字节
        byte[] bytes = str.getBytes();
        //解码
        System.out.println(new String(bytes));

        bytes = str.getBytes("gbk");
        System.out.println(new String(bytes));

        bytes = str.getBytes("gbk");
        System.out.println(new String(bytes, "gbk"));
    }
}
