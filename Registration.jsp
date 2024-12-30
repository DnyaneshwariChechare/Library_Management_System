<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Register page</title>
 <link rel="stylesheet" type="text/css" href="styleforregistration.css">

</head>
<body>
<h1>Register Here</h1>
 <div class="registration-container">
        <h2>Register for Library Management System</h2>
        <form action="register" method="post">
            <div class="form-group">
                <label for="name">Name:</label>
                <input type="text" id="name" name="name" required>
            </div><br><br>
            <div class="form-group">
                <label for="email">Email:</label>
                <input type="email" id="email" name="email" required>
            </div>
            <br><br>
            <div class="form-group">
                <label for="password">Password:</label>
                <input type="password" id="password" name="password" required>
            </div>
            <br><br>
            <div class="form-group">
                <label for="confirmPassword">Confirm Password:</label>
                <input type="password" id="confirmPassword" name="confirmPassword" required>
            </div>
            <br><br>
            <div class="form-group">
                <button type="submit">Register</button>
            </div>
            
            <p>Already have an account? <a href="Login.jsp">Login here</a></p>
</body>
</html>