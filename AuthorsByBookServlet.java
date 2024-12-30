package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/AuthorsByBookServlet")
public class AuthorsByBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    // Database credentials
    private static final String DB_URL = "jdbc:mysql://localhost:3306/library";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "password";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String bookTitle = request.getParameter("bookTitle");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        if (bookTitle == null || bookTitle.trim().isEmpty()) {
            out.println("<p style='color: red;'>Book title cannot be empty.</p>");
            return;
        }

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            // Connect to the database
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            // Query to fetch authors by book title
            String query = "SELECT a.author_name FROM authors a " +
                           "JOIN book_authors ba ON a.author_id = ba.author_id " +
                           "JOIN books b ON ba.book_id = b.book_id " +
                           "WHERE b.title = ?";
            stmt = conn.prepareStatement(query);
            stmt.setString(1, bookTitle);
            rs = stmt.executeQuery();

            // Display the results
            out.println("<h2>Authors for Book: " + bookTitle + "</h2>");
            if (rs.isBeforeFirst()) {
                out.println("<table border='1' cellpadding='5'><tr><th>Author Name</th></tr>");
                while (rs.next()) {
                    out.println("<tr><td>" + rs.getString("author_name") + "</td></tr>");
                }
                out.println("</table>");
            } else {
                out.println("<p style='color: red;'>No authors found for the given book title.</p>");
            }
        } catch (Exception e) {
            out.println("<p style='color: red;'>Error: " + e.getMessage() + "</p>");
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                out.println("<p style='color: red;'>Error closing resources: " + e.getMessage() + "</p>");
            }
        }
    }
}

