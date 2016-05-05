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
  SELECT fruits from my_table where is_round='yes';
</sql:query>
	<form action="" method="post">
	Choose a fruit:
                <select>
		        <c:forEach var="row" items="${result.rows}">
		        	<c:choose>
						 <c:when test="${row.fruits=='Apple'}">
						 	  <c:set var="a" value="Apple"></c:set>
						 </c:when>
						 <c:when test="${row.fruits=='Banana'}">
						 	  <c:set var="b" value="Banana"></c:set>
						 </c:when>
						 <c:when test="${row.fruits=='Cherry'}">
						 	  <c:set var="c" value="Cherry"></c:set>
						 </c:when>
					 </c:choose> 
		        </c:forEach>	
		        		<option value="">-- choose an option --</option>	  	
                        <option value="${row.fruits}" ${a == 'Apple' ? 'selected' : ''}>Apple</option>
                        <option value="${row.fruits}" ${b == 'Banana' ? 'selected' : ''}>Banana</option>
                        <option value="${row.fruits}" ${c == 'Cherry' ? 'selected' : ''}>Cherry</option>
                
                </select>
	</form>
</body>
</html>
