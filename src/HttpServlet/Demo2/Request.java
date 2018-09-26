package HttpServlet.Demo2;

import java.io.IOException;
import java.io.InputStream;
import java.net.URLDecoder;
import java.util.*;

/**
 * 请求
 */
public class Request {
    private String method;
    private String url;
    private Map<String, List<String>> params;

    private InputStream is;
    private final String CRLF = "\r\n";
    private final String BLANK = " ";

    private String requestInfo;

    public Request() {
        method = "";
        url = "";
        params = new HashMap<>();
        requestInfo = "";
    }

    public Request(InputStream is) {
        this();
        this.is = is;
        byte[] bytes = new byte[20480];
        try {
            int len = is.read(bytes);
            requestInfo = new String(bytes, 0, len);
        } catch (IOException e) {

        }
        parseRequestInfo();
    }

    /**
     * @description 分析请求信息
     * @params
     */
    private void parseRequestInfo() {
        if (requestInfo == null || requestInfo.trim().equals("")) {
            return;
        }

        String paramStr = "";
        //第一行
        String firstLine = requestInfo.substring(0, requestInfo.indexOf(CRLF));
        int indexofFirstSe = firstLine.indexOf("/");
        this.method = firstLine.substring(0, indexofFirstSe).trim();
        String strUrl = firstLine.substring(indexofFirstSe, firstLine.indexOf("HTTP/"));
        if (this.method.equalsIgnoreCase("post")) {
            this.url = strUrl;
            paramStr = requestInfo.substring(requestInfo.lastIndexOf(CRLF)).trim();
        } else {
            if (strUrl.contains("?")) {
                String[] urlArry = strUrl.split("\\?");
                this.url = urlArry[0];
                paramStr = urlArry[1];
            } else {
                this.url = strUrl;
            }
        }
        if (paramStr != "") {
            parseParam(paramStr);
        }

    }

    private void parseParam(String paramStr) {
        StringTokenizer token = new StringTokenizer(paramStr, "&");
        while (token.hasMoreTokens()) {
            String keyValue = token.nextToken();
            String[] keyValArr = keyValue.split("=");
            if (keyValArr.length == 1) {
                keyValArr = Arrays.copyOf(keyValArr, 2);
                keyValArr[1] = null;
            }
            String key = keyValArr[0];
            String value = keyValArr[1] == null ? null : keyValArr[1].trim();

            if (!params.containsKey(keyValArr[0].trim())) {
                params.put(key, new ArrayList<>());
            }
            params.get(key).add(value);
        }
    }

    public String getParamter(String key) {
        String[] values = getParamters(key);
        if (values == null) {
            return null;
        } else {
            return URLDecoder.decode(values[0]);
        }
    }

    public String[] getParamters(String key) {
        List<String> values = params.get(key);
        if (values == null) {
            return null;
        } else {
            return values.toArray(new String[0]);
        }
    }

    public String getUrl() {
        return url.trim();
    }

}
