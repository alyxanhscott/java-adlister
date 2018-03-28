import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Random;
//annotation allows us to define this class as a servlet
@WebServlet(name = "guessServlet", urlPatterns = "/guess")
//the above urlPatterns tell servlet what to look for from the jsp(s)
public class guessServlet extends HttpServlet {

    protected Random rand = new Random();
    protected int randNum = rand.nextInt(100);
//    random num generated and assigned outside the scope of the doPost method so there isnt a new random number
//    generated every time a post req. is made

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/guess.jsp").forward(req, resp);
    }
//    above doGet allows us to define the urlPattern in line 9 as just "/guess" vs. "/guess.jsp". this allows us to
//    hide the actual url pattern and type

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
//the below line will actually send the info back to the result jsp page, based on which parameter it falls under.
        req.getRequestDispatcher("/result.jsp").forward(req, resp);
    }
}
