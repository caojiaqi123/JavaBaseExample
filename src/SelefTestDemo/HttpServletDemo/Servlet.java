package SelefTestDemo.HttpServletDemo;

public class Servlet {
    public void service(Request req, Response rep) {
        StringBuilder sbContext = new StringBuilder();
        sbContext.append("<html>\n<head><title>登录13</title></head>\n<body>\n");
        sbContext.append("欢迎：").append(req.getParam("uname")).append(" 回来");
        sbContext.append("正文\n<p>段落</p>\n</body>\n</html>");

        rep.print(sbContext.toString());
    }
}
