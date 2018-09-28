package SelefTestDemo.HttpServletDemo;

public class RegisterServlet extends Servlet {
    @Override
    public void doGet(Request req, Response rep) {

    }

    @Override
    public void doPost(Request req, Response rep) {
        StringBuilder sbContext = new StringBuilder();
        sbContext.append("<html>\n<head><title>注册</title></head>\n<body>\n");
        sbContext.append("你到用户名为：").append(req.getParam("uname"));
        sbContext.append("<p>注册成功</p>\n</body>\n</html>");

        rep.print(sbContext.toString());
    }
}
