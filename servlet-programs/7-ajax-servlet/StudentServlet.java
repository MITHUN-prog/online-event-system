package com.ajax;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/students")
public class StudentServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("application/json");

        PrintWriter out = response.getWriter();

        out.print("[");
        out.print("{\"id\":201,\"name\":\"Ravi\",\"dept\":\"AI\"},");
        out.print("{\"id\":202,\"name\":\"Sita\",\"dept\":\"DS\"},");
        out.print("{\"id\":203,\"name\":\"Kumar\",\"dept\":\"CSE\"}");
        out.print("]");
    }
}
