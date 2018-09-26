package HttpServlet.Demo2;


public class RegisterServlet extends Servlet {
    @Override
    public void doGet(Request req, Response rep) throws Exception {

    }

    @Override
    public void doPost(Request req, Response rep) throws Exception {
        StringBuilder sbContext = new StringBuilder();
        sbContext.append("<html>\n<head><title>注册</title></head>\n<body>\n");
        sbContext.append("你到用户名为：").append(req.getParamter("uname"));
        sbContext.append("正文\n<p>段落</p>\n</body>\n</html>");

        rep.print(sbContext.toString());
    }
}
