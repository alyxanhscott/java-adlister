import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Random;

@WebServlet(name = "guessServlet", urlPatterns = "/guess")
public class guessServlet extends HttpServlet {

    protected Random rand = new Random();
    protected int randNum = rand.nextInt(100);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/guess.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String number = req.getParameter("number");

        if (Integer.parseInt(number) > randNum) {
            req.setAttribute("guess", "Guess Lower");
        } else if (Integer.parseInt(number) < randNum) {
            req.setAttribute("guess", "Guess Higher");
        } else {
            req.setAttribute("guess", "Correct!");
        }

        req.getRequestDispatcher("/result.jsp").forward(req, resp);
    }
}
