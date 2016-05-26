<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta http-equiv="cache-control" content="no-cache">
<title>User Login</title>
</head>
<body>
<%String regex ="(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,}";%>
	<h1>Create Account</h1>
		<form method="post" action="">
			First Name:<input type="text" name="fname"><br><br>
			Last Name: <input type="text" name="lname"><br><br>
			User Name: <input type="text" name="username" required><br><br>
			Password:  <input type="password" name="password" required><br><br>
			<button type="submit" name="submit">Create Account</button><br><br>
			<c:if test="${empty param.check}">
			<c:set var="password" value="${param.password}"></c:set>
			<%String password = (String) pageContext.getAttribute("password"); %>
			<%if (password.matches(regex)) {
				//Place code to insert to database here
				out.println("Password OK. Account created");%>
				<br><br>
				<button type="button">Go To Login</button>
			<%}
			else {
				out.println("Password must contain at least 8 characters, including UPPER/lowercase and numbers");
			}
			%>
			</c:if>
		</form>
</body>
</html>
