package com.servlets;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/returnBook")
public class ReturnBook extends HttpServlet{
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String bookId = request.getParameter("bookId");

        // Dummy database logic (replace with real database interaction)
        boolean isBookReturned = true; // Assume the book is returned successfully

        if (isBookReturned) {
            response.sendRedirect("Return.jsp?success=return&bookId=" + bookId);
        } else {
            response.sendRedirect("Return.jsp?error=return");
        }
    }
}

