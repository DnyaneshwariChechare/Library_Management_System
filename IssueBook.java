package com.servlets;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/issueBook")
public class IssueBook extends HttpServlet{
	  protected void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        String bookId = request.getParameter("bookId");
	        String userId = request.getParameter("userId");

	        // Dummy database logic (replace with real database interaction)
	        boolean isBookIssued = true; // Assume the book is issued successfully

	        if (isBookIssued) {
	            response.sendRedirect("Issue.jsp?success=issue&bookId=" + bookId);
	        } else {
	            response.sendRedirect("Issue.jsp?error=issue");
	        }
	    }
	}

