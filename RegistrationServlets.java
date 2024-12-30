package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.connection.DBConnection;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class RegistrationServlets extends HttpServlet {
	 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        String name = request.getParameter("name");
	        String email = request.getParameter("email");
	        String password = request.getParameter("password");
	        
	        // Remove PrintWriter usage as it interferes with redirection
	        try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "root");
	            
	            // Prepare the SQL statement
	            String query = "INSERT INTO users (name, email, password) VALUES (?, ?, ?)";
	            PreparedStatement stmt = conn.prepareStatement(query);
	            stmt.setString(1, name);
	            stmt.setString(2, email);
	            stmt.setString(3, password);
	            
	            // Execute the statement
	            stmt.executeUpdate();
	            System.out.println("Data inserted successfully");

	            // Close the database connection and statement
	            stmt.close();
	            conn.close();

	            // Redirect to Login page after successful insertion
	            RequestDispatcher rd=request.getRequestDispatcher("/Login.jsp");
				rd.include(request, response);

	        } catch (Exception e) {
	            e.printStackTrace(); // Log the exception
	            // Optionally, you can redirect to an error page
	            response.sendRedirect("error.jsp");
	        }
	    }
	}