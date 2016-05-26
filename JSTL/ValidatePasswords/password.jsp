<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta http-equiv="cache-control" content="no-cache">
<title>User Login</title>
</head>
<body>
	<h1>Create Account</h1>
		<form method="POST" action="..." onsubmit="return checkForm(this);">
			First Name:<input type="text" name="fname"><br><br>
			Last Name: <input type="text" name="lname"><br><br>
			User Name: <input type="text" name="username" required><br><br>
			Password: &nbsp; <input title="Password must contain at least 8 characters, including UPPER/lowercase and numbers" 
						type="password" required pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" name="password"><br><br>
			<button type="submit" name="submit">Create Account</button><br><br>
		</form>
</body>
</html>
