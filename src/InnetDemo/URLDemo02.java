package InnetDemo;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

public class URLDemo02 {
    public static void main(String[] args) throws IOException {
        URL url = new URL("http://www.baiduc.com");
        InputStream is = url.openStream();
        /*
        byte[] flush = new byte[1024];
        int len = 0;
        while (-1 != (len = is.read(flush))) {
            System.out.println(new String(flush));
        }
        is.close();//有点问题 有乱码 需要使用字节转换流
        */

        //使用转换流
        //文件流输出到文件
        FileOutputStream fsOut = new FileOutputStream("/Users/caojiaqi/Projects/java git/javaBaseExample/test/UrlDir/baidu.html");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fsOut, "gb2312"));

        BufferedReader br = new BufferedReader(new InputStreamReader(is, "gb2312"));
        String msg = null;
        while (null != (msg = br.readLine())) {
            bw.append(msg);
            bw.newLine();

            System.out.println(msg);
        }
        bw.flush();
        bw.close();
        br.close();


    }
}
