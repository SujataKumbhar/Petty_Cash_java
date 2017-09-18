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
    
    
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link rel="stylesheet" href="css/w3.css">

<title>Show Details Particular Date</title>
</head>
<body>
<center>
<header> <jsp:include page="../header.jsp"/> </header>

<h2 style="font-family:Harrington;font-size:40px;color:blue">Welcome ${uname}</h2>


<table border =2 class="w3-table-all w3-centered" style="width: 50%; margin: 2px; padding: 2px">
	<thead>
		<tr class="w3-green">

			<th>Id</th>
			<th>Date</th>
			<th>Product Name</th>
			<th>Product Price</th>
			<th>Product Quantity</th>
			<th>Product Total</th>
			<th>Edit</th>
			<th>Delete</th>
	
			</tr>
	</thead>
	
		<tbody>
		
		<c:forEach var="daily" items="${ShowDetailsParticularDate}">
			<tr class="w3-hover-grey">

				<td>${ daily.did }</td>
				<td><fmt:formatDate value="${daily.date1}"  dateStyle="medium"/></td>
				<td>${ daily.dailyProduct.productName}</td>
				<td>${ daily.productPrice }</td>
				<td>${ daily.productQuantity }</td>
				<td>${ daily.productTotal }</td>
				
				<c:if test="${uname ne null }">
				<td><a href='<c:url value="daily?action=update&did=${daily.did}"/>'>Update</a></td>
				<td><a href='<c:url value="daily?action=delete&did=${daily.did}"/>'>Delete</a></td>
				</c:if>
				
			</tr>

		</c:forEach>
	</tbody>
	</table>
	
	</center>

</body>
</html>