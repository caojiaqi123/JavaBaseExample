package HttpServlet.Demo2;

import java.util.Map;

/**
 * 初始化 servletcontex
 */
public class WebApp {
    private static ServletContext context;

    static {
        context = new ServletContext();

        //添加对应到
        Map<String, String> mapping = context.getMapping();
        mapping.put("/login", "login");
        mapping.put("/log", "login");
        mapping.put("/register", "register");

        Map<String, Servlet> servlet = context.getServlet();
        servlet.put("login", new LoginServlet());
        servlet.put("register", new RegisterServlet());
    }

    //获取对应URL的servlet
    public static Servlet getServlet(String url) {
        if (url.equals("") || null == url) {
            return null;
        }

        return context.getServlet().get(context.getMapping().get(url));
    }
}
