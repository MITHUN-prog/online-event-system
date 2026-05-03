package log;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class WelcomeServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        if (session != null && session.getAttribute("user") != null) {
            String user = (String) session.getAttribute("user");

            out.println("<h2>Welcome, " + user + "</h2>");
            out.println("<a href='logout'>Logout</a>");
        } else {
            out.println("<h3>Session Expired. Please Login Again.</h3>");
            out.println("<a href='login.html'>Login</a>");
        }
    }
}
