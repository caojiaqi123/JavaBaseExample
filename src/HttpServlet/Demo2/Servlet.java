package HttpServlet.Demo2;

public abstract class Servlet {

    public void service(Request req, Response rep) throws Exception {
        doGet(req, rep);

        doPost(req, rep);
    }

    public abstract void doGet(Request req, Response rep) throws Exception;

    public abstract void doPost(Request req, Response rep) throws Exception;
}
