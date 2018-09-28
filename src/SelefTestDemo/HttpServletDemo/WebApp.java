package SelefTestDemo.HttpServletDemo;

import java.util.Map;

/**
 * 根据url创建不同的servlet
 */
public class WebApp {
    private static ServletContext servletContext;

    static {
        servletContext = new ServletContext();
        Map<String, String> mapping = servletContext.getMapping();
        mapping.put("/login", "login");
        mapping.put("/register", "register");

        Map<String, Servlet> servletMap = servletContext.getServlets();
        servletMap.put("login", new LoginServlet());
        servletMap.put("register", new RegisterServlet());
    }

    public static Servlet getServlet(String url) {
        if (url == null || url.trim().equals("")) {
            return null;
        }
        return servletContext.getServlets().get(servletContext.getMapping().get(url));
    }
}
