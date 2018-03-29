import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AdServlet", urlPatterns = {"/ads", "/show"})
public class AdServlet extends HttpServlet {

    protected ListAdsDao listAdsDao = new ListAdsDao();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if ("/show".equals(request.getServletPath())) {
            String adId = request.getParameter("id");

            if(adId == null || adId.isEmpty()) {
                response.sendRedirect("/ads");
                return;
            }

            for (Ad ad : listAdsDao.all()) {
                if (Long.toString(ad.getId()).equals(adId)) {
                    request.setAttribute("ad", ad);
                    request.getRequestDispatcher("/ads/show.jsp").forward(request, response);
                    return;
                }
            }

            response.sendRedirect("/ads");
            return;
        }

        request.setAttribute("ads", listAdsDao.all());
        request.getRequestDispatcher("/ads/index.jsp").forward(request, response);
    }
}
