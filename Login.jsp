<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Login Page</title>
<link rel="stylesheet" type="text/css" href="stylrforLogin.css">
</head>
<body>
	<div class="login-container">
		<h2>Login to Library Management System</h2>
		<form action="login" method="post">
			<div class="form-group">
				<label for="email">Email:</label> <input type="email" id="email"
					name="email" required>
			</div>
			<div class="form-group">
				<label for="password">Password:</label> <input type="password"
					id="password" name="password" required>
			</div>
			<div class="form-group">
				<button type="submit">Login</button>
				
			</div>
		</form>
		<p>
			Don't have an account? <a href="Registration.jsp">Register here</a>
		</p>
		<%
		String errorMessage = request.getParameter("error");
		if (errorMessage != null) {
		%>
		<p class="error-message"><%=errorMessage%></p>
		<%
		}
		%>
	</div>
</body>
</html>