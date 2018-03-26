import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.*;
import javax.servlet.http.*;

@WebServlet (name = "HelloWorldServlet", urlPatterns = "/hello")
public class HelloWorldServlet extends HttpServlet {

    public int counter;

    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        String getName = req.getParameter("name");
        String reset = req.getParameter("reset");
        if (reset != null) {
            counter = 0;
        }
        if (getName == null) {
            res.getWriter().println("<h1>Hello, World!</h1>");
        } else {
            res.getWriter().printf("<h1>Hello, %s</h1>", getName);
        }
        counter++;
        res.getWriter().printf("<h1>%d</h1>", counter);

    }

}
