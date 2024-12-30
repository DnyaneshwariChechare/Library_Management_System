<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 <main>
        <h2>Add New Book</h2>
        <form action="books" method="POST">
         <label for="Id">Book Id:</label>
            <input type="text" id="Id" name="Id" required />
            
            <input type="hidden" name="action" value="add">
            <br><br>
            <label for="title">Book Title:</label>
            <input type="text" id="title" name="title" required />
            <br><br>
            <label for="author">Author:</label>
            <input type="text" id="author" name="author" required />
            <br><br>
            <label for="Status">Status:</label>
            <input type="text" id="Status" name="Status" required />
            <br><br>
            <button type="submit">Add Book</button>
        </form>
</body>
</html>