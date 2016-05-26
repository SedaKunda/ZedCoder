<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta http-equiv="cache-control" content="no-cache">
<title>User Login</title>
</head>
<body>
	<h1>Create Account</h1>
		<form method="post" action="">
			First Name:<input type="text" name="fname"><br><br>
			Last Name: <input type="text" name="lname"><br><br>
			User Name: <input type="text" name="username" required><br><br>
			Password:  <input type="password" name="password" required><br><br>
			<button type="submit" name="submit">Create Account</button><br><br>
			<c:if test="${empty param.check}">
			 <c:choose>
				 <c:when test="${fn:length(param.password)<8}">
				 	Password must contain at least 8 characters, including UPPER/lowercase and numbers
				 </c:when>
				 <c:otherwise>
				 	<c:choose>
					 	<c:when test="${(param.password).matches('[A-Za-z]+[0-9]+|[0-9]+[A-Za-z]+')}">
					 		<%--Place code to insert to database here --%>
						    Password OK. Account created<br><br>
					 		<button type="button">Go To Login</button>
						</c:when>
						<c:otherwise>
					 		Password must contain at least 8 characters, including UPPER/lowercase and numbers
						</c:otherwise>
					</c:choose>				 	
				 </c:otherwise>
			 </c:choose>	
			</c:if>
		</form>
</body>
</html>
