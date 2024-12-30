<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Dashboard - Library Management</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f4f4f4;
        }
        header {
            background-color: #333;
            color: white;
            padding: 20px;
            text-align: center;
        }
        header h1 {
            margin: 0;
        }
        main {
            padding: 20px;
        }
        .dashboard-container {
            display: flex;
            justify-content: space-around;
            flex-wrap: wrap;
            margin-top: 20px;
        }
        .card {
            background-color: #fff;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            padding: 20px;
            width: 200px;
            text-align: center;
            margin: 10px;
            font-size: 18px;
        }
        .card h3 {
            font-size: 24px;
            margin-bottom: 10px;
        }
        .card p {
            font-size: 16px;
        }
        .card a {
            display: inline-block;
            margin-top: 10px;
            padding: 10px 20px;
            background-color: #4CAF50;
            color: white;
            text-decoration: none;
            border-radius: 5px;
        }
        .card a:hover {
            background-color: #45a049;
        }
        .card .error {
            background-color: #f8d7da;
            color: #721c24;
            padding: 10px;
            margin-top: 20px;
        }
    </style>
</head>
<body>

    <header>
        <h1>Library Management System</h1>
    </header>
   <form action="Dashboard" method="post">
    <main>
        <div class="dashboard-container">
            <!-- Card for Total Books -->
            <div class="card">
                <h3>Total Books</h3>
                <p>${totalBooks}</p>
                <a href="book.jsp">View Books</a>
            </div>

            <!-- Card for Total Authors -->
            <div class="card">
                <h3>Total Authors</h3>
                <p>${totalAuthors}</p>
                <a href="AuthorsByBook.jsp">View Books by Author</a>
            </div>

            <!-- Card for Add New Book -->
            <div class="card">
                <h3>Add New Book</h3>
                <p>Quickly add a new book to the library.</p>
                <a href="addBook.jsp">Add Book</a>
            </div>
        </div>

        <!-- Error Message -->
        <c:if test="${not empty errorMessage}">
            <div class="error">
                ${errorMessage}
            </div>
        </c:if>
    </main>

</body>
</html>

