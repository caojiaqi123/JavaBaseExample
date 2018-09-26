package HttpServlet.Demo2;

public class LoginServlet extends Servlet {
    @Override
    public void doGet(Request req, Response rep) {
        StringBuilder sbContext = new StringBuilder();
        sbContext.append("<html>\n<head><title>登录</title></head>\n<body>\n");
        sbContext.append("欢迎：").append(req.getParamter("uname")).append(" 回来");
        sbContext.append("正文\n<p>段落</p>\n</body>\n</html>");

        rep.print(sbContext.toString());
    }

    @Override
    public void doPost(Request req, Response rep) {

    }
}
