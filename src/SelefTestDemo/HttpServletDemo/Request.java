package SelefTestDemo.HttpServletDemo;

import java.io.IOException;
import java.io.InputStream;
import java.net.URLDecoder;
import java.util.*;

/**
 * @Descriptio:读取客户端的请求报文 报文格式
 * <p>
 * GET / HTTP/1.1
 * Host: localhost:8889
 * Connection: keep-alive
 * Upgrade-Insecure-Requests: 1
 * User-Agent: Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/69.0.3497.100 Safari/537.36
 * Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,
 * Accept-Encoding:gzip,deflate,br
 * Accept-Language:zh-CN,zh;q=0.9
 * @Date: 2018/9/27 14:20
 **/
public class Request {
    //空格
    private final String BLANK = " ";
    //回车换号
    private final String CRLF = "\r\n";
    //请求来源url
    private String url;
    //请求参数
    private Map<String, List<String>> param;
    //请求方法 只考虑post get
    private String method;
    private String requestInfo;

    public Request() {
        url = "";
        method = "";
        requestInfo = "";
        param = new HashMap<>();
    }

    public Request(InputStream is) {
        this();
        byte[] date = new byte[20480];
        try {
            int length = is.read(date);
            //读取客户端响应请求
            requestInfo = new String(date, 0, length);
        } catch (IOException e) {

        }
        parseRequestInfo();
    }

    //分解报文
    private void parseRequestInfo() {
        if (requestInfo.trim().equals("") || requestInfo == null) {
            return;
        }
        String paramStr = "";
        //第一行
        String firstLine = requestInfo.substring(0, requestInfo.indexOf(CRLF));
        int firstSlash = firstLine.indexOf("/");//第一个斜杠
        method = firstLine.substring(0, firstSlash).trim();
        //url里面可能有参数 也可能参数在body里面
        String urlStr = firstLine.substring(firstSlash, firstLine.indexOf("HTTP/"));
        if (method.equalsIgnoreCase("post")) {
            this.url = urlStr;
            paramStr = requestInfo.substring(requestInfo.lastIndexOf(CRLF)).trim();
        } else {
            if (urlStr.contains("?")) {
                String[] urlArry = urlStr.split("\\?");
                this.url = urlArry[0];
                paramStr = urlArry[1];
            } else {
                this.url = urlStr;
            }
        }
        if (!paramStr.trim().equals("")) {
            parseParam(paramStr);
        }
    }

    //准备参数
    private void parseParam(String paramStr) {
        StringTokenizer tokenizer = new StringTokenizer(paramStr, "&");
        while (tokenizer.hasMoreTokens()) {
            String keyValueStr = tokenizer.nextToken();
            String[] keyValueArray = keyValueStr.split("=");
            if (keyValueArray.length == 1) {
                keyValueArray = Arrays.copyOf(keyValueArray, 2);//如果只有个参数 则将元数组扩容 如&param1
            }
            String key = keyValueArray[0];
            String value = keyValueArray[1] == null ? null : keyValueArray[1];
            if (!param.containsKey(key)) {
                param.put(key, new ArrayList<>());
            }
            param.get(key).add(value);
        }
    }

    public String[] getParams(String key) {
        List<String> params = param.get(key);
        if (param.containsKey(key)) {
            return params.toArray(new String[0]);
        }
        return null;
    }

    //中文的时候会有点问题 所以需要url decode
    public String getParam(String key) {
        String[] params = getParams(key);
        if (params.length > 0) {
            return URLDecoder.decode(params[0]);
        }
        return null;
    }

    public String getUrl() {
        return url.trim();
    }
}
