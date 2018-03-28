import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet (name = "NameServlet", urlPatterns = "/name")
public class NameServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/NamePage.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("name");

        if (name != null && !name.isEmpty()) {
            req.setAttribute("name", name);
            req.getRequestDispatcher("/nameHowdy.jsp").forward(req, resp);
        } else {
            req.setAttribute("error", "There was an issue with your name.");
            req.getRequestDispatcher("/NamePage.jsp").forward(req, resp);
        }
    }
}
