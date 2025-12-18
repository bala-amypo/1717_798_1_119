// package com.example.demo.servlet;

// import jakarta.servlet.annotation.WebServlet;
// import jakarta.servlet.http.HttpServlet;
// import jakarta.servlet.http.HttpServletRequest;
// import jakarta.servlet.http.HttpServletResponse;
// import java.io.IOException;
// import java.io.PrintWriter;

// @WebServlet(urlPatterns = "/status")
// public class SimpleStatusServlet extends HttpServlet {
    
//     @Override
//     protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
//         resp.setContentType("text/plain");
//         resp.setStatus(200);
        
//         PrintWriter out = resp.getWriter();
//         out.print("Servlet Running!");
//         out.flush();
//     }
// }