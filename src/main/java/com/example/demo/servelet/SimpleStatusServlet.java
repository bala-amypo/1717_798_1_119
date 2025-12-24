package com.example.demo.servlet;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/status")
public class SimpleStatusServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        try {
            resp.setStatus(200);
            resp.getWriter().write("Servlet Running");
        } catch (Exception ignored) {}
    }
}
