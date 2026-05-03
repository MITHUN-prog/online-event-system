package com.example.cookies;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PreferenceServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String theme = request.getParameter("theme");
        String language = request.getParameter("language");

        Cookie themeCookie = new Cookie("theme", theme);
        Cookie languageCookie = new Cookie("language", language);

        themeCookie.setMaxAge(24 * 60 * 60);
        languageCookie.setMaxAge(24 * 60 * 60);

        response.addCookie(themeCookie);
        response.addCookie(languageCookie);

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<h2>Preferences Saved Successfully!</h2>");
        out.println("<a href='preferences'>View Preferences</a>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String theme = "Not Set";
        String language = "Not Set";

        Cookie[] cookies = request.getCookies();

        if (cookies != null) {
            for (Cookie c : cookies) {
                if (c.getName().equals("theme")) {
                    theme = c.getValue();
                }
                if (c.getName().equals("language")) {
                    language = c.getValue();
                }
            }
        }

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<h2>Your Saved Preferences</h2>");
        out.println("Theme: " + theme + "<br>");
        out.println("Language: " + language + "<br><br>");
        out.println("<a href='preferences.html'>Change Preferences</a>");
    }
}
