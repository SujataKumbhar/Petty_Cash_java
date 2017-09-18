<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link rel="stylesheet" href="css/w3.css">

<style>
body { 
    background-image: url('img/receipts.jpg');
    background-repeat: no-repeat;
    background-attachment: fixed;
    background-position: center; 
    background-size : cover;
}
</style>


<title>Update Daily Page</title>
</head>
<body >
<center>
<header> <jsp:include page="../header.jsp"/> </header>
<h2 style="font-family:Harrington;font-size:40px;color:blue">Welcome ${uname}</h2>
<c:url value ="daily" var="url"/>
<form action ="${url}" method ="post">

<table class="w3-table-all"   style="margin-left:30px;width:600px">
	
 	<tr>
 		<td>Id </td>
 		<td><input type="text" name="did" value="${daily.did }" readonly="readonly" class="w3-panel w3-border w3-round-xlarge w3-border-red w3-hover-border-green"></td>
 	</tr>
 	
 	 	<tr>
 		<td>Product Name </td>
 		<td>
 		<select name="pname">
		<c:forEach items="${ listOfProducts}" var="p">
				<option value="${ p.productName}">${p.productName}</option>
				</c:forEach>
				</select>
		</td>
 	</tr>
 	
 	<%-- <tr>
 		<td>Product Name<input type="text" name="productName" value="${daily.dailyProduct.productName }"></td>
 	</tr> --%>
 	
 	
 	<tr>
 		<td>Price</td><td> <input type="text" required class="w3-panel w3-border w3-round-xlarge w3-border-red w3-hover-border-green" name="productPrice" value="${daily.productPrice }"></td>
 	</tr>
 	
 	<tr>
 		<td>Quantity</td><td> <input type="text" required class="w3-panel w3-border w3-round-xlarge w3-border-red w3-hover-border-green" name="productQuantity" value="${daily.productQuantity }"></td>
 	</tr>
 	
 		<tr>
		<td><input type="hidden" name="action" value="update"></td>
		<td><input type="submit" value="Update"  class="w3-button w3-green w3-border w3-border-red w3-round-large" style="margin-left:50px"></td>
		</tr>
</table>
</form>

<footer> <jsp:include page="../footer.jsp"/> </footer>

</center>
</body>
</html>