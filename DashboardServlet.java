package com.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.connection.DBConnection;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/Dashboard")
public class DashboardServlet extends HttpServlet {
	 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        try (Connection conn = DBConnection.getConnection()) {
	            // Fetch the number of books in the library
	            String bookCountQuery = "SELECT COUNT(*) AS total_books FROM books";
	            PreparedStatement bookCountStmt = conn.prepareStatement(bookCountQuery);
	            ResultSet bookCountRs = bookCountStmt.executeQuery();
	            int totalBooks = 0;
	            if (bookCountRs.next()) {
	                totalBooks = bookCountRs.getInt("total_books");
	            }
	            
	            // Fetch the number of authors in the library
	            String authorCountQuery = "SELECT COUNT(DISTINCT author) AS total_authors FROM books";
	            PreparedStatement authorCountStmt = conn.prepareStatement(authorCountQuery);
	            ResultSet authorCountRs = authorCountStmt.executeQuery();
	            int totalAuthors = 0;
	            if (authorCountRs.next()) {
	                totalAuthors = authorCountRs.getInt("total_authors");
	            }

	            // Set the data as request attributes to be displayed in the JSP
	            request.setAttribute("totalBooks", totalBooks);
	            request.setAttribute("totalAuthors", totalAuthors);
	            
	            // Forward the request to dashboard.jsp
	            request.getRequestDispatcher("Dashboard.jsp").forward(request, response);
	        } catch (Exception e) {
	            e.printStackTrace();
	            response.sendRedirect("error.jsp");
	        }
	    }
	}

