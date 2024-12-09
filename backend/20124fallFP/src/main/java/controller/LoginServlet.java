package controller;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.ServletException;

import java.io.PrintWriter;
import java.io.IOException;

/**
 * A simple servlet to verify connection between frontend and backend.
 */
//@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Set response content type to JSON
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");

        // Respond with a fixed JSON response
        PrintWriter out = resp.getWriter();
        out.print("{\"status\": \"success\", \"message\": \"Connected to backend successfully!\"}");
        out.flush();
    }
}
