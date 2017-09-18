<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<style>
body { 
    background-image: url('img/coffee.jpg');
    background-repeat: no-repeat;
    background-attachment: fixed;
    background-position: center; 
    background-size : cover;
}
</style>
    
<title>Update Product</title>
</head>
<body>
<center>
<header> <jsp:include page="../header.jsp"/> </header>

<h2 style="font-family:Harrington;font-size:40px;color:blue">Welcome ${uname}</h2>
<c:url value ="product" var="url"/>
		<form action="${url}" method="post">
		
		<table class="w3-table-all" style="margin-left:30px;width:600px">
		
			<tr>
				<td> Product Id </td> 
				<td><input type="text" name="productId" value ="${product.productId}" readonly="readonly"  class="w3-panel w3-border w3-round-xlarge w3-border-red w3-hover-border-green"></td>
			</tr>
			
			<tr>
				<td>Product Name </td> 
				<td> <input type="text" name="productName" value ="${product.productName}"  required class="w3-panel w3-border w3-round-xlarge w3-border-red w3-hover-border-green"></td>
			</tr>
			
		
			<tr>
			<td><input type="hidden" name="action" value="productupdate" ></td>
			<td><input type="submit" value="Update" class="w3-button w3-green w3-border w3-border-red w3-round-large" style="margin-left:50px"></td>
			</tr>

		</table>
		
		</form>
		
	<footer> <jsp:include page="../footer.jsp"/> </footer>
</center>
</body>
</html>