import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet (name = "pickColorServlet", urlPatterns = "/pickcolor")
public class pickColorServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/pickcolor.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String color = req.getParameter("color");

        if (color != null && !color.isEmpty()) {
            req.setAttribute("color", color);
            req.getRequestDispatcher("/colorchoice.jsp").forward(req, resp);
        } else {
            req.setAttribute("error", "Not a valid color.");
            req.getRequestDispatcher("/pickcolor.jsp").forward(req, resp);
        }

    }
}
