<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>rr
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Library Management System - Home</title>
    <style>
        body {
             font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-image: url('D:\library management\home page.jpeg'); /* Path to your background image */
            background-size: cover; /* Makes sure the image covers the entire background */
            background-position: center; /* Centers the image */
            background-attachment: fixed; /* Keeps the background fixed during scroll */
            color: #333;
        }
        header {{
            background-color: rgba(0, 7 7, 153, 0.8);
            color: #fff;
            padding: 20px;
            text-align: center;
        }
        nav {
            text-align: center;
            margin: 20px 0;
        }
        nav a {
            text-decoration: none;
            margin: 0 15px;
            padding: 10px 20px;
            background-color:rgba(0, 51, 102, 0.8);
            color: #fff;
            border-radius: 5px;
        }
        nav a:hover {
            background-color:rgba(0, 34, 68, 0.8);
        }
        main {
           text-align: center;
            padding: 20px;
            background-color: rgba(255, 255, 255, 0.8); /* Semi-transparent main content */
            margin: 20px auto;
            width: 80%;
            border-radius: 10px;
        }
        footer {
            text-align: center;
            padding: 10px;
            background-color: rgba(0, 77, 153, 0.8);
            color: #fff;
            position: fixed;
            width: 100%;
            bottom: 0;
        }
        .message {
            margin: 20px;
            font-size: 18px;
            color: green;
        }
    </style>
</head>
<body>
    <header>
        <h1>Library Management System</h1>
    </header>
    <nav>
        <a href="Login.jsp">Login</a>
        <a href="Registration.jsp">Register</a>
        <a href="Logout.jsp">Logout</a>
    </nav>
    <main>
        <h2>Welcome to the Library Management System</h2>
        <p>Please choose an option from above to proceed.</p>
        <% 
            String message = (String) session.getAttribute("message");
            if (message != null) { 
        %>
            <div class="message"><%= message %></div>
        <% 
                session.removeAttribute("message");
            } 
        %>
    </main>
    <footer>
        <p>&copy; 2024 Library Management System. All Rights Reserved.</p>
    </footer>
</body>
</html>
