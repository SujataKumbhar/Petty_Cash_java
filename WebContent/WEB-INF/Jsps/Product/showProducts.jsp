<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">


<style>
body { 
    background-image: url('img/ice.jpg');
    background-repeat: no-repeat;
    background-attachment: fixed;
    background-position: center; 
    background-size : cover;
}
</style>
    
<title>Show Products Page</title>
</head>
<body>
<center>
<header> <jsp:include page="../header.jsp"/> </header>
<h2 style="font-family:Harrington;font-size:40px;color:blue">Welcome ${uname}</h2>

<table border =2 class="w3-table-all w3-centered" style="width: 50%; margin: 2px; padding: 2px" >
	<thead>
		<tr class="w3-green">

			<th>Product Id</th>
			<th>Product Name</th>		
			<th>Edit</th>
			<th>Delete</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="product" items="${listOfProducts}">
			<tr class="w3-hover-grey">

				<td>${ product.productId }</td>
				<td>${ product.productName }</td>
			
		
				<c:if test="${uname ne null}">
				<td><a href ='<c:url value="product?action=productupdate&productId=${product.productId }"/>'> Update </a></td>
				<td><a href ='<c:url value="product?action=productdelete&productId=${product.productId }"/>'> Delete </a></td>
				</c:if> 
				
				
				</tr>
			</c:forEach>	
	</tbody>
	</table>


</center>
</body>
</html>