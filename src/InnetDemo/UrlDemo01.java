package InnetDemo;

import java.net.MalformedURLException;
import java.net.URL;

public class UrlDemo01 {
    public static void main(String[] args) throws MalformedURLException {
        URL url = new URL("http://www.baidu.com:80/index.html#aa?user=cjq");
        System.out.println(url.getProtocol());
        System.out.println(url.getHost());
        System.out.println(url.getFile());//资源
        System.out.println(url.getPort());
        System.out.println(url.getPath());//相对路径
        System.out.println(url.getRef());//锚点
        System.out.println(url.getQuery());//存在锚点 返回null 不存在 返回正确
    }
}
