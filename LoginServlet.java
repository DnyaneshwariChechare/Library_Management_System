package com.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.connection.DBConnection;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        String email = request.getParameter("email");
	        String password = request.getParameter("password");

	        try {
        		Class.forName("com.mysql.cj.jdbc.Driver");
        		
        		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","root");
       {
	            String query = "SELECT * FROM users WHERE email = ? AND password = ?";
	            PreparedStatement stmt = conn.prepareStatement(query);
	            stmt.setString(1, email);
	            stmt.setString(2, password);
	            ResultSet rs = stmt.executeQuery();

	            if (rs.next()) {
	                HttpSession session = request.getSession();
	                session.setAttribute("userId", rs.getInt("id"));
	                session.setAttribute("userName", rs.getString("name"));
	                RequestDispatcher rd=request.getRequestDispatcher("/Dashboard.jsp");
					rd.include(request, response);

	            }
       
       else {
	                response.sendRedirect("Login.jsp?error=Invalid Credentials");
	            }
       }
	        }
       
       catch (Exception e) {
	            e.printStackTrace();
	            response.sendRedirect("error.jsp");
	        }
	    
	 }  
}
