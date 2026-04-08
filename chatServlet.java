package com.chat;

import java.io.*;
import java.sql.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet("/ChatServlet")
public class chatServlet extends HttpServlet {

    // Save message to database
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
                          throws ServletException, IOException {

        String sender = request.getParameter("sender");
        String message = request.getParameter("message");

        try {
            Connection conn = DBConnection.getConnection();
            String sql = "INSERT INTO messages(sender, message) VALUES(?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, sender);
            ps.setString(2, message);
            ps.executeUpdate();
            response.sendRedirect("index.html");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Get all messages from database
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
                         throws ServletException, IOException {

        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        StringBuilder json = new StringBuilder("[");

        try {
            Connection conn = DBConnection.getConnection();
            String sql = "SELECT sender, message, sent_at FROM messages ORDER BY sent_at ASC";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            boolean first = true;
            while (rs.next()) {
                if (!first) json.append(",");
                json.append("{")
                    .append("\"sender\":\"").append(rs.getString("sender")).append("\",")
                    .append("\"message\":\"").append(rs.getString("message")).append("\",")
                    .append("\"time\":\"").append(rs.getString("sent_at")).append("\"")
                    .append("}");
                first = false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        json.append("]");
        out.print(json.toString());
    }
}