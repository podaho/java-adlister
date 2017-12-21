import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "ViewProfileServlet", urlPatterns = "/profile")
public class ViewProfileServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if(session.getAttribute("user") != null) {
            if(session.getAttribute("user").equals("admin")) {
                request.setAttribute("loggedIn","true");
                request.setAttribute("user", session.getAttribute("user"));
                request.getRequestDispatcher("/profile.jsp").forward(request, response);
                return;
            }
        }
        response.sendRedirect("/login");
    }
}
