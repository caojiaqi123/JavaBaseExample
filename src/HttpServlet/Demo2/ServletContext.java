package HttpServlet.Demo2;

import java.util.HashMap;
import java.util.Map;

public class ServletContext {
    //为每一个servlet定义一个别名
    //login -> loginServlet

    private Map<String,Servlet> servlet ;
    //存储URL 每个URL对应一个
    //url -> login
    private Map<String,String> mapping;

    public Map<String, Servlet> getServlet() {
        return servlet;
    }

    public void setServlet(Map<String, Servlet> servlet) {
        this.servlet = servlet;
    }

    public Map<String, String> getMapping() {
        return mapping;
    }

    public void setMapping(Map<String, String> mapping) {
        this.mapping = mapping;
    }

    public ServletContext() {
        servlet = new HashMap<>();
        mapping = new HashMap<>();
    }
}
