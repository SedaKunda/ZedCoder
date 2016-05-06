<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create Account</title>
</head>
<body>
	<h1>Create Account</h1>
	<form method="post" action="/Wordpress/SendEmailServlet">
		<input type="text" id="fname" name="fname" placeholder="First Name" required><br><br>
		<input type="text" id="lname" name="lname" placeholder="Last Name" required><br><br>
		<input type="email" id="email" name="email" placeholder="Email Address" required><br><br>
		<button type="submit" name="register">Create Account</button>
	</form>
</body>
</html>
