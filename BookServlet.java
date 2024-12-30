package com.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.connection.DBConnection;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/books")
public class BookServlet extends HttpServlet {
	  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        String action = request.getParameter("action");

	        try {
        		Class.forName("com.mysql.cj.jdbc.Driver");
        		
        		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","root");
	            if ("add".equals(action)) {
	                String title = request.getParameter("title");
	                String author = request.getParameter("author");
	                String query = "INSERT INTO books (title, author) VALUES (?, ?)";
	                PreparedStatement stmt = conn.prepareStatement(query);
	                stmt.setString(1, title);
	                stmt.setString(2, author);
	                stmt.executeUpdate();
	                System.out.println("Data inserted successfully");
	            } else if ("delete".equals(action)) {
	                int id = Integer.parseInt(request.getParameter("id"));
	                String query = "DELETE FROM books WHERE id = ?";
	                PreparedStatement stmt = conn.prepareStatement(query);
	                stmt.setInt(1, id);
	                stmt.executeUpdate();
	            }
	            System.out.println("Data deleted successfully");
	            
	        } catch (Exception e) {
	            e.printStackTrace();
	            response.sendRedirect("Delete.jsp");
	        }
	    
	}

}

