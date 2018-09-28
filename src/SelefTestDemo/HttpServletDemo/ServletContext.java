package SelefTestDemo.HttpServletDemo;

import java.util.HashMap;
import java.util.Map;

public class ServletContext {
    private Map<String, String> mapping;
    private Map<String, Servlet> servlets;

    public ServletContext() {
        mapping = new HashMap<>();
        servlets = new HashMap<>();
    }

    public Map<String, String> getMapping() {
        return mapping;
    }

    public void setMapping(Map<String, String> mapping) {
        this.mapping = mapping;
    }

    public Map<String, Servlet> getServlets() {
        return servlets;
    }

    public void setServlets(Map<String, Servlet> servlets) {
        this.servlets = servlets;
    }
}
