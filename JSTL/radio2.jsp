<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<sql:setDataSource var="snapshot" driver="com.mysql.jdbc.Driver" 
url="jdbc:mysql://localhost:3306/zedcoder" user="root"  password=""/>
</head>
<body>
<sql:query dataSource="${snapshot}" var="result">
  SELECT fruits from my_table where fruits='Apple';
</sql:query>
Choose favorite fruit:
<c:forEach var="row" items="${result.rows}">
  	<input type="radio" name="frt" value="Apple" ${row.fruits == 'Apple' ? 'checked' : ''}>Apple
  	<input type="radio" name="frt" value="Banana" ${row.fruits == 'Banana' ? 'checked' : ''}>Banana
  	<input type="radio" name="frt" value="Cherry" ${row.fruits == 'Cherry' ? 'checked' : ''}>Cherry
</c:forEach>
<body>
</html>