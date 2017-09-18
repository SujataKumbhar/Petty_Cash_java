<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
     <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt" %>
    
    
<style>
body { 
    background-image: url('img/teaWithRecipts.jpg');
    background-repeat: no-repeat;
    background-attachment: fixed;
    background-position: center; 
    background-size : cover;
}
</style>
    
    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link rel="stylesheet" href="css/w3.css">

<title>Show Yearly Details Page</title>
</head>
<body>
<center>
<header> <jsp:include page="../header.jsp"/> </header>

<h2 style="font-family:Harrington;font-size:40px;color:blue">Welcome ${uname}</h2>

<table border =2 class="w3-table-all w3-centered" style="width: 50%; margin: 2px; padding: 2px">
	<thead>
		<tr class="w3-green">

			
			<th>Date</th>
			<th>All Total</th>
			
	
			</tr>
			</thead>
	
	<tbody>
		
		<c:forEach var="daily" items="${ShowDetailsParticularYear}">
			<tr class="w3-hover-grey">

				<td><a href="daily?action=ShowDetailsParticularMonth&date1=${ daily.date1}"><fmt:formatDate value="${ daily.date1}" pattern="YYYY-MM"/></a></td>
				
			
				<td>${ daily.productTotal }</td>
				
			</tr>

		</c:forEach>
	</tbody>
	
	
	
</table>

</center>
</body>
</html>